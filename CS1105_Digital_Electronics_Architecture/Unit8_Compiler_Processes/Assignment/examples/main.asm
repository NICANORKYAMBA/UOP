; main.asm - uses a symbol (print_msg) that is defined in another file
; and a forward reference (done) that is defined later in this file.
SECTION .data
counter dd  0                   ; a variable: the symbol "counter" names an address

SECTION .text
global  _start                  ; export _start so the linker can find the entry point
extern  print_msg               ; promise: print_msg is defined in some other object file

_start:
    call    print_msg           ; external reference, resolved by the LINKER
    inc     dword [counter]     ; data reference, its final address is fixed by the linker
    jmp     done                ; forward reference, resolved by the ASSEMBLER (pass 2)
    nop
done:
    mov     ebx, [counter]      ; exit code = counter = 1
    mov     eax, 1              ; sys_exit
    int     80h
