# Written Assignment Unit 4: Polynomials II - Higher-Order Polynomials and Rational Functions

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Maswili
**Instructor:** Chibuike Agu
**Due:** September 30, 2026

This assignment studies higher-order polynomial and rational functions through five tasks:
reading a polynomial from its graph, finding the zeros of a quartic with the Rational Zero
Theorem and synthetic division, finding the asymptotes and domain of a rational function,
identifying a rational function from its graph, and modeling the volume of an open box. Every
answer shows its steps, and the graphs were made in GeoGebra.

## Task 1: Interpreting a Polynomial Graph

### (i) Turning Points, Zeros, and x-Intercepts

**Turning points** are the points where the graph changes from rising to falling or from
falling to rising. Reading the graph from left to right:

| Point | Coordinates | What happens there |
|---|---|---|
| A | (-1.569, -3.124) | falling changes to rising (a valley) |
| B | (0.319, 8.643) | rising changes to falling (a peak) |
| C | (2, 0) | falling changes to rising (a valley that sits on the x-axis) |

So the graph has **three turning points: A, B and C** (Mathispower4u, 2012c).

**Zeros and x-intercepts.** A zero is an x-value where f(x) = 0, and the matching x-intercept is
the point where the graph meets the x-axis. The graph meets the x-axis at D, E and C:

- Zeros: **x = -2, x = -1 and x = 2**
- x-intercepts: **(-2, 0), (-1, 0) and (2, 0)**

The graph also crosses the y-axis at about (0, 8), which is used below to check the formula.

### (ii) Multiplicity

Yes. The zero **x = 2 has multiplicity 2**. The graph comes down to (2, 0), touches the x-axis,
and turns back up without crossing it. A zero where the graph touches and bounces off the axis
must have **even** multiplicity, because the factor (x - 2) raised to an even power never
changes sign, so f(x) has the same sign on both sides of x = 2 (Abramson, 2023, Section 5.3;
Mathispower4u, 2013). The smallest even multiplicity, 2, fits the graph.

The zeros **x = -2 and x = -1 each have multiplicity 1**. At these points the graph passes
straight through the x-axis, changing sign, which happens for odd multiplicity. The crossing is
not flattened, so the multiplicity is 1 rather than 3.

### (iii) Degree, Polynomial, and Where It Increases or Decreases

**Degree.** Adding the multiplicities gives 1 + 1 + 2 = **4**. Two other features agree:

- The graph has 3 turning points, and a polynomial of degree n has at most n - 1 turning
  points, so the degree is at least 3 + 1 = 4 (Mathispower4u, 2012a).
- Both ends of the graph rise, which means the degree is even and the leading coefficient is
  positive (Mathispower4u, 2012b).

**The polynomial.** Each zero gives a factor, raised to its multiplicity:

f(x) = a(x + 2)(x + 1)(x - 2)²

To find a, use the y-intercept (0, 8): f(0) = a(2)(1)(-2)² = 8a = 8, so **a = 1**.

```
f(x) = (x + 2)(x + 1)(x - 2)²
     = (x² + 3x + 2)(x² - 4x + 4)
     = x⁴ - 4x³ + 4x² + 3x³ - 12x² + 12x + 2x² - 8x + 8
     = x⁴ - x³ - 6x² + 4x + 8
```

**Check against the labeled points.** This formula reproduces the points on the graph:

- f(0.319) = (2.319)(1.319)(-1.681)² ≈ 8.643, which is point B.
- f(-1.569) = (0.431)(-0.569)(-3.569)² ≈ -3.124, which is point A.

Both match to three decimal places, so the polynomial is correct.

**Increasing and decreasing.** The graph changes direction only at the turning points, so:

| Interval | Behavior |
|---|---|
| (-∞, -1.569) | decreasing |
| (-1.569, 0.319) | increasing |
| (0.319, 2) | decreasing |
| (2, ∞) | increasing |

In exact form the turning points are at x = (-5 - √57)/8 ≈ -1.569, x = (-5 + √57)/8 ≈ 0.319,
and x = 2.

### (iv) Local Maximum and Minimum

Yes, the graph has both:

- **Local maximum:** f(0.319) ≈ **8.643**, at point **B (0.319, 8.643)**. It is the highest point
  near it, the top of the hill between x = -1.569 and x = 2.
