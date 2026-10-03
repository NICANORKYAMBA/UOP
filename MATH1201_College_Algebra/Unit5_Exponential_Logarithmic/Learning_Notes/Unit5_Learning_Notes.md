# Unit 5 Learning Notes: Exponential and Logarithmic Functions

Course: MATH 1201 College Algebra
Reading: Abramson (2023), *Algebra and Trigonometry 2e*, Sections 6.1 to 6.7; Yoshiwara (2020),
*Modeling, Functions, and Graphs*, Sections 4.1 and 4.4
Videos: Mathispower4u (population growth, compound interest, intro to logs, log properties, pH)

Due October 7, 2026: Discussion (150 to 250 words; post by **Sunday Oct 4**, 2 replies by
**Wednesday Oct 7**), Assignment Activity (3 tasks), Self-Quiz.

---

## 1. Exponential functions

f(x) = a · bˣ, b > 0, b ≠ 1

- **a** = initial value (f(0) = a). **b** = growth factor (b > 1 grows, 0 < b < 1 decays).
- Growth rate r: b = 1 + r (2% growth: b = 1.02). Decay: b = 1 - r.
- Domain (-∞, ∞), range (0, ∞) when a > 0, horizontal asymptote **y = 0**, y-intercept (0, a).
- Test for exponential data: **constant ratio** between equal x steps (linear = constant
  difference).
- Natural base **e ≈ 2.71828**. Continuous growth: A = Pe^(rt).
- Compound interest: A = P(1 + r/n)^(nt).

**Transformations of bˣ**
- a · bˣ: vertical **stretch** if |a| > 1, compression if |a| < 1.
- b^(-x): reflection about the **y-axis**. -bˣ: reflection about the x-axis.
- bˣ + k: shifts up k (asymptote becomes y = k). b^(x - h): shifts right h.

## 2. Logarithmic functions

y = log_b(x) **means** bʸ = x.

- Inverse of bˣ. Domain (0, ∞), range (-∞, ∞), vertical asymptote **x = 0**, x-intercept (1, 0).
- Common log: log(x) = log₁₀(x). Natural log: ln(x) = log_e(x).
- Domain rule: the inside of the log must be **> 0**.

## 3. Properties of logarithms

| Rule | Formula |
|---|---|
| Product | log_b(MN) = log_b M + log_b N |
| Quotient | log_b(M/N) = log_b M - log_b N |
| Power | log_b(Mᵏ) = k log_b M |
| Inverse | log_b(bᵏ) = k and b^(log_b x) = x |
| Change of base | log_b x = ln x / ln b |

## 4. Solving equations

- **Exponential:** isolate the power, take ln (or log) of both sides, use the power rule.
- **Logarithmic:** combine logs into one, rewrite in exponential form, check the answer is in
  the domain.

## 5. Applications of logs

Richter scale M = log(x / 0.001): each +1 = 10 times the amplitude. pH = -log[H⁺]. Decibels.

---

## Self-Quiz answers

| # | Question | Answer |
|---|---|---|
| 1 | 2(7ˣ) compared with 7ˣ | **Stretches vertically** |
| 2 | Domain, range, asymptote of 23ˣ | **(-∞, ∞), (0, ∞), horizontal asymptote y = 0** |
| 3 | True about e^(-x) | **The graph approaches zero but never reaches it** |
| 4 | 9ˣ as x → -∞ | **Approaches zero as x approaches -∞** |
| 5 | Reflection of 5ˣ about the y-axis | **(-∞, ∞), (0, ∞), "vertical asymptote y = 0"** (the quiz mislabels it; y = 0 is really a horizontal asymptote, but this is the only option with the right domain and range) |

## References

Abramson, J. (2023). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e

Yoshiwara, K. (2020). *Modeling, functions, and graphs*. American Institute of Mathematics.
https://yoshiwarabooks.org/mfg/frontmatter.html
