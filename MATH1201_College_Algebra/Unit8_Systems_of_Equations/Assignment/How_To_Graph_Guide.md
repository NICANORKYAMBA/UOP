# GeoGebra Graphing Guide: MATH 1201 Unit 8 (Task 3)

You need **one graph**: the line x + y = 4 and the curve x² - 2xy - 3 = 0, with the two
intersection points marked.

Save it as **`fig1_task3.png`**, or just tell me when it is in Downloads, and I will put it in the
Word file.

---

## Steps

Go to **https://www.geogebra.org/calculator** and type each line in its own **Input...** box,
pressing **Enter** after each.

**1. The line** (the name L comes before the colon)
```
L: x + y = 4
```

**2. The curve** (GeoGebra recognizes it as a hyperbola)
```
H: x^2 - 2x y - 3 = 0
```
Type a space between `x` and `y` so GeoGebra reads it as x times y.

**3. The intersection points**
```
Intersect(L, H)
```
Two points appear, A at (3, 1) and B at about (-0.33, 4.33).

If `Intersect` gives an error, type the points yourself:
```
A = (3, 1)
```
```
B = (-1/3, 13/3)
```

**4. Show the coordinates on the graph:** ⋮ on the A row → Settings → **Show Label** → choose
**Name & Value**. Do the same for B.

**5. Colours** (optional but clearer): ⋮ on the L row → Settings → Color → blue; H → red.

**6. Window** (right-click the empty grid → Graphics... → Basic, the Dimensions boxes):
x Min **-6**, x Max **8**, y Min **-4**, y Max **8**.

**You should see:** a straight line sloping down through (0, 4) and (4, 0), and a curve with two
branches, one on each side of the y-axis. The line crosses the right branch at A(3, 1) and the
left branch at B(-0.33, 4.33).

**7. Export:** ☰ → **Export Image** → PNG → **Download**.

---

## If something goes wrong

| Problem | Fix |
|---|---|
| The curve does not appear | Check step 2 has a space: `2x y` (or type `2*x*y`) |
| Only one point appears | Zoom out with the window in step 6; B is near the y-axis |
| The labels hide the points | Drag the label a little away from the point |
