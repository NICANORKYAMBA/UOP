# CS1101 Unit 3 Discussion - Peer Response to Tariro Makombe

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 3 - Conditionals and Recursion  
**Date**: February 2026

---

## Response to Tariro Makombe

Hi Tariro,

Excellent explanation of chained versus nested conditionals! Your examples clearly demonstrate how logical operators can flatten nested structures and improve code readability. I particularly appreciate your side-by-side comparison showing the nested version and its equivalent single conditional using `and` operators.

To answer your discussion question about handling non-mutually exclusive conditions, I use a combination of strategies depending on the complexity:

**1. Early Returns for Guard Clauses**

When dealing with multiple independent conditions, I often use early returns to handle edge cases first, which eliminates the need for deep nesting:

```python
def process_user_data(age, income, credit_score):
    """Process loan application with multiple conditions."""
    # Guard clauses handle invalid cases first
    if age < 18:
        return "Applicant must be 18 or older"
    if income < 20000:
        return "Insufficient income"
    if credit_score < 300:
        return "Invalid credit score"
    
    # Main logic proceeds only if all guards pass
    if credit_score >= 700 and income >= 50000:
        return "Approved for premium rate"
    elif credit_score >= 600 and income >= 35000:
        return "Approved for standard rate"
    else:
        return "Application requires manual review"
```

**2. Boolean Flags for Complex Conditions**

When conditions are not mutually exclusive and multiple can be true simultaneously, I use boolean flags to track each condition separately:

```python
def analyze_student_status(gpa, attendance, extracurricular):
    """Determine student awards - multiple can apply."""
    academic_honors = gpa >= 3.5
    perfect_attendance = attendance >= 95
    leadership_award = extracurricular >= 3
    
    awards = []
    if academic_honors:
        awards.append("Academic Honors")
    if perfect_attendance:
        awards.append("Perfect Attendance")
    if leadership_award:
        awards.append("Leadership Award")
    
    return awards if awards else ["No awards"]
```

This approach is cleaner than nested conditionals because each condition is evaluated independently, and the code clearly shows that multiple awards can be granted simultaneously.

**3. Dictionary Mapping for Complex Decision Trees**

For scenarios with many conditions, I sometimes use dictionary mapping to avoid long if-elif chains:

```python
def calculate_shipping(weight, distance, priority):
    """Calculate shipping cost using lookup strategy."""
    base_rates = {
        ('light', 'local', 'standard'): 5.00,
        ('light', 'local', 'express'): 10.00,
        ('heavy', 'international', 'express'): 50.00
    }
    
    weight_category = 'light' if weight <= 5 else 'heavy'
    distance_category = 'local' if distance <= 100 else 'international'
    
    key = (weight_category, distance_category, priority)
    return base_rates.get(key, 25.00)  # Default rate
```

According to Downey (2015), "the key to avoiding complicated nested conditionals is to think about the problem structure first" (p. 47). By breaking down complex conditions into smaller, manageable pieces using these strategies, we maintain code that is both readable and maintainable.

Your use of logical operators to combine conditions is exactly the right approach for most situations. The key is recognizing when conditions are mutually exclusive (use if-elif-else chains) versus when they're independent (use separate if statements or boolean flags).

**Discussion Question for You**: In your experience, have you encountered situations where using a dictionary or lookup table would be more efficient than chained conditionals, especially when dealing with many possible combinations of conditions?

Great post, and thanks for the clear examples!

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: 448 words (excluding code and references)
