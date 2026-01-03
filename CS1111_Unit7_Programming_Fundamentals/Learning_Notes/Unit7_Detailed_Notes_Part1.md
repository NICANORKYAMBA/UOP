# CS1111 Unit 7: Programming Fundamentals - Detailed Notes Part 1

## Programming Paradigms: Comprehensive Overview

### 1. What is a Programming Paradigm?

A programming paradigm is a fundamental style or approach to programming that provides a framework for structuring and organizing code. Different paradigms offer different ways of thinking about and solving problems (MV, 2019).

**Key Insight:** "A programming paradigm is a way of thinking about and structuring code. It's not about which language you use, but how you use it" (MV, 2019).

---

## 2. Structured Programming

### 2.1 Definition and History

Structured programming emerged in the 1960s as a response to the "software crisis" caused by increasingly complex programs written with GOTO statements, creating "spaghetti code" that was difficult to understand and maintain (Busbee & Braunschweig, 2018).

**Core Philosophy:** "Structured programming is a programming paradigm aimed at improving the clarity, quality, and development time of a computer program by making extensive use of subroutines, block structures, and loops" (Busbee & Braunschweig, 2018).

### 2.2 Three Basic Control Structures

According to Busbee & Braunschweig (2018), structured programming relies on three fundamental control structures:

**1. Sequence**
- Instructions execute one after another in order
- Default flow of control
- Most straightforward structure

**2. Selection (Decision)**
- Allows program to choose between alternative paths
- Implemented using IF-THEN-ELSE statements
- Enables conditional execution

**3. Iteration (Repetition)**
- Allows repeated execution of code blocks
- Implemented using WHILE, FOR, DO-WHILE loops
- Enables efficient handling of repetitive tasks

### 2.3 Key Principles of Structured Programming

**Modularity:**
Breaking programs into smaller, manageable procedures or functions. Each module performs a specific task and can be developed, tested, and debugged independently (Busbee & Braunschweig, 2018).

**Top-Down Design:**
Starting with high-level problem description and progressively breaking it down into smaller, more detailed sub-problems until each can be easily coded.

**Single Entry, Single Exit:**
Each control structure should have one entry point and one exit point, making program flow predictable and easier to trace.

**Avoidance of GOTO:**
Structured programming eliminates or minimizes use of GOTO statements, which can create unpredictable program flow.

### 2.4 Benefits of Structured Programming

According to Busbee & Braunschweig (2018):
- **Improved Readability:** Code is easier to read and understand
- **Easier Maintenance:** Changes can be made with less risk of introducing errors
- **Better Testing:** Individual modules can be tested independently
- **Reduced Complexity:** Breaking problems into smaller parts reduces cognitive load
- **Enhanced Reliability:** Structured approach leads to fewer bugs

### 2.5 Example: Structured Programming Approach

```
Function CalculateEmployeePay(hoursWorked, hourlyRate):
    // Sequence: Steps execute in order
    regularHours = 40
    overtimeRate = 1.5
    
    // Selection: Decision based on condition
    IF hoursWorked <= regularHours:
        totalPay = hoursWorked * hourlyRate
    ELSE:
        regularPay = regularHours * hourlyRate
        overtimeHours = hoursWorked - regularHours
        overtimePay = overtimeHours * hourlyRate * overtimeRate
        totalPay = regularPay + overtimePay
    END IF
    
    RETURN totalPay
END Function

// Main Program
BEGIN
    // Iteration: Process multiple employees
    FOR each employee in employeeList:
        pay = CalculateEmployeePay(employee.hours, employee.rate)
        Display employee.name, pay
    END FOR
END
```

---

## 3. Functional Programming

### 3.1 Core Concepts

Functional programming treats computation as the evaluation of mathematical functions and avoids changing state and mutable data (MV, 2019).

**Key Characteristics:**

**1. Pure Functions**
A pure function always produces the same output for the same input and has no side effects (MV, 2019).

Example:
```
// Pure function
Function add(a, b):
    RETURN a + b
// Always returns same result for same inputs

// Impure function (has side effect)
total = 0
Function addToTotal(value):
    total = total + value  // Modifies external state
    RETURN total
```

**2. Immutability**
Data cannot be modified after creation. Instead of changing existing data, new data structures are created (MV, 2019).

**3. First-Class Functions**
Functions are treated as values - they can be assigned to variables, passed as arguments, and returned from other functions.

**4. Higher-Order Functions**
Functions that take other functions as parameters or return functions as results.

Example:
```
Function map(function, list):
    result = []
    FOR each item in list:
        result.append(function(item))
    RETURN result

Function double(x):
    RETURN x * 2

numbers = [1, 2, 3, 4, 5]
doubled = map(double, numbers)
// Result: [2, 4, 6, 8, 10]
```

### 3.2 Advantages of Functional Programming

According to MV (2019):
- **Easier Testing:** Pure functions are predictable and easy to test
- **Parallel Processing:** No shared state makes parallelization safer
- **Fewer Bugs:** Immutability eliminates entire classes of bugs
- **Mathematical Reasoning:** Code behavior can be proven mathematically
- **Composability:** Small functions can be combined to build complex operations

### 3.3 When to Use Functional Programming

- Data transformation pipelines
- Concurrent/parallel processing
- Mathematical computations
- Big data processing (MapReduce)
- Situations requiring high reliability

---

## 4. Object-Oriented Programming (OOP)

### 4.1 Historical Context

