#!/usr/bin/env python3
"""
CS1101 Unit 2 Discussion - Example 5
Global vs Local Variable Name Collision - Variable Shadowing
"""

# Global variable
student_name = "Alice Johnson"

def register_course(course_code):
    """Register a student for a course."""
    # Local variable with SAME NAME as global
    student_name = "Bob Smith"
    print(f"Inside function: {student_name} registered for {course_code}")

print("=== Example 5: Global vs Local Variable Collision ===\n")

# Before function call
print(f"Before function call:")
print(f"  student_name = '{student_name}' (global variable)\n")

# Call function
print("Calling register_course('CS1101'):")
register_course("CS1101")
print()

# After function call
print(f"After function call:")
print(f"  student_name = '{student_name}' (global variable unchanged)\n")

print("Explanation:")
print("- The local 'student_name' inside the function shadows the global one")
print("- The global variable remains unchanged")
print("- This demonstrates variable scoping and function isolation")
