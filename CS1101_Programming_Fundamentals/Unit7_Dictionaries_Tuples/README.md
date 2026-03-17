# CS1101 Unit 7 — Dictionaries and Tuples

**Course**: CS1101 Programming Fundamentals  
**Unit**: 7 — Data and Data Structures  
**Textbook**: Downey, A. (2015). *Think Python* — Chapters 11, 12, 13

---

## Learning Objectives

- Construct code to manipulate the content of a dictionary
- Use global variables in functions
- Apply tuples in loops over lists and dictionaries
- Use the `zip` function, `enumerate` function, and `items()` dictionary method

---

## Topics Covered

- Dictionaries: key-value pairs, mapping, looping
- Reverse lookup in dictionaries
- Dictionaries and lists together
- Global variables
- Tuples: immutability, assignment, return values
- `zip()`, `enumerate()`, `.items()`
- Dictionaries as tuples
- Case study: data structure selection (Chapter 13)

---

## Files

```
Unit7_Dictionaries_Tuples/
├── Assignment/
│   ├── Unit7_Programming_Assignment.md
│   ├── Unit7_Programming_Assignment.docx
│   └── invert_dict.py
├── Discussion/
│   ├── Unit7_Discussion_Assignment.md
│   ├── Unit7_Discussion_Assignment.docx
│   └── Peer_Response_*.md
├── Learning_Notes/
│   ├── Chapter11_Dictionaries_Notes.md
│   ├── Chapter12_Tuples_Notes.md
│   └── Quick_Study_Guide.md
├── Resources/
│   └── Additional_Materials.md
└── README.md
```

---

## Key Concepts Quick Reference

| Concept | Description |
|---|---|
| Dictionary | Mutable mapping of key → value pairs |
| Key | Must be immutable (string, int, tuple) |
| Value | Any type, including lists or other dicts |
| Tuple | Immutable sequence — can be a dict key |
| `zip(a, b)` | Pairs elements from two sequences |
| `enumerate(seq)` | Yields `(index, value)` pairs |
| `.items()` | Returns `(key, value)` pairs from a dict |
| Reverse lookup | Finding a key given its value |
| Global variable | Defined outside all functions, accessible everywhere |

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf
