#!/usr/bin/env python3
"""
Generate the APA .docx for MATH 1201 Unit 4 (Polynomials II: Higher-Order and
Rational Functions) from the Markdown source, so the .md and .docx never drift apart. Double-spaced Times
New Roman, title page, native heading styles, monospaced diagrams, real Word
tables, hanging-indent references with clickable links.

Usage:  python3 build_docx.py
Output: Assignment/Unit4_Assignment_Activity.docx
GeoGebra screenshots in Assignment/figures/ are inserted automatically.
"""

import re
from pathlib import Path

from docx import Document
from docx.enum.text import WD_ALIGN_PARAGRAPH, WD_LINE_SPACING
from docx.opc.constants import RELATIONSHIP_TYPE as RT
from docx.oxml import OxmlElement
from docx.oxml.ns import qn
from docx.shared import Inches, Pt, RGBColor

FONT = "Times New Roman"
SPACING = 1.5  # body line spacing (user preference for this course)
MONO = "Courier New"
HERE = Path(__file__).resolve().parent

AUTHOR = "Nicanor Maswili"
AFFIL = "Department of Mathematics, University of the People"
COURSE = "MATH 1201: College Algebra"
INSTRUCTOR = "Instructor: Chibuike Agu"
DUE = "September 30, 2026"

JOBS = [
    ("Assignment/Unit4_Assignment_Activity.md", "Assignment/Unit4_Assignment_Activity.docx"),
]

URL = re.compile(r"(https?://\S+)")


def base(doc):
    st = doc.styles["Normal"]
    st.font.name = FONT
    st.font.size = Pt(12)
    st.paragraph_format.line_spacing = SPACING
    st.paragraph_format.space_after = Pt(0)
    for h, sz in (("Title", 16), ("Heading 1", 13), ("Heading 2", 12), ("Heading 3", 12)):
        s = doc.styles[h]
        s.font.name = FONT
        s.font.size = Pt(sz)
        s.font.bold = True
        s.font.color.rgb = RGBColor(0, 0, 0)
        s.paragraph_format.line_spacing = SPACING
        s.paragraph_format.space_before = Pt(0)
        s.paragraph_format.space_after = Pt(0)
    for sec in doc.sections:
        sec.top_margin = sec.bottom_margin = Inches(1)
        sec.left_margin = sec.right_margin = Inches(1)


def run(p, text, bold=False, italic=False):
    r = p.add_run(text)
    r.bold, r.italic = bold, italic
    r.font.name = FONT
    r.font.size = Pt(12)
    return r


def hyperlink(p, url):
    rid = p.part.relate_to(url, RT.HYPERLINK, is_external=True)
    h = OxmlElement("w:hyperlink")
    h.set(qn("r:id"), rid)
    r = OxmlElement("w:r")
    rpr = OxmlElement("w:rPr")
    fonts = OxmlElement("w:rFonts")
    fonts.set(qn("w:ascii"), FONT)
    fonts.set(qn("w:hAnsi"), FONT)
    color = OxmlElement("w:color")
    color.set(qn("w:val"), "0563C1")
    u = OxmlElement("w:u")
    u.set(qn("w:val"), "single")
    sz = OxmlElement("w:sz")
    sz.set(qn("w:val"), "24")
    for el in (fonts, color, u, sz):
        rpr.append(el)
    r.append(rpr)
    t = OxmlElement("w:t")
    t.text = url
    r.append(t)
    h.append(r)
    p._p.append(h)


def inline(p, text):
    """Write text with **bold**, *italic*, and clickable URLs."""
    for chunk in re.split(r"(\*\*[^*]+\*\*)", text):
        if chunk.startswith("**") and chunk.endswith("**"):
            run(p, chunk[2:-2], bold=True)
            continue
        for i, seg in enumerate(chunk.split("*")):
            for piece in URL.split(seg):
                if URL.fullmatch(piece):
                    hyperlink(p, piece)
                elif piece:
                    run(p, piece, italic=(i % 2 == 1))


def para(doc, text="", align=None, block=False, indent=False, hanging=False):
    """Body text: double spaced; block=True adds space after (block style), indent=True indents."""
    p = doc.add_paragraph()
    pf = p.paragraph_format
    pf.line_spacing = SPACING
    pf.space_after = Pt(10) if block else Pt(0)
    if indent:
        pf.first_line_indent = Inches(0.5)
    if hanging:
        pf.left_indent = Inches(0.5)
        pf.first_line_indent = Inches(-0.25)
    if align is not None:
        p.alignment = align
    inline(p, text)
    return p


def page_numbers(doc):
    """APA 7 page number, top right of every page."""
    for sec in doc.sections:
        p = sec.header.paragraphs[0]
        p.alignment = WD_ALIGN_PARAGRAPH.RIGHT
        r = p.add_run()
        r.font.name = FONT
        r.font.size = Pt(12)
        for tag, text in (("begin", None), (None, "PAGE"), ("end", None)):
            if tag:
                el = OxmlElement("w:fldChar")
                el.set(qn("w:fldCharType"), tag)
            else:
                el = OxmlElement("w:instrText")
                el.set(qn("xml:space"), "preserve")
                el.text = text
            r._r.append(el)


def head(doc, text, level=2, center=False):
    p = doc.add_heading(level=level)
    if center:
        p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(text)
    r.bold = True
    r.font.name = FONT
    r.font.size = Pt(12)
    r.font.color.rgb = RGBColor(0, 0, 0)


