# MATH 1201 Final Exam Study Guide

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Maswili
**Instructor:** Chibuike Agu
**Due:** Final Exam, Unit 9

## How to Use This Guide

The proctored final exam covers all eight units. Study Part 1 until you can write the formulas from memory, review the self-quiz answers in Part 2, then take the practice exam in Part 3 without looking at Part 4. Every practice answer was checked with a computer algebra tool. Mark any question you miss and reread that unit's formulas.

## Part 1: Formula Sheet

### Units 1 and 2: Functions

- A **function** gives each input exactly one output (vertical line test). **One-to-one**: each
  output comes from one input (horizontal line test); only one-to-one functions have inverses.
- **Domain** rules: denominator ≠ 0; inside a square root ≥ 0; inside a log > 0.
- **Average rate of change** from a to b: [f(b) - f(a)] / (b - a).
- **Composition**: (f ∘ g)(x) = f(g(x)), apply g first. Usually f ∘ g ≠ g ∘ f.
- **Inverse**: write y = f(x), swap x and y, solve for y. Check f(f⁻¹(x)) = x.
- **Transformations** of y = f(x): f(x) + k up k; f(x - h) right h; -f(x) reflect in x-axis;
  f(-x) reflect in y-axis; a·f(x) vertical stretch (|a| > 1) or compression (|a| < 1).
- **Even**: f(-x) = f(x), symmetric about the y-axis. **Odd**: f(-x) = -f(x), symmetric about
  the origin.

### Unit 3: Linear and Quadratic

- Slope m = (y₂ - y₁)/(x₂ - x₁). Point-slope: y - y₁ = m(x - x₁). Slope-intercept: y = mx + b.
- Parallel: equal slopes. Perpendicular: m₁ · m₂ = -1.
- Quadratic f(x) = ax² + bx + c: vertex x = -b/(2a); opens up if a > 0 (minimum), down if a < 0
  (maximum). Vertex form a(x - h)² + k has vertex (h, k).
- **Names in our textbook:** the **standard form** of a quadratic function is a(x - h)² + k, and
  ax² + bx + c is the **general form** (Abramson, Section 5.1). Graded Quiz 3 tested this.
- Quadratic formula x = [-b ± √(b² - 4ac)] / (2a). Discriminant b² - 4ac: > 0 two real roots,
  = 0 one, < 0 none.

### Unit 4: Polynomials and Rational Functions

- End behaviour from the leading term: even degree, both ends the same way; odd degree, opposite
  ways; negative leading coefficient flips the right end down.
- Degree n: at most n real zeros and at most n - 1 turning points.
- Multiplicity: odd crosses the x-axis, even touches and bounces.
- Remainder Theorem: dividing by (x - c) leaves remainder f(c). Factor Theorem: f(c) = 0 means
  (x - c) is a factor. Rational zeros: p/q with p | constant, q | leading coefficient.
- Rational functions: cancel common factors first (cancelled factor = hole). Vertical asymptotes
  at remaining zeros of the denominator. Horizontal asymptote: top degree < bottom, y = 0;
  equal, ratio of leading coefficients; top = bottom + 1, slant asymptote (long division).

### Unit 5: Exponential and Logarithmic

- f(x) = a·bˣ: a = starting value, b = growth (b > 1) or decay (0 < b < 1) factor. Asymptote
  y = 0, domain all reals, range (0, ∞).
- Compound interest A = P(1 + r/n)^(nt); continuous A = Pe^(rt).
- y = log_b x means bʸ = x. Domain x > 0, asymptote x = 0, passes (1, 0).
- Rules: log(MN) = log M + log N; log(M/N) = log M - log N; log(Mᵏ) = k log M;
  change of base log_b x = ln x / ln b.
- Solve exponentials by taking logs of both sides; solve logs by rewriting in exponential form
  (then check the domain).

### Unit 6: Trigonometry I

- Degrees to radians × π/180; radians to degrees × 180/π.
- SOH CAH TOA; csc = 1/sin, sec = 1/cos, cot = 1/tan.
- Unit circle: (cos θ, sin θ). Signs by quadrant: All, Sin, Tan, Cos (QI to QIV).
- Reference angle: QII 180° - θ, QIII θ - 180°, QIV 360° - θ.
- Exact values: sin 30° = 1/2, sin 45° = √2/2, sin 60° = √3/2 (cosine in reverse order);
  tan 30° = √3/3, tan 45° = 1, tan 60° = √3.
- y = A sin(Bx - C) + D: amplitude |A|, period 2π/|B|, phase shift C/B, midline y = D.
  Tangent period π/|B|.
- Arc length s = rθ (radians); sector area (θ/360°)πr².
- arcsin and arctan give angles in [-π/2, π/2]; arccos gives angles in [0, π].

### Unit 7: Trigonometry II (Identities)

- Pythagorean: sin²θ + cos²θ = 1; 1 + tan²θ = sec²θ; 1 + cot²θ = csc²θ.
- Sum and difference: sin(A ± B) = sinA cosB ± cosA sinB; cos(A ± B) = cosA cosB ∓ sinA sinB;
  tan(A ± B) = (tanA ± tanB)/(1 ∓ tanA tanB).