- **Local minima:** f(-1.569) ≈ **-3.124** at point **A (-1.569, -3.124)**, and f(2) = **0** at
  point **C (2, 0)**.

Point A is also the **absolute (global) minimum**, since the graph never goes lower. There is
no absolute maximum, because both ends rise forever.

### (v) Remainder When Divided by x - 4

By the Remainder Theorem, the remainder of f(x) ÷ (x - 4) equals f(4) (Abramson, 2023,
Section 5.4):

f(4) = (4 + 2)(4 + 1)(4 - 2)² = (6)(5)(4) = **120**

Checking with synthetic division, using the coefficients 1, -1, -6, 4, 8:

```
  4 |   1    -1    -6     4     8
    |         4    12    24   112
    ------------------------------
        1     3     6    28  | 120
```

The remainder is **120**, and the quotient is x³ + 3x² + 6x + 28 (Mathispower4u, 2011b).

## Task 2: Zeros of f(x) = x⁴ - 8x³ - 8x² + 8x + 7

### (i) Rational Zero Theorem and Synthetic Division

**Step 1: List the possible rational zeros.** By the Rational Zero Theorem, every rational zero
has the form p/q, where p is a factor of the constant term and q is a factor of the leading
coefficient (Abramson, 2023, Section 5.5).

- Factors of the constant term 7: p = ±1, ±7
- Factors of the leading coefficient 1: q = ±1
- Possible rational zeros: **±1, ±7**

**Step 2: Test the candidates.** By the Remainder Theorem, f(c) is the remainder when f(x) is
divided by (x - c), so c is a zero exactly when f(c) = 0.

| Candidate | Calculation | f(c) | Zero? |
|---|---|---|---|
| x = 1 | 1 - 8 - 8 + 8 + 7 | 0 | Yes |
| x = -1 | 1 + 8 - 8 - 8 + 7 | 0 | Yes |
| x = 7 | 2401 - 2744 - 392 + 56 + 7 | -672 | No |
| x = -7 | 2401 + 2744 - 392 - 56 + 7 | 4704 | No |

**Step 3: Divide out x = 1 with synthetic division.** The coefficients of f are 1, -8, -8, 8, 7.

```
  1 |   1    -8    -8     8     7
    |         1    -7   -15    -7
    ------------------------------
        1    -7   -15    -7  |  0   <- remainder 0, so (x - 1) is a factor
```

So f(x) = (x - 1)(x³ - 7x² - 15x - 7).

**Step 4: Divide the cubic by x = -1.**

```
 -1 |   1    -7   -15    -7
    |        -1     8     7
    ------------------------
        1    -8    -7  |  0   <- remainder 0, so (x + 1) is a factor
```

So f(x) = (x - 1)(x + 1)(x² - 8x - 7) (Mathispower4u, 2011b).

**Step 5: Solve the remaining quadratic.** The quadratic x² - 8x - 7 has no rational zeros (its
only candidates, ±1 and ±7, have already failed), so we use the quadratic formula with a = 1,
b = -8, c = -7:

```
x = [8 ± √(64 + 28)] / 2 = [8 ± √92] / 2 = [8 ± 2√23] / 2 = 4 ± √23
```

**Zeros of f:** x = -1, x = 1, x = 4 - √23 ≈ -0.80, and x = 4 + √23 ≈ 8.80. Each has
multiplicity 1, so the graph crosses the x-axis at all four points. Fully factored:

f(x) = (x - 1)(x + 1)(x - (4 - √23))(x - (4 + √23))

### (ii) Graph in GeoGebra

**Figure 1**

*Graph of f(x) = x⁴ - 8x³ - 8x² + 8x + 7 in GeoGebra*

[FIGURE figures/task2_graph.png]

In Figure 1, points A, B, C and D are the zeros, Y is the y-intercept, and E, F and G are
the turning points found with GeoGebra's Root and Extremum commands. The graph confirms the
algebra. It crosses the x-axis at the four zeros found above, crosses
the y-axis at f(0) = 7, and has three turning points: a local minimum near (-0.90, -0.19), a
local maximum near (0.34, 8.49), and a deep local minimum near (6.56, -691.30). Three turning
points is the most a degree 4 polynomial can have (Abramson, 2023, Section 5.3).

### (iii) End Behavior

The end behavior of a polynomial is controlled by its leading term (Abramson, 2023, Section
5.2; Mathispower4u, 2012b). Here the leading term is x⁴: the degree 4 is **even** and the
leading coefficient 1 is **positive**. So both ends of the graph rise:

