# CS1111 Unit 7: Quick Study Guide

## Programming Paradigms Comparison

| Aspect | Structured | Functional | Object-Oriented |
|--------|-----------|------------|-----------------|
| **Focus** | Procedures/Functions | Pure Functions | Objects (Data + Methods) |
| **Data** | Separate from functions | Immutable | Encapsulated in objects |
| **Code Reuse** | Function calls | Function composition | Inheritance |
| **Best For** | Small programs | Data transformation | Large systems |
| **Example Languages** | C, Pascal | Haskell, Lisp | Java, Python, C++ |

---

## Control Structures Quick Reference

### Sequencing
```
Step 1
Step 2
Step 3
```
- Linear execution
- Order matters

### Selection
```
IF condition:
    action1
ELSE:
    action2
```
- Decision-making
- Branching logic

### Iteration
```
WHILE condition:
    action
```
- Repetition
- Loop until condition false

---

## Algorithm Design Checklist

- [ ] Define inputs clearly
- [ ] Define expected outputs
- [ ] Identify edge cases (0, negative, max)
- [ ] Write pseudocode first
- [ ] Draw flowchart if complex
- [ ] Test with simple values
- [ ] Check boundary conditions

---

## Debugging Strategy

1. **Reproduce the Error**: Make it happen consistently
2. **Isolate**: Find which section has the bug
3. **Print Values**: Track variable changes
4. **Test Assumptions**: Verify what you think is true
5. **Fix**: Make minimal change
6. **Test Again**: Ensure fix works

---

## Common Logical Errors

| Error | Example | Fix |
|-------|---------|-----|
| Off-by-one | `FOR i = 1 to 10` (runs 10 times, not 11) | Check loop bounds |
| Uninitialized | Using `sum` before `sum = 0` | Initialize all variables |
| Wrong operator | `IF x = 5` instead of `IF x == 5` | Use correct comparison |
| Division by zero | `average = sum / count` when count = 0 | Check before dividing |
| Infinite loop | `WHILE x < 10` but x never increases | Update loop variable |

---

## Problem Analysis Template

**Problem:** [What needs to be solved?]

**Inputs:** [What data is needed?]

**Outputs:** [What results are expected?]

**Constraints:** [Any limitations?]

**Edge Cases:** [Special situations to handle?]

**Sub-problems:** [Break into smaller parts]

---

## Flowchart Symbols

- **Oval**: Start/End
- **Rectangle**: Process/Action
- **Diamond**: Decision (Yes/No)
- **Parallelogram**: Input/Output
- **Arrow**: Flow direction

---

## Key Formulas & Patterns

### Average Calculation
```
sum = 0
count = 0
FOR each item:
    sum = sum + item
    count = count + 1
average = sum / count  // Check count != 0!
```

### Finding Maximum
```
max = first_item
FOR each item:
    IF item > max:
        max = item
```

### Counting
```
count = 0
FOR each item:
    IF condition:
        count = count + 1
```

---

## Exam Tips

1. **Read Carefully**: Understand what's being asked
2. **Write Pseudocode**: Before coding, plan in plain language
3. **Test Edge Cases**: 0, negative, empty, maximum
4. **Show Your Work**: Partial credit for correct approach
5. **Check Your Logic**: Trace through with simple example
6. **Time Management**: Don't spend too long on one question

---

## Quick Definitions

**Algorithm**: Step-by-step procedure to solve a problem

**Pseudocode**: Algorithm written in plain language

**Encapsulation**: Bundling data and methods in OOP

**Inheritance**: Creating new classes from existing ones

**Immutability**: Data cannot be changed after creation

**Pure Function**: Same input always gives same output

**Logical Error**: Program runs but gives wrong results

**Iteration**: Repeating a process

**Selection**: Choosing between alternatives

**Sequencing**: Executing steps in order

---

## Memory Aids

**OOP Principles (APIE):**
- **A**bstraction
- **P**olymorphism
- **I**nheritance
- **E**ncapsulation

**Control Structures (SSI):**
- **S**equencing
- **S**election
- **I**teration

**Debugging Steps (RIFT):**
- **R**eproduce
- **I**solate
- **F**ix
- **T**est

---

## Practice Questions

1. What paradigm would you use for a banking system? Why?
2. Write pseudocode to find the largest of 3 numbers
3. What's wrong with this loop? `WHILE x > 0: Display x`
4. How would you debug a program that calculates wrong totals?
5. Draw a flowchart for determining if a number is even or odd

---

## Before the Exam

- [ ] Review all three paradigms
- [ ] Practice writing algorithms
- [ ] Draw flowcharts for common problems
- [ ] Understand difference between error types
- [ ] Know debugging techniques
- [ ] Practice tracing code execution
- [ ] Review edge cases for loops

---

## End of Quick Study Guide
