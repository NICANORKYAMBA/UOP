# MATH 1201 Unit 7: Trigonometry II, Additional Trigonometric Concepts

Learning notes by Nicanor Maswili. Assignment due October 21, 2026.

## Learning Objectives

1. Solve trigonometric problems using trigonometric identities.
2. Solve problems using compound, double, and half angles.
3. Solve problems using the sum-to-product and product-to-sum formulas.
4. Solve trigonometric equations.

## Identity Sheet

### Basic (OpenStax 9.1)

| Identity | Formula |
|---|---|
| Reciprocal | csc θ = 1/sin θ, sec θ = 1/cos θ, cot θ = 1/tan θ |
| Quotient | tan θ = sin θ / cos θ, cot θ = cos θ / sin θ |
| Pythagorean | sin²θ + cos²θ = 1, 1 + tan²θ = sec²θ, 1 + cot²θ = csc²θ |
| Even and odd | cos(-θ) = cos θ, sin(-θ) = -sin θ, tan(-θ) = -tan θ |

### Compound Angles (Sum and Difference, OpenStax 9.2, Yoshiwara 8.1)

| Function | Formula |
|---|---|
| sin(A ± B) | sin A cos B ± cos A sin B |
| cos(A ± B) | cos A cos B ∓ sin A sin B (note the sign flips) |
| tan(A ± B) | (tan A ± tan B) / (1 ∓ tan A tan B) |

### Double Angle (OpenStax 9.3)

| Function | Formula |
|---|---|
| sin 2θ | 2 sin θ cos θ = 2 tan θ / (1 + tan²θ) |
| cos 2θ | cos²θ - sin²θ = 2cos²θ - 1 = 1 - 2sin²θ = (1 - tan²θ)/(1 + tan²θ) |
| tan 2θ | 2 tan θ / (1 - tan²θ) |

### Half Angle (OpenStax 9.3)

| Function | Formula |
|---|---|
| sin(θ/2) | ±√[(1 - cos θ)/2] |
| cos(θ/2) | ±√[(1 + cos θ)/2] |
| tan(θ/2) | sin θ / (1 + cos θ) = (1 - cos θ) / sin θ |

The ± sign is chosen by the **quadrant of θ/2**, not of θ.

### Sum to Product and Product to Sum (OpenStax 9.4)

| Sum to product | Product to sum |
|---|---|
| sin A + sin B = 2 sin[(A+B)/2] cos[(A-B)/2] | sin A cos B = ½[sin(A+B) + sin(A-B)] |
| sin A - sin B = 2 cos[(A+B)/2] sin[(A-B)/2] | cos A sin B = ½[sin(A+B) - sin(A-B)] |
| cos A + cos B = 2 cos[(A+B)/2] cos[(A-B)/2] | cos A cos B = ½[cos(A+B) + cos(A-B)] |
| cos A - cos B = -2 sin[(A+B)/2] sin[(A-B)/2] | sin A sin B = ½[cos(A-B) - cos(A+B)] |

## Solving Trigonometric Equations (OpenStax 9.5)

1. Use identities to get one trigonometric function.
2. Treat it like algebra: isolate it, or factor (for example, 3 sin²θ - 12 sin θ + 9 = 0 becomes
   3(sin θ - 1)(sin θ - 3) = 0).
3. Reject impossible values: sin and cos must be between -1 and 1.
4. Find the reference angle, then every angle in one rotation with the right sign (ASTC rule:
   All, Sine, Tangent, Cosine are positive in Quadrants I, II, III, IV).
5. Add multiples of the period (2π for sin and cos, π for tan) to cover the whole interval, one
   rotation at a time.

## Reading Questions

1. **Using identities to solve and simplify:** rewrite everything in sine and cosine (or in one
   function), combine fractions, factor, and cancel. Identities swap a hard form for an
   equivalent easy one.
2. **Compound, double, and half angles:** a compound angle is a sum or difference (A ± B); a
   double angle is the special case A = B (2θ); a half angle comes from solving the cos 2θ
   formula backwards for θ/2.
3. **Solving trigonometric equations:** reduce to one function, solve algebraically, reject
   impossible values, then list all angles in the given interval using the period.

## This Week's Assignment (Answers Verified With sympy)

| Task | Answer |
|---|---|
| 1 (i) tan 2θ | -24/7 |
| 1 (iii) tan 4θ | 336/527 |
| 1 (iv) sin(A+B) | 4/5 |
| 1 (v) cos(θ/2) | 2√5/5 |
| 1 (vi) sin(α/2) | √10/10 |
| 2 | 3(x-1)(x-3); θ = π/2, 5π/2 on [0, 4π] |
| 3 (i) | -2 sin 5θ sin θ = -√2 sin 9° ≈ -0.2212 |
| 3 (ii) | ½(sin 9θ + sin 3θ) = 3/4 |
| 4 | 2 tan θ / (1 + tan θ)² |

## Self-Quiz Unit 7

| Q | Answer | Working |
|---|---|---|
| 1 | tan θ | sec θ · sec θ · cos θ = sec θ; tan θ · cot θ = 1; sec θ · sin θ = tan θ |
| 2 | sin x cos x | csc x tan x = sec x, sec x cot x = csc x; sec x + csc x = (sin x + cos x)/(sin x cos x) |
| 3 | -cos 2x | sin²x - cos²x = -(cos²x - sin²x) = -cos 2x |
| 4 | x = 30°, 330° | 2 cos x = √3, so cos x = √3/2 (Quadrants I and IV) |
| 5 | -tan 6x | (2 sin 6x sin x) / (-2 cos 6x sin x) = -tan 6x |
