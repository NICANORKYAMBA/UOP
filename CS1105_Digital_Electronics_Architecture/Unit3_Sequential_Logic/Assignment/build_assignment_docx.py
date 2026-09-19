#!/usr/bin/env python3
"""
Generate the APA .docx for CS 1105 Unit 3 Assignment (Learning Journal:
Sequential Circuit Project - Scoreboard Counter with Register Latch).
Double-spaced Times New Roman, native Title/Heading styles, block paragraphs,
monospaced block diagram, Logisim screenshot placeholder, APA references.

Usage:  python3 build_assignment_docx.py
Output: Unit3_Assignment_Activity.docx
"""

from docx import Document
from docx.shared import Pt, Inches, RGBColor
from docx.enum.text import WD_ALIGN_PARAGRAPH, WD_LINE_SPACING

FONT = "Times New Roman"
MONO = "Courier New"
OUTPUT = "Unit3_Assignment_Activity.docx"

TITLE = ("A Sequential Scoreboard: Integrating a Binary Counter and a "
         "Register for a Digital Score Display")
AUTHOR = "Nicanor Maswili"
AFFIL = "Department of Computer Science, University of the People"
COURSE = "CS 1105: Digital Electronics & Computer Architecture"
INSTRUCTOR = "Instructor: Muhammad Aligohar Bilal"
DUE = "September 23, 2026"

DIAGRAM = [
    "score pulse --> [ CLK ] MODULO-16 COUNTER (4 JK/T flip-flops)",
    "                          | Q3 Q2 Q1 Q0  (4-bit count)",
    "                          v",
    "latch pulse --> [ CLK ] 4-BIT PARALLEL REGISTER (4 D flip-flops)",
    "                          | held value",
    "                          v",
    "                  BCD-to-7-SEGMENT DECODER --> 7-SEGMENT DISPLAY",
    "reset ----------> asynchronous CLR on counter and register",
]

