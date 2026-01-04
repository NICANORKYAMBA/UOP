# Unit 3 Learning Notes - Part 1: Boolean Algebra Laws

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 3 - Boolean Algebra and Logic Gates
- **Topic**: Boolean Algebra Laws and De Morgan's Theorems
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [Introduction to Boolean Algebra](#introduction-to-boolean-algebra)
2. [Basic Boolean Operations](#basic-boolean-operations)
3. [Laws of Boolean Algebra](#laws-of-boolean-algebra)
4. [De Morgan's Theorems](#de-morgans-theorems)
5. [Boolean Expression Simplification](#boolean-expression-simplification)

---

## Introduction to Boolean Algebra

### What is Boolean Algebra?

**Boolean Algebra** is a mathematical system for manipulating logical expressions using variables that can have only two values: **TRUE (1)** or **FALSE (0)**.

**Inventor**: George Boole (1854)

**Purpose**: Foundation for digital logic design and computer circuits

### Boolean Variables

- **Values**: 0 (FALSE, LOW, OFF) or 1 (TRUE, HIGH, ON)
- **Notation**: Usually uppercase letters (A, B, C, X, Y, Z)

**Example**:
- A = 1 (switch is ON)
- B = 0 (switch is OFF)

### Applications

1. **Digital Circuits**: Logic gates, processors, memory
2. **Computer Programming**: Conditional statements, logic operations
3. **Database Queries**: Search conditions
4. **Search Engines**: Query optimization
5. **Circuit Design**: Simplification and optimization

---

## Basic Boolean Operations

### 1. AND Operation (·)

**Symbol**: · or ∧ or no symbol (AB means A·B)

**Definition**: Output is 1 only when ALL inputs are 1

**Truth Table**:
```
A | B | A·B
--|---|----
0 | 0 | 0
0 | 1 | 0
1 | 0 | 0
1 | 1 | 1
```

**Analogy**: Series circuit (both switches must be ON)

**Example**: A·B = 1 only when A=1 AND B=1

---

### 2. OR Operation (+)

**Symbol**: + or ∨

**Definition**: Output is 1 when AT LEAST ONE input is 1

**Truth Table**:
```
A | B | A+B
--|---|----
0 | 0 | 0
0 | 1 | 1
1 | 0 | 1
1 | 1 | 1
```

**Analogy**: Parallel circuit (either switch can be ON)

**Example**: A+B = 1 when A=1 OR B=1 OR both

---

### 3. NOT Operation (′)

**Symbol**: ′ or ¯ or ~

**Definition**: Output is opposite of input (complement)

**Truth Table**:
```
A | A′
--|---
0 | 1
1 | 0
```

**Analogy**: Inverter switch

**Example**: If A=1, then A′=0

---

## Laws of Boolean Algebra

### 1. Commutative Law

**Definition**: Order of variables doesn't matter

**AND Form**: A·B = B·A

**OR Form**: A+B = B+A

**Example**:
```
A·B = B·A
If A=1, B=0: 1·0 = 0·1 = 0 ✓
```

**Application**: Rearrange terms for simplification

---

### 2. Associative Law

**Definition**: Grouping of variables doesn't matter

**AND Form**: (A·B)·C = A·(B·C)

**OR Form**: (A+B)+C = A+(B+C)

**Example**:
```
(A·B)·C = A·(B·C)
If A=1, B=1, C=0:
(1·1)·0 = 1·0 = 0
1·(1·0) = 1·0 = 0 ✓
```

**Application**: Remove or add parentheses

---

### 3. Distributive Law

**Definition**: Distribute one operation over another

**AND over OR**: A·(B+C) = (A·B)+(A·C)

**OR over AND**: A+(B·C) = (A+B)·(A+C)

**Example**:
```
A·(B+C) = (A·B)+(A·C)
If A=1, B=0, C=1:
1·(0+1) = 1·1 = 1
(1·0)+(1·1) = 0+1 = 1 ✓
```

**Application**: Factor or expand expressions

---

### 4. Identity Law

**Definition**: Identity elements for AND and OR

**AND Identity**: A·1 = A

**OR Identity**: A+0 = A

**Example**:
```
A·1 = A (ANDing with 1 gives original value)
A+0 = A (ORing with 0 gives original value)
```

**Application**: Simplify expressions with constants

---

### 5. Null (Dominance) Law

**Definition**: Null elements for AND and OR

**AND Null**: A·0 = 0

**OR Null**: A+1 = 1

**Example**:
```
A·0 = 0 (ANDing with 0 always gives 0)
A+1 = 1 (ORing with 1 always gives 1)
```

**Application**: Eliminate terms

---

### 6. Idempotent Law

**Definition**: Variable with itself

**AND Form**: A·A = A

**OR Form**: A+A = A

**Example**:
```
A·A = A (1·1=1, 0·0=0)
A+A = A (1+1=1, 0+0=0)
```

**Application**: Eliminate duplicate terms

---

### 7. Complement Law

**Definition**: Variable with its complement

**AND Form**: A·A′ = 0

**OR Form**: A+A′ = 1

**Example**:
```
A·A′ = 0 (1·0=0, 0·1=0)
A+A′ = 1 (1+0=1, 0+1=1)
```

**Application**: Simplify contradictory terms

---

### 8. Involution (Double Negation) Law

**Definition**: Complement of complement

**Form**: (A′)′ = A

**Example**:
```
If A=1: A′=0, (A′)′=1 ✓
If A=0: A′=1, (A′)′=0 ✓
```

**Application**: Remove double negations

---

### 9. Absorption Law

**Definition**: Absorb redundant terms

**Form 1**: A+(A·B) = A

**Form 2**: A·(A+B) = A

**Proof of Form 1**:
```
A+(A·B) = A·1 + A·B    (Identity)
        = A·(1+B)      (Distributive)
        = A·1          (Null law: 1+B=1)
        = A            (Identity)
```

**Example**:
```
A+(A·B) = A
If A=1: 1+(1·B) = 1+B = 1 ✓
If A=0: 0+(0·B) = 0+0 = 0 ✓
```

**Application**: Eliminate redundant terms

---

### 10. Consensus Theorem

**Definition**: Eliminate redundant consensus terms

**Form**: (A·B)+(A′·C)+(B·C) = (A·B)+(A′·C)

**Explanation**: B·C term is redundant (consensus of first two terms)

**Application**: Advanced simplification

---

### Boolean Algebra Laws Summary Table

| Law | AND Form | OR Form |
|-----|----------|---------|
| **Commutative** | A·B = B·A | A+B = B+A |
| **Associative** | (A·B)·C = A·(B·C) | (A+B)+C = A+(B+C) |
| **Distributive** | A·(B+C) = A·B+A·C | A+(B·C) = (A+B)·(A+C) |
| **Identity** | A·1 = A | A+0 = A |
| **Null** | A·0 = 0 | A+1 = 1 |
| **Idempotent** | A·A = A | A+A = A |
| **Complement** | A·A′ = 0 | A+A′ = 1 |
| **Involution** | (A′)′ = A | (A′)′ = A |
| **Absorption** | A·(A+B) = A | A+(A·B) = A |

---

## De Morgan's Theorems

### Overview

**De Morgan's Theorems** provide rules for negating AND and OR operations.

**Inventor**: Augustus De Morgan (1847)

**Importance**: Essential for circuit simplification and logic transformation

---

### Theorem 1: NOT of AND

**Statement**: The complement of an AND operation equals the OR of complements

**Formula**: (A·B)′ = A′+B′

**In Words**: "NOT (A AND B) = (NOT A) OR (NOT B)"

**Truth Table Proof**:
```
A | B | A·B | (A·B)′ | A′ | B′ | A′+B′
--|---|-----|--------|----|----|-------
0 | 0 |  0  |   1    | 1  | 1  |   1   ✓
0 | 1 |  0  |   1    | 1  | 0  |   1   ✓
1 | 0 |  0  |   1    | 0  | 1  |   1   ✓
1 | 1 |  1  |   0    | 0  | 0  |   0   ✓
```

**Example**:
```
(A·B)′ = A′+B′
If A=1, B=1: (1·1)′ = 1′ = 0
             1′+1′ = 0+0 = 0 ✓
```

---

### Theorem 2: NOT of OR

**Statement**: The complement of an OR operation equals the AND of complements

**Formula**: (A+B)′ = A′·B′

**In Words**: "NOT (A OR B) = (NOT A) AND (NOT B)"

**Truth Table Proof**:
```
A | B | A+B | (A+B)′ | A′ | B′ | A′·B′
--|---|-----|--------|----|----|-------
0 | 0 |  0  |   1    | 1  | 1  |   1   ✓
0 | 1 |  1  |   0    | 1  | 0  |   0   ✓
1 | 0 |  1  |   0    | 0  | 1  |   0   ✓
1 | 1 |  1  |   0    | 0  | 0  |   0   ✓
```

**Example**:
```
(A+B)′ = A′·B′
If A=0, B=0: (0+0)′ = 0′ = 1
             0′·0′ = 1·1 = 1 ✓
```

---

### De Morgan's Theorems - Extended Forms

**Three Variables**:
- (A·B·C)′ = A′+B′+C′
- (A+B+C)′ = A′·B′·C′

**General Form (n variables)**:
- (A₁·A₂·...·Aₙ)′ = A₁′+A₂′+...+Aₙ′
- (A₁+A₂+...+Aₙ)′ = A₁′·A₂′·...·Aₙ′

---

### How to Apply De Morgan's Theorems

**Step-by-Step Process**:

1. **Break the bar**: Remove the overbar (NOT)
2. **Change the operator**: AND ↔ OR
3. **Complement each variable**: A → A′

**Example 1**: Simplify (A·B)′

```
Step 1: Break the bar over A·B
Step 2: Change · to +
Step 3: Complement each: A → A′, B → B′
Result: A′+B′
```

**Example 2**: Simplify (A+B+C)′

```
Step 1: Break the bar over A+B+C
Step 2: Change + to ·
Step 3: Complement each: A → A′, B → B′, C → C′
Result: A′·B′·C′
```

**Example 3**: Simplify (A′·B)′

```
Step 1: Break the bar
Step 2: Change · to +
Step 3: Complement each: A′ → A, B → B′
Result: A+B′
```

---

### Relationship to Other Boolean Laws

**De Morgan's + Involution**:
```
(A·B)′ = A′+B′         (De Morgan's)
((A·B)′)′ = (A′+B′)′   (Apply NOT to both sides)
A·B = (A′+B′)′         (Involution: double negation)
```

**De Morgan's + Distributive**:
```
A·(B+C) = A·B + A·C    (Distributive)
(A·(B+C))′ = (A·B + A·C)′  (Apply NOT)
A′+(B+C)′ = (A·B)′·(A·C)′  (De Morgan's)
A′+(B′·C′) = (A′+B′)·(A′+C′)  (De Morgan's again)
```

---

### Practical Applications of De Morgan's

**1. Circuit Simplification**:
- Convert NAND to OR with inverted inputs
- Convert NOR to AND with inverted inputs

**2. Logic Transformation**:
- Change gate types for implementation
- Reduce gate count

**3. Expression Simplification**:
- Remove complex negations
- Simplify nested expressions

**Example Application**:
```
Original: (A·B)′·(C+D)′
Apply De Morgan's:
= (A′+B′)·(C′·D′)
= A′·C′·D′ + B′·C′·D′  (Distributive)
```

---

## Boolean Expression Simplification

### Simplification Process

**Goal**: Reduce expression to minimum number of terms and literals

**Benefits**:
- Fewer logic gates required
- Lower cost
- Faster circuits
- Less power consumption

---

### Simplification Techniques

#### 1. Algebraic Manipulation

**Use Boolean laws systematically**

**Example 1**: Simplify A·B + A·B′

```
A·B + A·B′
= A·(B+B′)      (Distributive law)
= A·1           (Complement law: B+B′=1)
= A             (Identity law: A·1=A)
```

**Example 2**: Simplify A + A′·B

```
A + A′·B
= A·1 + A′·B         (Identity: A=A·1)
= A·(1+B) + A′·B     (Distributive)
= A·1 + A′·B         (Null: 1+B=1)
= A + A′·B           (Back to start, try different approach)

Alternative:
= (A+A′)·(A+B)       (Distributive OR over AND)
= 1·(A+B)            (Complement: A+A′=1)
= A+B                (Identity: 1·X=X)
```

**Example 3**: Simplify (A·B) + (A′·C) + (B·C)

```
(A·B) + (A′·C) + (B·C)
= (A·B) + (A′·C) + (B·C)·1                    (Identity)
= (A·B) + (A′·C) + (B·C)·(A+A′)               (Complement)
= (A·B) + (A′·C) + (A·B·C) + (A′·B·C)         (Distributive)
= (A·B)·(1+C) + (A′·C)·(1+B)                  (Factor)
= (A·B)·1 + (A′·C)·1                          (Null: 1+X=1)
= (A·B) + (A′·C)                              (Identity)
```

---

#### 2. Truth Table Method

**Process**:
1. Create truth table for expression
2. Identify rows where output = 1
3. Write sum-of-products (SOP) form
4. Simplify using Boolean laws

**Example**: Simplify expression with truth table

```
A | B | C | Output
--|---|---|-------
0 | 0 | 0 |   0
0 | 0 | 1 |   1    → A′·B′·C
0 | 1 | 0 |   0
0 | 1 | 1 |   1    → A′·B·C
1 | 0 | 0 |   0
1 | 0 | 1 |   1    → A·B′·C
1 | 1 | 0 |   0
1 | 1 | 1 |   1    → A·B·C

SOP: A′·B′·C + A′·B·C + A·B′·C + A·B·C
Simplify: C·(A′·B′ + A′·B + A·B′ + A·B)
        = C·(A′·(B′+B) + A·(B′+B))
        = C·(A′·1 + A·1)
        = C·(A′+A)
        = C·1
        = C
```

---

### Simplification Examples

**Example 1**: (I·A) + (L′·A)

```
Step 1: Factor out common term A
(I·A) + (L′·A) = A·(I+L′)    (Distributive law)

Result: A·(I+L′)
```

**Example 2**: A·B + A·B′ + A′·B

```
Step 1: Factor A from first two terms
= A·(B+B′) + A′·B

Step 2: Apply complement law
= A·1 + A′·B

Step 3: Apply identity law
= A + A′·B

Step 4: Apply absorption variant
= A + B

Result: A + B
```

**Example 3**: (A+B)·(A+B′)

```
Step 1: Apply distributive law
= A·A + A·B′ + B·A + B·B′

Step 2: Apply idempotent and complement
= A + A·B′ + A·B + 0

Step 3: Factor A
= A·(1+B′+B)

Step 4: Apply null law
= A·1

Step 5: Apply identity
= A

Result: A
```

---

## Key Takeaways

1. **Boolean Algebra**: Mathematical system with two values (0, 1)
2. **Basic Operations**: AND (·), OR (+), NOT (′)
3. **Key Laws**: Commutative, Associative, Distributive, Identity, Null, Complement
4. **De Morgan's Theorems**: (A·B)′ = A′+B′ and (A+B)′ = A′·B′
5. **Simplification**: Use laws systematically to reduce expressions
6. **Applications**: Digital circuit design, logic optimization

---

## Study Tips

1. **Memorize laws**: Create flashcards for each law
2. **Practice simplification**: Work through examples daily
3. **Verify with truth tables**: Check your simplifications
4. **Understand De Morgan's**: Break bar, change operator, complement variables
5. **Look for patterns**: Common terms to factor, complements to eliminate

---

## References

ALL ABOUT ELECTRONICS. (2021, October 16). *The laws of Boolean algebra explained* [Video]. YouTube.

ALL ABOUT ELECTRONICS. (2021b, October 23). *De Morgan's law in Boolean algebra explained (with solved examples)* [Video]. YouTube.

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley & Sons, Incorporated.

Neso Academy. (2021, September 15). *De Morgan's law in Boolean algebra explained* [Video]. YouTube.

---

**Next**: Part 2 - Logic Gates and Truth Tables
