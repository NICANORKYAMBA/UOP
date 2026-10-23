# MATH 1201 Unit 8: Systems of Equations

Learning notes by Nicanor Maswili. Due: discussion post Sunday Oct 25 (final Oct 28), peer
replies Wednesday Oct 28, assignment Oct 28, 2026. This is the last unit before the final exam.

## Learning Objectives

1. Solve systems of linear and nonlinear equations.
2. Identify the nature of systems of linear equations.
3. Interpret the graphs of linear and nonlinear equations.

## The Nature of a Linear System (OpenStax 11.1 and 11.2)

| Type | Solutions | Graph (two variables) | Elimination ends with |
|---|---|---|---|
| Consistent, independent | Exactly one | Lines cross at one point | A value for every variable |
| Consistent, dependent | Infinitely many | Same line | A true statement, 0 = 0 |
| Inconsistent | None | Parallel lines | A false statement, e.g. 0 = 3 |

Quick test for two lines: different slopes means independent; same slope and same intercept
means dependent; same slope and different intercept means inconsistent.

## Methods

- **Substitution:** solve one equation for a variable and substitute into the other. This is
  best when a variable has coefficient 1, and is the standard method for line plus curve
  systems.
- **Elimination (addition):** multiply equations so one variable cancels when added.
- **Gaussian elimination (11.6):** use an augmented matrix and **row operations only** (swap rows,
  multiply a row by a nonzero number, add a multiple of one row to another) to reach row-echelon
  form, then back-substitute.
- **Nonlinear systems (11.3):** a line and a parabola or circle meet in 0, 1, or 2 points.
  Substitute the line into the curve to get a quadratic; its discriminant tells you how many
  points there are.

## Reading Questions

1. **Nature of linear and nonlinear systems:** linear systems have exactly one, no, or
   infinitely many solutions. Nonlinear systems can have any finite number of solutions (for
   example 0, 1, 2, or 4 for two conics) because curves can cross several times.
2. **Methods:** graphing, substitution, elimination, and Gaussian elimination with matrices.
   Nonlinear systems mostly use substitution or elimination of a squared term.
3. **How I solve them:** reduce to one variable, solve, back-substitute, then check every
   solution in every original equation and confirm on a graph.

## This Week's Work

- **Discussion:** the four types with examples: x + y = 5 with x - y = 1 gives (3, 2);
  x + y = 5 with 2x + 2y = 10 gives infinitely many solutions; x + y = 5 with x + y = 2 gives
  none.
- **Assignment Task 1:** dependent system (equation 3 = 5 × equation 1). The special toy is
  $23.75; the other two together are $1.25.
- **Task 2:** x = 1/2, y = -7/2, z = 0.
- **Task 3:** (3, 1) and (-1/3, 13/3), where the line meets the hyperbola y = x/2 - 3/(2x).

## Self-Quiz Unit 8

| Q | Answer | Why |
|---|---|---|
| 1 | (2,0)(-2,0) | Subtracting gives 3y² = 0, so y = 0 and x = ±2 |
| 2 | False | Gaussian elimination uses row operations, not column operations |
| 3 | False | 6x + 4y = 10 is parallel to 3x + 2y = 7 (2 × 7 = 14 ≠ 10), so the system is inconsistent |
| 4 | True | Substitution gives at most a quadratic, so at most 2 points |
| 5 | It has a unique solution and intersect at a point | Definition of an independent system |