REFS = [
    "Down to the Wires. (2020, October 4). *Registers and counters* [Video]. "
    "YouTube. https://youtu.be/ikrNRrIRyMk",
    "Harris, D. M., & Harris, S. L. (2012). *Digital design and computer "
    "architecture* (2nd ed.). Morgan Kaufmann.",
    "Mano, M. M., & Ciletti, M. D. (2018). *Digital design: With an "
    "introduction to the Verilog HDL, VHDL, and SystemVerilog* (6th ed.). "
    "Pearson.",
    "Ndjountche, T. (2016). *Digital electronics 2: Sequential and arithmetic "
    "logic circuits*. ISTE Ltd/John Wiley & Sons. "
    "https://doi.org/10.1002/9781119318613",
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


def mono(doc, text):
    p = doc.add_paragraph()
    p.paragraph_format.line_spacing_rule = WD_LINE_SPACING.SINGLE
    p.paragraph_format.space_after = Pt(0)
    p.paragraph_format.left_indent = Inches(0.3)
    r = p.add_run(text)
    r.font.name = MONO
    r.font.size = Pt(10)


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
    para(doc, "As a junior electrical engineering instructor, I designed a small student "
              "project that applies sequential logic in a way learners can build and observe: "
              "a digital scoreboard. Sequential circuits are the right tool here because, "
              "unlike combinational circuits, they contain memory elements (flip-flops) whose "
              "outputs depend on both the present inputs and the stored past state, "
              "coordinated by a clock (Ndjountche, 2016). The scoreboard has to both count "
              "events and remember (hold) a value on a display, so it naturally combines a "
              "counter and a register. This journal explains the chosen scenario and its "
              "justification, gives a step-by-step analysis of the design, shows how the "
              "register and counter work together, and summarizes the key components.")

    head(doc, "(a) Scenario and Justification")
    para(doc, "The chosen scenario is a scoreboard counter display for a simple game or "
              "sports timer. Each time a point is scored, a pulse increments a running count; "
              "the current score is shown on a 7-segment display and stays visible (latched) "
              "until it is updated. I selected this scenario for three reasons. First, it is "
              "practical and familiar, so students can relate the circuit to something they "
              "have seen. Second, it exercises both required concepts at once: a counter to "
              "tally events and a register to hold the value for display, which is exactly "
              "the integration the assignment asks for. Third, it is easy to verify: students "
              "can single-step the clock and watch the count and the displayed value change, "
              "making the input/output behavior visible and testable. These qualities make "
              "the scoreboard a strong teaching example of sequential design (Harris & "
              "Harris, 2012).")

    head(doc, "(b) Step-by-Step Analysis of the Circuit Design")
    para(doc, "The design has four stages, shown in the block diagram below.")
    for line in DIAGRAM:
        mono(doc, line)
    para(doc, "")
    para(doc, "Step 1: Capture the score event (clock). Each scoring event produces one clean "
              "pulse. This pulse is the clock for the counter, so one event advances the "
              "count by one. A debounced button or sensor provides the pulse in a real "
              "build.")
    para(doc, "Step 2: Count with a modulo-16 counter. Four flip-flops form a 4-bit binary "
              "counter that counts 0000 through 1111 (0 to 15) and then rolls over. In a "
              "ripple (asynchronous) counter the first flip-flop toggles on every pulse and "
              "each next flip-flop is clocked by the previous output, so the outputs Q3 Q2 Q1 "
              "Q0 represent the running score in binary (Ndjountche, 2016). Using T (or JK "
              "with J = K = 1) flip-flops makes each stage toggle as required.")
    para(doc, "Step 3: Latch the value in a register. A 4-bit parallel register made of four "
              "D flip-flops sharing one clock captures the counter's outputs when a latch "
              "pulse arrives, and holds that value steady afterward. A register is precisely "
              "a group of flip-flops that stores a multi-bit word (Mano & Ciletti, 2018). "
              "Latching means the display shows a stable number even while the counter "
              "continues, avoiding flicker during transitions.")
    para(doc, "Step 4: Decode and display. A BCD-to-7-segment decoder converts the register's "
              "4-bit value into the seven signals that light the correct segments, showing "
              "the score as a digit. An asynchronous CLR line resets both the counter and the "
              "register to zero at the start of a game.")
    para(doc, "Input/output behavior. Inputs are the score pulse (clock to the counter), the "
              "latch pulse (clock to the register), and the reset. Outputs are the 4-bit "
              "count, the latched value, and the lit segments of the display. Each score "
              "pulse increments the count; each latch pulse copies the current count to the "
              "display; reset returns everything to zero.")
    para(doc, "A Logisim implementation is shown below.")
    placeholder(doc, "[ Insert Logisim screenshot of the counter + register + display here ]")

    head(doc, "(c) How Registers and Counters Work Together")
    para(doc, "The counter and the register perform complementary jobs, and the design needs "
              "both. A counter is a sequential circuit that advances through a fixed sequence "
              "of states on each clock pulse; it is the component that actually tallies the "
              "score and, being modulo-16, wraps back to zero after 15 (Ndjountche, 2016; "
              "Down to the Wires, 2020). A "
              "register, by contrast, does not count: it stores a word of data and holds it "
              "until told to load a new one. Placing a register after the counter separates "
              "counting from displaying. Without the register, the display would be tied "
              "directly to the counter and would flicker through every intermediate value as "
              "the count changed; with the register, the display updates only when a latch "
              "pulse loads the current count, so it shows a clean, stable number (Mano & "
              "Ciletti, 2018).")
    para(doc, "Their interaction is a simple pipeline synchronized by clocks. The counter's "
              "four outputs are wired to the register's four D inputs. On a score pulse the "
              "counter increments; on a latch pulse the register copies whatever the counter "
              "currently holds. Because both are edge-triggered, the timing is predictable: "
              "the register samples the counter only at the clock edge, when the counter's "
              "outputs are stable, which is the standard way flip-flop-based stages are "
              "chained safely (Harris & Harris, 2012). One timing detail matters here: a "
              "ripple counter's bits do not all change at once, because the carry propagates "
              "from stage to stage, so its outputs briefly pass through transient values "
              "before settling (Ndjountche, 2016). To avoid latching one of those transients, "
              "the latch pulse is issued after the counter has settled (or a synchronous "
              "counter, whose bits all update on the same clock edge, is used instead); the "
              "register then captures only the final, correct count, which is another reason "
              "the register improves the displayed output. The same reset clears both so they "
              "start aligned at zero. In effect, the counter is the \"producer\" of new "
              "values and the register is the \"snapshot\" that presents a value to the "
              "outside world, and the clock signals coordinate when each acts. This division "
              "of labor - one component to generate the sequence and another to hold a chosen "
              "value - is a common and powerful pattern in sequential design, and it scales: "
              "adding more counter and register bits (and a second display digit) extends the "
              "scoreboard to larger scores without changing the basic structure.")

    head(doc, "(d) Overview of Key Components")
    para(doc, "The project's key components and their roles are:")
    para(doc, "1. Modulo-16 counter (four flip-flops): tallies score events and produces the "
              "4-bit running count, rolling over after 15.")
    para(doc, "2. Four-bit parallel register (four D flip-flops): latches and holds the "
              "counter's value so the display stays stable between updates.")
    para(doc, "3. BCD-to-7-segment decoder and display: converts the held 4-bit value into a "
              "readable digit.")
    para(doc, "4. Clock and control lines: the score pulse clocks the counter, the latch "
              "pulse clocks the register, and the asynchronous reset clears both.")
    para(doc, "Working together, these components turn a stream of score pulses into a stable, "
              "readable number: the counter accumulates events, the register freezes the "
              "value to display, and the decoder shows it. The clocked, memory-based behavior "
              "of the flip-flops is what makes the scoreboard remember the score over time, "
              "which is the essence of sequential logic and the intended outcome of the "
              "project.")

    head(doc, "Academic Integrity Statement")
    para(doc, "This assignment is my own original work. The project design and all "
              "explanations were written by me, and ideas drawn from the course readings are "
              "cited in APA style in the References section below.")

    doc.add_page_break()
    head(doc, "References", level=1, center=True)
    for r in REFS:
        reference(doc, r)

    doc.save(OUTPUT)
    print(f"Created {OUTPUT}")


if __name__ == "__main__":
    build()
