# MATH 1201 Unit 2 — How to Actually Solve Each Task

A complete, worked guide for every task type in this assignment. Each section shows the
method, then a full worked example you can copy the structure of, then exactly what to write.

---

## TASK 1 — Operations & Composition of Functions  (ALREADY DONE, shown here as reference)

**Given:** f(x) = 2x + 1, g(x) = 3x + 1

**How to do each operation:**

- **Sum (f+g)(x):** add the rules, combine like terms.
  (2x+1) + (3x+1) = 5x + 2
- **Product (fg)(x):** multiply with FOIL.
  (2x+1)(3x+1) = 6x² + 2x + 3x + 1 = 6x² + 5x + 1
- **Composition (f∘g)(x) = f(g(x)):** put g inside f.
  f(3x+1) = 2(3x+1) + 1 = 6x + 3
- **Composition (g∘f)(x) = g(f(x)):** put f inside g.
  g(2x+1) = 3(2x+1) + 1 = 6x + 4

**Are they equal?** No. The product is quadratic; the compositions are linear and differ
(6x+3 vs 6x+4), so composition is not commutative.

**Domain & range:** polynomials → domain all reals (−∞,∞). Lines → range (−∞,∞). The
parabola 6x²+5x+1 opens up; vertex at x = −b/2a = −5/12, min = −1/24 → range [−1/24, ∞).

---

## TASK 2 — Inverse Function (greenhouse)

**Goal:** given T = T(C), solve for C in terms of T. That gives the inverse C(T).

**METHOD (4 steps):**
1. Write the equation: T = (the given formula in C).
2. Get the C-term alone: move constants to the other side.
3. Divide/undo to isolate C.
4. Write the answer as C(T) = ... and (optional) verify.

**WORKED EXAMPLE** — suppose the given function is **T(C) = 2C + 15**:
1. T = 2C + 15
2. T − 15 = 2C          (subtract 15 from both sides)
3. C = (T − 15) / 2      (divide both sides by 2)
4. **C(T) = (T − 15)/2**  ← the inverse

*Verify:* put C back into T: T((T−15)/2) = 2·((T−15)/2) + 15 = (T−15) + 15 = T ✓

**If the function has a fraction or different coefficient**, same idea. Example
**T(C) = C/4 + 10**:
- T − 10 = C/4  →  C = 4(T − 10)  →  **C(T) = 4(T − 10) = 4T − 40**

**Part (ii) — limitations to write about (pick the ones that fit the actual function):**
- The control setting and temperature only make sense over a **physical range** (a real
  inverter has min/max settings; a greenhouse has a realistic temperature band), so the
  inverse is valid only on those intervals, not all real numbers.
- An inverse exists only if the function is **one-to-one** (each temperature comes from one
  setting). A linear function is one-to-one, so that condition holds here.
- Real factors: **sensor error, response delay, heat loss, outside weather** — the model is
  an approximation, so the setting from the inverse gives a target, not an exact guarantee.

> When you send me the real T(C), I plug it into these exact steps.

---

## TASK 3 — Transformations of a Function

**Goal:** graph the base function and 4 transformations, explain each, give domain/range.

**THE TRANSFORMATION RULES (memorize these):**
| Form | Effect on the graph |
|------|--------------------|
| f(x) + k | shift **UP** k units (down if k negative) |
| f(x) − k | shift **DOWN** k units |
| f(x − h) | shift **RIGHT** h units |
| f(x + h) | shift **LEFT** h units |
| −f(x) | **reflect** over the x-axis (flip upside down) |
| f(−x) | **reflect** over the y-axis (flip left-right) |
| a·f(x), a>1 | **vertical stretch** (taller/narrower) |
| a·f(x), 0<a<1 | **vertical compression** (shorter/wider) |

**WORKED EXAMPLE** — suppose base **f(x) = x²** with transformations
f(x)+3, f(x−2), −f(x), 2f(x):