- Double angle: sin 2θ = 2 sinθ cosθ; cos 2θ = cos²θ - sin²θ = 1 - 2sin²θ = 2cos²θ - 1;
  tan 2θ = 2tanθ/(1 - tan²θ).
- Half angle: sin(θ/2) = ±√[(1 - cosθ)/2]; cos(θ/2) = ±√[(1 + cosθ)/2] (sign from the quadrant
  of θ/2).
- Sum to product: cosA - cosB = -2 sin[(A+B)/2] sin[(A-B)/2]; sinA - sinB = 2 cos[(A+B)/2]
  sin[(A-B)/2]. Product to sum: sinA cosB = ½[sin(A+B) + sin(A-B)].
- Solving: isolate the trig function, find the reference angle, list every quadrant where the
  sign matches, then add the period for each extra rotation.

### Unit 8: Systems of Equations

- Independent: one solution (lines cross). Dependent: infinitely many (same line, elimination
  gives 0 = 0). Inconsistent: none (parallel lines, elimination gives a false statement like
  0 = 3). Consistent = independent or dependent.
- Methods: substitution, elimination, Gaussian elimination (row operations only: swap rows,
  multiply a row by a nonzero number, add a multiple of one row to another).
- Nonlinear (line and curve): substitute the line into the curve and solve the quadratic;
  0, 1, or 2 intersection points.


## Part 2: Self-Quiz Review (From Your Notes)

### Unit 4

| Question | Answer | Why |
|---|---|---|
| Degree, leading coefficient, leading term of -2x¹⁰ - 25x⁴ + 30x³ - 20x + 5 | 10, -2, -2x¹⁰ | The highest power is 10 |
| Zeros of 6x³ + 2x² - 4x | 0, 2/3, -1 | 2x(3x - 2)(x + 1) |
| Graph with both ends down | Negative leading coefficient, even degree | Same direction = even; down = negative |
| Vertical asymptotes of (x - 1)/(x² + 4x + 3) | x = -3, x = -1 | (x + 1)(x + 3), nothing cancels |
| Vertical asymptotes of (x - 5)/(x⁴ + 2x³ + x²) | x = 0, x = -1 | x²(x + 1)² |

### Unit 5

| Question | Answer | Why |
|---|---|---|
| 2(7ˣ) compared with 7ˣ | Stretches vertically | Multiplying the output by 2 |
| Domain, range, asymptote of 23ˣ | (-∞, ∞), (0, ∞), y = 0 | Every exponential bˣ |
| True about e^(-x) | Approaches zero but never reaches it | Decay towards y = 0 |
| 9ˣ as x → -∞ | Approaches zero | Left tail of growth |
| Reflection of 5ˣ about the y-axis | (-∞, ∞), (0, ∞), asymptote y = 0 | Reflection keeps domain, range, asymptote |

### Unit 6 (Review of Units 3 to 6)

| Topic | Answer | Why |
|---|---|---|
| Which is a polynomial | 3x² - 5x + 2 | Whole-number powers only |
| Zero of 7x + 3 | -3/7 | 7x + 3 = 0 |
| 7 radians in degrees | 401° | 7 × 180/π ≈ 401.07 |
| $25,000 at 8% for 3 years | $31,492.80 | 25000 × 1.08³ |
| Degree-10 polynomial: max x-intercepts, turning points | 10, 9 | n and n - 1 |
| Domain and range of log(4x + 5) | (-5/4, ∞), (-∞, ∞) | 4x + 5 > 0 |
| Present value of $8000 in 3 years at 6% | about $6,717 (option $6,720) | 8000 ÷ 1.06³ |
| Solve 2ˣ = 1/6 | -2.5849 | x = log₂(1/6) |
| Multiplying a function by 25 compresses it | False | It stretches |
| Distance with angle of elevation 60° and height 20 m | 11.54 m | 20 / tan 60° |
| Horizontal asymptote when top degree 3, bottom 2 | Does not exist | Top degree is larger |
| 1560° in radians (reduced) | 2π/3 | 1560 - 4(360) = 120° |
| Quadrantal angle | Terminal side on an axis | 0°, 90°, 180°, 270° |
| cos t = -3/5 in QII, find sin t | 4/5 | sin² t = 16/25, sine positive in QII |
| Sector 30°, radius 20 cm | about 105 cm² | (30/360)π(20²) |
| y = -10 sin x - 7: amplitude, midline | 10, y = -7 | Amplitude is |A| |
| cos 450° | 0 | Coterminal with 90° |

### Unit 7

| Question | Answer | Why |
|---|---|---|
| sec θ · sec θ · cos θ · tan θ · sin θ · cot θ | tan θ | sec²θ cos θ = sec θ; tan θ cot θ = 1; sec θ sin θ = tan θ |
| (sin x + cos x)/(csc x tan x + sec x cot x) | sin x cos x | csc x tan x = sec x; sec x cot x = csc x |
| A = sin x, B = cos x: A² - B² | -cos 2x | -(cos²x - sin²x) |
| 2cos x = 4cos x - √3 on [0, 2π] | x = 30°, 330° | cos x = √3/2 |
| (cos 5x - cos 7x)/(sin 5x - sin 7x) | -tan 6x | Sum-to-product on top and bottom |

