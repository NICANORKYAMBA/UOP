# Symbol Resolution: How Names Become Wires, Addresses, and Instructions

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** October 28, 2026

## Introduction

Computers do not understand names. A circuit only has wires, a processor only has binary opcodes
and numeric addresses, and memory only has numbered locations. People, on the other hand, think
and write in names: a wire called bus, a variable called counter, a routine called print_msg.
Symbol resolution is the process that connects each name to the one physical thing it stands
for. This paper is written as a lesson for a beginning computer science class. It explains why
symbol resolution is essential in digital systems, microprocessors, and assembly programs,
summarizes its key principles, and shows it working in practice with examples that I built and
ran myself: a Logisim circuit, a two-file assembly program, and a small C program. Every output
shown below is real.

### What Symbol Resolution Means

**Symbol resolution is the process of matching every use of a name (a reference) to exactly one
meaning (a definition), and then replacing the name with the value, address, or connection that
the hardware actually uses.** It always answers the same two questions: which definition does this
name refer to, and what number or wire does that definition stand for? Table 1 gives the terms
used in the rest of this lesson.

**Table 1**

*Key Terms for Beginners*

| Term | Meaning | Example from this paper |
|---|---|---|
| Symbol | A name for a location, value, or signal | counter, print_msg, the wire label bus |
| Definition | The one place where a symbol is given its meaning | print_msg: in lib.asm |
| Reference | A place where a symbol is used | call print_msg in main.asm |
| Symbol table | The assembler's list of every symbol and its address | done = offset 0x0E |
| Linker | The program that joins object files and resolves names across them | ld |
| Relocation | Writing a symbol's final address into the machine code | call becomes E8 1B 00 00 00 |
| Net | A set of connected points in a circuit that carries one value | all tunnels labelled bus |

## Part 1: Why Symbol Resolution Is Essential

### In Digital Systems

In digital logic, the most basic symbols are the values on a wire: 0, 1, and in some circuits a
floating "nothing is driving this" value. Larger circuits also use names. Logisim's tunnel
component, for example, connects every point that carries the same label, so a signal can reach
a distant part of the circuit without a long wire (Burch, n.d.-b). The simulator must therefore
resolve two things whenever a value in the circuit changes: which points belong to the same named
net, and what single value that net carries when several components drive it. If two outputs place different values on
the same wire, the value cannot be resolved, and Logisim shows the wire in red with an error value
(Burch, n.d.-a). Correct resolution is what makes a wire
carry exactly one meaningful value.

### In Microprocessors

A microprocessor resolves symbols every time it runs an instruction. The bits of an instruction
are symbols that the processor's decoder must turn into one specific operation, and its operands
must be turned into specific registers or memory addresses. WatElectronics (2020) describes the
8085 microprocessor, whose architecture includes an instruction register and a decoder, together
with a 16-bit address bus that carries the address of every memory location it reads or writes.
If the operand's address were wrong, the processor would read the wrong data or jump to the wrong
instruction, and it has no way to notice. That is why all names must already be resolved to the
correct numbers before the program reaches the processor.

### In Assembly Programs

Assembly language lets programmers use symbolic instructions and names instead of raw binary
(Fernando, 2026). One of our readings calls labels the assembler's most important abstraction,
because they free the programmer from tracking where instructions and data end up in memory
(*Assembly and Linking*, n.d.). The price is that every label must later be turned
into the correct address. Programs are also built from several files, so a name used in one file
may be defined in another. Resolving those names is the linker's job: it takes all the object
files, finds the module or variable each reference means, and fixes the final memory addresses
(Bhargav, 2024). Without symbol resolution, a program built from many files could never become
one working executable. Figure 1 shows the whole path a symbol travels.

**Figure 1**

*The Life of a Symbol, From Source Code to the CPU*

[FIGURE figures/fig1_pipeline.png]

## Part 2: Key Principles of Symbol Resolution

**Table 2**

*Key Principles of Symbol Resolution*