- as x → -∞, f(x) → +∞
- as x → +∞, f(x) → +∞

This matches the graph, which climbs upward on the far left and the far right.

## Task 3: Asymptotes and Domain of f(x) = (2x² - 5x + 3) / (x² + 5x)

### (i) Horizontal and Vertical Asymptotes

**Step 1: Factor the numerator and the denominator.**

- Numerator: 2x² - 5x + 3. We need two numbers that multiply to 2 × 3 = 6 and add to -5,
  which are -2 and -3. So 2x² - 2x - 3x + 3 = 2x(x - 1) - 3(x - 1) = **(2x - 3)(x - 1)**.
- Denominator: x² + 5x = **x(x + 5)**.

f(x) = (2x - 3)(x - 1) / [x(x + 5)]

**Step 2: Look for common factors.** The numerator's factors (2x - 3) and (x - 1) do not match
the denominator's factors x and (x + 5), so nothing cancels and the graph has **no holes**.

**Step 3: Vertical asymptotes.** Set the denominator equal to zero:

x(x + 5) = 0, so x = 0 or x = -5.

Neither value makes the numerator zero (at x = 0 the numerator is 3, at x = -5 it is 78), so
both are vertical asymptotes: **x = 0 and x = -5** (Abramson, 2023, Section 5.6).

The behavior near each asymptote, found by checking the sign of each factor:

| Approach | Sign of numerator | Sign of denominator | f(x) goes to |
|---|---|---|---|
| x → -5⁻ | + | + | +∞ |
| x → -5⁺ | + | - | -∞ |
| x → 0⁻ | + | - | -∞ |
| x → 0⁺ | + | + | +∞ |

**Step 4: Horizontal asymptote.** The numerator and the denominator both have degree 2. When
the degrees are equal, the horizontal asymptote is the ratio of the leading coefficients
(Abramson, 2023, Section 5.6; Mathispower4u, 2011a):

y = 2/1, so the horizontal asymptote is **y = 2**.

To see why, divide the top and bottom by x²: f(x) = (2 - 5/x + 3/x²) / (1 + 5/x). As x grows
very large in either direction, every term with x in the denominator shrinks toward 0, so f(x)
gets closer and closer to 2/1 = 2.

**A detail worth noting.** A graph can cross its horizontal asymptote in the middle, even
though it cannot cross a vertical one. Setting f(x) = 2:

2x² - 5x + 3 = 2(x² + 5x), so 2x² - 5x + 3 = 2x² + 10x, which gives -15x = -3 and x = 1/5.

So the graph crosses y = 2 once, at (0.2, 2), and then approaches y = 2 from below as x → +∞.

### (ii) Domain

A rational function is defined everywhere except where its denominator is zero, because
division by zero is undefined.

1. Set the denominator equal to zero: x² + 5x = 0.
2. Factor: x(x + 5) = 0.
3. Solve: x = 0 or x = -5.
4. Remove these two values from the real numbers.

**Domain: all real numbers except x = -5 and x = 0**, which is

{x ∈ ℝ : x ≠ -5, x ≠ 0} = **(-∞, -5) ∪ (-5, 0) ∪ (0, ∞)**

The function's zeros are x = 1 and x = 3/2 (from the numerator), and it has no y-intercept,
because x = 0 is not in the domain. Figure 2 shows the graph with its asymptotes.

**Figure 2**

*GeoGebra Graph of f(x) = (2x² - 5x + 3)/(x² + 5x) With Asymptotes x = -5, x = 0 and y = 2*

[FIGURE figures/task3_graph.png]

## Task 4: Identifying a Rational Function From Its Graph

### (i) Asymptotes, and How to Find Them in General

**Reading the graph.** The graph has two vertical asymptotes, **x = 1** and **x = 5**. Near each
of these lines the curve shoots toward +∞ on one side and -∞ on the other and never touches the
line. There is **no horizontal asymptote**: on the far left and far right the curve does not
level off toward a constant. Instead it follows a slanted straight line, rising to the right
and falling to the left, which is a sign of an **oblique (slant) asymptote**. After finding the
function in part (iii), this slant asymptote is shown to be y = x - 3.

**How to find asymptotes of any rational function f(x) = P(x) / Q(x) mathematically**
(Abramson, 2023, Section 5.6; Mathispower4u, 2011a):

