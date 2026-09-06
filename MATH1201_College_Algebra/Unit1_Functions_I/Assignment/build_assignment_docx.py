#!/usr/bin/env python3
"""
Generate the APA 7 .docx for MATH 1201 Unit 1 Written Assignment (Functions - I).

Meets the assignment's format requirements: Word document, double-spaced,
Times New Roman, 12pt, 1-inch margins. Includes an APA student title page,
real Word heading styles, and a placeholder for the GeoGebra graph (Task 2).

Usage:  python3 build_assignment_docx.py
Output: Unit1_Assignment_Activity.docx
"""

from docx import Document
from docx.shared import Pt, Inches, RGBColor
from docx.enum.text import WD_ALIGN_PARAGRAPH, WD_LINE_SPACING

FONT = "Times New Roman"
MONO = "Courier New"
OUTPUT = "Unit1_Assignment_Activity.docx"

TITLE = "Written Assignment Unit 1: Functions - I"
AUTHOR = "Nicanor Kyamba"
AFFIL = "Department of Mathematics, University of the People"
COURSE = "MATH 1201: College Algebra"
INSTRUCTOR = "Instructor: [Instructor Name]"
DUE = "September 9, 2026"

REFS = [
    "Abramson, J. (2023). *Algebra and trigonometry* (2nd ed.). OpenStax. "
    "https://openstax.org/details/books/algebra-and-trigonometry-2e",
    "GeoGebra. (n.d.). *GeoGebra graphing calculator*. https://www.geogebra.org/calculator",
    "Stitz, C., & Zeager, J. (2013). *College algebra*. Stitz Zeager Open Source "
    "Mathematics. https://stitz-zeager.com/szca07042013.pdf",
    "Yoshiwara, K. (2020). *Modeling, functions, and graphs*. American Institute of "
    "Mathematics. https://yoshiwarabooks.org/mfg/colophon-1.html",
]


def base(doc):
    st = doc.styles["Normal"]
    st.font.name = FONT
    st.font.size = Pt(12)
    st.paragraph_format.line_spacing = 2.0  # APA double-spacing
    st.paragraph_format.space_after = Pt(0)
    for h, sz in (("Heading 1", 12), ("Heading 2", 12)):
        try:
            s = doc.styles[h]
            s.font.name = FONT
            s.font.size = Pt(sz)
            s.font.bold = True
            s.font.color.rgb = RGBColor(0, 0, 0)
            s.paragraph_format.line_spacing = 2.0
            s.paragraph_format.space_before = Pt(0)
            s.paragraph_format.space_after = Pt(0)
        except KeyError:
            pass
    for sec in doc.sections:
        sec.top_margin = sec.bottom_margin = Inches(1)
        sec.left_margin = sec.right_margin = Inches(1)


def para(doc, text="", bold=False, align=None):
    p = doc.add_paragraph()
    p.paragraph_format.line_spacing = 2.0
    p.paragraph_format.first_line_indent = Inches(0)
    if align is not None:
        p.alignment = align
    r = p.add_run(text)
    r.bold = bold
    r.font.name = FONT
    r.font.size = Pt(12)
    return p


def head(doc, text, level=2, center=False):
    p = doc.add_heading(level=level)
    if center:
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    p.paragraph_format.line_spacing = 2.0
    r = p.add_run(text)
    r.bold = True
    r.font.name = FONT
    r.font.size = Pt(12)
    r.font.color.rgb = RGBColor(0, 0, 0)
    return p


def mono(doc, text):
    p = doc.add_paragraph()
    p.paragraph_format.line_spacing_rule = WD_LINE_SPACING.SINGLE
    p.paragraph_format.left_indent = Inches(0.5)
    r = p.add_run(text)
    r.font.name = MONO
    r.font.size = Pt(11)
    return p


def placeholder(doc, text):
    p = doc.add_paragraph()
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    p.paragraph_format.line_spacing = 2.0
    r = p.add_run(text)
    r.bold = True
    r.font.name = FONT
    r.font.size = Pt(12)


