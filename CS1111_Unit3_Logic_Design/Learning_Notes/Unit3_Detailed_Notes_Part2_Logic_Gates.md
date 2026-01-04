# Unit 3 Learning Notes - Part 2: Logic Gates and Truth Tables

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 3 - Boolean Algebra and Logic Gates
- **Topic**: Logic Gates, Truth Tables, and Circuit Design
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [Introduction to Logic Gates](#introduction-to-logic-gates)
2. [Basic Logic Gates](#basic-logic-gates)
3. [Universal Logic Gates](#universal-logic-gates)
4. [Truth Tables](#truth-tables)
5. [Logic Circuit Design](#logic-circuit-design)
6. [Boolean Expression Equivalence](#boolean-expression-equivalence)

---

## Introduction to Logic Gates

### What is a Logic Gate?

A **logic gate** is an electronic circuit that performs a logical operation on one or more binary inputs to produce a single binary output.

**Function**: Physical implementation of Boolean operations

**Building Blocks**: Transistors (MOSFETs in modern circuits)

### Importance

- **Foundation of Digital Circuits**: All digital systems built from logic gates
- **Computer Processors**: Billions of gates in modern CPUs
- **Memory**: Storage circuits use logic gates
- **Control Systems**: Decision-making circuits

### Gate Representation

**Standard Symbols**: IEEE/ANSI standard symbols

**Components**:
- **Inputs**: Left side (A, B, C, etc.)
- **Output**: Right side (Y, F, Q, etc.)
- **Gate Symbol**: Distinctive shape for each gate type

---

## Basic Logic Gates

### 1. AND Gate

**Symbol**:
```
    A ──┐
        │\
        │ )── Y
        │/
    B ──┘
```

**Boolean Expression**: Y = A·B or Y = AB

**Operation**: Output is 1 only when ALL inputs are 1

**Truth Table**:
```
A | B | Y = A·B
--|---|--------
0 | 0 |   0
0 | 1 |   0
1 | 0 |   0
1 | 1 |   1
```

**Characteristics**:
- **Inputs**: 2 or more
- **Output**: 1 only when all inputs are 1
- **Analogy**: Series switches (all must be closed)

**Applications**:
- Enable/disable circuits
- Masking operations
- Conditional logic

**Example**: Door lock system
- A = Valid key card
- B = Correct PIN
- Y = Door unlocks (only when both A=1 AND B=1)

---

### 2. OR Gate

**Symbol**:
```
    A ──┐
        │)
        │ )── Y
        │)
    B ──┘
```

**Boolean Expression**: Y = A+B

**Operation**: Output is 1 when AT LEAST ONE input is 1

**Truth Table**:
```
A | B | Y = A+B
--|---|--------
0 | 0 |   0
0 | 1 |   1
1 | 0 |   1
1 | 1 |   1
```

**Characteristics**:
- **Inputs**: 2 or more
- **Output**: 1 when any input is 1
- **Analogy**: Parallel switches (any can be closed)

**Applications**:
- Multiple trigger sources
- Alarm systems
- Alternative paths

**Example**: Emergency stop system
- A = Button 1 pressed
- B = Button 2 pressed
- Y = System stops (when either button pressed)

---

### 3. NOT Gate (Inverter)

**Symbol**:
```
    A ──▷○── Y
```

**Boolean Expression**: Y = A′ or Y = Ā or Y = ~A

**Operation**: Output is opposite of input

**Truth Table**:
```
A | Y = A′
--|-------
0 |   1
1 |   0
```

**Characteristics**:
- **Inputs**: 1 only
- **Output**: Complement of input
- **Analogy**: Inverter switch

**Applications**:
- Signal inversion
- Complement generation
- Active-low signals

**Example**: Normally closed switch
- A = Switch open (0)
- Y = Light ON (1)

---

### 4. Buffer Gate

**Symbol**:
```
    A ──▷── Y
```

**Boolean Expression**: Y = A

**Operation**: Output equals input (no inversion)

**Truth Table**:
```
A | Y = A
--|------
0 |  0
1 |  1
```

**Purpose**:
- Signal amplification
- Isolation
- Delay introduction
- Drive capability

---

## Universal Logic Gates

### 5. NAND Gate (NOT-AND)

**Symbol**:
```
    A ──┐
        │\
        │ )○── Y
        │/
    B ──┘
```

**Boolean Expression**: Y = (A·B)′ or Y = A↑B

**Operation**: Output is 0 only when ALL inputs are 1 (opposite of AND)

**Truth Table**:
```
A | B | A·B | Y = (A·B)′
--|---|-----|------------
0 | 0 |  0  |     1
0 | 1 |  0  |     1
1 | 0 |  0  |     1
1 | 1 |  1  |     0
```

**Characteristics**:
- **Universal Gate**: Can implement any Boolean function
- **Output**: Inverted AND
- **Most Common**: Easier to manufacture than AND

**Why Universal?**

Can create all other gates:

**NOT from NAND**:
```
A ──┐
    │\
    │ )○── A′
    │/
A ──┘
(Connect both inputs together)
```

**AND from NAND**:
```
A ──┐         ┌──▷○── A·B
    │\    ┌───┤
    │ )○──┤   └──▷○
    │/    └───┤
B ──┘         
(NAND followed by NOT)
```

**OR from NAND**:
```
A ──▷○──┐
        │\
        │ )○── A+B
        │/
B ──▷○──┘
(NOT inputs, then NAND)
```

**Applications**:
- Entire circuits built with only NAND gates
- Memory cells (flip-flops)
- Arithmetic circuits

---

### 6. NOR Gate (NOT-OR)

**Symbol**:
```
    A ──┐
        │)
        │ )○── Y
        │)
B ──┘
```

**Boolean Expression**: Y = (A+B)′ or Y = A↓B

**Operation**: Output is 1 only when ALL inputs are 0 (opposite of OR)

**Truth Table**:
```
A | B | A+B | Y = (A+B)′
--|---|-----|------------
0 | 0 |  0  |     1
0 | 1 |  1  |     0
1 | 0 |  1  |     0
1 | 1 |  1  |     0
```

**Characteristics**:
- **Universal Gate**: Can implement any Boolean function
- **Output**: Inverted OR

**Why Universal?**

Can create all other gates:

**NOT from NOR**:
```
A ──┐
    │)
    │ )○── A′
    │)
A ──┘
(Connect both inputs together)
```

**OR from NOR**:
```
A ──┐         ┌──▷○── A+B
    │)    ┌───┤
    │ )○──┤   └──▷○
    │)    └───┤
B ──┘         
(NOR followed by NOT)
```

**AND from NOR**:
```
A ──▷○──┐
        │)
        │ )○── A·B
        │)
B ──▷○──┘
(NOT inputs, then NOR)
```

**Applications**:
- Alternative to NAND for circuit design
- Memory cells
- Control logic

---

### 7. XOR Gate (Exclusive-OR)

**Symbol**:
```
    A ──┐
        │))
        │  )── Y
        │))
    B ──┘
```

**Boolean Expression**: Y = A⊕B = A′·B + A·B′

**Operation**: Output is 1 when inputs are DIFFERENT

**Truth Table**:
```
A | B | Y = A⊕B
--|---|--------
0 | 0 |   0
0 | 1 |   1
1 | 0 |   1
1 | 1 |   0
```

**Characteristics**:
- **Output**: 1 when odd number of 1s
- **Comparison**: Detects difference
- **Reversible**: A⊕B = B⊕A

**Properties**:
- A⊕0 = A (Identity)
- A⊕1 = A′ (Complement)
- A⊕A = 0 (Self-inverse)
- A⊕A′ = 1

**Applications**:
- Parity checking
- Error detection
- Arithmetic (half-adder)
- Encryption
- Comparators

**Example**: Parity bit generator
- Count 1s in data
- XOR all bits
- Result is parity bit

---

### 8. XNOR Gate (Exclusive-NOR)

**Symbol**:
```
    A ──┐
        │))
        │  )○── Y
        │))
    B ──┘
```

**Boolean Expression**: Y = (A⊕B)′ = A·B + A′·B′

**Operation**: Output is 1 when inputs are SAME (equality detector)

**Truth Table**:
```
A | B | Y = (A⊕B)′
--|---|------------
0 | 0 |     1
0 | 1 |     0
1 | 0 |     0
1 | 1 |     1
```

**Characteristics**:
- **Output**: 1 when even number of 1s
- **Equality**: Detects same values
- **Complement of XOR**

**Applications**:
- Equality comparator
- Error detection
- Parity checking

---

## Logic Gate Summary Table

| Gate | Symbol | Expression | Output = 1 when | Universal? |
|------|--------|------------|-----------------|------------|
| **AND** | D-shape | A·B | All inputs 1 | No |
| **OR** | Curved | A+B | Any input 1 | No |
| **NOT** | Triangle+circle | A′ | Input is 0 | No |
| **NAND** | D-shape+circle | (A·B)′ | Any input 0 | Yes |
| **NOR** | Curved+circle | (A+B)′ | All inputs 0 | Yes |
| **XOR** | Double-curved | A⊕B | Inputs different | No |
| **XNOR** | Double-curved+circle | (A⊕B)′ | Inputs same | No |

---

## Truth Tables

### What is a Truth Table?

A **truth table** is a table showing all possible input combinations and corresponding outputs for a logic circuit or Boolean expression.

**Purpose**:
- Verify circuit behavior
- Compare expressions
- Design circuits
- Debug logic

### Creating Truth Tables

**Steps**:
1. List all input variables
2. Calculate number of rows: 2^n (n = number of inputs)
3. List all input combinations (binary counting)
4. Calculate output for each combination

**Example**: 2 inputs (A, B)
- Rows needed: 2² = 4
- Combinations: 00, 01, 10, 11

**Example**: 3 inputs (A, B, C)
- Rows needed: 2³ = 8
- Combinations: 000, 001, 010, 011, 100, 101, 110, 111

---

### Truth Table Examples

**Example 1**: Y = A·B + A·C

```
A | B | C | A·B | A·C | Y = A·B + A·C
--|---|---|-----|-----|---------------
0 | 0 | 0 |  0  |  0  |      0
0 | 0 | 1 |  0  |  0  |      0
0 | 1 | 0 |  0  |  0  |      0
0 | 1 | 1 |  0  |  0  |      0
1 | 0 | 0 |  0  |  0  |      0
1 | 0 | 1 |  0  |  1  |      1
1 | 1 | 0 |  1  |  0  |      1
1 | 1 | 1 |  1  |  1  |      1
```

**Example 2**: Y = (A+B)·C

```
A | B | C | A+B | Y = (A+B)·C
--|---|---|-----|-------------
0 | 0 | 0 |  0  |      0
0 | 0 | 1 |  0  |      0
0 | 1 | 0 |  1  |      0
0 | 1 | 1 |  1  |      1
1 | 0 | 0 |  1  |      0
1 | 0 | 1 |  1  |      1
1 | 1 | 0 |  1  |      0
1 | 1 | 1 |  1  |      1
```

**Example 3**: Y = A′·B + A·B′ (XOR)

```
A | B | A′ | B′ | A′·B | A·B′ | Y
--|---|----|----|------|------|---
0 | 0 | 1  | 1  |  0   |  0   | 0
0 | 1 | 1  | 0  |  1   |  0   | 1
1 | 0 | 0  | 1  |  0   |  1   | 1
1 | 1 | 0  | 0  |  0   |  0   | 0
```

---

## Logic Circuit Design

### From Boolean Expression to Circuit

**Process**:
1. Identify operations (AND, OR, NOT)
2. Draw gates for each operation
3. Connect inputs and outputs
4. Label all signals

**Example 1**: Y = A·B + C

```
Step 1: Identify operations
- AND: A·B
- OR: (A·B) + C

Step 2: Draw circuit
A ──┐
    │\
    │ )──┐
    │/   │
B ──┘    │)
         │ )── Y
         │)
C ───────┘
```

**Example 2**: Y = (A+B)·C′

```
Step 1: Identify operations
- OR: A+B
- NOT: C′
- AND: (A+B)·C′

Step 2: Draw circuit
A ──┐
    │)
    │ )──┐
    │)   │\
B ──┘    │ )── Y
         │/
C ──▷○───┘
```

**Example 3**: Y = A·(I+L′)

```
Step 1: Identify operations
- NOT: L′
- OR: I+L′
- AND: A·(I+L′)

Step 2: Draw circuit
         ┌──┐
I ───────┤  │)
         │  │ )──┐
L ──▷○───┤  │)   │\
         └──┘    │ )── Y
                 │/
A ───────────────┘
```

---

### From Truth Table to Circuit

**Process**:
1. Write Sum-of-Products (SOP) from truth table
2. Simplify using Boolean algebra
3. Draw circuit

**Example**: Design circuit for truth table

```
A | B | Y
--|---|---
0 | 0 | 0
0 | 1 | 1
1 | 0 | 1
1 | 1 | 0

Step 1: SOP (rows where Y=1)
Y = A′·B + A·B′

Step 2: Recognize as XOR
Y = A⊕B

Step 3: Draw XOR gate
A ──┐
    │))
    │  )── Y
    │))
B ──┘
```

---

## Boolean Expression Equivalence

### What is Equivalence?

Two Boolean expressions are **equivalent** if they produce the same output for all input combinations.

**Methods to Prove Equivalence**:
1. Algebraic manipulation
2. Truth table comparison
3. Logic circuit analysis

---

### Method 1: Algebraic Manipulation

**Process**: Transform one expression into the other using Boolean laws

**Example 1**: Prove (I·A) + (L′·A) = A·(I+L′)

```
Left side: (I·A) + (L′·A)
= A·I + A·L′           (Commutative)
= A·(I+L′)             (Distributive)
= Right side ✓
```

**Example 2**: Prove A+A·B = A

```
Left side: A+A·B
= A·1 + A·B            (Identity: A=A·1)
= A·(1+B)              (Distributive)
= A·1                  (Null: 1+B=1)
= A                    (Identity)
= Right side ✓
```

**Example 3**: Prove (A+B)·(A+B′) = A

```
Left side: (A+B)·(A+B′)
= A·A + A·B′ + B·A + B·B′    (Distributive)
= A + A·B′ + A·B + 0         (Idempotent, Complement)
= A·(1+B′+B)                 (Factor)
= A·1                        (Null)
= A                          (Identity)
= Right side ✓
```

---

### Method 2: Truth Table Comparison

**Process**: Create truth tables for both expressions and compare outputs

**Example**: Verify (I·A) + (L′·A) = A·(I+L′)

**Expression 1**: (I·A) + (L′·A)
```
I | L | A | I·A | L′ | L′·A | (I·A)+(L′·A)
--|---|---|-----|-------|------|-------------
0 | 0 | 0 |  0  |  1  |  0   |      0
0 | 0 | 1 |  0  |  1  |  1   |      1
0 | 1 | 0 |  0  |  0  |  0   |      0
0 | 1 | 1 |  0  |  0  |  0   |      0
1 | 0 | 0 |  0  |  1  |  0   |      0
1 | 0 | 1 |  1  |  1  |  1   |      1
1 | 1 | 0 |  0  |  0  |  0   |      0
1 | 1 | 1 |  1  |  0  |  0   |      1
```

**Expression 2**: A·(I+L′)
```
I | L | A | L′ | I+L′ | A·(I+L′)
--|---|---|-------|------|----------
0 | 0 | 0 |  1  |  1   |    0
0 | 0 | 1 |  1  |  1   |    1
0 | 1 | 0 |  0  |  0   |    0
0 | 1 | 1 |  0  |  0   |    0
1 | 0 | 0 |  1  |  1   |    0
1 | 0 | 1 |  1  |  1   |    1
1 | 1 | 0 |  0  |  1   |    0
1 | 1 | 1 |  0  |  1   |    1
```

**Comparison**: Both outputs identical → Expressions are equivalent ✓

---

### Method 3: Logic Circuit Analysis

**Process**: Draw circuits for both expressions and verify same behavior

**Example**: Compare circuits for (I·A) + (L′·A) and A·(I+L′)

**Circuit 1**: (I·A) + (L′·A)
```
I ──┐
    │\
    │ )──┐
    │/   │
A ──┘    │)
         │ )── Y
L ──▷○─┐ │)
       │\│
       │ )
       │/
A ─────┘
```

**Circuit 2**: A·(I+L′)
```
I ───────┐
         │)
         │ )──┐
L ──▷○───┤)   │\
         └────┤ )── Y
              │/
A ────────────┘
```

**Analysis**: Circuit 2 uses fewer gates (more efficient) but produces same output

---

## Practical Application Example

### Security Access Control System

**Scenario**: Lab door access control

**Inputs**:
- I = ID Scanned (1 = valid, 0 = invalid)
- L = Lab Available (1 = available, 0 = in use)
- A = Admin Override (1 = override, 0 = no override)

**Original Expression**: (I·A) + (L′·A)

**Simplified Expression**: A·(I+L′)

**Truth Table**:
```
I | L | A | Original | Simplified | Door Unlocks?
--|---|---|----------|------------|---------------
0 | 0 | 0 |    0     |     0      | No
0 | 0 | 1 |    1     |     1      | Yes (admin override, lab in use)
0 | 1 | 0 |    0     |     0      | No
0 | 1 | 1 |    0     |     0      | No (no valid ID)
1 | 0 | 0 |    0     |     0      | No
1 | 0 | 1 |    1     |     1      | Yes (valid ID + admin)
1 | 1 | 0 |    0     |     0      | No (no admin)
1 | 1 | 1 |    1     |     1      | Yes (valid ID + admin)
```

**Logic**: Door unlocks when:
- Admin override is active AND (Valid ID OR Lab is in use)

**Circuit Diagram** (Simplified):
```
         ┌──┐
I ───────┤  │)
         │  │ )──┐
L ──▷○───┤  │)   │\
         └──┘    │ )── Door Unlock
                 │/
A ───────────────┘
```

---

## Key Takeaways

1. **Logic Gates**: Physical implementation of Boolean operations
2. **Basic Gates**: AND, OR, NOT (fundamental building blocks)
3. **Universal Gates**: NAND and NOR can implement any function
4. **Truth Tables**: Show all input/output combinations
5. **Circuit Design**: Convert Boolean expressions to gate diagrams
6. **Equivalence**: Prove using algebra, truth tables, or circuit analysis

---

## Study Tips

1. **Memorize gate symbols**: Draw each gate from memory
2. **Practice truth tables**: Create tables for various expressions
3. **Simplify first**: Always simplify before drawing circuits
4. **Verify equivalence**: Use multiple methods to confirm
5. **Real-world thinking**: Apply to practical scenarios

---

## References

ALL ABOUT ELECTRONICS. (2021a, September 29). *What is logic gate? Logic gates explained* [Video]. YouTube.

Mr Bulmer's Learning Zone. (2024, September 6). *Logic gates and truth tables* [Video]. YouTube.

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley & Sons, Incorporated.

Neso Academy. (2021, September 20). *Logic gates, truth tables, Boolean algebra AND, OR, NOT, NAND & NOR* [Video]. YouTube.

Westcott, S., & Westcott, J. R. (2023). *Basic electronics: Theory and practice*. Mercury Learning & Information.

---

**End of Unit 3 Learning Notes**

**Summary**: You have covered:
- Boolean Algebra Laws and De Morgan's Theorems
- Logic Gates (AND, OR, NOT, NAND, NOR, XOR, XNOR)
- Truth Tables and Circuit Design
- Boolean Expression Equivalence

**Next Steps**: Complete Unit 3 assignment on security access control system!
