# list_operations.py — CS1101 Unit 6 Programming Assignment
# Tests all code before documenting outputs

# ─── PART (a) ────────────────────────────────────────────────────────────────

# Original list of 10 employees
employees = [
    'Alice Johnson', 'Bob Martinez', 'Carol White', 'David Lee', 'Emma Davis',
    'Frank Wilson', 'Grace Taylor', 'Henry Brown', 'Isla Clark', 'James Moore'
]

# 1. Split into two sub-lists of 5
subList1 = employees[:5]
subList2 = employees[5:]
print("subList1:", subList1)
print("subList2:", subList2)

# 2. Add new employee to subList2
subList2.append('Kriti Brown')
print("\nsubList2 after append:", subList2)

# 3. Remove second employee from subList1 (index 1)
del subList1[1]
print("subList1 after removing 2nd employee:", subList1)

# 4. Merge both lists
merged = subList1 + subList2
print("\nMerged list:", merged)
print("Total employees:", len(merged))

# 5. Apply 4% raise to salaryList
salaryList = [52000, 61000, 47000, 73000, 55000, 68000, 49000, 82000, 57000, 63000, 45000]
print("\nSalaries before raise:", salaryList)
for i in range(len(salaryList)):
    salaryList[i] = round(salaryList[i] * 1.04, 2)
print("Salaries after 4% raise:", salaryList)

# 6. Sort and show top 3 salaries
salaryList.sort(reverse=True)
print("\nTop 3 salaries:", salaryList[:3])

# ─── PART (b) ────────────────────────────────────────────────────────────────

sentence = "Python lists are powerful and flexible"
word_list = sentence.split()
print("\nOriginal word list:", word_list)

word_list.reverse()
print("Reversed word list:", word_list)
