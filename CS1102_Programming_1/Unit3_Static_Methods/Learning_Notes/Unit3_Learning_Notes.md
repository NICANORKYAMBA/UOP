# Unit 3 Detailed Learning Notes (Directly Aligned to Assigned Sections)

## Assigned Coverage Matrix
This week requires Chapter 4 sections:
- 4.2 Static Subroutines and Static Variables
- 4.3.1 Using Parameters
- 4.3.2 Formal and Actual Parameters
- 4.3.3 Overloading
- 4.3.4 Subroutine Examples
- 4.4 Return Values
- 4.6.3 Using Classes from Packages
- 4.8 The Truth about Declarations

All required parts are covered below with examples, common errors, and exam-focused checkpoints.

## 1) Section 4.2 Static Subroutines and Static Variables

### 1.1 Core distinction in this chapter
The textbook emphasizes that static members belong to the class, while non-static members belong to objects. Unit 3 focuses on static design first so you can master subroutines and class-level data before deeper object-oriented work.

### 1.2 Subroutine definition structure (4.2.1)

```java
modifiers returnType subroutineName(parameterList) {
    statements
}
```

Breakdown:
- modifiers: examples include static, public, private
- returnType: int, double, boolean, String, array types, or void
- subroutineName: identifier
- parameterList: zero or more parameter declarations

Important syntax facts:
- Empty parameter list still requires parentheses.
- Each parameter declaration names one parameter.
- You cannot nest one method definition inside another.

### 1.3 Calling static subroutines (4.2.2)
- Same class call pattern:

```java
playGame();
```

- Different class call pattern:

```java
Poker.playGame();
```

Rules:
- Number of actual parameters must match formal parameters.
- Types must be assignment-compatible.

### 1.4 Program decomposition pattern (4.2.3)
The guessing game example demonstrates top-level design:
- Keep main focused on flow and control.
- Move coherent subtasks into named helper subroutines.
- This improves readability, testing, and future modification.

### 1.5 Static member variables (4.2.4)
Member variables are declared in class scope (outside methods). Static member variables:
- are created when class is loaded
- are shared by methods in that class
- persist across multiple calls

Default values for member variables:
- numeric -> 0
- boolean -> false
- char -> Unicode 0
- object reference -> null

Contrast with local variables:
- local variables are method-lifetime only
- no automatic default value guarantee for safe use in expressions before assignment

Design implication from text:
- use private by default unless there is a clear reason to expose a member

## 2) Section 4.3.1 to 4.3.4 Parameters

### 2.1 Using parameters (4.3.1)
Parameter purpose: customize the same subroutine behavior for different inputs.

Example idea from text:

```java
static void print3NSequence(int startingValue) { ... }
```

What matters:
- method logic is fixed
- output changes by parameter value

### 2.2 Formal vs actual parameters (4.3.2)
- Formal parameter: variable name in method definition
- Actual parameter (argument): expression/value at call site

Example mapping:

```java
print3NSequence(K);
```

Here:
- K is actual parameter
- startingValue is formal parameter

Execution concept:
- actual values are evaluated
- assigned to formals
- then method body executes

Common beginner mistake highlighted by the textbook:
- trying to read or assign formal parameter values manually at top of method

### 2.3 Overloading (4.3.3)
Overloading allows same name with different signatures.

Signature includes:
- method name
- parameter count and parameter types

Signature excludes:
- return type

Therefore illegal:
- same name + same parameter list + different return type only

### 2.4 Subroutine examples and contracts (4.3.4)
Textbook examples model good interface design:
- State preconditions and assumptions.
- Keep methods small and purpose-specific.
- Compose solutions by calling helper methods.

Contract pattern to emulate:
- What method does
- What it expects from caller
- What happens in edge cases

## 3) Section 4.4 Return Values

### 3.1 return statement mechanics (4.4.1)

```java
return expression;
```

Rules:
- expression type must match declared return type (or be assignment-compatible)
- execution stops immediately at return
- all execution paths in non-void methods must return (or throw)

In void methods:

```java
return;
```

can be used for early termination.

