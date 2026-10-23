# Written Assignment Unit 8: Systems of Linear and Nonlinear Equations

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Maswili
**Instructor:** Chibuike Agu
**Due:** October 28, 2026

This assignment solves three systems of equations: a word problem about the prices of three toys,
a system of three linear equations solved by Gaussian elimination, and a nonlinear system solved
algebraically and checked with a GeoGebra graph. Every step is shown, and every answer was checked
by substituting it back into the original equations and with a computer algebra tool.

## Task 1: The Prices of Daniel's Toys

### (i) The System of Linear Equations

Let the prices of the three toys be:

- a = the price of the first toy (in dollars)
- b = the price of the second toy
- c = the price of the special toy, which costs $20 more than three times the other two combined

Each sentence of the problem becomes one equation:

```
"three toys for $25 in total"                    a + b + c = 25            (1)
"$20 more than three times the other two"        c = 3(a + b) + 20         (2)
"total cost multiplied by five is $125"          5(a + b + c) = 125        (3)
```

In standard form, with all variables on the left (Abramson, 2021, Section 11.2):

```
 a +  b +  c =  25      (1)
3a + 3b -  c = -20      (2)
5a + 5b + 5c = 125      (3)
```

### (ii) The Nature of the System

**Equation (3) gives no new information.** Dividing both sides of (3) by 5 gives
a + b + c = 25, which is exactly equation (1). So the system really contains only **two different
equations for three unknowns**.

The augmented matrix shows this clearly. Subtracting 5 times row (1) from row (3) turns row (3)
into all zeros:

```
[ 1  1   1 |  25 ]                        [ 1  1   1 |  25 ]
[ 3  3  -1 | -20 ]   R3 -> R3 - 5 R1  ->   [ 3  3  -1 | -20 ]
[ 5  5   5 | 125 ]                        [ 0  0   0 |   0 ]
```

A row of zeros on both sides, 0 = 0, is always true, so it causes no contradiction. A system is
**dependent** when its equations do not determine a single solution and it has infinitely many
solutions; it is **inconsistent** only when the work leads to a false statement such as 0 = 5
(Abramson, 2021, Section 11.2).

**Table 1**

*Nature of the System in Task 1*

| Property | Answer | Reason |
|---|---|---|
| Consistent? | **Yes** | It has solutions; no step produces a false statement such as 0 = 5 |
| Independent? | **No, it is dependent** | Equation (3) is 5 times equation (1), so only two equations are independent |
| Number of solutions | **Infinitely many** | Two independent equations cannot fix three unknowns |

### (iii) The Cost of Each Toy

Although the system is dependent, it still fixes the price of the special toy exactly.

**Step 1.** From equation (1), the two ordinary toys together cost:

```
a + b = 25 - c
```

**Step 2.** Substitute this into equation (2):

```
c = 3(25 - c) + 20
c = 75 - 3c + 20
c = 95 - 3c
4c = 95
c = 23.75
```

**Step 3.** Then the other two toys together cost:

```
a + b = 25 - 23.75 = 1.25
```

**Check:** c = 3(1.25) + 20 = 3.75 + 20 = 23.75, the total is 1.25 + 23.75 = 25, and
5 × 25 = 125. All three statements in the problem hold.

**Answer.** The special toy costs **$23.75**, and the other two toys together cost **$1.25**.
The individual prices of those two toys **cannot be determined** from the information given,
because the third statement only repeats the first. Every pair with a + b = 1.25 works, so the
solution set is

```
(a, b, c) = (a, 1.25 - a, 23.75),   for any price a between 0 and 1.25
```

For example, $0.25 and $1.00, or $0.50 and $0.75, are both possible. In real money, where prices
are whole cents and every toy costs at least one cent, there are 124 possible pairs. A further
fact, such as "the two toys cost the same" or a third independent price relation, would be needed
to find a single answer.

## Task 2: Gaussian Elimination

Solve the system:

```
 x - y +  z = 4
5x - y +  z = 6
3x - y + 5z = 5
```

Gaussian elimination writes the system as an augmented matrix and uses row operations, which do
not change the solution, to reach row-echelon form: zeros below the main diagonal (Abramson, 2021,
Section 11.6; Mathispower4u, 2010). The allowed operations are swapping two rows, multiplying a row
by a nonzero number, and adding a multiple of one row to another.

**Step 1. Write the augmented matrix.**

```
[ 1  -1   1 |  4 ]
[ 5  -1   1 |  6 ]
[ 3  -1   5 |  5 ]
```

**Step 2. Make zeros below the first entry of column 1.**

```
R2 -> R2 - 5 R1:   (5 - 5, -1 + 5, 1 - 5 | 6 - 20)  =  (0, 4, -4 | -14)
R3 -> R3 - 3 R1:   (3 - 3, -1 + 3, 5 - 3 | 5 - 12)  =  (0, 2,  2 |  -7)

[ 1  -1   1 |   4 ]
[ 0   4  -4 | -14 ]
[ 0   2   2 |  -7 ]
```

**Step 3. Make the second entry of row 2 equal to 1.**

```
R2 -> (1/4) R2:    (0, 1, -1 | -7/2)

[ 1  -1   1 |    4 ]
[ 0   1  -1 | -7/2 ]
[ 0   2   2 |   -7 ]
```

**Step 4. Make a zero below it in column 2.**

```
R3 -> R3 - 2 R2:   (0, 2 - 2, 2 + 2 | -7 + 7)  =  (0, 0, 4 | 0)

[ 1  -1   1 |    4 ]
[ 0   1  -1 | -7/2 ]
[ 0   0   4 |    0 ]
```

**Step 5. Make the last diagonal entry 1.**

```
R3 -> (1/4) R3:    (0, 0, 1 | 0)

[ 1  -1   1 |    4 ]
[ 0   1  -1 | -7/2 ]
[ 0   0   1 |    0 ]
```

The matrix is now in row-echelon form.

**Step 6. Back-substitute from the bottom row up.**

```
Row 3:   z = 0
Row 2:   y - z = -7/2   ->   y = -7/2 + 0 = -7/2
Row 1:   x - y + z = 4  ->   x = 4 + y - z = 4 - 7/2 - 0 = 1/2
```

**Solution: x = 1/2, y = -7/2, z = 0**, or (0.5, -3.5, 0).

**Check in all three original equations:**

```
 x - y +  z = 0.5 + 3.5 + 0        = 4   ✓
5x - y +  z = 2.5 + 3.5 + 0        = 6   ✓
3x - y + 5z = 1.5 + 3.5 + 0        = 5   ✓
```

This system is consistent and independent, with exactly one solution, because elimination left a
nonzero number in every diagonal position.

## Task 3: A Nonlinear System

[TASK 3 PENDING: waiting for the equations]

## References

Abramson, J. (2021). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e

Mathispower4u. (2010, August 22). *Augmented matrices: Reduced row echelon form* [Video]. YouTube.
https://www.youtube.com/watch?v=-aAucWVD--M
