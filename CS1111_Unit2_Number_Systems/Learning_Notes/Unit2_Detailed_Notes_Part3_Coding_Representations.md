# Unit 2 Learning Notes - Part 3: Coding Representations

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 2 - Number Systems and Codes
- **Topic**: Coding Representations (ASCII, Unicode, Gray Code, BCD, EBCDIC)
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [Introduction to Data Representation](#introduction-to-data-representation)
2. [Binary-Coded Decimal (BCD)](#binary-coded-decimal-bcd)
3. [Gray Code](#gray-code)
4. [ASCII Code](#ascii-code)
5. [Unicode](#unicode)
6. [EBCDIC](#ebcdic)
7. [Comparison of Coding Schemes](#comparison-of-coding-schemes)
8. [Applications and Use Cases](#applications-and-use-cases)

---

## Introduction to Data Representation

### What is Data Representation?

**Data representation** refers to the methods used to encode information in a format that computers can process and store. Different coding schemes serve different purposes based on:

- **Type of data**: Numbers, text, symbols, control characters
- **Character set size**: How many unique characters can be represented
- **Compatibility**: Interoperability between systems
- **Efficiency**: Storage space and processing speed
- **Industry standards**: Historical and current usage

### Why Multiple Coding Schemes?

1. **Historical Evolution**: Different systems developed independently
2. **Specialized Needs**: Some applications require specific encoding
3. **Efficiency Trade-offs**: Balance between simplicity and capability
4. **Backward Compatibility**: Legacy systems still in use
5. **International Requirements**: Support for multiple languages and scripts

---

## Binary-Coded Decimal (BCD)

### Overview

**Binary-Coded Decimal (BCD)** is a class of binary encodings where each decimal digit (0-9) is represented by a fixed number of binary bits, typically 4 bits.

- **Bits per digit**: 4 bits (1 nibble)
- **Range**: 0000 to 1001 (0 to 9 in decimal)
- **Unused codes**: 1010 to 1111 (A to F in hex) are invalid in BCD
- **Purpose**: Simplify decimal arithmetic in digital systems

### BCD Encoding Table

| Decimal | BCD (4-bit) | Decimal | BCD (4-bit) |
|---------|-------------|---------|-------------|
| 0       | 0000        | 5       | 0101        |
| 1       | 0001        | 6       | 0110        |
| 2       | 0010        | 7       | 0111        |
| 3       | 0011        | 8       | 1000        |
| 4       | 0100        | 9       | 1001        |

**Invalid BCD codes**: 1010, 1011, 1100, 1101, 1110, 1111

### How BCD Works

Each decimal digit is encoded separately using 4 bits.

**Example 1**: Encode 25₁₀ in BCD

```
Decimal:    2         5
BCD:        0010      0101

Result: 0010 0101 (BCD)
```

**Example 2**: Encode 1982₁₀ in BCD

```
Decimal:    1         9         8         2
BCD:        0001      1001      1000      0010

Result: 0001 1001 1000 0010 (BCD)
```

### BCD vs. Pure Binary

**Example**: Representing 25₁₀

- **Pure Binary**: 11001₂ (5 bits)
- **BCD**: 0010 0101 (8 bits)

**Key Difference**:
- BCD uses more bits but maintains decimal digit boundaries
- Pure binary is more compact but requires conversion for decimal display

### Comparison: 99₁₀

| Representation | Binary Pattern | Bits Used |
|----------------|----------------|-----------|
| **Pure Binary** | 01100011 | 8 bits |
| **BCD** | 1001 1001 | 8 bits |

### Comparison: 255₁₀

| Representation | Binary Pattern | Bits Used |
|----------------|----------------|-----------|
| **Pure Binary** | 11111111 | 8 bits |
| **BCD** | 0010 0101 0101 | 12 bits |

### Advantages of BCD

1. **Easy Decimal Conversion**: Each digit maps directly to decimal
2. **No Rounding Errors**: Exact decimal representation (important for financial calculations)
3. **Simple Display**: Direct mapping to 7-segment displays
4. **Human-Readable**: Easier to debug and verify

### Disadvantages of BCD

1. **Storage Inefficiency**: Uses more bits than pure binary
2. **Wasted Codes**: 6 out of 16 possible 4-bit combinations are unused
3. **Complex Arithmetic**: Addition/subtraction requires special correction logic
4. **Limited Range**: For same number of bits, represents smaller values than binary

### BCD Arithmetic Example

**Adding 8 + 5 in BCD**:

```
  8:  1000
+ 5:  0101
    ------
     1101  (13 in binary, but invalid in BCD!)

Correction: Add 6 (0110) when result > 9
     1101
   + 0110
    ------
  1 0011  (Carry 1, digit 3)

Result: 0001 0011 (BCD for 13)
```

### Applications of BCD

1. **Financial Systems**: Banking, accounting (no rounding errors)
2. **Digital Clocks**: Time display (hours, minutes, seconds)
3. **Calculators**: Direct decimal input/output
4. **Measurement Instruments**: Digital multimeters, scales
5. **Legacy Systems**: Older mainframe computers (IBM)

---

## Gray Code

### Overview

**Gray Code** (also called Reflected Binary Code) is a binary numeral system where two successive values differ in only one bit position.

- **Key Property**: Only 1 bit changes between consecutive numbers
- **Purpose**: Minimize errors in digital systems during transitions
- **Inventor**: Frank Gray (Bell Labs, 1947)
- **Patent**: Used in shaft encoders and error correction

### Why Gray Code?

**Problem with Binary**: Multiple bits can change simultaneously

```
Binary counting 3 → 4:
3: 011
4: 100  (All 3 bits change!)
```

If bits don't change simultaneously due to timing issues, intermediate invalid states can occur (011 → 001 → 101 → 100).

**Solution with Gray Code**: Only 1 bit changes

```
Gray code 3 → 4:
3: 0010
4: 0110  (Only 1 bit changes)
```

### Gray Code Table (4-bit)

| Decimal | Binary | Gray Code |
|---------|--------|-----------|
| 0       | 0000   | 0000      |
| 1       | 0001   | 0001      |
| 2       | 0010   | 0011      |
| 3       | 0011   | 0010      |
| 4       | 0100   | 0110      |
| 5       | 0101   | 0111      |
| 6       | 0110   | 0101      |
| 7       | 0111   | 0100      |
| 8       | 1000   | 1100      |
| 9       | 1001   | 1101      |
| 10      | 1010   | 1111      |
| 11      | 1011   | 1110      |
| 12      | 1100   | 1010      |
| 13      | 1101   | 1011      |
| 14      | 1110   | 1001      |
| 15      | 1111   | 1000      |

### Binary to Gray Code Conversion

**Algorithm**:
1. The MSB (leftmost bit) of Gray code = MSB of Binary
2. For remaining bits: Gray bit = XOR of current binary bit and previous binary bit

**Formula**: G(i) = B(i) XOR B(i+1)

**Example**: Convert 1011₂ to Gray Code

```
Binary:     1  0  1  1
            ↓  ↓  ↓  ↓
Step 1:     1  (MSB stays same)
Step 2:        1⊕0 = 1
Step 3:           0⊕1 = 1
Step 4:              1⊕1 = 0

Gray Code:  1  1  1  0
```

### Gray Code to Binary Conversion

**Algorithm**:
1. The MSB of Binary = MSB of Gray code
2. For remaining bits: Binary bit = XOR of current Gray bit and previous Binary bit

**Example**: Convert 1110 (Gray) to Binary

```
Gray:       1  1  1  0
            ↓  ↓  ↓  ↓
Step 1:     1  (MSB stays same)
Step 2:        1⊕1 = 0
Step 3:           0⊕1 = 1
Step 4:              1⊕0 = 1

Binary:     1  0  1  1
```

### Applications of Gray Code

1. **Rotary Encoders**: Shaft position sensing (mechanical to digital)
2. **Analog-to-Digital Converters (ADC)**: Minimize conversion errors
3. **Error Correction**: Reduce errors in digital communication
4. **Karnaugh Maps**: Logic circuit simplification
5. **Genetic Algorithms**: Mutation operations
6. **Position Sensors**: Robotics and automation

### Real-World Example: Rotary Encoder

A rotary encoder on a motor shaft uses Gray code to track position:

```
Position 0: 0000
Position 1: 0001  (1 bit change)
Position 2: 0011  (1 bit change)
Position 3: 0010  (1 bit change)
```

If the sensor reads during transition, only 1 bit might be wrong, resulting in an adjacent position (acceptable error) rather than a completely wrong value.

---

## ASCII Code

### Overview

**ASCII (American Standard Code for Information Interchange)** is a character encoding standard for electronic communication, representing text in computers and communication equipment.

- **Developed**: 1963 by American Standards Association (ASA)
- **Bits**: 7 bits (128 characters)
- **Extended ASCII**: 8 bits (256 characters)
- **Standard**: ANSI X3.4-1986, ISO/IEC 646

### ASCII Character Set

**7-bit ASCII** (0-127):
- **0-31**: Control characters (non-printable)
- **32-126**: Printable characters
- **127**: DEL (delete)

### ASCII Categories

#### 1. Control Characters (0-31)

| Code | Char | Meaning | Code | Char | Meaning |
|------|------|---------|------|------|---------|
| 0    | NUL  | Null    | 10   | LF   | Line Feed |
| 7    | BEL  | Bell    | 13   | CR   | Carriage Return |
| 8    | BS   | Backspace | 27  | ESC  | Escape |
| 9    | TAB  | Tab     | 32   | SP   | Space |

#### 2. Digits (48-57)

| Decimal | Char | Binary   | Hex |
|---------|------|----------|-----|
| 48      | 0    | 0110000  | 30  |
| 49      | 1    | 0110001  | 31  |
| 50      | 2    | 0110010  | 32  |
| ...     | ...  | ...      | ... |
| 57      | 9    | 0111001  | 39  |

#### 3. Uppercase Letters (65-90)

| Decimal | Char | Binary   | Hex |
|---------|------|----------|-----|
| 65      | A    | 1000001  | 41  |
| 66      | B    | 1000010  | 42  |
| 67      | C    | 1000011  | 43  |
| ...     | ...  | ...      | ... |
| 90      | Z    | 1011010  | 5A  |

#### 4. Lowercase Letters (97-122)

| Decimal | Char | Binary   | Hex |
|---------|------|----------|-----|
| 97      | a    | 1100001  | 61  |
| 98      | b    | 1100010  | 62  |
| 99      | c    | 1100011  | 63  |
| ...     | ...  | ...      | ... |
| 122     | z    | 1111010  | 7A  |

#### 5. Special Characters

| Decimal | Char | Decimal | Char | Decimal | Char |
|---------|------|---------|------|---------|------|
| 33      | !    | 44      | ,    | 63      | ?    |
| 35      | #    | 46      | .    | 64      | @    |
| 36      | $    | 58      | :    | 91      | [    |
| 37      | %    | 59      | ;    | 93      | ]    |
| 38      | &    | 60      | <    | 123     | {    |
| 40      | (    | 61      | =    | 125     | }    |
| 41      | )    | 62      | >    | 126     | ~    |

### ASCII Examples

**Example 1**: "Hello" in ASCII

```
Character:  H     e     l     l     o
Decimal:    72    101   108   108   111
Binary:     1001000 1100101 1101100 1101100 1101111
Hex:        48    65    6C    6C    6F
```

**Example 2**: "CS1111" in ASCII

```
Character:  C     S     1     1     1     1
Decimal:    67    83    49    49    49    49
Binary:     1000011 1010011 0110001 0110001 0110001 0110001
Hex:        43    53    31    31    31    31
```

### ASCII Properties

1. **Case Conversion**: Uppercase ↔ Lowercase differs by 32 (bit 5)
   - 'A' (65) ↔ 'a' (97): 97 - 65 = 32
   - Toggle bit 5: 'A' (1000001) ↔ 'a' (1100001)

2. **Digit to Number**: Subtract 48 to get numeric value
   - '5' (53) - 48 = 5

3. **Alphabetical Order**: Preserved in ASCII values
   - 'A' < 'B' < 'C' ... < 'Z'

### Extended ASCII (8-bit)

- **Range**: 128-255
- **Purpose**: Additional characters for different languages
- **Variants**: ISO 8859-1 (Latin-1), Windows-1252, etc.
- **Characters**: Accented letters (é, ñ, ü), symbols (©, ®, °)

### Advantages of ASCII

1. **Simplicity**: Easy to implement and understand
2. **Efficiency**: Compact representation for English text
3. **Compatibility**: Widely supported across all systems
4. **Human-Readable**: Direct mapping to characters

### Limitations of ASCII

1. **English-Centric**: Limited support for non-English languages
2. **Small Character Set**: Only 128 (or 256) characters
3. **No Emojis**: Cannot represent modern symbols
4. **Multiple Variants**: Extended ASCII has incompatible versions

### Applications of ASCII

1. **Text Files**: Plain text documents (.txt)
2. **Programming**: Source code files
3. **Communication Protocols**: Email (SMTP), HTTP headers
4. **Data Exchange**: CSV files, configuration files
5. **Terminal Emulation**: Command-line interfaces

---

## Unicode

### Overview

**Unicode** is a universal character encoding standard that assigns a unique code point to every character in every language, including emojis and symbols.

- **Developed**: 1991 by Unicode Consortium
- **Current Version**: Unicode 15.0 (2022) with 149,186 characters
- **Code Points**: U+0000 to U+10FFFF (over 1.1 million possible)
- **Goal**: Support all writing systems worldwide

### Unicode Encoding Forms

#### 1. UTF-8 (Variable Length: 1-4 bytes)

- **Most Common**: Used by 98% of websites
- **ASCII Compatible**: First 128 characters identical to ASCII
- **Efficient**: 1 byte for English, more for other languages

**Byte Structure**:
```
1 byte:  0xxxxxxx                    (U+0000 to U+007F)
2 bytes: 110xxxxx 10xxxxxx           (U+0080 to U+07FF)
3 bytes: 1110xxxx 10xxxxxx 10xxxxxx  (U+0800 to U+FFFF)
4 bytes: 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx (U+10000 to U+10FFFF)
```

#### 2. UTF-16 (Variable Length: 2 or 4 bytes)

- **Used By**: Windows, Java, JavaScript internally
- **Basic Multilingual Plane (BMP)**: 2 bytes (U+0000 to U+FFFF)
- **Supplementary Planes**: 4 bytes (surrogate pairs)

#### 3. UTF-32 (Fixed Length: 4 bytes)

- **Fixed Size**: Every character uses 4 bytes
- **Simple**: Direct code point representation
- **Inefficient**: Wastes space for common characters

### Unicode Character Ranges

| Range | Description | Examples |
|-------|-------------|----------|
| U+0000-U+007F | Basic Latin (ASCII) | A-Z, a-z, 0-9 |
| U+0080-U+00FF | Latin-1 Supplement | é, ñ, ü, © |
| U+0100-U+017F | Latin Extended-A | ā, ē, ī, ō, ū |
| U+0370-U+03FF | Greek and Coptic | α, β, γ, Ω |
| U+0400-U+04FF | Cyrillic | А, Б, В, Г |
| U+0600-U+06FF | Arabic | ا, ب, ت, ث |
| U+4E00-U+9FFF | CJK Unified Ideographs | 中, 文, 字 |
| U+1F300-U+1F5FF | Miscellaneous Symbols | 🌍, 🔥, 📱 |
| U+1F600-U+1F64F | Emoticons | 😀, 😂, 😍 |

### Unicode Examples

**Example 1**: "Hello" in UTF-8

```
Character:  H     e     l     l     o
Unicode:    U+0048 U+0065 U+006C U+006C U+006F
UTF-8:      48    65    6C    6C    6F (1 byte each)
```

**Example 2**: "你好" (Chinese: Hello) in UTF-8

```
Character:  你         好
Unicode:    U+4F60    U+597D
UTF-8:      E4 BD A0  E5 A5 BD (3 bytes each)
```

**Example 3**: "😀" (Emoji) in UTF-8

```
Character:  😀
Unicode:    U+1F600
UTF-8:      F0 9F 98 80 (4 bytes)
```

### Advantages of Unicode

1. **Universal**: Supports all languages and scripts
2. **Comprehensive**: Includes emojis, symbols, historical scripts
3. **Standardized**: Single encoding for global communication
4. **Extensible**: Can add new characters
5. **Backward Compatible**: UTF-8 is ASCII-compatible

### Disadvantages of Unicode

1. **Complexity**: Multiple encoding forms (UTF-8, UTF-16, UTF-32)
2. **Storage**: Requires more bytes than ASCII for English text
3. **Processing**: Variable-length encoding complicates string operations
4. **Legacy Issues**: Older systems may not support Unicode

### Applications of Unicode

1. **Web Development**: HTML, XML, JSON (UTF-8 standard)
2. **Internationalization (i18n)**: Multi-language applications
3. **Social Media**: Emojis, diverse language support
4. **Operating Systems**: Modern OS use Unicode internally
5. **Databases**: MySQL, PostgreSQL, MongoDB support Unicode

---

## EBCDIC

### Overview

**EBCDIC (Extended Binary Coded Decimal Interchange Code)** is an 8-bit character encoding used primarily on IBM mainframe and midrange computer systems.

- **Developed**: 1963-1964 by IBM
- **Bits**: 8 bits (256 characters)
- **Usage**: IBM mainframes (z/OS, z/VM, z/VSE)
- **Variants**: Multiple versions (37 variants)

### EBCDIC vs. ASCII

| Feature | ASCII | EBCDIC |
|---------|-------|--------|
| **Bits** | 7 (or 8 extended) | 8 |
| **Characters** | 128 (or 256) | 256 |
| **Platform** | Universal | IBM mainframes |
| **Ordering** | Sequential | Non-sequential |
| **Compatibility** | Widely compatible | Limited |

### Character Ordering Difference

**ASCII**: Letters are sequential
```
A=65, B=66, C=67, ..., Z=90
```

**EBCDIC**: Letters are NOT sequential
```
A=193, B=194, C=195, ..., I=201
J=209, K=210, ..., R=217
S=226, T=227, ..., Z=233
```

**Gap Problem**: There are gaps in the alphabet sequence in EBCDIC!

### EBCDIC Character Examples

| Character | EBCDIC (Decimal) | EBCDIC (Hex) | ASCII (Decimal) |
|-----------|------------------|--------------|-----------------|
| Space     | 64               | 40           | 32              |
| 0         | 240              | F0           | 48              |
| A         | 193              | C1           | 65              |
| a         | 129              | 81           | 97              |

### Advantages of EBCDIC

1. **Mainframe Optimization**: Designed for IBM hardware
2. **Punch Card Compatibility**: Aligned with IBM punch card encoding
3. **Established Systems**: Decades of legacy code

### Disadvantages of EBCDIC

1. **Limited Compatibility**: Not widely supported outside IBM
2. **Non-Sequential**: Letters not in order (complicates sorting)
3. **Conversion Required**: Must convert to ASCII for interoperability
4. **Declining Use**: Modern systems prefer ASCII/Unicode

### Applications of EBCDIC

1. **IBM Mainframes**: z/OS, z/VM, z/VSE operating systems
2. **Banking Systems**: Legacy financial applications
3. **Government**: Older government databases
4. **Enterprise**: Large corporations with IBM infrastructure

### EBCDIC to ASCII Conversion

Requires lookup tables or conversion utilities:
- **iconv** (Unix/Linux)
- **dd conv=ascii** (Unix/Linux)
- **IBM utilities**: ICONV, QASCII

---

## Comparison of Coding Schemes

### Comprehensive Comparison Table

| Feature | BCD | Gray Code | ASCII | Unicode | EBCDIC |
|---------|-----|-----------|-------|---------|--------|
| **Purpose** | Decimal digits | Error reduction | Text encoding | Universal text | IBM text |
| **Bits** | 4 per digit | Variable | 7 (or 8) | Variable (8-32) | 8 |
| **Characters** | 10 (0-9) | N/A | 128 (256) | 149,186+ | 256 |
| **Efficiency** | Low | N/A | High | Medium | Medium |
| **Compatibility** | Limited | Specialized | Universal | Universal | IBM only |
| **Use Case** | Calculators | Encoders | English text | All languages | Mainframes |
| **Industry** | Finance, displays | Robotics | Computing | Web, mobile | Banking |
| **Year** | 1960s | 1947 | 1963 | 1991 | 1963 |
| **Standard** | Various | IEEE | ANSI, ISO | ISO 10646 | IBM |

### Character Set Size Comparison

```
BCD:        10 characters (digits only)
Gray Code:  N/A (not for text)
ASCII:      128 characters (7-bit)
Extended ASCII: 256 characters (8-bit)
EBCDIC:     256 characters (8-bit)
Unicode:    149,186+ characters (and growing)
```

### Storage Efficiency Example: "123"

| Encoding | Binary Representation | Bytes |
|----------|----------------------|-------|
| **BCD** | 0001 0010 0011 | 1.5 bytes |
| **ASCII** | 00110001 00110010 00110011 | 3 bytes |
| **Unicode (UTF-8)** | 00110001 00110010 00110011 | 3 bytes |
| **EBCDIC** | 11110001 11110010 11110011 | 3 bytes |
| **Pure Binary** | 01111011 | 1 byte |

### When to Use Each Coding Scheme

**Use BCD when**:
- Exact decimal representation required (financial)
- Interfacing with 7-segment displays
- Decimal arithmetic without conversion

**Use Gray Code when**:
- Minimizing errors in transitions
- Rotary encoders, position sensors
- Analog-to-digital conversion

**Use ASCII when**:
- English text only
- Legacy system compatibility
- Simple text files, protocols

**Use Unicode when**:
- Multi-language support required
- Modern web/mobile applications
- Emojis and special symbols needed

**Use EBCDIC when**:
- Working with IBM mainframes
- Legacy banking/government systems
- No choice (system requirement)

---

## Applications and Use Cases

### Real-World Scenario 1: E-Commerce Website

**Requirement**: Display product information in multiple languages with prices

**Recommended Encoding**: **Unicode (UTF-8)**

**Reasoning**:
- Supports all languages (English, Chinese, Arabic, etc.)
- Handles currency symbols (€, ¥, £, ₹)
- Web standard (98% of websites)
- Backward compatible with ASCII

**Price Storage**: Use BCD or Decimal type in database (no rounding errors)

### Real-World Scenario 2: Digital Multimeter

**Requirement**: Display measurement values on 7-segment display

**Recommended Encoding**: **BCD**

**Reasoning**:
- Direct mapping to 7-segment displays
- Exact decimal representation
- Simple hardware implementation
- No conversion needed for display

### Real-World Scenario 3: Robotic Arm Position Sensor

**Requirement**: Track arm position with minimal error during movement

**Recommended Encoding**: **Gray Code**

**Reasoning**:
- Only 1 bit changes per position
- Minimizes errors during transitions
- Reliable position tracking
- Industry standard for encoders

### Real-World Scenario 4: Legacy Banking System

**Requirement**: Interface with IBM mainframe for transaction processing

**Recommended Encoding**: **EBCDIC**

**Reasoning**:
- Mainframe uses EBCDIC natively
- Established legacy code
- Conversion to ASCII for external communication
- No alternative (system constraint)

### Real-World Scenario 5: IoT Sensor Data

**Requirement**: Transmit sensor readings (temperature, humidity) over network

**Recommended Encoding**: **ASCII or Unicode (UTF-8)**

**Reasoning**:
- Human-readable for debugging
- Universal compatibility
- JSON format uses UTF-8
- Easy parsing and processing

---

## Key Takeaways

1. **BCD**: Decimal digits, financial accuracy, display interfaces
2. **Gray Code**: Error reduction, position sensors, ADC
3. **ASCII**: English text, legacy systems, simple protocols
4. **Unicode**: Universal text, multi-language, modern applications
5. **EBCDIC**: IBM mainframes, legacy banking, limited use
6. **Choose based on**: Application requirements, compatibility, efficiency

---

## Study Tips

1. **Memorize ASCII ranges**: Control (0-31), Digits (48-57), Uppercase (65-90), Lowercase (97-122)
2. **Understand trade-offs**: Efficiency vs. compatibility vs. capability
3. **Practice conversions**: BCD encoding, Gray code generation
4. **Real-world context**: Think about when each encoding is appropriate
5. **Compare and contrast**: Know the differences between all schemes

---

## References

ALL ABOUT ELECTRONICS. (2021, August 2). *Binary codes: Classification of binary codes explained* [Video]. YouTube. https://www.youtube.com/watch?v=7WZwOJEoTMo

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley & Sons, Incorporated.

Robertson, S. (2020). *B c, before computers: On information technology from writing to the age of digital data*. Open Book Publishers.

---

**End of Unit 2 Learning Notes**

**Summary**: You have now covered all topics in Unit 2:
- Number Systems (Binary, Decimal, Octal, Hexadecimal)
- Base Conversions (All methods)
- Coding Representations (BCD, Gray Code, ASCII, Unicode, EBCDIC)

**Next Steps**: Review all three parts, practice conversions, and complete the Unit 2 assignment!
