# CS1111 Unit 7: Programming Fundamentals - Detailed Notes Part 2

## Program Development: Problem Analysis, Design, and Solution

### 1. Software Development Process Overview

Software development is a systematic process that transforms user requirements into working software systems. According to Yatsko & Suslow (2016), the software development process consists of several critical phases that ensure quality and efficiency.

### 2. Problem Analysis Phase

**Definition:** Problem analysis is the critical first phase where developers thoroughly understand what needs to be solved before attempting any solution (Yatsko & Suslow, 2016).

#### 2.1 Why Problem Analysis is Critical

According to Yatsko & Suslow (2016, pp. 65-67), effective problem analysis:
- **Prevents Costly Mistakes:** Errors caught early are cheaper to fix
- **Clarifies Requirements:** Ensures all stakeholders have shared understanding
- **Identifies Constraints:** Reveals limitations and boundaries
- **Guides Design Decisions:** Provides foundation for architectural choices
- **Reduces Rework:** Thorough analysis minimizes later changes

**Key Insight:** "The cost of fixing errors increases exponentially as development progresses. An error caught during analysis costs 1x to fix, during design costs 10x, during coding costs 100x, and after deployment costs 1000x" (Yatsko & Suslow, 2016).

#### 2.2 Steps in Problem Analysis

**1. Problem Definition**
- What exactly needs to be solved?
- What are the goals and objectives?
- Who are the stakeholders?

**2. Requirements Gathering**
- Functional requirements (what system must do)
- Non-functional requirements (performance, security, usability)
- Constraints (budget, time, technology)

**3. Input Identification**
- What data is needed?
- Where does data come from?
- What format is data in?
- What validation is required?

**4. Output Identification**
- What results are expected?
- In what format?
- Who will use the outputs?
- What level of accuracy is required?

**5. Process Identification**
- What transformations are needed?
- What calculations must be performed?
- What business rules apply?

**6. Constraint Analysis**
- Time limitations
- Resource limitations
- Technical limitations
- Legal/regulatory requirements

#### 2.3 Problem Analysis Example: Budget Calculator

**Problem Statement:** Create a system to help users manage monthly budgets.

**Requirements:**
- Calculate remaining budget after expenses
- Handle multiple expense categories
- Warn when budget is exceeded
- Store expense history

**Inputs:**
- Monthly income (positive number)
- Fixed expenses (rent, utilities, insurance)
- Variable expenses (groceries, entertainment, etc.)

**Outputs:**
- Total expenses
- Remaining budget
- Warning messages if over budget
- Expense breakdown by category

**Constraints:**
- Must handle decimal values
- Must validate positive numbers
- Must prevent division by zero
- Must be user-friendly

**Edge Cases:**
- Zero income
- Negative values (invalid)
- Very large numbers
- No expenses entered

---

### 3. Design Phase

According to Yatsko & Suslow (2016), design translates requirements into a blueprint for implementation.

#### 3.1 Algorithm Design Principles

Yatsko & Suslow (2016, pp. 31-34) identify key principles for algorithm design:

**1. Correctness**
- Algorithm must produce correct results for all valid inputs
- Must handle edge cases appropriately
- Must terminate (not run forever)

**2. Efficiency**
- Time efficiency (how fast it runs)
- Space efficiency (how much memory it uses)
- Balance between the two

**3. Clarity**
- Easy to understand
- Well-documented
- Follows logical structure

**4. Generality**
- Solves general problem, not just specific case
- Reusable in different contexts

**5. Robustness**
- Handles unexpected inputs gracefully
- Provides meaningful error messages
- Doesn't crash on invalid input

#### 3.2 Design Tools

**Flowcharts**

According to Chaudhuri (2020, pp. 2-17), flowcharts are graphical representations of algorithms using standardized symbols:

**Standard Flowchart Symbols:**
- **Oval/Terminal:** Start and End points
- **Rectangle/Process:** Actions or operations
- **Diamond/Decision:** Conditional branches (Yes/No questions)
- **Parallelogram/Input-Output:** Data input or output operations
- **Arrow/Flow Line:** Direction of flow

**Benefits of Flowcharts (Chaudhuri, 2020):**
- Visual representation easier to understand
- Shows logic flow clearly
- Helps identify logical errors before coding
- Useful for documentation
- Facilitates communication with non-programmers

**Pseudocode**

Pseudocode is a plain-language description of algorithm steps, independent of any programming language (Yatsko & Suslow, 2016).

**Characteristics:**
- Uses structured programming constructs
- Readable by humans
- Not executable by computers
- Language-independent

