# CS1111 Unit 7: Programming Fundamentals - Detailed Notes Part 3

## Debugging: Identifying and Fixing Logical Errors

### 1. What is Debugging?

**Definition:** "Debugging is the process of finding and fixing errors or bugs in software code that prevent it from running correctly" (Nduta, 2023).

According to Nduta (2023), debugging is an essential skill for programmers because:
- All code contains bugs
- Bugs can cause serious problems
- Finding bugs early saves time and money
- Good debugging skills improve code quality

---

### 2. Types of Errors

#### 2.1 Syntax Errors

**Definition:** Violations of programming language grammar rules (Nduta, 2023).

**Characteristics:**
- Detected by compiler/interpreter
- Prevent code from running
- Easy to identify (error messages point to location)
- Easy to fix once found

**Examples:**
```
// Missing semicolon
x = 5

// Misspelled keyword
whle x < 10:

// Unmatched parentheses
result = (a + b * c

// Incorrect indentation (Python)
if x > 0:
display x
```

**How to Fix:**
- Read error message carefully
- Check line number indicated
- Look for common mistakes (typos, missing punctuation)
- Use IDE syntax highlighting

---

#### 2.2 Runtime Errors

**Definition:** Errors that occur during program execution, causing the program to crash (Nduta, 2023).

**Characteristics:**
- Code compiles successfully
- Error occurs when specific code executes
- Program terminates abnormally
- Error message indicates type of problem

**Common Runtime Errors:**

**1. Division by Zero**
```
Algorithm: CalculateAverage
sum = 100
count = 0
average = sum / count  // Runtime error: division by zero!
```

**2. Array Index Out of Bounds**
```
numbers = [1, 2, 3, 4, 5]
value = numbers[10]  // Runtime error: index 10 doesn't exist!
```

**3. File Not Found**
```
file = Open("data.txt")  // Runtime error if file doesn't exist
```

**4. Null/None Reference**
```
object = None
object.method()  // Runtime error: can't call method on None
```

**How to Fix:**
- Add input validation
- Check conditions before operations
- Use try-catch/exception handling
- Test with various inputs

---

#### 2.3 Logical Errors (Most Challenging)

**Definition:** "Logical errors occur when a program runs successfully but produces incorrect or unexpected results" (Nduta, 2023).

**Characteristics:**
- No error messages
- Program runs to completion
- Results are wrong
- Hardest to detect and fix

**Why Logical Errors Are Most Challenging:**

According to Nduta (2023), logical errors are difficult because:

1. **No Error Messages**
   - Program appears to work fine
   - No indication where problem is
   - Must compare expected vs actual results

2. **Subtle Mistakes**
   - Small errors in logic
   - Wrong formula or algorithm
   - Incorrect assumptions

3. **Complex Interactions**
   - Error may result from combination of code
   - Problem may be far from symptom
   - Multiple functions interacting incorrectly

4. **Edge Cases**
   - Works for most inputs
   - Fails only for specific values
   - Hard to discover during testing

5. **Assumption Errors**
   - Programmer misunderstood requirements
   - Wrong interpretation of problem
   - Incorrect mental model

**Examples of Logical Errors:**

**Example 1: Wrong Formula**
```
Algorithm: CalculateCircleArea
Input: radius
Output: area

BEGIN
    area = 2 * 3.14159 * radius  // WRONG! Should be π * r²
    Display area
END

// Runs without error but gives wrong answer
// For radius=5: gives 31.4159 instead of 78.5398
```

**Example 2: Off-by-One Error**
```
Algorithm: SumArray
Input: numbers (array)
Output: sum

BEGIN
    sum = 0
    FOR i = 0 TO length(numbers):  // WRONG! Goes one past end
        sum = sum + numbers[i]
    END FOR
    Display sum
END

// Should be: FOR i = 0 TO length(numbers)-1
```

