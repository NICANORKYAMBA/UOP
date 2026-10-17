# CS 1105 Unit 7: Peer Responses

Author: Nicanor Maswili
Course: CS 1105 Digital Electronics & Computer Architecture

You need to post **2** replies by Wednesday (minimum 75 words, three to four sentences or more).
Three drafts are provided so you can pick the two that fit best. Each one engages the classmate's
specific points, adds a technical idea, answers their question, and ends with a question.

---

## Peer Response 1: to Nankya Joyce Sanyu

Hi Nankya,

I liked your calculator example, because division is exactly where Python and Java disagree. It
looks like the forum removed the operator symbols from your sentence, so for readers: Python's /
always gives a float, while Java's / truncates when both operands are integers. There is a second,
subtler trap with negative numbers: Python's // rounds toward minus infinity, so -7 // 2 is -4
(Python Software Foundation, n.d.), but Java rounds toward zero, so -7 / 2 is -3 (Gosling et al.,
2023, §15.17.2). Java's Math.floorDiv() gives the Python result.

To answer your question, the feature that would influence me most is type checking. If many
people will maintain the code for years, Java's compile-time checks catch mistakes early; for a
quick script, Python's speed of writing wins. One small fix: your Thakkar reference links to
asmtutor.com, but the article is now at this address: https://sectigostore.com/blog/what-is-assembly-language/
Would team size or performance matter more in your decision?

Best,
Nicanor

References:
Gosling, J., Joy, B., Steele, G., Bracha, G., Buckley, A., Smith, D., & Bierman, G. (2023). *The Java
language specification: Java SE 21 edition*. Oracle.
https://docs.oracle.com/javase/specs/jls/se21/html/index.html

Python Software Foundation. (n.d.). Built-in types. In *The Python standard library*.
https://docs.python.org/3/library/stdtypes.html

---

## Peer Response 2: to Haruna Mohammed Abubakar

Hi Haruna,

Your step-by-step plan of translating one part at a time and comparing outputs on the same inputs
is very practical, and linking it to the compiler phases from Bhumika (2022) was a good touch. To
answer your question, knowing the differences prevents errors when I turn each one into a test.
For example, Python integers have unlimited precision, so 2 to the power 31 is just 2147483648
(Python Software Foundation, n.d.), but in Java Integer.MAX_VALUE + 1 silently wraps to a negative
number, because Java's integer operators do not report overflow (Gosling et al., 2023, §4.2.2). A
test that feeds both programs a very large number catches this at once. One suggestion: APA
references need a clickable link, so adding https://codedocs.org/what-is/compiler and the Goseeko
article's URL would complete yours. Which difference do you think is the easiest to miss when
testing only with small numbers?

Best,
Nicanor

References:
Bhumika. (2022, April 9). *What is the phases of compiler?* Goseeko.
https://web.archive.org/web/20230331094608/https://www.goseeko.com/blog/what-is-the-phases-of-compiler/

Gosling, J., Joy, B., Steele, G., Bracha, G., Buckley, A., Smith, D., & Bierman, G. (2023). *The Java
language specification: Java SE 21 edition*. Oracle.
https://docs.oracle.com/javase/specs/jls/se21/html/index.html

Python Software Foundation. (n.d.). Built-in types. In *The Python standard library*.
https://docs.python.org/3/library/stdtypes.html

---

## Peer Response 3: to Rohith Dayalan

Hi Rohith,

Your four-phase pipeline, especially porting the pytest suite to JUnit before translating any
logic, is a strong way to prove both versions behave the same. To answer your question, I would
refactor into custom classes, and in modern Java a record does this in one line, because a record
is "a simple aggregate of values" (Gosling et al., 2023, §8.10). With Map<String, Object>, every
read needs a cast, and a wrong cast only fails at run time with a ClassCastException (Gosling et
al., 2023, §5.1.6), which is exactly the Python-style error we wanted to leave behind. The
trade-off is flexibility: if the data's shape is truly unknown, such as arbitrary JSON from users,
a map is still the practical choice at the boundary, converted into records as soon as the shape
is known. This also ties to our reading on compiler phases, since records let semantic analysis
check the types (Bhumika, 2022). Would you validate the map's contents before converting it?

Best,
Nicanor

References:
Bhumika. (2022, April 9). *What is the phases of compiler?* Goseeko.
https://web.archive.org/web/20230331094608/https://www.goseeko.com/blog/what-is-the-phases-of-compiler/

Gosling, J., Joy, B., Steele, G., Bracha, G., Buckley, A., Smith, D., & Bierman, G. (2023). *The Java
language specification: Java SE 21 edition*. Oracle.
https://docs.oracle.com/javase/specs/jls/se21/html/index.html
