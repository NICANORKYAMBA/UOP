# CS1101 Unit 6 Discussion — Peer Response to Oluwaseun Oloyede

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 6 — Lists  
**Date**: March 2026

---

## Response to Oluwaseun Oloyede

Hi Oluwaseun,

Your post is well-structured and covers all three parts of the prompt clearly. The distinction you draw between `list_a == list_b` (equivalent) and `list_a is list_b` (identical) is accurate and your state diagram explanation — "they were created separately" — maps directly to how Python allocates separate memory objects for each list literal, even when the values are the same. That is a precise way to frame it.

Your `add_score()` function effectively demonstrates how a list parameter is a reference to the same object as the argument. One nuance worth noting: your function both modifies the list in place *and* returns it. While this works, it can be slightly misleading — a caller might assume the return value is a new list rather than the same modified object. Downey (2015) draws a useful distinction here: functions that modify a list in place conventionally return `None` (like `append()` itself), while functions that return a new list leave the original unchanged (p. 109). Choosing one pattern consistently makes your code more predictable.

To directly answer your discussion question: the standard technique for creating an independent copy is a full slice — `copy = original[:]`. This creates a new list object with the same values, so mutations to `copy` do not affect `original`. An alternative is `list(original)`, which achieves the same result. Both approaches are covered in Downey (2015, p. 106) under the topic of list cloning.

Great work overall — your aliasing example with `alias_numbers.append(4)` is a particularly clean illustration of why aliasing can produce surprising side effects in larger programs.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: 278 words