### Unit 8

| Question | Answer | Why |
|---|---|---|
| Circle x² + y² = 4 meets ellipse x² + 4y² = 4 | (2, 0), (-2, 0) | Subtract: 3y² = 0 |
| Gaussian elimination uses row and column operations | False | Row operations only |
| 3x + 2y = 7 and 6x + 4y = 10 is consistent | False | Parallel lines (would need 14) |
| A parabola meets a line in at most two points | True | Substitution gives a quadratic |
| Independent system | Unique solution, lines meet at a point | Definition |

## Part 3: Practice Exam (48 Questions) and Graded Quiz Review

Write your answers on paper, then check them in Part 4.

### Unit 1: Functions I

**1.** Which set of ordered pairs represents a function?

- A. {(1, 2), (2, 4), (3, 6)}
- B. {(1, 2), (1, 3), (2, 4)}
- C. {(0, 1), (0, -1)}
- D. {(2, 2), (2, 3), (3, 3)}

**2.** What is the domain of f(x) = √(x - 3)?

- A. (-∞, ∞)
- B. [3, ∞)
- C. (3, ∞)
- D. [0, ∞)

**3.** If f(x) = 2x² - 3x + 1, what is f(-2)?

- A. 3
- B. -1
- C. 15
- D. 11

**4.** What is the average rate of change of f(x) = x² from x = 1 to x = 4?

- A. 15
- B. 4
- C. 3
- D. 5

**5.** f(x) = x + 2 when x < 0, and f(x) = x² when x ≥ 0. What is f(-3) + f(3)?

- A. 8
- B. 10
- C. -1
- D. 18

**6.** What is the domain of f(x) = 1 / (x² - 9)?

- A. x ≠ 9
- B. x ≠ 3 and x ≠ -3
- C. x > 3
- D. All real numbers

### Unit 2: Functions II

**7.** If f(x) = x + 1 and g(x) = x², what is (f ∘ g)(x)?

- A. x² + 2x + 1
- B. (x + 1)²
- C. x² + 1
- D. x³ + x²

**8.** With f(x) = x + 1 and g(x) = x², what is (g ∘ f)(2)?

- A. 6
- B. 4
- C. 5
- D. 9

**9.** What is the inverse of f(x) = (2x - 5) / 3?

- A. f⁻¹(x) = (3x + 5) / 2
- B. f⁻¹(x) = (3x - 5) / 2
- C. f⁻¹(x) = 3 / (2x - 5)
- D. f⁻¹(x) = (2x + 5) / 3

**10.** Compared with the graph of f(x), the graph of g(x) = f(x - 2) + 3 is:

- A. shifted left 2 and up 3
- B. shifted right 2 and up 3
- C. shifted right 2 and down 3
- D. shifted left 2 and down 3

**11.** Which function is even?

- A. f(x) = 2x
- B. f(x) = x³ + x
- C. f(x) = x⁴ - 3x²
- D. f(x) = x + 1

**12.** The graph of y = -f(x) is the graph of y = f(x):

- A. shifted down 1
- B. unchanged
- C. reflected about the y-axis
- D. reflected about the x-axis

### Unit 3: Linear and Quadratic Functions

**13.** What is the slope of the line through (2, -1) and (6, 7)?

- A. 2
- B. -2
- C. 8
- D. 1/2

**14.** What is the slope of a line perpendicular to y = 3x + 1?

- A. 1/3
- B. -1/3
- C. 3
- D. -3

**15.** What is the vertex of f(x) = 2x² - 8x + 3?

- A. (4, 3)
- B. (2, 3)
- C. (2, -5)
- D. (-2, 27)

**16.** What are the solutions of x² - 5x + 6 = 0?

- A. x = 1, 6
- B. x = -1, 6
- C. x = -2, -3
- D. x = 2, 3

**17.** A ball's height is h(t) = -5t² + 20t + 1 metres. What is its maximum height?

- A. 21 m
- B. 1 m
- C. 41 m
- D. 20 m

**18.** How many real solutions does 2x² + 3x + 5 = 0 have?

- A. One
- B. None
- C. Infinitely many
- D. Two

### Unit 4: Polynomial and Rational Functions

**19.** What is the end behaviour of f(x) = -3x⁵ + 2x² - 1?

- A. Up on both ends
- B. Down on the left, up on the right
- C. Up on the left, down on the right
- D. Down on both ends

**20.** What is the remainder when x³ - 2x² + 4 is divided by (x - 3)?

- A. 4
- B. -5
- C. 31
- D. 13

**21.** What is the horizontal asymptote of f(x) = (3x² + 1) / (x² - 4)?

- A. y = 3
- B. y = 1/4
- C. None
- D. y = 0

**22.** f(x) = (x² - 1) / (x - 1) has, at x = 1:

- A. a vertical asymptote
- B. a hole
- C. a zero
- D. a horizontal asymptote

**23.** What is the greatest number of turning points a degree-6 polynomial can have?

- A. 6
- B. 7
- C. 5
- D. 3

