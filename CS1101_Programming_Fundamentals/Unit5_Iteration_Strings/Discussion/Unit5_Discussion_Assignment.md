# CS1101 Unit 5 Discussion Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 5 - Iteration and Strings  
**Date**: February 2026

---

## Analyzing Lowercase Letter Checking Functions

This discussion analyzes five Python functions that are each supposed to check whether a string argument contains any lowercase letters. Using knowledge of for loops, string methods, and return statements from Downey (2015), I will describe what each function actually does, identify incorrect implementations, and provide counterexamples.

---

### Function 1: any_lowercase1

```python
def any_lowercase1(s):
    for c in s:
        if c.islower():
            return True
        else:
            return False
```

**What it actually does**: This function only ever examines the **first character** of the string. Because both the `if` and `else` branches contain a `return` statement, the function exits on the very first iteration of the loop, regardless of what the remaining characters are.

**Is it correct?** No.

**Counterexample**:
```
any_lowercase1('Abc')   # returns False — 'A' is uppercase, never checks 'b' or 'c'
any_lowercase1('ABc')   # returns False — never reaches lowercase 'c'
```

Both calls return `False` even though `'b'` and `'c'` are lowercase. According to Downey (2015), a `return` statement immediately terminates a function (p. 55), so placing `return` inside both branches of an if-else within a loop causes the loop to exit after the first character.

---

### Function 2: any_lowercase2

```python
def any_lowercase2(s):
    for c in s:
        if 'c'.islower():
            return 'True'
        else:
            return 'False'
```

**What it actually does**: This function **always returns the string `'True'`** regardless of input. The bug is `'c'.islower()` — it checks whether the string literal `'c'` is lowercase, not the loop variable `c`. Since `'c'` is always lowercase, the condition is always `True`, and the function always returns the string `'True'` after the first iteration.

**Is it correct?** No — it has two bugs:
1. Checks `'c'` (string literal) instead of `c` (loop variable)
2. Returns strings `'True'`/`'False'` instead of booleans `True`/`False`

**Counterexample**:
```
any_lowercase2('ABC')   # returns 'True'  (should return False)
any_lowercase2('123')   # returns 'True'  (should return False)
```

---

### Function 3: any_lowercase3

```python
def any_lowercase3(s):
    for c in s:
        flag = c.islower()
    return flag
```

**What it actually does**: This function checks only the **last character** of the string. The variable `flag` is reassigned on every iteration, so when the loop finishes, `flag` holds the result for the final character only. The `return` is correctly outside the loop, but the flag is never accumulated across iterations.

**Is it correct?** No.

**Counterexample**:
```
any_lowercase3('abcD')   # returns False — last char 'D' is uppercase, ignores 'a','b','c'
any_lowercase3('ABCd')   # returns True  — last char 'd' is lowercase
```

The first call returns `False` even though three lowercase letters exist. The function also raises a `NameError` if passed an empty string since `flag` would never be assigned.

---

### Function 4: any_lowercase4

```python
def any_lowercase4(s):
    flag = False
    for c in s:
        flag = flag or c.islower()
    return flag
```

**What it actually does**: This function **correctly checks whether any character in the string is lowercase**. It initializes `flag` to `False`, then uses the `or` operator to accumulate results. Once `flag` becomes `True`, it stays `True` for all subsequent iterations because `True or anything` is always `True`.

**Is it correct?** Yes. ✅

**Examples**:
```
any_lowercase4('abc')   # True
any_lowercase4('ABC')   # False
any_lowercase4('AbC')   # True
any_lowercase4('')      # False
```

This is the accumulator pattern described by Downey (2015, p. 67), where a variable is initialized before the loop and updated on each iteration.

---

### Function 5: any_lowercase5

```python
def any_lowercase5(s):
    for c in s:
        if not c.islower():
            return False
    return True
```

**What it actually does**: This function returns `True` only if **all characters are lowercase** — it is effectively an `all_lowercase` function, not `any_lowercase`. It returns `False` as soon as it finds any character that is not lowercase, and only returns `True` if the entire string passes without triggering the early return.

**Is it correct?** No — it solves the wrong problem.

**Counterexample**:
```
any_lowercase5('AbC')   # returns False — should return True since 'b' is lowercase
any_lowercase5('')      # returns True  — vacuously true, edge case
```

---

## Summary Table

| Function | Behavior | Correct? | Bug |
|----------|----------|----------|-----|
| `any_lowercase1` | Checks first character only | ❌ | `return` in both if/else branches exits loop immediately |
| `any_lowercase2` | Always returns string `'True'` | ❌ | Checks `'c'` literal instead of variable `c` |
| `any_lowercase3` | Checks last character only | ❌ | Overwrites `flag` each iteration without accumulating |
| `any_lowercase4` | Correctly checks all characters | ✅ | None |
| `any_lowercase5` | Checks if ALL characters are lowercase | ❌ | Wrong logic — implements `all_lowercase`, not `any_lowercase` |

---

## Discussion Question

Functions 1, 3, and 5 all have subtle bugs related to where the `return` statement is placed relative to the loop. How does the placement of a `return` statement inside versus outside a loop fundamentally change what a function computes, and what general rule would you follow to decide where to place `return` when writing a search or validation function?

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Khan Academy. (2011, June 30). *Fun with strings* [Video]. YouTube. https://youtu.be/iZAtkS0F-Zo

---

**Word Count**: 612 words (excluding code, table, and references)