- **f(x) = x²** — base parabola, vertex (0,0). Domain (−∞,∞), Range [0,∞).
- **f(x)+3 = x²+3** — shifts UP 3. Vertex (0,3). Domain (−∞,∞), Range **[3,∞)**.
- **f(x−2) = (x−2)²** — shifts RIGHT 2. Vertex (2,0). Domain (−∞,∞), Range [0,∞).
- **−f(x) = −x²** — reflects over x-axis (opens down). Vertex (0,0). Domain (−∞,∞),
  Range **(−∞,0]**.
- **2f(x) = 2x²** — vertical stretch by 2 (narrower). Domain (−∞,∞), Range [0,∞).

**Domain/range observation to write:** shifts left/right never change domain or range of a
parabola's shape except vertical shifts move the range; reflection over the x-axis flips the
range (e.g. [0,∞) becomes (−∞,0]); vertical stretch keeps the same range for x² but changes
steepness.

**HOW TO GRAPH IN GEOGEBRA (all 5 on one screen):**
1. Go to https://www.geogebra.org/calculator
2. Input bar, type the base: `f(x) = x^2`  (use the real base function)
3. Type each transformation on its own line, referencing f:
   `f(x) + 3`  then `f(x - 2)`  then `-f(x)`  then `2 f(x)`
   (GeoGebra draws each in a new color and labels them.)
4. Scroll/zoom so all five curves show.
5. Export: menu (☰) → Download → Image (.png), or Flameshot the graph.

> When you send me the real base + 4 transformations, I write the exact classification,
> domain, and range for each, and give you the exact GeoGebra lines to type.

---

## TASK 4 — Even / Odd Function

**Goal:** define even function, test the displacement function algebraically, read the graph.

**DEFINITIONS:**
- **Even:** f(−x) = f(x) for all x  → symmetric about the **y-axis** (mirror image).
- **Odd:** f(−x) = −f(x) for all x  → symmetric about the **origin** (180° rotation).
- Otherwise: **neither**.

**THE ALGEBRAIC TEST (3 steps):**
1. Replace every x with (−x) to get f(−x).
2. Simplify using: even powers stay positive [(−x)²=x², (−x)⁴=x⁴]; odd powers flip sign
   [(−x)³=−x³, (−x)=−x]; constants stay.
3. Compare:
   - if f(−x) equals f(x) → **even**
   - if f(−x) equals −f(x) → **odd**
   - if neither → **neither**

**WORKED EXAMPLE** — suppose displacement **f(x) = x⁴ − 3x² + 2**:
1. f(−x) = (−x)⁴ − 3(−x)² + 2
2. = x⁴ − 3x² + 2      (even powers stay positive)
3. This equals f(x), so **f is EVEN** → its graph is symmetric about the y-axis.

**Another example** — **f(x) = x³ − x** (to show an odd result):
1. f(−x) = (−x)³ − (−x) = −x³ + x
2. −f(x) = −(x³ − x) = −x³ + x
3. f(−x) = −f(x), so **f is ODD** → symmetric about the origin.

**READING THE GIVEN GRAPH:**
- Fold the graph along the **y-axis** — if the two halves land on each other → **even**.
- Rotate the graph **180° about the origin** — if it looks identical → **odd**.
- If neither works → **neither**.

> When you send me the real displacement function + the graph, I run the exact test on it and
> state whether the graph shows even, odd, or neither symmetry, with the reasoning.

---

## SUMMARY — what to do

1. **Task 1:** already solved in `Unit2_Assignment_Activity.md`.
2. **Tasks 2, 3, 4:** follow the methods above. Send me the 3 real functions (+ Task 4 graph)
   and I'll produce the exact solutions and the final double-spaced Times New Roman Word doc.
3. **Graphs:** Task 3 needs a GeoGebra image (steps above); Task 4 uses the graph already
   given in the assignment.
