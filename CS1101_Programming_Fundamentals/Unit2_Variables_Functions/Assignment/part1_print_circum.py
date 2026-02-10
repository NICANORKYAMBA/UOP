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
