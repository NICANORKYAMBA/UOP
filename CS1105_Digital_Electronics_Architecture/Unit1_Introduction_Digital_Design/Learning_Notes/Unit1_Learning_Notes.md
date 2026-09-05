# Unit 1 Learning Notes: Boolean Algebra and Logic Gates

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Kyamba
**Topics:** Digital design basics, logic gates, Boolean algebra, Logisim setup

> My own study notes for Unit 1, in my own words from the reading (Ndjountche, 2016) and
> the unit videos. Sources are cited inline; full reference at the end.

---

## 1. Digital vs. Analog

Digital circuits work with two discrete voltage levels that we label **0** and **1**
(low/high, false/true). This binary representation makes circuits reliable and noise-
resistant compared with continuous analog signals, and it is the foundation for everything
from logic gates up to a full CPU (Ndjountche, 2016).

---

## 2. The Basic Logic Gates

A logic gate takes one or more binary inputs and produces one binary output according to a
fixed rule. The core gates:

| Gate | Symbol notation | Output is 1 when... | Boolean |
|------|-----------------|---------------------|---------|
| NOT (inverter) | A' | input is 0 (it inverts) | L = A' |
| AND | A · B | all inputs are 1 | L = A · B |
| OR | A + B | at least one input is 1 | L = A + B |
| NAND | (A · B)' | NOT of AND | L = (A · B)' |
| NOR | (A + B)' | NOT of OR | L = (A + B)' |
| XOR | A ⊕ B | inputs differ | L = A ⊕ B |
| XNOR | (A ⊕ B)' | inputs are the same | L = (A ⊕ B)' |

Key ideas I want to remember:
- **NAND and NOR are "universal" gates** — any logic function can be built from only NANDs
  or only NORs. This matters later for chip design.
- **XOR** is the workhorse of binary addition (it gives the sum bit).
- A **buffer** outputs its input unchanged (L = A); it adds no logic but strengthens or
  isolates a signal.

---

## 3. Truth Tables and Logic Functions

A **truth table** lists every possible input combination and the resulting output. For n
inputs there are 2ⁿ rows. A truth table completely defines a **logic function** — the
relationship between inputs and outputs (Ndjountche, 2016). From a truth table I can read
off a Boolean expression by writing a term for each row where the output is 1
(sum-of-products form).

Example — XOR:

| A | B | A ⊕ B |
|---|---|-------|
| 0 | 0 | 0 |
| 0 | 1 | 1 |
| 1 | 0 | 1 |
| 1 | 1 | 0 |

---

## 4. Three-State (Tri-State) Buffer

Beyond 0 and 1, a **three-state buffer** can also present a high-impedance state (Z), which
effectively disconnects the output from the line. This is used to let multiple devices share
a common bus without conflicting, since only one driver is active at a time (Ndjountche,
2016).

---

## 5. Boolean Algebra Laws

Boolean algebra is the math for simplifying and manipulating logic expressions, which lets
us build circuits with fewer gates (Ndjountche, 2016). The laws I need most:

| Law | AND form | OR form |
|-----|----------|---------|
| Identity | A · 1 = A | A + 0 = A |
| Null / Domination | A · 0 = 0 | A + 1 = 1 |
| Idempotent | A · A = A | A + A = A |
| Complement | A · A' = 0 | A + A' = 1 |
| Involution | (A')' = A | — |
| Commutative | A · B = B · A | A + B = B + A |
| Associative | (A·B)·C = A·(B·C) | (A+B)+C = A+(B+C) |
| Distributive | A·(B+C) = A·B + A·C | A + (B·C) = (A+B)·(A+C) |
| Absorption | A·(A+B) = A | A + A·B = A |
| De Morgan's | (A·B)' = A' + B' | (A+B)' = A' · B' |

**De Morgan's theorems** are especially important — they let me convert between AND/OR forms
and are how NAND/NOR gates become universal.

---

## 6. Multi-Level Logic and Practical Considerations

Complex functions are built by combining gates into **multi-level** circuits (the output of
one gate feeds the input of another). Practical design also has to consider real-world
factors such as **propagation delay** (gates take time to switch), **fan-out** (how many
inputs one output can drive), and power — not just the ideal logic (Ndjountche, 2016).

---

## 7. How This Connects to Unit 1 Work

- **Discussion (2-bit adder):** Sum = XOR, Carry = AND; a half adder plus a full adder chain
  add two 2-bit numbers, and Boolean algebra defines the carry-out logic.
- **Assignment (light bulb + switch):** the function simplifies to L = S by the identity law,
  so the minimal circuit uses zero gates (or a single buffer).

---

## 8. Logisim Setup Notes

- Logisim is a Java-based digital logic simulator; it needs a **Java Runtime Environment
  (JRE) v5+** installed first.
- TECS (Nand2Tetris) tools also need Java (JRE 1.3.1+) and are used later for the
  assembler and CPU emulator.
- Workflow: place input/output pins, drop in gates, wire them, then toggle inputs and watch
  outputs update in real time — great for verifying a truth table row by row.

---

## Self-Check (Unit 1 outcomes)

1. Can I explain the basic logic gates and their truth tables? ✅
2. Can I apply Boolean algebra and gates to construct a digital circuit? ✅

---

## Reference

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley &
Sons. https://ebookcentral.proquest.com/
