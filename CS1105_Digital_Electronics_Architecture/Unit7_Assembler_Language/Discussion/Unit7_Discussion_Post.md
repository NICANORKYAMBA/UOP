# Translating a Python Program into Java

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Due:** October 21, 2026

For this training project, imagine translating a small Python program that reads student marks,
calculates averages and grades, and prints a report into an equivalent Java program. Software that
converts code from one high-level language into another is known as a transcompiler (Compiler,
2021). Doing the job by hand shows that the hard part is keeping the meaning
the same, not copying the syntax.

## Integrating and Organizing the Project

I would organize the work in six steps:

1. **Capture the behavior first.** Run the Python program on many inputs, including edge cases,
and save the outputs as "golden" test results. The Java version is finished only when it
reproduces all of them.
2. **Keep both versions in one repository.** The Python and Java code sit in separate folders
beside a shared tests folder, so both are checked against the same golden results.
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
6. **Keep a translation log.** Record every decision, such as "Python // became Math.floorDiv",
so the team knows why the Java code looks as it does.

## Key Challenges and Benefits

The biggest challenge is that identical-looking code can mean different things. I tested these
in Python 3.14 and Java 21:

- **Integer division:** -7 // 2 is -4 in Python, which always rounds toward minus infinity (Python
Software Foundation, n.d.-a), but -7 / 2 is -3 in Java, which rounds toward zero (Gosling et al.,
2023, §15.17.2). A grade calculator with negative adjustments would quietly give different results.
- **Overflow:** Python integers have unlimited precision, so 2**31 is simply 2147483648 (Python
Software Foundation, n.d.-a). In Java, Integer.MAX_VALUE + 1 wraps to -2147483648, because Java's
integer operators "do not indicate overflow or underflow in any way" (Gosling et al., 2023,
§4.2.2).
- **Rounding:** Python's round(2.5) gives 2, because it rounds halves to the even number (Python
Software Foundation, n.d.-a), while Java's Math.round(2.5) gives 3.
- **Equality:** == compares string values in Python, but in Java it is true only when both
operands refer to the same object (Gosling et al., 2023, §15.21.3), so equals() is needed.
- **Dynamic types:** a Python function may return a number or None. Java needs one declared return
type, so the design itself must change.

The benefits are real, too. Java is statically typed, so every variable's type is known before
the program runs and many errors are caught at compile time (Gosling et al., 2023, §4). In my view,
Java's tooling also suits large, long-lived systems. The process also improves the original code, because writing explicit types exposes hidden
assumptions and bugs in the Python version.

## Coding Practices and My Future Language Choices

Some practices are more prominent in one language. Python favors concise code, duck typing,
where code simply uses an object's methods instead of checking its type (Python Software
Foundation, n.d.-b), and indentation that decides how statements are grouped (Python Software
Foundation, n.d.-c). Java favors explicit types, private fields, interfaces that define contracts,
and checked exceptions, which the compiler requires every caller to handle (Gosling et al., 2023,
§11.2). Java takes more lines, but I think its structure
helps large teams. This unit also reminded me that both languages must finally be
translated into machine code the processor can execute (BGZDevTips, 2016), so the language
choice matters mostly to the people maintaining the code.

For future projects, I would choose Python for prototypes, scripts, and data analysis, where speed
of writing matters most, and Java for team projects and long-lived applications, where
compile-time checks and clear contracts pay off. If a prototype grows into a product, the staged
plan above offers a safe path to Java.

**Question for the class:** If a transcompiler translated Python into Java automatically, which
compiler phase do you think would struggle most with Python's dynamic typing, and how could it
choose a Java type for a variable whose type changes while the program runs?

Word count: 741

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

Python Software Foundation. (n.d.-a). Built-in types. In *The Python standard library*.
https://docs.python.org/3/library/stdtypes.html

Python Software Foundation. (n.d.-b). Glossary. In *Python documentation*.
https://docs.python.org/3/glossary.html

Python Software Foundation. (n.d.-c). Lexical analysis. In *The Python language reference*.
https://docs.python.org/3/reference/lexical_analysis.html
