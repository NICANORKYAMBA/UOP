; lib.asm - defines print_msg and exports it with "global"
SECTION .data
msg     db  'Hello from print_msg', 0Ah
len     equ $ - msg             ; a constant symbol: assembler computes 21

SECTION .text
global  print_msg               ; make print_msg visible to other object files

print_msg:
    mov     edx, len
    mov     ecx, msg
    mov     ebx, 1              ; stdout
    mov     eax, 4              ; sys_write
    int     80h
    ret
