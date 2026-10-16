# Building a Stack in x86 Assembly to Reverse Strings and Check Balanced Brackets

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** October 21, 2026

## Introduction

A stack is one of the simplest high-level data structures: items are added and removed only at
the top, so the last item in is the first item out (LIFO). In a language like Java or Python a
stack is one line of code, but the processor has no "stack object". It only has registers,
memory addresses, and instructions. For this assignment I built a stack by hand in x86 assembly
language and used it to solve three classic problems: reversing a string, testing whether a string
is a palindrome, and checking that the brackets ( ), [ ], and { } in a line of text are balanced.
The program was written for NASM, the assembler used in the asmtutor.com tutorials from this
unit's readings, and runs as a 32-bit Linux program (*NASM Assembly Language Tutorials*, n.d.).

This paper covers the three parts of the assignment in order. The first part shows the program and
the data structure. The second part explains the design and development process and what it
taught me about low-level programming. The third part summarizes the benefits of assembly language
for building data structures like this one, with real-world examples.

## Part 1: The Stack Data Structure and the Program

### What the Program Does

The program is one source file, stackapp.asm (the full listing is in the Appendix). Run with no
arguments, it processes eight built-in test strings. Run with arguments, for example
./stackapp "(a[b])" "level", it processes the strings the user typed. For every string it
prints the reversed string, whether the string is a palindrome, and whether its brackets are
balanced. If they are not, it says exactly what went wrong and where.

**Table 1**

*Routines in stackapp.asm*

| Group | Routine | Job |
|---|---|---|
| Stack | stack_init | Empty the stack (set stack_top to 0) |
| Stack | stack_push | Push the byte in AL; carry flag set on overflow |
| Stack | stack_pop | Pop the top byte into AL; carry flag set on underflow |
| Stack | stack_size | Return the number of items in EAX |
| Problems | reverse | Push every character, then pop them all into outbuf |
| Problems | is_palindrome | Compare the string with its reversed copy |
| Problems | check_brackets | Push opening brackets, match each closing bracket with a pop |
| Output | print_str, print_quoted, print_uint | Write text, a quoted character, or a number using the Linux write system call |
| Control | process, _start | Run the three problems on each string and print the results |

### How the Stack Is Stored in Memory

The stack is two variables in the .bss section, the part of memory that holds uninitialized data
(Figure 1). stack_data is a block of 64 bytes that holds the items, and stack_top is a 32-bit
counter. stack_top does two jobs at once: it is the number of items on the stack, and it is also
the index of the next free slot. That one choice keeps every operation short. A push writes to
stack_data[stack_top] and then adds 1, and a pop subtracts 1 and then reads
stack_data[stack_top]. In x86 this is a single instruction with base plus index addressing:
mov [stack_data + ebx], al.

**Figure 1**

*Memory Layout of the Stack After Reading "{[("*

[FIGURE figures/fig1_stack_memory.png]

### The Stack Operations

Each operation is a small subroutine called with call and left with ret. The table below gives
the interface of each, because in assembly there are no parameter lists, so the "contract" has to
be written down.

**Table 2**

*Interface of the Stack Operations*

| Operation | Input | Output | Error handling |
|---|---|---|---|
| stack_init | none | stack_top = 0 | none needed |
| stack_push | AL = item | item stored, stack_top + 1 | CF = 1 if 64 items already (overflow) |
| stack_pop | none | AL = top item, stack_top - 1 | CF = 1 if the stack is empty (underflow) |
| stack_size | none | EAX = number of items | none needed |

The heart of the data structure is these two routines:

```
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

stack_pop:
    push    ebx
    mov     ebx, [stack_top]
    test    ebx, ebx                ; empty?
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
```

Both routines report success or failure in the carry flag (CF), a single bit in the processor's
flags register. The caller tests it with one jump instruction (jc for "jump if carry"), so error
checking costs almost nothing. Both routines also save and restore EBX, so a caller never loses a
value it was keeping in a register.

### How the Stack Solves the Three Problems

**String reversal.** reverse pushes every character of the string and then pops until the stack is
empty, writing each popped character into an output buffer. Because the last character pushed is
the first one popped, the characters come out in reverse order. "Assembly" becomes "ylbmessA".

**Palindrome test.** is_palindrome reuses the reversed copy. It compares the original string and
the reversed string byte by byte. If they match all the way to the zero byte that ends both
strings, the string reads the same in both directions, as "racecar" and "level" do.

