# CS 1105 Unit 7: Assembler Language and Program Translation

Learning notes by Nicanor Maswili. Due dates: discussion post Sunday Oct 18 (final Oct 21), peer
replies Wednesday Oct 21, assignment Oct 21, 2026.

## Learning Outcomes

1. Develop high-level data structures using assembly language to solve programming problems.
2. Identify differing coding practices and design principles in Python and Java.
3. Explain program translation among languages and the semantic differences it exposes.

## Key Ideas

### Assembly language and assemblers

- Assembly is a low-level language with roughly one statement per machine instruction. It is
  specific to one processor family (x86, ARM, MIPS each have their own).
- An **assembler** turns mnemonics (mov, add, cmp) into machine code. A **linker** turns the
  object file into a runnable program.
- **One-pass vs multi-pass assemblers:** a one-pass assembler reads the source once, so it cannot
  know the address of a label that appears later (a forward reference) unless it patches it
  afterwards. A two-pass assembler collects all label addresses in pass 1 and generates code in
  pass 2.
- Still used for: device drivers, interrupt handlers, boot code, OS kernels, real-time and
  embedded systems, and processor-specific instructions (CodeDocs "Assembly language").
- Kann (2.5): designing an assembly language has 3 concerns: moving data between memory and CPU
  registers, ALU operations, and program control (branches).

### Building data structures in assembly

| Structure | How it is built in assembly |
|---|---|
| Variable | A labelled memory location (db, dw, dd in .data; resb, resd in .bss) |
| Array | A block of memory; element i is at base + i * size, e.g. [array + ebx] |
| Stack | An array plus a top index; push = store then increment, pop = decrement then load |
| Queue | An array used as a ring buffer with head and tail indexes that wrap around |
| Linked list | Nodes in memory, each holding data plus the address (pointer) of the next node |

**Linked list in assembly (answer to reading question 2).** Each node is a small block of memory,
for example 4 bytes of data and 4 bytes holding the address of the next node, with 0 meaning
"end of list". Walking the list means loading the next pointer into a register and looping until
it is 0:

```
; node layout: [node] = value (dd), [node + 4] = address of next node (dd)
SECTION .data
node3   dd  30, 0           ; last node: next = 0
node2   dd  20, node3
node1   dd  10, node2
head    dd  node1

SECTION .text
sum_list:                   ; returns the sum of all values in EAX
    xor     eax, eax
    mov     ebx, [head]     ; EBX = pointer to the current node
.next:
    test    ebx, ebx        ; null pointer = end of list
    jz      .done
    add     eax, [ebx]      ; add this node's value
    mov     ebx, [ebx + 4]  ; follow the pointer to the next node
    jmp     .next
.done:
    ret
```

Inserting at the front means: write the old head address into the new node's next field, then
store the new node's address in head. That is why the quiz answer for "how is a linked list
implemented in assembly" is **using pointers**.

### Program translation

- A **compiler** translates a whole high-level program into a lower-level one (assembly or machine
  code). A program that translates between two high-level languages is a **source-to-source
  compiler** or **transcompiler**. One that goes from low level back to high level is a
  **decompiler**.
- **Syntax** = the structure of statements (grammar). **Semantics** = their meaning.
- Phases of a compiler (Bhumika, 2022; Neso Academy video):

| Phase | Input to output | Checks or does |
|---|---|---|
| Lexical analysis | characters to tokens | groups characters into lexemes such as keywords and numbers |
| Syntax analysis | tokens to parse tree | is the grammar correct? reports syntax errors |
| Semantic analysis | parse tree to annotated tree | types, declared identifiers, meaning |
| Intermediate code generation | tree to intermediate code | machine-independent form |
| Code optimization (optional) | intermediate to better intermediate | faster, smaller code |
| Code generation | intermediate code to target code | assembly or machine code for the target CPU |

## Reading Questions

1. **Why build high-level data structures in assembly?** You control exactly where every byte
   lives and how many instructions each operation takes, so the code is small, fast, and
   predictable. That matters in drivers, interrupt handlers, embedded systems, and boot code. The
   cost is that the code is longer, harder to read, and works on only one processor family.
2. **Linked list in assembly:** see the code above. Nodes hold a value plus a pointer, and the
   traversal follows pointers until it reaches 0.
3. **What is program translation and why does it matter?** It is converting a program from one
   language into another, from source to machine code (compiling, assembling) or between high-level
   languages (porting). It lets humans write in readable languages while machines run binary, and it
   lets old software move to new platforms and languages.
4. **Key steps to translate code between languages:**
   1. Capture the current behavior with tests.
   2. Map structures (modules to classes, lists to ArrayList, and so on).
   3. Translate the syntax.
   4. Resolve semantic differences (division, overflow, typing, equality).
   5. Re-run the same tests until every output matches.

## This Week's Work

- **Assignment:** a stack in 32-bit x86 NASM assembly (Assignment/src/stackapp.asm). It reverses
  strings, tests palindromes, and checks balanced brackets with precise error messages. It was
  verified on 5,014 strings against a Python reference (verify_stackapp.py).
- **Discussion:** translating Python to Java. Semantic differences I verified by running both:

| Expression | Python 3.14 | Java 21 |
|---|---|---|
| -7 // 2 and -7 / 2 | -4 (floor) | -3 (toward zero) |
| -7 % 2 | 1 | -1 |
| 2**31 and Integer.MAX_VALUE + 1 | 2147483648 | -2147483648 (wraps silently) |
| round(2.5) and Math.round(2.5) | 2 (round half to even) | 3 |
| string == | compares values | compares references (use equals) |

## Self-Quiz Unit 7

| Q | Answer | Why |
|---|---|---|
| 1 | The structure of program statements | Syntax is structure; semantics is meaning |
| 2 | Code optimization | Of the options given, the one translation aims for: compilers produce optimized target code |
| 3 | Stack | Stack = Last-In-First-Out |
| 4 | Code generation | The final phase maps intermediate code to assembly or machine code |
| 5 | Efficient memory management | Building structures in assembly is about controlling memory directly |
| 6 | Incompatible data types | A semantic (meaning) problem, e.g. Python int vs Java int |
| 7 | Syntax analysis | The parser reports errors in the source's structure |
| 8 | When porting software across platforms | Moving software to a new platform or language needs translation |
| 9 | Differences in the meaning of program statements | Semantics = meaning |
| 10 | Using pointers | Each node stores the address of the next node |
