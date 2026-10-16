# Translating a Python Program into Java

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Due:** October 21, 2026

For this training project, imagine translating a small Python program that reads student marks,
calculates averages and grades, and prints a report into an equivalent Java program. A tool that
translates between two high-level languages is called a source-to-source compiler or
transcompiler (Compiler, 2021). Doing the job by hand shows that the hard part is keeping the
meaning the same, not copying the syntax.

## Integrating and Organizing the Project

I would organize the work in six steps:

1. **Capture the behavior first.** Run the Python program on many inputs, including edge cases,
and save the outputs as "golden" test results. The Java version is finished only when it
reproduces all of them.
2. **Keep both versions in one repository.** The Python code stays in a python folder, the Java
code goes in a java folder, and the golden results sit in a shared tests folder, so both versions
are checked against exactly the same data.
3. **Map the structure.** Each Python module becomes a Java class, functions become methods, lists
become ArrayList, dictionaries become HashMap, and tuples become records.
4. **Translate in phases, like a compiler.** A compiler checks tokens, then grammar, then meaning
(Bhumika, 2022; Neso Academy, 2022). I would first translate the syntax (indentation becomes
braces, def becomes a typed method), then make a separate semantic pass over every type, division,
and comparison.
5. **Work bottom-up and switch over gradually.** Translate the helper functions first, port their
tests to JUnit, and let an automated build run both test suites on every change. The Python
program stays in use until the Java version matches every golden result, so users never notice
the switch.
6. **Keep a translation log.** Every decision, such as "Python // became Math.floorDiv", is
recorded so the team understands why the Java code looks the way it does.

## Key Challenges and Benefits

The biggest challenge is that identical-looking code can mean different things. I tested these
in Python 3.14 and Java 21:

- **Integer division:** -7 // 2 is -4 in Python, which always rounds toward minus infinity (Python
Software Foundation, n.d.), but -7 / 2 is -3 in Java, which rounds toward zero (Gosling et al.,
2023). A grade calculator with negative adjustments would quietly give different results.
- **Overflow:** Python integers have unlimited precision, so 2**31 is simply 2147483648 (Python
Software Foundation, n.d.). In Java, Integer.MAX_VALUE + 1 wraps to -2147483648, because Java's
integer operators "do not indicate overflow or underflow in any way" (Gosling et al., 2023).
- **Rounding:** Python's round(2.5) gives 2, because it rounds halves to the even number (Python
Software Foundation, n.d.), while Java's Math.round(2.5) gives 3.
- **Equality:** == compares string values in Python, but object references in Java, where
equals() is needed.
- **Dynamic types:** a Python function may return a number or None. Java needs one declared return
type, so the design itself must change.

The benefits are real, too. Java's static typing moves many errors from run time to compile time,
Java programs usually run faster, and the Java ecosystem suits large, long-lived systems. The
process also improves the original code, because writing explicit types exposes hidden
assumptions and bugs in the Python version.

## Coding Practices and My Future Language Choices

Some practices are much more prominent in one language. Python favors concise code, dynamic "duck"
typing, and readability enforced by indentation, so a script can be written and changed quickly.
Java favors explicit types, encapsulation with private fields, interfaces that define contracts,
and checked exceptions that force callers to handle errors. Java takes more lines, but its
structure helps large teams. This unit also reminded me that both languages must finally be
translated into machine code the processor can execute (BGZDevTips, 2016), so the choice of
language matters mostly for the people writing and maintaining the code.

For future projects, I would choose Python for prototypes, scripts, and data analysis, where speed
of writing matters most, and Java for team projects and long-lived applications, where
compile-time checks and clear contracts pay off. When a prototype grows into a product, the staged
approach above gives a safe path from one language to the other.

**Question for the class:** If a transcompiler translated Python into Java automatically, which
compiler phase do you think would struggle most with Python's dynamic typing, and how could it
choose a Java type for a variable whose type changes while the program runs?

Word count: 715

## References

BGZDevTips. (2016, June 12). *Short lesson - The compilation/translation process* [Video]. YouTube.
https://www.youtube.com/watch?v=5ErQnht_Ct0

Bhumika. (2022, April 9). *What is the phases of compiler?* Goseeko. Archived at
https://web.archive.org/web/20230331094608/https://www.goseeko.com/blog/what-is-the-phases-of-compiler/

Compiler. (2021, June 18). In *CodeDocs*. https://codedocs.org/what-is/compiler

Gosling, J., Joy, B., Steele, G., Bracha, G., Buckley, A., Smith, D., & Bierman, G. (2023). *The Java
language specification: Java SE 21 edition*. Oracle.
https://docs.oracle.com/javase/specs/jls/se21/html/index.html

Neso Academy. (2022, March 31). *Different phases of compiler* [Video]. YouTube.
https://www.youtube.com/watch?v=TApMNhQPaCM

Python Software Foundation. (n.d.). Built-in types. In *The Python standard library*.
https://docs.python.org/3/library/stdtypes.html
