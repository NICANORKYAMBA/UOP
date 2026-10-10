# Unit 6 Learning Notes: Generic Programming

Course: CS 1103 Programming 2
Readings: Eck (2022), Chapter 10; Divertitto (2022), CodeGym; Kumar (2023), Tech Thoughts Explorer
Videos: Bro Code (2020), Java generics; Coding with John (2021), Generics in Java

Due October 14, 2026: Discussion (post by **Sunday Oct 11**, 2 replies by **Wednesday Oct 14**),
Programming Assignment (Generic Library Catalog), and the quiz.

---

## 1. Why generics
- **Type safety at compile time:** a List<String> rejects an Integer when you compile.
- **No casts:** list.get(0) already has type String.
- **Reuse:** one class or method works for many types.

## 2. Syntax
- Generic class: `class Box<T> { private T value; }`
- Generic method: `static <T> T first(List<T> list)` (the `<T>` goes before the return type)
- Bounded type parameter: `<T extends Number>` (T must be Number or a subclass; an **upper bound**)
- Wildcards: `List<?>` (any), `List<? extends Number>` (upper bound, read from it),
  `List<? super Integer>` (lower bound, write to it)

## 3. Rules and restrictions
- **No primitives** as type arguments: `List<int>` is a **compile-time error**; use `Integer`.
- **Type erasure:** type arguments are removed after compilation, so `new T()`, `new T[10]`, and
  `instanceof List<String>` are not allowed.
- **Invariance:** `List<Integer>` is **not** a `List<Number>`; use `List<? extends Number>`.
- **Raw types** (`List` with no `<>`) compile with an "unchecked" warning; avoid them.
- A static method cannot use the class's T; it declares its own type parameter.

## 4. Generics in the Collection Framework
| Class | Notes |
|---|---|
| ArrayList<E>, LinkedList<E> | ordered lists |
| HashSet<E> | no duplicates, no order |
| TreeSet<E> | no duplicates, **sorted** |
| HashMap<K,V> | key-value, no order |
| TreeMap<K,V> | key-value, **sorted by key** |
| LinkedHashMap<K,V> | key-value, insertion order (used in the catalog) |
| PriorityQueue<E> | removes the smallest (highest-priority) element first |

## Self-Quiz answers (ungraded practice, reviews Units 4 to 6)

| # | Answer | Why |
|---|---|---|
| 1 | The result of a SQL query | executeQuery() returns a ResultSet |
| 2 | Statement | base interface for SQL statements |
| 3 | Identifying the database | jdbc:mysql://host:3306/dbname |
| 4 | By using generic types | the compiler checks every element |
| 5 | To represent any data type | T is filled in when the class is used |
| 6 | PrintWriter | print, println, printf for formatted text |
| 7 | registerDriver() | DriverManager.registerDriver() |
| 8 | To execute parameterized SQL queries | closest option (strictly PreparedStatement adds parameters) |
| 9 | TreeMap | keeps keys sorted |
| 10 | Connection | returned by DriverManager.getConnection() |
| 11 | Writing characters to a char array | CharArrayWriter writes into memory |
| 12 | To execute parameterized SQL queries | ? placeholders |
| 13 | QueryStatement | does not exist |
| 14 | It generates a compile-time error | use Integer instead of int |
| 15 | To specify an upper bound for a type parameter | <T extends Number> |

**Self-Quiz, remaining questions:**

| # | Answer | Why |
|---|---|---|
| 1 | List | Set, List, Map and Iterable are all generic; List is the expected answer (try Map if marked wrong) |
| 2 | class | `class Box<T>` |
| 3 | Generics allow you to write type-safe code | the other options are false |
| 4 | <T> | `static <T> T first(List<T> list)` |
| 5 | Producer, Extends, Consumer, Super | PECS: `? extends` to read, `? super` to write |
