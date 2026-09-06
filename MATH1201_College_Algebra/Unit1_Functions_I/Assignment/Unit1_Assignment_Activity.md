# Written Assignment Unit 1: Functions — I

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Kyamba

---

## Task 1: Interpreting the Graph (Domain, Range, and One-to-One)

The given graph is a smooth curve that rises from the bottom of the plane on the left, peaks
near the point (0, 5), dips to a small valley near (2, 3), and then rises steeply upward off
the top of the plane on the right. The arrows on both ends indicate the curve continues
without bound.

**(i) Domain and Range.**
- **Domain:** the curve extends left and right without end (the ends carry arrows), so every
  x-value is covered. The domain is **all real numbers, (−∞, ∞)**.
- **Range:** the curve falls to negative infinity on the lower left and rises to positive
  infinity on the upper right, passing through every height in between (the small peak and
  valley do not create any gap). The range is therefore **all real numbers, (−∞, ∞)**.

**(ii) Is it a function? Is it one-to-one?**
- **Function (Vertical Line Test):** any vertical line drawn through the graph touches the
  curve exactly once, so each input x maps to exactly one output y. Therefore the graph
  **is a function** (Abramson, 2023).
- **One-to-one (Horizontal Line Test):** because the curve rises, then falls slightly
  (between the peak near (0, 5) and the valley near (2, 3)), then rises again, a horizontal
  line drawn through that middle region — for example y = 4 — crosses the curve **three
  times**. Since at least one horizontal line meets the graph more than once, the function
  **is not one-to-one** (Abramson, 2023). In other words, different inputs can produce the
  same output, so the function has no inverse over its full domain.

---

## Task 2: Avocado Export Function E(P) = P − 10000, P ≥ 10000

**(i) Graph of E(P).**
Plot E(P) = P − 10000 in GeoGebra using a scale where 1 unit = 1000 on both axes. This is a
straight line with slope 1 and E-intercept at −10000; because P ≥ 10000, the graph is the
ray starting at the point (10000, 0) and rising to the right.
*(Insert your GeoGebra screenshot below.)*

**[ Insert GeoGebra graph of E(P) here ]**

**(ii) Is E(P) a function of P?**
Yes. For every production value P there is exactly one export value E(P) = P − 10000. The
straight-line graph passes the vertical line test, so E is a function of P (Abramson, 2023).

**(iii) Domain and Range.**
- **Domain:** the problem states P ≥ 10000, so the domain is **[10000, ∞)**.
- **Range:** when P = 10000, E = 0; as P increases, E increases without bound. So the range
  is **[0, ∞)**.

**(iv) Export for 70 and 20 thousand of production.**
Since values are in thousands, P = 70 thousand = 70000 and P = 20 thousand = 20000:
- E(70000) = 70000 − 10000 = **60000** (i.e., 60 thousand units exported).
- E(20000) = 20000 − 10000 = **10000** (i.e., 10 thousand units exported).

**(v) Dependent and independent variables.**
- **Independent variable:** P, the production, because we choose it freely.
- **Dependent variable:** E, the export, because its value depends on P.

---

## Task 3: Rate of Change — Weights and Lengths of Two Animals

The graph shows a parabola (f) and a straight line (g) intersecting at **A(5, 25)**, with x
= length (feet) and y = weight (tons).

> Note on identifying the two curves from the given point: a straight line through the
> origin and A(5, 25) has equation **g(x) = 5x** (since 25 ÷ 5 = 5). A parabola through the
> origin and A(5, 25) is **f(x) = x²** (since 5² = 25). Read your own C, D, E, F points from
> the graph; the method below applies to whatever points you select.

**(i) Rate of change at the intersection.**
The rate of change of weight with respect to length is the slope, slope = Δy / Δx = (change
in weight) / (change in length). For the **line g**, the rate of change is **constant** at
5 tons per foot everywhere, including at A. For the **parabola f**, the rate of change is
**not constant** — it increases as length increases. Conclusion: the line represents an
animal whose weight grows at a steady rate per foot, while the parabola represents an animal
whose weight grows faster and faster as it gets longer.

**(ii) Slopes of CD (on f) and EF (on g).**
Use the slope formula between two points (x₁, y₁) and (x₂, y₂):

  slope = (y₂ − y₁) / (x₂ − x₁)

- **On f (the parabola f(x) = x²), pick C = (2, 4) and D = (4, 16)** (both lie on the
  curve, and neither is O or A):
  slope(CD) = (16 − 4) / (4 − 2) = 12 / 2 = **6**.
- **On g (the line g(x) = 5x), pick E = (1, 5) and F = (3, 15)** (both on the line, neither
  O nor A):
  slope(EF) = (15 − 5) / (3 − 1) = 10 / 2 = **5**.

