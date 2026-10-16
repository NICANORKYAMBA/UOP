; ---------------------------------------------------------------------------
; stackapp.asm
; CS 1105 Unit 7: a stack data structure written in x86 assembly language
; Author: Nicanor Maswili
;
; The program builds its own stack (separate from the CPU's call stack) and
; uses it to solve three problems on each input string:
;   1. reverse the string
;   2. test whether the string is a palindrome
;   3. check that the brackets ( ) [ ] { } are balanced
;
; Target: NASM, 32-bit x86, Linux system calls (int 80h), as in asmtutor.com
; Build:  nasm -f elf stackapp.asm
;         ld -m elf_i386 stackapp.o -o stackapp
; Run:    ./stackapp                    runs the built-in test strings
;         ./stackapp "text" "(a[b])"    checks your own strings
; ---------------------------------------------------------------------------

STACK_MAX   equ 64              ; capacity of the stack, in bytes
SYS_EXIT    equ 1
SYS_WRITE   equ 4
STDOUT      equ 1

SECTION .data
title       db  '=== Stack in assembly: reversal, palindromes, brackets ===', 0Ah, 0Ah, 0
lbl_input   db  'Input      : "', 0
lbl_rev     db  'Reversed   : ', 0
lbl_pal     db  'Palindrome : ', 0
lbl_brk     db  'Brackets   : ', 0
open_quote  db  '"', 0
quote_nl    db  '"', 0Ah, 0
newline     db  0Ah, 0
msg_yes     db  'yes', 0Ah, 0
msg_no      db  'no', 0Ah, 0
msg_rev_ovf db  'error: stack overflow, the string is longer than 64 characters', 0Ah, 0
msg_skip    db  'skipped, the string could not be reversed', 0Ah, 0
msg_ok      db  'balanced', 0Ah, 0
msg_bad     db  'NOT balanced: ', 0
msg_at      db  ' at position ', 0
msg_noopen  db  ' has no opening bracket', 0Ah, 0
msg_nomatch db  ' does not match ', 0
msg_open    db  ' bracket(s) never closed', 0Ah, 0
msg_brk_ovf db  'error: stack overflow, more than 64 open brackets', 0Ah, 0
quoted      db  "'x'", 0           ; template used by print_quoted

; Built-in test strings, stored as a zero-terminated table of pointers.
tests       dd  t1, t2, t3, t4, t5, t6, t7, t8, 0
t1          db  'Assembly', 0
t2          db  'racecar', 0
t3          db  '(a + b) * [c - d]', 0
t4          db  '{[()()]}', 0
t5          db  '([)]', 0
t6          db  '((x)', 0
t7          db  'x)(', 0
t8          times 70 db '('
            db  0

SECTION .bss
stack_data  resb STACK_MAX      ; storage for the stack's items
stack_top   resd 1              ; number of items = index of the next free slot
outbuf      resb STACK_MAX + 1  ; reversed copy of the input
numbuf      resb 12             ; digits of a number being printed

SECTION .text
global _start

; ===========================================================================
; Stack operations. The status of push and pop is returned in the carry flag
; (CF = 0 success, CF = 1 error), so callers test it with jc / jnc.
; ===========================================================================

; stack_init: make the stack empty.
stack_init:
    mov     dword [stack_top], 0
    ret

; stack_push: push the byte in AL.
; Out: CF = 1 if the stack is full (overflow), otherwise CF = 0.
stack_push:
    push    ebx
    mov     ebx, [stack_top]
    cmp     ebx, STACK_MAX          ; is there room for one more item?
    jae     .full
    mov     [stack_data + ebx], al  ; store the item in the next free slot
    inc     ebx
    mov     [stack_top], ebx
    clc                             ; CF = 0: success
    pop     ebx
    ret
.full:
    stc                             ; CF = 1: overflow
    pop     ebx
    ret

; stack_pop: remove the top byte and return it in AL (AH is not changed).
; Out: CF = 1 if the stack is empty (underflow), otherwise CF = 0.
stack_pop:
    push    ebx
    mov     ebx, [stack_top]
    test    ebx, ebx                ; empty? (test also clears CF)
    jz      .empty
    dec     ebx
    mov     al, [stack_data + ebx]  ; read the most recent item
    mov     [stack_top], ebx
    clc
    pop     ebx
    ret
.empty:
    stc                             ; CF = 1: underflow
    pop     ebx
    ret

; stack_size: return the number of items in EAX.
stack_size:
    mov     eax, [stack_top]
    ret

; ===========================================================================
; Problem solvers that use the stack
; ===========================================================================

; reverse: copy the zero-terminated string at ESI into outbuf, reversed.
; Every character is pushed, then popped, so the last one in comes out first.
; Out: CF = 1 on overflow (string too long), otherwise CF = 0.
reverse:
    pushad
    call    stack_init
.push_loop:
    mov     al, [esi]
    test    al, al                  ; end of string?
    jz      .pop_phase
    call    stack_push
    jc      .done                   ; overflow: return with CF = 1
    inc     esi
    jmp     .push_loop
.pop_phase:
    mov     edi, outbuf
.pop_loop:
    call    stack_pop
    jc      .finish                 ; stack empty: every character is copied
    mov     [edi], al
    inc     edi
    jmp     .pop_loop
.finish:
    mov     byte [edi], 0
    clc
.done:
    popad                           ; popad does not change the flags
    ret

; is_palindrome: compare the string at ESI with outbuf (its reverse).
; Out: ZF = 1 if they are equal, so the string reads the same both ways.
is_palindrome:
    pushad
    mov     edi, outbuf
.compare:
    mov     al, [esi]
    cmp     al, [edi]
    jne     .done                   ; ZF = 0: different
    test    al, al                  ; both ended together: ZF = 1
    jz      .done
    inc     esi
    inc     edi
    jmp     .compare
.done:
    popad
    ret

; check_brackets: check that ( ) [ ] { } in the string at ESI are balanced.
; Opening brackets are pushed. A closing bracket must match the bracket
; popped from the top. Any other character is ignored.
; Out: EAX = 0 balanced
;          = 1 closing bracket with no opening bracket  (ECX = position, DL = char)
;          = 2 closing bracket of the wrong kind        (ECX = position, DL = char,
;                                                        DH = opening bracket found)
;          = 3 opening brackets never closed            (ECX = how many)
;          = 4 stack overflow
check_brackets:
    push    esi
    call    stack_init
    xor     ecx, ecx                ; ECX = position of the current character
.next:
    mov     al, [esi]
    test    al, al
    jz      .end_of_text
    inc     ecx
    inc     esi
    cmp     al, '('
    je      .open
    cmp     al, '['
    je      .open
    cmp     al, '{'
    je      .open
    mov     ah, '('                 ; AH = the opening bracket this one needs
    cmp     al, ')'
    je      .close
    mov     ah, '['
    cmp     al, ']'
    je      .close
    mov     ah, '{'
    cmp     al, '}'
    je      .close
    jmp     .next                   ; not a bracket
.open:
    call    stack_push
    jc      .overflow
    jmp     .next
.close:
    mov     dl, al                  ; remember the closing bracket
    call    stack_pop               ; AL = most recent opening bracket
    jc      .no_opener
    cmp     al, ah
    jne     .mismatch
    jmp     .next
.end_of_text:
    call    stack_size              ; anything left open?
    mov     ecx, eax
    test    ecx, ecx
    jnz     .unclosed
    xor     eax, eax                ; 0 = balanced
    jmp     .return
.no_opener:
    mov     eax, 1
    jmp     .return
.mismatch:
    mov     dh, al
    mov     eax, 2
    jmp     .return
.unclosed:
    mov     eax, 3
    jmp     .return
.overflow:
    mov     eax, 4
.return:
    pop     esi
    ret

; ===========================================================================
; Output helpers (all registers are preserved)
; ===========================================================================

; print_str: write the zero-terminated string at EAX to the screen.
print_str:
    pushad
    mov     ecx, eax                ; ECX = address of the text
    xor     edx, edx                ; EDX = length, counted below
.count:
    cmp     byte [ecx + edx], 0
    je      .write
    inc     edx
    jmp     .count
.write:
    mov     ebx, STDOUT
    mov     eax, SYS_WRITE
    int     80h
    popad
    ret

; print_quoted: write the character in AL inside single quotes, e.g. '('.
print_quoted:
    pushad
    mov     [quoted + 1], al        ; fill the middle of the  'x'  template
    mov     eax, quoted
    call    print_str
    popad
    ret

; print_uint: write the unsigned number in EAX in decimal.
print_uint:
    pushad
    mov     edi, numbuf + 11
    mov     byte [edi], 0
    mov     ebx, 10
.digit:
    xor     edx, edx
    div     ebx                     ; EAX = EAX / 10, EDX = remainder
    add     dl, '0'
    dec     edi
    mov     [edi], dl
    test    eax, eax
    jnz     .digit
    mov     eax, edi
    call    print_str
    popad
    ret

; ===========================================================================
; process: run all three problems on the string at ESI and print the results.
; ===========================================================================
process:
    pushad
    mov     eax, lbl_input
    call    print_str
    mov     eax, esi
    call    print_str
    mov     eax, quote_nl
    call    print_str

    ; 1. reversal
    call    reverse
    jc      .reverse_failed
    mov     eax, lbl_rev
    call    print_str
    mov     eax, open_quote
    call    print_str
    mov     eax, outbuf
    call    print_str
    mov     eax, quote_nl
    call    print_str

    ; 2. palindrome, using the reversed copy
    mov     eax, lbl_pal
    call    print_str
    call    is_palindrome
    mov     eax, msg_yes
    je      .print_pal
    mov     eax, msg_no
.print_pal:
    call    print_str
    jmp     .brackets

.reverse_failed:
    mov     eax, lbl_rev
    call    print_str
    mov     eax, msg_rev_ovf
    call    print_str
    mov     eax, lbl_pal
    call    print_str
    mov     eax, msg_skip
    call    print_str

    ; 3. bracket check
.brackets:
    mov     eax, lbl_brk
    call    print_str
    call    check_brackets
    cmp     eax, 0
    je      .balanced
    cmp     eax, 1
    je      .no_opener
    cmp     eax, 2
    je      .mismatch
    cmp     eax, 3
    je      .unclosed
    mov     eax, msg_brk_ovf
    call    print_str
    jmp     .end

.balanced:
    mov     eax, msg_ok
    call    print_str
    jmp     .end

.no_opener:                         ; e.g.  ')' at position 2 has no opening bracket
    call    .bad_bracket_at
    mov     eax, msg_noopen
    call    print_str
    jmp     .end

.mismatch:                          ; e.g.  ')' at position 3 does not match '['
    call    .bad_bracket_at
    mov     eax, msg_nomatch
    call    print_str
    mov     al, dh
    call    print_quoted
    mov     eax, newline
    call    print_str
    jmp     .end

.unclosed:                          ; e.g.  1 bracket(s) never closed
    mov     eax, msg_bad
    call    print_str
    mov     eax, ecx
    call    print_uint
    mov     eax, msg_open
    call    print_str
    jmp     .end

; shared by the two closing-bracket errors: "NOT balanced: 'c' at position n"
.bad_bracket_at:
    mov     eax, msg_bad
    call    print_str
    mov     al, dl
    call    print_quoted
    mov     eax, msg_at
    call    print_str
    mov     eax, ecx
    call    print_uint
    ret

.end:
    mov     eax, newline
    call    print_str
    popad
    ret

; ===========================================================================
; Program entry point
; ===========================================================================
_start:
    mov     eax, title
    call    print_str

    mov     ecx, [esp]              ; ECX = argc (number of arguments + 1)
    lea     ebx, [esp + 8]          ; EBX -> argv[1], the first user string
    dec     ecx
    jz      .run_tests              ; no arguments: use the built-in tests

.arg_loop:
    mov     esi, [ebx]
    call    process
    add     ebx, 4
    dec     ecx
    jnz     .arg_loop
    jmp     .exit

.run_tests:
    mov     ebx, tests
.test_loop:
    mov     esi, [ebx]
    test    esi, esi                ; a zero pointer ends the table
    jz      .exit
    call    process
    add     ebx, 4
    jmp     .test_loop

.exit:
    mov     ebx, 0                  ; exit code 0
    mov     eax, SYS_EXIT
    int     80h
