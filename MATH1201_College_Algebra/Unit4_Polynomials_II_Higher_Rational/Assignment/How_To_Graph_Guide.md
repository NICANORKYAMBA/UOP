# GeoGebra Graphing Guide: MATH 1201 Unit 4

You need **four graphs** for this assignment (Task 1 gives its own graph, so it needs none):

| Graph | Task | Save as | Status |
|---|---|---|---|
| Graph 1 | Task 2, the quartic f(x) = x⁴ - 8x³ - 8x² + 8x + 7 | `task2_graph.png` | done |
| Graph 2 | Task 3, f(x) = (2x² - 5x + 3)/(x² + 5x) with its asymptotes | `task3_graph.png` | to do |
| Graph 3 | Task 4, the rational function with its asymptotes | `task4_graph.png` | done |
| Graph 4 | Task 5, the box volume V(x) and the line V = 12500 | `task5_graph.png` | to do |

Save all of them into this folder:
`MATH1201_College_Algebra/Unit4_Polynomials_II_Higher_Rational/Assignment/figures/`

---

## PART 0: Open GeoGebra and learn the screen (2 minutes)

1. Open your browser and go to **https://www.geogebra.org/calculator**
2. If a pop-up or sign-in box appears, close it with the **X**. You do not need an account.
3. The screen has two halves:

```
+---------------------------+-----------------------------------------------+
| ☰  (menu, top left)       |                                               |
|                           |                                               |
|  ALGEBRA PANEL (left)     |          GRAPH AREA (right, the grid)         |
|                           |                                               |
|  +--------------------+   |                     |                         |
|  |  Input...          | <-- you type here       |                         |
|  +--------------------+   |          -----------+-----------              |
|                           |                     |                         |
|                           |                     |                         |
|                           |                         [+] [-] [home]  <-- zoom buttons,
+---------------------------+-----------------------------------------------+     bottom right
```

- **Input box:** the empty row in the left panel that says **"Input..."**. Click it and a
  cursor blinks. This is where you type every command in this guide.
- After you type a line and press **Enter**, it becomes a row in the left panel, it shows on the
  grid, and a new empty **Input...** row appears underneath for the next line.
- A **math keyboard** may pop up at the bottom of the screen. You can ignore it and type on your
  normal keyboard, or close it with the small **X** / keyboard icon.
- Each finished row has a **colored circle** on its left (click it to hide or show that graph)
  and **three dots ⋮** on its right (click for Settings or Delete).

**Typing powers:** type `x^4`. The cursor jumps up into the exponent. Press the **right arrow
key →** once to come back down, then keep typing. Example for x⁴ - 8x³: type `x^4`, press →,
type ` - 8x^3`, press →, and so on.

