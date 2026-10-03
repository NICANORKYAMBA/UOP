# Written Assignment Unit 5: Exponential and Logarithmic Functions

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Maswili
**Instructor:** Chibuike Agu
**Due:** October 7, 2026

This assignment explores exponential and logarithmic functions in three tasks: explaining what
they are and how they differ from power functions, proving and solving equations with the
properties of logarithms, and modeling the growth of cancer cells with an exponential function.
Every step is shown, and the graphs were drawn in GeoGebra.

## Task 1: Exponential and Logarithmic Functions

### (i) Definitions, Relationship, Key Factors, Domain and Range

**Exponential function.** An exponential function has the form

f(x) = a · bˣ, with a ≠ 0, b > 0 and b ≠ 1.

- **x** is the input, and it appears in the **exponent**.
- **b** is the **base** (the growth or decay factor). If b > 1 the function grows, and if
  0 < b < 1 it decays. The base cannot be 1, because 1ˣ = 1 is just a constant.
- **a** is the **initial value**, the output when x = 0, since a · b⁰ = a (Abramson, 2023,
  Section 6.1).

**Logarithmic function.** A logarithmic function has the form

g(x) = log_b(x), with b > 0 and b ≠ 1,

and y = log_b(x) means exactly the same as bʸ = x (Abramson, 2023, Section 6.3). The logarithm
answers the question "what power of b gives x?" For example, log₂(8) = 3 because 2³ = 8. Here
**b** is again the base and **x** is the input, which must be positive.

**How they are related.** The two functions are **inverses**. The exponential function takes an
exponent and returns a power, and the logarithm takes the power back to the exponent:
log_b(bˣ) = x and b^(log_b x) = x. Graphically, the graph of y = log_b(x) is the reflection of
y = bˣ across the line y = x (Figure 2).

**Domain and range.** Because they are inverses, the domain of one is the range of the other.

| | Exponential f(x) = bˣ | Logarithmic g(x) = log_b(x) |
|---|---|---|
| Domain | all real numbers, (-∞, ∞) | positive numbers only, (0, ∞) |
| Range | positive numbers only, (0, ∞) | all real numbers, (-∞, ∞) |
| Asymptote | horizontal, y = 0 | vertical, x = 0 |
| Key point | y-intercept (0, 1) | x-intercept (1, 0) |

### (ii) Exponential, Logarithmic, and Power Functions Compared

The difference is **where the variable sits**:

- **Exponential:** the variable is the exponent and the base is fixed. Example: **f(x) = 2ˣ**.
- **Logarithmic:** the variable is inside a logarithm. Example: **g(x) = log₂(x)**.
- **Power:** the variable is the base and the exponent is fixed. Example: **h(x) = x²**.

| Feature | f(x) = 2ˣ | g(x) = log₂(x) | h(x) = x² |
|---|---|---|---|
| Domain | (-∞, ∞) | (0, ∞) | (-∞, ∞) |
| Range | (0, ∞) | (-∞, ∞) | [0, ∞) |
| Asymptote | y = 0 (horizontal) | x = 0 (vertical) | none |
| Intercepts | y-intercept (0, 1) | x-intercept (1, 0) | (0, 0) |
| Zeros | none | x = 1 | x = 0 |
| Growth pattern | multiplies by 2 for every step of 1 | adds 1 every time x doubles | grows like the square of x |

**Figure 1**

*Graphs of f(x) = 2ˣ, g(x) = log₂(x), and h(x) = x² in GeoGebra*

[FIGURE figures/fig1_compare.png]

### (iii) How to Tell if a Function Has Exponential Growth

A function shows exponential growth when **equal steps in x multiply the output by the same
factor**, rather than adding the same amount (Yoshiwara, 2020, Section 4.1). There are three
practical tests:

1. **The formula** has the form f(x) = a · bˣ with a > 0 and b > 1.
2. **A table of values** has a constant **ratio** between consecutive outputs. For 2ˣ:
   1, 2, 4, 8, 16, and each value divided by the one before is always 2. A linear function would
   instead have a constant difference.
3. **The graph** rises slowly at first and then more and more steeply, with a horizontal
   asymptote on the left side.

The cancer-cell model in Task 3 passes the ratio test, with a constant ratio of 1.02.

### (iv) Which Grows Faster?

**Exponential functions grow much faster than logarithmic functions.** In fact, they are opposites:
an exponential function's growth speeds up, while a logarithm's growth slows down. The reason is
in their definitions. 2ˣ **doubles** every time x increases by 1, so its increase keeps getting
bigger. log₂(x) only increases by 1 when x **doubles**, so it needs larger and larger jumps in x to
climb.

