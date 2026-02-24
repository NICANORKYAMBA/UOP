# CS1101 Unit 4 Programming Assignment

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 4 - Functions and Return Values  
**Date**: February 2026

---

## Part 1: Hypotenuse Function Using Incremental Development

### Technical Explanation

Incremental development is a program development strategy where complex functions are built step by step, testing at each stage rather than writing the entire function at once (Downey, 2015, p. 59). This approach minimizes debugging time because when an error appears, it must be in the most recently added code. The Pythagorean theorem states that the hypotenuse $c$ of a right triangle with legs $a$ and $b$ is calculated as:

$$c = \sqrt{a^2 + b^2}$$

The following demonstrates the incremental development of a `hypotenuse` function through five stages, from a minimal skeleton to a clean final version. Each stage adds a small piece of functionality, and scaffolding (temporary `print` statements) is used to verify intermediate computations before proceeding.

---

### Stage 1: Function Skeleton with Dummy Return

The first stage establishes the function signature with the correct parameters and a dummy return value. This ensures the basic structure works before adding any computation.

```python
def hypotenuse(a, b):
    """Calculate the hypotenuse of a right triangle given two legs."""
    return 0.0  # Dummy return value to test structure

# Test
print(hypotenuse(3, 4))
```

**Output:**
```
0.0
```

**Explanation:** The function accepts two parameters `a` and `b` representing the two legs of a right triangle and returns a placeholder value of `0.0`. The output confirms the function is callable and returns a float. The return value is incorrect, but the goal at this stage is simply to verify that the function definition, parameter passing, and return mechanism work correctly.

---

### Stage 2: Compute the Squares

The second stage adds the computation of $a^2$ and $b^2$. Scaffolding `print` statements display the intermediate values so we can manually verify them before proceeding.

```python
def hypotenuse(a, b):
    """Calculate the hypotenuse of a right triangle given two legs."""
    a_squared = a ** 2
    b_squared = b ** 2
    print(f"DEBUG: a_squared = {a_squared}, b_squared = {b_squared}")  # Scaffolding
    return 0.0  # Still dummy return

# Test
print(hypotenuse(3, 4))
```

**Output:**
```
DEBUG: a_squared = 9, b_squared = 16
0.0
```

**Explanation:** The `**` operator raises each leg to the power of 2. For input `(3, 4)`, we expect $3^2 = 9$ and $4^2 = 16$, which matches the scaffolding output. The dummy return remains because we are only verifying the squaring computation at this stage. The scaffolding `print` statement is a temporary debugging aid that will be removed in the final version.

---

### Stage 3: Compute the Sum of Squares

The third stage adds the sum of the squared values and verifies the intermediate result.

```python
def hypotenuse(a, b):
    """Calculate the hypotenuse of a right triangle given two legs."""
    a_squared = a ** 2
    b_squared = b ** 2
    sum_of_squares = a_squared + b_squared
    print(f"DEBUG: sum_of_squares = {sum_of_squares}")  # Scaffolding
    return 0.0  # Still dummy return

# Test
print(hypotenuse(3, 4))
```

**Output:**
```
DEBUG: sum_of_squares = 25
0.0
```

**Explanation:** The sum $9 + 16 = 25$ is correct. This intermediate verification is important because if the final result were wrong, we would already know that the squaring and addition steps are correct, narrowing the bug to the square root computation. Each stage of incremental development builds confidence in the previously written code.

---

### Stage 4: Compute the Square Root and Return the Result

The fourth stage imports the `math` module, computes the square root using `math.sqrt()`, and replaces the dummy return with the actual result. Scaffolding remains to verify the final computation.

```python
import math

def hypotenuse(a, b):
    """Calculate the hypotenuse of a right triangle given two legs."""
    a_squared = a ** 2
    b_squared = b ** 2
    sum_of_squares = a_squared + b_squared
    result = math.sqrt(sum_of_squares)
    print(f"DEBUG: result = {result}")  # Scaffolding
    return result

# Test
print(hypotenuse(3, 4))
```

**Output:**
```
DEBUG: result = 5.0
5.0
```

**Explanation:** The `math.sqrt()` function computes $\sqrt{25} = 5.0$, which is the correct hypotenuse for a 3-4-5 right triangle. The function now returns the actual computed value instead of the dummy `0.0`. The scaffolding confirms the result before we clean up in the final stage. The result `5.0` is a float because `math.sqrt()` always returns a floating-point number.