**Example 3: Wrong Condition**
```
Algorithm: CheckEligibility
Input: age
Output: eligible

BEGIN
    IF age > 18:  // WRONG! Should be >= 18
        eligible = true
    ELSE:
        eligible = false
    END IF
    Display eligible
END

// 18-year-olds incorrectly marked as not eligible
```

**Example 4: Uninitialized Variable**
```
Algorithm: CalculateTotal
Input: prices (array)
Output: total

BEGIN
    // total not initialized!
    FOR each price IN prices:
        total = total + price  // Uses undefined value
    END FOR
    Display total
END

// Should initialize: total = 0
```

**Example 5: Wrong Order of Operations**
```
Algorithm: CalculateDiscount
Input: price, discountPercent
Output: finalPrice

BEGIN
    discount = price * discountPercent  // WRONG! Missing division
    finalPrice = price - discount
    Display finalPrice
END

// Should be: discount = price * discountPercent / 100
// For price=100, discount=20%: gives -1900 instead of 80
```

---

### 3. Debugging Techniques

According to Nduta (2023), effective debugging requires systematic approaches:

#### 3.1 Print Debugging (Most Common)

**Technique:** Insert print/display statements to track variable values and program flow.

**Example:**
```
Algorithm: CalculateBudget
Input: income, expenses
Output: remaining

BEGIN
    Display "DEBUG: Starting calculation"
    Display "DEBUG: income =", income
    Display "DEBUG: expenses =", expenses
    
    total = 0
    FOR each expense IN expenses:
        Display "DEBUG: Adding expense:", expense
        total = total + expense
        Display "DEBUG: Running total:", total
    END FOR
    
    remaining = income - total
    Display "DEBUG: Final remaining:", remaining
    Display "Result:", remaining
END
```

**Benefits:**
- Simple and quick
- Works in any language
- Shows exact values at specific points
- Reveals program flow

**Best Practices:**
- Use clear labels ("DEBUG:", "TRACE:")
- Print variable names with values
- Show before and after values
- Remove debug prints after fixing

---

#### 3.2 Rubber Duck Debugging

**Technique:** Explain code line-by-line to someone (or an inanimate object like a rubber duck) (Nduta, 2023).

**Process:**
1. Get a rubber duck (or any object)
2. Explain what each line should do
3. Explain what it actually does
4. Often reveals the error while explaining

**Why It Works:**
- Forces you to think carefully
- Verbalizing reveals assumptions
- Slows down thinking process
- Catches overlooked details

---

#### 3.3 Divide and Conquer

**Technique:** Isolate the problem by testing sections independently (Nduta, 2023).

**Process:**
1. Identify general area of problem
2. Split code into sections
3. Test each section separately
4. Narrow down to specific location

**Example:**
```
// Original code with bug somewhere
Function ProcessData(data):
    cleaned = CleanData(data)
    validated = ValidateData(cleaned)
    transformed = TransformData(validated)
    result = CalculateResult(transformed)
    RETURN result

// Test each function separately
Display CleanData(testData)  // Works correctly
Display ValidateData(cleanedData)  // Works correctly
Display TransformData(validatedData)  // WRONG OUTPUT - Bug found!
```

---

#### 3.4 Test with Simple Inputs

**Technique:** Use small, known inputs where you can verify output manually (Nduta, 2023).

**Example:**
```
// Testing sum algorithm
// Instead of: numbers = [47, 83, 129, 256, 391]
// Use: numbers = [1, 2, 3]
// Expected sum = 6 (easy to verify)

Algorithm: TestSum
BEGIN
    numbers = [1, 2, 3]
    sum = CalculateSum(numbers)
    Display "Sum:", sum
    Display "Expected: 6"
    IF sum == 6:
        Display "PASS"
    ELSE:
        Display "FAIL - Bug exists!"
    END IF
END
```

---

#### 3.5 Check Boundary Conditions

**Technique:** Test edge cases where errors often hide (Nduta, 2023).

