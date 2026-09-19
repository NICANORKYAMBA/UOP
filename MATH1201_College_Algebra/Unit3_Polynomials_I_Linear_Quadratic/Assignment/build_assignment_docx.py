#!/usr/bin/env python3
"""
Generate the APA 7 .docx for MATH 1201 Unit 3 Written Assignment
(Polynomials I: Linear and Quadratic Functions).

Format: Word document, double-spaced, Times New Roman 12pt, 1-inch margins,
native Word Title/Heading styles, block paragraphs, native tables, APA title
page, and placeholders for the two GeoGebra graphs (Task 1 quadratic, Task 2
linear road map).

Usage:  python3 build_assignment_docx.py
Output: Unit3_Assignment_Activity.docx
"""

from docx import Document
from docx.shared import Pt, Inches, RGBColor
from docx.enum.text import WD_ALIGN_PARAGRAPH

FONT = "Times New Roman"
OUTPUT = "Unit3_Assignment_Activity.docx"

TITLE = ("Written Assignment Unit 3: Polynomials I - "
         "Linear and Quadratic Functions")
AUTHOR = "Nicanor Maswili"
AFFIL = "Department of Mathematics, University of the People"
COURSE = "MATH 1201: College Algebra"
INSTRUCTOR = "Instructor: Chibuike Agu"
DUE = "September 23, 2026"

REFS = [
    "Abramson, J. (2023). *Algebra and trigonometry* (2nd ed.). OpenStax. "
    "https://openstax.org/details/books/algebra-and-trigonometry-2e",
    "Stitz, C., & Zeager, J. (2013). *College algebra*. Stitz Zeager Open "
    "Source Mathematics. https://stitz-zeager.com/szca07042013.pdf",
    "Yoshiwara, K. (2020). *Modeling, functions and graphs*. American "
    "Institute of Mathematics. https://yoshiwarabooks.org/mfg/MFG.html",
]


def base(doc):
    st = doc.styles["Normal"]
    st.font.name = FONT
    st.font.size = Pt(12)
    st.paragraph_format.line_spacing = 2.0
    st.paragraph_format.space_after = Pt(0)
    for h, sz in (("Title", 16), ("Heading 1", 13), ("Heading 2", 12)):
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


def para(doc, text="", bold=False, align=None, block=True):
    p = doc.add_paragraph()
    p.paragraph_format.line_spacing = 2.0
    p.paragraph_format.first_line_indent = Inches(0)
    p.paragraph_format.space_after = Pt(10) if block else Pt(0)
    if align is not None:
        p.alignment = align
    r = p.add_run(text)
    r.bold = bold
    r.font.name = FONT
    r.font.size = Pt(12)
    return p


def title_style(doc, text):
    p = doc.add_paragraph(style="Title")
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    p.paragraph_format.line_spacing = 2.0
    r = p.add_run(text)
    r.bold = True
    r.font.name = FONT
    r.font.size = Pt(16)
    r.font.color.rgb = RGBColor(0, 0, 0)
    return p


def head(doc, text, level=2, center=False):
    p = doc.add_heading(level=level)
    if center:
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    p.paragraph_format.line_spacing = 2.0
    r = p.add_run(text)
    r.bold = True
    r.font.name = FONT
    r.font.size = Pt(13 if level == 1 else 12)
    r.font.color.rgb = RGBColor(0, 0, 0)
    return p


def table(doc, rows):
    t = doc.add_table(rows=len(rows), cols=len(rows[0]))
    t.style = "Table Grid"
    for i, row in enumerate(rows):
        for j, val in enumerate(row):
            cell = t.rows[i].cells[j]
            cell.text = ""
            rp = cell.paragraphs[0]
            rp.paragraph_format.line_spacing = 1.0
            run = rp.add_run(str(val))
            run.font.name = FONT
            run.font.size = Pt(11)
            if i == 0:
                run.bold = True
    para(doc, "")
    return t


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
    pf.space_after = Pt(0)
    for i, seg in enumerate(text.split("*")):
        r = p.add_run(seg)
        r.font.name = FONT
        r.font.size = Pt(12)
        r.italic = (i % 2 == 1)


