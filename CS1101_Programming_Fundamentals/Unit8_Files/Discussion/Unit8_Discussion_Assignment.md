# CS1101 Unit 8 Discussion Assignment — File Exception Handling

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 8 — Files  
**Date**: March 2026

---

## Part 1: How Exception Handling Helps with File Errors

One of the first things I noticed when working with files in Python is how many things can quietly go wrong before your program even gets to do anything useful. The file might not exist, you might not have permission to open it, or the path you typed might point to a folder instead of a file. Without exception handling, any of these situations causes Python to raise an error and stop the program immediately — which is frustrating for users and unhelpful for debugging.

Python's `try`/`except` blocks solve this by letting you anticipate specific failures and respond to them gracefully. As Downey (2015) explains, "if you try to open a file that doesn't exist, you get a `FileNotFoundError`" (p. 145). The `try` block wraps the code that might fail; the `except` block names the specific exception to catch and defines what to do when it occurs. If the exception matches, the handler runs instead of the program crashing. If it doesn't match, the error propagates normally — which is exactly what you want, because a bare `except:` that catches everything can hide bugs you didn't know existed.

Here is an example that handles three of the most common file errors:

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

**Output:**

```
=== Test 1: Missing file ===
Error: 'ghost_file.txt' was not found. Check the filename and path.

=== Test 2: Directory instead of file ===
Error: '/tmp' is a directory, not a file.
```

**What is happening here:** The function wraps `open()` inside a `try` block. When `"ghost_file.txt"` is passed, Python raises `FileNotFoundError` because no such file exists on disk — the first `except` clause catches it and prints a clear message. When `"/tmp"` is passed — a real path, but a directory — Python raises `IsADirectoryError`, which the third `except` clause handles. The `PermissionError` handler covers the case where the file exists but the current user lacks read access.

Two design choices here are worth noting. First, I used the `with` statement as a context manager, which guarantees the file is closed automatically when the block exits — even if an error occurs inside it (Downey, 2015, p. 141). Second, each `except` clause names a specific exception rather than using a bare `except:`. This is important because it means only the errors the program knows how to handle are caught; anything unexpected still propagates and gets noticed (Downey, 2015, p. 145).

---

## Part 2: Handling File Errors in a Large Production Program

In a small script, printing an error message and moving on is usually fine. In a large production program, though, that approach breaks down quickly — nobody is watching the console, errors need to be traceable after the fact, and a single file failure should not bring down an entire system.

The first thing I would change is replacing `print()` statements with a proper logging framework. Python's built-in `logging` module records errors with timestamps, severity levels, and contextual information that gets written to a log file. This creates a permanent audit trail that developers can search through hours or days after an incident, which is far more useful than console output that disappears the moment the terminal closes.

The second consideration is distinguishing between errors that are permanent and errors that are temporary. On a network-mounted file system, for example, a file might be temporarily unavailable due to a network hiccup rather than genuinely missing. A production program would implement retry logic — catching the error, waiting a short interval, and trying again a fixed number of times before giving up. This prevents a transient network issue from being treated as a fatal failure.

Third, I would think carefully about graceful degradation. If a non-critical file — say, a user preferences file — cannot be read, the program should continue running with sensible defaults rather than shutting down entirely. The error gets logged, the user might see a notification, but the application keeps working. Contrast this with a critical configuration file: if that is missing, the program genuinely cannot proceed, and a clear, informative error message should explain exactly what is missing and where it should be.

Finally, in a large codebase, I would avoid scattering `try`/`except` blocks throughout every function that touches a file. Instead, I would define a centralized file-handling utility — a single module or class responsible for all file I/O — so that error handling logic lives in one place, is tested once, and behaves consistently everywhere it is used. This makes the codebase easier to maintain and reduces the risk of one developer handling errors differently from another.

---

**Discussion Question:** When you were writing your exception handling code, did you use a single broad `except Exception` to catch everything, or did you name specific exceptions like `FileNotFoundError`? What made you choose that approach, and did you run into any situations where catching a specific exception wasn't enough?

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

Schafer, C. (2016, April 29). *Python tutorial: File objects - Reading and writing to files* [Video]. YouTube. https://youtu.be/Uh2ebFW8OYM

---

**Word Count**: ~750 words (body, excluding title and references)
