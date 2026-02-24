# CS1101 Unit 4 Discussion - Peer Response to Oluwaseun Oloyede

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 4 - Functions and Return Values  
**Date**: February 2026

---

## Response to Oluwaseun Oloyede

Hi Oluwaseun,

Great breakdown of the three debugging possibilities from Section 6.9! Your examples are well-chosen — the missing argument in `divide(10)`, the addition-instead-of-multiplication bug in `area_rectangle`, and the missing `return` statement in `multiply` each clearly illustrate a distinct category of error. I especially liked that your `multiply` example highlights one of the most common mistakes in fruitful functions: forgetting that Python returns `None` by default when no explicit `return` statement is provided (Downey, 2015).

To answer your discussion question about `assert` statements, they are an excellent tool for enforcing preconditions directly in code. For example, in your `divide` function, adding `assert b != 0, "Denominator cannot be zero"` at the start would immediately raise an `AssertionError` with a clear message if someone passes zero as the second argument, catching the precondition violation before the `ZeroDivisionError` occurs. The advantage over a simple `if` check is that `assert` statements can be globally disabled in production with the `-O` flag, making them ideal for development-time validation without runtime overhead. One thing I would add to your analysis is that the missing `return` bug in your third example could also be caught by checking postconditions — if we expect `multiply(3, 4)` to return an `int`, asserting `assert result is not None` on the caller side would flag the issue immediately.

### Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/html/
