# Written Assignment Unit 2: Functions - II

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Maswili

---

## Introduction

This assignment applies four core ideas about functions: combining functions through
algebraic operations and composition, inverting a function, transforming a function's graph,
and testing a function for even or odd symmetry. Each task is worked step by step with the
reasoning shown, and the required graphs are produced with the GeoGebra graphing calculator.

---

## Task 1: Algebraic Operations and Composition of Functions

Given f: ℝ → ℝ and g: ℝ → ℝ defined by **f(x) = 2x + 1** and **g(x) = 3x + 1**.

An algebraic operation combines the outputs of the two functions at the same input, while
composition uses one function's output as the other's input (Abramson, 2023; Stitz & Zeager,
2013). The four required operations are (f/g)(x), (fg)(x), (f ∘ g)(x), and (g ∘ f)(x).

### (i) Performing the operations

**Quotient — (f/g)(x):** divide the rule of f by the rule of g.

  (f/g)(x) = f(x) / g(x) = **(2x + 1) / (3x + 1)**

**Product — (fg)(x):** multiply the two rules using the distributive (FOIL) method.

  (fg)(x) = f(x) · g(x) = (2x + 1)(3x + 1)
  = (2x)(3x) + (2x)(1) + (1)(3x) + (1)(1)
  = 6x² + 2x + 3x + 1 = **6x² + 5x + 1**

**Composition — (f ∘ g)(x) = f(g(x)):** apply g first, then substitute its output into f
wherever x appears.

  f(g(x)) = 2·[g(x)] + 1 = 2(3x + 1) + 1 = 6x + 2 + 1 = **6x + 3**

**Composition — (g ∘ f)(x) = g(f(x)):** apply f first, then substitute into g.

  g(f(x)) = 3·[f(x)] + 1 = 3(2x + 1) + 1 = 6x + 3 + 1 = **6x + 4**

**Verification (numerical check at x = 5):** f(5) = 11 and g(5) = 16.
(f/g)(5) = 11/16 ✓; (fg)(5) = 176 = 6(25)+5(5)+1 ✓; (f∘g)(5) = f(16) = 33 = 6(5)+3 ✓;
(g∘f)(5) = g(11) = 34 = 6(5)+4 ✓.

### (ii) Are fg, f ∘ g, and g ∘ f equal?

**No — all three are different**, for two reasons:

1. **The product is not a composition.** (fg)(x) = 6x² + 5x + 1 is formed by multiplying the
   two outputs, producing a second-degree (quadratic) expression. Composition never multiplies
   outputs; it substitutes one function into the other, so (f ∘ g)(x) = 6x + 3 and
   (g ∘ f)(x) = 6x + 4 both remain first-degree (linear). A quadratic cannot equal a linear
   function, so fg differs from both compositions.

2. **Composition is not commutative.** (f ∘ g)(x) = 6x + 3 while (g ∘ f)(x) = 6x + 4; they
   differ by a constant, so f ∘ g ≠ g ∘ f. The order of composition matters — applying g then
   f is not the same as applying f then g (Abramson, 2023). Therefore **fg ≠ f ∘ g ≠ g ∘ f**.

### (iii) Domain and range of each operation

| Operation | Result | Domain | Range |
|-----------|--------|--------|-------|
| (f/g)(x) | (2x+1)/(3x+1) | x ≠ −1/3, i.e. (−∞, −1/3) ∪ (−1/3, ∞) | y ≠ 2/3, i.e. (−∞, 2/3) ∪ (2/3, ∞) |
| (fg)(x) | 6x² + 5x + 1 | (−∞, ∞) | [−1/24, ∞) |
| (f ∘ g)(x) | 6x + 3 | (−∞, ∞) | (−∞, ∞) |
| (g ∘ f)(x) | 6x + 4 | (−∞, ∞) | (−∞, ∞) |

**Procedure for the domains.**
- **(f/g):** a quotient is undefined where the denominator is zero. Set 3x + 1 = 0 → x = −1/3.
  So the domain excludes −1/3: **(−∞, −1/3) ∪ (−1/3, ∞)**.
- **Product and compositions** are polynomials (no denominator, no radical), so they are
  defined for **all real numbers, (−∞, ∞)**. For a composition, the domain is the set of x
  valid for the inner function whose outputs are valid for the outer; since f and g are each
  defined on all reals, the composition domain is all reals (Abramson, 2023).

