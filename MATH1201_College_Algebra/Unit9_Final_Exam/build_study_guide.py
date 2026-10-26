#!/usr/bin/env python3
"""
Builds the MATH 1201 final exam study guide (Markdown) and the data for the practice page
from question_bank.py, so the printed guide and the interactive page always match.

Options are rotated so the correct answer cycles through A, B, C, D evenly.

Usage:  python3 build_study_guide.py
Output: Final_Exam_Study_Guide.md, practice_questions.json
"""

import json
from pathlib import Path

from question_bank import QUESTIONS, UNIT_NAMES

HERE = Path(__file__).resolve().parent
LETTERS = "ABCD"


def balanced(questions):
    """Rotates each question's options so the correct answer lands on position i % 4."""
    out = []
    for i, (unit, text, options, correct, why) in enumerate(questions):
        target = i % 4
        shift = (target - correct) % 4
        rotated = options[-shift:] + options[:-shift] if shift else list(options)
        assert rotated[target] == options[correct]
        out.append({"unit": unit, "q": text, "options": rotated, "answer": target, "why": why})
    return out


FORMULAS = """
## Part 1: Formula Sheet

### Units 1 and 2: Functions

- A **function** gives each input exactly one output (vertical line test). **One-to-one**: each
  output comes from one input (horizontal line test); only one-to-one functions have inverses.
- **Domain** rules: denominator ≠ 0; inside a square root ≥ 0; inside a log > 0.
- **Average rate of change** from a to b: [f(b) - f(a)] / (b - a).
- **Composition**: (f ∘ g)(x) = f(g(x)), apply g first. Usually f ∘ g ≠ g ∘ f.
- **Inverse**: write y = f(x), swap x and y, solve for y. Check f(f⁻¹(x)) = x.
- **Transformations** of y = f(x): f(x) + k up k; f(x - h) right h; -f(x) reflect in x-axis;
  f(-x) reflect in y-axis; a·f(x) vertical stretch (|a| > 1) or compression (|a| < 1).
- **Even**: f(-x) = f(x), symmetric about the y-axis. **Odd**: f(-x) = -f(x), symmetric about
  the origin.

### Unit 3: Linear and Quadratic

- Slope m = (y₂ - y₁)/(x₂ - x₁). Point-slope: y - y₁ = m(x - x₁). Slope-intercept: y = mx + b.
- Parallel: equal slopes. Perpendicular: m₁ · m₂ = -1.
- Quadratic f(x) = ax² + bx + c: vertex x = -b/(2a); opens up if a > 0 (minimum), down if a < 0
  (maximum). Vertex form a(x - h)² + k has vertex (h, k).
- Quadratic formula x = [-b ± √(b² - 4ac)] / (2a). Discriminant b² - 4ac: > 0 two real roots,
  = 0 one, < 0 none.

### Unit 4: Polynomials and Rational Functions

- End behaviour from the leading term: even degree, both ends the same way; odd degree, opposite
  ways; negative leading coefficient flips the right end down.
- Degree n: at most n real zeros and at most n - 1 turning points.
- Multiplicity: odd crosses the x-axis, even touches and bounces.
- Remainder Theorem: dividing by (x - c) leaves remainder f(c). Factor Theorem: f(c) = 0 means
  (x - c) is a factor. Rational zeros: p/q with p | constant, q | leading coefficient.
- Rational functions: cancel common factors first (cancelled factor = hole). Vertical asymptotes
  at remaining zeros of the denominator. Horizontal asymptote: top degree < bottom, y = 0;
  equal, ratio of leading coefficients; top = bottom + 1, slant asymptote (long division).

### Unit 5: Exponential and Logarithmic

- f(x) = a·bˣ: a = starting value, b = growth (b > 1) or decay (0 < b < 1) factor. Asymptote
  y = 0, domain all reals, range (0, ∞).
- Compound interest A = P(1 + r/n)^(nt); continuous A = Pe^(rt).
- y = log_b x means bʸ = x. Domain x > 0, asymptote x = 0, passes (1, 0).
- Rules: log(MN) = log M + log N; log(M/N) = log M - log N; log(Mᵏ) = k log M;
  change of base log_b x = ln x / ln b.
- Solve exponentials by taking logs of both sides; solve logs by rewriting in exponential form
  (then check the domain).

### Unit 6: Trigonometry I

- Degrees to radians × π/180; radians to degrees × 180/π.
- SOH CAH TOA; csc = 1/sin, sec = 1/cos, cot = 1/tan.
- Unit circle: (cos θ, sin θ). Signs by quadrant: All, Sin, Tan, Cos (QI to QIV).
- Reference angle: QII 180° - θ, QIII θ - 180°, QIV 360° - θ.
- Exact values: sin 30° = 1/2, sin 45° = √2/2, sin 60° = √3/2 (cosine in reverse order);
  tan 30° = √3/3, tan 45° = 1, tan 60° = √3.
- y = A sin(Bx - C) + D: amplitude |A|, period 2π/|B|, phase shift C/B, midline y = D.
  Tangent period π/|B|.
- Arc length s = rθ (radians); sector area (θ/360°)πr².
- arcsin and arctan give angles in [-π/2, π/2]; arccos gives angles in [0, π].

### Unit 7: Trigonometry II (Identities)

- Pythagorean: sin²θ + cos²θ = 1; 1 + tan²θ = sec²θ; 1 + cot²θ = csc²θ.
- Sum and difference: sin(A ± B) = sinA cosB ± cosA sinB; cos(A ± B) = cosA cosB ∓ sinA sinB;
  tan(A ± B) = (tanA ± tanB)/(1 ∓ tanA tanB).
- Double angle: sin 2θ = 2 sinθ cosθ; cos 2θ = cos²θ - sin²θ = 1 - 2sin²θ = 2cos²θ - 1;
  tan 2θ = 2tanθ/(1 - tan²θ).
- Half angle: sin(θ/2) = ±√[(1 - cosθ)/2]; cos(θ/2) = ±√[(1 + cosθ)/2] (sign from the quadrant
  of θ/2).
- Sum to product: cosA - cosB = -2 sin[(A+B)/2] sin[(A-B)/2]; sinA - sinB = 2 cos[(A+B)/2]
  sin[(A-B)/2]. Product to sum: sinA cosB = ½[sin(A+B) + sin(A-B)].
- Solving: isolate the trig function, find the reference angle, list every quadrant where the
  sign matches, then add the period for each extra rotation.

### Unit 8: Systems of Equations

- Independent: one solution (lines cross). Dependent: infinitely many (same line, elimination
  gives 0 = 0). Inconsistent: none (parallel lines, elimination gives a false statement like
  0 = 3). Consistent = independent or dependent.
- Methods: substitution, elimination, Gaussian elimination (row operations only: swap rows,
  multiply a row by a nonzero number, add a multiple of one row to another).
- Nonlinear (line and curve): substitute the line into the curve and solve the quadratic;
  0, 1, or 2 intersection points.
"""