Object-Oriented Programming emerged to handle increasing software complexity by organizing code around "objects" that combine data and behavior, modeling real-world entities (Yatsko & Suslow, 2016).

### 4.2 Four Pillars of OOP

**1. Encapsulation**

Bundling data (attributes) and methods (functions) that operate on that data within a single unit (class), and restricting direct access to some components (Yatsko & Suslow, 2016).

**Benefits:**
- Data hiding and protection
- Controlled access through methods
- Reduces coupling between components
- Easier to modify internal implementation

Example:
```
Class BankAccount:
    // Private attributes (encapsulated)
    PRIVATE balance
    PRIVATE accountNumber
    
    // Public methods (interface)
    PUBLIC Function deposit(amount):
        IF amount > 0:
            balance = balance + amount
            RETURN true
        RETURN false
    
    PUBLIC Function withdraw(amount):
        IF amount > 0 AND amount <= balance:
            balance = balance - amount
            RETURN true
        RETURN false
    
    PUBLIC Function getBalance():
        RETURN balance
```

**2. Inheritance**

Creating new classes (child/derived classes) based on existing classes (parent/base classes), inheriting their attributes and methods (Yatsko & Suslow, 2016).

**Benefits:**
- Code reusability
- Establishes hierarchical relationships
- Supports polymorphism
- Reduces redundancy

Example:
```
Class Vehicle:
    PROTECTED speed
    PROTECTED fuel
    
    PUBLIC Function start():
        Display "Vehicle starting"
    
    PUBLIC Function stop():
        Display "Vehicle stopping"

Class Car EXTENDS Vehicle:
    PRIVATE numberOfDoors
    
    PUBLIC Function start():
        Display "Car engine starting"
        // Overrides parent method
    
    PUBLIC Function honk():
        Display "Beep beep!"
        // New method specific to Car
```

**3. Polymorphism**

The ability of different objects to respond to the same message (method call) in different ways (Yatsko & Suslow, 2016).

**Types:**
- **Compile-time (Method Overloading):** Same method name, different parameters
- **Runtime (Method Overriding):** Child class provides specific implementation

Example:
```
Class Shape:
    PUBLIC Function calculateArea():
        // Abstract method

Class Circle EXTENDS Shape:
    PRIVATE radius
    
    PUBLIC Function calculateArea():
        RETURN 3.14159 * radius * radius

Class Rectangle EXTENDS Shape:
    PRIVATE width
    PRIVATE height
    
    PUBLIC Function calculateArea():
        RETURN width * height

// Polymorphism in action
shapes = [Circle(5), Rectangle(4, 6), Circle(3)]
FOR each shape in shapes:
    Display shape.calculateArea()
    // Each shape calculates area differently
```

**4. Abstraction**

Hiding complex implementation details and showing only essential features (Yatsko & Suslow, 2016).

**Benefits:**
- Reduces complexity
- Focuses on what object does, not how
- Easier to understand and use
- Allows implementation changes without affecting users

### 4.3 Advantages of OOP

According to Yatsko & Suslow (2016):
- **Modularity:** Code organized into discrete objects
- **Reusability:** Inheritance and composition enable code reuse
- **Scalability:** Easier to extend and modify large systems
- **Maintainability:** Changes localized to specific classes
- **Real-world Modeling:** Natural way to represent real entities
- **Collaboration:** Different developers can work on different classes

### 4.4 When to Use OOP

- Large, complex applications
- GUI applications
- Game development
- Enterprise software systems
- Systems modeling real-world entities
- Projects requiring long-term maintenance

---

## 5. Comparing Programming Paradigms

### 5.1 Structured vs. OOP

**Structured Programming:**
- Focus: Procedures and functions
- Data: Separate from functions
- Best for: Small to medium programs with clear sequential logic

**Object-Oriented Programming:**
- Focus: Objects combining data and methods
- Data: Encapsulated within objects
- Best for: Large systems modeling real-world entities

**Key Difference:** OOP organizes code around data (objects), while structured programming organizes around actions (procedures) (Yatsko & Suslow, 2016).

### 5.2 Functional vs. OOP

**Functional Programming:**
- Immutable data
- Pure functions without side effects
- Declarative (what to do)
- Best for: Data transformation, parallel processing

**Object-Oriented Programming:**
- Mutable object state
- Methods can have side effects
- Imperative (how to do it)
- Best for: Modeling stateful entities

### 5.3 Choosing the Right Paradigm

According to MV (2019), the choice depends on:
- **Problem Nature:** What are you trying to solve?
- **Team Expertise:** What does your team know?
- **Project Scale:** How large and complex is the system?
- **Performance Requirements:** What are the constraints?
- **Maintenance Needs:** How long will this be maintained?

**Modern Approach:** Many modern languages support multiple paradigms, allowing developers to choose the best approach for each part of the system.

---

## References for Part 1

Busbee, K. L., & Braunschweig, D. (2018). Structured programming. In *Programming fundamentals: A modular structured approach using C++*. Rebus Community. https://press.rebus.community/programmingfundamentals/chapter/structured-programming/

MV, T. (2019, November 12). What exactly is a programming paradigm? *freeCodeCamp.org*. https://www.freecodecamp.org/news/what-exactly-is-a-programming-paradigm/

Yatsko, A., & Suslow, W. (2016). *Insight into theoretical and applied informatics: Introduction to information technologies and computer science*. Walter de Gruyter GmbH.

---

**Continue to Part 2 for Program Development, Algorithms, and Debugging**