| Principle | What it means | Where it applies |
|---|---|---|
| 1. A label names a location, not what is stored there | In LDR r1, =num, the label num means the address where 5 is stored, not 5 itself (Kann, 2021, Section 4.4) | Assembly, microprocessor |
| 2. Every reference needs exactly one definition | One definition: resolved. None: "undefined reference". Two global ones: "multiple definition" (Arun, 2016) | Linker |
| 3. A symbol table records every name | The assembler stores each label and its address in a symbol table, and passes it on so the linker can connect definitions and references (*Assembly and Linking*, n.d.) | Assembler, linker |
| 4. Two passes handle forward references | Pass 1 assigns an address to every label; pass 2 assembles the instructions using those addresses (*Assembly and Linking*, n.d.) | Assembler |
| 5. Scope decides who can see a symbol | Local labels are resolved inside one file; EXTERN declares a symbol defined in another module, and the defining module must export it with GLOBAL (NASM Development Team, n.d., Sections 8.5 and 8.7) | Assembler, linker |
| 6. Binding strength settles conflicts | A global definition silently overrides a weak one; two global definitions are a fatal error (Arun, 2016) | Linker |
| 7. Resolution and relocation go together | Once each symbol is matched, the linker patches the final addresses into the machine code (Bhargav, 2024) | Linker |
| 8. Errors must stop the build, not the running program | An unresolved or duplicated name is reported before the program ever runs, as Examples 3 and 4 show | Assembler, linker |
| 9. One value per net | A named wire must have one resolvable value; conflicting drivers produce an error value (Burch, n.d.-a) | Digital logic |

A few of these principles need more explanation.

**Symbol tables and two passes.** When the assembler meets an instruction such as jmp done, the
label done may not have been defined yet, because it appears further down the file. This is a
forward reference. The solution is to read the source twice. In the first pass the assembler
counts bytes with a program location counter and records every label's address in the symbol
table; in the second pass it assembles each instruction, now able to look up every label
(*Assembly and Linking*, n.d.). This is the same idea that separates single-pass from
multipass compilers: a multipass design runs over the program several times, and each pass works
with the results of the one before (Lithmee, 2018).

**Defined, undefined, and tentative symbols.** Arun (2016) explains that the link-editor sees
three kinds of symbols: defined, undefined, and tentative. Its task is to resolve the undefined
and tentative references by searching the symbol tables of all the input files. If it finds
exactly one definition, there is no ambiguity. If it finds more than one, it must choose using
rules: a global symbol beats a weak one, and two global symbols cause a fatal "multiple
definitions" error. Kanich (2020) walks through the same process of how a linker binds each
symbol reference to a definition.

**Resolution then relocation.** Finding the right definition is only half the job. The object
file contains placeholder addresses, because the final memory layout is not known until all files
are combined. After resolving each symbol, the linker computes its final address and writes it
into every instruction that uses it (Bhargav, 2024). Finally the loader places the program in
memory and starts the processor at the entry point (Bhargav, 2024).

## Part 3: Examples of Symbol Resolution in Practice

All examples are in the examples folder that accompanies this paper, and the script
run_examples.sh rebuilds them and prints every output shown here. They use NASM, GNU ld 2.47, GCC
16, and Logisim 2.7.1 on Linux.

### Example 1: Digital Logic, Two Drivers on One Named Wire

I built a Logisim circuit in which two inputs, A and B, each connect to a tunnel labelled bus, and
a third tunnel labelled bus feeds an output. No wire joins them directly; Logisim connects them
only because the labels match. I then ran the circuit from the command line for every input
combination.

**Table 3**

*How Logisim Resolved the Value of the Wire Named bus*

| A | B | Value of bus | Meaning |
|---|---|---|---|
| 0 | 0 | 0 | Both drivers agree |
| 0 | 1 | E | Conflict: the value cannot be resolved |
| 1 | 0 | E | Conflict: the value cannot be resolved |
| 1 | 1 | 1 | Both drivers agree |

**Figure 2**

*The Same Circuit When the Drivers Agree (Left) and When They Conflict (Right)*

[FIGURE figures/fig2_bus_resolution.png]

