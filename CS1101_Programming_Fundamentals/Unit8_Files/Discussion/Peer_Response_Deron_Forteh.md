# CS1101 Unit 8 — Peer Response to Deron Jay Forteh

**By**: Nicanor Kyamba  
**Date**: March 2026

---

Deron, this is one of the more complete posts I have seen for this unit. The decision to include two test cases — one for a missing file and one for an existing file — is particularly effective because it shows both execution paths through the code. A reader can see exactly what happens when the `try` block succeeds and when the `except` block takes over, which makes the behavior of exception handling much clearer than a single failing test alone. I also noticed you already used the `with` statement correctly, which automatically closes the file even if an error occurs inside the block (Downey, 2015, p. 141) — that is the right approach and worth pointing out since not everyone in the class used it.

Your Part 2 is well thought out, and point five — graceful shutdown — is the one I find most interesting. There is an important distinction between *recoverable* errors and *unrecoverable* ones that your post touches on but does not name explicitly. A missing preferences file is recoverable: fall back to defaults and keep running. A missing database file that the entire application depends on is unrecoverable: no amount of retry logic will fix it, and the right response is exactly what you described — save state, release resources, log a clear final message, and exit cleanly. Making that distinction explicit in code, perhaps by categorizing exceptions as recoverable or fatal at the point they are caught, is a pattern used in production systems to prevent the program from limping along in a broken state when it genuinely cannot function.

One small suggestion: since Downey (2015) is the assigned textbook for this unit and covers file handling and exception catching directly in Chapter 14, adding it as a second reference would strengthen the academic grounding of your post.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: ~280 words  
**Rating**: 9/10
