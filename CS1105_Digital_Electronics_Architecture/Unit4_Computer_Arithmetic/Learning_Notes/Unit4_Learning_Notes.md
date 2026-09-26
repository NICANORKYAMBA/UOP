# Unit 4 Learning Notes: Computer Arithmetic, Adders, and the ALU

Course: CS 1105 Digital Electronics & Computer Architecture
Readings: Ndjountche (2016a), *Digital electronics 1*, Ch. 1 Number Systems (pp. 20-53);
Ndjountche (2016b), *Digital electronics 2*, Ch. 4 Arithmetic and Logic Circuits (pp. 117-149)
Videos: Learning Vibes (2023) number systems; Learn Computer Science (2022) ALU

Due this week (all September 30, 2026):
- Discussion: first post by **Sunday Sep 27**, 2 peer replies by **Wednesday Sep 30**
- Assignment Activity (Word doc)
- Self-Quiz (answers at the bottom)

---

## 1. Number systems (radix B)

A number in radix B is a sum of digits times powers of B:
`d3 d2 d1 d0 = d3*B^3 + d2*B^2 + d1*B^1 + d0*B^0`

| System | Base | Digits | Why computers use it |
|---|---|---|---|
| Decimal | 10 | 0-9 | What humans read and type |
| Binary | 2 | 0, 1 | Matches two voltage levels (off/on) |
| Octal | 8 | 0-7 | 1 octal digit = 3 bits |
| Hexadecimal | 16 | 0-9, A-F | 1 hex digit = 4 bits, short way to write binary |

- n bits give **2^n** different values. 5 bits = 32 values, 8 bits = 256.
- Hex and octal are just shorthand for binary. `1011 0110` = `B6` hex.

## 2. Decimal to binary (reading question)

Repeated division by 2, then read the remainders from bottom to top.

45 to binary:

| Divide | Quotient | Remainder |
|---|---|---|
| 45 / 2 | 22 | 1 |
| 22 / 2 | 11 | 0 |
| 11 / 2 | 5 | 1 |
| 5 / 2 | 2 | 1 |
| 2 / 2 | 1 | 0 |
| 1 / 2 | 0 | 1 |

Read up: **101101** = 32 + 8 + 4 + 1 = 45.

Fractions go the other way: multiply by 2 and take the integer part each time.
0.1 decimal becomes 0.000110011... and repeats forever, so **0.1 cannot be stored exactly
in binary**. This is why money in computers is tricky.

## 3. BCD (binary-coded decimal)

Each decimal digit gets its own 4 bits. 58 = `0101 1000`.
- Easy to display, exact for decimal values.
- Wastes codes (1010 to 1111 are unused) and needs a correction when adding: if a digit sum
  is more than 9 (or makes a carry), **add 6 (0110)**.

## 4. Signed integers

| Method | How -5 looks in 8 bits | Notes |
|---|---|---|
| Sign-magnitude | 1000 0101 | Two zeros, adding is awkward |
| One's complement | 1111 1010 | Invert all bits; still two zeros |
| **Two's complement** | 1111 1011 | Invert and add 1; one zero; same adder works for + and - |

8-bit two's complement range: **-128 to +127**.

**Overflow:** adding two positives gives a negative, or two negatives give a positive.
Hardware check: `V = carry into MSB XOR carry out of MSB`.

## 5. Fixed point, floating point, and real numbers

- **Fixed point:** binary point at a set place. Simple, fast, limited range.
- **Floating point:** sign, exponent, mantissa (like scientific notation). Huge range, but
  rounding errors. Standard is IEEE 754 (single = 32 bits, double = 64 bits).

## 6. Error-detecting and correcting codes (1.13)

- **Parity bit:** add one bit so the count of 1s is even (or odd). Detects single-bit errors.
- **Hamming code:** several parity bits in set positions; can find and fix a single-bit error.

## 7. Adders

**Half adder** (2 inputs): `S = A XOR B`, `C = A AND B`

**Full adder** (3 inputs, includes carry in):
- `S = A XOR B XOR Cin`
- `Cout = AB + Cin(A XOR B)`

