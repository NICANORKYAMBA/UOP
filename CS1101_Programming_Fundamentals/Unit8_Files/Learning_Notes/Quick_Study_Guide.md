# Unit 8 Quick Study Guide — Files

## The 3-Step File Pattern

```
open → read/write → close
```
Always use `with open(...)` — it closes automatically.

## Exception Handling Template

```python
try:
    with open(filename, 'r') as f:
        data = f.read()
except FileNotFoundError:
    print("File not found")
except PermissionError:
    print("No access")
```

## File → Dict → Inverted Dict → File

```python
# Read
d = {}
with open('in.txt') as f:
    for line in f:
        k, v = line.strip().split(': ', 1)
        d[k] = v

# Invert
inv = {}
for k, v in d.items():
    inv.setdefault(v, []).append(k)

# Write
with open('out.txt', 'w') as f:
    for k, vals in inv.items():
        f.write(k + ': ' + ', '.join(vals) + '\n')
```

## Key Functions

| Function | Purpose |
|---|---|
| `open(f, mode)` | Open file, return file object |
| `f.read()` | Read entire file as string |
| `f.readline()` | Read one line |
| `f.write(s)` | Write string to file |
| `os.getcwd()` | Current working directory |
| `os.path.exists(f)` | Check if file exists |

## Common Exceptions

| Exception | When |
|---|---|
| `FileNotFoundError` | File doesn't exist |
| `PermissionError` | No access rights |
| `IsADirectoryError` | Path is a folder |