**Balanced brackets.** This is the problem where a stack is really needed, because brackets nest
and the most recently opened bracket must be the first one closed (Figure 2). check_brackets reads
the string one character at a time. An opening bracket is pushed. For a closing bracket the
routine puts the matching opening bracket in AH, pops the top of the stack into AL, and compares
the two. Any other character is skipped. There are four ways to fail, and the routine returns a
different code for each one so the program can print a precise message: a closing bracket with
nothing open (code 1), a closing bracket of the wrong kind (code 2), brackets still open when the
string ends (code 3), and more than 64 open brackets (code 4, overflow).

**Figure 2**

*Flowchart of check_brackets*

[FIGURE figures/fig2_bracket_flow.png]

Table 3 traces the stack while checking the balanced string "{[()()]}".

**Table 3**

*Trace of check_brackets for "{[()()]}"*

| Position | Character | Action | Stack (bottom to top) |
|---|---|---|---|
| 1 | { | push | { |
| 2 | [ | push | { [ |
| 3 | ( | push | { [ ( |
| 4 | ) | pop "(", it matches | { [ |
| 5 | ( | push | { [ ( |
| 6 | ) | pop "(", it matches | { [ |
| 7 | ] | pop "[", it matches | { |
| 8 | } | pop "{", it matches | (empty) |
| end | | stack_size = 0 | balanced |

For "([)]" the same steps push "(" and "[", but at position 3 the ")" pops "[" instead of "(",
so the program prints: NOT balanced: ')' at position 3 does not match '['.

### Efficiency of the Design

- **Time.** Each character is read exactly once, and every push and pop takes constant time. On
the success path, stack_push and stack_pop each execute exactly 10 instructions (7 when they report
an error), which I confirmed by disassembling the program with objdump. All three problems
therefore run in linear time, O(n), in the length of the string.
- **Memory.** The stack uses a fixed 68 bytes and the reversed copy a fixed 65 bytes. There is no
heap allocation, and the input string is never copied.
- **Small choices that add up.** Loop variables stay in registers (ESI for the string pointer, ECX
for the position) instead of memory. Errors are reported in the carry flag, so checking one costs
a single jc instruction. The palindrome test reuses the reversed copy instead of running the stack
a second time, and check_brackets stops at the first error instead of scanning the rest of the
string.

## Part 2: Design and Development Process

### Step 1: Defining the Problem and Choosing the Structure

I started from the problem, not the code. Reversal and bracket matching both depend on "last in,
first out", so a stack was the natural choice. A linked list would also work, but a stack stored
in an array needs no pointers and no memory allocation, which matters in assembly, where there is
no malloc or new unless you write one yourself. Mahout (2012) presents arrays and stacks as basic
structures that an assembly programmer builds directly in memory, and that is the approach I took.

### Step 2: Choosing the Tools

I chose NASM on 32-bit x86 Linux because it matches the asmtutor.com lessons in our reading list,
which use the same build commands (nasm -f elf, then ld -m elf_i386) and the same int 80h system
calls for output and exit (*NASM Assembly Language Tutorials*, n.d.). The assembler translates each
mnemonic, such as mov or cmp, into machine code ("Assembly Language," 2021), and the linker then
turns that object file into a program the operating system can run.

### Step 3: Designing the Data Layout and the Interfaces

Kann (2021) explains that designing an assembly language comes down to three concerns: moving data
between main memory and the registers inside the CPU, the operations the ALU can perform, and
branching for program control. I designed my program around the same three concerns:

- **Data.** The items live in memory (stack_data), and a register (EBX) holds the index while an
operation runs. The 64-byte limit is a named constant, STACK_MAX, so it can be changed in one place.
- **Operations.** Each stack operation is a handful of moves, compares, and increments.
- **Control.** Every decision is a compare followed by a conditional jump, such as jae for "stack
full" or jc for "an error was reported".

Before writing any code I wrote down the interface of every routine (Table 2): which register
carries the input, which carries the output, and how errors are reported. I picked the carry flag
for errors because one flag is cheaper than a return code and is easy to test.

### Step 4: Building and Testing the Stack First

I wrote stack_init, stack_push, and stack_pop before anything else and tested them on their own. Only
when push and pop behaved correctly, including on a full and an empty stack, did I build reverse,
is_palindrome, and check_brackets on top of them. Building in layers meant that when something went
wrong later, I knew the bug was in the new layer and not in the stack.

### Step 5: Handling Errors

In assembly nothing stops the program from writing past the end of an array. A push onto a full
stack would silently overwrite stack_top, the variable stored right after stack_data in memory,
and the stack would lose track of its own size. So stack_push checks the
capacity before every write, stack_pop checks for an empty stack before every read, and every caller
tests the carry flag. The last built-in test string has 70 "(" characters to prove that both
overflow cases are caught and reported instead of corrupting memory.

### Step 6: Debugging

Two problems taught me the most. The first was a risk I had to plan around: register clobbering.
The output routines call the Linux write system call, which uses EAX, EBX, ECX, and EDX. Without
care, printing a message would destroy the position and bracket values that check_brackets had
just returned. I avoided this by making every helper save all registers with pushad and restore
them with popad. I also learned
that popad does not change the flags, so a routine can restore its registers and still return a
result in the carry flag. The second was a visible bug in my first full run: when a string was too
long, the output read Reversed : "error: ... with a stray quote mark. The label printed an opening
quote before I knew whether reversal would succeed. I moved the quote so it is printed only when
there is a reversed string to show.

### Step 7: Testing

I tested the program in three ways:

1. **The built-in tests** (Figure 3) cover a normal word, a palindrome, two balanced expressions,
and every error: a wrong bracket, an unclosed bracket, a bracket with no opener, and overflow.
2. **My own strings on the command line** (Figure 4), including a line of C code.
3. **An automated check.** I wrote a short Python script, verify_stackapp.py, that assembles the
program, runs it on 5,014 strings (random strings plus edge cases at exactly 64 and 65 characters),
and compares every printed line with a Python version of the same algorithms. All 5,014 matched. To
make sure the checker could actually catch mistakes, I planted a bug on purpose in a copy of the
program (I skipped the bracket-kind comparison), and the checker flagged 26 failing batches. With
the bug removed, it reports no failures.

**Table 4**

*Selected Test Cases and Results*

| Input | Reversed | Palindrome | Brackets |
|---|---|---|---|
| Assembly | ylbmessA | no | balanced |
| racecar | racecar | yes | balanced |
| {[()()]} | }])()([{ | no | balanced |
| ([)] | ])[( | no | ')' at position 3 does not match '[' |
| ((x) | )x(( | no | 1 bracket(s) never closed |
| x)( | ()x | no | ')' at position 2 has no opening bracket |
| 70 "(" characters | overflow error | skipped | overflow error |
| {(}) | )}({ | no | '}' at position 3 does not match '(' |

### Compile and Run

```
nasm -f elf stackapp.asm
ld -m elf_i386 stackapp.o -o stackapp
./stackapp                          (built-in tests)
./stackapp "text" "(a[b]{c})"       (your own strings)
```

The program assembles with no warnings. Its machine code is 748 bytes, and the stack itself
uses 68 bytes of memory (64 for the items and 4 for stack_top).

**Figure 3**

*Building the Program and Running the Built-in Tests*

[FIGURE figures/fig3_run_builtin.png]

**Figure 4**

*Running the Program on Strings Typed on the Command Line*

[FIGURE figures/fig4_run_custom.png]

### How This Project Deepened My Understanding of Low-Level Programming

- **A data structure is just memory plus rules.** The "stack" is 64 bytes and a counter. What
makes it a stack is the discipline that every access goes through push and pop. High-level
languages hide this, but it is exactly what a Stack class does inside.
- **Addressing modes do real work.** Base plus index addressing, [stack_data + ebx], is what an
array access like data[top] becomes in machine code.
- **Flags are a communication channel.** Returning errors in the carry flag showed me how
compare and jump instructions drive every decision a program makes.
- **There are two stacks.** My data stack is separate from the CPU's own call stack (ESP), which
call, ret, push, and pop use behind the scenes to store return addresses and saved registers.
Writing both side by side made the hardware stack easy to understand, because it works by the
same LIFO rule as mine.
- **Programs talk to the operating system through system calls.** Printing one line means
loading a system call number into EAX, the arguments into EBX, ECX, and EDX, and executing int 80h
(*NASM Assembly Language Tutorials*, n.d.).
- **Program translation became concrete.** I wrote the same push operation in C and asked GCC to
translate it with optimization turned on (gcc -m32 -O2 -S). The compiler produced almost the same
compare, store, and increment. This matches the code generation phase, where a compiler maps its
optimized intermediate code to the target machine's instructions (Bhumika, 2022). The main
differences were that GCC passed the item on the memory stack and returned the status in EAX,
because it must follow the standard calling convention, while my version uses a register and the
carry flag.

## Part 3: Benefits of Assembly Language for High-Level Data Structures

**1. Complete control over memory.** In assembly I decide exactly where every byte lives and how
big the structure is: 64 bytes of items and a 4-byte counter, with no object headers and no hidden
allocation. This matters most on small embedded devices. Mahout (2012) teaches these structures on
the ARM Cortex-M3, a processor core built for microcontrollers, where memory is small and has to
be planned byte by byte.

**2. Speed and predictable timing.** A push in my program is about ten instructions with no
function-call overhead beyond call and ret, and its running time is the same every time. Assembly
is still used where timing is critical, such as device drivers, interrupt handlers, and real-time
systems, where an interrupt may fire thousands of times per second and must finish in as few cycles
as possible ("Assembly Language," 2021). Thakkar (2022) also points out that a few programmers
still pick assembly for short programs where every bit of execution speed counts.

**3. Smaller code.** My hand-written stack_push is 31 bytes of machine code. The same logic written
in C and compiled by GCC with -O2 came to 40 bytes, mostly because the compiler has to pass the
argument through memory to follow the calling convention. The gap is small, which shows how good
modern compilers are, but in boot code or firmware stored in a small ROM those bytes add up.
Assembly is still typically used for boot code that runs before the operating system starts
("Assembly Language," 2021).

**4. Access to processor features that high-level languages hide.** I used the carry flag as a
cheap error signal, which C or Java cannot do directly. Real systems use this kind of access too.
The Linux kernel's memcpy, the routine that copies blocks of memory for the whole operating system,
is written in x86 assembly so it can use the rep movsb string instruction directly (Linux kernel
developers, n.d.). Encryption code is another example, because it relies on bit rotation
instructions that many compilers do not expose ("Assembly Language," 2021).

**5. Understanding what high-level code really does.** Even if I never write production code in
assembly, I now know what a Stack class, a function call, and an array index cost on real hardware.
That helps with debugging, with reading compiler output, and with security work, where attacks
such as buffer overflows only make sense at this level.

These benefits come with real costs. My program runs only on x86 processors, because each
processor family has its own assembly language (Thakkar, 2022). It took far more lines than the
same program in Python, and I had to handle every overflow check and saved register myself.
Thakkar (2022) notes that most developers rarely write assembly today for these reasons. In
practice, the best use of assembly is for the small, critical parts of a system, such as the core
data structure operations, the interrupt handler, or the memory copy routine, while the rest is
written in a high-level language.

## Conclusion

The project turned a familiar idea, the stack, into something I could see at the level of bytes,
registers, and flags. Building it in layers, defining clear register interfaces, checking for
overflow and underflow on every operation, and testing against a reference version on more than
5,000 strings gave me a program that is small (748 bytes of code), fast, and correct. It also
showed me why assembly is still worth knowing: it gives full control over memory, timing, and
processor features, which is exactly what device drivers, embedded systems, and operating system
kernels need, even though most software is now written in high-level languages.

## Appendix: Full Source Code

[CODE src/stackapp.asm]

## References

Assembly language. (2021, June 18). In *CodeDocs*. https://codedocs.org/what-is/assembly-language

Bhumika. (2022, April 9). *What is the phases of compiler?* Goseeko.
https://web.archive.org/web/20230331094608/https://www.goseeko.com/blog/what-is-the-phases-of-compiler/

Kann, C. W., III. (2021, March 21). 2.5: Designing an assembly language. In *Implementing a
one-address CPU in Logisim (Kann)*. LibreTexts Engineering.
https://eng.libretexts.org/Bookshelves/Electrical_Engineering/Electronics/Implementing_a_One_Address_CPU_in_Logisim_(Kann)/02%3A_Assembly_Language/2.05%3A_Designing_an_Assembly_Language

Linux kernel developers. (n.d.). *memcpy_64.S* [Source code]. GitHub.
https://github.com/torvalds/linux/blob/master/arch/x86/lib/memcpy_64.S

Mahout, V. (2012). Algorithmic and data structures. In *Assembly language programming: ARM
Cortex-M3* (pp. 87–118). ISTE; John Wiley & Sons. https://doi.org/10.1002/9781118562123.ch6

*NASM assembly language tutorials*. (n.d.). asmtutor.com. https://asmtutor.com/

Thakkar, M. (2022, May 3). *What is assembly language? A quick overview*. InfoSec Insights.
https://sectigostore.com/blog/what-is-assembly-language/
