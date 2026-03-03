# Chapter 7: Iteration - Learning Notes

**Course**: CS1101 Programming Fundamentals  
**Unit**: 5 - Iteration and Strings  
**Source**: Downey, A. (2015). *Think Python* (2nd ed.), Chapter 7 (pp. 63-69)

---

## 7.1 Reassignment

Variables can be reassigned to new values. Each new assignment replaces the previous value:

```python
x = 5
print(x)   # 5
x = 7
print(x)   # 7
```

**Important**: In Python, `=` is assignment, not equality. `x = x + 1` is valid — it reads the current value of x, adds 1, and stores the result back in x.

---

## 7.2 Updating Variables

A common pattern is updating a variable based on its current value:

```python
x = x + 1   # increment
x = x - 1   # decrement
x = x * 2   # double
```

Before updating, the variable must be initialized:

```python
# This causes a NameError:
# x = x + 1  (x not yet defined)

x = 0        # initialize first
x = x + 1   # now update works
```

---

## 7.3 The while Statement

The while loop repeats a block of code as long as a condition is True:

```python
while condition:
    body
```

**Execution flow**:
1. Evaluate condition
2. If False, exit loop
3. If True, execute body, go back to step 1

**Example — countdown**:
```python
def countdown(n):
    while n > 0:
        print(n)
        n = n - 1
    print('Blastoff!')
```

**Infinite loop risk**: If the condition never becomes False, the loop runs forever. Always ensure the loop variable changes toward termination.

---

## 7.4 break

The `break` statement exits the loop immediately, regardless of the condition:

```python
while True:
    line = input('> ')
    if line == 'done':
        break
    print(line)
print('Done!')
```

This pattern — loop forever until a sentinel value is entered — is very common for user input.

---

## 7.5 Square Roots (Newton's Method — Algorithm Example)

An algorithm is a mechanical process for solving a category of problems. Newton's method for computing square roots is a classic example:

```python
def square_root(a):
    x = a / 2.0          # initial guess
    while True:
        y = (x + a/x) / 2   # improved guess
        if abs(y - x) < 1e-10:  # close enough?
            break
        x = y
    return x
```

**Key algorithm characteristics**:
- Clear, unambiguous steps
- Finite — terminates after a known number of steps
- Effective — each step is executable

---

## 7.6 Algorithms

An **algorithm** is a general solution to a class of problems, not just one specific instance.

- Algorithms are not specific to any programming language
- They describe the logic, not the implementation
- Good algorithms are efficient, correct, and readable

**Example**: Counting vowels in a string is an algorithm — it works for any string, not just one specific word.

---

## for Loop vs while Loop

| Feature | for loop | while loop |
|---------|----------|------------|
| Use when | Number of iterations known | Condition-based termination |
| Iteration type | Definite | Indefinite |
| Syntax | `for item in sequence:` | `while condition:` |
| Risk | None (finite by nature) | Infinite loop if condition never False |
| Best for | Strings, lists, ranges | User input, convergence, search |

---

## Common Loop Patterns

### Counter Pattern
```python
count = 0
for c in word:
    if c == 'a':
        count += 1
```

### Accumulator Pattern
```python
total = 0
for n in numbers:
    total += n
```

### Search Pattern (with break)
```python
found = False
for c in word:
    if c.islower():
        found = True
        break
```

### Sentinel Loop
```python
while True:
    user_input = input("Enter value (or 'quit'): ")
    if user_input == 'quit':
        break
    # process input
```

---

## Key Terms

| Term | Definition |
|------|-----------|
| Iteration | Repeated execution of a block of code |
| Loop variable | Variable that changes with each iteration |
| Infinite loop | Loop that never terminates |
| break | Statement that exits a loop immediately |
| Algorithm | General step-by-step process for solving a problem |
| Increment | Increase a variable's value (usually by 1) |
| Decrement | Decrease a variable's value (usually by 1) |

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Khan Academy. (2011, June 30). *While loops in Python* [Video]. YouTube. https://youtu.be/D0Nb2Fs3Q8c

Khan Academy. (2011, June 30). *For loops in Python* [Video]. YouTube. https://youtu.be/9LgyKiq_hU0
