# Unit 2 Learning Notes - Part 1: Number Systems

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 2 - Number Systems and Codes
- **Topic**: Number Systems (Binary, Decimal, Octal, Hexadecimal)
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [Introduction to Number Systems](#introduction-to-number-systems)
2. [Decimal Number System (Base-10)](#decimal-number-system-base-10)
3. [Binary Number System (Base-2)](#binary-number-system-base-2)
4. [Octal Number System (Base-8)](#octal-number-system-base-8)
5. [Hexadecimal Number System (Base-16)](#hexadecimal-number-system-base-16)
6. [Representation in Radix B](#representation-in-radix-b)
7. [Comparison of Number Systems](#comparison-of-number-systems)

---

## Introduction to Number Systems

### What is a Number System?

A **number system** is a systematic way of representing numbers using a specific set of symbols or digits. Different number systems use different bases (radix) to represent numerical values.

### Key Terminology

- **Base (Radix)**: The number of unique digits (including zero) used to represent numbers in a positional numeral system
- **Digit**: A single symbol used to represent numbers in a number system
- **Position (Weight)**: The value of a digit based on its position in the number
- **Most Significant Bit/Digit (MSB/MSD)**: The leftmost digit with the highest positional value
- **Least Significant Bit/Digit (LSB/LSD)**: The rightmost digit with the lowest positional value

### Why Multiple Number Systems?

Different number systems serve different purposes in computing:

1. **Human Readability**: Decimal is natural for humans
2. **Machine Processing**: Binary is fundamental to digital electronics
3. **Compact Representation**: Hexadecimal provides shorter notation for binary data
4. **Historical/Specialized Uses**: Octal was popular in early computing systems

---

## Decimal Number System (Base-10)

### Overview

- **Base**: 10
- **Digits**: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
- **Usage**: Standard number system used by humans in everyday life
- **Notation**: Subscript ₁₀ or no subscript (e.g., 125₁₀ or 125)

### Positional Value

Each position represents a power of 10:

```
Position:    10³   10²   10¹   10⁰   .   10⁻¹  10⁻²
Value:       1000  100   10    1     .   0.1   0.01
```

### Example: 3,456.78₁₀

```
3 × 10³ = 3 × 1000 = 3000
4 × 10² = 4 × 100  = 400
5 × 10¹ = 5 × 10   = 50
6 × 10⁰ = 6 × 1    = 6
7 × 10⁻¹ = 7 × 0.1 = 0.7
8 × 10⁻² = 8 × 0.01 = 0.08
                    -------
Total = 3,456.78
```

### Characteristics

- **Natural for humans**: We have 10 fingers
- **Widely used**: Commerce, science, everyday calculations
- **Not efficient for computers**: Requires complex circuitry to represent 10 states

---

## Binary Number System (Base-2)

### Overview

- **Base**: 2
- **Digits**: 0, 1 (called bits - binary digits)
- **Usage**: Fundamental to all digital computers and electronics
- **Notation**: Subscript ₂ (e.g., 1011₂)

### Positional Value

Each position represents a power of 2:

```
Position:    2⁷   2⁶   2⁵   2⁴   2³   2²   2¹   2⁰
Value:       128  64   32   16   8    4    2    1
```

### Why Binary for Computers?

1. **Two-State Electronics**: Easy to implement with ON/OFF, HIGH/LOW, TRUE/FALSE
2. **Reliability**: Less susceptible to noise and errors
3. **Simple Logic**: Boolean algebra operates on binary values
4. **Hardware Efficiency**: Transistors naturally operate in two states

### Example: 1011₂ to Decimal

```
1 × 2³ = 1 × 8 = 8
0 × 2² = 0 × 4 = 0
1 × 2¹ = 1 × 2 = 2
1 × 2⁰ = 1 × 1 = 1
              ----
Total = 11₁₀
```

### Binary Counting

```
Decimal    Binary
0          0000
1          0001
2          0010
3          0011
4          0100
5          0101
6          0110
7          0111
8          1000
9          1001
10         1010
11         1011
12         1100
13         1101
14         1110
15         1111
```

### Binary Terminology

- **Bit**: Single binary digit (0 or 1)
- **Nibble**: 4 bits (e.g., 1011)
- **Byte**: 8 bits (e.g., 10110101)
- **Word**: Typically 16, 32, or 64 bits depending on computer architecture

### Binary Fractions

```
Position:    2⁰   .   2⁻¹   2⁻²   2⁻³   2⁻⁴
Value:       1    .   0.5   0.25  0.125 0.0625
```

**Example**: 101.101₂ to Decimal

```
1 × 2² = 1 × 4 = 4
0 × 2¹ = 0 × 2 = 0
1 × 2⁰ = 1 × 1 = 1
1 × 2⁻¹ = 1 × 0.5 = 0.5
0 × 2⁻² = 0 × 0.25 = 0
1 × 2⁻³ = 1 × 0.125 = 0.125
                     ------
Total = 5.625₁₀
```

---

## Octal Number System (Base-8)

### Overview

- **Base**: 8
- **Digits**: 0, 1, 2, 3, 4, 5, 6, 7
- **Usage**: Historically used in computing; compact representation of binary
- **Notation**: Subscript ₈ (e.g., 157₈)

### Positional Value

Each position represents a power of 8:

```
Position:    8³   8²   8¹   8⁰
Value:       512  64   8    1
```

### Why Octal?

1. **Compact Binary Representation**: Each octal digit represents exactly 3 binary bits
2. **Historical Use**: Popular in early computing systems (PDP-8, Unix file permissions)
3. **Easier than Binary**: Shorter notation while maintaining direct binary relationship

### Octal-Binary Relationship

Each octal digit maps to 3 binary bits:

```
Octal    Binary
0        000
1        001
2        010
3        011
4        100
5        101
6        110
7        111
```

### Example: 157₈ to Decimal

```
1 × 8² = 1 × 64 = 64
5 × 8¹ = 5 × 8  = 40
7 × 8⁰ = 7 × 1  = 7
               ----
Total = 111₁₀
```

### Example: 157₈ to Binary

```
1    5    7     (Octal digits)
↓    ↓    ↓
001  101  111   (3 bits each)

Result: 001101111₂ = 1101111₂
```

### Modern Usage

- **Unix/Linux File Permissions**: chmod 755 (rwxr-xr-x)
- **Legacy Systems**: Some older computer architectures
- **Educational**: Teaching number system concepts

---

## Hexadecimal Number System (Base-16)

### Overview

- **Base**: 16
- **Digits**: 0-9, A-F (A=10, B=11, C=12, D=13, E=14, F=15)
- **Usage**: Widely used in computing for memory addresses, color codes, debugging
- **Notation**: Subscript ₁₆ or prefix 0x (e.g., 2F₁₆ or 0x2F)

### Positional Value

Each position represents a power of 16:

```
Position:    16³   16²   16¹   16⁰
Value:       4096  256   16    1
```

### Why Hexadecimal?

1. **Compact Binary Representation**: Each hex digit represents exactly 4 binary bits (1 nibble)
2. **Human-Readable**: Much shorter than binary for large numbers
3. **Industry Standard**: Memory addresses, color codes, MAC addresses, debugging
4. **Byte Alignment**: Two hex digits = 1 byte (8 bits)

### Hexadecimal Digits

```
Decimal    Hexadecimal    Binary
0          0              0000
1          1              0001
2          2              0010
3          3              0011
4          4              0100
5          5              0101
6          6              0110
7          7              0111
8          8              1000
9          9              1001
10         A              1010
11         B              1011
12         C              1100
13         D              1101
14         E              1110
15         F              1111
```

### Hexadecimal-Binary Relationship

Each hex digit maps to 4 binary bits:

```
Hex     Binary
0       0000
1       0001
2       0010
3       0011
4       0100
5       0101
6       0110
7       0111
8       1000
9       1001
A       1010
B       1011
C       1100
D       1101
E       1110
F       1111
```

### Example: 2F₁₆ to Decimal

```
2 × 16¹ = 2 × 16 = 32
F × 16⁰ = 15 × 1 = 15
                 ----
Total = 47₁₀
```

### Example: 2F₁₆ to Binary

```
2    F       (Hex digits)
↓    ↓
0010 1111    (4 bits each)

Result: 00101111₂ = 101111₂
```

### Real-World Applications

1. **Memory Addresses**: 0x7FFF8000
2. **Color Codes**: #FF5733 (RGB: Red=FF, Green=57, Blue=33)
3. **MAC Addresses**: 00:1A:2B:3C:4D:5E
4. **IPv6 Addresses**: 2001:0db8:85a3:0000:0000:8a2e:0370:7334
5. **Assembly Language**: Machine code representation
6. **Debugging**: Memory dumps, register values

---

## Representation in Radix B

### General Formula

Any number in base B can be represented as:

**N = dₙ × Bⁿ + dₙ₋₁ × Bⁿ⁻¹ + ... + d₁ × B¹ + d₀ × B⁰ + d₋₁ × B⁻¹ + ...**

Where:
- **N**: The number value
- **B**: The base (radix)
- **dᵢ**: The digit at position i
- **n**: The highest position (power)

### Example: 3A7.C₁₆ in Radix 16

```
3 × 16² = 3 × 256 = 768
A × 16¹ = 10 × 16 = 160
7 × 16⁰ = 7 × 1   = 7
C × 16⁻¹ = 12 × 0.0625 = 0.75
                        -------
Total = 935.75₁₀
```

### Valid Digits for Different Bases

| Base | Valid Digits | Example |
|------|-------------|---------|
| 2    | 0, 1        | 1011₂   |
| 8    | 0-7         | 157₈    |
| 10   | 0-9         | 125₁₀   |
| 16   | 0-9, A-F    | 2F₁₆    |

### Range of Values

For an n-digit number in base B:

- **Minimum value**: 0
- **Maximum value**: Bⁿ - 1

**Examples**:
- 8-bit binary: 0 to 2⁸ - 1 = 0 to 255
- 2-digit hex: 0 to 16² - 1 = 0 to 255
- 3-digit octal: 0 to 8³ - 1 = 0 to 511

---

## Comparison of Number Systems

### Quick Reference Table

| Feature | Binary (Base-2) | Octal (Base-8) | Decimal (Base-10) | Hexadecimal (Base-16) |
|---------|----------------|----------------|-------------------|----------------------|
| **Digits** | 0, 1 | 0-7 | 0-9 | 0-9, A-F |
| **Bits per digit** | 1 | 3 | ~3.32 | 4 |
| **Notation** | ₂ or 0b | ₈ or 0o | ₁₀ or none | ₁₆ or 0x |
| **Compactness** | Least compact | Moderate | Moderate | Most compact |
| **Human readability** | Difficult | Moderate | Easy | Moderate |
| **Computer use** | Fundamental | Historical | Interface | Very common |
| **Example (47₁₀)** | 101111₂ | 57₈ | 47₁₀ | 2F₁₆ |

### Conversion Relationships

```
Binary ←→ Octal:   Group by 3 bits
Binary ←→ Hex:     Group by 4 bits
Octal ←→ Hex:      Convert through binary or decimal
Any ←→ Decimal:    Use positional notation formula
```

### Practical Applications by Number System

**Binary**:
- Digital circuit design
- Boolean logic operations
- Low-level programming
- Data transmission

**Octal**:
- Unix file permissions (chmod)
- Legacy system documentation
- Educational purposes

**Decimal**:
- User interfaces
- Financial calculations
- Scientific notation
- Human communication

**Hexadecimal**:
- Memory addresses
- Color codes (web design)
- Assembly language
- Network protocols (MAC, IPv6)
- Debugging and memory dumps

---

## Key Takeaways

1. **Number systems** use different bases to represent numerical values
2. **Binary (base-2)** is fundamental to all digital computing
3. **Octal (base-8)** provides compact binary representation using 3-bit groups
4. **Decimal (base-10)** is the natural human number system
5. **Hexadecimal (base-16)** is widely used in computing for compact, readable binary representation
6. Each hex digit = 4 bits (1 nibble), each octal digit = 3 bits
7. Understanding multiple number systems is essential for computer science

---

## Study Tips

1. **Practice conversions** between all number systems regularly
2. **Memorize** the hex-to-binary and octal-to-binary mappings
3. **Recognize patterns**: Powers of 2 (1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024)
4. **Use mnemonics**: "Hex is 4 bits, Octal is 3 bits"
5. **Real-world practice**: Look at memory addresses, color codes, file permissions

---

## References

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley & Sons, Incorporated.

The Organic Chemistry Tutor. (2021, January 15). *Number systems introduction - Decimal, binary, octal & hexadecimal* [Video]. YouTube. https://www.youtube.com/watch?v=FFDMzbrEXaE

---

**Next**: Part 2 - Base Conversions (Decimal ↔ Binary ↔ Octal ↔ Hexadecimal)
