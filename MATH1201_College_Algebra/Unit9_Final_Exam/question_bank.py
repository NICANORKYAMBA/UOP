"""
MATH 1201 final exam practice bank: 48 multiple-choice questions, 6 per unit.

Each entry: (unit, question, [four options], index of the correct option, worked explanation).
Every computed answer was checked with sympy (see verify step in the session log).
"""

QUESTIONS = [
    # ---------------- Unit 1: Functions I ----------------
    (1, "Which set of ordered pairs represents a function?",
     ["{(1, 2), (2, 4), (3, 6)}", "{(1, 2), (1, 3), (2, 4)}", "{(0, 1), (0, -1)}", "{(2, 2), (2, 3), (3, 3)}"], 0,
     "A function gives each input exactly one output. Only the first set never repeats an x-value."),
    (1, "What is the domain of f(x) = √(x - 3)?",
     ["(-∞, ∞)", "[3, ∞)", "(3, ∞)", "[0, ∞)"], 1,
     "The inside of a square root must be at least 0: x - 3 ≥ 0, so x ≥ 3, written [3, ∞)."),
    (1, "If f(x) = 2x² - 3x + 1, what is f(-2)?",
     ["3", "-1", "15", "11"], 2,
     "f(-2) = 2(4) - 3(-2) + 1 = 8 + 6 + 1 = 15. Watch the signs: -3 times -2 is +6."),
    (1, "What is the average rate of change of f(x) = x² from x = 1 to x = 4?",
     ["3", "5", "15", "4"], 1,
     "Average rate of change = [f(4) - f(1)] / (4 - 1) = (16 - 1) / 3 = 15 / 3 = 5."),
    (1, "f(x) = x + 2 when x < 0, and f(x) = x² when x ≥ 0. What is f(-3) + f(3)?",
     ["8", "10", "-1", "18"], 0,
     "f(-3) uses the first rule: -3 + 2 = -1. f(3) uses the second rule: 3² = 9. Sum: -1 + 9 = 8."),
    (1, "What is the domain of f(x) = 1 / (x² - 9)?",
     ["All real numbers", "x ≠ 9", "x ≠ 3 and x ≠ -3", "x > 3"], 2,
     "The denominator cannot be 0: x² - 9 = 0 when x = 3 or x = -3, so those two values are excluded."),

    # ---------------- Unit 2: Functions II ----------------
    (2, "If f(x) = x + 1 and g(x) = x², what is (f ∘ g)(x)?",
     ["(x + 1)²", "x² + 1", "x³ + x²", "x² + 2x + 1"], 1,
     "(f ∘ g)(x) = f(g(x)) = f(x²) = x² + 1. Work from the inside out: apply g first, then f."),
    (2, "With f(x) = x + 1 and g(x) = x², what is (g ∘ f)(2)?",
     ["5", "9", "6", "4"], 1,
     "(g ∘ f)(2) = g(f(2)) = g(3) = 9. Note that (f ∘ g)(2) = 5, so composition order matters."),
    (2, "What is the inverse of f(x) = (2x - 5) / 3?",
     ["f⁻¹(x) = (3x + 5) / 2", "f⁻¹(x) = (3x - 5) / 2", "f⁻¹(x) = 3 / (2x - 5)", "f⁻¹(x) = (2x + 5) / 3"], 0,
     "Write y = (2x - 5)/3, swap x and y: x = (2y - 5)/3. Then 3x = 2y - 5, 2y = 3x + 5, y = (3x + 5)/2."),
    (2, "Compared with the graph of f(x), the graph of g(x) = f(x - 2) + 3 is:",
     ["shifted left 2 and up 3", "shifted right 2 and up 3", "shifted right 2 and down 3", "shifted left 2 and down 3"], 1,
     "Inside the brackets the shift is opposite to the sign: x - 2 means right 2. Outside, + 3 means up 3."),
    (2, "Which function is even?",
     ["f(x) = x³ + x", "f(x) = x⁴ - 3x²", "f(x) = x + 1", "f(x) = 2x"], 1,
     "Even means f(-x) = f(x). (-x)⁴ - 3(-x)² = x⁴ - 3x², unchanged. Its graph is symmetric about the y-axis."),
    (2, "The graph of y = -f(x) is the graph of y = f(x):",
     ["reflected about the y-axis", "reflected about the x-axis", "shifted down 1", "unchanged"], 1,
     "Multiplying the output by -1 flips every point (x, y) to (x, -y): a reflection about the x-axis. "
     "Reflection about the y-axis is f(-x)."),

    # ---------------- Unit 3: Linear and quadratic ----------------
    (3, "What is the slope of the line through (2, -1) and (6, 7)?",
     ["1/2", "2", "-2", "8"], 1,
     "m = (y₂ - y₁)/(x₂ - x₁) = (7 - (-1))/(6 - 2) = 8/4 = 2."),
    (3, "What is the slope of a line perpendicular to y = 3x + 1?",
     ["3", "-3", "1/3", "-1/3"], 3,
     "Perpendicular slopes are negative reciprocals: m₁ × m₂ = -1, so m₂ = -1/3."),
    (3, "What is the vertex of f(x) = 2x² - 8x + 3?",
     ["(2, -5)", "(-2, 27)", "(4, 3)", "(2, 3)"], 0,
     "x = -b/(2a) = 8/4 = 2. f(2) = 2(4) - 16 + 3 = -5. Vertex (2, -5), a minimum because a > 0."),
    (3, "What are the solutions of x² - 5x + 6 = 0?",
     ["x = -2, -3", "x = 2, 3", "x = 1, 6", "x = -1, 6"], 1,
     "Factor: two numbers that multiply to 6 and add to -5 are -2 and -3, so (x - 2)(x - 3) = 0, x = 2 or 3."),
    (3, "A ball's height is h(t) = -5t² + 20t + 1 metres. What is its maximum height?",
     ["20 m", "21 m", "1 m", "41 m"], 1,
     "Peak at t = -b/(2a) = -20/(-10) = 2 s. h(2) = -20 + 40 + 1 = 21 m."),
    (3, "How many real solutions does 2x² + 3x + 5 = 0 have?",
     ["Two", "One", "None", "Infinitely many"], 2,
     "Discriminant b² - 4ac = 9 - 40 = -31 < 0, so there are no real solutions (the parabola misses the x-axis)."),

    # ---------------- Unit 4: Polynomials and rational functions ----------------
    (4, "What is the end behaviour of f(x) = -3x⁵ + 2x² - 1?",
     ["Up on the left, down on the right", "Down on both ends", "Up on both ends", "Down on the left, up on the right"], 0,
     "Only the leading term -3x⁵ matters: odd degree, negative coefficient, so it rises on the left and falls on the right."),
    (4, "What is the remainder when x³ - 2x² + 4 is divided by (x - 3)?",
     ["13", "4", "-5", "31"], 0,
     "Remainder Theorem: the remainder is f(3) = 27 - 18 + 4 = 13."),
    (4, "What is the horizontal asymptote of f(x) = (3x² + 1) / (x² - 4)?",
     ["y = 0", "y = 3", "y = 1/4", "None"], 1,
     "Same degree on top and bottom, so y = (leading coefficient on top)/(leading coefficient on bottom) = 3/1 = 3."),
    (4, "f(x) = (x² - 1) / (x - 1) has, at x = 1:",
     ["a vertical asymptote", "a hole", "a zero", "a horizontal asymptote"], 1,
     "x² - 1 = (x - 1)(x + 1). The factor (x - 1) cancels, so x = 1 is a hole, not an asymptote."),
    (4, "What is the greatest number of turning points a degree-6 polynomial can have?",
     ["6", "7", "5", "3"], 2,
     "A polynomial of degree n has at most n - 1 turning points: 6 - 1 = 5."),
    (4, "At a zero of multiplicity 2, the graph of a polynomial:",
     ["crosses the x-axis", "touches the x-axis and turns back", "has a vertical asymptote", "has a hole"], 1,
     "Even multiplicity: the graph touches and bounces. Odd multiplicity: it crosses."),

    # ---------------- Unit 5: Exponential and logarithmic ----------------
    (5, "Solve 3ˣ = 81.",
     ["x = 27", "x = 3", "x = 4", "x = 9"], 2,
     "81 = 3⁴, so 3ˣ = 3⁴ and x = 4."),
    (5, "What is log₂ 32?",
     ["16", "5", "4", "6"], 1,
     "log₂ 32 asks: 2 to what power is 32? 2⁵ = 32, so the answer is 5."),
    (5, "Which is the expanded form of log(x²y / z)?",
     ["2 log x + log y - log z", "log 2x + log y - log z", "2 log x · log y / log z", "2 log(xy) - log z"], 0,
     "Product rule adds, quotient rule subtracts, power rule brings exponents down: log x² + log y - log z = 2 log x + log y - log z."),
    (5, "Solve ln x = 2.",
     ["x = 2e", "x = e² ≈ 7.389", "x = ln 2", "x = 100"], 1,
     "ln x = 2 means e² = x, so x = e² ≈ 7.389. (log x = 2 would give 100.)"),
    (5, "$1000 is invested at 5% interest compounded annually. What is it worth after 3 years?",
     ["$1150.00", "$1157.63", "$1050.00", "$1161.83"], 1,
     "A = P(1 + r)ᵗ = 1000(1.05)³ = 1000 × 1.157625 = $1157.63. ($1150 would be simple interest.)"),
    (5, "What is the domain of f(x) = log(x - 4)?",
     ["(-∞, ∞)", "[4, ∞)", "(4, ∞)", "(0, ∞)"], 2,
     "The input of a log must be greater than 0: x - 4 > 0, so x > 4, written (4, ∞) with a round bracket."),

    # ---------------- Unit 6: Trigonometry I ----------------
    (6, "Convert 150° to radians.",
     ["5π/6", "3π/4", "2π/3", "5π/3"], 0,
     "Multiply by π/180: 150 × π/180 = 15π/18 = 5π/6."),
    (6, "What is the exact value of cos(5π/6)?",
     ["√3/2", "-√3/2", "1/2", "-1/2"], 1,
     "5π/6 = 150° is in Quadrant II, where cosine is negative. Reference angle 30°: cos 30° = √3/2, so cos(5π/6) = -√3/2."),
    (6, "What is the reference angle of 225°?",
     ["45°", "135°", "25°", "75°"], 0,
     "225° is in Quadrant III: reference angle = 225° - 180° = 45°."),
    (6, "What are the amplitude and period of y = 3 sin(2x)?",
     ["Amplitude 2, period 3π", "Amplitude 3, period π", "Amplitude 3, period 2π", "Amplitude 6, period π"], 1,
     "Amplitude = |A| = 3. Period = 2π/|B| = 2π/2 = π."),
    (6, "In a right triangle, the side opposite θ is 5 and the hypotenuse is 13. What is cos θ?",
     ["5/13", "12/13", "5/12", "13/12"], 1,
     "Adjacent = √(13² - 5²) = √144 = 12. cos θ = adjacent/hypotenuse = 12/13."),
    (6, "What is arcsin(1/2)?",
     ["π/3", "π/6", "5π/6", "π/4"], 1,
     "arcsin returns an angle in [-π/2, π/2] whose sine is 1/2: that is π/6 (30°). 5π/6 also has sine 1/2 but is outside the range."),

    # ---------------- Unit 7: Trigonometry II ----------------
    (7, "What is the exact value of sin 75°?",
     ["(√6 + √2)/4", "(√6 - √2)/4", "√3/2", "(√3 + 1)/2"], 0,
     "sin(45° + 30°) = sin45 cos30 + cos45 sin30 = (√2/2)(√3/2) + (√2/2)(1/2) = (√6 + √2)/4."),
    (7, "If sin θ = 3/5, what is cos 2θ?",
     ["24/25", "7/25", "-7/25", "9/25"], 1,
     "Use cos 2θ = 1 - 2 sin²θ = 1 - 2(9/25) = 1 - 18/25 = 7/25. No quadrant information is needed for this form."),
    (7, "Simplify (1 - cos²x) / sin x.",
     ["cos x", "sin x", "tan x", "1"], 1,
     "By the Pythagorean identity, 1 - cos²x = sin²x, and sin²x / sin x = sin x."),
    (7, "Solve 2 sin x - 1 = 0 for 0 ≤ x < 2π.",
     ["x = π/6 only", "x = π/6, 5π/6", "x = π/3, 2π/3", "x = π/6, 7π/6"], 1,
     "sin x = 1/2. Sine is positive in Quadrants I and II: x = π/6 and π - π/6 = 5π/6."),
    (7, "If tan θ = 1/2, what is tan 2θ?",
     ["1", "4/3", "3/4", "1/4"], 1,
     "tan 2θ = 2 tan θ / (1 - tan²θ) = 1 / (1 - 1/4) = 1 / (3/4) = 4/3."),
    (7, "Which expression equals cos²x - sin²x?",
     ["sin 2x", "cos 2x", "1", "2 cos x"], 1,
     "This is the double-angle identity cos 2x = cos²x - sin²x (also 2cos²x - 1 and 1 - 2sin²x)."),

    # ---------------- Unit 8: Systems of equations ----------------
    (8, "Solve: x + y = 10 and x - y = 2.",
     ["(4, 6)", "(6, 4)", "(5, 5)", "(8, 2)"], 1,
     "Add the equations: 2x = 12, x = 6. Then y = 10 - 6 = 4. Check: 6 - 4 = 2."),
    (8, "The system 2x + 4y = 8 and x + 2y = 4 is:",
     ["consistent and independent", "inconsistent", "consistent and dependent", "has exactly two solutions"], 2,
     "The first equation is 2 times the second, so both are the same line: infinitely many solutions (dependent)."),
    (8, "The system x + y = 3 and x + y = 7 is:",
     ["consistent and independent", "inconsistent", "consistent and dependent", "has one solution (5, 2)"], 1,
     "Subtracting gives 0 = 4, a contradiction. The lines are parallel, so there is no solution."),
    (8, "Where does the circle x² + y² = 25 meet the line y = x + 1?",
     ["(3, 4) and (-4, -3)", "(4, 3) and (-3, -4)", "(0, 5) and (5, 0)", "They do not meet"], 0,
     "Substitute: x² + (x + 1)² = 25, so 2x² + 2x - 24 = 0, x² + x - 12 = 0, (x + 4)(x - 3) = 0. "
     "x = 3 gives y = 4; x = -4 gives y = -3."),
    (8, "Which is NOT an allowed row operation in Gaussian elimination?",
     ["Swap two rows", "Multiply a row by a nonzero number", "Add a multiple of one row to another", "Multiply a row by 0"], 3,
     "Multiplying a row by 0 destroys an equation. The three allowed operations keep the solution set the same."),
    (8, "Solve x + y + z = 6, y + z = 5, z = 3 by back-substitution.",
     ["(1, 2, 3)", "(3, 2, 1)", "(2, 1, 3)", "(1, 3, 2)"], 0,
     "z = 3. Then y = 5 - 3 = 2. Then x = 6 - 2 - 3 = 1. Answer (1, 2, 3)."),
]

