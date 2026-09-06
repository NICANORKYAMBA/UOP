# Written Assignment Unit 1: Functions — I

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Kyamba

---

## Task 1: Interpreting the Graph (Domain, Range, and One-to-One)

> This task refers to the "Domain and Range" graph provided in the assignment. Read the
> exact endpoints from that graph and substitute them into the method below. The reasoning
> and format are complete; only the specific numeric endpoints come from your image.

**(i) Domain and Range.**
- The **domain** is the set of all x-values (horizontal extent) the graph covers. Read the
  leftmost and rightmost x-values. Use a **square bracket [ ]** if the endpoint is included
  (solid dot) and a **parenthesis ( )** if it is excluded (open dot).
  Example format: Domain = [x_min, x_max].
- The **range** is the set of all y-values (vertical extent). Read the lowest and highest
  y-values the graph reaches, using the same bracket rules.
  Example format: Range = [y_min, y_max].

**(ii) Is it a function? Is it one-to-one?**
- **Function test (Vertical Line Test):** if every vertical line crosses the graph at most
  once, it is a function, because each input x maps to exactly one output y (Abramson,
  2023). If any vertical line hits the curve twice, it is **not** a function.
- **One-to-one test (Horizontal Line Test):** if every horizontal line crosses the graph at
  most once, the function is one-to-one, meaning each output y comes from exactly one input
  x. If any horizontal line hits it twice (as with a parabola), it is a function but **not**
  one-to-one (Abramson, 2023).
- State your conclusion clearly, e.g., "The graph passes the vertical line test, so it is a
  function; it fails/passes the horizontal line test, so it is/ is not one-to-one," with the
  specific justification based on the shape in your graph.

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

- **On f (parabola), choose two points C and D** from the graph (not O or A). Example: if
  C = (1, 1) and D = (3, 9) on f(x) = x², then slope(CD) = (9 − 1)/(3 − 1) = 8/2 = **4**.
- **On g (line), choose two points E and F** from the graph (not O or A). Example: if
  E = (1, 5) and F = (3, 15) on g(x) = 5x, then slope(EF) = (15 − 5)/(3 − 1) = 10/2 = **5**.

**Insight:** the slope of EF (the line) equals the line's constant rate of change, so any
two points give the same slope (5). The slope of CD (the parabola) is an **average** rate of
change that changes depending on which two points you pick, confirming the parabola's rate
of change is not constant. In context, animal g gains weight at a fixed rate per foot, while
animal f gains weight increasingly quickly as its length grows.

> Replace the example points with the actual C, D, E, F you read from your graph, and keep
> the same calculation format.

---

## Task 4: Local Extrema and Behavior of the Function

> This task refers to the extrema graph provided. Read the turning points and interval
> endpoints from that graph and substitute them into the method below.

**Local extrema vs. absolute (maximum/minimum) values.**
- A **local maximum** is a point where the function value is higher than at all nearby
  points — the graph rises to it, then falls (a "peak"). A **local minimum** is where the
  value is lower than nearby points — the graph falls to it, then rises (a "valley")
  (Abramson, 2023).
- These differ from the **absolute (global) maximum/minimum**, which are the single highest
  and lowest values over the **entire** domain. A local extremum is only "the best in its
  neighborhood," while an absolute extremum is "the best overall." A graph can have several
  local extrema but at most one absolute max and one absolute min.

**Intervals of increase and decrease.**
Read the x-coordinates of the turning points from your graph and list the intervals between
them, labeling each:
- The function is **increasing** on an interval if the graph goes up from left to right
  there (positive slope).
- The function is **decreasing** if the graph goes down from left to right (negative slope).
- Format each interval by its endpoints, e.g., "increasing on (A, B), decreasing on (B, C)."
  A local maximum occurs where the graph changes from increasing to decreasing; a local
  minimum where it changes from decreasing to increasing.

State each local extremum with its approximate coordinates and each interval with its
increasing/decreasing label, exactly as your graph shows.

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
