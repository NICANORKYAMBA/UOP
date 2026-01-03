# CS1111 Unit 2: Number Systems and Codes

## 📚 Unit Overview

Unit 2 covers fundamental number systems used in computing:
- Binary number system (base-2)
- Decimal number system (base-10)
- Hexadecimal number system (base-16)
- Octal number system (base-8)
- Number system conversions
- Binary arithmetic operations
- Character encoding (ASCII, Unicode)

---

## 📁 Folder Structure

```
CS1111_Unit2_Number_Systems/
├── Assignment/
│   └── Number_Systems_Assignment.docx
├── Learning_Notes/
│   └── (Study materials to be added)
└── Resources/
    └── (Additional materials)
```

---

## 📝 Assignment

### Number_Systems_Assignment.docx
- Complete number systems assignment
- Covers conversions between different bases
- Binary arithmetic operations
- Character encoding concepts

---

## 🎯 Key Topics Covered

### Number Systems

**Binary (Base-2):**
- Uses digits: 0, 1
- Foundation of all digital computing
- Each position represents power of 2
- Example: 1011₂ = 11₁₀

**Decimal (Base-10):**
- Uses digits: 0-9
- Standard human counting system
- Each position represents power of 10
- Example: 123₁₀

**Hexadecimal (Base-16):**
- Uses digits: 0-9, A-F (A=10, B=11, C=12, D=13, E=14, F=15)
- Compact representation of binary
- Each hex digit = 4 binary digits
- Example: FF₁₆ = 255₁₀ = 11111111₂

**Octal (Base-8):**
- Uses digits: 0-7
- Less common in modern computing
- Each octal digit = 3 binary digits
- Example: 17₈ = 15₁₀ = 1111₂

---

## 🔄 Number System Conversions

### Binary to Decimal
Multiply each digit by 2^position and sum:
```
1011₂ = (1×2³) + (0×2²) + (1×2¹) + (1×2⁰)
      = 8 + 0 + 2 + 1
      = 11₁₀
```

### Decimal to Binary
Repeatedly divide by 2, record remainders:
```
13₁₀ ÷ 2 = 6 remainder 1
6 ÷ 2 = 3 remainder 0
3 ÷ 2 = 1 remainder 1
1 ÷ 2 = 0 remainder 1
Read remainders bottom to top: 1101₂
```

### Binary to Hexadecimal
Group binary digits in sets of 4 (from right):
```
11010110₂ = 1101 0110
           = D    6
           = D6₁₆
```

### Hexadecimal to Binary
Convert each hex digit to 4 binary digits:
```
A3₁₆ = A     3
     = 1010  0011
     = 10100011₂
```

---

## ➕ Binary Arithmetic

### Binary Addition
```
  1011₂  (11₁₀)
+ 0110₂  (6₁₀)
-------
 10001₂  (17₁₀)
```

Rules:
- 0 + 0 = 0
- 0 + 1 = 1
- 1 + 0 = 1
- 1 + 1 = 10 (0 with carry 1)

### Binary Subtraction
```
  1011₂  (11₁₀)
- 0110₂  (6₁₀)
-------
  0101₂  (5₁₀)
```

Rules:
- 0 - 0 = 0
- 1 - 0 = 1
- 1 - 1 = 0
- 0 - 1 = 1 (with borrow)

---

## 🔤 Character Encoding

### ASCII (American Standard Code for Information Interchange)
- 7-bit encoding (128 characters)
- Extended ASCII: 8-bit (256 characters)
- Examples:
  - 'A' = 65₁₀ = 01000001₂
  - 'a' = 97₁₀ = 01100001₂
  - '0' = 48₁₀ = 00110000₂

### Unicode
- Universal character encoding
- Supports all world languages
- UTF-8, UTF-16, UTF-32 encodings
- Backward compatible with ASCII

---

## 💡 Quick Reference Table

| Decimal | Binary | Octal | Hexadecimal |
|---------|--------|-------|-------------|
| 0 | 0000 | 0 | 0 |
| 1 | 0001 | 1 | 1 |
| 2 | 0010 | 2 | 2 |
| 3 | 0011 | 3 | 3 |
| 4 | 0100 | 4 | 4 |
| 5 | 0101 | 5 | 5 |
| 6 | 0110 | 6 | 6 |
| 7 | 0111 | 7 | 7 |
| 8 | 1000 | 10 | 8 |
| 9 | 1001 | 11 | 9 |
| 10 | 1010 | 12 | A |
| 11 | 1011 | 13 | B |
| 12 | 1100 | 14 | C |
| 13 | 1101 | 15 | D |
| 14 | 1110 | 16 | E |
| 15 | 1111 | 17 | F |

---

## 📖 Study Tips

1. **Memorize powers of 2**: 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024
2. **Practice conversions**: Work through multiple examples
3. **Use grouping**: Binary to hex (groups of 4), binary to octal (groups of 3)
4. **Understand place values**: Each position is base^position
5. **Check your work**: Convert back to verify correctness

---

## ✅ Unit 2 Checklist

- [ ] Understand all four number systems
- [ ] Practice binary to decimal conversions
- [ ] Practice decimal to binary conversions
- [ ] Practice binary to hexadecimal conversions
- [ ] Practice hexadecimal to binary conversions
- [ ] Master binary addition
- [ ] Master binary subtraction
- [ ] Understand ASCII encoding
- [ ] Complete assignment
- [ ] Review for quiz

---

## 🎓 Real-World Applications

- **Computer Memory**: Addresses in hexadecimal
- **IP Addresses**: Binary representation
- **Color Codes**: Hex color codes (#FF0000 = red)
- **File Permissions**: Octal notation in Unix/Linux
- **Machine Code**: Binary instructions
- **Data Storage**: All data stored as binary

---

**Note**: Number systems are fundamental to understanding how computers store and process information. Master these concepts for success in computer science.