**24.** At a zero of multiplicity 2, the graph of a polynomial:

- A. has a vertical asymptote
- B. has a hole
- C. crosses the x-axis
- D. touches the x-axis and turns back

### Unit 5: Exponential and Logarithmic Functions

**25.** Solve 3ˣ = 81.

- A. x = 4
- B. x = 9
- C. x = 27
- D. x = 3

**26.** What is log₂ 32?

- A. 16
- B. 5
- C. 4
- D. 6

**27.** Which is the expanded form of log(x²y / z)?

- A. 2 log x · log y / log z
- B. 2 log(xy) - log z
- C. 2 log x + log y - log z
- D. log 2x + log y - log z

**28.** Solve ln x = 2.

- A. x = ln 2
- B. x = 100
- C. x = 2e
- D. x = e² ≈ 7.389

**29.** $1000 is invested at 5% interest compounded annually. What is it worth after 3 years?

- A. $1157.63
- B. $1050.00
- C. $1161.83
- D. $1150.00

**30.** What is the domain of f(x) = log(x - 4)?

- A. [4, ∞)
- B. (4, ∞)
- C. (0, ∞)
- D. (-∞, ∞)

### Unit 6: Trigonometry I

**31.** Convert 150° to radians.

- A. 2π/3
- B. 5π/3
- C. 5π/6
- D. 3π/4

**32.** What is the exact value of cos(5π/6)?

- A. 1/2
- B. -1/2
- C. √3/2
- D. -√3/2

**33.** What is the reference angle of 225°?

- A. 45°
- B. 135°
- C. 25°
- D. 75°

**34.** What are the amplitude and period of y = 3 sin(2x)?

- A. Amplitude 2, period 3π
- B. Amplitude 3, period π
- C. Amplitude 3, period 2π
- D. Amplitude 6, period π

**35.** In a right triangle, the side opposite θ is 5 and the hypotenuse is 13. What is cos θ?

- A. 13/12
- B. 5/13
- C. 12/13
- D. 5/12

**36.** What is arcsin(1/2)?

- A. 5π/6
- B. π/4
- C. π/3
- D. π/6

### Unit 7: Trigonometry II (Identities)

**37.** What is the exact value of sin 75°?

- A. (√6 + √2)/4
- B. (√6 - √2)/4
- C. √3/2
- D. (√3 + 1)/2

**38.** If sin θ = 3/5, what is cos 2θ?

- A. 24/25
- B. 7/25
- C. -7/25
- D. 9/25

**39.** Simplify (1 - cos²x) / sin x.

- A. 1
- B. cos x
- C. sin x
- D. tan x

**40.** Solve 2 sin x - 1 = 0 for 0 ≤ x < 2π.

- A. x = π/3, 2π/3
- B. x = π/6, 7π/6
- C. x = π/6 only
- D. x = π/6, 5π/6

**41.** If tan θ = 1/2, what is tan 2θ?

- A. 4/3
- B. 3/4
- C. 1/4
- D. 1

**42.** Which expression equals cos²x - sin²x?

- A. sin 2x
- B. cos 2x
- C. 1
- D. 2 cos x

### Unit 8: Systems of Equations

**43.** Solve: x + y = 10 and x - y = 2.

- A. (8, 2)
- B. (4, 6)
- C. (6, 4)
- D. (5, 5)

**44.** The system 2x + 4y = 8 and x + 2y = 4 is:

- A. has exactly two solutions
- B. consistent and independent
- C. inconsistent
- D. consistent and dependent

**45.** The system x + y = 3 and x + y = 7 is:

- A. inconsistent
- B. consistent and dependent
- C. has one solution (5, 2)
- D. consistent and independent

**46.** Where does the circle x² + y² = 25 meet the line y = x + 1?

- A. They do not meet
- B. (3, 4) and (-4, -3)
- C. (4, 3) and (-3, -4)
- D. (0, 5) and (5, 0)

**47.** Which is NOT an allowed row operation in Gaussian elimination?

- A. Multiply a row by a nonzero number
- B. Add a multiple of one row to another
- C. Multiply a row by 0
- D. Swap two rows

**48.** Solve x + y + z = 6, y + z = 5, z = 3 by back-substitution.

- A. (3, 2, 1)
- B. (2, 1, 3)
- C. (1, 3, 2)
- D. (1, 2, 3)

### Graded Quiz Unit 3 (real questions)

**49.** If f(x) = 3x⁵ and g(x) = (x - 1)/x², what is g(f(x))?

- A. (3x⁵ - 1)/(18x¹⁰)
- B. (3x⁵ - 1)/(6x⁷)
- C. (3x⁵ - 1)/(9x¹⁰)
- D. (3x⁵ - 1)/(18x⁷)

**50.** f(x) = √(x + 3). What is the range of the inverse function f⁻¹(x)?

- A. (-∞, -3]
- B. ℝ (all real numbers)
- C. (-∞, -3) ∪ (-3, ∞)
- D. [-3, ∞)

**51.** The inverse of f(x) = x⁴ + 50 is:

- A. (x - 50)^(1/4)
- B. (50 + x)^(1/4)
- C. (x + 50)^(1/4)
- D. (50 - x)^(1/4)

