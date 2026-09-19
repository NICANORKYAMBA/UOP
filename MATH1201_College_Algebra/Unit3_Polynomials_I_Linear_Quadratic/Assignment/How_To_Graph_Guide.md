# GeoGebra Graphing Guide — MATH 1201 Unit 3

You need **two** graphs for this assignment. Use the GeoGebra online calculator:
https://www.geogebra.org/calculator

---

## Graph 1 — Task 1: the bungee jumper quadratic

Model: `h(t) = -0.5t² + 210`.

**Steps:**
1. Open the GeoGebra calculator link.
2. In the input bar, type exactly:  `h(x) = -0.5 x^2 + 210`
   (GeoGebra uses `x` as the input variable; treat `x` as time `t`.)
3. Press Enter — a downward parabola appears with its peak at `(0, 210)`.
4. To show only the physical part of the jump (t from 0 to ~20.49), you can instead type:
   `f(x) = If(0 <= x <= 20.49, -0.5 x^2 + 210)`
5. Mark the key points (optional but nice): type `(0, 210)` for the vertex/start and
   `(20.49, 0)` for the river touchdown. Type `(20, 10)` to show the "after 20 s" point.
6. Adjust the view: right-click the graph → Settings → set x-axis roughly 0 to 22 and y-axis
   0 to 220 so the whole curve is visible.
7. **Screenshot** the graph and paste it into the docx at:
   `[ Insert GeoGebra graph of h(t) = -0.5t^2 + 210 here ]`

What the grader should see: a parabola peaking at (0, 210), curving down to cross the t-axis
near t ≈ 20.49.

---

## Graph 2 — Task 2: the road and its alternate routes

Main road: `y = -2x + 17`, with points A(5, 7) and B(6, 5).

**Steps:**
1. In the input bar, type each line, pressing Enter after each:
   - `y = -2x + 17`   (the proposed road)
   - `y = -2x`         (a parallel route — same slope −2)
   - `y = 0.5x + 4.5`  (a perpendicular route — slope 1/2, through A)
2. Add the two locations: type `A = (5, 7)` then `B = (6, 5)`. They appear as labeled points
   on the main road.
3. (Optional) Mark the access points: type `(0, 17)` (y-intercept) and `(8.5, 0)`
   (x-intercept).
4. Adjust the view so x runs about −2 to 12 and y about −2 to 20.
5. **Screenshot** and paste into the docx at:
   `[ Insert GeoGebra graph of the road y = -2x + 17 with A, B, and the parallel/perpendicular
   routes here ]`

What the grader should see: the main road line passing through A(5, 7) and B(6, 5), a second
line parallel to it, and a third line crossing it at right angles.

---

## Tip
Once both screenshots are pasted into `Unit3_Assignment_Activity.docx`, delete the bracketed
placeholder lines so only the images remain. Then the document is ready to submit.