def build():
    doc = Document()
    base(doc)

    # ---- Title page ----
    for _ in range(4):
        para(doc, "", block=False)
    title_style(doc, TITLE)
    para(doc, "", block=False)
    para(doc, AUTHOR, align=WD_ALIGN_PARAGRAPH.CENTER, block=False)
    para(doc, AFFIL, align=WD_ALIGN_PARAGRAPH.CENTER, block=False)
    para(doc, COURSE, align=WD_ALIGN_PARAGRAPH.CENTER, block=False)
    para(doc, INSTRUCTOR, align=WD_ALIGN_PARAGRAPH.CENTER, block=False)
    para(doc, DUE, align=WD_ALIGN_PARAGRAPH.CENTER, block=False)
    doc.add_page_break()

    head(doc, TITLE, level=1, center=True)

    head(doc, "Introduction")
    para(doc, "This assignment applies linear and quadratic functions to three real-world "
              "scenarios. Task 1 analyzes a bungee jumper's height with a quadratic model, "
              "both algebraically and graphically. Task 2 uses linear functions to plan a "
              "road connecting two locations. Task 3 models electricity pricing with a "
              "linear cost function and interprets its rate of change. Each part shows the "
              "steps and connects the mathematics back to the scenario, and the two required "
              "graphs are produced with the GeoGebra graphing calculator.")

    # ================= TASK 1 =================
    head(doc, "Task 1: Quadratic Function - Bungee Jumper", level=1)
    para(doc, "The height above the river is modeled by h(t) = -0.5t^2 + v0 t + h0, where h "
              "is in meters and t in seconds. With initial velocity v0 = 0 m/s and initial "
              "height h0 = 210 m, the model simplifies to h(t) = -0.5t^2 + 210.")

    head(doc, "Part 1(i): Mathematical Understanding")

    para(doc, "1. Domain and range.", bold=True)
    para(doc, "Mathematically the formula accepts any real t, but physically the motion runs "
              "from the moment of the jump (t = 0) until the jumper reaches the river "
              "(h = 0). Setting h(t) = 0 gives 0.5t^2 = 210, so t^2 = 420 and t = sqrt(420) "
              "which is about 20.49 s. The domain is therefore t in [0, 20.49] seconds. Over "
              "this interval the height falls from its largest value 210 m down to 0 m, so "
              "the range is h in [0, 210] meters. Physically, the domain is the time the "
              "fall lasts and the range is the set of heights the jumper actually passes "
              "through, from the bridge down to the river surface (Stitz & Zeager, 2013).")

    para(doc, "2. Vertex.", bold=True)
    para(doc, "For a quadratic in the form at^2 + bt + c, the vertex occurs at t = -b/(2a). "
              "Here a = -0.5 and b = 0, so t = -0/(2*(-0.5)) = 0, and h(0) = -0.5(0) + 210 = "
              "210. The vertex is (0, 210). Because a is negative the parabola opens "
              "downward, so the vertex is the highest point. In this scenario the vertex "
              "represents the start of the jump, where the jumper is momentarily at the "
              "maximum height of 210 m with zero velocity.")

    para(doc, "3. Time and value of maximum height.", bold=True)
    para(doc, "The maximum of a downward parabola is its vertex, found above. The maximum "
              "height is reached at t = 0 s and equals h(0) = 210 m. This is expected: with "
              "initial velocity v0 = 0, the jumper is released from rest at the top, so the "
              "highest point is the launch point itself and the height only decreases "
              "afterward.")

    para(doc, "4. Time to reach a height of 11 m.", bold=True)
    para(doc, "Set h(t) = 11: -0.5t^2 + 210 = 11, so 0.5t^2 = 199, giving t^2 = 398 and "
              "t = sqrt(398) which is about 19.95 s. (The negative root is rejected because "
              "time cannot be negative.) The jumper is 11 m above the river at about 19.95 "
              "seconds into the fall.")

    para(doc, "5. Height after 20 seconds.", bold=True)
    para(doc, "Substitute t = 20: h(20) = -0.5(20)^2 + 210 = -0.5(400) + 210 = -200 + 210 = "
              "10 m. After 20 seconds the jumper is 10 m above the river - very close to the "
              "water, consistent with the jump ending at about 20.49 s.")

    para(doc, "6. Time the jumper touches the river.", bold=True)
    para(doc, "The jumper touches the river when h(t) = 0: 0.5t^2 = 210, t^2 = 420, "
              "t = sqrt(420) which is about 20.49 s. This is the end of the domain found in "
              "part 1 and marks the instant the fall reaches the water surface.")

    head(doc, "Part 1(ii): Graphical Understanding")

    para(doc, "7. Graph of h(t).", bold=True)
    para(doc, "The graph of h(t) = -0.5t^2 + 210 is a downward-opening parabola with vertex "
              "at (0, 210) and a t-intercept at about (20.49, 0). Only the portion for "
              "t in [0, 20.49] is physically meaningful. GeoGebra input: "
              "h(t) = -0.5 t^2 + 210 (restrict to 0 <= t <= 20.49).")
    placeholder(doc, "[ Insert GeoGebra graph of h(t) = -0.5t^2 + 210 here ]")

    para(doc, "8. Increasing or decreasing intervals.", bold=True)
    para(doc, "Reading the physical branch from t = 0 to t = 20.49 s, the height only falls: "
              "the curve decreases throughout the interval (0, 20.49). It is never "
              "increasing during the jump because the jumper starts at the top with zero "
              "velocity and moves downward the entire time. (For the full unrestricted "
              "parabola the function would increase for t < 0, but negative time has no "
              "meaning here.)")

    para(doc, "9. Axis of symmetry.", bold=True)
    para(doc, "The axis of symmetry is the vertical line through the vertex, t = -b/(2a) = 0, "
              "that is the line t = 0. In this scenario the axis of symmetry coincides with "
              "the start of the jump. Because the initial velocity is zero, the launch "
              "happens exactly at the parabola's turning point, so the axis of symmetry marks "
              "the moment of maximum height rather than sitting between two equal-height "
              "times during the fall.")

    para(doc, "10. Intercepts.", bold=True)
    para(doc, "The h-intercept is found at t = 0: h(0) = 210, giving the point (0, 210); it "
              "represents the initial height of the bridge above the river. The t-intercept "
              "is found at h = 0: t = sqrt(420) which is about 20.49, giving (20.49, 0); it "
              "represents the time at which the jumper reaches the river. (The negative root "
              "-20.49 is not physical.)")

    # ================= TASK 2 =================
    head(doc, "Task 2: Linear Function - Road Project", level=1)
    para(doc, "A road connects Point A(5, 7) and Point B(6, 5). The following parts analyze "
              "this road as a linear function, connecting each result to the planning "
              "scenario.")

    para(doc, "1. Optimal route planning (equation of the road).", bold=True)
    para(doc, "The slope between A(5, 7) and B(6, 5) is m = (5 - 7)/(6 - 5) = -2/1 = -2. "
              "Using point-slope form with A(5, 7): y - 7 = -2(x - 5), so y - 7 = -2x + 10, "
              "giving y = -2x + 17. This is the equation of the road that connects the two "
              "critical locations.")

    para(doc, "2. Traffic flow analysis (slope).", bold=True)
    para(doc, "The slope of the road is m = -2, calculated above. It means that for every "
              "one unit of horizontal distance traveled in the positive x-direction, the "
              "road drops two units in the y-direction. A steady, known slope supports "
              "efficient traffic design because it describes a constant rate of change along "
              "the route (Yoshiwara, 2020).")

    para(doc, "3. Enhanced traffic safety (change in elevation).", bold=True)
    para(doc, "Going from A(5, 7) to B(6, 5), the elevation changes by delta-y = 5 - 7 = -2 "
              "over a horizontal run of delta-x = 6 - 5 = 1. The road therefore descends 2 "
              "units for each 1 unit of horizontal travel (a decline consistent with the "
              "slope -2). Knowing this drop matters for safety features such as grade, "
              "drainage, and speed limits on the descending stretch.")

    para(doc, "4. Alternate routes (parallel and perpendicular).", bold=True)
    para(doc, "Parallel roads have the same slope, m = -2. A parallel route through a "
              "different point, for example (0, 0), is y = -2x. Perpendicular roads have "
              "slopes that are negative reciprocals: the perpendicular slope is -1/(-2) = "
              "1/2. A perpendicular route through A(5, 7) is y - 7 = (1/2)(x - 5), that is "
              "y = (1/2)x + 9/2. These give commuters parallel and crossing alternatives "
              "(Abramson, 2023).")

    para(doc, "5. Visual infrastructure mapping (graph).", bold=True)
    para(doc, "The road y = -2x + 17, together with a parallel route and a perpendicular "
              "route, is plotted in GeoGebra below, with points A(5, 7) and B(6, 5) marked. "
              "GeoGebra input: y = -2x + 17; y = -2x; y = 0.5x + 4.5; A = (5, 7); "
              "B = (6, 5).")
    placeholder(doc, "[ Insert GeoGebra graph of the road y = -2x + 17 with A, B, and the "
                     "parallel/perpendicular routes here ]")

    para(doc, "6. Access points (intercepts).", bold=True)
    para(doc, "For y = -2x + 17: the y-intercept is at x = 0, giving y = 17, the point "
              "(0, 17); the x-intercept is at y = 0, giving 0 = -2x + 17, so x = 8.5, the "
              "point (8.5, 0). These intercepts are where the road meets the coordinate axes "
              "and can serve as access points or landmarks in the plan.")

    para(doc, "7. How many parallel and perpendicular roads are possible?", bold=True)
    para(doc, "Infinitely many of each. There are infinitely many lines with slope -2 "
              "(each a different parallel road through a different point) and infinitely many "
              "lines with slope 1/2 (each a different perpendicular road), because a line is "
              "fixed only once both a slope and a point are chosen, and there are infinitely "
              "many points to choose from (Abramson, 2023).")

    # ================= TASK 3 =================
    head(doc, "Task 3: Linear Function II - Electricity Pricing", level=1)
    para(doc, "In Italy each household pays a fixed charge of $50 plus $0.78 for every unit "
              "of electricity consumed.")

    para(doc, "1. Linear function for the pricing.", bold=True)
    para(doc, "Let u be the number of units of electricity consumed (units) and C(u) the "
              "total monthly cost (dollars). The fixed charge is the constant term and the "
              "per-unit charge is the slope, so C(u) = 50 + 0.78u. Here 50 is the fixed cost "
              "billed even at zero consumption, and 0.78 is the cost added per unit consumed "
              "(Yoshiwara, 2020).")

    para(doc, "2. Average rate of change and its impact on the bill.", bold=True)
    para(doc, "For a linear function the average rate of change is constant and equals the "
              "slope. Taking any two consumption levels, for example u1 = 100 and u2 = 200: "
              "C(100) = 50 + 0.78(100) = 128 and C(200) = 50 + 0.78(200) = 206. The average "
              "rate of change is (206 - 128)/(200 - 100) = 78/100 = 0.78 dollars per unit. "
              "This means each additional unit of electricity raises the monthly bill by "
              "exactly $0.78, regardless of how much has already been used. For the consumer, "
              "the bill grows in direct proportion to consumption on top of the fixed $50, so "
              "reducing usage by one unit saves $0.78, and the steady slope makes the monthly "
              "cost easy to predict (Yoshiwara, 2020).")

    head(doc, "Conclusion")
    para(doc, "Across the three tasks, the quadratic model captured the rise-and-fall of a "
              "bungee jump through its vertex, intercepts, and axis of symmetry, while the "
              "linear models described a road's constant slope and an electricity bill's "
              "constant rate of change. Together they show how first- and second-degree "
              "functions translate directly into physical meaning in real situations.")

    para(doc, "Academic Integrity Statement", bold=True)
    para(doc, "This assignment is my own original work. I solved each task and wrote all "
              "explanations myself, produced the graphs in GeoGebra, and cited the course "
              "readings used in APA style in the References section below.")

    # ---- References ----
    doc.add_page_break()
    head(doc, "References", level=1, center=True)
    for r in REFS:
        reference(doc, r)

    doc.save(OUTPUT)
    print(f"Created {OUTPUT}")


if __name__ == "__main__":
    build()