**Example Pseudocode:**
```
Algorithm: CalculateMonthlyBudget
Input: monthlyIncome, fixedExpenses, variableExpensesList
Output: remainingBudget, warningMessage

BEGIN
    // Validate inputs
    IF monthlyIncome <= 0:
        Display "Error: Income must be positive"
        RETURN
    END IF
    
    // Initialize total expenses
    totalExpenses = fixedExpenses
    
    // Add all variable expenses
    FOR each expense IN variableExpensesList:
        IF expense < 0:
            Display "Error: Expense cannot be negative"
            CONTINUE
        END IF
        totalExpenses = totalExpenses + expense
    END FOR
    
    // Calculate remaining budget
    remainingBudget = monthlyIncome - totalExpenses
    
    // Generate appropriate message
    IF remainingBudget < 0:
        warningMessage = "WARNING: Over budget by " + ABS(remainingBudget)
    ELSE IF remainingBudget == 0:
        warningMessage = "Budget exactly met"
    ELSE:
        warningMessage = "Under budget by " + remainingBudget
    END IF
    
    // Display results
    Display "Total Income: ", monthlyIncome
    Display "Total Expenses: ", totalExpenses
    Display "Remaining Budget: ", remainingBudget
    Display warningMessage
END
```

---

## Algorithms: Sequencing, Selection, and Iteration

### 1. Introduction to Algorithms

**Definition:** "An algorithm is a finite sequence of well-defined instructions to solve a specific problem or perform a computation" (Yatsko & Suslow, 2016, p. 31).

**Properties of Good Algorithms (Yatsko & Suslow, 2016):**
1. **Input:** Zero or more inputs
2. **Output:** At least one output
3. **Definiteness:** Each step clearly defined
4. **Finiteness:** Must terminate after finite steps
5. **Effectiveness:** Steps must be basic enough to execute

---

### 2. Sequencing

**Definition:** Sequencing is the execution of instructions in a specific order, one after another (Chaudhuri, 2020, p. 2).

#### 2.1 Characteristics of Sequencing

According to Chaudhuri (2020):
- **Linear Flow:** Instructions execute top to bottom
- **Order Matters:** Changing order changes results
- **Default Structure:** Most basic control structure
- **Deterministic:** Same inputs always produce same sequence

#### 2.2 Sequencing Example

```
Algorithm: PrepareBreakfast
1. Get bread from pantry
2. Put bread in toaster
3. Press toaster button
4. Wait for toast to pop up
5. Remove toast from toaster
6. Spread butter on toast
7. Serve toast

// Order is critical - can't spread butter before toasting!
```

**Flowchart for Sequencing:**
```
[Start]
   ↓
[Get bread]
   ↓
[Put in toaster]
   ↓
[Press button]
   ↓
[Wait for toast]
   ↓
[Remove toast]
   ↓
[Spread butter]
   ↓
[Serve]
   ↓
[End]
```

---

### 3. Selection (Conditional Logic)

**Definition:** Selection allows a program to choose between alternative paths based on conditions (Chaudhuri, 2020, pp. 19-36).

#### 3.1 Types of Selection Structures

According to Chaudhuri (2020, Chapter 2), there are several selection structures:

**1. Simple IF**
```
IF condition:
    action
END IF
```

**2. IF-ELSE**
```
IF condition:
    action1
ELSE:
    action2
END IF
```

**3. Nested IF**
```
IF condition1:
    IF condition2:
        action1
    ELSE:
        action2
    END IF
ELSE:
    action3
END IF
```

**4. IF-ELIF-ELSE (Multiple Conditions)**
```
IF condition1:
    action1
ELSE IF condition2:
    action2
ELSE IF condition3:
    action3
ELSE:
    action4
END IF
```

#### 3.2 Selection Examples from Chaudhuri (2020)

**Example 1: Determine if Number is Positive, Negative, or Zero**
```
Algorithm: CheckNumber
Input: number
Output: classification

BEGIN
    Read number
    
    IF number > 0:
        Display "Positive"
    ELSE IF number < 0:
        Display "Negative"
    ELSE:
        Display "Zero"
    END IF
END
```

**Example 2: Find Largest of Three Numbers**
```
Algorithm: FindLargest
Input: a, b, c
Output: largest

BEGIN
    Read a, b, c
    
    IF a >= b AND a >= c:
        largest = a
    ELSE IF b >= a AND b >= c:
        largest = b
    ELSE:
        largest = c
    END IF
    
    Display "Largest is:", largest
END
```