SELF_QUIZ = """
## Part 2: Self-Quiz Review (From Your Notes)

### Unit 4

| Question | Answer | Why |
|---|---|---|
| Degree, leading coefficient, leading term of -2x¹⁰ - 25x⁴ + 30x³ - 20x + 5 | 10, -2, -2x¹⁰ | The highest power is 10 |
| Zeros of 6x³ + 2x² - 4x | 0, 2/3, -1 | 2x(3x - 2)(x + 1) |
| Graph with both ends down | Negative leading coefficient, even degree | Same direction = even; down = negative |
| Vertical asymptotes of (x - 1)/(x² + 4x + 3) | x = -3, x = -1 | (x + 1)(x + 3), nothing cancels |
| Vertical asymptotes of (x - 5)/(x⁴ + 2x³ + x²) | x = 0, x = -1 | x²(x + 1)² |

### Unit 5

| Question | Answer | Why |
|---|---|---|
| 2(7ˣ) compared with 7ˣ | Stretches vertically | Multiplying the output by 2 |
| Domain, range, asymptote of 23ˣ | (-∞, ∞), (0, ∞), y = 0 | Every exponential bˣ |
| True about e^(-x) | Approaches zero but never reaches it | Decay towards y = 0 |
| 9ˣ as x → -∞ | Approaches zero | Left tail of growth |
| Reflection of 5ˣ about the y-axis | (-∞, ∞), (0, ∞), asymptote y = 0 | Reflection keeps domain, range, asymptote |

### Unit 6 (Review of Units 3 to 6)

| Topic | Answer | Why |
|---|---|---|
| Which is a polynomial | 3x² - 5x + 2 | Whole-number powers only |
| Zero of 7x + 3 | -3/7 | 7x + 3 = 0 |
| 7 radians in degrees | 401° | 7 × 180/π ≈ 401.07 |
| $25,000 at 8% for 3 years | $31,492.80 | 25000 × 1.08³ |
| Degree-10 polynomial: max x-intercepts, turning points | 10, 9 | n and n - 1 |
| Domain and range of log(4x + 5) | (-5/4, ∞), (-∞, ∞) | 4x + 5 > 0 |
| Present value of $8000 in 3 years at 6% | about $6,717 (option $6,720) | 8000 ÷ 1.06³ |
| Solve 2ˣ = 1/6 | -2.5849 | x = log₂(1/6) |
| Multiplying a function by 25 compresses it | False | It stretches |
| Distance with angle of elevation 60° and height 20 m | 11.54 m | 20 / tan 60° |
| Horizontal asymptote when top degree 3, bottom 2 | Does not exist | Top degree is larger |
| 1560° in radians (reduced) | 2π/3 | 1560 - 4(360) = 120° |
| Quadrantal angle | Terminal side on an axis | 0°, 90°, 180°, 270° |
| cos t = -3/5 in QII, find sin t | 4/5 | sin² t = 16/25, sine positive in QII |
| Sector 30°, radius 20 cm | about 105 cm² | (30/360)π(20²) |
| y = -10 sin x - 7: amplitude, midline | 10, y = -7 | Amplitude is |A| |
| cos 450° | 0 | Coterminal with 90° |

### Unit 7

| Question | Answer | Why |
|---|---|---|
| sec θ · sec θ · cos θ · tan θ · sin θ · cot θ | tan θ | sec²θ cos θ = sec θ; tan θ cot θ = 1; sec θ sin θ = tan θ |
| (sin x + cos x)/(csc x tan x + sec x cot x) | sin x cos x | csc x tan x = sec x; sec x cot x = csc x |
| A = sin x, B = cos x: A² - B² | -cos 2x | -(cos²x - sin²x) |
| 2cos x = 4cos x - √3 on [0, 2π] | x = 30°, 330° | cos x = √3/2 |
| (cos 5x - cos 7x)/(sin 5x - sin 7x) | -tan 6x | Sum-to-product on top and bottom |

### Unit 8

| Question | Answer | Why |
|---|---|---|
| Circle x² + y² = 4 meets ellipse x² + 4y² = 4 | (2, 0), (-2, 0) | Subtract: 3y² = 0 |
| Gaussian elimination uses row and column operations | False | Row operations only |
| 3x + 2y = 7 and 6x + 4y = 10 is consistent | False | Parallel lines (would need 14) |
| A parabola meets a line in at most two points | True | Substitution gives a quadratic |
| Independent system | Unique solution, lines meet at a point | Definition |
"""