**Setting the view window** (you'll do this for every graph):
1. **Right-click** on an empty spot of the grid (not on the curve).
2. Click **Graphics...** (or **Settings**). A **Settings** panel opens on the right side.
3. At the top of that panel, click the **Graphics** tab (next to General and Algebra).
4. Click **Dimensions** (the row with a **>** arrow, under Grid and Axes). It opens and shows
   boxes labeled **x Min**, **x Max**, **y Min**, **y Max**.
   (Older GeoGebra versions show these boxes straight away on a **Basic** tab instead.)
5. Click each box, delete what's there, type the new number, and press **Enter**.
6. Close the Settings panel with the **X** at its top right.

**Saving a picture (export)**:
1. Click the **☰ menu** (three lines, top left corner of the screen).
2. Click **Export Image**. (In some versions it is **Download as** → **PNG image (.png)**.)
3. Keep the format as **PNG** and click **Download**.
4. The file goes to your **Downloads** folder. Rename it to the name in the table above and move
   it into the `figures` folder.

**Starting a new graph:** ☰ menu → **New** (or **Clear all**) → if asked to save, click
**Don't save**.

---

## PART 1: Graph for Task 2, f(x) = x⁴ - 8x³ - 8x² + 8x + 7

**Step 1. Type the function.**
Click the **Input...** box. Type the line below, then press **Enter**:
```
f(x) = x^4 - 8x^3 - 8x^2 + 8x + 7
```
(Remember to press **→** after each power.)
**You should see:** a row `f(x) = x⁴ - 8x³ - 8x² + 8x + 7` in the left panel and a curve on the
grid. It may look like two tall lines right now; that is normal, the window is fixed in Step 5.

**Step 2. Mark the zeros.**
Click the new empty **Input...** box, type, press **Enter**:
```
Root(f)
```
**You should see:** four dots on the x-axis named A, B, C, D, and new rows in the left panel
like A = (-1, 0), B = (-0.8, 0), C = (1, 0), D = (8.8, 0).

**Step 3. Mark the y-intercept.**
In the next **Input...** box type, then **Enter**:
```
Y = (0, 7)
```

**Step 4. Mark the turning points.**
In the next **Input...** box type, then **Enter**:
```
Extremum(f)
```
**You should see:** three more dots, at about (-0.9, -0.19), (0.34, 8.49) and (6.56, -691.3).

**Step 5. Set the window.**
Right-click an empty part of the grid → **Graphics...** → **Graphics** tab → **Dimensions** → enter:

| Box | Value |
|---|---|
| x Min | -3 |
| x Max | 10 |
| y Min | -750 |
| y Max | 150 |

Close the settings panel.
**You should see:** a big W-shaped curve: high on the left, a deep valley near x = 6.5, high
again on the right. The zeros near -1, -0.8 and 1 look bunched together near the origin; that
is correct.

**Step 6. Export.** ☰ → **Export Image** → PNG → **Download**. Rename to
**`task2_graph.png`** and move it into the `figures` folder.

---

## PART 1B: Graph for Task 3, f(x) = (2x² - 5x + 3) / (x² + 5x)

Start a new graph: ☰ → **New** → **Don't save**.

**Step 1. Type the function.**
Click **Input...**, type, **Enter**:
```
h(x) = (2x^2 - 5x + 3) / (x^2 + 5x)
```
Type the top in brackets, then `/`, then the bottom in brackets. Press **→** after each `^2`,
and press **→** again after the bottom to leave the fraction.
**Check:** the row shows a fraction with 2x² - 5x + 3 on top and x² + 5x on the bottom.

**Step 2. Draw the three asymptotes.** One per **Input...** box, **Enter** after each:
```
x = -5
```
```
x = 0
```
```
y = 2
```
Note: `x = 0` sits exactly on the y-axis, so after making it dashed it will look like a dashed
y-axis. That is correct.

**Step 3. Make the three asymptotes dashed** (same as Part 2 Step 3): ⋮ on the row →
**Settings** → **Style** tab → **Line Style** → dashed.

**Step 4. Mark the zeros and the point where the graph crosses y = 2.** One per box:
```
Z1 = (1, 0)
```
```
Z2 = (1.5, 0)
```
```
P = (0.2, 2)
```

**Step 5. Set the window.** Right-click empty grid → **Graphics...** → **Graphics** tab →
**Dimensions**:

| Box | Value |
|---|---|
| x Min | -15 |
| x Max | 10 |
| y Min | -10 |
| y Max | 12 |

**You should see:** three separate pieces of curve. On the far left the curve comes in along
y = 2 and shoots up at x = -5. Between x = -5 and x = 0 it comes up from -∞ and drops back down
to -∞. On the right of x = 0 it comes down from +∞, passes through P(0.2, 2), dips just below
the x-axis between Z1 and Z2, and then rises slowly toward y = 2 from below.

**Step 6. Export.** ☰ → **Export Image** → PNG → **Download**. Save as **`task3_graph.png`**
(or leave it in Downloads and ask me to move it).

---

## PART 2: Graph for Task 4, the rational function

Start a new graph: ☰ → **New** → **Don't save**.

**Step 1. Type the function.**
Click **Input...**, type, **Enter**:
```
g(x) = (x - 2)(x - 3)(x - 4) / ((x - 1)(x - 5))
```
Tip: when you type `/`, GeoGebra builds a fraction and moves the cursor into the top part.
The easiest way is to type the whole top in brackets first, then `/`, then the whole bottom in
brackets, exactly as written above. After typing the bottom, press **→** to leave the fraction.
**Check:** the row in the left panel should show a fraction with (x - 2)(x - 3)(x - 4) on top and
(x - 1)(x - 5) on the bottom.

**Step 2. Draw the three asymptotes.** Type each line in its own **Input...** box, pressing
**Enter** after each:
```
x = 1
```
```
x = 5
```
```
y = x - 3
```
**You should see:** two vertical lines and one slanted line.

**Step 3. Make the asymptotes dashed.** Do this for each of the three lines:
1. In the left panel, find the row for the line (for example `x = 1`).
2. Click the **three dots ⋮** on the right end of that row → **Settings**.
3. In the settings panel click the **Style** tab.
4. Find **Line Style** and pick a **dashed** pattern from the dropdown.
5. Close the settings panel.

**Step 4. Mark the points from the task.** Type each line in its own **Input...** box:
```
A = (0, -4.8)
```
```
B = (2, 0)
```
```
C = (3, 0)
```
```
D = (4, 0)
```

**Step 5. Set the window.** Right-click empty grid → **Graphics...** → **Graphics** tab → **Dimensions**:

| Box | Value |
|---|---|
| x Min | -9 |
| x Max | 10 |
| y Min | -12 |
| y Max | 12 |

**You should see:** a picture that matches the graph in the assignment: the curve passing
through A, B, C and D, shooting up and down at the dashed lines x = 1 and x = 5, and following
the dashed slanted line at the far left and far right.

**Step 6. Export.** ☰ → **Export Image** → PNG → **Download**. Rename to
**`task4_graph.png`** and move it into `figures`.

---

## PART 3: Graph for Task 5, the box volume

Start a new graph: ☰ → **New** → **Don't save**.

**Step 1. Type the volume function, only for x > 30.**
Click **Input...**, type, **Enter**:
```
V(x) = If(x > 30, 45x^2 - 1800x + 13500)
```
(`If` means: only draw the curve when x > 30, the domain of a real box.)
Remember → after `x^2`.

**Step 2. Draw the target volume line.**
Next **Input...** box, type, **Enter**:
```
h: y = 12500
```
**You should see:** a horizontal line. The `h:` at the start is its name.

**Step 3. Find where they cross.**
Next **Input...** box, type, **Enter**:
```
Intersect(V, h)
```
**You should see:** a dot named A at about **(39.44, 12500)**. That's the cardboard width from
the paper.

**Step 4. Set the window.** Right-click empty grid → **Graphics...** → **Graphics** tab → **Dimensions**:

| Box | Value |
|---|---|
| x Min | 0 |
| x Max | 50 |
| y Min | -1000 |
| y Max | 20000 |

**You should see:** the curve starting on the x-axis at x = 30 and rising steeply, crossing the
horizontal line at the dot near x = 39.44.

**Step 5. Export.** ☰ → **Export Image** → PNG → **Download**. Rename to
**`task5_graph.png`** and move it into `figures`.

---

## PART 4: Put the graphs into the Word file

Open a terminal and run:
```
cd ~/UOP/MATH1201_College_Algebra/Unit4_Polynomials_II_Higher_Rational
python3 build_docx.py
```
The three graphs are placed under Figures 1, 2 and 3 in `Assignment/Unit4_Assignment_Activity.docx`.

---

## If something goes wrong

| Problem | Fix |
|---|---|
| The power swallowed the rest of the line (like x⁴⁻⁸ˣ) | Delete it and retype, pressing **→** right after the exponent |
| Red text or "Undefined variable" | Put `*` between a number and a bracket, e.g. `15*(3x - 30)` |
| Root(f) shows fewer than 4 dots | Zoom in near the origin; the dots at -1, -0.8 and 1 are close together |
| The curve looks like straight lines | The window is wrong, redo the **Graphics...** step |
| Intersect shows nothing | The line must be typed as `h: y = 12500` so it is named h |
| Can't find Export Image | Try ☰ → **Download as** → **PNG image**, or take a screenshot with Flameshot |
| Deleting a row | Click the ⋮ at the right end of the row → **Delete** |