| A | B | Cin | S | Cout |
|---|---|---|---|---|
| 0 | 0 | 0 | 0 | 0 |
| 0 | 0 | 1 | 1 | 0 |
| 0 | 1 | 0 | 1 | 0 |
| 0 | 1 | 1 | 0 | 1 |
| 1 | 0 | 0 | 1 | 0 |
| 1 | 0 | 1 | 0 | 1 |
| 1 | 1 | 0 | 0 | 1 |
| 1 | 1 | 1 | 1 | 1 |

- **Ripple-carry adder:** chain n full adders, carry goes bit to bit. Small but slow
  (delay grows with n).
- **Carry-lookahead adder:** compute `G = AB` (generate) and `P = A XOR B` (propagate) for each
  bit, then `C(i+1) = Gi + Pi*Ci`, expanded so all carries come out at about the same time.
  Faster, more gates.

## 8. Subtractor

Use the adder: **A - B = A + (NOT B) + 1**. Put an XOR gate on each B bit with a control line
SUB. SUB = 0 passes B (add); SUB = 1 inverts B and also sets Cin = 1 (subtract). One circuit
does both.

## 9. Comparator

Tells if A > B, A = B, or A < B. Can be built directly from gates, or by doing A - B and
checking the flags (zero flag means equal, sign/borrow tells which is bigger).

## 10. ALU (Arithmetic Logic Unit)

The part of the CPU that does **arithmetic** (add, subtract, increment, compare) and
**logic** (AND, OR, XOR, NOT, shifts).
- Inputs: operand A, operand B, and an **opcode / select lines** that choose the operation.
- Outputs: result plus **status flags**: Carry (C), Zero (Z), Negative/Sign (N), Overflow (V).
- Inside: an adder, logic gates, and a multiplexer that picks which result goes out.
- **Conditional branching:** the ALU itself does not jump. It sets the flags (for example
  after a compare), and the control unit reads the flags to decide whether to take the
  branch ("branch if zero", "branch if negative").

## 11. Multiplier

- **Shift-and-add:** for each 1 bit in the multiplier, add the multiplicand shifted left by
  that bit's position. n x n bits gives up to 2n bits.
- **Array multiplier:** AND gates make all partial products at once, a grid of adders sums
  them. Fast, but many gates.

1101 x 1011 (13 x 11):
```
      1101
    x 1011
    ------
      1101      (bit 0 = 1)
     1101       (bit 1 = 1)
    0000        (bit 2 = 0)
   1101         (bit 3 = 1)
  --------
  10001111   = 143
```

## 12. Divider

**Restoring division:** shift the next dividend bit into a remainder register, subtract the
divisor. If the result is negative, add the divisor back (restore) and write quotient bit 0;
otherwise keep it and write 1. One step per bit. Dividing by zero must be caught as an error.

13 / 3 = 4 remainder 1 (`1101 / 0011 = 0100 r 0001`).

---

## Self-Quiz answers

| # | Question | Answer | Why |
|---|---|---|---|
| 1 | Bits for 32 unique values | **5** | 2^5 = 32 |
| 2 | Carry when adding 1 + 1 | **1** | 1 + 1 = 10 in binary: sum 0, carry 1 |
| 3 | 10101 + 11011 | **110000** | 21 + 27 = 48 = 110000 |
| 4 | Main function of an ALU | **Perform arithmetic and logic operations** | |
| 5 | 42 in binary | **101010** | 32 + 8 + 2 = 42 |

## References

Learn Computer Science. (2022, May 31). *What is arithmetic logic unit? | ALU in computer
architecture explained* [Video]. YouTube. https://www.youtube.com/watch?v=H_aoaQYgKT8

Learning Vibes. (2023, January 9). *Number system in digital electronics | Introduction to
number system | Digital electronics | Mruduraj* [Video]. YouTube.
https://www.youtube.com/watch?v=XICyh0hO254

Ndjountche, T. (2016a). *Digital electronics 1: Combinational logic circuits*. ISTE; John Wiley & Sons. https://doi.org/10.1002/9781119318620

Ndjountche, T. (2016b). *Digital electronics 2: Sequential and arithmetic logic circuits*.
ISTE; John Wiley & Sons. https://doi.org/10.1002/9781119329756
