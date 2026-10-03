# GeoGebra Graphing Guide: MATH 1201 Unit 5

You need **three graphs**:

| Graph | Task | Save as |
|---|---|---|
| Graph 1 | Task 1: 2ˣ, log₂(x), and x² together | `fig1_compare.png` |
| Graph 2 | Task 1: 2ˣ and log₂(x) mirrored across y = x | `fig2_inverse.png` |
| Graph 3 | Task 3: cancer cell growth, 100-unit scale | `fig3_growth.png` |

Save them into `MATH1201_College_Algebra/Unit5_Exponential_Logarithmic/Assignment/figures/`
(or leave them in Downloads and tell me which is which). Then run, from the Unit 5 folder:

```
cd ~/UOP/MATH1201_College_Algebra/Unit5_Exponential_Logarithmic
python3 build_docx.py
```

---

## Quick reminders (same screen as last week)

- Go to **https://www.geogebra.org/calculator**. Type each line in the **Input...** box on the
  left and press **Enter**.
- Powers: type `2^x`, then press **→** to come back down before typing more.
- **Log base 2** in GeoGebra is typed `log(2, x)` (the base goes first).
- **Window:** right-click empty grid → **Graphics...** → **Graphics** tab → **Dimensions** →
  x Min, x Max, y Min, y Max.
- **Dashed line:** ⋮ at the end of a row → **Settings** → **Style** tab → **Line Style**.
- **Export:** ☰ menu → **Export Image** → PNG → **Download**.
- **New graph:** ☰ → **New** → **Don't save**.

---

## GRAPH 1: Task 1, three types of function

Type each line in its own **Input...** box:

```
f(x) = 2^x
```
```
g(x) = log(2, x)
```
```
h(x) = x^2
```
Then mark the special points:
```
Intersect(f, h, -2, 5)
```
(For two functions GeoGebra needs a start and end x-value; plain `Intersect(f, h)` shows "?"
because 2ˣ is not a polynomial. You get about (-0.77, 0.59), (2, 4) and (4, 16). If your version
rejects it, type the points instead: `A = (-0.767, 0.588)`, `B = (2, 4)`, `C = (4, 16)`.)
```
P = (0, 1)
```
```
Q = (1, 0)
```

**Window:** x Min **-3**, x Max **6**, y Min **-4**, y Max **20**.

**You should see:** the exponential curve rising steeply on the right, the parabola, and the log
curve starting near the y-axis and rising slowly. P is where 2ˣ crosses the y-axis, Q is where
log₂(x) crosses the x-axis.

**Export** as `fig1_compare.png`.

---

## GRAPH 2: Task 1, inverse functions

Start a new graph. Type:

```
f(x) = 2^x
```
```
g(x) = log(2, x)
```
```
y = x
```
Make **y = x dashed** (⋮ → Settings → Style → Line Style). Then add the mirror points:
```
P = (0, 1)
```
```
Q = (1, 0)
```
```
R = (2, 4)
```
```
S = (4, 2)
```

**Window:** x Min **-4**, x Max **6**, y Min **-4**, y Max **6**.

**You should see:** the two curves as mirror images across the dashed line. P mirrors Q, and R
mirrors S.

**Export** as `fig2_inverse.png`.

---

## GRAPH 3: Task 3, cancer cell growth with a 100-unit scale

Start a new graph. Type:

```
P(x) = 232.26 * 1.02^x
```
(Here x is the number of years after 2018.)

Plot the table points for 2018 to 2023 in one go:
```
Sequence((t, 232.26 * 1.02^t), t, 0, 5)
```
Mark the 10-year projection:
```
A = (10, P(10))
```

**Set the 100-unit scale** (the task asks for this):
1. Right-click empty grid → **Graphics...** → **Graphics** tab.
2. Open **xAxis**. Tick **Distance** and type **100**.
3. Open **yAxis**. Tick **Distance** and type **100**.

**Window (Dimensions):** x Min **-10**, x Max **120**, y Min **-100**, y Max **2000**.

**You should see:** the curve starting at (0, 232.26), rising slowly at first and then more
steeply, reaching about 1,683 at x = 100. The table points sit close together near the start, and
A is at about (10, 283.12). Grid lines are 100 units apart on both axes.

**Export** as `fig3_growth.png`.

---

## If something goes wrong

| Problem | Fix |
|---|---|
| `log(2, x)` gives an error | Make sure there is a comma, and the base (2) comes first |
| The exponent swallowed the rest | Retype and press **→** right after the power |
| Intersect shows `= ?` or an error | Use a range: `Intersect(f, h, -2, 5)`, or type the points |
| Sequence draws nothing | Check both brackets: `Sequence((t, ...), t, 0, 5)` |
| Can't find Distance | It is inside **xAxis** / **yAxis** in the Graphics tab; click the **>** arrow to open it |
