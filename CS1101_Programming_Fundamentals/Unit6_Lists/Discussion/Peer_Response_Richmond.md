# CS1101 Unit 6 Discussion — Peer Response to Richmond Ntsiful

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 6 — Lists  
**Date**: March 2026

---

## Response to Richmond Ntsiful

Hi Richmond,

Your post is well-organised and addresses all three parts of the prompt. Your explanation of aliasing is particularly strong — the point that "changes made through one reference will affect the same object accessed through another reference" is exactly the right mental model, and your `numbers is alias_numbers` check at the end of the aliasing example is a nice touch that confirms identity rather than just observing the side effect.

I want to flag a small but important discrepancy in your `add_square_numbers()` function. The function body uses `num_list[i] * 2`, which doubles each element, but the function name and the documented output (`1, 4, 9, 16`) suggest squaring was intended. Running the code as written actually produces `[2, 4, 6, 8]`, not `[1, 4, 9, 16]`. To produce the squared output, the operation should be `num_list[i] ** 2`. This is a good example of why Downey (2015) recommends testing each small piece of code incrementally — a mismatch between a function's name and its behaviour is one of the harder bugs to spot during a review (p. 45).

To answer your discussion question: the key difference is that mutable objects like lists are passed by reference — the function parameter points to the same object in memory, so in-place modifications persist after the function returns. Immutable objects like integers and strings cannot be modified in place at all; any operation that appears to "change" them actually creates a new object, leaving the original untouched (Downey, 2015, p. 109).

Great work overall — the Python Software Foundation citation is a strong addition that goes beyond the textbook.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: 282 words
