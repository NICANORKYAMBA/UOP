# CS1101 Unit 3 Discussion Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 3 - Conditionals and Recursion  
**Date**: February 2026

---

## Chained vs. Nested Conditionals

### Difference Between Chained and Nested Conditionals

**Chained conditionals** use `if-elif-else` statements to check multiple conditions sequentially, where only the first true condition executes. According to Downey (2015), chained conditionals evaluate conditions in order and stop at the first match, making them efficient for mutually exclusive scenarios. In contrast, **nested conditionals** place one conditional statement inside another, creating multiple levels of decision-making. While nested conditionals allow for complex logic where one condition depends on another, they can quickly become difficult to read and maintain as nesting depth increases.

### Example 1: Chained Conditional

```python
def calculate_shipping_cost(weight):
    """Calculate shipping cost based on package weight."""
    if weight <= 0:
        print("Invalid weight")
    elif weight <= 5:
        print("Shipping cost: $5.00")
    elif weight <= 20:
        print("Shipping cost: $10.00")
    else:
        print("Shipping cost: $15.00")

# Test the function
calculate_shipping_cost(3)   # Output: Shipping cost: $5.00
calculate_shipping_cost(12)  # Output: Shipping cost: $10.00
calculate_shipping_cost(25)  # Output: Shipping cost: $15.00
```

**Explanation**: This chained conditional checks weight ranges sequentially. Once a condition is true (e.g., `weight <= 5`), the corresponding code executes and the remaining conditions are skipped. This structure is clear and efficient for categorizing values into distinct ranges.

### Example 2: Nested Conditional

```python
def check_student_eligibility(age, gpa):
    """Check if student is eligible for scholarship."""
    if age >= 18:
        if gpa >= 3.5:
            print("Eligible for scholarship")
        else:
            print("GPA too low for scholarship")
    else:
        print("Must be 18 or older")

# Test the function
check_student_eligibility(20, 3.8)  # Output: Eligible for scholarship
check_student_eligibility(20, 3.0)  # Output: GPA too low for scholarship
check_student_eligibility(16, 3.8)  # Output: Must be 18 or older
```

**Explanation**: This nested conditional first checks age, then checks GPA only if the age requirement is met. The inner conditional depends on the outer conditional being true, creating a hierarchical decision structure.

### Strategy for Avoiding Nested Conditionals

The most effective strategy for avoiding deeply nested conditionals is using **logical operators** (`and`, `or`, `not`) to combine conditions into a single expression. Downey (2015) emphasizes that boolean expressions can simplify complex logic by flattening nested structures. This approach improves code readability, reduces indentation levels, and makes the logic easier to understand and maintain. Additionally, using early returns or guard clauses can eliminate unnecessary nesting by handling edge cases first.

### Example 3: Nested Conditional Simplified

**Nested Version** (harder to read):
```python
def approve_loan(credit_score, income):
    """Determine loan approval (nested version)."""
    if credit_score >= 700:
        if income >= 50000:
            print("Loan approved")
        else:
            print("Income too low")
    else:
        print("Credit score too low")

approve_loan(750, 60000)  # Output: Loan approved
```

**Simplified Single Conditional** (easier to read):
```python
def approve_loan_simplified(credit_score, income):
    """Determine loan approval (simplified version)."""
    if credit_score >= 700 and income >= 50000:
        print("Loan approved")
    elif credit_score < 700:
        print("Credit score too low")
    else:
        print("Income too low")

approve_loan_simplified(750, 60000)  # Output: Loan approved
```

**Explanation**: The simplified version uses the `and` operator to combine both conditions into a single expression, eliminating one level of nesting. This makes the approval criteria immediately clear: both conditions must be true for loan approval. The chained `elif` and `else` statements handle rejection cases explicitly, improving code clarity and maintainability.

---

## Discussion Question

How would you refactor a deeply nested conditional (3+ levels) that checks multiple user permissions (admin, editor, viewer) and account status (active, suspended, expired) to determine access rights? What combination of logical operators and early returns would make the code most readable?

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: 287 words (excluding code and references)