**52.** y = √(x + 2) with domain (-∞, ∞) and codomain [0, ∞). This relation is a function.

- A. True
- B. False

**53.** f(x) = √(3x - 2). Which gives the domain and range?

- A. Domain (-∞, ∞); Range [0, ∞)
- B. Domain [2/3, ∞); Range (-∞, ∞)
- C. Domain (-∞, ∞); Range (-∞, ∞)
- D. Domain [2/3, ∞); Range [0, ∞)

**54.** {(1, 3), (2, 4), (3, 6), (4, 8), (5, 10)} with domain {1, 2, 3, 4, 5} and codomain {3, 4, 5, 6, 7, 8, 9, 10} is a function.

- A. True
- B. False

**55.** A city of 100,000 grows by 2,000 people per year. Which equation gives the population P after t years?

- A. P = 100,000t + 2,000
- B. P = 2,000t + 100,000
- C. P = 2,000t - 100,000
- D. P = 100,000 - 2,000

**56.** g(x) = 3x - 10. What is the domain of g⁻¹(x)?

- A. (-∞, 10/3] ∪ [10/3, ∞)
- B. (-∞, 10/3) ∪ (10/3, ∞)
- C. (10/3, ∞)
- D. [-10/3, ∞)

**57.** What is the standard form of a quadratic equation (course key)?

- A. y = eˣ
- B. y = a(x - h)² + k
- C. y = mx + b
- D. ax² + bx + c = 0

**58.** f(x) = √(10 - x)/(x + 11). What is the domain of f?

- A. (-11, 10]
- B. (-∞, 10) ∪ (10, 11)
- C. (-∞, -11) ∪ (-11, 10]
- D. [-11, 10) ∪ (10, ∞)

**59.** Which quadratic equation has exactly one real solution?

- A. x² + 32x + 256 = 0
- B. x² - 5x - 14 = 0
- C. x² - 2x - 10 = 0
- D. x² + 4x - 12 = 0

**60.** Which polynomial function can model the height of a ball thrown into the air?

- A. y = x⁵
- B. y = x²
- C. y = x⁴
- D. y = x³

**61.** f(x) = 10x, g(x) = x², h(x) = x³. Simplify (f ∘ g ∘ h)(x).

- A. 10x⁶
- B. 100x⁵
- C. 10x⁵
- D. 100x⁶

**62.** f(x) = log₂(x - 2). Which gives the domain and range?

- A. Domain [2, ∞); Range (-∞, 0)
- B. Domain (2, ∞); Range (-∞, ∞)
- C. Domain (2, ∞); Range (-∞, 0)
- D. Domain (-∞, 2); Range (-∞, ∞)

**63.** Which is a quadratic equation in the variable x?

- A. y = x² + 2x + 1
- B. y² = x²
- C. y = y² + 2x + 1
- D. x³ + 2x + 1 = 0

### Graded Quiz Unit 6 (real questions)

**64.** Which is an example of a polynomial function used to model a real-world situation?

- A. f(x) = 1/x
- B. f(x) = 3x² - 5x + 2
- C. f(x) = √x
- D. f(x) = eˣ

**65.** What is the phase shift of 23 sin(7x + 3) - 7?

- A. -3/7
- B. -7/3
- C. 7/3
- D. 3/7

**66.** Convert 7 radians to degrees.

- A. 401°
- B. 2520°
- C. 14°
- D. 808°

**67.** $25,000 earns 8% compounded annually. How much is there after 3 years?

- A. $31492.8
- B. $31692.8
- C. $31392.8
- D. $31592.8

**68.** How many intercepts and turning points can 20x¹⁰ + 6x⁹ - 3x⁵ - 10x⁴ have (at most)?

- A. 6, 5
- B. 5, 6
- C. 9, 10
- D. 10, 9

**69.** What are the domain and range of log(4x + 5)?

- A. (-∞, ∞), (-∞, ∞)
- B. (0, ∞), (-∞, ∞)
- C. (-5/4, ∞), (-∞, ∞)
- D. (5/4, ∞), (0, ∞)

**70.** A picture shows a straight line and a U-shaped curve drawn together on the same axes; the U-shaped curve stops at the top instead of continuing. True or false: this graph can be a polynomial of degree 2 or more.

- A. True
- B. False

**71.** What does the 10 in 20(10ˣ) determine?

- A. x-intercept
- B. y-intercept
- C. rate of growth or decay
- D. slope of the tangent line

**72.** After 3 years at 6% compounded annually, an account holds $8,000. What was the principal?

- A. $6000
- B. $6800
- C. $6,720
- D. $5550

**73.** Solve 5 = 6(2ˣ) + 4.

- A. -2.5849
- B. 2.5849
- C. 0.3868
- D. -0.3868

**74.** 25 log₁₀₀ x + 25 compared with log₁₀₀ x is a vertical compression by 25.

- A. True
- B. False

**75.** The angle of elevation to the top of a 20 m tree is 60°. About how far is the observer from the tree?

- A. 34.6 meters
- B. 20 meters
- C. 11.54 meters
- D. 40 meters

