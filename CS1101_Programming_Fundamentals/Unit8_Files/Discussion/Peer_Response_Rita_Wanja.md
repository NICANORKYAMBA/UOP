# CS1101 Unit 8 — Peer Response to Rita Wanja Karanja

**By**: Nicanor Kyamba  
**Date**: March 2026

---

Rita, your choice to focus on `PermissionError` is a good one — it is one of the more practically important file exceptions and does not get as much attention as `FileNotFoundError` in most introductory examples. Your explanation of why it occurs (the operating system checking access rights when `open()` is called) is accurate and clearly stated.

One thing worth adding to your example is the `with` statement. Your current code opens the file manually and calls `file.close()` explicitly, which works — but if the `file.write()` line raises an exception before `close()` is reached, the file never gets closed. Downey (2015) specifically recommends the `with` statement as a context manager for exactly this reason: it guarantees the file is closed automatically when the block exits, even if an error occurs inside it (p. 141). A small revision would look like this:

```python
try:
    with open("protected_file.txt", "w") as file:
        file.write("Confidential Data")
    print("Write operation successful.")
except PermissionError:
    print("Error: You do not have permission to modify this file.")
```

This version is safer and is the idiomatic Python style for file handling.

Your Part 2 covers the right ground — logging, upfront validation, retry logic, and graceful degradation are all genuinely important in production systems. I would add one more consideration: centralizing file I/O into a single utility module rather than scattering `try`/`except` blocks throughout the codebase. When error handling lives in one place, it is tested once and behaves consistently everywhere, which makes large programs much easier to maintain.

Overall this is a well-structured post that demonstrates solid understanding of both exception handling and production-level thinking.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: ~280 words  
**Rating**: 8/10