| x | 2ˣ | log₂(x) |
|---|---|---|
| 1 | 2 | 0 |
| 4 | 16 | 2 |
| 10 | 1,024 | about 3.32 |
| 16 | 65,536 | 4 |

At x = 16, the exponential is already 65,536, while the logarithm has only reached 4. Exponential
functions even overtake every power function eventually: 2ˣ and x² cross at x = 2 and x = 4, and
after x = 4, 2ˣ stays ahead forever (Abramson, 2023, Section 6.2).

### (v) Observations From the Graphs

From Figure 1 and Figure 2:

1. **y = 2ˣ** stays above the x-axis, crosses the y-axis at (0, 1), approaches the asymptote
   y = 0 on the left without ever touching it, and rises more and more steeply on the right. It
   has no zeros.
2. **y = log₂(x)** exists only for x > 0. It falls toward -∞ near the vertical asymptote x = 0,
   crosses the x-axis at its zero (1, 0), and keeps rising, but more and more slowly.
3. **y = x²** is a parabola with its lowest point at (0, 0). It is symmetric about the y-axis and
   has no asymptotes.
4. **2ˣ and x²** cross three times, marked A, B, and C in Figure 1: A ≈ (-0.77, 0.59), B = (2, 4),
   and C = (4, 16). Between 2 and 4 the
   parabola is higher, but after x = 4 the exponential pulls ahead and the gap widens quickly.
5. **2ˣ and log₂(x)** are mirror images across the dashed line y = x (Figure 2), which shows that
   they are inverse functions. The point (0, 1) on 2ˣ matches the point (1, 0) on log₂(x), and
   the horizontal asymptote y = 0 becomes the vertical asymptote x = 0.

**Figure 2**

*f(x) = 2ˣ and g(x) = log₂(x) Reflected Across the Line y = x*

[FIGURE figures/fig2_inverse.png]

## Task 2: Logarithmic Properties

The properties used below are (Yoshiwara, 2020, Section 4.4; Abramson, 2023, Section 6.5):

| Name | Property |
|---|---|
| Quotient rule | log_b(M/N) = log_b(M) - log_b(N) |
| Product rule | log_b(MN) = log_b(M) + log_b(N) |
| Power rule | log_b(Mᵏ) = k · log_b(M) |
| Inverse property | log_b(bᵏ) = k |

### (i) Prove that log₆(216ˣ / 1296ˣ) = -x

```
log₆(216ˣ / 1296ˣ)
  = log₆(216ˣ) - log₆(1296ˣ)        Quotient rule
  = x · log₆(216) - x · log₆(1296)   Power rule
  = x · log₆(6³) - x · log₆(6⁴)      since 216 = 6³ and 1296 = 6⁴
  = x · 3 - x · 4                    Inverse property: log₆(6ᵏ) = k
  = 3x - 4x
  = -x                               as required
```

**Check with a value.** For x = 1: log₆(216/1296) = log₆(1/6) = -1, which equals -x, as expected.

### (ii) Prove the logarithmic identity

Prove that

log(x+1)² + log(2x-1)³ - log(x)² - log(2x-1)⁴ + 6log(x+1) = log[(x+1)⁸ / (x²(2x-1))]

for x > 1/2, where every logarithm is defined.

```
Left side
  = 2log(x+1) + 3log(2x-1) - 2log(x) - 4log(2x-1) + 6log(x+1)     Power rule on each term
  = [2log(x+1) + 6log(x+1)] + [3log(2x-1) - 4log(2x-1)] - 2log(x) Group like terms
  = 8log(x+1) - 1·log(2x-1) - 2log(x)                             Combine coefficients
  = log(x+1)⁸ - log(2x-1) - log(x²)                               Power rule (reverse)
  = log(x+1)⁸ - [log(x²) + log(2x-1)]                             Factor out the minus sign
  = log(x+1)⁸ - log[x²(2x-1)]                                     Product rule
  = log[(x+1)⁸ / (x²(2x-1))]                                      Quotient rule
  = Right side                                                    as required
```

### (iii) Solve 10e^(2x-3) = 15e^(5x-7)