**Common Boundary Conditions:**
- Zero
- Negative numbers
- Empty collections
- Maximum values
- Minimum values
- First element
- Last element

**Example:**
```
Algorithm: TestBoundaries
BEGIN
    // Test with zero
    result = CalculateAverage([0, 0, 0])
    
    // Test with empty array
    result = CalculateAverage([])
    
    // Test with one element
    result = CalculateAverage([5])
    
    // Test with negative numbers
    result = CalculateAverage([-5, -10, -15])
    
    // Test with very large numbers
    result = CalculateAverage([1000000, 2000000])
END
```

---

#### 3.6 Trace Execution (Execution Table)

**Technique:** Create a table tracking variable values at each step.

**Example: Tracing a Loop**
```
Algorithm: SumEvenNumbers
BEGIN
    sum = 0
    FOR i = 1 TO 5:
        IF i MOD 2 == 0:
            sum = sum + i
        END IF
    END FOR
    Display sum
END
```

**Execution Trace Table:**
```
Step | i | i MOD 2 | Condition | sum | Action
-----|---|---------|-----------|-----|--------
1    | 1 |    1    |   false   |  0  | Skip
2    | 2 |    0    |   true    |  0  | sum = 0+2 = 2
3    | 3 |    1    |   false   |  2  | Skip
4    | 4 |    0    |   true    |  2  | sum = 2+4 = 6
5    | 5 |    1    |   false   |  6  | Skip
End  | - |    -    |     -     |  6  | Display 6
```

**Benefits:**
- Shows exact execution flow
- Reveals where values change
- Identifies incorrect calculations
- Helps understand complex logic

---

#### 3.7 Use Debugger Tools

**Technique:** Use IDE debugging features (Nduta, 2023).

**Common Debugger Features:**
- **Breakpoints:** Pause execution at specific lines
- **Step Over:** Execute one line at a time
- **Step Into:** Enter function calls
- **Step Out:** Exit current function
- **Watch Variables:** Monitor specific variables
- **Call Stack:** See function call hierarchy

**Debugging Workflow:**
1. Set breakpoint where problem might be
2. Run program in debug mode
3. When breakpoint hits, examine variables
4. Step through code line by line
5. Watch how values change
6. Identify where values become incorrect

---

### 4. Debugging Strategy for Logical Errors

**Systematic Approach:**

**Step 1: Reproduce the Error**
- Make error happen consistently
- Document exact steps to reproduce
- Note specific inputs that cause problem

**Step 2: Understand Expected Behavior**
- What should happen?
- What is actually happening?
- What's the difference?

**Step 3: Form Hypothesis**
- Where might the bug be?
- What could cause this symptom?
- List possible causes

**Step 4: Test Hypothesis**
- Add debug prints
- Test with simple inputs
- Trace execution
- Use debugger

**Step 5: Fix the Bug**
- Make minimal change
- Fix root cause, not symptom
- Don't introduce new bugs

**Step 6: Verify the Fix**
- Test with original failing input
- Test with other inputs
- Test boundary conditions
- Ensure no regression

**Step 7: Prevent Similar Bugs**
- Add validation
- Improve error handling
- Add comments
- Write tests

---

### 5. Common Logical Errors and Solutions

#### 5.1 Off-by-One Errors

**Problem:** Loop runs one too many or too few times.

**Example:**
```
// WRONG
FOR i = 1 TO length(array):
    process(array[i])  // Goes past end!

// CORRECT
FOR i = 1 TO length(array)-1:
    process(array[i])

// OR (if starting at 0)
FOR i = 0 TO length(array)-1:
    process(array[i])
```

---

#### 5.2 Uninitialized Variables

**Problem:** Using variable before setting value.

**Example:**
```
// WRONG
FOR i = 1 TO 10:
    sum = sum + i  // sum not initialized!

// CORRECT
sum = 0  // Initialize first
FOR i = 1 TO 10:
    sum = sum + i
```

