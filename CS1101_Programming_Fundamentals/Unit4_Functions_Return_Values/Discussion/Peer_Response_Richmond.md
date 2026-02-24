# CS1101 Unit 4 Discussion - Peer Response to Richmond Ntsiful

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 4 - Functions and Return Values  
**Date**: February 2026

---

## Response to Richmond Ntsiful

Hi Richmond,

Your post provides a thorough and well-structured walkthrough of the three debugging possibilities. I found your `add_tax` example particularly effective — it perfectly illustrates how a semantic error can be deceptive because the function runs without crashing yet silently produces the wrong result. This is arguably the hardest type of bug to catch, since there is no error message pointing you to the problem (Downey, 2015).

To answer your discussion question about documenting preconditions and postconditions, I think it is one of the most impactful practices for collaborative development. Python's docstring convention makes this straightforward — for instance, your `divide` function could include a docstring stating `Precondition: b != 0` and `Postcondition: returns a / b as a float`. When another developer calls that function, the documentation immediately tells them what inputs are valid and what output to expect, eliminating guesswork. In larger projects, this becomes even more critical because the person writing the function is often not the person calling it. I would also add that combining documentation with guardian patterns — like checking `if b == 0` at the top of the function and returning an error message — creates a double layer of protection: the docstring warns developers during coding, and the guardian catches violations at runtime. Your `divide` example is a great candidate for this approach since the `ZeroDivisionError` could easily crash an entire application if left unhandled.

### Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/html/
