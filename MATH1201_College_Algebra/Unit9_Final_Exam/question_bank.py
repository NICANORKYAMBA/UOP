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

UNIT_NAMES = {
    1: "Functions I", 2: "Functions II", 3: "Linear and Quadratic Functions",
    4: "Polynomial and Rational Functions", 5: "Exponential and Logarithmic Functions",
    6: "Trigonometry I", 7: "Trigonometry II (Identities)", 8: "Systems of Equations",
    9: "Graded Quiz Unit 3 (real questions)",
}

if __name__ == "__main__":
    assert len(QUESTIONS) == 48
    for unit in range(1, 9):
        assert sum(1 for q in QUESTIONS if q[0] == unit) == 6
    for q in QUESTIONS:
        assert len(q[2]) == 4 and 0 <= q[3] < 4 and len(set(q[2])) == 4, q[1]
    counts = [sum(1 for q in QUESTIONS if q[3] == i) for i in range(4)]
    print("48 questions OK; correct answers by position A-D:", counts)
