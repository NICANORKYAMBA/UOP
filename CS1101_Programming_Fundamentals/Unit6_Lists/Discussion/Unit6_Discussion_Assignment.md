# CS1101 Unit 6 Discussion Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 6 — Lists  
**Date**: March 2026

---

## Equivalent vs. Identical: Objects and Values

In Python, two objects can be **equivalent** — meaning they hold the same values — without being **identical** — meaning they are not the same object in memory. The `==` operator tests equivalence (value equality), while the `is` operator tests identity (whether two variables point to the exact same object). Downey (2015) describes this distinction clearly: "An object has a value. If you evaluate `a == b`, Python checks whether the values of `a` and `b` are the same. If you evaluate `a is b`, Python checks whether they are the same object" (p. 107).

```python
# Equivalent but NOT identical
a = [10, 20, 30]
b = [10, 20, 30]

print(a == b)   # True  — same values, equivalent
print(a is b)   # False — different objects in memory

# Identical
c = a
print(a is c)   # True  — c points to the same object as a
```

**Output**:
```
True
False
True
```

Here, `a` and `b` are two separate list objects that happen to contain the same values — equivalent but not identical. `c = a` makes `c` an alias for `a`, so `a is c` returns `True` because both names reference the exact same object.

---

## Objects, References, and Aliasing

Every Python variable is a **reference** — a name that points to an **object** stored in memory. When you write `a = [1, 2, 3]`, Python creates a list object and makes `a` a reference to it. **Aliasing** occurs when two or more references point to the same object.

```python
original = ['Alice', 'Bob', 'Carol']
alias = original        # alias references the SAME object

alias.append('David')
print(original)         # ['Alice', 'Bob', 'Carol', 'David']
print(alias is original)  # True
```

**Output**:
```
['Alice', 'Bob', 'Carol', 'David']
True
```

Because `alias` and `original` reference the same object, appending through `alias` also changes what `original` sees. This is aliasing in action. To avoid this side effect, create an independent copy using a slice:

```python
safe_copy = original[:]     # new object, same values
safe_copy.append('Eve')
print(original)             # ['Alice', 'Bob', 'Carol', 'David'] — unchanged
print(safe_copy is original)  # False
```

**Output**:
```
['Alice', 'Bob', 'Carol', 'David']
False
```

The slice `[:]` creates a new list object with the same values, so modifications to `safe_copy` do not affect `original`.

---

## Function That Modifies a List Argument

Because lists are passed by reference, a function receives a reference to the original list object — not a copy. This means the function can modify the original list directly.

```python
def apply_raise(salary_list, percent):
    # salary_list is a reference to the same object as the argument
    # Index assignment modifies the original list object in place
    for i in range(len(salary_list)):
        salary_list[i] = round(salary_list[i] * (1 + percent), 2)

salaries = [50000, 62000, 47500, 71000, 55000]
print("Before:", salaries)
apply_raise(salaries, 0.04)
print("After: ", salaries)
```

**Output**:
```
Before: [50000, 62000, 47500, 71000, 55000]
After:  [52000.0, 64480.0, 49400.0, 73840.0, 57200.0]
```

The function `apply_raise` takes `salary_list` as a **parameter** — a local reference that points to the same list object as the **argument** `salaries`. Because the function modifies elements in place using index assignment (`salary_list[i] = ...`), it modifies the original object directly. After the function returns, `salaries` reflects the updated values without any `return` statement needed. This is a direct consequence of Python's reference semantics: when a list is passed as an argument, the parameter and the argument are two names for the same object in memory. Downey (2015) notes that this behaviour is important to keep in mind because "if a function modifies a list parameter, the caller sees the change" (p. 110).

---

## Discussion Question

When a function modifies a list passed as an argument, the changes persist after the function returns — but if the function reassigns the parameter to a new list (e.g., `t = t + [x]`), the original list is unchanged. What strategies do you use to decide whether a function should modify a list in place or return a new list, and how does that choice affect the readability and predictability of your code?

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: ~640 words (body prose, excluding code blocks and header)