**76.** How can the unit circle be used to find trigonometric values for any angle?

- A. By drawing a right triangle in the circle
- B. By using a calculator or table of values
- C. By memorizing the values
- D. By measuring the angle in degrees

**77.** Horizontal asymptotes of f(x) = (5x³ - 10)/(10x² - 12x + 20)?

- A. y = 1/2
- B. x = 5
- C. Do not exist
- D. x = 2

**78.** What is 1560° equal to (as a coterminal angle in radians)?

- A. 4π/3
- B. π
- C. 2π/3
- D. 2π

## Part 4: Answer Key With Worked Solutions

**1. A** ({(1, 2), (2, 4), (3, 6)}). A function gives each input exactly one output. Only the first set never repeats an x-value.

**2. B** ([3, ∞)). The inside of a square root must be at least 0: x - 3 ≥ 0, so x ≥ 3, written [3, ∞).

**3. C** (15). f(-2) = 2(4) - 3(-2) + 1 = 8 + 6 + 1 = 15. Watch the signs: -3 times -2 is +6.

**4. D** (5). Average rate of change = [f(4) - f(1)] / (4 - 1) = (16 - 1) / 3 = 15 / 3 = 5.

**5. A** (8). f(-3) uses the first rule: -3 + 2 = -1. f(3) uses the second rule: 3² = 9. Sum: -1 + 9 = 8.

**6. B** (x ≠ 3 and x ≠ -3). The denominator cannot be 0: x² - 9 = 0 when x = 3 or x = -3, so those two values are excluded.

**7. C** (x² + 1). (f ∘ g)(x) = f(g(x)) = f(x²) = x² + 1. Work from the inside out: apply g first, then f.

**8. D** (9). (g ∘ f)(2) = g(f(2)) = g(3) = 9. Note that (f ∘ g)(2) = 5, so composition order matters.

**9. A** (f⁻¹(x) = (3x + 5) / 2). Write y = (2x - 5)/3, swap x and y: x = (2y - 5)/3. Then 3x = 2y - 5, 2y = 3x + 5, y = (3x + 5)/2.

**10. B** (shifted right 2 and up 3). Inside the brackets the shift is opposite to the sign: x - 2 means right 2. Outside, + 3 means up 3.

**11. C** (f(x) = x⁴ - 3x²). Even means f(-x) = f(x). (-x)⁴ - 3(-x)² = x⁴ - 3x², unchanged. Its graph is symmetric about the y-axis.

**12. D** (reflected about the x-axis). Multiplying the output by -1 flips every point (x, y) to (x, -y): a reflection about the x-axis. Reflection about the y-axis is f(-x).

**13. A** (2). m = (y₂ - y₁)/(x₂ - x₁) = (7 - (-1))/(6 - 2) = 8/4 = 2.

**14. B** (-1/3). Perpendicular slopes are negative reciprocals: m₁ × m₂ = -1, so m₂ = -1/3.

**15. C** ((2, -5)). x = -b/(2a) = 8/4 = 2. f(2) = 2(4) - 16 + 3 = -5. Vertex (2, -5), a minimum because a > 0.

**16. D** (x = 2, 3). Factor: two numbers that multiply to 6 and add to -5 are -2 and -3, so (x - 2)(x - 3) = 0, x = 2 or 3.

**17. A** (21 m). Peak at t = -b/(2a) = -20/(-10) = 2 s. h(2) = -20 + 40 + 1 = 21 m.

**18. B** (None). Discriminant b² - 4ac = 9 - 40 = -31 < 0, so there are no real solutions (the parabola misses the x-axis).

**19. C** (Up on the left, down on the right). Only the leading term -3x⁵ matters: odd degree, negative coefficient, so it rises on the left and falls on the right.

**20. D** (13). Remainder Theorem: the remainder is f(3) = 27 - 18 + 4 = 13.

**21. A** (y = 3). Same degree on top and bottom, so y = (leading coefficient on top)/(leading coefficient on bottom) = 3/1 = 3.

**22. B** (a hole). x² - 1 = (x - 1)(x + 1). The factor (x - 1) cancels, so x = 1 is a hole, not an asymptote.

**23. C** (5). A polynomial of degree n has at most n - 1 turning points: 6 - 1 = 5.

**24. D** (touches the x-axis and turns back). Even multiplicity: the graph touches and bounces. Odd multiplicity: it crosses.

**25. A** (x = 4). 81 = 3⁴, so 3ˣ = 3⁴ and x = 4.

**26. B** (5). log₂ 32 asks: 2 to what power is 32? 2⁵ = 32, so the answer is 5.

**27. C** (2 log x + log y - log z). Product rule adds, quotient rule subtracts, power rule brings exponents down: log x² + log y - log z = 2 log x + log y - log z.

**28. D** (x = e² ≈ 7.389). ln x = 2 means e² = x, so x = e² ≈ 7.389. (log x = 2 would give 100.)

**29. A** ($1157.63). A = P(1 + r)ᵗ = 1000(1.05)³ = 1000 × 1.157625 = $1157.63. ($1150 would be simple interest.)

**30. B** ((4, ∞)). The input of a log must be greater than 0: x - 4 > 0, so x > 4, written (4, ∞) with a round bracket.