---

#### 5.3 Wrong Operators

**Problem:** Using wrong operator (=, ==, +, -, etc.).

**Example:**
```
// WRONG
IF x = 5:  // Assignment, not comparison!
    Display "x is 5"

// CORRECT
IF x == 5:  // Comparison
    Display "x is 5"
```

---

#### 5.4 Integer Division

**Problem:** Division truncates decimal part.

**Example:**
```
// WRONG (if using integer division)
average = sum / count  // 7/2 = 3, not 3.5

// CORRECT
average = sum / (count * 1.0)  // Force floating-point
```

---

#### 5.5 Infinite Loops

**Problem:** Loop condition never becomes false.

**Example:**
```
// WRONG
i = 0
WHILE i < 10:
    Display i
    // Forgot to increment i!

// CORRECT
i = 0
WHILE i < 10:
    Display i
    i = i + 1  // Update loop variable
```

---

### 6. Practical Debugging Example

**Scenario:** Budget calculator occasionally shows wrong remaining budget.

**Buggy Code:**
```
Algorithm: CalculateBudget
Input: income, fixedExpenses, variableExpenses
Output: remaining

BEGIN
    total = fixedExpenses
    
    FOR each expense IN variableExpenses:
        total = total + expense
    END FOR
    
    remaining = income - fixedExpenses  // BUG! Should subtract total
    
    Display "Remaining:", remaining
END
```

**Debugging Process:**

**Step 1: Reproduce**
```
Input: income=1000, fixedExpenses=500, variableExpenses=[100, 200]
Expected: 1000 - (500+100+200) = 200
Actual: 500 (WRONG!)
```

**Step 2: Add Debug Prints**
```
BEGIN
    Display "DEBUG: income =", income
    Display "DEBUG: fixedExpenses =", fixedExpenses
    
    total = fixedExpenses
    Display "DEBUG: initial total =", total
    
    FOR each expense IN variableExpenses:
        Display "DEBUG: adding expense:", expense
        total = total + expense
        Display "DEBUG: new total:", total
    END FOR
    
    Display "DEBUG: final total =", total
    Display "DEBUG: calculating:", income, "-", fixedExpenses
    remaining = income - fixedExpenses
    Display "DEBUG: remaining =", remaining
END
```

**Step 3: Analyze Output**
```
DEBUG: income = 1000
DEBUG: fixedExpenses = 500
DEBUG: initial total = 500
DEBUG: adding expense: 100
DEBUG: new total: 600
DEBUG: adding expense: 200
DEBUG: new total: 800
DEBUG: final total = 800
DEBUG: calculating: 1000 - 500  // AHA! Should be 1000 - 800
DEBUG: remaining = 500
```

**Step 4: Fix**
```
remaining = income - total  // Use total, not fixedExpenses
```

**Step 5: Verify**
```
Input: income=1000, fixedExpenses=500, variableExpenses=[100, 200]
Result: 200 ✓ CORRECT!
```

---

## References for Part 3

Nduta, A. (2023, January 25). What is debugging? A simple guide for beginners. *CareerFoundry*. https://careerfoundry.com/en/blog/web-development/what-is-debugging/

---

## Summary of Unit 7

### Key Concepts

**Programming Paradigms:**
- Structured: Procedures, modularity, control structures
- Functional: Pure functions, immutability, no side effects
- OOP: Objects, encapsulation, inheritance, polymorphism

**Program Development:**
- Problem analysis is critical first step
- Design before coding (flowcharts, pseudocode)
- Systematic approach prevents costly errors

**Algorithms:**
- Sequencing: Linear execution
- Selection: Conditional branching
- Iteration: Repetition with loops

**Debugging:**
- Logical errors hardest (no error messages)
- Systematic debugging techniques essential
- Test with simple inputs and boundary conditions
- Use print debugging, tracing, and debugger tools

---

## End of Unit 7 Detailed Notes