The label bus is resolved into one net, and the net's value is resolved from all its drivers. When
the values disagree, every part of the net turns red and the output shows E, exactly as the
Logisim documentation describes (Burch, n.d.-a). The lesson for students is that a wire, like a
variable name, may have only one source of truth.

### Example 2: The Assembler's Symbol Table and a Forward Reference

The program main.asm uses three kinds of names: a local label done that appears after the jump to
it, a variable counter, and print_msg, which is defined in a different file.

```
SECTION .data
counter dd  0                   ; the symbol counter names an address
SECTION .text
global  _start                  ; export _start for the linker
extern  print_msg               ; defined in another object file
_start:
    call    print_msg           ; external reference: resolved by the LINKER
    inc     dword [counter]     ; data reference: final address fixed by the linker
    jmp     done                ; forward reference: resolved by the ASSEMBLER
    nop
done:
    mov     ebx, [counter]      ; exit code = counter = 1
    mov     eax, 1              ; sys_exit
    int     80h
```

After assembling, the nm tool prints the symbol table of the object file:

```
$ nm main.o                     $ nm lib.o
00000000 d counter              00000015 a len
0000000e t done                 00000000 d msg
         U print_msg            00000000 T print_msg
00000000 T _start
```

Each line is one symbol. T means defined code that other files can see, t and d are local code
and data, a is an absolute constant (len = 0x15 = 21, the message length that the assembler
computed itself), and **U means undefined**: main.o uses print_msg but does not contain it. The
assembler has already resolved the forward reference: done is at offset 0x0E, so jmp done became
the two bytes EB 01, meaning "jump forward 1 byte" over the nop.

### Example 3: The Linker Resolves Names Across Files

**Without the definition.** Linking main.o on its own fails, because nothing defines print_msg:

```
$ ld -m elf_i386 main.o -o alone
main.asm:(.text+0x1): undefined reference to `print_msg'
```

**With the definition.** Adding lib.o, which exports print_msg with global, resolves every
reference, and the program runs:

```
$ ld -m elf_i386 main.o lib.o -o prog && ./prog
Hello from print_msg
$ echo $?
1
```

**Resolution followed by relocation.** Comparing the machine code before and after linking shows
the linker writing the resolved addresses into the instructions:

**Table 4**

*Machine Code Before and After Linking*

| Instruction | In main.o (before linking) | In prog (after linking) | Resolved by |
|---|---|---|---|
| jmp done | EB 01 | EB 01 | Assembler (pass 2) |
| call print_msg | E8 FC FF FF FF + relocation R_386_PC32 print_msg | E8 1B 00 00 00 | Linker |
| inc dword [counter] | FF 05 00 00 00 00 + relocation R_386_32 .data | FF 05 00 A0 04 08 | Linker |

The call instruction stores a distance, not an address. The linker placed print_msg at 0x08049020
and the instruction after the call starts at 0x08049005, so it computed 0x08049020 - 0x08049005 =
0x1B and wrote 1B 00 00 00 (little-endian) into the instruction. The variable counter was placed at
0x0804A000, which appears in the inc instruction as the bytes 00 A0 04 08. The local jump needed no
change at all, because the assembler had already resolved it. This is the "resolve, then
relocate" principle in action (Bhargav, 2024).

### Example 4: Conflicting Definitions and Weak Symbols

**Two global definitions.** A third file, dup.asm, also declares global print_msg. The linker
refuses to guess which one is meant:

```
$ ld -m elf_i386 main.o lib.o dup.o -o bad
dup.asm:(.text+0x0): multiple definition of `print_msg'; lib.asm:(.text+0x0): first defined here
```

**A weak default overridden by a strong definition.** In C, a variable can be marked weak to act
as a default. The file config_default.c defines a weak limit = 5, config_user.c defines a normal
(strong) limit = 10, and show_limit.c prints limit:

```
$ gcc -o weak_only   show_limit.c config_default.c               && ./weak_only
limit = 5
$ gcc -o weak_strong show_limit.c config_default.c config_user.c && ./weak_strong
limit = 10
```

