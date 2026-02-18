# CS1101 Unit 3: Conditionals and Recursion

**Course**: CS1101 Programming Fundamentals  
**Unit**: 3 - Conditionals and Recursion  
**Student**: Nicanor Kyamba  
**Date**: February 2026

---

## 📚 Unit Overview

### Topics Covered
- Floor division and modulus operators
- Boolean expressions
- Chained conditionals
- Nested conditionals
- Recursion
- Keyboard input
- Error handling (syntax, runtime, semantic errors)

### Learning Objectives
By the end of this unit, you will be able to:
1. ✅ Differentiate between chained conditionals and nested conditionals
2. ✅ Simplify nested conditionals using boolean expressions
3. ✅ Write a chained conditional
4. ✅ Write a recursive function
5. ✅ Construct a program that uses keyboard input

---

## 📁 Folder Structure

```
Unit3_Conditionals_Recursion/
├── Discussion/
│   └── Unit3_Discussion_Assignment.md       # Chained vs nested conditionals
│
├── Assignment/
│   ├── Unit3_Programming_Assignment.md      # Q1: countdown/countup, Q2: division error
│   ├── question1_countdown_countup.py       # Recursive functions
│   ├── question2_division_error.py          # Error handling demo
│   └── Unit3_Programming_Assignment.docx    # Formatted submission
│
├── Learning_Notes/
│   ├── Chapter5_Conditionals_Recursion.md   # Comprehensive notes
│   ├── Boolean_Expressions.md               # Boolean logic
│   ├── Recursion_Guide.md                   # Recursion concepts
│   ├── Error_Handling.md                    # Debugging guide
│   └── Quick_Study_Guide.md                 # Unit 3 quick reference
│
├── Resources/
│   └── Additional_Materials.md              # Extra resources
│
└── README.md                                # This file
```

---

## 📖 Reading Assignments

### Required Readings

1. **Downey, A. (2015)** - *Think Python: How to think like a computer scientist*
   - **Chapter 5**: Conditionals and recursion
   - **Appendix A**: Debugging (Syntax, Runtime, Semantic Errors)
   - Link: https://greenteapress.com/thinkpython2/thinkpython2.pdf

2. **Video**: Python Beginner Tutorial 5 - Booleans and Conditionals
   - kjdElectronics (2017)
   - Link: https://youtu.be/E4wbrwDpnIg

3. **Video**: Learn Python EXCEPTION HANDLING in 5 minutes!
   - Bro Code (2024)
   - Link: https://www.youtube.com/watch?v=V_NXT2-QIlE

### Supplemental Reading

1. **Downey, A. (2015)** - *Think Python*
   - **Chapter 4**: Case study: interface design

---

## 📝 Discussion Assignment

### Requirements
**Topic**: Chained vs. Nested Conditionals

1. **Part 1**: Describe the difference between chained and nested conditionals
   - Provide your own example of each (not from textbook)

2. **Part 2**: Strategy for avoiding nested conditionals
   - Describe a strategy
   - Provide your own example of nested conditional
   - Show equivalent single conditional

3. **Requirements**:
   - Code and output must be explained technically
   - At least 150 words for descriptive answers
   - End with one programming question for peers
   - Reply to 2 classmates

### Rubric (10 points total)
- Code & Explanation: 4 points
- Question Posted: 1 point
- Connection to Course Materials: 1 point
- Peer Feedback (2 responses): 3 points
- Clarity and Language: 1 point

---

## 💻 Programming Assignment

### Question 1: Countdown and Countup Functions (Recursion)

**Task**:
1. Write a `countup` function that counts up from a negative number
2. Write a program that:
   - Gets keyboard input
   - Calls `countdown` for positive numbers
   - Calls `countup` for negative numbers
   - Chooses appropriate function for zero

**Deliverables**:
- Code for both functions
- Output for: positive number, negative number, zero
- Explanation of choice for zero input

---

### Question 2: Division by Zero Error Handling

**Task**:
1. Create a program that prompts for two numbers
2. Implement division operation
3. Introduce condition that raises runtime error if divisor is zero
4. Provide clear error message
5. Guide on error handling techniques

**Deliverables**:
- Code demonstrating error handling
- Output showing runtime error with message
- Explanation of error handling significance
- Discussion of impact of not handling errors

---

### Formatting Requirements
- **Word Count**: At least 200 words (descriptive part)
- **Font**: Times New Roman, 12pt
- **Spacing**: Double-spaced
- **Margins**: 1 inch on all sides
- **Citations**: APA format
- **Quality**: Clear, concise, well-organized, error-free

---

## 🎯 Key Concepts to Master

### 1. Boolean Expressions
- Comparison operators: `==`, `!=`, `<`, `>`, `<=`, `>=`
- Logical operators: `and`, `or`, `not`
- Truth tables
- Short-circuit evaluation