```
10e^(2x-3) = 15e^(5x-7)
e^(2x-3) / e^(5x-7) = 15/10            Divide both sides by 10e^(5x-7)
e^((2x-3) - (5x-7)) = 1.5              Quotient rule for exponents: eᵐ / eⁿ = e^(m-n)
e^(-3x + 4) = 1.5                      Simplify the exponent
ln(e^(-3x + 4)) = ln(1.5)              Take the natural log of both sides
-3x + 4 = ln(1.5)                      Inverse property: ln(eᵏ) = k
-3x = ln(1.5) - 4
x = (4 - ln 1.5) / 3                   Exact answer
x ≈ (4 - 0.405465) / 3 ≈ 1.1982        Approximate answer
```

**Check.** Left side: 10e^(2(1.1982) - 3) ≈ 10e^(-0.6036) ≈ 5.468.
Right side: 15e^(5(1.1982) - 7) ≈ 15e^(-1.0090) ≈ 5.468. Both sides agree, so the solution is correct.

## Task 3: Exponential Growth of Cancer Cells

### (i) Table of Yearly Values, 2018 to 2023

The cells grow by 2% per year, so each year's amount is the previous year's amount multiplied by
1 + 0.02 = 1.02 (Yoshiwara, 2020, Section 4.1).

| Year | t (years after 2018) | Calculation | Cancer cells (units) |
|---|---|---|---|
| 2018 | 0 | 232.26 | 232.26 |
| 2019 | 1 | 232.26 × 1.02 | 236.91 |
| 2020 | 2 | 236.91 × 1.02 | 241.64 |
| 2021 | 3 | 241.64 × 1.02 | 246.48 |
| 2022 | 4 | 246.48 × 1.02 | 251.41 |
| 2023 | 5 | 251.41 × 1.02 | 256.43 |

### (ii) The Function That Fits the Table

The yearly increase is not constant (4.65, then 4.73, then 4.84, and so on), so the growth is not
linear. But the **ratio** between consecutive years is always the same:

236.91 / 232.26 = 241.64 / 236.91 = ... = 1.02

A constant ratio is the mark of an **exponential function** (Abramson, 2023, Section 6.1). The
model is

**P(t) = 232.26 · (1.02)ᵗ**

with these key factors:

| Factor | Value | Meaning |
|---|---|---|
| t | years since 2018 | the input (time) |
| a (initial value) | 232.26 | units of cancer cells in 2018 |
| r (growth rate) | 0.02, or 2% | the percentage increase each year |
| b (growth factor) | 1 + r = 1.02 | the yearly multiplier; b > 1 means growth |
| P(t) | output | units of cancer cells after t years |

### (iii) Projection for 10 Years

Ten years after the start of the study (2018 + 10 = 2028), t = 10:

```
P(10) = 232.26 · (1.02)¹⁰
      = 232.26 · 1.218994
      ≈ 283.12 units
```

So, if the 2% rate continues, the animal will have about **283.12 units** of cancer cells in 2028,
an increase of about 21.9% over 2018. Even though 2% per year sounds small, compounding adds a
larger amount each year. If "10 years" is counted from the end of the table instead (2033, t = 15),
the model gives P(15) = 232.26 · (1.02)¹⁵ ≈ **312.59 units**.

### (iv) Graph of the Growth Pattern

Figure 3 shows P(t) = 232.26 · (1.02)ᵗ drawn in GeoGebra with a scale of 100 units on both axes,
together with the table points from 2018 to 2023 and the projection for t = 10.

**Figure 3**

*Growth of Cancer Cells, P(t) = 232.26(1.02)ᵗ, With 100-Unit Scale on Both Axes*

[FIGURE figures/fig3_growth.png]

**Observations.** The curve starts at (0, 232.26) and rises the whole way, never falling. Over
these few years it looks almost straight, because 2% growth is gentle, but it bends slightly
upward, and over a longer time, such as 100 years (where P(100) ≈ 1,683 units), the exponential
upward curve becomes obvious. The graph has a horizontal asymptote at y = 0 on the left, as every
exponential growth function does.

## Conclusion

Exponential and logarithmic functions are inverses: one turns exponents into powers and the
other turns powers back into exponents. That relationship explains their mirrored graphs, their
swapped domains and ranges, and why logarithms are the right tool for solving exponential
equations. The properties of logarithms made the proofs in Task 2 short and clear, and the cancer
model in Task 3 showed how a constant percentage rate produces exponential growth that speeds up
over time.

## References

Abramson, J. (2023). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e

Yoshiwara, K. (2020). *Modeling, functions, and graphs*. American Institute of Mathematics.
https://yoshiwarabooks.org/mfg/frontmatter.html
