Monthly Budget Calculator: Algorithm Development and Debugging

Introduction

Effective budget management requires systematic calculation of income and expenses to determine remaining funds. This assignment develops a comprehensive algorithm for a monthly budget calculator that incorporates sequencing, conditional selection, and iterative loops to handle various expense scenarios. Additionally, it demonstrates debugging techniques for identifying and resolving logical errors that may cause incorrect budget calculations.

Algorithm Development: Monthly Budget Calculator

The monthly budget calculator algorithm follows a structured approach using fundamental programming constructs. According to Chaudhuri (2020), algorithms should incorporate sequencing for ordered execution, selection for decision-making, and iteration for repetitive tasks.

**Algorithm: CalculateMonthlyBudget**

**Step 1: Initialize and Input Monthly Income (Sequencing)**
```
BEGIN
    Display "=== Monthly Budget Calculator ==="
    Display "Enter your monthly income: $"
    monthlyIncome = Input()
    
    // Input validation
    IF monthlyIncome <= 0:
        Display "Error: Income must be positive"
        RETURN
    END IF
```

This initial sequence establishes program flow by prompting for income and validating input. Yatsko and Suslow (2016) emphasize that input validation prevents logical errors from propagating through calculations.

**Step 2: Input Fixed Expenses (Sequencing)**
```
    Display "Enter total fixed expenses (rent, utilities, insurance): $"
    fixedExpenses = Input()
    
    // Validate fixed expenses
    IF fixedExpenses < 0:
        Display "Error: Expenses cannot be negative"
        RETURN
    END IF
    
    totalExpenses = fixedExpenses
```

**Step 3: Input Variable Expenses (Iteration)**
```
    Display "How many variable expense categories? (groceries, entertainment, etc.)"
    numCategories = Input()
    
    // Iterative loop for multiple variable expenses
    FOR i = 1 TO numCategories:
        Display "Enter variable expense", i, ": $"
        expense = Input()
        
        // Validate each expense
        IF expense < 0:
            Display "Warning: Negative expense ignored"
            CONTINUE
        END IF
        
        totalExpenses = totalExpenses + expense
    END FOR
```

This iterative loop handles multiple variable expenses efficiently. According to Chaudhuri (2020), iteration enables processing collections of data without code duplication, essential for handling varying numbers of expense categories.

**Step 4: Calculate Remaining Budget (Sequencing)**
```
    remainingBudget = monthlyIncome - totalExpenses
```

**Step 5: Display Results with Conditional Selection**
```
    // Conditional selection for different budget scenarios
    Display "Monthly Income: $", monthlyIncome
    Display "Total Expenses: $", totalExpenses
    Display "Remaining Budget: $", remainingBudget
    
    IF remainingBudget < 0:
        deficit = ABS(remainingBudget)
        Display "WARNING: Budget exceeded by $", deficit
        Display "Recommendation: Reduce expenses or increase income"
    ELSE IF remainingBudget == 0:
        Display "Budget exactly balanced"
        Display "Recommendation: Build emergency savings"
    ELSE IF remainingBudget < (monthlyIncome * 0.10):
        Display "Low remaining budget (less than 10% of income)"
        Display "Recommendation: Review discretionary spending"
    ELSE:
        Display "Budget on track"
        Display "Recommendation: Consider saving", remainingBudget * 0.20
    END IF
END
```

This conditional selection structure provides context-specific feedback based on budget status. Busbee and Braunschweig (2018) note that selection statements enable programs to respond appropriately to different conditions, enhancing user experience.

Debugging Logical Errors in Budget Calculation

Assume the algorithm occasionally miscalculates remaining budget, producing incorrect values. According to Nduta (2023), logical errors are challenging because programs run without error messages despite producing wrong results. The following systematic debugging approach would identify and resolve this issue.

**Step 1: Reproduce the Error**

First, I would document specific inputs causing incorrect calculations. For example, if income=$3000, fixed expenses=$1500, and variable expenses=[500, 300, 200] should yield $500 remaining but shows $1500, this establishes a reproducible test case.

**Step 2: Add Debug Print Statements**

Following Nduta's (2023) recommendation for print debugging, I would insert diagnostic output:

```
BEGIN
    Display "DEBUG: monthlyIncome =", monthlyIncome
    Display "DEBUG: fixedExpenses =", fixedExpenses
    Display "DEBUG: Initial totalExpenses =", totalExpenses
    
    FOR i = 1 TO numCategories:
        expense = Input()
        Display "DEBUG: Adding expense", i, "=", expense
        totalExpenses = totalExpenses + expense
        Display "DEBUG: Running totalExpenses =", totalExpenses
    END FOR
    
    Display "DEBUG: Final totalExpenses =", totalExpenses
    Display "DEBUG: Calculation:", monthlyIncome, "-", totalExpenses
    remainingBudget = monthlyIncome - totalExpenses
    Display "DEBUG: remainingBudget =", remainingBudget
END
```

**Step 3: Trace Execution**

Creating an execution trace table as recommended by Chaudhuri (2020):

```
Step | Variable        | Value | Action
-----|-----------------|-------|---------------------------
1    | monthlyIncome   | 3000  | Input received
2    | fixedExpenses   | 1500  | Input received
3    | totalExpenses   | 1500  | Initialized with fixed
4    | expense (i=1)   | 500   | First variable expense
5    | totalExpenses   | 2000  | After adding 500
6    | expense (i=2)   | 300   | Second variable expense
7    | totalExpenses   | 2300  | After adding 300
8    | expense (i=3)   | 200   | Third variable expense
9    | totalExpenses   | 2500  | After adding 200
10   | remainingBudget | 500   | 3000 - 2500
```

**Step 4: Identify the Bug**

If debug output shows `remainingBudget = monthlyIncome - fixedExpenses` instead of `remainingBudget = monthlyIncome - totalExpenses`, the logical error is using the wrong variable. This common mistake occurs when variable expenses are accumulated in `totalExpenses` but the final calculation incorrectly uses only `fixedExpenses`.

**Step 5: Fix and Verify**

Correct the calculation to use `totalExpenses`:
```
remainingBudget = monthlyIncome - totalExpenses  // Fixed
```

Test with original failing input and additional test cases including boundary conditions: zero income, no variable expenses, and very large numbers (Nduta, 2023).

Conclusion

The monthly budget calculator algorithm demonstrates effective use of sequencing for ordered execution, conditional selection for scenario-specific responses, and iteration for handling multiple expenses. Systematic debugging using print statements, execution tracing, and test cases enables identification and resolution of logical errors, ensuring accurate budget calculations.

References

Busbee, K. L., & Braunschweig, D. (2018). Structured programming. In *Programming fundamentals: A modular structured approach using C++*. Rebus Community. https://press.rebus.community/programmingfundamentals/chapter/structured-programming/

Chaudhuri, A. B. (2020). *Flowchart and algorithm basics: The art of programming*. Mercury Learning & Information.

Nduta, A. (2023, January 25). What is debugging? A simple guide for beginners. *CareerFoundry*. https://careerfoundry.com/en/blog/web-development/what-is-debugging/

Yatsko, A., & Suslow, W. (2016). *Insight into theoretical and applied informatics: Introduction to information technologies and computer science*. Walter de Gruyter GmbH.
