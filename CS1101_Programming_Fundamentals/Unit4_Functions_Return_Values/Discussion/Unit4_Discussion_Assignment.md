# CS1101 Unit 4 Discussion Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 4 - Functions and Return Values  
**Date**: February 2026

---

## Debugging Fruitful Functions

When a fruitful function returns an incorrect value, Downey (2015, Section 6.9) identifies three possibilities. The first is a **precondition violation** — the arguments do not meet the function's requirements. A **precondition** is a condition that must be true about the inputs before the function executes. The second is a **postcondition violation** — the return value does not satisfy expected conditions. A **postcondition** is what must be true about the output after the function completes. The third is a **bug in the function body**, where the internal logic itself is flawed despite valid inputs.

```python
def absolute_value(x):
    """Postcondition: result should always be >= 0."""
    if x < 0:
        return -x
    elif x > 0:
        return x
    # Bug: missing x == 0, returns None (postcondition violated)

print(absolute_value(5))   # Output: 5
print(absolute_value(-3))  # Output: 3
print(absolute_value(0))   # Output: None  ← should be 0!

# Fixed: ensure all paths return a valid value
def absolute_value_fixed(x):
    if x < 0:
        return -x
    return x  # Covers x >= 0, including 0

print(absolute_value_fixed(0))   # Output: 0
print(absolute_value_fixed(-7))  # Output: 7
```

This example shows a postcondition violation — the function runs without error, but `absolute_value(0)` returns `None` instead of `0` because the `x == 0` case has no return path. Downey (2015) recommends systematically checking preconditions first, then using scaffolding like `print` statements to trace intermediate values, and finally verifying postconditions against known answers. This structured debugging approach helps isolate exactly where things go wrong.

---

## Discussion Question

When writing recursive functions like `factorial(n)`, passing a negative integer causes infinite recursion — a precondition violation. How would you implement guardian patterns to detect such violations, and how do guardians differ from base cases?

---

### References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. [https://greenteapress.com/thinkpython2/html/](https://greenteapress.com/thinkpython2/html/)
