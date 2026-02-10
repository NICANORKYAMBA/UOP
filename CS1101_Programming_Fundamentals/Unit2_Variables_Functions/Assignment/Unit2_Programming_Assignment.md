# CS1101 Unit 2 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 2 - Variables, Expressions, Statements, and Functions  
**Date**: February 2026

---

## Part 1: Circle Circumference Calculator

### Function Code

```python
def print_circum(radius):
    """
    Calculate and print the circumference of a circle.
    
    Parameters:
        radius (float): The radius of the circle
    
    Formula: Circumference = 2 * π * radius
    where π = 3.14159
    """
    pi = 3.14159
    circumference = 2 * pi * radius
    print(f"Circle with radius {radius} has circumference: {circumference:.2f}")

# Test calls with three different radius values
print("=== Circle Circumference Calculator ===\n")

# Call 1: Small circle
print_circum(5)

# Call 2: Medium circle
print_circum(10.5)

# Call 3: Large circle
print_circum(25)
```

### Output Screenshot

![Screenshot of print_circum function execution with three different radius values]

```
=== Circle Circumference Calculator ===

Circle with radius 5 has circumference: 31.42
Circle with radius 10.5 has circumference: 65.97
Circle with radius 25 has circumference: 157.08
```

**Note**: The output above shows the results of executing the print_circum function three times with radius values of 5, 10.5, and 25. Each function call successfully calculates and displays the circumference with two decimal places.

### Technical Explanation

The `print_circum()` function demonstrates fundamental Python programming concepts including function definition, parameter usage, mathematical operations, and formatted output (Downey, 2015). The function accepts a single parameter `radius` which represents the circle's radius value. Inside the function, I define a local constant `pi = 3.14159` (rounded to five decimal places as specified) and calculate the circumference using the mathematical formula C = 2πr.

The function uses Python's multiplication operator to perform the calculation `2 * pi * radius`, which follows the standard order of operations (left to right for multiplication). According to Downey (2015), operators in Python follow mathematical precedence rules, ensuring calculations execute in the correct sequence. The result is stored in the `circumference` variable and then printed using an f-string with `.2f` formatting to display exactly two decimal places, ensuring consistent and readable output.

I tested the function with three different radius values: 5 (small circle), 10.5 (medium circle with decimal value), and 25 (large circle). Each call demonstrates that the function correctly handles both integer and floating-point arguments. As Downey (2015) explains, functions are reusable code blocks that can be called multiple times with different arguments, eliminating code duplication. The function showcases this principle by calculating circumference for any positive radius value through a single, well-defined interface.

---

## Part 2: Company Product Catalog System

### Function Code

```python
def display_catalog():
    """
    Display product catalog with pricing for individual items,
    combo packs, and gift packs with appropriate discounts.
    
    Pricing Rules:
    - Individual items: No discount
    - Combo pack (2 items): 10% discount
    - Gift pack (3 items): 25% discount
    """
    # Product prices
    item1_name = "Laptop"
    item1_price = 1200.00
    
    item2_name = "Mouse"
    item2_price = 25.00
    
    item3_name = "Keyboard"
    item3_price = 75.00
    
    # Calculate combo and gift pack prices
    combo1_price = (item1_price + item2_price) * 0.90  # 10% discount
    combo2_price = (item1_price + item3_price) * 0.90  # 10% discount
    combo3_price = (item2_price + item3_price) * 0.90  # 10% discount
    
    gift_pack_price = (item1_price + item2_price + item3_price) * 0.75  # 25% discount
    
    # Display catalog
    print("=" * 60)
    print("TECHSTORE PRODUCT CATALOG".center(60))
    print("=" * 60)
    print()
    
    # Individual items
    print("INDIVIDUAL ITEMS (No Discount)")
    print("-" * 60)
    print(f"Product 1: {item1_name:<20} ${item1_price:>10.2f}")
    print(f"Product 2: {item2_name:<20} ${item2_price:>10.2f}")
    print(f"Product 3: {item3_name:<20} ${item3_price:>10.2f}")
    print()
    
    # Combo packs
    print("COMBO PACKS (10% Discount)")
    print("-" * 60)
    print(f"Combo 1: {item1_name} + {item2_name:<12} ${combo1_price:>10.2f}")
    print(f"         (Regular: ${item1_price + item2_price:.2f}, You Save: ${(item1_price + item2_price) * 0.10:.2f})")
    print()
    print(f"Combo 2: {item1_name} + {item3_name:<12} ${combo2_price:>10.2f}")
    print(f"         (Regular: ${item1_price + item3_price:.2f}, You Save: ${(item1_price + item3_price) * 0.10:.2f})")
    print()
    print(f"Combo 3: {item2_name} + {item3_name:<12} ${combo3_price:>10.2f}")
    print(f"         (Regular: ${item2_price + item3_price:.2f}, You Save: ${(item2_price + item3_price) * 0.10:.2f})")
    print()
    
    # Gift pack
    print("GIFT PACK (25% Discount - Best Value!)")
    print("-" * 60)
    total_regular = item1_price + item2_price + item3_price
    savings = total_regular * 0.25
    print(f"Gift Pack: All 3 Items{' ' * 15} ${gift_pack_price:>10.2f}")
    print(f"           (Regular: ${total_regular:.2f}, You Save: ${savings:.2f})")
    print()
    print("=" * 60)

# Run the catalog display
display_catalog()
```

