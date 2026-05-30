# CS 1102 — Unit 8: Collection API and Java 8 Features
## Comprehensive Learning Notes
### Source: Eck (2022), Chapter 4 (4.5.2), Chapter 10 (10.2, 10.3, 10.6), Chapter 12 (12.1–12.4)

---

## Part 1: Multithreading (Chapter 12)

### 1.1 What is a Thread?

A **thread** is a single sequential flow of execution within a program. A Java program starts with one thread (the main thread), but can create additional threads to perform tasks concurrently. Eck (2022) explains that multithreading allows a program to do multiple things at the same time — for example, downloading a file while updating the GUI (Section 12.1).

### 1.2 Creating Threads

**Method 1 — Extending the Thread class:**

```java
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Thread running: " + getName());
    }
}

MyThread t = new MyThread();
t.start();  // starts a new thread that executes run()
```

**Method 2 — Implementing the Runnable interface (preferred):**

```java
public class MyTask implements Runnable {
    @Override
    public void run() {
        System.out.println("Task running: " + Thread.currentThread().getName());
    }
}

Thread t = new Thread(new MyTask());
t.start();
```

**Method 3 — Lambda expression (Java 8+):**

```java
Thread t = new Thread(() -> {
    System.out.println("Lambda thread running");
});
t.start();
```

### 1.3 Thread Lifecycle

| State | Description |
|-------|-------------|
| NEW | Thread created but not yet started |
| RUNNABLE | Thread is executing or ready to execute |
| BLOCKED | Waiting to acquire a lock |
| WAITING | Waiting indefinitely for another thread |
| TIMED_WAITING | Waiting for a specified time |
| TERMINATED | Thread has finished execution |

### 1.4 Thread Synchronization

When multiple threads access shared data, **race conditions** can occur. Synchronization prevents this:

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;  // only one thread can execute this at a time
    }

    public synchronized int getCount() {
        return count;
    }
}
```

### 1.5 Benefits and Challenges

| Benefits | Challenges |
|----------|-----------|
| Improved performance on multi-core CPUs | Race conditions |
| Better responsiveness (UI stays active) | Deadlocks |
| Efficient resource utilization | Thread safety complexity |
| Parallel processing of large datasets | Debugging difficulty |

---

## Part 2: Collection Framework (Chapter 10)

### 2.1 What is the Collection Framework?

The Java Collection Framework is a unified architecture for representing and manipulating groups of objects. It provides interfaces, implementations, and algorithms that reduce programming effort and increase performance (Eck, 2022, Section 10.2).

### 2.2 Collection Hierarchy

```
Iterable
  └── Collection
        ├── List (ordered, allows duplicates)
        │     ├── ArrayList
        │     ├── LinkedList
        │     └── Vector
        ├── Set (no duplicates)
        │     ├── HashSet
        │     ├── LinkedHashSet
        │     └── TreeSet (sorted)
        └── Queue
              ├── PriorityQueue
              └── Deque → ArrayDeque

Map (key-value pairs, not part of Collection interface)
  ├── HashMap
  ├── LinkedHashMap
  └── TreeMap (sorted by key)
```

### 2.3 List Interface (Section 10.2)

Ordered collection that allows duplicate elements. Access by index.

```java
List<String> names = new ArrayList<>();
names.add("Alice");
names.add("Bob");
names.add("Alice");  // duplicates allowed
System.out.println(names.get(0));  // "Alice"
System.out.println(names.size());  // 3
```

| Implementation | Characteristics |
|---------------|----------------|
| `ArrayList` | Fast random access (O(1)), slow insert/delete in middle |
| `LinkedList` | Fast insert/delete (O(1) at ends), slow random access |

### 2.4 Set Interface (Section 10.2)

Collection that does NOT allow duplicate elements.

```java
Set<String> uniqueNames = new HashSet<>();
uniqueNames.add("Alice");
uniqueNames.add("Bob");
uniqueNames.add("Alice");  // ignored — already exists
System.out.println(uniqueNames.size());  // 2
```

| Implementation | Characteristics |
|---------------|----------------|
| `HashSet` | Fastest (O(1) add/contains), no order guarantee |
| `LinkedHashSet` | Maintains insertion order |
| `TreeSet` | Sorted order, O(log n) operations |

### 2.5 Map Interface (Section 10.3)

Stores key-value pairs. Keys must be unique.

```java
Map<String, Integer> ages = new HashMap<>();
ages.put("Alice", 25);
ages.put("Bob", 30);
ages.put("Alice", 26);  // overwrites previous value for "Alice"

System.out.println(ages.get("Alice"));  // 26
System.out.println(ages.containsKey("Bob"));  // true

// Iterate over entries
for (Map.Entry<String, Integer> entry : ages.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
```

| Implementation | Characteristics |
|---------------|----------------|
| `HashMap` | Fastest (O(1)), no order guarantee |
| `LinkedHashMap` | Maintains insertion order |
| `TreeMap` | Sorted by key, O(log n) operations |

### 2.6 Iterator

An `Iterator` provides a way to traverse a collection element by element:

```java
List<String> list = Arrays.asList("A", "B", "C");
Iterator<String> it = list.iterator();
while (it.hasNext()) {
    String item = it.next();
    System.out.println(item);
}
```

---

## Part 3: Functional Interfaces (Section 4.5.2)

### 3.1 What is a Functional Interface?

A **functional interface** is an interface that contains exactly one abstract method. It can be used as the target for a lambda expression or method reference. Eck (2022) explains that functional interfaces enable Java to treat functions as first-class values (Section 4.5.2).

```java
@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}
```

### 3.2 Built-in Functional Interfaces (java.util.function)

| Interface | Method | Purpose |
|-----------|--------|---------|
| `Function<T, R>` | `R apply(T t)` | Takes T, returns R |
| `Predicate<T>` | `boolean test(T t)` | Takes T, returns boolean |
| `Consumer<T>` | `void accept(T t)` | Takes T, returns nothing |
| `Supplier<T>` | `T get()` | Takes nothing, returns T |
| `UnaryOperator<T>` | `T apply(T t)` | Takes T, returns same type T |
| `BiFunction<T, U, R>` | `R apply(T t, U u)` | Takes T and U, returns R |

### 3.3 Using Function Interface

```java
import java.util.function.Function;

