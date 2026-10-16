# GeoGebra Graphing Guide: MATH 1201 Unit 7 (Task 1 ii)

You only need **one graph** this week: y = tan θ and y = tan 2θ on the same axes, with the
triangle's angle marked on both.

Save it as **`fig1_tan_graphs.png`** in
`MATH1201_College_Algebra/Unit7_Trigonometry_II/Assignment/figures/`, or leave it in Downloads and
tell me. Then I will rebuild the Word file.

---

## Steps

Go to **https://www.geogebra.org/calculator** and type each line in its own **Input...** box,
pressing **Enter** after each.

**1. The two functions**
```
f(x) = tan(x)
```
```
g(x) = tan(2x)
```

**2. The triangle's angle** (θ = tan⁻¹(4/3) ≈ 0.9273 rad)
```
a = atan(4/3)
```
(If a slider appears for a, that is fine. Leave it.)

**3. The two points at that angle**
```
P = (a, f(a))
```
```
Q = (a, g(a))
```
P should sit at about (0.93, 1.33) on tan θ, and Q at about (0.93, -3.43) on tan 2θ.

**4. A dashed guide line through both points** (then make it dashed: ⋮ on its row → Settings →
Style → Line Style)
```
x = a
```

**5. Colours** so the two curves are easy to tell apart: ⋮ on the f row → Settings → Color →
blue. Do the same for g → red.

**6. Show the x-axis in multiples of π**
Right-click the empty grid → **Graphics...** → **xAxis** tab → tick **Distance** and choose
**π/4** from the list.

**7. Window** (Graphics → **Basic** tab, the Dimensions boxes): x Min **-0.3**, x Max **3.5**,
y Min **-6**, y Max **6**.

**You should see:** the blue tan θ curve with one break at π/2, and the red tan 2θ curve with
breaks at π/4 and 3π/4 (it repeats twice as often). P is on the blue curve above the x-axis, Q is
on the red curve below it, and the dashed line joins them.

**8. Export:** ☰ → **Export Image** → PNG → **Download**. Save as **`fig1_tan_graphs.png`**.

---

## If something goes wrong

| Problem | Fix |
|---|---|
| The curves look like steep lines | Redo the window in step 7 |
| atan gives an error | Type `a = arctan(4/3)` instead |
| The x-axis shows decimals | Redo step 6 (Distance π/4) |
| Q is off the screen | Make y Min -6 or lower |