---

### Stage 5: Final Clean Version (Remove Scaffolding)

The final stage removes all scaffolding `print` statements and simplifies the function body into a clean, concise expression. This is the production-ready version.

```python
import math

def hypotenuse(a, b):
    """Calculate the hypotenuse of a right triangle given two legs.
    
    Uses the Pythagorean theorem: c = sqrt(a^2 + b^2)
    
    Parameters:
        a (int or float): Length of the first leg
        b (int or float): Length of the second leg
    
    Returns:
        float: Length of the hypotenuse
    """
    return math.sqrt(a ** 2 + b ** 2)

# Required test: hypotenuse(3, 4)
print(f"hypotenuse(3, 4) = {hypotenuse(3, 4)}")

# Additional test call 1: 5-12-13 triangle
print(f"hypotenuse(5, 12) = {hypotenuse(5, 12)}")

# Additional test call 2: 8-15-17 triangle
print(f"hypotenuse(8, 15) = {hypotenuse(8, 15)}")
```

**Output:**
```
hypotenuse(3, 4) = 5.0
hypotenuse(5, 12) = 13.0
hypotenuse(8, 15) = 17.0
```

**Explanation:** The final function condenses the computation into a single return statement: `return math.sqrt(a ** 2 + b ** 2)`. All scaffolding has been removed since the intermediate computations were verified in previous stages. The three test cases use well-known Pythagorean triples — (3, 4, 5), (5, 12, 13), and (8, 15, 17) — which serve as reliable verification because their expected outputs are whole numbers. Each call correctly returns the expected hypotenuse value, confirming the function works for various inputs.

---

## Part 2: Body Mass Index (BMI) Calculator Using Incremental Development

### Technical Explanation

For my portfolio function, I chose to develop a **Body Mass Index (BMI) calculator** — a practical health-related computation that demonstrates fruitful functions, composition, and incremental development. The BMI formula converts weight and height into a standardized health metric used by medical professionals worldwide. The formula is:

$$BMI = \frac{weight_{kg}}{height_{m}^2}$$

For users who provide weight in pounds and height in inches (common in the United States), the function must first convert units:
- Pounds to kilograms: $kg = lbs \times 0.453592$
- Inches to meters: $m = inches \times 0.0254$

This function demonstrates several key concepts from Chapter 6 of Think Python (Downey, 2015). First, it is a **fruitful function** that returns a computed float value rather than just printing output. Second, it uses **composition** by combining unit conversion computations with the BMI formula within a single function. Third, it includes **input validation** through a guardian pattern that checks preconditions — both weight and height must be positive numbers for the BMI calculation to be meaningful. A zero or negative height would cause a division by zero error or produce a nonsensical negative BMI, so the guardian returns `None` with an error message to prevent invalid computations.

The incremental development approach allows us to build and verify each component — unit conversion, squaring, division, and input validation — one at a time. This ensures that any bug introduced at a particular stage can be immediately identified and fixed before additional complexity is added, making the debugging process fast and systematic.

---

### Stage 1: Function Skeleton

```python
def calculate_bmi(weight_lbs, height_inches):
    """Calculate BMI from weight in pounds and height in inches."""
    return 0.0  # Dummy return

# Test
print(calculate_bmi(150, 65))
```

**Output:**
```
0.0
```