**Example 3: Grade Calculator**
```
Algorithm: CalculateGrade
Input: score
Output: grade

BEGIN
    Read score
    
    // Validate input
    IF score < 0 OR score > 100:
        Display "Invalid score"
        RETURN
    END IF
    
    // Determine grade
    IF score >= 90:
        grade = "A"
    ELSE IF score >= 80:
        grade = "B"
    ELSE IF score >= 70:
        grade = "C"
    ELSE IF score >= 60:
        grade = "D"
    ELSE:
        grade = "F"
    END IF
    
    Display "Grade:", grade
END
```

#### 3.3 Flowchart for Selection

```
        [Start]
           ↓
    [Read score]
           ↓
    <score >= 90?>
      Yes ↓    No →
    [grade=A]    <score >= 80?>
        ↓         Yes ↓    No →
        ↓       [grade=B]  <score >= 70?>
        ↓           ↓       Yes ↓    No →
        ↓           ↓     [grade=C]  [grade=D or F]
        ↓           ↓         ↓           ↓
        └───────────┴─────────┴───────────┘
                    ↓
            [Display grade]
                    ↓
                 [End]
```

---

### 4. Iteration (Looping)

**Definition:** Iteration allows repeated execution of a block of code (Chaudhuri, 2020, pp. 39-56).

#### 4.1 Types of Loops

According to Chaudhuri (2020, Chapter 3):

**1. FOR Loop (Counter-Controlled)**
- Used when number of iterations is known
- Has initialization, condition, and increment

```
FOR counter = start TO end STEP increment:
    statements
END FOR
```

**2. WHILE Loop (Condition-Controlled)**
- Used when number of iterations is unknown
- Checks condition before executing

```
WHILE condition:
    statements
END WHILE
```

**3. DO-WHILE Loop (Post-Test)**
- Executes at least once
- Checks condition after executing

```
DO:
    statements
WHILE condition
```

#### 4.2 Iteration Examples from Chaudhuri (2020)

**Example 1: Sum of First N Numbers**
```
Algorithm: SumFirstN
Input: n
Output: sum

BEGIN
    sum = 0
    
    FOR i = 1 TO n:
        sum = sum + i
    END FOR
    
    Display "Sum of first", n, "numbers is:", sum
END

// For n=5: sum = 1+2+3+4+5 = 15
```

**Example 2: Factorial Calculation**
```
Algorithm: CalculateFactorial
Input: n
Output: factorial

BEGIN
    IF n < 0:
        Display "Factorial not defined for negative numbers"
        RETURN
    END IF
    
    factorial = 1
    i = 1
    
    WHILE i <= n:
        factorial = factorial * i
        i = i + 1
    END WHILE
    
    Display n, "! =", factorial
END

// For n=5: 5! = 1*2*3*4*5 = 120
```

**Example 3: Find Average of Numbers**
```
Algorithm: CalculateAverage
Input: numbers (list)
Output: average

BEGIN
    sum = 0
    count = 0
    
    FOR each number IN numbers:
        sum = sum + number
        count = count + 1
    END FOR
    
    IF count == 0:
        Display "No numbers to average"
    ELSE:
        average = sum / count
        Display "Average:", average
    END IF
END
```

**Example 4: Input Validation with Loop**
```
Algorithm: GetValidInput
Output: validNumber

BEGIN
    validInput = false
    
    WHILE NOT validInput:
        Display "Enter a positive number:"
        number = Input()
        
        IF number > 0:
            validInput = true
            validNumber = number
        ELSE:
            Display "Invalid! Must be positive. Try again."
        END IF
    END WHILE
    
    RETURN validNumber
END
```

#### 4.3 Nested Loops

Loops can be nested inside other loops (Chaudhuri, 2020):

**Example: Multiplication Table**
```
Algorithm: MultiplicationTable
Input: n (size of table)

BEGIN
    FOR i = 1 TO n:
        FOR j = 1 TO n:
            product = i * j
            Display product, " "
        END FOR
        Display newline
    END FOR
END

// For n=3:
// 1 2 3
// 2 4 6
// 3 6 9
```

#### 4.4 Loop Control Statements

**BREAK:** Exit loop immediately
```
FOR i = 1 TO 100:
    IF i == 50:
        BREAK  // Exit loop when i reaches 50
    END IF
    Display i
END FOR
```

**CONTINUE:** Skip to next iteration
```
FOR i = 1 TO 10:
    IF i MOD 2 == 0:
        CONTINUE  // Skip even numbers
    END IF
    Display i  // Only displays odd numbers
END FOR
```

---

## References for Part 2

Chaudhuri, A. B. (2020). *Flowchart and algorithm basics: The art of programming*. Mercury Learning & Information.

Yatsko, A., & Suslow, W. (2016). *Insight into theoretical and applied informatics: Introduction to information technologies and computer science*. Walter de Gruyter GmbH.

---

**Continue to Part 3 for Debugging and Practical Applications**
