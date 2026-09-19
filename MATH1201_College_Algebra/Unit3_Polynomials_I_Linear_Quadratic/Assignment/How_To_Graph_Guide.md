# GeoGebra Graphing Guide — MATH 1201 Unit 3 (Full Walkthrough)

You need **two graphs** for this assignment:
- **Graph 1** → Task 1 (the bungee jumper parabola)
- **Graph 2** → Task 2 (the road with parallel/perpendicular routes)

Tool: **GeoGebra Graphing Calculator** → https://www.geogebra.org/calculator
No install needed — it runs in your browser. Everything below is click-by-click.

---

## Before you start (one-time orientation)

- On the left is the **Algebra/Input panel** (a list of input rows with a blinking cursor).
- On the right is the **Graphics view** (the grid where graphs appear).
- You type a function into an input row and press **Enter**; it graphs immediately and a new
  empty row opens below.
- To type an exponent like x², type `x^2` (the `^` makes the next character a power). After
  typing the power, press the **right-arrow key →** to get back down to the normal line before
  typing more.
- To delete a row: hover the row, click the three-dots (or the x) and delete. To hide a graph
  without deleting, click the colored circle at the left of its row.

Golden rule: type one line, press Enter, check the graph, then type the next line.

---

# GRAPH 1 — Task 1: Bungee Jumper  h(t) = −0.5t² + 210

GeoGebra uses `x` as the variable, so we type `x` where the problem uses `t`. That's fine —
just remember the horizontal axis is time.

### Step 1 — Plot the height function
1. Click the first input row.
2. Type exactly:  `f(x) = -0.5x^2 + 210`
   - To enter it: type `f(x)=-0.5x`, then `^2`, then press **→** (right arrow), then ` + 210`.
3. Press **Enter.** A downward-opening parabola appears, peaking at the top of the y-axis.

### Step 2 — Mark the key points (makes the graph tell the story)
Type each of these on its own row, pressing Enter after each:
1. `A = (0, 210)`   → the vertex / start of the jump (maximum height).
2. `B = (20.49, 0)`  → where the jumper reaches the river (t-intercept).
3. `C = (20, 10)`   → the height after 20 seconds (from the assignment).

Each shows up as a labeled dot. This visually backs up your written answers.

### Step 3 — Set a clean viewing window
The parabola is tall (up to 210) and wide (to ~20.5), so zoom to fit:
1. Right-click anywhere on the grid → **Settings** (or click the gear icon).
2. Open the **xAxis** settings and set the visible range to about **−2 to 24**.
3. Open the **yAxis** settings and set it to about **−20 to 230**.
   - Quick alternative: use the mouse wheel to zoom out until you can see the peak at
     (0, 210) and the point (20.49, 0) at the same time.
4. You should now see the full arch: peak at (0, 210) curving down to cross the x-axis near
   20.49.

### Step 4 — (Optional) restrict to the physical part
If you want to show only the real jump (t from 0 to 20.49), add this row instead of relying on
the full parabola:
`g(x) = If(0 <= x <= 20.49, -0.5x^2 + 210)`
This draws only the meaningful piece. Not required, but it's a nice touch.

### Step 5 — Screenshot Graph 1
1. Make sure the peak (0, 210) and the river point (20.49, 0) are both visible.
2. Capture the Graphics view:
   - Easiest inside GeoGebra: the **menu (☰) → Download as → PNG image** (saves a clean PNG).
   - Or use your screen tool (Flameshot) to grab just the graph area.
3. Save it somewhere easy to find (e.g. Desktop) as `graph1_bungee.png`.

**What the grader must see:** a downward parabola, highest at (0, 210), crossing the time axis
near t ≈ 20.49.

---

# GRAPH 2 — Task 2: Road  y = −2x + 17  (with alternate routes)

Start a fresh graph so the two don't overlap: menu (☰) → **New** (or just delete the Graph 1
rows). 

### Step 1 — Plot the proposed road
1. In the first input row type:  `y = -2x + 17`
2. Press **Enter.** A straight line with a downward slope appears.

### Step 2 — Add the two locations A and B
Type each on its own row:
1. `A = (5, 7)`
2. `B = (6, 5)`
Both points should land exactly **on** the line y = −2x + 17 (that confirms your equation is
correct — if a point is off the line, re-check the equation).

### Step 3 — Add a parallel route (same slope −2)
Type:  `y = -2x`
Press Enter. This line runs parallel to the road (same steepness, shifted down).

### Step 4 — Add a perpendicular route (slope 1/2, through A)
Type:  `y = 0.5x + 4.5`
Press Enter. This line crosses the road at a right angle and passes through A(5, 7).
(Check: 0.5×5 + 4.5 = 7 ✓, so it does pass through A.)

### Step 5 — (Optional) mark the access points (intercepts)
Type each:
1. `(0, 17)`   → the y-intercept of the road.
2. `(8.5, 0)`  → the x-intercept of the road.

### Step 6 — Set a clean viewing window
1. Right-click grid → **Settings** (gear icon).
2. Set **xAxis** range about **−2 to 12** and **yAxis** range about **−2 to 20**.
   - Or mouse-wheel zoom until A(5,7), B(6,5), and the intercept (0,17) are all visible.
3. You should see: the main road through A and B, a parallel line below it, and a
   perpendicular line crossing it.

### Step 7 — Screenshot Graph 2
1. Make sure A, B, the road, the parallel line, and the perpendicular line are all in view.
2. Capture: menu (☰) → **Download as → PNG image**, or Flameshot the graph area.
3. Save as `graph2_road.png`.

**What the grader must see:** the road line passing through A(5,7) and B(6,5), one line
parallel to it, and one line crossing it at a right angle.

---

# INSERTING THE GRAPHS INTO THE WORD DOC

1. Open `Unit3_Assignment_Activity.docx` in Microsoft Word (or LibreOffice/Google Docs).
2. Find the line (Task 1):
   **[ Insert GeoGebra graph of h(t) = -0.5t^2 + 210 here ]**
   - Click on that line, delete the bracket text, then **Insert → Picture** →
     choose `graph1_bungee.png`.
3. Find the line (Task 2):
   **[ Insert GeoGebra graph of the road y = -2x + 17 with A, B, and the
   parallel/perpendicular routes here ]**
   - Delete the bracket text and **Insert → Picture** → choose `graph2_road.png`.
4. Resize each image so it fits neatly within the margins (drag a corner handle).
5. Save the document (keep it as `.docx`).

---

# FINAL CHECK BEFORE SUBMITTING

- [ ] Graph 1 shows the parabola peaking at (0, 210) and touching the x-axis near 20.49.
- [ ] Graph 2 shows the road through A(5,7) and B(6,5) plus a parallel and a perpendicular
      line.
- [ ] Both bracket placeholder lines are deleted (only the images remain).
- [ ] Document is double-spaced, Times New Roman 12 pt (already set).
- [ ] File saved as `.docx`, then upload to Brightspace.

That's everything — once both graphs are in, the assignment is fully complete for the 100/100
target (all math is already solved and verified, sources cited, formatting compliant).