# Real questions from Graded Quiz Unit 3 (closed and graded), kept in their original option order.
# Unit number 9 groups them as their own practice set.
GRADED_QUIZ_3 = [
    (9, "If f(x) = 3x⁵ and g(x) = (x - 1)/x², what is g(f(x))?",
     ["(3x⁵ - 1)/(18x¹⁰)", "(3x⁵ - 1)/(6x⁷)", "(3x⁵ - 1)/(9x¹⁰)", "(3x⁵ - 1)/(18x⁷)"], 2,
     "Put f(x) = 3x⁵ in place of x in g: (3x⁵ - 1)/(3x⁵)². The denominator is 3² · (x⁵)² = 9x¹⁰."),
    (9, "f(x) = √(x + 3). What is the range of the inverse function f⁻¹(x)?",
     ["(-∞, -3]", "ℝ (all real numbers)", "(-∞, -3) ∪ (-3, ∞)", "[-3, ∞)"], 3,
     "The range of f⁻¹ equals the domain of f. For √(x + 3) we need x + 3 ≥ 0, so x ≥ -3: [-3, ∞)."),
    (9, "The inverse of f(x) = x⁴ + 50 is:",
     ["(x - 50)^(1/4)", "(50 + x)^(1/4)", "(x + 50)^(1/4)", "(50 - x)^(1/4)"], 0,
     "YOU MISSED THIS ONE. Swap x and y: x = y⁴ + 50. Undo the + 50 first by SUBTRACTING: y⁴ = x - 50. "
     "Then take the fourth root: y = (x - 50)^(1/4). The inverse undoes each step in reverse order with the "
     "opposite operation, so + 50 becomes - 50."),
    (9, "y = √(x + 2) with domain (-∞, ∞) and codomain [0, ∞). This relation is a function.",
     ["True", "False"], 1,
     "False. A function must give an output for EVERY input in its domain, but √(x + 2) has no real value "
     "for x < -2 (e.g. x = -3). With domain [-2, ∞) it would be a function."),
    (9, "f(x) = √(3x - 2). Which gives the domain and range?",
     ["Domain (-∞, ∞); Range [0, ∞)", "Domain [2/3, ∞); Range (-∞, ∞)", "Domain (-∞, ∞); Range (-∞, ∞)",
      "Domain [2/3, ∞); Range [0, ∞)"], 3,
     "3x - 2 ≥ 0 gives x ≥ 2/3. A square root is never negative, so the range is [0, ∞)."),
    (9, "{(1, 3), (2, 4), (3, 6), (4, 8), (5, 10)} with domain {1, 2, 3, 4, 5} and codomain "
        "{3, 4, 5, 6, 7, 8, 9, 10} is a function.",
     ["True", "False"], 0,
     "True. Every domain value has exactly one output, and every output is in the codomain. The codomain "
     "may contain extra values (5, 7, 9) that are never used."),
    (9, "A city of 100,000 grows by 2,000 people per year. Which equation gives the population P after t years?",
     ["P = 100,000t + 2,000", "P = 2,000t + 100,000", "P = 2,000t - 100,000", "P = 100,000 - 2,000"], 1,
     "Linear model P = (rate)t + (starting value): the slope is 2,000 per year, the intercept is 100,000."),
    (9, "g(x) = 3x - 10. What is the domain of g⁻¹(x)?",
     ["(-∞, 10/3] ∪ [10/3, ∞)", "(-∞, 10/3) ∪ (10/3, ∞)", "(10/3, ∞)", "[-10/3, ∞)"], 0,
     "YOU MISSED THIS ONE. g is a line, so its inverse g⁻¹(x) = (x + 10)/3 is also a line, defined for ALL real "
     "numbers. The marked answer (-∞, 10/3] ∪ [10/3, ∞) is just an unusual way of writing all real numbers, "
     "because 10/3 is included in both pieces. The option you picked leaves out 10/3, which only happens "
     "when a denominator is zero, and there is no denominator here. Rule: domain of g⁻¹ = range of g."),
    (9, "What is the standard form of a quadratic equation (course key)?",
     ["y = eˣ", "y = a(x - h)² + k", "y = mx + b", "ax² + bx + c = 0"], 1,
     "TRAP: in our textbook (Abramson, Section 5.1), the STANDARD form of a quadratic function is "
     "f(x) = a(x - h)² + k (the vertex form), and ax² + bx + c is called the GENERAL form. Many other books "
     "call ax² + bx + c the standard form, which is why the instructor accepted both answers here. "
     "On this course's exam, read 'standard form' as a(x - h)² + k."),
    (9, "f(x) = √(10 - x)/(x + 11). What is the domain of f?",
     ["(-11, 10]", "(-∞, 10) ∪ (10, 11)", "(-∞, -11) ∪ (-11, 10]", "[-11, 10) ∪ (10, ∞)"], 2,
     "Two rules: under the root 10 - x ≥ 0, so x ≤ 10 (10 included); the denominator x + 11 ≠ 0, so x ≠ -11. "
     "Together: (-∞, -11) ∪ (-11, 10]."),
    (9, "Which quadratic equation has exactly one real solution?",
     ["x² + 32x + 256 = 0", "x² - 5x - 14 = 0", "x² - 2x - 10 = 0", "x² + 4x - 12 = 0"], 0,
     "One real solution means the discriminant b² - 4ac = 0: 32² - 4(256) = 1024 - 1024 = 0. "
     "It is a perfect square, (x + 16)² = 0."),
    (9, "Which polynomial function can model the height of a ball thrown into the air?",
     ["y = x⁵", "y = x²", "y = x⁴", "y = x³"], 1,
     "A thrown ball follows a parabola, which is a quadratic (degree 2) function."),
    (9, "f(x) = 10x, g(x) = x², h(x) = x³. Simplify (f ∘ g ∘ h)(x).",
     ["10x⁶", "100x⁵", "10x⁵", "100x⁶"], 0,
     "Work from the inside out: h(x) = x³, then g(x³) = (x³)² = x⁶, then f(x⁶) = 10x⁶."),
    (9, "f(x) = log₂(x - 2). Which gives the domain and range?",
     ["Domain [2, ∞); Range (-∞, 0)", "Domain (2, ∞); Range (-∞, ∞)", "Domain (2, ∞); Range (-∞, 0)",
      "Domain (-∞, 2); Range (-∞, ∞)"], 1,
     "The inside of a log must be > 0: x - 2 > 0, so x > 2 with a ROUND bracket. A log takes every real value."),
    (9, "Which is a quadratic equation in the variable x?",
     ["y = x² + 2x + 1", "y² = x²", "y = y² + 2x + 1", "x³ + 2x + 1 = 0"], 0,
     "Quadratic in x means the highest power of x is 2, with y as the output: y = x² + 2x + 1."),
]

