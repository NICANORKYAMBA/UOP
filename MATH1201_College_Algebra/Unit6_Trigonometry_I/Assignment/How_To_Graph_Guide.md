# GeoGebra Graphing Guide: MATH 1201 Unit 6 (Task 4)

You only need **one graph** this week. Figures 1 and 2 (the unit circle and the tree) are already
made.

| Graph | Task | Save as |
|---|---|---|
| Graph | Task 4: y = cos x and y = arccos x on the same axes | `fig3_task4.png` |

Save it into `MATH1201_College_Algebra/Unit6_Trigonometry_I/Assignment/figures/`, or leave it in
Downloads and tell me. Then run, from the Unit 6 folder:

```
cd ~/UOP/MATH1201_College_Algebra/Unit6_Trigonometry_I
python3 build_docx.py
```

---

## Steps

Go to **https://www.geogebra.org/calculator** and type each line in its own **Input...** box,
pressing **Enter** after each.

**1. The function and its inverse**
```
f(x) = cos(x)
```
```
g(x) = acos(x)
```
(`acos` is GeoGebra's name for arccos. The curve only appears between x = -1 and x = 1, which is
correct, because that is its domain.)

**2. The mirror line** (then make it dashed: ⋮ on its row → Settings → Style → Line Style)
```
y = x
```

**3. The table points on cos x**
```
Sequence((t, cos(t)), t, {0, pi/3, 2pi/3, pi/2, pi, 4pi/3, 2pi})
```
If that line gives an error, type the points one by one instead:
`A = (0, 1)`, `B = (pi/3, 0.5)`, `C = (2pi/3, -0.5)`, `D = (pi/2, 0)`, `E = (pi, -1)`,
`F = (4pi/3, -0.5)`, `G = (2pi, 1)`.

**4. The matching points on arccos x**
```
P = (1, 0)
```
```
Q = (0.5, pi/3)
```
```
R = (-0.5, 2pi/3)
```
```
S = (-1, pi)
```

**5. Show the x-axis in multiples of π**
Right-click the empty grid → **Graphics...** → **Graphics** tab → **xAxis** → tick **Distance**
and choose **π/2** from the list.

**6. Window** (Graphics tab → **Dimensions**): x Min **-1.5**, x Max **7**, y Min **-1.5**,
y Max **3.5**.

**You should see:** a cosine wave from 0 to 2π passing through the seven table points, and a
short arccos curve from (-1, π) down to (1, 0). The arccos curve is the mirror image of the part of
cos x between 0 and π, reflected across the dashed line y = x.

**7. Export:** ☰ → **Export Image** → PNG → **Download**. Save as **`fig3_task4.png`**.

---

## If something goes wrong

| Problem | Fix |
|---|---|
| The wave looks flat | Redo the Dimensions in step 6 |
| `acos` gives an error | Try `arccos(x)` instead |
| Sequence gives an error | Type the points A to G one by one (step 3) |
| Can't find Distance | Graphics tab → click the **>** next to **xAxis** |