**Insight:** the slope of EF is **5**, which equals the line's constant rate of change — any
two points on g give the same slope, so animal g gains weight at a steady 5 tons per foot.
The slope of CD is **6**, but this is only the **average** rate of change between x = 2 and
x = 4; choosing different points on the parabola gives a different slope (for example,
between x = 1 and x = 3 it would be 4). This confirms the parabola's rate of change is not
constant — animal f gains weight increasingly quickly as its length grows, so its weight
rises much faster than g's for larger lengths.

---

## Task 4: Local Extrema and Behavior of the Function

The graph is a smooth, repeating wave (a cosine-type curve) that oscillates between a
height of y = 1 at its peaks and y = −1 at its valleys. The labeled points are:
A(−11, 1), B(−8, −1), C(−5, 1), D(−2, −1), E(1.57, 1), F(4.71, −1), G(7.85, 1), H(11, −1).

**Local extrema vs. absolute (maximum/minimum) values.**
- A **local maximum** is a point higher than all nearby points — the graph rises to it,
  then falls (a "peak"). Here the peaks are A, C, E, and G, each at height **y = 1**.
- A **local minimum** is a point lower than all nearby points — the graph falls to it, then
  rises (a "valley"). Here the valleys are B, D, F, and H, each at height **y = −1**
  (Abramson, 2023).
- These differ from the **absolute (global) maximum and minimum**, which are the single
  highest and lowest values over the **entire** domain. Because this curve repeats forever,
  every peak reaches the same height (1) and every valley the same depth (−1). So each peak
  is a local maximum *and* ties for the absolute maximum (1), and each valley is a local
  minimum *and* ties for the absolute minimum (−1). The key distinction: a local extremum
  only has to be the highest/lowest *in its immediate neighborhood*, whereas an absolute
  extremum is the highest/lowest *over the whole graph*. A repeating function like this one
  has infinitely many local extrema.

**Intervals of increase and decrease.**
Between a valley and the next peak the graph rises (increasing); between a peak and the next
valley it falls (decreasing). Reading left to right across the labeled points:

- Increasing on **(B, C)** = (−8, −5): rising from the valley at B up to the peak at C.
- Decreasing on **(C, D)** = (−5, −2): falling from the peak at C down to the valley at D.
- Increasing on **(D, E)** = (−2, 1.57): rising from D up to the peak at E.
- Decreasing on **(E, F)** = (1.57, 4.71): falling from E down to the valley at F.
- Increasing on **(F, G)** = (4.71, 7.85): rising from F up to the peak at G.
- Decreasing on **(G, H)** = (7.85, 11): falling from G down to the valley at H.

At every peak (A, C, E, G) the graph changes from increasing to decreasing, confirming a
local maximum; at every valley (B, D, F, H) it changes from decreasing to increasing,
confirming a local minimum. The pattern continues indefinitely in both directions because
the function is periodic.

---

## Task 5: Piecewise Tax Function for Country W

**(i) The tax rule as a piecewise function.**
Let x be an individual's income and T(x) the tax owed. Following the three slabs:

```
         ⎧ 0.10x,                                  0 ≤ x ≤ 2200
T(x) =   ⎨ 220 + 0.185(x − 2200),               2200 < x ≤ 8945
         ⎩ 1467.825 + 0.30(x − 8945),               x > 8945
```

Explanation of the constants:
- For 2200 < x ≤ 8945: the first $2200 is taxed at 10% (= $220), and the amount above 2200
  is taxed at 18.5%.
- For x > 8945: the first $2200 gives $220, the band from 2200 to 8945 (a width of $6745)
  is taxed at 18.5% (= $1,247.825), so the fixed part is 220 + 1247.825 = **$1,467.825**,
  plus 30% of income above 8945.

**(ii) Sample tax in each slab.**

- **Slab a — income $2,000 (≤ 2200):**
  T = 0.10 × 2000 = **$200.00**

- **Slab b — income $5,000 (2200 < x ≤ 8945):**
  T = 220 + 0.185 × (5000 − 2200) = 220 + 0.185 × 2800 = 220 + 518 = **$738.00**

- **Slab c — income $10,000 (> 8945):**
  T = 1467.825 + 0.30 × (10000 − 8945) = 1467.825 + 0.30 × 1055 = 1467.825 + 316.5
  = **$1,784.325 ≈ $1,784.33**

Each result uses only the income within each rate band, which is exactly how a progressive
piecewise tax is applied (Stitz & Zeager, 2013).

---

## References

Abramson, J. (2023). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e

GeoGebra. (n.d.). *GeoGebra graphing calculator*. https://www.geogebra.org/calculator

Stitz, C., & Zeager, J. (2013). *College algebra*. Stitz Zeager Open Source Mathematics.
https://stitz-zeager.com/szca07042013.pdf

Yoshiwara, K. (2020). *Modeling, functions, and graphs*. American Institute of Mathematics.
https://yoshiwarabooks.org/mfg/colophon-1.html