def reference(doc, text):
    p = doc.add_paragraph()
    pf = p.paragraph_format
    pf.line_spacing = 2.0
    pf.left_indent = Inches(0.5)
    pf.first_line_indent = Inches(-0.5)
    for i, seg in enumerate(text.split("*")):
        r = p.add_run(seg)
        r.font.name = FONT
        r.font.size = Pt(12)
        r.italic = (i % 2 == 1)


def build():
    doc = Document()
    base(doc)

    # Title page
    for _ in range(4):
        para(doc, "")
    para(doc, TITLE, bold=True, align=WD_ALIGN_PARAGRAPH.CENTER)
    para(doc, "")
    para(doc, AUTHOR, align=WD_ALIGN_PARAGRAPH.CENTER)
    para(doc, AFFIL, align=WD_ALIGN_PARAGRAPH.CENTER)
    para(doc, COURSE, align=WD_ALIGN_PARAGRAPH.CENTER)
    para(doc, INSTRUCTOR, align=WD_ALIGN_PARAGRAPH.CENTER)
    para(doc, DUE, align=WD_ALIGN_PARAGRAPH.CENTER)
    doc.add_page_break()

    head(doc, TITLE, level=1, center=True)

    # Task 1
    head(doc, "Task 1: Interpreting the Graph (Domain, Range, One-to-One)")
    para(doc, "(i) Domain and Range. The domain is the set of all x-values the graph "
              "covers, read from the leftmost to the rightmost x-value; use a square "
              "bracket for an included endpoint (solid dot) and a parenthesis for an "
              "excluded endpoint (open dot). The range is the set of all y-values, from the "
              "lowest to the highest the graph reaches, using the same bracket rules. Read "
              "the exact endpoints from the provided graph and state Domain = [x_min, x_max] "
              "and Range = [y_min, y_max].")
    para(doc, "(ii) Function and one-to-one. By the vertical line test, if every vertical "
              "line meets the graph at most once, each input has exactly one output, so it "
              "is a function (Abramson, 2023). By the horizontal line test, if every "
              "horizontal line meets the graph at most once, it is one-to-one; if a "
              "horizontal line meets it more than once (as with a parabola), it is a "
              "function but not one-to-one. State the conclusion with the justification "
              "based on the shape shown.")

    # Task 2
    head(doc, "Task 2: Avocado Export Function E(P) = P - 10000, P >= 10000")
    para(doc, "(i) Graph. E(P) = P - 10000 is a straight line of slope 1 with E-intercept "
              "-10000; since P >= 10000, the graph is the ray starting at (10000, 0) and "
              "rising to the right. It was plotted in GeoGebra using a scale of 1 unit = "
              "1000 on both axes.")
    placeholder(doc, "[ Insert GeoGebra graph of E(P) here ]")
    para(doc, "(ii) Is E(P) a function of P? Yes. Each production value P gives exactly one "
              "export value E(P) = P - 10000, and the line passes the vertical line test, "
              "so E is a function of P (Abramson, 2023).")
    para(doc, "(iii) Domain and range. Domain: P >= 10000, i.e., [10000, infinity). Range: "
              "at P = 10000, E = 0, and E grows without bound, so [0, infinity).")
    para(doc, "(iv) Export for 70 and 20 thousand of production. With values in thousands, "
              "P = 70000 gives E = 70000 - 10000 = 60000 (60 thousand units), and P = 20000 "
              "gives E = 20000 - 10000 = 10000 (10 thousand units).")
    para(doc, "(v) Variables. The independent variable is P (production), which is chosen "
              "freely; the dependent variable is E (export), whose value depends on P.")

    # Task 3
    head(doc, "Task 3: Rate of Change - Weights and Lengths of Two Animals")
    para(doc, "The graph shows a parabola (f) and a line (g) intersecting at A(5, 25), with "
              "x = length (feet) and y = weight (tons). A line through the origin and "
              "A(5, 25) is g(x) = 5x, and a parabola through the origin and A(5, 25) is "
              "f(x) = x squared.")
    para(doc, "(i) Rate of change at the intersection. The rate of change of weight with "
              "respect to length is the slope, slope = change in y over change in x. For "
              "the line g the rate of change is constant at 5 tons per foot everywhere, "
              "including at A. For the parabola f the rate of change is not constant; it "
              "increases as length increases. So animal g gains weight at a steady rate per "
              "foot, while animal f gains weight faster and faster as it lengthens.")
    para(doc, "(ii) Slopes of CD (on f) and EF (on g). Using slope = (y2 - y1)/(x2 - x1): "
              "for example, taking C = (1, 1) and D = (3, 9) on f gives slope CD = "
              "(9 - 1)/(3 - 1) = 4; taking E = (1, 5) and F = (3, 15) on g gives slope EF = "
              "(15 - 5)/(3 - 1) = 5. The slope of EF equals the line's constant rate, so any "
              "two points give 5, while the slope of CD is an average rate that changes with "
              "the chosen points, confirming f's non-constant rate. Replace these example "
              "points with the actual C, D, E, F read from the graph.")

    # Task 4
    head(doc, "Task 4: Local Extrema and Behavior of the Function")
    para(doc, "A local maximum is a point higher than all nearby points (a peak, where the "
              "graph rises then falls); a local minimum is lower than nearby points (a "
              "valley, where the graph falls then rises) (Abramson, 2023). These differ "
              "from the absolute maximum and minimum, which are the single highest and "
              "lowest values over the entire domain. A local extremum is best only in its "
              "neighborhood, whereas an absolute extremum is best overall; a graph may have "
              "several local extrema but at most one absolute max and one absolute min.")
    para(doc, "For intervals, read the x-coordinates of the turning points from the graph. "
              "The function is increasing where the graph rises left to right (positive "
              "slope) and decreasing where it falls (negative slope). Report each interval "
              "by its endpoints, for example increasing on (A, B) and decreasing on (B, C). "
              "A local maximum occurs where the graph changes from increasing to decreasing, "
              "and a local minimum where it changes from decreasing to increasing. State "
              "each extremum's approximate coordinates as shown on the graph.")

    # Task 5
    head(doc, "Task 5: Piecewise Tax Function for Country W")
    para(doc, "(i) The tax rule as a piecewise function. Let x be income and T(x) the tax:")
    mono(doc, "          | 0.10x,                        0 <= x <= 2200")
    mono(doc, "T(x) =    | 220 + 0.185(x - 2200),     2200 <  x <= 8945")
    mono(doc, "          | 1467.825 + 0.30(x - 8945),    x > 8945")
    para(doc, "For 2200 < x <= 8945, the first $2200 is taxed at 10% ($220) and the amount "
              "above $2200 at 18.5%. For x > 8945, the first $2200 gives $220, the band from "
              "$2200 to $8945 (width $6745) taxed at 18.5% gives $1,247.825, so the fixed "
              "part is $1,467.825, plus 30% of income above $8945.")
    para(doc, "(ii) Sample tax in each slab:")
    para(doc, "Slab a - income $2,000 (<= 2200): T = 0.10 x 2000 = $200.00.")
    para(doc, "Slab b - income $5,000 (2200 < x <= 8945): T = 220 + 0.185 x (5000 - 2200) = "
              "220 + 518 = $738.00.")
    para(doc, "Slab c - income $10,000 (> 8945): T = 1467.825 + 0.30 x (10000 - 8945) = "
              "1467.825 + 316.5 = $1,784.325, approximately $1,784.33.")
    para(doc, "Each result taxes only the income within each rate band, which is how a "
              "progressive piecewise tax is applied (Stitz & Zeager, 2013).")

    # References
    doc.add_page_break()
    head(doc, "References", level=1, center=True)
    for r in REFS:
        reference(doc, r)

    doc.save(OUTPUT)
    print(f"Created {OUTPUT}")


if __name__ == "__main__":
    build()
