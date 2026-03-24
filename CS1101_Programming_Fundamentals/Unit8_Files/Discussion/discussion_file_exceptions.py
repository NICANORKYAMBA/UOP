# discussion_file_exceptions.py — CS1101 Unit 8 Discussion

# Demonstrate exception handling for file errors using try/except.
# Three common file errors are shown:
#   FileNotFoundError  — file does not exist
#   PermissionError    — no read access
#   IsADirectoryError  — path points to a directory, not a file

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


# --- Test 1: file that does not exist ---
print("=== Test 1: Missing file ===")
read_file_safely("ghost_file.txt")

# --- Test 2: a directory path instead of a file ---
print("\n=== Test 2: Directory instead of file ===")
read_file_safely("/tmp")
