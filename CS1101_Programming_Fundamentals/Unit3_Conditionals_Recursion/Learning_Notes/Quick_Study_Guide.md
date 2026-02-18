# Unit 3 Quick Study Guide - CS1101

**Course**: CS1101 Programming Fundamentals  
**Unit**: 3 - Conditionals and Recursion  
**Date**: February 2026

---

## 🎯 Unit 3 at a Glance

### Five Core Skills
1. **Boolean Expressions** - Logical conditions
2. **Conditionals** - If/elif/else statements
3. **Recursion** - Functions calling themselves
4. **Error Handling** - Try/except blocks
5. **Keyboard Input** - Getting user input

---

## 📊 Quick Reference Tables

### Comparison Operators

| Operator | Meaning | Example | Result |
|----------|---------|---------|--------|
| `==` | Equal to | `5 == 5` | True |
| `!=` | Not equal | `5 != 3` | True |
| `>` | Greater than | `5 > 3` | True |
| `<` | Less than | `3 < 5` | True |
| `>=` | Greater or equal | `5 >= 5` | True |
| `<=` | Less or equal | `3 <= 5` | True |

### Logical Operators

| Operator | Description | Example | Result |
|----------|-------------|---------|--------|
| `and` | Both True | `True and False` | False |
| `or` | At least one True | `True or False` | True |
| `not` | Negates | `not True` | False |

### Floor Division & Modulus

| Operation | Symbol | Example | Result |
|-----------|--------|---------|--------|
| Floor Division | `//` | `7 // 3` | 2 |
| Modulus | `%` | `7 % 3` | 1 |

---

## 🔑 Key Patterns

### Conditional Patterns

**Simple If**:
```python
if condition:
    # execute if True
```

**If-Else**:
```python
if condition:
    # execute if True
else:
    # execute if False
```

**Chained (if-elif-else)**:
```python
if condition1:
    # first True condition
elif condition2:
    # second True condition
else:
    # all False
```

**Nested**:
```python
if condition1:
    if condition2:
        # both True
```

---

### Recursion Pattern

```python
def recursive_func(n):
    if base_condition:  # Base case
        return base_value
    else:  # Recursive case
        return recursive_func(modified_n)
```

**Requirements**:
1. Base case (stops recursion)
2. Progress toward base case
3. Recursive call with modified argument

---

### Error Handling Pattern

```python
try:
    # Code that might error
    result = risky_operation()
except ErrorType:
    # Handle error
    print("Error occurred")
```

---

## ✅ Assignment Checklist

### Discussion Assignment
- [ ] Explain chained vs nested conditionals
- [ ] Original chained conditional example
- [ ] Original nested conditional example
- [ ] Strategy for avoiding nesting
- [ ] Nested → simplified example
- [ ] Discussion question for peers
- [ ] At least 150 words
- [ ] Reply to 2 classmates

### Programming Assignment Q1
- [ ] Write `countup` function (recursive)
- [ ] Write main program with input
- [ ] Test positive number
- [ ] Test negative number
- [ ] Test zero
- [ ] Explain zero choice

### Programming Assignment Q2
- [ ] Division program with error
- [ ] Implement try-except
- [ ] Show error output
- [ ] Explain error handling (200+ words)
- [ ] Discuss impact of not handling

### Formatting
- [ ] Times New Roman 12pt
- [ ] Double-spaced
- [ ] 1" margins
- [ ] APA citations
- [ ] 200+ words descriptive
- [ ] Export to DOCX

---

## 💡 Quick Tips

### For Conditionals
- **Chained**: Multiple conditions, checks in order, first True executes
- **Nested**: Conditionals inside conditionals, harder to read
- **Simplify**: Use `and`/`or` instead of nesting

### For Recursion
- **Always** have base case
- **Always** make progress toward base case
- **Test** with small inputs first
- **Draw** stack diagram if confused

### For Error Handling
- Use `try-except` for runtime errors
- Provide meaningful error messages
- Test edge cases (zero, negative, empty)

---

## ⚠️ Common Mistakes

### Conditionals
- ❌ Using `=` instead of `==` for comparison
- ❌ Forgetting colon after condition
- ❌ Incorrect indentation
- ❌ Over-nesting (use logical operators)

### Recursion
- ❌ No base case (infinite recursion)
- ❌ Not making progress toward base case
- ❌ Forgetting to return value

### Error Handling
- ❌ Catching all exceptions (too broad)
- ❌ Empty except block (hiding errors)
- ❌ Not providing error message

---

## 🔍 Debugging Checklist

### Syntax Errors
- [ ] Check for missing colons
- [ ] Verify indentation
- [ ] Check parentheses/brackets match
- [ ] Verify variable names spelled correctly

### Runtime Errors
- [ ] Check for division by zero
- [ ] Verify variables are defined
- [ ] Check data types match operations
- [ ] Test with edge cases

### Semantic Errors
- [ ] Verify logic is correct
- [ ] Check condition operators (>, <, ==)
- [ ] Test with known inputs/outputs
- [ ] Use print statements to debug

---

## 📝 Example Code Snippets

### Check Even/Odd
```python
if n % 2 == 0:
    print("Even")
else:
    print("Odd")
```

### Countdown (Recursion)
```python
def countdown(n):
    if n <= 0:
        print("Blastoff!")
    else:
        print(n)
        countdown(n - 1)
```

### Division with Error Handling
```python
try:
    result = x / y
    print(result)
except ZeroDivisionError:
    print("Cannot divide by zero!")
```

### Keyboard Input
```python
n = int(input("Enter number: "))
if n > 0:
    print("Positive")
elif n < 0:
    print("Negative")
else:
    print("Zero")
```

---

## 🎓 Exam Tips

### For Self-Quiz
- Review boolean operators
- Practice recursion tracing
- Understand chained vs nested
- Know error types

### For Graded Quiz
- Study all learning notes
- Practice writing conditionals
- Trace recursive functions
- Understand stack diagrams

---

## ⏰ Time Management

- **Day 1**: Read Chapter 5, watch videos
- **Day 2**: Complete learning notes
- **Day 3**: Write discussion post
- **Day 4**: Start programming assignment Q1
- **Day 5**: Complete programming assignment Q2
- **Day 6**: Format, cite, proofread
- **Day 7**: Submit, reply to peers

---

## 🎯 Success Criteria

### Excellent Work Includes:
- ✅ Clear explanations of concepts
- ✅ Original, working code examples
- ✅ Proper error handling
- ✅ Technical explanations (200+ words)
- ✅ APA citations
- ✅ Error-free writing
- ✅ Proper formatting

---

**Last Updated**: February 2026  
**Good Luck!** 🎓
