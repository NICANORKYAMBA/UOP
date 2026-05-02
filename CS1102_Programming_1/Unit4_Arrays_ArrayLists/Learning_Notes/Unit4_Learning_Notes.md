# CS 1102 — Unit 4: Arrays and ArrayLists
## Comprehensive Learning Notes
### Source: Eck (2022), Sections 3.8, 7.1, 7.2, 7.3, 7.6

---

## Part 1: Introduction to Arrays (Eck, 2022, Section 3.8)

### 1.1 What is an Array?

An **array** is a data structure in which items are arranged as a numbered sequence, so that each individual item can be referred to by its position number (Eck, 2022, Section 3.8.1). Key terminology:

- **Length**: the number of items in the array
- **Base type**: the type of the individual items (all elements must be the same type)
- **Index**: the position number of an item, always starting at **zero**
- **Element**: an individual item in the array — each acts like a separate variable

Without arrays, storing 1,000 names would require 1,000 separate variables. With an array, a single variable holds the entire list.

### 1.2 Creating and Using Arrays

```java
// Declaration and creation
int[] scores = new int[10];       // array of 10 ints, all initialized to 0
String[] names = new String[5];   // array of 5 Strings, all initialized to null

// Array initializer (declare + fill at once)
int[] primes = {2, 3, 5, 7, 11};  // length is automatically 5

// Accessing elements
scores[0] = 95;        // set first element
scores[9] = 88;        // set last element (index = length - 1)
System.out.println(scores[0]);  // prints 95

// Array length
System.out.println(primes.length);  // prints 5
```

**Important**: Accessing an index outside the range 0 to `length-1` throws `ArrayIndexOutOfBoundsException` (Eck, 2022, Section 7.1).

### 1.3 Arrays are Objects

In Java, arrays are objects. An array variable holds a **reference** to the array, not the array itself. The value of an array variable can be `null`, meaning it does not refer to any array. Attempting to access an element of a null array throws `NullPointerException` (Eck, 2022, Section 7.1).

---

## Part 2: Array Details (Eck, 2022, Section 7.1)

### 2.1 For-each Loops with Arrays

The **for-each loop** processes every element in an array without needing an index:

```java
String[] namelist = {"Alice", "Bob", "Carol"};

// Traditional for loop
for (int i = 0; i < namelist.length; i++) {
    System.out.println(namelist[i]);
}

// For-each loop — cleaner, no index needed
for (String name : namelist) {
    System.out.println(name);
}
```

Syntax: `for (BaseType item : array) { ... }`

The for-each loop is ideal when you need to process every element and do not need the index. Use a traditional for loop when you need the index value (Eck, 2022, Section 7.1.1).

### 2.2 Array Copy

Assigning one array variable to another does NOT copy the array — it copies the reference:

```java
int[] A = {1, 2, 3};
int[] B = A;       // B and A now point to the SAME array
B[0] = 99;
System.out.println(A[0]);  // prints 99 — A was also changed!

// To make a true copy:
int[] C = new int[A.length];
for (int i = 0; i < A.length; i++) {
    C[i] = A[i];
}
// Or use: int[] C = Arrays.copyOf(A, A.length);
```

### 2.3 Partially Full Arrays

When the number of items to store is not known in advance, use a **partially full array** pattern: allocate a large array and track how many positions are actually in use with a counter variable (Eck, 2022, Section 7.2).

```java
int[] data = new int[100];  // allocate space for up to 100 items
int count = 0;              // how many items are actually stored

// Add an item
data[count] = 42;
count++;

// Process only the used portion
for (int i = 0; i < count; i++) {
    System.out.println(data[i]);
}
```

---

## Part 3: Array Processing (Eck, 2022, Section 7.2)

### 3.1 Common Off-by-One Error

A classic mistake when processing consecutive pairs of elements:

```java
// WRONG — causes ArrayIndexOutOfBoundsException on last iteration
for (int i = 0; i < array.length; i++) {
    if (array[i] == array[i+1]) { ... }  // i+1 goes out of range when i = length-1
}

// CORRECT — stop one before the end
for (int i = 0; i < array.length - 1; i++) {
    if (array[i] == array[i+1]) { ... }
}
```

### 3.2 Searching an Array

**Linear search** — check each element one by one:

```java
static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) return i;  // return index if found
    }
    return -1;  // not found
}
```

**Binary search** — only works on a sorted array, much faster (O(log n) vs O(n)):

```java
// Java provides: Arrays.binarySearch(arr, target)
import java.util.Arrays;
int[] sorted = {2, 5, 8, 12, 16};
int idx = Arrays.binarySearch(sorted, 8);  // returns 2
```

### 3.3 Sorting Arrays

```java
import java.util.Arrays;
int[] nums = {5, 2, 8, 1, 9};
Arrays.sort(nums);  // sorts in ascending order: {1, 2, 5, 8, 9}
```

`Arrays.sort()` uses a highly optimized algorithm (dual-pivot quicksort for primitives). Time complexity: O(n log n).

### 3.4 Useful Methods from java.util.Arrays

```java
Arrays.sort(arr)              // sort in ascending order
Arrays.binarySearch(arr, val) // search sorted array, returns index or negative
Arrays.copyOf(arr, newLength) // copy array, truncate or pad with zeros
Arrays.fill(arr, val)         // fill all elements with a value
Arrays.toString(arr)          // convert to readable string "[1, 2, 3]"
Arrays.equals(arr1, arr2)     // true if same length and same elements
```

---

## Part 4: ArrayList (Eck, 2022, Section 7.3)

### 4.1 Why ArrayList?

Arrays have a fixed size — once created, the length cannot change. The **ArrayList** class implements a **dynamic array** that automatically resizes as elements are added or removed (Eck, 2022, Section 7.3).