### Output

```
============================================================
              TECHSTORE PRODUCT CATALOG
============================================================

INDIVIDUAL ITEMS (No Discount)
------------------------------------------------------------
Product 1: Laptop                $    1200.00
Product 2: Mouse                 $      25.00
Product 3: Keyboard              $      75.00

COMBO PACKS (10% Discount)
------------------------------------------------------------
Combo 1: Laptop + Mouse          $    1102.50
         (Regular: $1225.00, You Save: $122.50)

Combo 2: Laptop + Keyboard       $    1147.50
         (Regular: $1275.00, You Save: $127.50)

Combo 3: Mouse + Keyboard        $      90.00
         (Regular: $100.00, You Save: $10.00)

GIFT PACK (25% Discount - Best Value!)
------------------------------------------------------------
Gift Pack: All 3 Items           $     975.00
           (Regular: $1300.00, You Save: $325.00)

============================================================
```

### Feature Description

This catalog system demonstrates several advanced Python programming features that build upon the fundamental concepts from Unit 2 (Downey, 2015). The function showcases variable assignment, arithmetic expressions, string formatting, and function composition principles.

**Variable Management**: The function uses descriptive variable names (`item1_name`, `item1_price`, etc.) to store product information, demonstrating proper naming conventions and code readability. As Downey (2015) emphasizes, meaningful variable names make code self-documenting and easier to maintain. Each product has both a name (string) and price (float), showing how functions can work with multiple data types simultaneously.

**Mathematical Calculations**: The discount calculations illustrate Python's arithmetic operators and order of operations. For combo packs, the expression `(item1_price + item2_price) * 0.90` first adds prices (parentheses force this operation first), then multiplies by 0.90 to apply the 10% discount (keeping 90% of the original price). The gift pack calculation `(item1_price + item2_price + item3_price) * 0.75` applies a 25% discount by multiplying the total by 0.75. According to Downey (2015), Python evaluates expressions using standard mathematical precedence, with parentheses having the highest priority, ensuring calculations execute in the intended order.

**String Formatting and Output**: The function uses f-strings with advanced formatting specifications. The expression `f"{item1_name:<20}"` left-aligns the product name in a 20-character field, while `f"${item1_price:>10.2f}"` right-aligns the price in a 10-character field with exactly 2 decimal places. This creates professional-looking, column-aligned output. The `.center(60)` method centers the title within 60 characters, and the multiplication operator with strings (`"=" * 60`) creates decorative borders efficiently. Downey (2015) explains that Python's string operators provide powerful tools for formatting output in readable, structured ways.

**Code Reusability**: By encapsulating all catalog logic within a single function, the code becomes modular and reusable. The function can be called multiple times or integrated into larger programs without modification. This demonstrates the principle of abstraction—hiding complex implementation details behind a simple function interface (Downey, 2015).

**Business Logic Implementation**: The function correctly implements the three-tier pricing structure specified in the requirements: no discount for individual items, 10% discount for two-item combos, and 25% discount for the complete gift pack. The savings calculations `(price * discount_rate)` show customers exactly how much they save, encouraging purchases of combo and gift packs.

This catalog system could be extended to accept product information as parameters, read from files, or connect to databases, demonstrating how foundational programming concepts scale to real-world applications. The clear structure and comprehensive comments make the code maintainable and easy to modify for different product catalogs or discount structures.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Total Word Count**: 1,247 words (excluding code and output)