def mono(doc, lines):
    for line in lines:
        p = doc.add_paragraph()
        p.paragraph_format.line_spacing_rule = WD_LINE_SPACING.SINGLE
        p.paragraph_format.space_after = Pt(0)
        p.paragraph_format.left_indent = Inches(0.3)
        r = p.add_run(line if line else " ")
        r.font.name = MONO
        r.font.size = Pt(9.5)
    doc.add_paragraph().paragraph_format.space_after = Pt(0)


def table(doc, rows):
    cells = [[c.strip() for c in r.strip().strip("|").split("|")] for r in rows]
    cells = [r for r in cells if not all(set(c) <= set("-: ") for c in r)]
    t = doc.add_table(rows=len(cells), cols=len(cells[0]))
    t.style = "Table Grid"
    for i, row in enumerate(cells):
        for j, val in enumerate(row):
            p = t.cell(i, j).paragraphs[0]
            p.paragraph_format.line_spacing = 1.0
            r = p.add_run(val.replace("**", ""))
            r.font.name = FONT
            r.font.size = Pt(10.5)
            r.bold = i == 0
    doc.add_paragraph().paragraph_format.space_after = Pt(0)


def figure(doc, rel):
    path = HERE / "Assignment" / rel
    p = doc.add_paragraph()
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    p.paragraph_format.space_after = Pt(10)
    if path.exists():
        p.add_run().add_picture(str(path), width=Inches(6))
    else:
        run(p, f"[ Insert Logisim screenshot: {rel} ]", bold=True)


def bullet(doc, text):
    p = doc.add_paragraph()
    p.paragraph_format.line_spacing = SPACING
    p.paragraph_format.left_indent = Inches(0.5)
    p.paragraph_format.first_line_indent = Inches(-0.25)
    p.paragraph_format.space_after = Pt(0)
    run(p, "\u2022  ")
    inline(p, text)


def reference(doc, text):
    p = doc.add_paragraph()
    pf = p.paragraph_format
    pf.line_spacing = SPACING
    pf.left_indent = Inches(0.5)
    pf.first_line_indent = Inches(-0.5)
    pf.space_after = Pt(0)
    inline(p, text)


def blocks(lines):
    """Group Markdown lines into (kind, payload) blocks."""
    i = 0
    while i < len(lines):
        line = lines[i]
        if line.startswith("```"):
            j = i + 1
            while not lines[j].startswith("```"):
                j += 1
            yield "code", lines[i + 1:j]
            i = j + 1
        elif line.startswith("|"):
            j = i
            while j < len(lines) and lines[j].startswith("|"):
                j += 1
            yield "table", lines[i:j]
            i = j
        elif line.startswith("#"):
            yield "head", line
            i += 1
        elif not line.strip():
            i += 1
        elif line.startswith("[FIGURE "):
            yield "figure", line[len("[FIGURE "):].rstrip("]").strip()
            i += 1
        else:
            j = i
            while (j < len(lines) and lines[j].strip() and lines[j][0] not in "#|`"
                   and not lines[j].startswith("[FIGURE ")
                   and not (j > i and re.match(r"(\d+\.|-) ", lines[j]))):
                j += 1
            yield "para", " ".join(l.strip() for l in lines[i:j])
            i = j


def build(src, out):
    lines = (HERE / src).read_text().splitlines()
    title = lines[0].lstrip("# ").strip()
    body = [l for l in lines[1:] if not re.match(r"\*\*(Course|Student|Instructor|Due):\*\*", l)]

    doc = Document()
    base(doc)
    for _ in range(4):
        para(doc, "", block=False)
    p = doc.add_paragraph(style="Title")
    p.alignment = WD_ALIGN_PARAGRAPH.CENTER
    r = p.add_run(title)
    r.bold = True
    r.font.name = FONT
    r.font.size = Pt(12)
    r.font.color.rgb = RGBColor(0, 0, 0)
    page_numbers(doc)
    para(doc, "", block=False)
    for line in (AUTHOR, AFFIL, COURSE, INSTRUCTOR, DUE):
        para(doc, line, align=WD_ALIGN_PARAGRAPH.CENTER, block=False)
    doc.add_page_break()
    head(doc, title, level=1, center=True)

    in_refs = False
    for kind, data in blocks(body):
        if kind == "head":
            level = len(data) - len(data.lstrip("#"))
            text = data.lstrip("# ").strip()
            if text == "References":
                doc.add_page_break()
                head(doc, text, level=1, center=True)
                in_refs = True
            else:
                head(doc, text, level=1 if level == 2 else 2, center=(level == 2))
        elif kind == "code":
            mono(doc, data)
        elif kind == "table":
            table(doc, data)
        elif kind == "figure":
            figure(doc, data)
        elif in_refs:
            reference(doc, data)
        elif data.startswith("- "):
            bullet(doc, data[2:])
        elif re.fullmatch(r"\*\*(Table|Figure) \d+\*\*", data) or re.fullmatch(r"\*[^*].*[^*]\*", data):
            para(doc, data)  # APA table/figure number and italic title: no indent
        elif re.match(r"\d+\. ", data):
            para(doc, data, hanging=True)
        elif data.startswith(("Word count", "**Question for the class")):
            para(doc, data)
        else:
            para(doc, data, block=True)  # block paragraphs, as in earlier units

    doc.save(HERE / out)
    print(f"Created {out}")


if __name__ == "__main__":
    for src, out in JOBS:
        build(src, out)
