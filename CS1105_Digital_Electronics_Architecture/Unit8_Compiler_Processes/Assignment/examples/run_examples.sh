#!/bin/sh
# Rebuilds every symbol resolution example in this folder and prints what it shows.
# Needs: nasm, ld (binutils), gcc. Run from this folder:  sh run_examples.sh
set -u

echo "== 1. Symbol tables after assembling (nm): T = defined code, d = data, U = undefined"
nasm -f elf main.asm -o main.o
nasm -f elf lib.asm -o lib.o
nasm -f elf dup.asm -o dup.o
nm main.o; echo "--"; nm lib.o

echo; echo "== 2. Linking main.o alone: print_msg has no definition"
ld -m elf_i386 main.o -o alone 2>&1

echo; echo "== 3. Linking main.o with lib.o: every reference resolved"
ld -m elf_i386 main.o lib.o -o prog && ./prog; echo "exit code (counter) = $?"
nm -n prog | grep -v '__\|_e'

echo; echo "== 4. Machine code before linking (placeholders + relocations)"
objdump -d -r -M intel main.o | sed -n '/<_start>:/,$p'
echo; echo "== 5. Machine code after linking (real addresses)"
objdump -d -M intel prog | sed -n '/<_start>:/,/int /p'

echo; echo "== 6. Two global definitions of print_msg"
ld -m elf_i386 main.o lib.o dup.o -o bad 2>&1

echo; echo "== 7. Weak and strong definitions in C"
gcc -o weak_only show_limit.c config_default.c && ./weak_only
gcc -o weak_strong show_limit.c config_default.c config_user.c && ./weak_strong

rm -f *.o alone prog bad weak_only weak_strong
