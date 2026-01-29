"""
CS1101 Unit 1 Programming Assignment - All Code Examples
Run each section separately to capture screenshots

Student: Nicanor Kyamba
Date: January 15, 2025
"""

print("=" * 60)
print("CS1101 UNIT 1 PROGRAMMING ASSIGNMENT - CODE EXAMPLES")
print("=" * 60)
print("\nRun each section separately for screenshots\n")

# ============================================================================
# PART 1(a) - Missing Quotation Marks
# ============================================================================

print("\n" + "=" * 60)
print("PART 1(a) - MISSING QUOTATION MARKS")
print("=" * 60)

# Test 1: Missing one quotation mark (WILL CAUSE ERROR)
print("\n--- Test 1: Missing closing quotation mark ---")
print("Code: print(\"Nicanor Kyamba)")
print("Expected: SyntaxError - unterminated string literal")
print("\nUncomment the line below to test:")
# print("Nicanor Kyamba)

# Test 2: Missing both quotation marks (WILL CAUSE ERROR)
print("\n--- Test 2: Missing both quotation marks ---")
print("Code: print(Nicanor Kyamba)")
print("Expected: SyntaxError - invalid syntax")
print("\nUncomment the line below to test:")
# print(Nicanor Kyamba)

# Test 3: Correct code
print("\n--- Test 3: Correct code ---")
print("Code: print(\"Nicanor Kyamba\")")
print("Output:")
print("Nicanor Kyamba")

input("\nPress Enter to continue to Part 1(b)...")

# ============================================================================
# PART 1(b) - Difference Between * and ** Operators
# ============================================================================

print("\n" + "=" * 60)
print("PART 1(b) - MULTIPLICATION (*) vs EXPONENTIATION (**)")
print("=" * 60)

print("\n--- Multiplication Operator (*) ---")
result1 = 5 * 3
print("5 * 3 =", result1)

result2 = "Python" * 3
print("'Python' * 3 =", result2)

print("\n--- Exponentiation Operator (**) ---")
result3 = 5 ** 3
print("5 ** 3 =", result3)

result4 = 16 ** 0.5
print("16 ** 0.5 =", result4)

result5 = 2 ** -3
print("2 ** -3 =", result5)

input("\nPress Enter to continue to Part 1(c)...")

# ============================================================================
# PART 1(c) - Leading Zero in Integer
# ============================================================================

print("\n" + "=" * 60)
print("PART 1(c) - LEADING ZERO IN INTEGER")
print("=" * 60)

print("\n--- Test: Integer with leading zero (WILL CAUSE ERROR) ---")
print("Code: print(09)")
print("Expected: SyntaxError - leading zeros not permitted")
print("\nUncomment the line below to test:")
# print(09)

print("\n--- Correct Alternatives ---")
print("\nOption 1: Remove leading zero")
print("Code: print(9)")
print("Output:", 9)

print("\nOption 2: Use string")
print("Code: print(\"09\")")
print("Output:", "09")

print("\nOption 3: Format with leading zero")
number = 9
print(f"Code: print(f\"{{number:02d}}\")")
print(f"Output: {number:02d}")

input("\nPress Enter to continue to Part 1(d)...")

# ============================================================================
# PART 1(d) - Type Function Comparison
# ============================================================================

print("\n" + "=" * 60)
print("PART 1(d) - TYPE FUNCTION COMPARISON")
print("=" * 60)

result1 = type('67')
print("type('67') =", result1)

result2 = type(67)
print("type(67) =", result2)

print("\nDemonstration of difference:")
print("'67' + '33' =", '67' + '33', "(string concatenation)")
print("67 + 33 =", 67 + 33, "(integer addition)")

input("\nPress Enter to continue to Part 2(a)...")

# ============================================================================
# PART 2(a) - Multiply Age by 2
# ============================================================================

print("\n" + "=" * 60)
print("PART 2(a) - MULTIPLY AGE BY 2")
print("=" * 60)

age = 25
result = age * 2
print("My age is:", age)
print("My age multiplied by 2 is:", result)

input("\nPress Enter to continue to Part 2(b)...")

# ============================================================================
# PART 2(b) - Display Location
# ============================================================================

print("\n" + "=" * 60)
print("PART 2(b) - DISPLAY LOCATION")
print("=" * 60)

city = "Nairobi"
country = "Kenya"
continent = "Africa"

print("I am currently living in:")
print("City:", city)
print("Country:", country)
print("Continent:", continent)
print()
print(f"Full location: {city}, {country}, {continent}")

input("\nPress Enter to continue to Part 2(c)...")

# ============================================================================
# PART 2(c) - Examination Schedule
# ============================================================================

print("\n" + "=" * 60)
print("PART 2(c) - EXAMINATION SCHEDULE")
print("=" * 60)

term_name = "Term 3, 2026"
exam_start_date = "March 10, 2026"
exam_end_date = "March 16, 2026"
course_code = "CS1101"
course_name = "Programming Fundamentals"

print("=" * 50)
print("EXAMINATION SCHEDULE")
print("=" * 50)
print(f"Term: {term_name}")
print(f"Course: {course_code} - {course_name}")
print(f"Exam Period: {exam_start_date} to {exam_end_date}")
print("=" * 50)

input("\nPress Enter to continue to Part 2(d)...")

# ============================================================================
# PART 2(d) - Display Temperature
# ============================================================================

print("\n" + "=" * 60)
print("PART 2(d) - DISPLAY TEMPERATURE")
print("=" * 60)

import datetime

country = "Kenya"
city = "Nairobi"
temperature_celsius = 24
temperature_fahrenheit = (temperature_celsius * 9/5) + 32
date_today = datetime.date.today()
formatted_date = date_today.strftime("%B %d, %Y")

print("WEATHER INFORMATION")
print("-" * 40)
print(f"Location: {city}, {country}")
print(f"Date: {formatted_date}")
print(f"Temperature: {temperature_celsius}°C ({temperature_fahrenheit}°F)")
print("-" * 40)

if temperature_celsius < 15:
    weather_description = "Cold"
elif temperature_celsius < 25:
    weather_description = "Moderate"
else:
    weather_description = "Warm"

print(f"Weather condition: {weather_description}")

print("\n" + "=" * 60)
print("ALL CODE EXAMPLES COMPLETED!")
print("=" * 60)
print("\nRemember to capture screenshots for each section.")
print("For error examples (Part 1a and 1c), uncomment the code")
print("and run those sections separately.")