**Procedure for the ranges.**
- **(f/g) = (2x+1)/(3x+1):** this is a rational function with a horizontal asymptote. Dividing
  leading coefficients gives y → 2/3 as x → ±∞, and the value 2/3 is never actually reached
  (solving (2x+1)/(3x+1) = 2/3 leads to 3 = 2, a contradiction). So the range is **y ≠ 2/3**,
  i.e. **(−∞, 2/3) ∪ (2/3, ∞)**.
- **6x² + 5x + 1** is an upward-opening parabola; its vertex is the minimum. Vertex x = −b/2a
  = −5/12, minimum value = 6(−5/12)² + 5(−5/12) + 1 = 25/24 − 50/24 + 24/24 = −1/24. Range
  **[−1/24, ∞)**.
- **6x + 3 and 6x + 4** are non-constant lines, taking every real value, so each range is
  **(−∞, ∞)**.

---

## Task 2: Inverse Function — Greenhouse Climate Control

The temperature control function is **T(C) = √[(20C + 15) / (15C + 16)]**, where T is the
greenhouse temperature (°C) and C is the control setting on the DC inverter.

### (i) Finding the control setting C as a function of temperature T

Finding the inverse reverses input and output: it expresses the control setting C in terms of
the resulting temperature T (Abramson, 2023). The steps:

1. Write the relationship:
   T = √[(20C + 15) / (15C + 16)]

2. Square both sides to remove the square root:
   T² = (20C + 15) / (15C + 16)

3. Multiply both sides by (15C + 16) to clear the denominator:
   T²(15C + 16) = 20C + 15
   15T²·C + 16T² = 20C + 15

4. Collect all C-terms on one side and everything else on the other:
   15T²·C − 20C = 15 − 16T²

5. Factor out C:
   C(15T² − 20) = 15 − 16T²

6. Divide to isolate C:
   **C(T) = (15 − 16T²) / (15T² − 20)**

**Verification:** taking a sample setting C = 2 gives T = √[(40+15)/(30+16)] = √(55/46) ≈
1.0935; substituting T² ≈ 1.1957 into C(T) returns (15 − 19.13)/(17.94 − 20) = (−4.13)/(−2.06)
≈ 2.0, recovering the original setting. This confirms the inverse is correct.

### (ii) Practical limitations and considerations

- **Domain and range are physically restricted.** The square root requires the ratio
  (20C + 15)/(15C + 16) to be non-negative, and a real DC inverter has minimum and maximum
  control settings while a greenhouse has a realistic temperature band. The inverse is only
  meaningful over these physical intervals, not over all real numbers.
- **Excluded value from the inverse.** C(T) is undefined when 15T² − 20 = 0, i.e. T = √(4/3)
  ≈ 1.15 °C in the model. Near that value the inverse becomes unstable, so the operating range
  must avoid it.
- **One-to-one requirement.** An inverse function is valid only where T(C) is one-to-one
  (each temperature comes from exactly one setting). Over the physical operating range the
  function is monotonic, so this holds, but outside it the inverse could be ambiguous
  (Abramson, 2023).
- **Real-world factors.** Sensor accuracy, response lag, heat loss through the structure, and
  outdoor weather mean the model is an approximation; the inverse gives a target setting, and
  a feedback loop is still needed to correct drift.

---

## Task 3: Transformations of a Function

The base function is **f(x) = ⁵√x** (the fifth root of x, i.e. x^(1/5)). The four
transformations are:
**⁵√x + 6**, **⁵√x − 6**, **⁵√(50x)**, and **⁵√(x/50)**.

### (i) Graphs

All five functions are plotted together in GeoGebra (see the screenshot below). The base
curve passes through the origin; the transformed curves are shifted or scaled versions of it.

**[ Insert GeoGebra graph of f(x)=⁵√x and its four transformations here ]**

*(GeoGebra input lines: `f(x) = x^(1/5)`, then `f(x) + 6`, `f(x) - 6`, `(50 x)^(1/5)`,
`(x/50)^(1/5)`. Note: the fifth root is defined for negative x as well, so enter it as
`nroot(x, 5)` in GeoGebra if `x^(1/5)` only shows the positive branch.)*

### (ii) Explanation of the four transformations

Using the standard transformation rules (Stitz & Zeager, 2013):

- **⁵√x + 6 (vertical shift up):** adding 6 outside the root raises every point of the base
  graph by 6 units. The whole curve moves **up 6 units**; its shape is unchanged.
