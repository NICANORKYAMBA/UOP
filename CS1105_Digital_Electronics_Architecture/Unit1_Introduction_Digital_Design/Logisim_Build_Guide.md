# Logisim Beginner Walkthrough — CS 1105 Unit 1

Written for a first-time Logisim user. We build two circuits, click by click.
Install: `sudo apt-get install -y logisim`  •  Run: `logisim`

---

## Know your 4 main tools (top toolbar, left group)

Logisim has tools in the toolbar. The four you need:

| Tool | Icon look | What it does |
|------|-----------|--------------|
| **Edit/Poke (arrow/hand)** | arrow | selects, and (as a hand) clicks inputs to toggle 0/1 |
| **Wiring tool** | a small line between two dots | draws wires by dragging |
| **Input pin** | a green square with a dot | an input you can toggle (our "switch") |
| **Output pin** | a circle/square outline | shows a result (our "bulb") |

Also, on the **left side** there is an **explorer tree** with folders. Open the **Gates**
folder to find AND, OR, XOR, etc. Open **Wiring** for pins (or use the toolbar pin tools).

When you click a component in the explorer, look at the **bottom-left "Properties" panel** —
that's where you set things like a pin's **Label** or a gate's **facing** direction.

Golden rule: **place components first, then wire them.** And **File → Save** early.

---

# CIRCUIT 1 (do this first — the easy one): Switch → Bulb

This is the ASSIGNMENT circuit. The logic is L = S, so it is literally one input wired to
one output. Great for learning the tool.

### Step 1 — Place the input pin (the switch)
1. In the toolbar, click the **Input pin** tool (green square with a dot).
2. Click once on the **left side** of the canvas. A small green pin appears. This is **S**.

### Step 2 — Label it "S"
1. Click the **Edit tool** (arrow), then click your input pin to select it.
2. In the bottom-left **Properties** panel, find **Label** and type `S`.

### Step 3 — Place the output pin (the bulb)
1. Click the **Output pin** tool in the toolbar.
2. Click once on the **right side** of the canvas, roughly level with S. This is **L**.
3. Select it with the Edit tool and set its **Label** to `L` in Properties.

### Step 4 — Wire S to L
1. Click the **Wiring tool** (or just use the Edit tool — hovering over a pin's connection
   point shows a small green circle).
2. Press and hold the mouse on the **right edge of S** (the connection nub), drag across to
   the **left edge of L**, and release. A wire connects them.
   - Wires are only horizontal/vertical. If S and L are level, one straight drag works. If
     not, drag horizontally, release, then drag vertically to finish the corner.

### Step 5 — Test it
1. Click the **Poke tool** (the hand).
2. Click on **S**. It toggles to 1 — the wire turns green and **L lights up (green)**.
3. Click **S** again → 0 → wire goes gray, L turns off.
   That is exactly "bulb on when switch is on, off when off." Done!

### Step 6 — Screenshot
- Take one screenshot with S = 1 (bulb on) so the behavior is visible.
- Flameshot the canvas, then paste into `Unit1_Assignment_Activity.docx` at the
  `[ Insert Logisim circuit screenshot here ]` spot.

> Optional: to show a real "bulb," open the **Input/Output** folder in the explorer and use
> an **LED** instead of the plain output pin. Same wiring. Not required though.

---

# CIRCUIT 2: 2-Bit Binary Adder (for the DISCUSSION)

This is bigger but we go slow. It adds A (A1 A0) + B (B1 B0) and gives Cout, S1, S0.
We build it in two halves: a **half adder** for bit 0, then a **full adder** for bit 1.

### Step 1 — Place the 4 input pins
Using the Input pin tool, place 4 pins down the left side and label them (Edit tool →
Properties → Label):
- `A0`, `B0`  (the bit-0 pair, put these together near the top)
- `A1`, `B1`  (the bit-1 pair, below them)

### Step 2 — Place the 3 output pins
Using the Output pin tool, place 3 pins down the right side and label them:
- `S0` (top), `S1` (middle), `Cout` (bottom)

### Step 3 — Get your gates
Open the **Gates** folder in the explorer. You will drag these onto the canvas:
- **3 × XOR** gates
- **3 × AND** gates
- **1 × OR** gate

Click "XOR" in the explorer, then click on the canvas to drop one. Repeat for each gate.
Place them in the middle, leaving space. Tip: a gate's inputs are on its **left**, output on
its **right**. (If you ever need to rotate one, select it and change **Facing** in Properties.)

### Step 4 — Wire BIT 0 (Half Adder)
- **S0:** wire `A0` and `B0` into the two inputs of an **XOR** gate; wire that XOR's output
  to **S0**.  → this is `S0 = A0 XOR B0`.
- **C0 (internal carry):** wire `A0` and `B0` also into an **AND** gate. Its output is the
  carry **C0**. Leave its output on a short wire; we reuse it in bit 1.
  → `C0 = A0 AND B0`.

(You can wire one pin to two gates: just start a new wire drag from the same pin/wire.)

### Step 5 — Wire BIT 1 (Full Adder)
Let **X1 = A1 XOR B1** be a helper.
1. Wire `A1` and `B1` into a **second XOR** gate → call its output **X1**.
2. Wire **X1** and **C0** into a **third XOR** gate → its output goes to **S1**.
   → `S1 = A1 XOR B1 XOR C0`.
3. Wire `A1` and `B1` into a **second AND** gate → call it **G1**.
4. Wire **C0** and **X1** into a **third AND** gate → call it **G2**.
5. Wire **G1** and **G2** into the **OR** gate → its output goes to **Cout**.
   → `Cout = (A1 AND B1) OR (C0 AND (A1 XOR B1))`.

### Step 6 — Test with the Poke tool (hand)
Toggle the inputs and check against the truth table:
- A1A0 = 11, B1B0 = 01  →  Cout=1, S1=0, S0=0  (3+1 = 4 = 100) ✓
- A1A0 = 11, B1B0 = 11  →  Cout=1, S1=1, S0=0  (3+3 = 6 = 110) ✓
- A1A0 = 01, B1B0 = 01  →  Cout=0, S1=1, S0=0  (1+1 = 2 = 010) ✓

If a row is wrong, re-check that wire — usually a gate input is connected to the wrong pin.

### Step 7 — Screenshot
Screenshot the finished circuit (ideally with one test case toggled on so wires show green),
then paste it into your Brightspace discussion post.

---

## Handy tips
- **Delete a mistake:** Edit tool → click the wire/gate → press Delete.
- **Blue/red wires** mean an error (e.g., two outputs fighting, or unconnected). Green = 1,
  gray/black = 0 during simulation.
- **Save often:** File → Save As → put it in this folder, e.g. `adder.circ` and `bulb.circ`.