### 2. Conditional Statements

**Simple Conditional**:
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

**Chained Conditional** (if-elif-else):
```python
if condition1:
    # execute if condition1 is True
elif condition2:
    # execute if condition2 is True
else:
    # execute if all conditions are False
```

**Nested Conditional**:
```python
if condition1:
    if condition2:
        # execute if both True
    else:
        # execute if condition1 True, condition2 False
else:
    # execute if condition1 False
```

### 3. Recursion
- **Definition**: Function that calls itself
- **Base case**: Condition that stops recursion
- **Recursive case**: Function calls itself with modified argument
- **Stack diagram**: Visual representation of function calls

**Recursion Requirements**:
1. Must have a base case
2. Must make progress toward base case
3. Must call itself

### 4. Floor Division and Modulus
- **Floor division** (`//`): Returns quotient without remainder
  - `7 // 2` → `3`
- **Modulus** (`%`): Returns remainder
  - `7 % 2` → `1`

### 5. Error Types

**Syntax Errors**:
- Broken language rules
- Program won't run
- Example: Missing colon, incorrect indentation

**Runtime Errors**:
- Occur during execution
- Program crashes
- Example: Division by zero, undefined variable

**Semantic Errors**:
- Program runs but produces wrong output
- Logic flaws
- Example: Wrong formula, incorrect condition

---

## 📊 Unit 3 Checklist

### Reading & Learning
- [ ] Read Think Python Chapter 5 (Conditionals and recursion)
- [ ] Read Think Python Appendix A (Debugging)
- [ ] Watch kjdElectronics video on Booleans and Conditionals
- [ ] Watch Bro Code video on Exception Handling
- [ ] Complete learning notes for all topics
- [ ] Review quick study guide

### Discussion Assignment
- [ ] Write explanation of chained vs nested conditionals
- [ ] Create original example of chained conditional
- [ ] Create original example of nested conditional
- [ ] Describe strategy for avoiding nested conditionals
- [ ] Show nested conditional simplified to single conditional
- [ ] Write discussion question for peers
- [ ] Post discussion (at least 150 words)
- [ ] Reply to 2 classmates

### Programming Assignment
- [ ] Write `countup` recursive function
- [ ] Write main program with keyboard input
- [ ] Test with positive number
- [ ] Test with negative number
- [ ] Test with zero
- [ ] Explain choice for zero input
- [ ] Write division program with error
- [ ] Implement error handling (try-except)
- [ ] Test and capture error output
- [ ] Write technical explanations (200+ words)
- [ ] Format document (Times New Roman 12pt, double-spaced)
- [ ] Add APA citations and references
- [ ] Proofread for errors
- [ ] Export to DOCX
- [ ] Submit assignment

### Quizzes
- [ ] Complete Self-Quiz (practice, not graded)
- [ ] Review Self-Quiz results
- [ ] Complete Graded Quiz (counts toward final grade)

---

## 💡 Study Tips

### For Conditionals
1. Draw flowcharts to visualize logic
2. Test each branch of conditional
3. Use boolean expressions to simplify nested conditionals
4. Remember: chained conditionals check conditions in order

### For Recursion
1. Always identify base case first
2. Ensure recursive case makes progress toward base case
3. Draw stack diagrams to understand execution
4. Test with small inputs first
5. Watch for infinite recursion

### For Error Handling
1. Use try-except blocks for runtime errors
2. Provide meaningful error messages
3. Test edge cases (zero, negative, empty input)
4. Don't catch errors you can't handle

---

## 🔑 Important Formulas & Patterns

### Recursion Pattern
```python
def recursive_function(n):
    # Base case
    if base_condition:
        return base_value
    # Recursive case
    else:
        return recursive_function(modified_n)
```

### Error Handling Pattern
```python
try:
    # Code that might cause error
    risky_operation()
except ErrorType:
    # Handle specific error
    print("Error message")
```

### Simplifying Nested Conditionals
**Nested** (harder to read):
```python
if x > 0:
    if y > 0:
        print("Both positive")
```

**Simplified** (easier to read):
```python
if x > 0 and y > 0:
    print("Both positive")
```

---

## 📅 Important Dates

- **Discussion Opens**: Check course homepage
- **Discussion Due**: Check course homepage
- **Assignment Due**: Check course homepage
- **Graded Quiz**: Check course homepage

---

## 🎓 Learning Outcomes

By completing this unit, you will:
- Master conditional logic in Python
- Understand and implement recursive functions
- Handle user input effectively
- Debug syntax, runtime, and semantic errors
- Write clean, readable conditional code
- Apply error handling techniques

---

**Note**: All code must be original and properly explained. Follow APA citation guidelines for all references.

---

**Last Updated**: February 2026  
**Status**: In Progress