TIPS = """
## Part 5: Exam-Day Checklist

- **Rosalyn rules:** a Windows or macOS computer (no phone or tablet), and only paper, a pencil,
  and a calculator. No notes or books, so learn the formula sheet in Part 1 beforehand.
- **Calculator mode:** check degrees or radians before every trig question. Most wrong trig
  answers come from the wrong mode.
- **Plug back in:** for any "solve" question, substitute your answer into the original equation.
  It takes seconds and catches sign errors.
- **Use the options:** with multiple choice, you can test each option in the equation when
  solving directly is slow.
- **Watch the traps from this course:** composition order (f ∘ g vs g ∘ f), round vs square
  brackets in domains, hole vs asymptote, arcsin's range, the sign of cosine in Quadrant II, and
  "dependent" systems hidden in word problems.
- **Pace:** answer the questions you know first, mark the hard ones, and come back.
"""


def main():
    questions = balanced(QUESTIONS)
    (HERE / "practice_questions.json").write_text(json.dumps(questions, ensure_ascii=False, indent=1))

    lines = [
        "# MATH 1201 Final Exam Study Guide",
        "",
        "**Course:** MATH 1201 College Algebra",
        "**Student:** Nicanor Maswili",
        "**Instructor:** Chibuike Agu",
        "**Due:** Final Exam, Unit 9",
        "",
        "## How to Use This Guide",
        "",
        "The proctored final exam covers all eight units. Study Part 1 until you can write the "
        "formulas from memory, review the self-quiz answers in Part 2, then take the practice exam "
        "in Part 3 without looking at Part 4. Every practice answer was checked with a computer "
        "algebra tool. Mark any question you miss and reread that unit's formulas.",
        FORMULAS,
        SELF_QUIZ,
        "## Part 3: Practice Exam (48 Questions)",
        "",
        "Write your answers on paper, then check them in Part 4.",
        "",
    ]
    number = 0
    for unit in range(1, 9):
        lines += [f"### Unit {unit}: {UNIT_NAMES[unit]}", ""]
        for q in (q for q in questions if q["unit"] == unit):
            number += 1
            lines.append(f"**{number}.** {q['q']}")
            lines.append("")
            for i, option in enumerate(q["options"]):
                lines.append(f"- {LETTERS[i]}. {option}")
            lines.append("")
    lines += ["## Part 4: Answer Key With Worked Solutions", ""]
    for number, q in enumerate(questions, start=1):
        lines.append(f"**{number}. {LETTERS[q['answer']]}** ({q['options'][q['answer']]}). {q['why']}")
        lines.append("")
    lines.append(TIPS)
    lines += [
        "## References",
        "",
        "Abramson, J. (2021). *Algebra and trigonometry* (2nd ed.). OpenStax.",
        "https://openstax.org/details/books/algebra-and-trigonometry-2e",
    ]
    (HERE / "Final_Exam_Study_Guide.md").write_text("\n".join(lines) + "\n")
    counts = [sum(1 for q in questions if q["answer"] == i) for i in range(4)]
    print("Wrote guide and JSON; answers by position A-D:", counts)


if __name__ == "__main__":
    main()