// Function that takes a String and returns its length
Function<String, Integer> strLength = s -> s.length();
System.out.println(strLength.apply("Hello"));  // 5

// Function that takes an Employee and returns name + department
Function<Employee, String> nameAndDept = emp ->
    emp.getName() + " - " + emp.getDepartment();
```

### 3.4 Chaining Functions

```java
Function<Integer, Integer> doubleIt = x -> x * 2;
Function<Integer, Integer> addTen = x -> x + 10;

// Compose: first doubleIt, then addTen
Function<Integer, Integer> doubleThenAdd = doubleIt.andThen(addTen);
System.out.println(doubleThenAdd.apply(5));  // (5*2) + 10 = 20

// Compose: first addTen, then doubleIt
Function<Integer, Integer> addThenDouble = doubleIt.compose(addTen);
System.out.println(addThenDouble.apply(5));  // (5+10) * 2 = 30
```

---

## Part 4: Stream API (Section 10.6)

### 4.1 What is a Stream?

A **stream** is a sequence of elements that supports sequential and parallel aggregate operations. Unlike collections, streams do not store data — they process data from a source (collection, array, I/O) through a pipeline of operations (Eck, 2022, Section 10.6).

### 4.2 Stream vs Collection

| Feature | Collection | Stream |
|---------|-----------|--------|
| Storage | Stores elements in memory | Does not store — processes on demand |
| Consumption | Can be iterated multiple times | Can only be consumed once |
| Evaluation | Eager (all elements loaded) | Lazy (processes only when needed) |
| Modification | Can add/remove elements | Cannot modify source |
| Purpose | Data storage | Data processing |

### 4.3 Stream Pipeline

```
Source → Intermediate Operations → Terminal Operation
```

- **Source**: Collection, array, generator
- **Intermediate**: `filter()`, `map()`, `sorted()`, `distinct()` — return a new stream (lazy)
- **Terminal**: `collect()`, `forEach()`, `count()`, `reduce()`, `average()` — produce a result (triggers execution)

### 4.4 Common Stream Operations

```java
List<Employee> employees = Arrays.asList(
    new Employee("Alice", 28, "Engineering", 75000),
    new Employee("Bob", 35, "Marketing", 65000),
    new Employee("Carol", 42, "Engineering", 90000),
    new Employee("David", 31, "HR", 55000)
);

// Filter: employees over 30
List<Employee> over30 = employees.stream()
    .filter(e -> e.getAge() > 30)
    .collect(Collectors.toList());

// Map: extract names
List<String> names = employees.stream()
    .map(Employee::getName)
    .collect(Collectors.toList());

// Average salary
OptionalDouble avgSalary = employees.stream()
    .mapToDouble(Employee::getSalary)
    .average();

// Count
long count = employees.stream()
    .filter(e -> e.getDepartment().equals("Engineering"))
    .count();

// Sorted by salary descending
List<Employee> sorted = employees.stream()
    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
    .collect(Collectors.toList());
```

### 4.5 Lazy Evaluation

Stream operations are lazy — intermediate operations are not executed until a terminal operation is invoked:

```java
employees.stream()
    .filter(e -> {
        System.out.println("Filtering: " + e.getName());
        return e.getAge() > 30;
    })
    .findFirst();  // only processes until first match is found
```

This is **short-circuiting** — `findFirst()` stops processing once it finds one element, even if the list has thousands of entries.

### 4.6 Parallel Streams

```java
double avgSalary = employees.parallelStream()
    .mapToDouble(Employee::getSalary)
    .average()
    .orElse(0.0);
```

Parallel streams split the work across multiple threads automatically — useful for large datasets.

---

## Key Terms Summary

| Term | Definition |
|------|-----------|
| Thread | Single sequential flow of execution |
| Runnable | Functional interface with `run()` method for thread tasks |
| Synchronization | Mechanism to prevent race conditions on shared data |
| Collection | Group of objects managed as a single unit |
| List | Ordered collection allowing duplicates |
| Set | Collection that rejects duplicates |
| Map | Key-value pair storage (keys unique) |
| Iterator | Object for traversing a collection element by element |
| Functional Interface | Interface with exactly one abstract method |
| Function<T,R> | Takes input T, produces output R |
| Predicate<T> | Takes input T, returns boolean |
| Stream | Lazy, non-storing pipeline for processing data |
| Intermediate operation | Returns a new stream (lazy) — filter, map, sorted |
| Terminal operation | Produces a result (triggers execution) — collect, forEach, count |
| Lazy evaluation | Operations execute only when terminal operation is called |
| Parallel stream | Stream that processes elements across multiple threads |

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Creative Commons CC 4.0. [https://math.hws.edu/javanotes/](https://math.hws.edu/javanotes/)

Coding with John. (2021, June 28). *Multithreading in Java explained in 10 minutes* [Video]. YouTube. https://youtu.be/r_MbozD32eo

Easy Learning. (2019, December 24). *Built in functional interfaces in Java* [Video]. YouTube. https://youtu.be/dN5r2jWfRas

Programming with Mosh. (2022, March 1). *Java collections tutorial* [Video]. YouTube. https://youtu.be/GdAon80-0KA