1. **Factor** the numerator and the denominator completely.
2. **Cancel common factors.** A factor that cancels creates a hole (a removable
   discontinuity), not an asymptote.
3. **Vertical asymptotes:** set the remaining denominator equal to zero. Each real solution
   x = a gives a vertical asymptote, because the function's values grow without bound as x
   approaches a.
4. **Horizontal asymptote:** compare the degree n of the numerator with the degree m of the
   denominator.
   - If n < m, the horizontal asymptote is y = 0.
   - If n = m, it is y = (leading coefficient of P) / (leading coefficient of Q).
   - If n > m, there is no horizontal asymptote. When n = m + 1, there is a slant asymptote
     y = mx + b, found by dividing P by Q with long division and ignoring the remainder.

### (ii) Zeros

The zeros are the x-intercepts marked on the graph: **x = 2, x = 3 and x = 4** (points B, C
and D). At each one the graph passes straight through the x-axis, which means each zero has
odd multiplicity, and the simplest choice is multiplicity 1.

### (iii) The Rational Function

**Step 1: Numerator from the zeros.** Zeros at 2, 3 and 4 give numerator factors (x - 2),
(x - 3) and (x - 4).

**Step 2: Denominator from the vertical asymptotes.** Asymptotes at x = 1 and x = 5 give
denominator factors (x - 1) and (x - 5).

**Step 3: Use the y-intercept to find the stretch factor a.**

f(x) = a(x - 2)(x - 3)(x - 4) / [(x - 1)(x - 5)]

The graph passes through A = (0, -4.8), so

f(0) = a(-2)(-3)(-4) / [(-1)(-5)] = -24a / 5 = -4.8, which gives a = 1.

**The rational function is**

f(x) = (x - 2)(x - 3)(x - 4) / [(x - 1)(x - 5)] = (x³ - 9x² + 26x - 24) / (x² - 6x + 5)

**Step 4: Check the function against the graph.**

- **Slant asymptote.** The numerator has degree 3 and the denominator degree 2, so there is no
  horizontal asymptote. Long division gives

  x³ - 9x² + 26x - 24 = (x² - 6x + 5)(x - 3) + (3x - 9), so the slant asymptote is **y = x - 3**, a line with slope 1, which matches the straight-line
  tails of the graph.
- **Behavior at the asymptotes.** As x → 1⁻, f(x) → -∞ and as x → 1⁺, f(x) → +∞. As x → 5⁻,
  f(x) → -∞ and as x → 5⁺, f(x) → +∞. These match the four branches in the graph.
- **A point on the right branch.** f(6) = (4)(3)(2) / [(5)(1)] = 24/5 = 4.8, which matches the
  low point of the right-hand branch near (6, 4.8).
- **Domain:** all real numbers except x = 1 and x = 5, written (-∞, 1) ∪ (1, 5) ∪ (5, ∞).

**Figure 3**

*GeoGebra Check: f(x) With Its Asymptotes x = 1, x = 5 and y = x - 3*

[FIGURE figures/task4_graph.png]

## Task 5: Volume of an Open Box

### (i) The Volume Function

The cardboard has width x cm and length 3x cm. A 15 cm × 15 cm square is cut from each corner
and the sides are folded up. Folding removes 15 cm from each end of both dimensions, so:

- Height of the box: **15 cm** (the size of the cut)
- Width of the base: **x - 2(15) = x - 30 cm**
- Length of the base: **3x - 2(15) = 3x - 30 cm**

Volume = length × width × height, so

```
V(x) = 15(3x - 30)(x - 30)
     = 15(3x² - 90x - 30x + 900)
     = 15(3x² - 120x + 900)
     = 45x² - 1800x + 13500   cubic cm
```

**Is it a polynomial?** Yes. V(x) is a sum of terms of the form a·xⁿ with whole-number powers
(2, 1 and 0) and real coefficients, so it is a polynomial function. Its degree is 2, so it is a
**quadratic** function with leading coefficient 45. It is not a rational function, because
there is no variable in a denominator. This is different from Example 3.1.3 in Stitz and
Zeager (2013, p. 238), where the size of the corner cut is the variable, so the height,
width, and length all depend on x and the volume is a cubic. Here the cut is fixed at 15 cm,
so only two dimensions depend on x, and the volume is one degree lower.

### (ii) Domain of the Volume Function