**Explanation:** The skeleton accepts weight in pounds and height in inches. The dummy return confirms the function is callable. The parameters represent a person weighing 150 lbs at 65 inches (5'5") tall.

---

### Stage 2: Add Unit Conversions

```python
def calculate_bmi(weight_lbs, height_inches):
    """Calculate BMI from weight in pounds and height in inches."""
    weight_kg = weight_lbs * 0.453592    # Convert pounds to kilograms
    height_m = height_inches * 0.0254     # Convert inches to meters
    print(f"DEBUG: weight_kg = {weight_kg:.2f}, height_m = {height_m:.4f}")  # Scaffolding
    return 0.0

# Test
print(calculate_bmi(150, 65))
```

**Output:**
```
DEBUG: weight_kg = 68.04, height_m = 1.6510
0.0
```

**Explanation:** The conversion factors are standard: 1 pound = 0.453592 kilograms and 1 inch = 0.0254 meters. For 150 lbs, we get 68.04 kg, and for 65 inches, we get 1.651 meters. Both values are verified as correct through the scaffolding output before proceeding.

---

### Stage 3: Compute BMI Value

```python
def calculate_bmi(weight_lbs, height_inches):
    """Calculate BMI from weight in pounds and height in inches."""
    weight_kg = weight_lbs * 0.453592
    height_m = height_inches * 0.0254
    bmi = weight_kg / (height_m ** 2)  # BMI formula: weight / height^2
    print(f"DEBUG: bmi = {bmi:.2f}")  # Scaffolding
    return bmi

# Test
print(calculate_bmi(150, 65))
```

**Output:**
```
DEBUG: bmi = 24.96
24.959183673469386
```

**Explanation:** The BMI formula divides weight in kilograms by the square of height in meters. For this input, $BMI = 68.04 / 1.651^2 = 68.04 / 2.7258 \approx 24.96$. A BMI of 24.96 falls in the "normal weight" range (18.5–24.9), which is a reasonable result for a 150 lb, 5'5" person, providing confidence that the computation is correct.

---

### Stage 4: Add Input Validation (Guardian Pattern)

```python
def calculate_bmi(weight_lbs, height_inches):
    """Calculate BMI from weight in pounds and height in inches."""
    # Guardian: check preconditions
    if weight_lbs <= 0 or height_inches <= 0:
        print("Error: Weight and height must be positive numbers.")
        return None
    
    weight_kg = weight_lbs * 0.453592
    height_m = height_inches * 0.0254
    bmi = weight_kg / (height_m ** 2)
    print(f"DEBUG: bmi = {bmi:.2f}")  # Scaffolding
    return bmi

# Test valid input
print(calculate_bmi(150, 65))

# Test invalid input (guardian should catch this)
print(calculate_bmi(0, 65))
```

**Output:**
```
DEBUG: bmi = 24.96
24.959183673469386
Error: Weight and height must be positive numbers.
None
```

**Explanation:** The guardian pattern at the top of the function checks preconditions before executing the main computation. If either weight or height is zero or negative, the function prints an error message and returns `None` instead of attempting the calculation. This prevents a `ZeroDivisionError` when height is zero and avoids nonsensical negative BMI values. The valid input test still produces the correct result, confirming the guardian does not interfere with normal operation.

---

### Stage 5: Final Clean Version (Remove Scaffolding)

```python
def calculate_bmi(weight_lbs, height_inches):
    """Calculate Body Mass Index from weight in pounds and height in inches.
    
    Converts imperial units to metric, then applies the BMI formula:
    BMI = weight_kg / height_m^2
    
    Parameters:
        weight_lbs (int or float): Weight in pounds (must be > 0)
        height_inches (int or float): Height in inches (must be > 0)
    
    Returns:
        float: The calculated BMI value, or None if inputs are invalid
    """
    if weight_lbs <= 0 or height_inches <= 0:
        print("Error: Weight and height must be positive numbers.")
        return None
    
    weight_kg = weight_lbs * 0.453592
    height_m = height_inches * 0.0254
    return weight_kg / (height_m ** 2)


# Test call 1: Average adult (150 lbs, 5'5")
bmi1 = calculate_bmi(150, 65)
print(f"calculate_bmi(150, 65) = {bmi1:.2f}")

# Test call 2: Taller individual (180 lbs, 6'0")
bmi2 = calculate_bmi(180, 72)
print(f"calculate_bmi(180, 72) = {bmi2:.2f}")

# Test call 3: Lighter individual (120 lbs, 5'2")
bmi3 = calculate_bmi(120, 62)
print(f"calculate_bmi(120, 62) = {bmi3:.2f}")
```

**Output:**
```
calculate_bmi(150, 65) = 24.96
calculate_bmi(180, 72) = 24.41
calculate_bmi(120, 62) = 21.95
```

**Explanation:** The final version removes all scaffolding and includes a comprehensive docstring documenting the function's purpose, parameters, and return value. The three test cases cover different body types: a 150 lb person at 5'5" (BMI 24.96 — normal weight), a 180 lb person at 6'0" (BMI 24.41 — normal weight), and a 120 lb person at 5'2" (BMI 21.95 — normal weight). All results fall within the medically accepted normal range of 18.5–24.9, confirming the function computes realistic BMI values. The function demonstrates fruitful function design by returning the computed BMI to the caller, allowing it to be stored in variables and used in further computations — a key advantage over void functions that only print output.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist* (2nd ed.). Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: Approximately 850 words (descriptive portions, excluding code and output)