**31. C** (5π/6). Multiply by π/180: 150 × π/180 = 15π/18 = 5π/6.

**32. D** (-√3/2). 5π/6 = 150° is in Quadrant II, where cosine is negative. Reference angle 30°: cos 30° = √3/2, so cos(5π/6) = -√3/2.

**33. A** (45°). 225° is in Quadrant III: reference angle = 225° - 180° = 45°.

**34. B** (Amplitude 3, period π). Amplitude = |A| = 3. Period = 2π/|B| = 2π/2 = π.

**35. C** (12/13). Adjacent = √(13² - 5²) = √144 = 12. cos θ = adjacent/hypotenuse = 12/13.

**36. D** (π/6). arcsin returns an angle in [-π/2, π/2] whose sine is 1/2: that is π/6 (30°). 5π/6 also has sine 1/2 but is outside the range.

**37. A** ((√6 + √2)/4). sin(45° + 30°) = sin45 cos30 + cos45 sin30 = (√2/2)(√3/2) + (√2/2)(1/2) = (√6 + √2)/4.

**38. B** (7/25). Use cos 2θ = 1 - 2 sin²θ = 1 - 2(9/25) = 1 - 18/25 = 7/25. No quadrant information is needed for this form.

**39. C** (sin x). By the Pythagorean identity, 1 - cos²x = sin²x, and sin²x / sin x = sin x.

**40. D** (x = π/6, 5π/6). sin x = 1/2. Sine is positive in Quadrants I and II: x = π/6 and π - π/6 = 5π/6.

**41. A** (4/3). tan 2θ = 2 tan θ / (1 - tan²θ) = 1 / (1 - 1/4) = 1 / (3/4) = 4/3.

**42. B** (cos 2x). This is the double-angle identity cos 2x = cos²x - sin²x (also 2cos²x - 1 and 1 - 2sin²x).

**43. C** ((6, 4)). Add the equations: 2x = 12, x = 6. Then y = 10 - 6 = 4. Check: 6 - 4 = 2.

**44. D** (consistent and dependent). The first equation is 2 times the second, so both are the same line: infinitely many solutions (dependent).

**45. A** (inconsistent). Subtracting gives 0 = 4, a contradiction. The lines are parallel, so there is no solution.

**46. B** ((3, 4) and (-4, -3)). Substitute: x² + (x + 1)² = 25, so 2x² + 2x - 24 = 0, x² + x - 12 = 0, (x + 4)(x - 3) = 0. x = 3 gives y = 4; x = -4 gives y = -3.

**47. C** (Multiply a row by 0). Multiplying a row by 0 destroys an equation. The three allowed operations keep the solution set the same.

**48. D** ((1, 2, 3)). z = 3. Then y = 5 - 3 = 2. Then x = 6 - 2 - 3 = 1. Answer (1, 2, 3).

**49. C** ((3x⁵ - 1)/(9x¹⁰)). Put f(x) = 3x⁵ in place of x in g: (3x⁵ - 1)/(3x⁵)². The denominator is 3² · (x⁵)² = 9x¹⁰.

**50. D** ([-3, ∞)). The range of f⁻¹ equals the domain of f. For √(x + 3) we need x + 3 ≥ 0, so x ≥ -3: [-3, ∞).

**51. A** ((x - 50)^(1/4)). YOU MISSED THIS ONE. Swap x and y: x = y⁴ + 50. Undo the + 50 first by SUBTRACTING: y⁴ = x - 50. Then take the fourth root: y = (x - 50)^(1/4). The inverse undoes each step in reverse order with the opposite operation, so + 50 becomes - 50.

**52. B** (False). False. A function must give an output for EVERY input in its domain, but √(x + 2) has no real value for x < -2 (e.g. x = -3). With domain [-2, ∞) it would be a function.

**53. D** (Domain [2/3, ∞); Range [0, ∞)). 3x - 2 ≥ 0 gives x ≥ 2/3. A square root is never negative, so the range is [0, ∞).

**54. A** (True). True. Every domain value has exactly one output, and every output is in the codomain. The codomain may contain extra values (5, 7, 9) that are never used.

**55. B** (P = 2,000t + 100,000). Linear model P = (rate)t + (starting value): the slope is 2,000 per year, the intercept is 100,000.

**56. A** ((-∞, 10/3] ∪ [10/3, ∞)). YOU MISSED THIS ONE. g is a line, so its inverse g⁻¹(x) = (x + 10)/3 is also a line, defined for ALL real numbers. The marked answer (-∞, 10/3] ∪ [10/3, ∞) is just an unusual way of writing all real numbers, because 10/3 is included in both pieces. The option you picked leaves out 10/3, which only happens when a denominator is zero, and there is no denominator here. Rule: domain of g⁻¹ = range of g.

**57. B** (y = a(x - h)² + k). TRAP: in our textbook (Abramson, Section 5.1), the STANDARD form of a quadratic function is f(x) = a(x - h)² + k (the vertex form), and ax² + bx + c is called the GENERAL form. Many other books call ax² + bx + c the standard form, which is why the instructor accepted both answers here. On this course's exam, read 'standard form' as a(x - h)² + k.

