# Written Assignment Unit 6: Trigonometry I, Foundations of Trigonometry

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Maswili
**Instructor:** Chibuike Agu
**Due:** October 14, 2026

This assignment works through four tasks on trigonometric functions: finding all six function
values from a point on the unit circle, using angles of elevation in a real situation, analysing
sine, cosine, and tangent equations and graphs, and comparing a trigonometric function with its
inverse. Every step and formula is shown, the values were checked with a computer algebra tool,
and the Task 4 graph was drawn in GeoGebra.

## Task 1: Trigonometric Functions From a Point on the Unit Circle

Point A lies on the unit circle at A = (-√3/2, 1/2), after one full revolution from the initial
line (the positive x-axis).

### (i) All Six Trigonometric Values

On the unit circle the radius is r = 1, so for a point (x, y) the six functions are defined as
follows (Abramson, 2021, Sections 7.3 and 7.4):

| Function | Formula | Value |
|---|---|---|
| sin θ | y / r = y | **1/2** |
| cos θ | x / r = x | **-√3/2** |
| tan θ | y / x | (1/2) ÷ (-√3/2) = -1/√3 = **-√3/3** |
| csc θ | 1 / sin θ = r / y | 1 ÷ (1/2) = **2** |
| sec θ | 1 / cos θ = r / x | 1 ÷ (-√3/2) = -2/√3 = **-2√3/3** |
| cot θ | 1 / tan θ = x / y | (-√3/2) ÷ (1/2) = **-√3** |

**Check that A is on the unit circle:** x² + y² = (3/4) + (1/4) = 1, so r = 1. The Pythagorean
identity sin²θ + cos²θ = 1/4 + 3/4 = 1 also holds.

### (ii) The Quadrant

Point A lies in **Quadrant II**. The reason is the signs of its coordinates: x = -√3/2 is
**negative** and y = 1/2 is **positive**, and Quadrant II is exactly the region where x < 0 and
y > 0. This matches the signs of the six values above: in Quadrant II only sine and its reciprocal
cosecant are positive, while cosine, tangent, secant, and cotangent are negative.

### (iii) The Angle and the Reference Angle

**Reference angle.** The reference angle θ' is the acute angle between the terminal side and the
x-axis. Using the absolute values of the coordinates:

```
tan θ' = |y| / |x| = (1/2) / (√3/2) = 1/√3
θ'     = tan⁻¹(1/√3) = 30°   (π/6 radians)
```

**Angle with the positive x-axis.** In Quadrant II the angle is θ = 180° - θ' (Abramson, 2021,
Section 7.3):

```
θ = 180° - 30° = 150°   (5π/6 radians)
```

Because the point is reached after completing one revolution, the total rotation measured from the
initial line is 360° + 150° = **510°** (or 17π/6 radians). An angle of 510° is coterminal with 150°,
since they differ by a full turn of 360°, so it ends at the same point A and has the same six
function values and the same **30° reference angle**. Figure 1 shows the point, the angle, and the
reference angle.

**Figure 1**

*Point A on the Unit Circle With θ = 150° and a Reference Angle of 30°*

[FIGURE figures/fig1_unit_circle.png]

## Task 2: Angles of Elevation

Alice first stands at point A, 4 m from the tree, then moves 2 m closer to point B, so B is
2 m from the tree. The object is at the top of the tree, 6 m above the ground. Each position forms
a right triangle with the tree, where the height of the tree is the side opposite the angle and the
ground distance is the adjacent side (Figure 2). As in the textbook model, Alice's eyes are taken to
be at ground level.

**Figure 2**

*Right Triangles Formed at Points A and B*

[FIGURE figures/fig2_tree.png]

### (i) The Angles at A and B

The formula linking the opposite and adjacent sides is the tangent ratio (Abramson, 2021,
Section 7.2):

tan θ = opposite / adjacent, so θ = tan⁻¹(opposite / adjacent)

```
At A:  tan A = 6 / 4 = 1.5     ->  A = tan⁻¹(1.5) ≈ 56.31°
At B:  tan B = 6 / 2 = 3       ->  B = tan⁻¹(3)   ≈ 71.57°
```

These are **angles of elevation**: each is the angle between the horizontal ground and Alice's line
of sight as she looks **up** at an object above her.

### (ii) Comparing the Angles

Angle A (56.31°) is **not** larger than angle B (71.57°). Angle B is larger by about 15.26°.

**Conclusion.** For an object at a fixed height, the closer the observer stands, the larger the
angle of elevation. Moving closer shrinks the adjacent side while the opposite side stays 6 m, so
the ratio opposite/adjacent grows (from 1.5 to 3), and because tangent increases on 0° to 90°, the
angle grows too. Far away, the angle gets smaller and approaches 0°; standing almost at the base,
it approaches 90°.

### (iii) The Distances to the Object

The direct distance from each point to the object is the hypotenuse of its right triangle, found
with the Pythagorean theorem, c = √(a² + b²):

```
Distance AT = √(4² + 6²) = √(16 + 36) = √52 = 2√13 ≈ 7.21 m
Distance BT = √(2² + 6²) = √(4 + 36)  = √40 = 2√10 ≈ 6.32 m
```

**Check with trigonometry.** Using sin θ = opposite / hypotenuse, the hypotenuse = 6 / sin θ:
6 / sin 56.31° ≈ 7.21 m and 6 / sin 71.57° ≈ 6.32 m, which agree. So the object is about 7.21 m
from point A and about 6.32 m from point B.

## Task 3: Sinusoidal and Tangent Functions

The general forms used here are (Abramson, 2021, Sections 8.1 and 8.2):

- y = A sin(Bx - C) + D and y = A cos(Bx - C) + D, where |A| is the amplitude, the period is
  2π / |B|, the phase shift is C / B, and y = D is the midline.
- y = A tan(Bx - C) + D, where |A| is the stretching factor, the period is π / |B|, and the phase
  shift is C / B.

### (a) A Sine or Cosine Function With the Given Properties

Midline 5, amplitude 13, period 2π, phase shift 0.

```
Midline   D = 5
Amplitude |A| = 13              ->  A = 13
Period    2π / |B| = 2π         ->  B = 1
Phase shift C / B = 0            ->  C = 0
```

**y = 13 sin(x) + 5** (an equally valid cosine answer is y = 13 cos(x) + 5).

Check: the function swings 13 units above and below y = 5, from a minimum of -8 to a maximum of 18,
and repeats every 2π.

### (b) Analysing y = 15 tan(πx/3 + 2)

Rewrite it in the form A tan(Bx - C): here **A = 15**, **B = π/3**, and -C = 2, so **C = -2**.

| Property | Formula | Result |
|---|---|---|
| Stretching factor | ∣A∣ | **15** |
| Period | π / ∣B∣ = π ÷ (π/3) | **3** |
| Phase shift | C / B = -2 ÷ (π/3) = -6/π | **-6/π ≈ -1.91** (a shift 6/π units to the left) |
| Vertical asymptotes | set Bx - C = π/2 + kπ: πx/3 + 2 = π/2 + kπ | **x = 3/2 - 6/π + 3k ≈ -0.41 + 3k**, k an integer |
| Domain | all real x except the asymptotes | **{x : x ≠ 3/2 - 6/π + 3k, k ∈ ℤ}** |

**Solving for the asymptotes step by step:**

```
πx/3 + 2 = π/2 + kπ
πx/3     = π/2 - 2 + kπ
x        = (3/π)(π/2 - 2 + kπ) = 3/2 - 6/π + 3k
```

Neighbouring asymptotes are 3 apart, which matches the period. The range is all real numbers.

### (c) The Points on the Graph

The graph reaches its maximum value of 1 at θ = 0°, crosses zero at ±90°, and reaches -1 at
±180°. That is exactly the shape of **y = cos θ**, which starts at its maximum on the y-axis, so the
graph represents a **cosine function** (Abramson, 2021, Section 8.1). The vertical grid lines are
45° apart, which places each point at a multiple of 45°:

| Point | θ | y = cos θ | Coordinates |
|---|---|---|---|
| a | -315° | cos(-315°) = cos 45° = √2/2 ≈ 0.71 | **(-315°, √2/2)** |
| b | -135° | cos(-135°) = -√2/2 ≈ -0.71 | **(-135°, -√2/2)** |
| c | -90° | cos(-90°) = 0 | **(-90°, 0)** |
| d | 135° | cos(135°) = -√2/2 ≈ -0.71 | **(135°, -√2/2)** |
| e | 180° | cos(180°) = -1 | **(180°, -1)** |
| f | 225° | cos(225°) = -√2/2 ≈ -0.71 | **(225°, -√2/2)** |

The values also show the symmetry of cosine: b and d are mirror images about the y-axis, with
cos(-135°) = cos(135°), and d and f are symmetric about the minimum at e.

## Task 4: A Trigonometric Function and Its Inverse

### (i) The Table

I chose **Y = f(X) = cos X**, with inverse **f⁻¹(Y) = cos⁻¹(Y) = arccos(Y)**. The inverse cosine
returns the angle in [0, π] whose cosine is Y (Abramson, 2021, Section 8.3).

| X | 0 | π/3 | 2π/3 | π/2 | π | 4π/3 | 2π |
|---|---|---|---|---|---|---|---|
| Y = f(X) = cos X | 1 | 1/2 | -1/2 | 0 | -1 | -1/2 | 1 |
| f⁻¹(Y) = arccos Y | 0 | π/3 | 2π/3 | π/2 | π | 2π/3 | 0 |

The table reveals something important. For the first five columns, where X is between 0 and π,
the inverse gives back exactly the original X. For X = 4π/3 and X = 2π it does not: arccos(-1/2)
returns 2π/3, not 4π/3, and arccos(1) returns 0, not 2π. That happens because cosine is not
one-to-one over a full turn, so its inverse can only be defined by restricting cosine to [0, π],
and arccos always answers with an angle from that interval.

### (ii) The Graph

Figure 3 shows Y = cos X and its inverse Y = arccos X drawn on the same axes in GeoGebra, with the
line y = x. The arccos curve is the reflection of cos X, restricted to [0, π], across the line
y = x, which is the graphical meaning of an inverse.

**Figure 3**

*Y = cos X and Y = arccos X on the Same Graph in GeoGebra*

[FIGURE figures/fig3_task4.png]

### (iii) Observations

**(a) Periodicity.** The table shows that cos X repeats: cos 0 = cos 2π = 1, and the values 1,
1/2, -1/2, -1 return in reverse as X goes from π to 2π. In general cos(X + 2π) = cos X, so cosine is
**periodic with period 2π** (Abramson, 2021, Section 8.1). The inverse arccos is **not periodic**:
it is one-to-one and decreases steadily from π at Y = -1 to 0 at Y = 1, so it never repeats a value.

**(b) Domain and range.**

| Function | Domain | Range |
|---|---|---|
| f(X) = cos X | all real numbers, (-∞, ∞) | [-1, 1] |
| f⁻¹(Y) = arccos Y | [-1, 1] | [0, π] |

The domain of arccos is the range of cosine, and the range of arccos is the restricted domain
[0, π] of cosine, as expected for inverse functions.

**(c) Even, odd, or neither.** A function is even if f(-X) = f(X) and odd if f(-X) = -f(X). Cosine
satisfies cos(-X) = cos X; for example cos(-π/3) = 1/2 = cos(π/3). So **f(X) = cos X is an even
function**, and its graph is symmetric about the y-axis, as the points b and d in Task 3 also show.
(By contrast, arccos is neither even nor odd, because arccos(-Y) = π - arccos(Y).)

## Conclusion

The unit circle turns trigonometry into coordinates: the point A = (-√3/2, 1/2) gave all six
function values, its quadrant, and its 150° angle at once. Right-triangle ratios turned Alice's
situation into angles of elevation and distances, and showed that angles of elevation grow as an
observer moves closer. The general forms of sine, cosine, and tangent made it possible to build
and read equations and graphs, and the cosine table showed why an inverse trigonometric function
needs a restricted domain.

## References

Abramson, J. (2021). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e