Every dimension of a real box must be positive:

- Height: 15 > 0, always true.
- Width: x - 30 > 0, so x > 30.
- Length: 3x - 30 > 0, so x > 10.

Both conditions hold when x > 30. The domain of V is therefore **x > 30, or (30, ∞) in interval
notation**. At x = 30 the width is 0 and V(30) = 0, so there is no box. The formula V(x) itself
is defined for every real x, but values x ≤ 30 do not describe a real box, so they are
excluded, which is the same reasoning Stitz and Zeager (2013, p. 238) use for their applied
domain. In practice the size of the available cardboard sheet would also give an upper limit.

### (iii) Box Dimensions for a Volume of 12,500 Cubic cm

Set the volume equal to 12,500:

```
45x² - 1800x + 13500 = 12500
45x² - 1800x + 1000  = 0
9x² - 360x + 200     = 0      (dividing both sides by 5)
```

Quadratic formula with a = 9, b = -360, c = 200:

```
x = [360 ± √(360² - 4(9)(200))] / (2 · 9)
  = [360 ± √(129600 - 7200)] / 18
  = [360 ± √122400] / 18
  = [360 ± 60√34] / 18
  = 20 ± (10/3)√34
```

This gives x ≈ 39.44 or x ≈ 0.56. The value x ≈ 0.56 is outside the domain x > 30 (it would
make the width negative), so it is rejected. Therefore **x = 20 + (10/3)√34 ≈ 39.44 cm**.

**Appropriate dimensions:**

| Measurement | Expression | Value |
|---|---|---|
| Cardboard width | x | ≈ 39.44 cm |
| Cardboard length | 3x | ≈ 118.31 cm |
| Box width | x - 30 | ≈ 9.44 cm |
| Box length | 3x - 30 | ≈ 88.31 cm |
| Box height | 15 | 15 cm |

**Check:** 9.4365 × 88.3095 × 15 ≈ 12,500 cubic cm, as required.

So the courier should start with a sheet about 39.44 cm by 118.31 cm, which folds into an open
box about 88.31 cm long, 9.44 cm wide, and 15 cm high. The box is long and narrow, which suits a
flexible item that can bend or stretch to fit. Because V is increasing for every x > 30 (the
parabola's vertex is at x = 20, to the left of the domain), each volume matches exactly one
cardboard size, so this answer is the only one.

**Figure 4**

*GeoGebra Graph of V(x) on x > 30 Crossing the Line V = 12,500 at x ≈ 39.44*

[FIGURE figures/task5_graph.png]

## Conclusion

The five tasks show how polynomial and rational functions are read and used. The Rational Zero
Theorem and synthetic division turned a quartic into linear and quadratic factors, and its
leading term predicted the end behavior shown on the graph. For rational functions, the zeros
of the numerator and denominator gave the x-intercepts and vertical asymptotes, and comparing
degrees explained the slant asymptote. The open-box model showed how a real situation produces
a polynomial and why its domain must be limited to values that make physical sense.

## References

Abramson, J. (2023). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e

Mathispower4u. (2011a, March 18). *Determining vertical and horizontal asymptotes of rational
functions* [Video]. YouTube. https://www.youtube.com/watch?v=wBZxVxiJS9I

Mathispower4u. (2011b, October 9). *Ex 4: Divide a polynomial by a binomial using synthetic
division* [Video]. YouTube. https://www.youtube.com/watch?v=bqm4DoznJxo

Mathispower4u. (2012a, June 12). *Ex: Determine the least possible degree of a polynomial from
the graph* [Video]. YouTube. https://www.youtube.com/watch?v=LU1nLawYyH0

Mathispower4u. (2012b, June 11). *Summary of end behavior or long run behavior of polynomial
functions* [Video]. YouTube. https://www.youtube.com/watch?v=y78Dpr9LLN0

Mathispower4u. (2012c, June 12). *Turning points and x intercepts of a polynomial function*
[Video]. YouTube. https://www.youtube.com/watch?v=9WW0EetLD4Q

Mathispower4u. (2013, May 20). *Real zeros, factors, and graphs of polynomial functions*
[Video]. YouTube. https://www.youtube.com/watch?v=e_EttLeQblY

Stitz, C., & Zeager, J. (2013). *College algebra*. Stitz Zeager Open Source Mathematics.
https://stitz-zeager.com/szca07042013.pdf