ArrayList is a **parameterized type** — you specify the element type in angle brackets:

```java
import java.util.ArrayList;

ArrayList<String> names = new ArrayList<String>();
ArrayList<Integer> scores = new ArrayList<>();  // diamond operator shorthand
```

**Important**: ArrayList cannot hold primitive types directly. Use **wrapper classes**:
- `int` → `Integer`
- `double` → `Double`
- `char` → `Character`
- `boolean` → `Boolean`

Java's **autoboxing** automatically converts between primitives and their wrappers:
```java
ArrayList<Integer> nums = new ArrayList<>();
nums.add(42);        // autoboxing: int 42 → Integer(42)
int x = nums.get(0); // unboxing: Integer(42) → int 42
```

### 4.2 ArrayList Methods

| Method | Description |
|--------|-------------|
| `list.size()` | Returns number of elements currently in the list |
| `list.add(obj)` | Adds obj to the end of the list |
| `list.add(N, obj)` | Inserts obj at position N, shifting others right |
| `list.get(N)` | Returns element at position N |
| `list.set(N, obj)` | Replaces element at position N with obj |
| `list.remove(N)` | Removes element at position N, shifts others left |
| `list.remove(obj)` | Removes first occurrence of obj |
| `list.indexOf(obj)` | Returns index of first occurrence, or -1 |
| `list.clear()` | Removes all elements |
| `list.contains(obj)` | Returns true if obj is in the list |

```java
ArrayList<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");
System.out.println(fruits.size());      // 3
System.out.println(fruits.get(1));      // "Banana"
fruits.set(1, "Blueberry");
fruits.remove(0);                       // removes "Apple"
System.out.println(fruits);            // [Blueberry, Cherry]
```

### 4.3 Iterating an ArrayList

```java
// Traditional for loop with index
for (int i = 0; i < fruits.size(); i++) {
    System.out.println(fruits.get(i));
}

// For-each loop (preferred when index not needed)
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

### 4.4 Wrapper Classes

Since ArrayList cannot hold primitives, Java provides wrapper classes. The static methods are also useful:

```java
Integer.parseInt("42")      // String → int
Double.parseDouble("3.14")  // String → double
Integer.MAX_VALUE           // 2147483647
Integer.MIN_VALUE           // -2147483648
Character.isLetter('A')     // true
Character.isDigit('5')      // true
```

---

## Part 5: Two-Dimensional Arrays (Eck, 2022, Section 7.6)

### 5.1 Creating 2D Arrays

A 2D array is an array of arrays — each row is itself a 1D array:

```java
int[][] grid = new int[3][4];  // 3 rows, 4 columns

// Array initializer
int[][] matrix = {
    {1, 0, 12, -1},
    {7, -3,  2,  5},
    {-5, -2, 2, -9}
};

// Access element at row 1, column 2
System.out.println(matrix[1][2]);  // prints 2
```

### 5.2 Processing 2D Arrays with Nested Loops

```java
// Print all elements
for (int row = 0; row < matrix.length; row++) {
    for (int col = 0; col < matrix[row].length; col++) {
        System.out.printf("%4d", matrix[row][col]);
    }
    System.out.println();
}

// For-each version
for (int[] row : matrix) {
    for (int val : row) {
        System.out.printf("%4d", val);
    }
    System.out.println();
}
```

### 5.3 The Truth About 2D Arrays in Java

Java does not have true 2D arrays. A `int[][]` is an array of `int[]` references — each row is a separate 1D array object in memory. This means rows can have different lengths (**jagged arrays**):

```java
int[][] jagged = new int[3][];
jagged[0] = new int[5];
jagged[1] = new int[3];
jagged[2] = new int[7];
```

---

## Part 6: Arrays vs ArrayLists — Comparison

| Feature | Array | ArrayList |
|---------|-------|-----------|
| Size | Fixed at creation | Dynamic — grows/shrinks automatically |
| Syntax | `int[] arr = new int[10]` | `ArrayList<Integer> list = new ArrayList<>()` |
| Element access | `arr[i]` | `list.get(i)` |
| Element update | `arr[i] = val` | `list.set(i, val)` |
| Length/size | `arr.length` | `list.size()` |
| Primitive types | Yes (int, double, etc.) | No — must use wrapper classes |
| Performance | Faster (direct memory access) | Slightly slower (object overhead) |
| Built-in methods | Limited (via Arrays class) | Rich API (add, remove, contains, etc.) |
| Memory | Contiguous, fixed allocation | Dynamic, may over-allocate |
| Multi-dimensional | Yes (`int[][]`) | Nested: `ArrayList<ArrayList<Integer>>` |

**When to use arrays:**
- Size is known and fixed
- Performance-critical code (games, image processing)
- Working with primitive types
- Multi-dimensional data (matrices, grids)

**When to use ArrayList:**
- Size changes at runtime (unknown number of elements)
- Need to insert or remove elements in the middle
- Want built-in methods (contains, indexOf, remove by value)
- Working with objects rather than primitives

---

## Key Terms

| Term | Definition |
|------|-----------|
| Array | Fixed-size numbered sequence of same-type elements |
| Base type | The type of elements in an array |
| Index | Position number of an element (starts at 0) |
| Length | Number of elements in an array (`arr.length`) |
| For-each loop | `for (Type item : array)` — iterates all elements |
| ArrayList | Dynamic array from java.util — resizes automatically |
| Parameterized type | Type with a type parameter: `ArrayList<String>` |
| Wrapper class | Object version of a primitive: `Integer`, `Double`, etc. |
| Autoboxing | Automatic conversion between primitive and wrapper |
| 2D array | Array of arrays — rows and columns |
| Jagged array | 2D array where rows have different lengths |
| ArrayIndexOutOfBoundsException | Thrown when index is outside valid range |

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
