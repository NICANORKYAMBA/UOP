# Unit 4 Learning Notes: Higher-Order Polynomials and Rational Functions

Course: MATH 1201 College Algebra
Reading: Abramson (2023), *Algebra and Trigonometry 2e*, Sections 5.2 to 5.6; Stitz & Zeager
(2013), p. 238 (open box example)
Videos: Mathispower4u (end behavior, turning points, synthetic division, zeros, asymptotes)

Due this week (September 30, 2026): Assignment Activity (5 tasks) and Self-Quiz. No discussion
forum this unit.

---

## 1. Polynomial basics (5.2)

f(x) = a_n x^n + ... + a_1 x + a_0

- **Degree** = highest power n. **Leading term** = a_n x^n. **Leading coefficient** = a_n.
- A power function is f(x) = k x^p.

## 2. End behavior (only the leading term matters)

| Degree | Leading coefficient | Left end | Right end |
|---|---|---|---|
| Even | Positive | up | up |
| Even | Negative | down | down |
| Odd | Positive | down | up |
| Odd | Negative | up | down |

## 3. Graphs of polynomials (5.3)

- A polynomial of degree n has **at most n real zeros** and **at most n - 1 turning points**.
- If you see t turning points, the degree is **at least t + 1**.
- **Multiplicity** of a zero (how many times its factor repeats):
  - odd (1, 3, ...): graph **crosses** the x-axis (multiplicity 3 flattens as it crosses)
  - even (2, 4, ...): graph **touches and bounces** off the x-axis
- Polynomials are smooth and continuous: no breaks, holes or sharp corners.
- Local max/min = the turning points (peaks and valleys).

## 4. Dividing polynomials (5.4)

- **Remainder Theorem:** the remainder of f(x) / (x - c) is **f(c)**.
- **Factor Theorem:** (x - c) is a factor exactly when f(c) = 0.
- **Synthetic division by (x - c):** write the coefficients, bring down the first, multiply by c,
  add to the next column, repeat. The last number is the remainder.

## 5. Zeros (5.5)

**Rational Zero Theorem:** any rational zero is p/q, where p divides the constant term and q
divides the leading coefficient. Test candidates with synthetic division; each zero you find
lowers the degree by one. When you reach a quadratic, use the quadratic formula.

## 6. Rational functions (5.6)

f(x) = P(x) / Q(x)

- **Domain:** all real x except where Q(x) = 0.
- **Simplify first.** A factor that cancels from top and bottom gives a **hole**, not an
  asymptote.
- **Vertical asymptotes:** zeros of the denominator left after cancelling.
- **Zeros (x-intercepts):** zeros of the numerator left after cancelling.
- **y-intercept:** f(0), if 0 is in the domain.
- **Horizontal asymptote** (compare degrees, n = top, m = bottom):
  - n < m: y = 0
  - n = m: y = (leading coefficient of top) / (leading coefficient of bottom)
  - n = m + 1: no horizontal asymptote, but a **slant (oblique) asymptote**, found by long
    division (ignore the remainder)
  - n > m + 1: no horizontal or slant asymptote

---

## Self-Quiz answers

| # | Question | Answer | Why |
|---|---|---|---|
| 1 | Degree, leading coefficient, leading term of -2x^10 - 25x^4 + 30x^3 - 20x + 5 | **10, -2, -2x^10** | Highest power is 10 |
| 2 | Zeros of 6x^3 + 2x^2 - 4x | **0, 2/3, -1** | 2x(3x^2 + x - 2) = 2x(3x - 2)(x + 1) |
| 3 | Graph: both ends go down | **Negative leading coefficient and even degree polynomial** | Both ends point the same way (even), downward (negative) |
| 4 | Vertical asymptotes of (x - 1)/(x^2 + 4x + 3) | **x = -3, x = -1** | x^2 + 4x + 3 = (x + 1)(x + 3); nothing cancels |
| 5 | Vertical asymptotes of (x - 5)/(x^4 + 2x^3 + x^2) | **x = 0, x = -1** | x^2(x^2 + 2x + 1) = x^2(x + 1)^2 |

## References

Abramson, J. (2023). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e

Stitz, C., & Zeager, J. (2013). *College algebra*. Stitz Zeager Open Source Mathematics.
https://stitz-zeager.com/szca07042013.pdf