# Real questions from Graded Quiz Unit 6 (closed and graded), kept in their original option order.
GRADED_QUIZ_6 = [
    (10, "Which is an example of a polynomial function used to model a real-world situation?",
     ["f(x) = 1/x", "f(x) = 3x² - 5x + 2", "f(x) = √x", "f(x) = eˣ"], 1,
     "A polynomial uses only whole-number powers of x. 1/x = x⁻¹, √x = x^(1/2), and eˣ has x in the exponent."),
    (10, "What is the phase shift of 23 sin(7x + 3) - 7?",
     ["-3/7", "-7/3", "7/3", "3/7"], 0,
     "Factor B out: 7x + 3 = 7(x + 3/7). The graph moves 3/7 to the LEFT, a phase shift of -3/7 "
     "(set 7x + 3 = 0, x = -3/7)."),
    (10, "Convert 7 radians to degrees.",
     ["401°", "2520°", "14°", "808°"], 0,
     "Multiply by 180/π: 7 × 180/π ≈ 401.07°. (7 × 360 = 2520 is the trap.)"),
    (10, "$25,000 earns 8% compounded annually. How much is there after 3 years?",
     ["$31492.8", "$31692.8", "$31392.8", "$31592.8"], 0,
     "A = P(1 + r)ᵗ = 25000(1.08)³ = 25000 × 1.259712 = $31,492.80."),
    (10, "How many intercepts and turning points can 20x¹⁰ + 6x⁹ - 3x⁵ - 10x⁴ have (at most)?",
     ["6, 5", "5, 6", "9, 10", "10, 9"], 3,
     "Degree 10: at most 10 x-intercepts and at most 10 - 1 = 9 turning points."),
    (10, "What are the domain and range of log(4x + 5)?",
     ["(-∞, ∞), (-∞, ∞)", "(0, ∞), (-∞, ∞)", "(-5/4, ∞), (-∞, ∞)", "(5/4, ∞), (0, ∞)"], 2,
     "4x + 5 > 0 gives x > -5/4. Every log takes all real values, so the range is (-∞, ∞)."),
    (10, "A picture shows a straight line and a U-shaped curve drawn together on the same axes; the U-shaped "
         "curve stops at the top instead of continuing. True or false: this graph can be a polynomial of "
         "degree 2 or more.",
     ["True", "False"], 1,
     "YOU MISSED THIS ONE. The key is False. A polynomial's graph is ONE smooth, unbroken curve that passes "
     "the vertical line test and continues forever to the left and right. This picture has two separate "
     "graphs (a vertical line would cross both the line and the U-curve), and the U-curve is cut off, so "
     "as drawn it is not the graph of a single polynomial. Lesson: before calling a graph a polynomial, "
     "check it is one smooth curve, passes the vertical line test, and has no breaks, corners, or flat pieces."),
    (10, "What does the 10 in 20(10ˣ) determine?",
     ["x-intercept", "y-intercept", "rate of growth or decay", "slope of the tangent line"], 2,
     "In a·bˣ, b is the growth factor. The 20 is the starting value (the y-intercept)."),
    (10, "After 3 years at 6% compounded annually, an account holds $8,000. What was the principal?",
     ["$6000", "$6800", "$6,720", "$5550"], 2,
     "Work backwards: P = 8000 / 1.06³ = 8000 / 1.191016 ≈ $6,716.95, closest to $6,720."),
    (10, "Solve 5 = 6(2ˣ) + 4.",
     ["-2.5849", "2.5849", "0.3868", "-0.3868"], 0,
     "Subtract 4: 1 = 6(2ˣ). Divide by 6: 2ˣ = 1/6. Take logs: x = log(1/6)/log 2 ≈ -2.5849 "
     "(negative because 1/6 < 1)."),
    (10, "25 log₁₀₀ x + 25 compared with log₁₀₀ x is a vertical compression by 25.",
     ["True", "False"], 1,
     "False. Multiplying by 25 is a vertical STRETCH by 25 (the + 25 shifts it up). A compression needs a "
     "factor between 0 and 1."),
    (10, "The angle of elevation to the top of a 20 m tree is 60°. About how far is the observer from the tree?",
     ["34.6 meters", "20 meters", "11.54 meters", "40 meters"], 2,
     "tan 60° = opposite/adjacent = 20/d, so d = 20/tan 60° = 20/√3 ≈ 11.54 m. (34.6 = 20 × √3 is the trap.)"),
    (10, "How can the unit circle be used to find trigonometric values for any angle?",
     ["By drawing a right triangle in the circle", "By using a calculator or table of values",
      "By memorizing the values", "By measuring the angle in degrees"], 0,
     "A right triangle drawn from the point (x, y) to the x-axis, with hypotenuse 1, gives cos θ = x and sin θ = y."),
    (10, "Horizontal asymptotes of f(x) = (5x³ - 10)/(10x² - 12x + 20)?",
     ["y = 1/2", "x = 5", "Do not exist", "x = 2"], 2,
     "Top degree 3 is greater than bottom degree 2, so there is no horizontal asymptote (there is a slant one). "
     "Horizontal asymptotes are written y = ..., never x = ...."),
    (10, "What is 1560° equal to (as a coterminal angle in radians)?",
     ["4π/3", "π", "2π/3", "2π"], 2,
     "Remove full turns: 1560° - 4 × 360° = 120°. Then 120 × π/180 = 2π/3."),
]

