# file_dict.py — CS1101 Unit 8 Programming Assignment
# Reads a dictionary from a text file, inverts it, and writes the result to a new file.
# Uses exception handling throughout for robust file error management.

def read_dict_from_file(filename):
    """
    Read key:value pairs from a text file and return them as a dictionary.
    Each line must have the format:  key: value
    Lines that are blank or malformed are skipped.
    """
    d = {}
    try:
        with open(filename, 'r') as f:
            for line in f:
                line = line.strip()
                if not line:          # skip blank lines
                    continue
                if ':' not in line:   # skip malformed lines
                    continue
                key, value = line.split(':', 1)
                d[key.strip()] = value.strip()
    except FileNotFoundError:
        print(f"Error: Input file '{filename}' not found.")
    except PermissionError:
        print(f"Error: No permission to read '{filename}'.")
    return d


def invert_dict(d):
    """
    Invert a dictionary so that each value becomes a key mapping to a list
    of all original keys that had that value.
    Example: {'apple': 'red', 'cherry': 'red'} -> {'red': ['apple', 'cherry']}
    """
    inverse = {}
    for key, value in d.items():
        if value not in inverse:
            inverse[value] = [key]
        else:
            inverse[value].append(key)
    return inverse


def write_dict_to_file(d, filename):
    """
    Write an inverted dictionary to a text file.
    Each line has the format:  key: value1, value2, ...
    """
    try:
        with open(filename, 'w') as f:
            for key, values in d.items():
                line = key + ': ' + ', '.join(values)
                f.write(line + '\n')
        print(f"Inverted dictionary written to '{filename}'.")
    except PermissionError:
        print(f"Error: No permission to write to '{filename}'.")


# ── Main program ──────────────────────────────────────────────────────────────

INPUT_FILE  = 'fruits.txt'
OUTPUT_FILE = 'fruits_inverted.txt'

# Step 1: Read the original dictionary from file
original = read_dict_from_file(INPUT_FILE)

print("Original dictionary (read from file):")
for fruit, color in original.items():
    print(f"  {fruit}: {color}")

# Step 2: Invert the dictionary
inverted = invert_dict(original)

print("\nInverted dictionary:")
for color, fruits in inverted.items():
    print(f"  {color}: {', '.join(fruits)}")

# Step 3: Write the inverted dictionary to a new file
print()
write_dict_to_file(inverted, OUTPUT_FILE)