nm lists the weak definition with the letter V and the strong one with D. With only the weak
definition, it is used. When a strong definition is also present, it silently wins, which is
exactly the rule that Arun (2016) describes. Libraries use this to provide default settings that a
program can override without editing the library.

### Example 5: From Resolved Symbol to the Processor

Once the program is loaded, the processor never sees the names again. To run call print_msg, it
fetches the byte E8 using the address in the program counter, and its decoder recognizes E8 as
"call with a 32-bit relative distance". It then reads the four bytes 1B 00 00 00, adds 0x1B to the
address of the next instruction, and continues at 0x08049020, which is exactly where print_msg
starts. Every step depends on symbol resolution having produced the right numbers: the decoder
resolves the opcode symbol into an operation, and the address bus carries the address that the
linker resolved (WatElectronics, 2020).

**Table 5**

*Summary: Which Part of the System Resolves Which Symbols*

| Stage | Symbols it resolves | Result if resolution fails |
|---|---|---|
| Digital circuit | Net labels and the driven values on each wire | Error value E on the wire (Example 1) |
| Assembler | Local labels and constants, using a symbol table and two passes | NASM: "symbol `nowhere' not defined" |
| Linker | Global and external symbols across all object files | "Undefined reference" or "multiple definition" (Examples 3 and 4) |
| Loader | The entry point (_start) and the program's place in memory | The program cannot start |
| Processor | Opcode bits to operations, operands to registers and addresses | Wrong operation or wrong memory access |

## Conclusion

Symbol resolution is the bridge between the names people use and the numbers hardware uses. In
digital logic it decides which points form one net and what single value that net carries. In
assembly programming the assembler's symbol table and two passes turn labels into offsets, and
the linker matches every reference to exactly one definition across all files, settles conflicts
by binding strength, and patches the final addresses into the machine code. The microprocessor
then executes those resolved numbers without ever seeing a name. The examples showed every case a
student is likely to meet: a resolved name, a forward reference, an undefined reference, a
multiple definition, a weak symbol overridden by a strong one, and a wire with conflicting
drivers. In each case, accurate resolution is what lets separately written pieces fit together into
one system that works correctly.

## References

Arun. (2016, July 1). *Symbol resolution during link-editing*. Binary Dodo.
https://binarydodo.wordpress.com/2016/07/01/symbol-resolution-during-link-editing/

*Assembly and linking*. (n.d.). Brainkart. https://www.brainkart.com/article/Assembly-and-Linking_11818/

Bhargav, N. (2024, March 18). *Compiler, linker, assembler, and loader*. Baeldung on Computer
Science. https://www.baeldung.com/cs/compiler-linker-assembler-loader

Burch, C. (n.d.-a). *Wire colors*. Logisim 2.7 user's guide.
https://cburch.com/logisim/docs/2.7/en/html/guide/bundles/colors.html

Burch, C. (n.d.-b). *Tunnel*. Logisim 2.7 library reference.
https://cburch.com/logisim/docs/2.7/en/html/libs/wiring/tunnel.html

Fernando, J. (2026, July 30). *A beginner's guide to assembly languages*. Investopedia.
https://www.investopedia.com/terms/a/assembly-language.asp

Kanich, C. (2020, September 1). *How do linkers resolve symbols? Systems programming CS lecture*
[Video]. YouTube. https://www.youtube.com/watch?v=6XVUIeAaROU

Kann, C. W. (2021). *Introduction to assembly language programming: From soup to nuts: ARM
edition*. Open Educational Resources, 8. Gettysburg College. https://cupola.gettysburg.edu/oer/8/

Lithmee. (2018, November 20). *What is the difference between single pass and multipass compiler*.
Pediaa. https://pediaa.com/what-is-the-difference-between-single-pass-and-multipass-compiler/

NASM Development Team. (n.d.). Chapter 8: Assembler directives. In *NASM: The Netwide Assembler*.
https://www.nasm.us/doc/nasmdoc8.html

WatElectronics. (2020, April 27). *Microprocessor: Architecture, types, examples and its
applications*. https://www.watelectronics.com/what-is-a-microprocessor-architecture-types-its-applications/
