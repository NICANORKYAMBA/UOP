# CS 1105 Unit 8: Peer Responses

Author: Nicanor Maswili
Course: CS 1105 Digital Electronics & Computer Architecture

You need to post **2** replies by Wednesday (minimum 75 words, three to four sentences or more).
Each one engages the classmate's specific points, adds a technical idea, answers their question,
and ends with a question.

---

## Peer Response 1: to Rohith Dayalan

Hi Rohith,

Your point that an off-by-one resolution error makes the processor decode an unintended opcode is
a great reminder that hardware never checks our names. To answer your question, the main trick is
lazy binding. A call to a shared library function first goes to a small stub in the Procedure
Linkage Table. The first time it runs, the dynamic linker looks up the real address and stores it
in the Global Offset Table; every later call is just one indirect jump. The ld.so manual confirms
that by default the dynamic linker defers function resolution "to the point when they are first
referenced", unless LD_BIND_NOW is set (Linux man-pages project, n.d.). I could see this in a small C program I
compiled: nm lists puts as undefined (U), and the code calls it through puts@plt. As I understand
it, ASLR adds little cost because the code is position-independent, so only the table entries
hold real addresses. One
suggestion: linking your points to Arun (2016), our reading on link-editing, would strengthen your
references. Do you think lazy binding is worth its small first-call delay?

Best,
Nicanor

References:
Arun. (2016, July 1). *Symbol resolution during link-editing*. Binary Dodo.
https://binarydodo.wordpress.com/2016/07/01/symbol-resolution-during-link-editing/

Linux man-pages project. (n.d.). *ld.so(8): Linux manual page*. man7.org.
https://man7.org/linux/man-pages/man8/ld.so.8.html

---

## Peer Response 2: to Mohammed Arashed

Hi Mohammed,

I liked how you connected the link-editing phase to relocation across modules, because that is
exactly where the puzzle pieces lock together. To answer your question, a static linker resolves
every symbol at build time and copies the library code into the program, while dynamic linking
records the unresolved names and lets the system's dynamic linker resolve them when the program
starts or when a function is first called (Linux man-pages project, n.d.). I tested the trade-off with the same
hello-world program in C: the dynamically linked version was 15,952 bytes, but the static version
was 764,288 bytes, about 48 times larger, because it carries its own copy of the C library. Static
linking avoids any startup lookups, while dynamic linking saves disk space and lets many programs
share one library in memory. A small tip: APA references need a clickable URL, and the Baeldung
article now shows a 2024 update date (Bhargav, 2024). Which would you choose for a device with very
little storage?

Best,
Nicanor

References:
Bhargav, N. (2024, March 18). *Compiler, linker, assembler, and loader*. Baeldung on Computer
Science. https://www.baeldung.com/cs/compiler-linker-assembler-loader

Linux man-pages project. (n.d.). *ld.so(8): Linux manual page*. man7.org.
https://man7.org/linux/man-pages/man8/ld.so.8.html