- **⁵√x − 6 (vertical shift down):** subtracting 6 outside the root lowers every point by 6
  units, moving the curve **down 6 units** with the same shape.
- **⁵√(50x) (horizontal compression):** multiplying the input x by 50 inside the root
  compresses the graph horizontally toward the y-axis by a factor of 50 (equivalently, it
  rises more steeply). Because 50 = (⁵√50)⁵, this is also a vertical stretch by ⁵√50 ≈ 2.19,
  so the curve climbs faster than the base.
- **⁵√(x/50) (horizontal stretch):** dividing the input by 50 stretches the graph
  horizontally away from the y-axis by a factor of 50, so the curve rises more gradually than
  the base (equivalently a vertical compression by ⁵√(1/50) ≈ 0.46).

### (iii) Domain and range observations

The fifth root is an odd-index radical, so it is defined for **all real numbers** and outputs
**all real numbers**; none of these transformations introduce a restriction.

| Function | Domain | Range |
|----------|--------|-------|
| f(x) = ⁵√x | (−∞, ∞) | (−∞, ∞) |
| ⁵√x + 6 | (−∞, ∞) | (−∞, ∞) |
| ⁵√x − 6 | (−∞, ∞) | (−∞, ∞) |
| ⁵√(50x) | (−∞, ∞) | (−∞, ∞) |
| ⁵√(x/50) | (−∞, ∞) | (−∞, ∞) |

**Observation:** Because the fifth root has domain and range equal to all real numbers,
vertical shifts (± 6) and horizontal scalings (× 50, ÷ 50) do not change the domain or range
— all five functions keep domain (−∞, ∞) and range (−∞, ∞). The transformations change the
graph's position and steepness, but not the set of inputs or outputs. (This contrasts with an
even-index radical such as √x, whose domain and range would be restricted to non-negative
values.)

---

## Task 4: Even/Odd Function Analysis (Alex's Displacement Function)

Alex's displacement function is **g(t) = 10t³ / (12t² + 53)**.

### (i) Even functions and testing g(t)

A function is **even** if g(−t) = g(t) for every t in its domain; graphically, an even
function is symmetric about the **y-axis** (Stitz & Zeager, 2013). (A function is **odd** if
g(−t) = −g(t), which corresponds to symmetry about the **origin**.)

To determine the nature of Alex's function, apply the test by replacing every t with (−t):

1. g(−t) = 10(−t)³ / (12(−t)² + 53)

2. Simplify each power: (−t)³ = −t³ (odd power flips sign) and (−t)² = t² (even power stays
   positive):
   g(−t) = 10(−t³) / (12t² + 53) = **−10t³ / (12t² + 53)**

3. Compare with g(t) = 10t³/(12t² + 53):
   - g(−t) = −10t³/(12t² + 53) = **−g(t)**
   - Since g(−t) = −g(t) (and g(−t) ≠ g(t)), the function is **not even; it is ODD**.

So, to answer Alex directly: the algebraic test shows the displacement function is **not an
even function**. It is an **odd** function, because the numerator 10t³ is an odd-power term
and the denominator 12t² + 53 is even, and (odd)/(even) = odd. A numerical check confirms
this: g(1) = 10/65 ≈ 0.154 while g(−1) = −10/65 ≈ −0.154 = −g(1).

### (ii) Interpreting the graph

The provided graph passes through the **origin (0, 0)** and rises from the lower-left through
the origin to the upper-right, with the left portion below the x-axis and the right portion
above it. Testing for symmetry:

- It is **not symmetric about the y-axis**, so it is **not even** — the left half is not a
  mirror image of the right half.
- It **is symmetric about the origin**: rotating the graph 180° about the origin produces the
  same curve. Equivalently, for each point (t, g(t)) on the graph, the point (−t, −g(t)) is
  also on it (for example, (1, 0.15) and (−1, −0.15)).

This origin symmetry is the graphical signature of an **odd function**, which matches the
algebraic result g(−t) = −g(t). Therefore the graph possesses **odd symmetry**, not even
symmetry.

---

## References

Abramson, J. (2023). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e

Khan Academy. (2013, June 3). *Recognizing features of functions (example 2)* [Video]. YouTube.
https://www.youtube.com/

Mathisfun. (n.d.). *Operations with functions*.
https://www.mathsisfun.com/sets/functions-operations.html

Stitz, C., & Zeager, J. (2013). *College algebra*. Stitz Zeager Open Source Mathematics.
https://www.stitz-zeager.com/szca07042013.pdf
