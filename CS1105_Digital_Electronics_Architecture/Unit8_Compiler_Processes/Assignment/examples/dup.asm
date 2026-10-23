; dup.asm - a SECOND global definition of print_msg (to show a conflict)
SECTION .text
global  print_msg
print_msg:
    ret