**58. C** ((-∞, -11) ∪ (-11, 10]). Two rules: under the root 10 - x ≥ 0, so x ≤ 10 (10 included); the denominator x + 11 ≠ 0, so x ≠ -11. Together: (-∞, -11) ∪ (-11, 10].

**59. A** (x² + 32x + 256 = 0). One real solution means the discriminant b² - 4ac = 0: 32² - 4(256) = 1024 - 1024 = 0. It is a perfect square, (x + 16)² = 0.

**60. B** (y = x²). A thrown ball follows a parabola, which is a quadratic (degree 2) function.

**61. A** (10x⁶). Work from the inside out: h(x) = x³, then g(x³) = (x³)² = x⁶, then f(x⁶) = 10x⁶.

**62. B** (Domain (2, ∞); Range (-∞, ∞)). The inside of a log must be > 0: x - 2 > 0, so x > 2 with a ROUND bracket. A log takes every real value.

**63. A** (y = x² + 2x + 1). Quadratic in x means the highest power of x is 2, with y as the output: y = x² + 2x + 1.

**64. B** (f(x) = 3x² - 5x + 2). A polynomial uses only whole-number powers of x. 1/x = x⁻¹, √x = x^(1/2), and eˣ has x in the exponent.

**65. A** (-3/7). Factor B out: 7x + 3 = 7(x + 3/7). The graph moves 3/7 to the LEFT, a phase shift of -3/7 (set 7x + 3 = 0, x = -3/7).

**66. A** (401°). Multiply by 180/π: 7 × 180/π ≈ 401.07°. (7 × 360 = 2520 is the trap.)

**67. A** ($31492.8). A = P(1 + r)ᵗ = 25000(1.08)³ = 25000 × 1.259712 = $31,492.80.

**68. D** (10, 9). Degree 10: at most 10 x-intercepts and at most 10 - 1 = 9 turning points.

**69. C** ((-5/4, ∞), (-∞, ∞)). 4x + 5 > 0 gives x > -5/4. Every log takes all real values, so the range is (-∞, ∞).

**70. B** (False). YOU MISSED THIS ONE. The key is False. A polynomial's graph is ONE smooth, unbroken curve that passes the vertical line test and continues forever to the left and right. This picture has two separate graphs (a vertical line would cross both the line and the U-curve), and the U-curve is cut off, so as drawn it is not the graph of a single polynomial. Lesson: before calling a graph a polynomial, check it is one smooth curve, passes the vertical line test, and has no breaks, corners, or flat pieces.

**71. C** (rate of growth or decay). In a·bˣ, b is the growth factor. The 20 is the starting value (the y-intercept).

**72. C** ($6,720). Work backwards: P = 8000 / 1.06³ = 8000 / 1.191016 ≈ $6,716.95, closest to $6,720.

**73. A** (-2.5849). Subtract 4: 1 = 6(2ˣ). Divide by 6: 2ˣ = 1/6. Take logs: x = log(1/6)/log 2 ≈ -2.5849 (negative because 1/6 < 1).

**74. B** (False). False. Multiplying by 25 is a vertical STRETCH by 25 (the + 25 shifts it up). A compression needs a factor between 0 and 1.

**75. C** (11.54 meters). tan 60° = opposite/adjacent = 20/d, so d = 20/tan 60° = 20/√3 ≈ 11.54 m. (34.6 = 20 × √3 is the trap.)

**76. A** (By drawing a right triangle in the circle). A right triangle drawn from the point (x, y) to the x-axis, with hypotenuse 1, gives cos θ = x and sin θ = y.

**77. C** (Do not exist). Top degree 3 is greater than bottom degree 2, so there is no horizontal asymptote (there is a slant one). Horizontal asymptotes are written y = ..., never x = ....

**78. C** (2π/3). Remove full turns: 1560° - 4 × 360° = 120°. Then 120 × π/180 = 2π/3.


## Part 5: Exam-Day Checklist

- **Rosalyn rules:** a Windows or macOS computer (no phone or tablet), and only paper, a pencil,
  and a calculator. No notes or books, so learn the formula sheet in Part 1 beforehand.
- **Calculator mode:** check degrees or radians before every trig question. Most wrong trig
  answers come from the wrong mode.
- **Plug back in:** for any "solve" question, substitute your answer into the original equation.
  It takes seconds and catches sign errors.
- **Use the options:** with multiple choice, you can test each option in the equation when
  solving directly is slow.
- **Standard vs general form:** in this course "standard form" of a quadratic is a(x - h)² + k.
- **Inverses:** undo each step in reverse with the opposite operation (x⁴ + 50 becomes
  (x - 50)^(1/4)); the domain of f⁻¹ is the range of f, so a linear function's inverse takes all
  real numbers.
- **Watch the traps from this course:** composition order (f ∘ g vs g ∘ f), round vs square
  brackets in domains, hole vs asymptote, arcsin's range, the sign of cosine in Quadrant II, and
  "dependent" systems hidden in word problems.
- **Pace:** answer the questions you know first, mark the hard ones, and come back.

## References

Abramson, J. (2021). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e