# Real questions from the Unit 1, 2, and 3 Self-Quizzes, kept in their original option order.
SELF_QUIZZES_1_TO_3 = [
    (11, "Unit 1: If f(x) = 3x + 2 and g(x) = x - 4, what is (f/g)(4)?",
     ["(3, 2, 4)", "undefined", "none of these", "0", "14"], 1,
     "(f/g)(4) = f(4)/g(4) = 14/0. Division by zero is undefined, so 4 is not in the domain of f/g."),
    (11, "Unit 1: Find the range of f(x) = 2 - √(2 - x).",
     ["the empty set", "[-2, ∞)", "(-∞, 2]", "[2, ∞)"], 2,
     "√(2 - x) takes every value from 0 upward, so 2 minus it takes every value from 2 downward: (-∞, 2]."),
    (11, "Unit 1: g(x) = (x - 1)². Find the average rate of change on [-1, 2].",
     ["-2", "-1", "1", "2", "None of the above"], 1,
     "[g(2) - g(-1)] / (2 - (-1)) = (1 - 4) / 3 = -1."),
    (11, "Unit 1: If f(x) = 2x + 1, what is the domain?",
     ["(2, 1]", "[-∞, ∞]", "(1, 2)", "(∞, -∞)", "(-∞, ∞)"], 4,
     "A line accepts every real number: (-∞, ∞). Infinity always takes a ROUND bracket, so [-∞, ∞] is wrong."),
    (11, "Unit 1: Find the range of f(x) = -√(2 - x).",
     ["[2, ∞)", "(-∞, 0]", "[0, ∞)", "[-2, ∞)", "the empty set"], 1,
     "√(2 - x) ≥ 0, and the minus sign flips it to ≤ 0: (-∞, 0]."),
    (11, "Unit 2: Let f(x) = x² - 4 for x < 0. What is f⁻¹?",
     ["-√(x - 4), x > 4", "-√(x - 4)", "-√(x + 4)", "-√(x + 4), x > -4", "None of these"], 3,
     "Swap: x = y² - 4, so y² = x + 4 and y = ±√(x + 4). The original x-values were negative, so the inverse "
     "outputs must be negative: take the minus root. Its domain is the range of f, x > -4."),
    (11, "Unit 2: If f(x) = 2x + 3 and g(x) = x - 5, what is g ∘ f?",
     ["2x - 1", "2x + 2", "2x - 2", "None of these", "2x + 1"], 2,
     "YOU MISSED THIS ONE. g ∘ f means g(f(x)): put the WHOLE f(x) into g. g(2x + 3) = (2x + 3) - 5 = 2x - 2. "
     "The answer 2x + 2 comes from adding instead of subtracting. Always write g(   ) first, then fill the "
     "brackets with f(x)."),
    (11, "Unit 2: For f(x) = √(x + 5) + 2, what is the domain of f⁻¹?",
     ["(-∞, ∞)", "(0, ∞)", "(-∞, 0)", "None of these", "[2, ∞)"], 4,
     "Domain of f⁻¹ = range of f. √(x + 5) ≥ 0, so √(x + 5) + 2 ≥ 2: [2, ∞)."),
    (11, "Unit 2: If f(x) = 2x + 3 and g(x) = x² + x, what is g ∘ f?",
     ["2x² + 2x + 3", "4x² + 14x + 12", "None of these", "x² + 3x + 3", "4x² + 12x + 9"], 1,
     "g(2x + 3) = (2x + 3)² + (2x + 3) = 4x² + 12x + 9 + 2x + 3 = 4x² + 14x + 12."),
    (11, "Unit 2: If f(x) = 2x + 3 and g(x) = x - 5, what is f ∘ g?",
     ["2x - 10", "2x - 7", "2x - 15", "None of these", "2x - 5"], 1,
     "f(g(x)) = f(x - 5) = 2(x - 5) + 3 = 2x - 10 + 3 = 2x - 7. Compare with g ∘ f = 2x - 2: the order matters."),
    (11, "Unit 3: What are the x-intercepts of f(x) = x² - 6?",
     ["(0, -6)", "{6, -6}", "(√6, 0) and (-√6, 0)", "There are no intercepts", "(6, 0) and (-6, 0)"], 2,
     "Set f(x) = 0: x² = 6, x = ±√6. Intercepts are points with y = 0. (0, -6) is the y-intercept."),
    (11, "Unit 3: Where does the line y = 6 meet the parabola y = x² + x for x > 0?",
     ["(-2, 6)", "(-1, 6)", "(1, 6)", "(2, 6)", "None of these"], 3,
     "x² + x = 6, so x² + x - 6 = 0, (x + 3)(x - 2) = 0. With x > 0, x = 2: the point (2, 6)."),
    (11, "Unit 3: What is the equation of the line through (-1, 4) and (-2, 7)?",
     ["y = 3x + 1", "y = -3x + 1", "y = -3x + 7", "y = 3x + 7", "None of these"], 1,
     "Slope = (7 - 4)/(-2 - (-1)) = 3/(-1) = -3. Point-slope: y - 4 = -3(x + 1), so y = -3x + 1."),
    (11, "Unit 3: A frog's jump is modelled by f(x) = -x² + 2x and it lands after 2 seconds. Maximum height?",
     ["2", "0", "1", "None of these.", "The frog jumps into outer space."], 2,
     "The vertex is halfway through the flight: x = -b/(2a) = -2/(-2) = 1, and f(1) = -1 + 2 = 1."),
    (11, "Unit 3: f(x) is a quadratic with vertex (1, -2) that opens up. Which is f?",
     ["x² - 2x - 1", "x² - 2x + 1", "x² + 2x - 1", "x² + 2x + 1", "None of these"], 0,
     "Vertex form (x - 1)² - 2 = x² - 2x + 1 - 2 = x² - 2x - 1."),
]

UNIT_NAMES = {
    1: "Functions I", 2: "Functions II", 3: "Linear and Quadratic Functions",
    4: "Polynomial and Rational Functions", 5: "Exponential and Logarithmic Functions",
    6: "Trigonometry I", 7: "Trigonometry II (Identities)", 8: "Systems of Equations",
    9: "Graded Quiz Unit 3 (real questions)",
    10: "Graded Quiz Unit 6 (real questions)",
    11: "Self-Quizzes Units 1 to 3 (real questions)",
}

if __name__ == "__main__":
    assert len(QUESTIONS) == 48
    for unit in range(1, 9):
        assert sum(1 for q in QUESTIONS if q[0] == unit) == 6
    for q in QUESTIONS:
        assert len(q[2]) == 4 and 0 <= q[3] < 4 and len(set(q[2])) == 4, q[1]
    counts = [sum(1 for q in QUESTIONS if q[3] == i) for i in range(4)]
    print("48 questions OK; correct answers by position A-D:", counts)
