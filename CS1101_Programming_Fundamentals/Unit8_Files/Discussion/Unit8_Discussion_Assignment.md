# CS1101 Unit 8 Discussion Assignment — File Exception Handling

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 8 — Files  
**Date**: March 2026

---

## Part 1: Exception Handling for File Errors

### What Are File Exceptions?

When a Python program tries to open or read a file, several things can go wrong: the file might not exist, the program might not have permission to access it, or the path might point to a directory instead of a file. Without exception handling, any of these situations causes the program to crash immediately with an unhandled error. Python's `try`/`except` blocks allow the program to anticipate these failures, catch them gracefully, and respond with a meaningful message rather than an abrupt crash (Downey, 2015, p. 145).

As Downey (2015) explains, "if you try to open a file that doesn't exist, you get a `FileNotFoundError`" (p. 145). The `try` block contains the code that might raise an exception; the `except` block specifies which exception to catch and what to do when it occurs. Python matches the raised exception against the named exception in the `except` clause — if they match, the handler runs instead of the program terminating.

### Python Example

```python
# discussion_file_exceptions.py — CS1101 Unit 8 Discussion

def read_file_safely(filename):
    """Attempt to open and read a file, catching specific exceptions."""
    try:
        with open(filename, 'r') as f:
            contents = f.read()
            print(f"File contents:\n{contents}")

    except FileNotFoundError:
        print(f"Error: '{filename}' was not found. Check the filename and path.")

    except PermissionError:
        print(f"Error: No permission to read '{filename}'.")

    except IsADirectoryError:
        print(f"Error: '{filename}' is a directory, not a file.")


# Test 1: file that does not exist
print("=== Test 1: Missing file ===")
read_file_safely("ghost_file.txt")

# Test 2: a directory path instead of a file
print("\n=== Test 2: Directory instead of file ===")
read_file_safely("/tmp")
```

### Output

```
=== Test 1: Missing file ===
Error: 'ghost_file.txt' was not found. Check the filename and path.

=== Test 2: Directory instead of file ===
Error: '/tmp' is a directory, not a file.
```

### Explanation

The function `read_file_safely` wraps the `open()` call inside a `try` block. When `"ghost_file.txt"` is passed, Python raises a `FileNotFoundError` because no such file exists on disk. The first `except FileNotFoundError` clause catches it and prints a user-friendly message instead of crashing. When `"/tmp"` is passed — a valid path but a directory, not a file — Python raises `IsADirectoryError`, which the third `except` clause catches. The `PermissionError` handler covers the case where the file exists but the current user lacks read access.

Using named exception types in each `except` clause — rather than a bare `except:` — is important because it catches only the specific errors the program knows how to handle, allowing unexpected errors to propagate normally (Downey, 2015, p. 145). The `with` statement ensures the file is closed automatically even if an error occurs inside the block.

---

## Part 2: Handling File Errors in a Large Production Program

In a large production program, file errors require a more systematic approach than simple print statements. The following strategies would be appropriate:

**Logging instead of printing**: Production systems use a logging framework (such as Python's built-in `logging` module) to record errors with timestamps, severity levels, and contextual information. This creates an audit trail that developers can review after the fact, rather than relying on console output that may never be seen.

**Retry logic for transient errors**: Some file errors — particularly on network-mounted file systems — are temporary. A production program might catch an `OSError` and retry the operation two or three times with a short delay before giving up, rather than failing immediately on the first attempt.

**Graceful degradation**: If a non-critical file cannot be read, the program should continue operating with reduced functionality rather than shutting down entirely. For example, if a configuration file is missing, the program could fall back to default settings and log a warning.

**User notification and recovery options**: In applications with a user interface, file errors should be surfaced to the user with clear, actionable messages — not raw Python tracebacks. The user should be offered options such as selecting a different file, creating a new one, or canceling the operation.

**Centralized error handling**: Rather than duplicating `try`/`except` blocks throughout the codebase, production programs typically define a centralized error-handling layer or decorator that applies consistent error management across all file operations.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Schafer, C. (2016, April 29). *Python tutorial: File objects - Reading and writing to files* [Video]. YouTube. https://youtu.be/Uh2ebFW8OYM

---

**Word Count**: ~530 words (body, excluding title and references)
