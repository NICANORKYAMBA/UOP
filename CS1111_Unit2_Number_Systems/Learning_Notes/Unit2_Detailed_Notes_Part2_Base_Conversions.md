# Unit 2 Learning Notes - Part 2: Base Conversions

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 2 - Number Systems and Codes
- **Topic**: Base Conversions (All Methods)
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [Conversion Overview](#conversion-overview)
2. [Decimal to Binary Conversion](#decimal-to-binary-conversion)
3. [Binary to Decimal Conversion](#binary-to-decimal-conversion)
4. [Decimal to Octal Conversion](#decimal-to-octal-conversion)
5. [Octal to Decimal Conversion](#octal-to-decimal-conversion)
6. [Decimal to Hexadecimal Conversion](#decimal-to-hexadecimal-conversion)
7. [Hexadecimal to Decimal Conversion](#hexadecimal-to-decimal-conversion)
8. [Binary to Octal Conversion](#binary-to-octal-conversion)
9. [Octal to Binary Conversion](#octal-to-binary-conversion)
10. [Binary to Hexadecimal Conversion](#binary-to-hexadecimal-conversion)
11. [Hexadecimal to Binary Conversion](#hexadecimal-to-binary-conversion)
12. [Octal to Hexadecimal Conversion](#octal-to-hexadecimal-conversion)
13. [Hexadecimal to Octal Conversion](#hexadecimal-to-octal-conversion)
14. [Conversion Quick Reference](#conversion-quick-reference)

---

## Conversion Overview

### Conversion Pathways

```
        ←→ Binary ←→
       ↗     ↕      ↖
Decimal ←→ Octal ←→ Hexadecimal
       ↖     ↕      ↗
        ←→ Binary ←→
```

### Direct vs. Indirect Conversions

**Direct Conversions** (Use formulas):
- Any base → Decimal (positional notation)
- Decimal → Any base (division/multiplication method)

**Indirect Conversions** (Through binary):
- Binary ↔ Octal (group by 3 bits)
- Binary ↔ Hexadecimal (group by 4 bits)
- Octal ↔ Hexadecimal (convert through binary)

---

## Decimal to Binary Conversion

### Method: Repeated Division by 2

**Steps**:
1. Divide the decimal number by 2
2. Record the remainder (0 or 1)
3. Divide the quotient by 2
4. Repeat until quotient is 0
5. Read remainders from bottom to top (LSB to MSB)

### Example 1: Convert 25₁₀ to Binary

```
Division    Quotient    Remainder
25 ÷ 2  =   12          1  ← LSB (Least Significant Bit)
12 ÷ 2  =   6           0
6 ÷ 2   =   3           0
3 ÷ 2   =   1           1
1 ÷ 2   =   0           1  ← MSB (Most Significant Bit)

Reading from bottom to top: 11001₂
```

**Verification**: 1×16 + 1×8 + 0×4 + 0×2 + 1×1 = 16 + 8 + 1 = 25₁₀ ✓

### Example 2: Convert 156₁₀ to Binary

```
Division    Quotient    Remainder
156 ÷ 2 =   78          0  ← LSB
78 ÷ 2  =   39          0
39 ÷ 2  =   19          1
19 ÷ 2  =   9           1
9 ÷ 2   =   4           1
4 ÷ 2   =   2           0
2 ÷ 2   =   1           0
1 ÷ 2   =   0           1  ← MSB

Result: 10011100₂
```

### Decimal Fraction to Binary

**Method**: Repeated Multiplication by 2

**Steps**:
1. Multiply the fraction by 2
2. Record the integer part (0 or 1)
3. Keep the fractional part
4. Repeat until fraction is 0 or desired precision
5. Read integer parts from top to bottom

### Example: Convert 0.625₁₀ to Binary

```
Multiplication          Integer Part
0.625 × 2 = 1.25        1  ← First bit after decimal
0.25 × 2  = 0.5         0
0.5 × 2   = 1.0         1
0.0 (stop)

Result: 0.101₂
```

**Verification**: 1×0.5 + 0×0.25 + 1×0.125 = 0.5 + 0.125 = 0.625₁₀ ✓

### Example: Convert 13.625₁₀ to Binary

**Integer part**: 13₁₀ = 1101₂ (using division method)
**Fractional part**: 0.625₁₀ = 0.101₂ (using multiplication method)

**Result**: 1101.101₂

---

## Binary to Decimal Conversion

### Method: Positional Notation (Multiply and Add)

**Formula**: Sum of (digit × 2^position)

### Example 1: Convert 1011₂ to Decimal

```
Position:    3    2    1    0
Binary:      1    0    1    1
Power of 2:  2³   2²   2¹   2⁰
Value:       8    4    2    1

Calculation:
1 × 2³ = 1 × 8 = 8
0 × 2² = 0 × 4 = 0
1 × 2¹ = 1 × 2 = 2
1 × 2⁰ = 1 × 1 = 1
              ----
Total = 11₁₀
```

### Example 2: Convert 11010110₂ to Decimal

```
Position:    7    6    5    4    3    2    1    0
Binary:      1    1    0    1    0    1    1    0
Power of 2:  128  64   32   16   8    4    2    1

Calculation:
1 × 128 = 128
1 × 64  = 64
0 × 32  = 0
1 × 16  = 16
0 × 8   = 0
1 × 4   = 4
1 × 2   = 2
0 × 1   = 0
        -----
Total = 214₁₀
```

### Quick Method: Doubling

Start from the left, double and add:

**Example**: 1011₂
```
1
1 × 2 + 0 = 2
2 × 2 + 1 = 5
5 × 2 + 1 = 11₁₀
```

---

## Decimal to Octal Conversion

### Method: Repeated Division by 8

**Steps**:
1. Divide the decimal number by 8
2. Record the remainder (0-7)
3. Divide the quotient by 8
4. Repeat until quotient is 0
5. Read remainders from bottom to top

### Example 1: Convert 156₁₀ to Octal

```
Division    Quotient    Remainder
156 ÷ 8 =   19          4  ← LSD (Least Significant Digit)
19 ÷ 8  =   2           3
2 ÷ 8   =   0           2  ← MSD (Most Significant Digit)

Result: 234₈
```

**Verification**: 2×64 + 3×8 + 4×1 = 128 + 24 + 4 = 156₁₀ ✓

### Example 2: Convert 511₁₀ to Octal

```
Division    Quotient    Remainder
511 ÷ 8 =   63          7  ← LSD
63 ÷ 8  =   7           7
7 ÷ 8   =   0           7  ← MSD

Result: 777₈
```

---

## Octal to Decimal Conversion

### Method: Positional Notation

**Formula**: Sum of (digit × 8^position)

### Example 1: Convert 157₈ to Decimal

```
Position:    2    1    0
Octal:       1    5    7
Power of 8:  8²   8¹   8⁰
Value:       64   8    1

Calculation:
1 × 8² = 1 × 64 = 64
5 × 8¹ = 5 × 8  = 40
7 × 8⁰ = 7 × 1  = 7
               ----
Total = 111₁₀
```

### Example 2: Convert 2047₈ to Decimal

```
2 × 8³ = 2 × 512 = 1024
0 × 8² = 0 × 64  = 0
4 × 8¹ = 4 × 8   = 32
7 × 8⁰ = 7 × 1   = 7
                ------
Total = 1063₁₀
```

---

## Decimal to Hexadecimal Conversion

### Method: Repeated Division by 16

**Steps**:
1. Divide the decimal number by 16
2. Record the remainder (0-15, use A-F for 10-15)
3. Divide the quotient by 16
4. Repeat until quotient is 0
5. Read remainders from bottom to top

### Example 1: Convert 254₁₀ to Hexadecimal

```
Division    Quotient    Remainder    Hex Digit
254 ÷ 16 =  15          14           E  ← LSD
15 ÷ 16  =  0           15           F  ← MSD

Result: FE₁₆
```

**Verification**: F×16 + E×1 = 15×16 + 14×1 = 240 + 14 = 254₁₀ ✓

### Example 2: Convert 1000₁₀ to Hexadecimal

```
Division    Quotient    Remainder    Hex Digit
1000 ÷ 16 = 62          8            8  ← LSD
62 ÷ 16   = 3           14           E
3 ÷ 16    = 0           3            3  ← MSD

Result: 3E8₁₆
```

### Decimal to Hex Conversion Table

| Decimal | Hex | Decimal | Hex |
|---------|-----|---------|-----|
| 0       | 0   | 8       | 8   |
| 1       | 1   | 9       | 9   |
| 2       | 2   | 10      | A   |
| 3       | 3   | 11      | B   |
| 4       | 4   | 12      | C   |
| 5       | 5   | 13      | D   |
| 6       | 6   | 14      | E   |
| 7       | 7   | 15      | F   |

---

## Hexadecimal to Decimal Conversion

### Method: Positional Notation

**Formula**: Sum of (digit × 16^position)

### Example 1: Convert 2F₁₆ to Decimal

```
Position:    1    0
Hex:         2    F
Decimal:     2    15
Power of 16: 16¹  16⁰
Value:       16   1

Calculation:
2 × 16¹ = 2 × 16 = 32
F × 16⁰ = 15 × 1 = 15
                 ----
Total = 47₁₀
```

### Example 2: Convert 1A3C₁₆ to Decimal

```
1 × 16³ = 1 × 4096 = 4096
A × 16² = 10 × 256 = 2560
3 × 16¹ = 3 × 16  = 48
C × 16⁰ = 12 × 1  = 12
                  ------
Total = 6716₁₀
```

---

## Binary to Octal Conversion

### Method: Group by 3 Bits (from right to left)

**Steps**:
1. Start from the rightmost bit (LSB)
2. Group bits in sets of 3
3. Add leading zeros if needed for the leftmost group
4. Convert each 3-bit group to its octal equivalent (0-7)

### Binary to Octal Mapping

| Binary | Octal | Binary | Octal |
|--------|-------|--------|-------|
| 000    | 0     | 100    | 4     |
| 001    | 1     | 101    | 5     |
| 010    | 2     | 110    | 6     |
| 011    | 3     | 111    | 7     |

### Example 1: Convert 11010110₂ to Octal

```
Step 1: Group by 3 from right
11 010 110

Step 2: Add leading zeros
011 010 110

Step 3: Convert each group
011 = 3
010 = 2
110 = 6

Result: 326₈
```

### Example 2: Convert 1111101₂ to Octal

```
Step 1: Group by 3 from right
1 111 101

Step 2: Add leading zeros
001 111 101

Step 3: Convert each group
001 = 1
111 = 7
101 = 5

Result: 175₈
```

---

## Octal to Binary Conversion

### Method: Convert Each Octal Digit to 3 Bits

**Steps**:
1. Convert each octal digit to its 3-bit binary equivalent
2. Concatenate all binary groups
3. Remove leading zeros if desired

### Example 1: Convert 157₈ to Binary

```
Octal digit:    1      5      7
Binary:         001    101    111

Result: 001101111₂ = 1101111₂
```

### Example 2: Convert 2047₈ to Binary

```
Octal digit:    2      0      4      7
Binary:         010    000    100    111

Result: 010000100111₂ = 10000100111₂
```

---

## Binary to Hexadecimal Conversion

### Method: Group by 4 Bits (from right to left)

**Steps**:
1. Start from the rightmost bit (LSB)
2. Group bits in sets of 4
3. Add leading zeros if needed for the leftmost group
4. Convert each 4-bit group to its hex equivalent (0-F)

### Binary to Hex Mapping

| Binary | Hex | Binary | Hex |
|--------|-----|--------|-----|
| 0000   | 0   | 1000   | 8   |
| 0001   | 1   | 1001   | 9   |
| 0010   | 2   | 1010   | A   |
| 0011   | 3   | 1011   | B   |
| 0100   | 4   | 1100   | C   |
| 0101   | 5   | 1101   | D   |
| 0110   | 6   | 1110   | E   |
| 0111   | 7   | 1111   | F   |

### Example 1: Convert 11010110₂ to Hexadecimal

```
Step 1: Group by 4 from right
1101 0110

Step 2: Convert each group
1101 = D
0110 = 6

Result: D6₁₆
```

### Example 2: Convert 1111101₂ to Hexadecimal

```
Step 1: Group by 4 from right
111 1101

Step 2: Add leading zeros
0111 1101

Step 3: Convert each group
0111 = 7
1101 = D

Result: 7D₁₆
```

---

## Hexadecimal to Binary Conversion

### Method: Convert Each Hex Digit to 4 Bits

**Steps**:
1. Convert each hex digit to its 4-bit binary equivalent
2. Concatenate all binary groups
3. Remove leading zeros if desired

### Example 1: Convert 2F₁₆ to Binary

```
Hex digit:      2      F
Binary:         0010   1111

Result: 00101111₂ = 101111₂
```

### Example 2: Convert 1A3C₁₆ to Binary

```
Hex digit:      1      A      3      C
Binary:         0001   1010   0011   1100

Result: 0001101000111100₂ = 1101000111100₂
```

---

## Octal to Hexadecimal Conversion

### Method: Convert Through Binary

**Steps**:
1. Convert octal to binary (each digit → 3 bits)
2. Convert binary to hexadecimal (group by 4 bits)

### Example: Convert 157₈ to Hexadecimal

```
Step 1: Octal to Binary
1      5      7
001    101    111
Binary: 001101111₂

Step 2: Binary to Hex (group by 4)
0110 1111
6    F

Result: 6F₁₆
```

---

## Hexadecimal to Octal Conversion

### Method: Convert Through Binary

**Steps**:
1. Convert hexadecimal to binary (each digit → 4 bits)
2. Convert binary to octal (group by 3 bits)

### Example: Convert 2F₁₆ to Octal

```
Step 1: Hex to Binary
2      F
0010   1111
Binary: 00101111₂

Step 2: Binary to Octal (group by 3)
00 101 111
0  5   7

Result: 57₈
```

---

## Conversion Quick Reference

### Conversion Methods Summary

| From → To | Method | Key Points |
|-----------|--------|------------|
| **Decimal → Binary** | Divide by 2, record remainders | Read remainders bottom-up |
| **Binary → Decimal** | Multiply by powers of 2, sum | Position × 2^n |
| **Decimal → Octal** | Divide by 8, record remainders | Read remainders bottom-up |
| **Octal → Decimal** | Multiply by powers of 8, sum | Position × 8^n |
| **Decimal → Hex** | Divide by 16, record remainders | Use A-F for 10-15 |
| **Hex → Decimal** | Multiply by powers of 16, sum | Position × 16^n |
| **Binary → Octal** | Group by 3 bits | Right to left, pad with zeros |
| **Octal → Binary** | Each digit → 3 bits | Direct mapping |
| **Binary → Hex** | Group by 4 bits | Right to left, pad with zeros |
| **Hex → Binary** | Each digit → 4 bits | Direct mapping |
| **Octal → Hex** | Via binary | Octal→Binary→Hex |
| **Hex → Octal** | Via binary | Hex→Binary→Octal |

### Powers Reference Table

| Power | 2^n | 8^n | 16^n |
|-------|-----|-----|------|
| 0     | 1   | 1   | 1    |
| 1     | 2   | 8   | 16   |
| 2     | 4   | 64  | 256  |
| 3     | 8   | 512 | 4096 |
| 4     | 16  | 4096| 65536|
| 5     | 32  | -   | -    |
| 6     | 64  | -   | -    |
| 7     | 128 | -   | -    |
| 8     | 256 | -   | -    |

### Conversion Shortcuts

1. **Binary ↔ Octal**: Remember 3 bits = 1 octal digit
2. **Binary ↔ Hex**: Remember 4 bits = 1 hex digit
3. **Quick Binary to Decimal**: Memorize powers of 2 (1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024)
4. **Hex A-F**: A=10, B=11, C=12, D=13, E=14, F=15

---

## Practice Problems

### Problem Set 1: Decimal Conversions

1. Convert 45₁₀ to binary
2. Convert 127₁₀ to octal
3. Convert 255₁₀ to hexadecimal

### Problem Set 2: Binary Conversions

1. Convert 10110101₂ to decimal
2. Convert 11111111₂ to octal
3. Convert 10101010₂ to hexadecimal

### Problem Set 3: Mixed Conversions

1. Convert 377₈ to hexadecimal
2. Convert FF₁₆ to octal
3. Convert 1024₁₀ to all bases

---

## Key Takeaways

1. **Decimal conversions** use repeated division (to other bases) or positional notation (from other bases)
2. **Binary-Octal**: Group by 3 bits (each octal digit = 3 bits)
3. **Binary-Hex**: Group by 4 bits (each hex digit = 4 bits = 1 nibble)
4. **Octal-Hex**: Convert through binary as intermediate step
5. **Always verify** your conversions by converting back to the original base
6. **Memorize** the binary-octal and binary-hex mappings for speed

---

## Study Tips

1. **Practice daily**: Do 5-10 conversions each day
2. **Memorize mappings**: Binary-Octal (3 bits) and Binary-Hex (4 bits)
3. **Use shortcuts**: Binary↔Octal↔Hex conversions are fastest through grouping
4. **Check your work**: Convert back to verify
5. **Learn powers**: Memorize powers of 2, 8, and 16

---

## References

ALL ABOUT ELECTRONICS. (2021, March 24). *Binary number system: Counting in binary number system | Binary to decimal conversion* [Video]. YouTube. https://www.youtube.com/watch?v=VLflTjd3lWA

ALL ABOUT ELECTRONICS. (2021, March 30). *Decimal to binary conversion explained (with solved examples)* [Video]. YouTube. https://www.youtube.com/watch?v=rsxT4FfRBaM

ALL ABOUT ELECTRONICS. (2021, July 27). *Octal and hexadecimal number system explained* [Video]. YouTube. https://www.youtube.com/watch?v=pg-HEGBpCQk

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley & Sons, Incorporated.

The Organic Chemistry Tutor. (2021, January 15). *Number systems introduction - Decimal, binary, octal & hexadecimal* [Video]. YouTube. https://www.youtube.com/watch?v=FFDMzbrEXaE

---

**Next**: Part 3 - Coding Representations (ASCII, Unicode, Gray Code, BCD, EBCDIC)
