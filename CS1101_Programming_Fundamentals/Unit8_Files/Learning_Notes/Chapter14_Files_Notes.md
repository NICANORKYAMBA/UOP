# Chapter 14 Learning Notes — Files

**Course**: CS1101 Programming Fundamentals  
**Unit**: 8 — Files  
**Source**: Downey (2015), Chapter 14

---

## 1. Persistence

Programs that store data only in variables lose everything when they exit. **Persistence** means saving data to files so it survives between runs. Python uses the built-in `open()` function to create a file object for reading or writing.

---

## 2. Reading and Writing Files

```python
# Write mode — creates or overwrites
f = open('output.txt', 'w')
f.write('Hello, file!\n')
f.close()

# Read mode — file must exist
f = open('output.txt', 'r')
text = f.read()
f.close()
```

Always close files after use. The `with` statement does this automatically:

```python
with open('output.txt', 'r') as f:
    for line in f:
        print(line.strip())
```

| Mode | Meaning |
|---|---|
| `'r'` | Read (default) |
| `'w'` | Write (creates/overwrites) |
| `'a'` | Append (adds to end) |

---

## 3. Format Operator `%`

The `%` operator formats strings before writing them:

```python
name = 'Alice'
score = 95.5
print('%-10s %5.1f' % (name, score))
# Output: Alice       95.5
```

`%-10s` — left-align string in 10-char field  
`%5.1f` — float in 5-char field, 1 decimal place

---

## 4. Filenames and Paths

```python
import os
import os.path

cwd = os.getcwd()                    # current working directory
os.path.exists('fruits.txt')         # True/False
os.path.join('data', 'fruits.txt')   # 'data/fruits.txt'
os.listdir('.')                      # list files in current dir
```

---

## 5. Catching Exceptions

```python
try:
    f = open('missing.txt', 'r')
except FileNotFoundError:
    print("File not found.")
except PermissionError:
    print("No read permission.")
```

**Key rule**: name the specific exception in `except` — never use bare `except:` in production code (Downey, 2015, p. 145).

Common file exceptions:

| Exception | Cause |
|---|---|
| `FileNotFoundError` | File does not exist |
| `PermissionError` | No read/write access |
| `IsADirectoryError` | Path is a directory |
| `FileExistsError` | File already exists (mode `'x'`) |
| `OSError` | General OS-level file error |

---

## 6. Converting Between Files and Dictionaries

**File → Dictionary**:
```python
d = {}
with open('data.txt', 'r') as f:
    for line in f:
        key, value = line.strip().split(': ', 1)
        d[key] = value
```

**Dictionary → File**:
```python
with open('output.txt', 'w') as f:
    for key, value in d.items():
        f.write(f'{key}: {value}\n')
```

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Schafer, C. (2016, April 29). *Python tutorial: File objects - Reading and writing to files* [Video]. YouTube. https://youtu.be/Uh2ebFW8OYM
