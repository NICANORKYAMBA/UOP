# CS1101 Unit 8 — Peer Response to Allan Maghenda

**By**: Nicanor Kyamba  
**Date**: March 2026

---

Allan, your explanation of why exception handling matters for file operations is clear and well-grounded — the point that file operations depend on *external conditions* outside the program's control is exactly the right framing. It explains why you cannot simply check for errors before they happen the way you might with a conditional; the file system state can change between the check and the operation.

I also like that you included `print("Program execution continues normally.")` after the `except` block. That single line demonstrates something important: the program does not stop at the exception handler — it continues executing whatever comes after the `try`/`except` structure. That is one of the key benefits of exception handling that is easy to miss when you only look at the error message.

One improvement worth considering is replacing the manual `file.close()` with a `with` statement. In your current code, if `file.read()` raises an unexpected error, the `file.close()` line is never reached and the file handle stays open. The `with` statement solves this by closing the file automatically when the block exits, regardless of whether an error occurred (Downey, 2015, p. 141):

```python
try:
    with open("student_records.txt", "r") as file:
        content = file.read()
        print("File opened successfully.")
        print(content)
except FileNotFoundError:
    print("Error: The file 'student_records.txt' was not found.")

print("Program execution continues normally.")
```

Your Part 2 covers the right strategies. The backup and recovery point is one I did not include in my own post — the idea of automatically falling back to an alternative file or creating a new one is a genuinely practical production pattern, especially for configuration files that a program cannot run without.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: ~285 words  
**Rating**: 8/10