### 3.2 Function examples and patterns (4.4.2)
Examples used by text:
- nextN(int) -> int
- letterGrade(int) -> char
- isPrime(int) -> boolean
- reverse(String) -> String

Critical warning from text:
- a function should return computed value, not print it as a substitute

### 3.3 3N+1 revisited (4.4.3)
Design lesson:
- split complex logic into helper function calls
- improve output formatting without overloading one method with too many responsibilities

## 4) Section 4.6.3 Using Classes from Packages

### 4.1 Full class names vs imports
Package-qualified class name example:

```java
javafx.scene.paint.Color rectColor;
```

Import to shorten usage:

```java
import javafx.scene.paint.Color;
Color rectColor;
```

### 4.2 Wildcard imports

```java
import java.util.*;
```

Meaning:
- imports classes in that package
- does not import subpackages

### 4.3 Ambiguous class names
If two imported packages define same class name (for example List), short name becomes ambiguous. Solution:
- use full package-qualified class names where needed

### 4.4 Package statement for your own code

```java
package utilities;
```

Placement rule:
- package statement appears before imports
- directory structure must match package path

Useful reminder from text:
- classes without explicit package go to default package

## 5) Section 4.8 The Truth about Declarations

### 5.1 Initialization in declarations (4.8.1)

```java
int count = 0;
```

Equivalent intent:
- declare variable
- initialize variable

Important class-level rule:
- declaration statements can appear outside methods
- assignment statements cannot appear directly outside methods

Array declaration-time initialization:

```java
int[] smallPrimes = {2, 3, 5, 7, 11};
```

### 5.2 var declarations (4.8.2)
From Java 11+:
- local variables only
- initializer required
- compiler infers type

```java
var interestRate = 0.05; // inferred as double
```

### 5.3 Named constants with final (4.8.3)

```java
public static final double INTEREST_RATE = 0.05;
```

Benefits:
- prevents accidental reassignment
- improves readability
- centralizes updates

Style guidance:
- constants in uppercase with underscores

### 5.4 Scope and naming rules (4.8.4)
Key scope rules:
- static method names are visible across class source
- formal parameter scope is method body
- local variable scope starts at declaration and ends at block end
- for-loop control variables declared in loop header have loop-local scope

Name hiding behavior:
- local variable or parameter can hide member variable with same name
- access hidden member via ClassName.memberName form

Java restriction highlighted by text:
- cannot redeclare a local/formal variable name in a nested block if original is still in scope

## 6) Static vs Non-Static (Unit Objective Tie-in)
Even though Chapter 4 emphasizes static members, you must explain contrast for discussion and quiz:

Static:
- class-level ownership
- shared state
- callable via class name

Non-static (instance):
- object-level ownership
- each object has separate state
- called on object references

Memory implication:
- static field has one shared storage location per class
- instance field has one storage location per object

## 7) Common Errors Checklist (Exam and Assignment)
- Missing parentheses when calling methods with no parameters.
- Wrong parameter count or incompatible parameter type.
- Assuming return type can differentiate overloaded methods.
- Printing from function instead of returning value.
- Using wildcard imports without noticing class-name conflicts.
- Writing class-level assignment statement outside method body.
- Forgetting final for constants intended not to change.
- Confusing variable scope, especially for-loop variables and hidden members.

## 8) Quick Self-Test Questions
1. Why can two methods with same name and parameter list not differ only by return type?
2. What is the exact difference between formal and actual parameters?
3. Why is return required on all non-void paths?
4. What does import package.* include and what does it not include?
5. Why is static final preferred for named constants?
6. How can you refer to a hidden member variable when a local name is the same?

## 9) Unit 3 High-Value Summary
- Static methods and variables are class-level tools for shared behavior and shared data.
- Parameter passing defines method interface and controls behavior safely.
- Return values make functions reusable in expressions and assignments.
- Package/import rules improve code organization but can introduce ambiguity.
- Declarations, initialization, constants, and scope rules are foundational for clean Java design.

## Reference
Eck, D. J. (2022). Introduction to programming using Java (Version 9, JavaFX ed.). https://math.hws.edu/javanotes/
