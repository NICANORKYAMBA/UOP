#!/usr/bin/env python3
"""Writes figures/fig2_physical_erd.dot (crow's foot notation) and renders it to PNG with Graphviz."""
import subprocess
from pathlib import Path

HERE = Path(__file__).resolve().parent
TABLES = {
    "Customer": [("PK", "customer_id", "INT"), ("", "first_name", "VARCHAR(50)"), ("", "last_name", "VARCHAR(50)"),
                 ("UQ", "email", "VARCHAR(100)"), ("", "phone", "VARCHAR(20)"), ("", "shipping_address", "VARCHAR(255)")],
    "Orders": [("PK", "order_id", "INT"), ("FK", "customer_id", "INT"), ("", "order_date", "DATE"),
               ("", "status", "VARCHAR(20)"), ("", "total_amount", "DECIMAL(10,2)")],
    "Order_Item": [("PK, FK", "order_id", "INT"), ("PK, FK", "product_id", "INT"), ("", "quantity", "INT"),
                   ("", "unit_price", "DECIMAL(10,2)")],
    "Product": [("PK", "product_id", "INT"), ("UQ", "sku", "VARCHAR(30)"), ("", "product_name", "VARCHAR(100)"),
                ("", "category", "VARCHAR(50)"), ("", "unit_price", "DECIMAL(10,2)")],
    "Inventory": [("PK", "inventory_id", "INT"), ("FK", "product_id", "INT"), ("", "warehouse_location", "VARCHAR(50)"),
                  ("", "quantity_on_hand", "INT"), ("", "reorder_level", "INT"), ("", "last_updated", "DATE")],
}
# (parent port, child port, parent end, child end, parent label, child label, verb)
RELATIONSHIPS = [
    ("Customer", "Orders", "teetee", "crowodot", "1..1", "0..*", "places"),
    ("Orders", "Order_Item", "teetee", "crowtee", "1..1", "1..*", "contains"),
    ("Product", "Order_Item", "teetee", "crowodot", "1..1", "0..*", "appears in"),
    ("Product", "Inventory", "teetee", "crowodot", "1..1", "0..*", "stocked as"),
]


def row(key, col, typ):
    key_cell = f'<FONT COLOR="#8a1c1c"><B>{key}</B></FONT>' if key else " "
    name = f"<B><U>{col}</U></B>" if "PK" in key else col
    return (f'<TR><TD ALIGN="LEFT">{key_cell}</TD><TD ALIGN="LEFT" PORT="{col}">{name}</TD>'
            f'<TD ALIGN="LEFT"><FONT COLOR="#555555">{typ}</FONT></TD></TR>')


lines = ["digraph Physical {",
         '  graph [rankdir=LR, nodesep=0.9, ranksep=1.9, fontname="Helvetica", bgcolor=white, pad=0.3];',
         '  node [shape=plain, fontname="Helvetica", fontsize=11];',
         '  edge [dir=both, penwidth=1.5, fontname="Helvetica-Bold", fontsize=11, arrowsize=1.2];']
for name, cols in TABLES.items():
    body = "".join(row(*c) for c in cols)
    lines.append(f'  {name} [label=<<TABLE BORDER="1" CELLBORDER="0" CELLSPACING="0" CELLPADDING="4" BGCOLOR="white">'
                 f'<TR><TD COLSPAN="3" BGCOLOR="#1f5aa6"><FONT COLOR="white"><B>{name}</B></FONT></TD></TR>{body}</TABLE>>];')
for a, b, tail, head, tl, hl, verb in RELATIONSHIPS:
    lines.append(f'  {a} -> {b} [arrowtail={tail}, arrowhead={head}, tailport=e, headport={"s" if b == "Order_Item" and a == "Product" else "w"}, '
                 f'label=<<B>{verb}</B><BR/>{tl} to {hl}>];')
lines += ["  { rank=same; Orders; Product; }", "  { rank=same; Order_Item; Inventory; }",
          '  legend [label=<<TABLE BORDER="1" CELLBORDER="0" CELLPADDING="3" BGCOLOR="#f7f7f7">'
          '<TR><TD ALIGN="LEFT"><B>Key</B></TD></TR>'
          '<TR><TD ALIGN="LEFT">PK = primary key, FK = foreign key, UQ = unique</TD></TR>'
          '<TR><TD ALIGN="LEFT">Two bars = exactly one (1..1), mandatory</TD></TR>'
          '<TR><TD ALIGN="LEFT">Bar + crow\'s foot = one or many (1..*), mandatory</TD></TR>'
          '<TR><TD ALIGN="LEFT">Circle + crow\'s foot = zero or many (0..*), optional</TD></TR></TABLE>>];',
          "  { rank=same; Customer; legend; }", "}"]
dot = HERE / "figures" / "fig2_physical_erd.dot"
dot.write_text("\n".join(lines) + "\n")
subprocess.run(["dot", "-Tpng", "-Gdpi=170", str(dot), "-o", str(dot.with_suffix(".png"))], check=True)
print("Rendered", dot.with_suffix(".png"))
