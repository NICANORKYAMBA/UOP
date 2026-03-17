# Unit 7 Quick Study Guide — Dictionaries and Tuples

**Course**: CS1101 Programming Fundamentals

---

## Mnemonic: DIRTGZ — The 6 Core Concepts

| Letter | Concept | One-liner |
|---|---|---|
| **D** | Dictionary | Key → Value mapping, mutable |
| **I** | Immutable keys | Keys must be immutable (str, int, tuple) |
| **R** | Reverse lookup | Find key given value — use list comprehension |
| **T** | Tuple | Immutable sequence, can be a dict key |
| **G** | Global | `global x` needed to modify outside variable |
| **Z** | zip/enumerate/items | The three tuple-loop tools |

---

## Essential Syntax Cheat Sheet

```python
# ── DICTIONARIES ──────────────────────────────
d = {'a': 1, 'b': 2}
d['c'] = 3              # add/update
del d['a']              # delete
d.get('z', 0)           # safe access, default 0
'b' in d                # True — key membership
for k, v in d.items():  # loop key-value pairs

# ── TUPLES ────────────────────────────────────
t = (1, 2, 3)
a, b, c = t             # unpack
a, b = b, a             # swap
t2 = tuple([1, 2, 3])   # from list

# ── ZIP ───────────────────────────────────────
for a, b in zip(list1, list2):   # pair elements
d = dict(zip(keys, values))      # build dict

# ── ENUMERATE ─────────────────────────────────
for i, val in enumerate(seq):          # 0-based
for i, val in enumerate(seq, start=1): # 1-based

# ── ITEMS ─────────────────────────────────────
for k, v in d.items():   # (key, value) tuples
sorted(d.items(), key=lambda x: x[1])  # sort by value
```

---

## The Three Loop Tools Compared

| Tool | Input | Yields | Use When |
|---|---|---|---|
| `zip(a, b)` | Two sequences | `(a_item, b_item)` | Pairing two parallel lists |
| `enumerate(seq)` | One sequence | `(index, value)` | Need index + value together |
| `d.items()` | Dictionary | `(key, value)` | Looping over dict pairs |

---

## Inverting a Dictionary

```python
def invert_dict(d):
    inverse = {}
    for key, value in d.items():
        if value not in inverse:
            inverse[value] = [key]
        else:
            inverse[value].append(key)
    return inverse
```

---

## Global Variable Pattern

```python
counter = 0

def increment():
    global counter   # required to modify, not just read
    counter += 1
```

---

## Common Exam Questions

**Q: Why can't a list be a dictionary key?**  
A: Lists are mutable — their hash value could change, breaking the dictionary's internal structure. Keys must be immutable.

**Q: What does `zip` do with unequal-length sequences?**  
A: It stops at the shortest one — extra elements in the longer sequence are ignored.

**Q: What's the difference between `d[key]` and `d.get(key)`?**  
A: `d[key]` raises `KeyError` if the key doesn't exist; `d.get(key, default)` returns the default instead.

**Q: How do you return multiple values from a function?**  
A: Return a tuple — `return a, b` — and unpack with `x, y = func()`.

---

## Reference

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf
