# Written Assignment Unit 7: Trigonometry II, Additional Trigonometric Concepts

**Course:** MATH 1201 College Algebra
**Student:** Nicanor Maswili
**Instructor:** Chibuike Agu
**Due:** October 21, 2026

This assignment works through four tasks that use trigonometric identities: double-angle,
half-angle, and sum formulas on a right triangle, factorizing and solving a trigonometric
equation, sum-to-product and product-to-sum formulas, and rewriting a double-angle expression in
terms of tan θ. Every formula is stated before it is used, every step is shown, all results were
checked with a computer algebra tool, and the graph in Task 1 was drawn in GeoGebra.

**Table 1**

*Identities Used in This Assignment*

| Type | Identity |
|---|---|
| Double angle | tan 2θ = 2 tan θ / (1 - tan²θ) |
| Double angle | sin 2θ = 2 sin θ cos θ,  cos 2θ = cos²θ - sin²θ |
| Sum of angles | sin(A + B) = sin A cos B + cos A sin B |
| Half angle | cos(θ/2) = ±√[(1 + cos θ)/2],  sin(θ/2) = ±√[(1 - cos θ)/2] |
| Sum to product | cos A - cos B = -2 sin[(A + B)/2] sin[(A - B)/2] |
| Product to sum | sin A cos C = ½[sin(A + C) + sin(A - C)] |
| Pythagorean | sin²θ + cos²θ = 1,  1 + tan²θ = sec²θ |

Sources: Yoshiwara (2023, Section 8.1); Abramson (2021, Sections 9.2 to 9.4); Mathispower4u
(2010c, 2010d).

## Task 1: Double-Angle, Sum, and Half-Angle Formulas on a Right Triangle

### Reading the Triangle

The right angle is at B. Side AB = 8 is vertical, side BC = 6 is horizontal, angle α is at A, and
angle θ is at C. (I follow the figure, where the side of length 8 is AB, opposite θ.) The
hypotenuse comes from the Pythagorean theorem:

```
AC = √(AB² + BC²) = √(8² + 6²) = √(64 + 36) = √100 = 10
```

For angle θ at C, the opposite side is AB = 8 and the adjacent side is BC = 6. For angle α at A,
the opposite side is BC = 6 and the adjacent side is AB = 8.

**Table 2**

*Trigonometric Ratios of θ and α*

| Angle | sin | cos | tan |
|---|---|---|---|
| θ (at C) | 8/10 = 4/5 | 6/10 = 3/5 | 8/6 = 4/3 |
| α (at A) | 6/10 = 3/5 | 8/10 = 4/5 | 6/8 = 3/4 |

Both angles are acute, θ ≈ 53.13° and α ≈ 36.87°, and θ + α = 90°, as it must be in a right
triangle.

### (i) tan 2θ

The double-angle formula for tangent comes from the sum formula with both angles equal to θ
(Yoshiwara, 2023, Section 8.1; Mathispower4u, 2019):

```
tan 2θ = 2 tan θ / (1 - tan²θ)
       = 2(4/3) / (1 - (4/3)²)
       = (8/3) / (1 - 16/9)
       = (8/3) / (-7/9)
       = (8/3) × (-9/7)
       = -24/7
```

**tan 2θ = -24/7 ≈ -3.4286.** The value is negative because 2θ ≈ 106.26° lies in Quadrant II,
where tangent is negative.

### (ii) Graphs of tan 2θ and tan θ

Figure 1 shows y = tan θ and y = tan 2θ drawn in GeoGebra, with the triangle's angle
θ = tan⁻¹(4/3) ≈ 0.9273 rad marked on both curves.

**Figure 1**

*Graphs of y = tan θ and y = tan 2θ in GeoGebra*

[FIGURE figures/fig1_tan_graphs.png]

**Table 3**

*Comparing the Two Graphs*

| Feature | y = tan θ | y = tan 2θ |
|---|---|---|
| Period | π | π/2 (twice as many cycles) |
| Vertical asymptotes | θ = π/2 + kπ | θ = π/4 + kπ/2 |
| Zeros | θ = kπ | θ = kπ/2 |
| Value at θ ≈ 0.9273 | 4/3 ≈ 1.333 (point P) | -24/7 ≈ -3.429 (point Q) |

The graph of tan 2θ is the graph of tan θ compressed horizontally by a factor of 2, so it repeats
every π/2 (Abramson, 2021, Section 9.3). At the triangle's angle, point P on tan θ is above the
axis while point Q on tan 2θ is below it, which agrees with the answer to part (i). The reason is
that θ ≈ 0.927 lies before the asymptote of tan θ at π/2 ≈ 1.571, but after the asymptote of
tan 2θ at π/4 ≈ 0.785, where tan 2θ jumps from very large positive values to very large negative
values.

### (iii) tan 4θ

Since 4θ = 2(2θ), the same double-angle formula is applied to the angle 2θ, using
tan 2θ = -24/7 from part (i):

```
tan 4θ = 2 tan 2θ / (1 - tan²2θ)
       = 2(-24/7) / (1 - (-24/7)²)
       = (-48/7) / (1 - 576/49)
       = (-48/7) / (-527/49)
       = (-48/7) × (-49/527)
       = 2352/3689
       = 336/527
```

(2352/3689 reduces by 7, since 2352 = 7 × 336 and 3689 = 7 × 527.)

**tan 4θ = 336/527 ≈ 0.6376.** As a check, 4θ ≈ 212.52° lies in Quadrant III, where tangent is
positive.

### (iv) sin(A + B)

Here A is the angle at vertex A (α) and B is the angle at vertex B, which is the right angle, so
B = 90°, sin B = 1, and cos B = 0. Using the sum formula (Abramson, 2021, Section 9.2;
Mathispower4u, 2010d):

```
sin(A + B) = sin A cos B + cos A sin B
           = sin A (0) + cos A (1)
           = cos A
           = adjacent / hypotenuse = AB / AC = 8/10
           = 4/5
```

**sin(A + B) = 4/5 = 0.8.** Check: the angles of a triangle add to 180°, so A + B = 180° - C and
sin(A + B) = sin(180° - C) = sin C = sin θ = 4/5. Both methods agree.

### (v) cos(θ/2)

The half-angle formula for cosine is (Abramson, 2021, Section 9.3; Mathispower4u, 2010a):

```
cos(θ/2) = ±√[(1 + cos θ) / 2]
```

Since θ ≈ 53.13° is acute, θ/2 ≈ 26.57° is in Quadrant I, so the positive root is taken. With
cos θ = 3/5:

```
cos(θ/2) = √[(1 + 3/5) / 2]
         = √[(8/5) / 2]
         = √(4/5)
         = 2/√5
         = 2√5/5
```

**cos(θ/2) = 2√5/5 ≈ 0.8944.** Check: cos(26.57°) ≈ 0.8944.

### (vi) sin(α/2)

The half-angle formula for sine is:

```
sin(α/2) = ±√[(1 - cos α) / 2]
```

Since α ≈ 36.87° is acute, α/2 ≈ 18.43° is in Quadrant I, so the positive root is taken. With
cos α = 4/5:

```
sin(α/2) = √[(1 - 4/5) / 2]
         = √[(1/5) / 2]
         = √(1/10)
         = 1/√10
         = √10/10
```

**sin(α/2) = √10/10 ≈ 0.3162.** Check: sin(18.43°) ≈ 0.3162.

## Task 2: Factorizing and Solving a Trigonometric Equation

### (i) Factorize 3x² - 12x + 9

First take out the common factor 3, then factor the quadratic by finding two numbers that
multiply to 3 and add to -4. Those numbers are -1 and -3:

```
3x² - 12x + 9 = 3(x² - 4x + 3)
              = 3(x - 1)(x - 3)
```

**3x² - 12x + 9 = 3(x - 1)(x - 3).** Check by expanding:
3(x² - 3x - x + 3) = 3x² - 12x + 9.

### (ii) Factorize 3 sin²θ - 12 sin θ + 9

Because sin²θ = (sin θ)², the expression has exactly the same form as part (i) with x replaced by
sin θ. Substituting x = sin θ into the factorization from part (i):

```
3 sin²θ - 12 sin θ + 9 = 3(sin θ)² - 12(sin θ) + 9
                       = 3(sin θ - 1)(sin θ - 3)
```

**3 sin²θ - 12 sin θ + 9 = 3(sin θ - 1)(sin θ - 3).**

### (iii) Solve 3 sin²θ - 12 sin θ + 9 = 0 on [0, 4π]

Using the factorization from part (ii) and the zero-product property, a product is zero only if
one of its factors is zero (Abramson, 2021, Section 9.5; Mathispower4u, 2010b):

```
3(sin θ - 1)(sin θ - 3) = 0
sin θ - 1 = 0   or   sin θ - 3 = 0
sin θ = 1       or   sin θ = 3
```

**sin θ = 3 has no solution**, because the sine of any angle is between -1 and 1.

**sin θ = 1** happens only at the top of the unit circle, θ = π/2 + 2πk for any integer k. The
interval [0, 4π] covers two full rotations, which are checked separately:

**Table 4**

*Solutions of sin θ = 1, Rotation by Rotation*

| Rotation | Interval | k | Solution | Check |
|---|---|---|---|---|
| First | [0, 2π] | 0 | θ = π/2 (90°) | sin(π/2) = 1 |
| Second | [2π, 4π] | 1 | θ = π/2 + 2π = 5π/2 (450°) | sin(5π/2) = sin(π/2) = 1 |

The next value, k = 2, gives 9π/2 > 4π, which is outside the interval.

**Solution: θ = π/2 and θ = 5π/2.** Check in the original equation at θ = π/2:
3(1)² - 12(1) + 9 = 3 - 12 + 9 = 0.

## Task 3: Sums and Products of Trigonometric Functions

### (i) cos A - cos B

**Using the triangle.** The right angle is at C, so the other two angles add to 90°:

```
A + B = 90°
6θ + 4θ = 90°
10θ = 90°
θ = 9°,   so A = 6θ = 54° and B = 4θ = 36°
```

**Sum-to-product formula** (Abramson, 2021, Section 9.4; Mathispower4u, 2010e):

```
cos A - cos B = -2 sin[(A + B)/2] sin[(A - B)/2]
```

Substituting A = 6θ and B = 4θ:

```
cos 6θ - cos 4θ = -2 sin[(6θ + 4θ)/2] sin[(6θ - 4θ)/2]
                = -2 sin 5θ sin θ
```

With θ = 9°, 5θ = 45° and sin 45° = √2/2:

```
cos A - cos B = -2 sin 45° sin 9°
              = -2 (√2/2) sin 9°
              = -√2 sin 9°
              ≈ -1.4142 × 0.1564
              ≈ -0.2212
```

**cos A - cos B = -2 sin 5θ sin θ = -√2 sin 9° ≈ -0.2212.** Check directly:
cos 54° - cos 36° ≈ 0.5878 - 0.8090 = -0.2212.

### (ii) sin A cos C as a Sum

**Using the triangle.** The right angle is at B, so:

```
A + C = 90°
6θ + 3θ = 90°
9θ = 90°
θ = 10°,   so A = 6θ = 60° and C = 3θ = 30°
```

**Product-to-sum formula** (Abramson, 2021, Section 9.4):

```
sin A cos C = ½[sin(A + C) + sin(A - C)]
```

Substituting A = 6θ and C = 3θ:

```
sin 6θ cos 3θ = ½[sin(6θ + 3θ) + sin(6θ - 3θ)]
              = ½[sin 9θ + sin 3θ]
```

With θ = 10°, 9θ = 90° and 3θ = 30°:

```
sin A cos C = ½[sin 90° + sin 30°]
            = ½[1 + ½]
            = ½ × 3/2
            = 3/4
```

**sin A cos C = ½(sin 9θ + sin 3θ) = ½(sin 90° + sin 30°) = 3/4.** Check directly:
sin 60° cos 30° = (√3/2)(√3/2) = 3/4.

## Task 4: Writing a Double-Angle Expression in Terms of tan θ

Simplify (tan 2θ / cos 2θ)(1 - sin 2θ) in terms of tan θ. Let t = tan θ.

**Step 1: The three double-angle functions in terms of tan θ** (Abramson, 2021, Section 9.3;
Mathispower4u, 2019). Each comes from a double-angle formula, dividing by
cos²θ and using sec²θ = 1 + tan²θ:

```
tan 2θ = 2 tan θ / (1 - tan²θ)                                    = 2t / (1 - t²)

sin 2θ = 2 sin θ cos θ = (2 sin θ cos θ / cos²θ) × cos²θ
       = 2 tan θ / sec²θ                                          = 2t / (1 + t²)

cos 2θ = cos²θ - sin²θ = ((cos²θ - sin²θ) / cos²θ) × cos²θ
       = (1 - tan²θ) / sec²θ                                      = (1 - t²) / (1 + t²)
```

**Step 2: Divide tan 2θ by cos 2θ.**

```
tan 2θ / cos 2θ = [2t / (1 - t²)] ÷ [(1 - t²) / (1 + t²)]
                = [2t / (1 - t²)] × [(1 + t²) / (1 - t²)]
                = 2t(1 + t²) / (1 - t²)²
```

**Step 3: Write 1 - sin 2θ over a common denominator.** The numerator is a perfect square:

```
1 - sin 2θ = 1 - 2t / (1 + t²)
           = (1 + t² - 2t) / (1 + t²)
           = (1 - t)² / (1 + t²)
```

**Step 4: Multiply and cancel.** The factor (1 + t²) cancels, and 1 - t² = (1 - t)(1 + t) is a
difference of squares:

```
(tan 2θ / cos 2θ)(1 - sin 2θ) = [2t(1 + t²) / (1 - t²)²] × [(1 - t)² / (1 + t²)]
                              = 2t(1 - t)² / (1 - t²)²
                              = 2t(1 - t)² / [(1 - t)²(1 + t)²]
                              = 2t / (1 + t)²
```

**Result: (tan 2θ / cos 2θ)(1 - sin 2θ) = 2 tan θ / (1 + tan θ)²**, valid wherever the original
expression is defined, that is, cos θ ≠ 0 and tan θ ≠ ±1 (so that tan 2θ exists and cos 2θ ≠ 0).

**Check at θ = 30°**, where tan θ = 1/√3 ≈ 0.5774:

```
Original:  (tan 60° / cos 60°)(1 - sin 60°) = (√3 / ½)(1 - √3/2) = 2√3 - 3 ≈ 0.4641
Result:    2(0.5774) / (1.5774)² = 1.1547 / 2.4882 ≈ 0.4641
```

Both sides agree.

## Summary of Answers

**Table 5**

*Final Answers*

| Task | Answer |
|---|---|
| 1 (i) | tan 2θ = -24/7 |
| 1 (ii) | Graphs in Figure 1: tan 2θ has period π/2, tan θ has period π |
| 1 (iii) | tan 4θ = 336/527 |
| 1 (iv) | sin(A + B) = 4/5 |
| 1 (v) | cos(θ/2) = 2√5/5 |
| 1 (vi) | sin(α/2) = √10/10 |
| 2 (i) | 3(x - 1)(x - 3) |
| 2 (ii) | 3(sin θ - 1)(sin θ - 3) |
| 2 (iii) | θ = π/2 (first rotation), θ = 5π/2 (second rotation) |
| 3 (i) | cos A - cos B = -2 sin 5θ sin θ = -√2 sin 9° ≈ -0.2212 |
| 3 (ii) | sin A cos C = ½(sin 9θ + sin 3θ) = 3/4 |
| 4 | 2 tan θ / (1 + tan θ)² |

## References

Abramson, J. (2021). *Algebra and trigonometry* (2nd ed.). OpenStax.
https://openstax.org/details/books/algebra-and-trigonometry-2e

Mathispower4u. (2010a, May 21). *Half angle identities* [Video]. YouTube.
https://www.youtube.com/watch?v=Rp61qiglwfg

Mathispower4u. (2010b, June 4). *Solving trigonometric equations I* [Video]. YouTube.
https://www.youtube.com/watch?v=26EWKD2Xha4

Mathispower4u. (2010c, May 21). *Sum and difference identities for cosine* [Video]. YouTube.
https://www.youtube.com/watch?v=H-0jQTzfkWQ

Mathispower4u. (2010d, May 21). *Sum and difference identities for sine* [Video]. YouTube.
https://www.youtube.com/watch?v=hiNDDQyee2E

Mathispower4u. (2010e, May 21). *Sum to product and product to sum identities* [Video]. YouTube.
https://www.youtube.com/watch?v=ps4Z01gFOpM

Mathispower4u. (2019, November 11). *Trigonometric double angle identities* [Video]. YouTube.
https://www.youtube.com/watch?v=4NznoskozDY

Yoshiwara, K. (2023). *Trigonometry*. American Institute of Mathematics.
https://yoshiwarabooks.org/trig/Sum-and-Difference-Formulas.html
