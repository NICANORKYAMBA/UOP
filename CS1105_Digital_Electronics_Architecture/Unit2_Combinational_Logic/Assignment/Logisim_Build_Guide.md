# Logisim Build Guide — CS 1105 Unit 2 Security Circuit

Written for a first-time Logisim user. We build a **representative** version of the smart-home
security system from the assignment: a 2-bit code comparator (built from XNOR + AND gates)
that outputs a **GRANT** signal, and a small **decoder** that routes that grant to unlock
exactly one selected room. This is the "wherever applicable" Logisim piece for the assignment.

Run Logisim: `logisim`  (installed at `/usr/bin/logisim`)

> Why this version? The full house-wide system (encoder + MUX + comparator + decoder + demux)
> is large. A 2-bit comparator + 2-to-4 decoder captures the same combinational ideas — gate
> logic makes the grant decision, and a decoder routes it to one room — and is realistic to
> wire by hand and screenshot. It maps directly onto the design in the written assignment.

---

## Your tools (top toolbar + left explorer)

| Tool | Look | What it does |
|------|------|--------------|
| **Edit (arrow)** | arrow | select / move components |
| **Poke (hand)** | hand | click an input pin to toggle 0/1 during simulation |
| **Wiring** | short line between dots | drag to draw wires |
| **Input pin** | green square with a dot | a switch you can toggle |
| **Output pin** | circle/square outline | shows a result (our "unlock light") |

In the **left explorer tree**: open **Gates** for XNOR and AND; open **Plexers** for the
**Decoder**; open **Wiring** for pins (or use the toolbar pin tools).

Set a component's **Label** or **facing** in the bottom-left **Properties** panel after
selecting it with the Edit tool.

Golden rule: **place components first, then wire.** Use **File → Save** early (e.g.
`security.circ` in this folder).

---

# PART A — The 2-bit code comparator (the GRANT decision)

We compare a 2-bit **entered code** `A1 A0` against a 2-bit **stored code** `S1 S0`.
Grant = 1 only when both bits match:

**Grant = (A0 XNOR S0) AND (A1 XNOR S1)**

### Step 1 — Place 4 input pins
Using the **Input pin** tool, place 4 pins down the left side. Select each with the Edit tool
and set **Label** in Properties:
- `A0`, `A1`  (the entered code — put these near the top)
- `S0`, `S1`  (the stored code — below them)

### Step 2 — Place the gates
Open the **Gates** folder in the explorer:
- Drag **2 × XNOR** gates onto the middle of the canvas.
- Drag **1 × AND** gate to the right of the XNORs.

(A gate's inputs are on its **left**, output on its **right**.)

### Step 3 — Wire the two XNOR comparisons
- Wire `A0` and `S0` into the two inputs of the **first XNOR** → this checks if bit 0 matches.
- Wire `A1` and `S1` into the two inputs of the **second XNOR** → checks if bit 1 matches.

### Step 4 — Combine with AND
- Wire the **first XNOR output** and the **second XNOR output** into the two inputs of the
  **AND** gate. The AND output is the **GRANT** signal (1 only when both bits match).

Leave the AND output on a short wire — Part B uses it. Don't connect it to an output pin yet.

---

# PART B — The 2-to-4 decoder (route GRANT to one room)

Two **room-select** bits `R1 R0` pick which of four rooms the user wants. A **decoder**
activates exactly one of its four outputs; we gate each with GRANT so only the selected room
unlocks, and only when access is granted.

### Step 5 — Place the room-select inputs and the decoder
1. Using the **Input pin** tool, place 2 more input pins lower on the left. Label them
   `R0` and `R1`.
2. Open the **Plexers** folder in the explorer and drag a **Decoder** onto the canvas
   (to the right, near the AND output).
3. Select the decoder. In **Properties**, set **Select Bits = 2**. It now has 4 outputs
   (labeled 0,1,2,3) and one 2-bit select input at the bottom (or side).

### Step 6 — Wire the select bits into the decoder
- Wire `R0` and `R1` into the decoder's **select** input.
  - If the decoder shows a single 2-bit select port, use a **Splitter** (Wiring folder,
    Fan Out = 2, Bit Width In = 2) to feed R0 into bit 0 and R1 into bit 1.
  - Simpler alternative: in the decoder Properties you can often keep two 1-bit select pins —
    wire R0 to the lower select bit and R1 to the upper. Either way, R1R0 chooses output 0–3.

### Step 7 — Gate each decoder output with GRANT
For each room you want to demonstrate (do at least **Room 0** and **Room 1**):
1. Drag an **AND** gate (Gates folder) near the decoder output.
2. Wire the **decoder output N** and the **GRANT** wire (from Step 4) into that AND gate.
3. Wire the AND output to an **Output pin** labeled `Unlock_Room0` (repeat: `Unlock_Room1`,
   etc.).

Now `Unlock_RoomN = decoder_output_N AND GRANT`, so a room unlocks only when it is selected
**and** the entered code matches the stored code.

> Tip: to show a real light, use an **LED** from the **Input/Output** folder instead of a
> plain output pin. Same wiring.

---

# Testing with the Poke tool (hand)

Pick a stored code to demonstrate, e.g. set the "stored" switches to **S1 S0 = 1 0** (binary
2). Then toggle inputs and confirm:

| A1 A0 | S1 S0 | R1 R0 | GRANT | Unlock_Room selected | Meaning |
|-------|-------|-------|-------|----------------------|---------|
| 1 0   | 1 0   | 0 0   | 1     | Room0 = 1            | Correct code, Room 0 → unlocks ✓ |
| 1 0   | 1 0   | 0 1   | 1     | Room1 = 1            | Correct code, Room 1 → unlocks ✓ |
| 0 1   | 1 0   | 0 0   | 0     | Room0 = 0            | Wrong code → denied ✓ |
| 1 1   | 1 0   | 0 1   | 0     | Room1 = 0            | Wrong code → denied ✓ |

Green wires = logic 1, gray/black = 0 during simulation. If a row is wrong, re-check that the
XNOR inputs go to the matching bit pair (A0–S0, A1–S1) and that each output AND uses the
correct decoder line.

---

# Screenshot for the assignment

1. Toggle a **granted** case (row 1 above: A=10, S=10, R=00) so `GRANT` and `Unlock_Room0`
   are green and clearly on.
2. Capture the canvas with Flameshot (or your screenshot tool).
3. Paste it into `Unit2_Assignment_Activity.docx` at the
   **`[ Insert Logisim circuit screenshot here ]`** placeholder.

Optionally take a second screenshot of a **denied** case (wrong code, GRANT = 0) to show the
comparator blocking access — it strengthens the "logic and computation" evidence.

---

## Handy tips
- **Delete a mistake:** Edit tool → click the wire/gate → press Delete.
- **Red/blue wires** mean an error (unconnected, wrong bit width, or two outputs fighting).
  A width mismatch usually means a 1-bit wire hit a multi-bit port — check the decoder select.
- **Rotate a gate:** select it → Properties → **Facing**.
- **Save often:** File → Save (`security.circ` in this Assignment folder).
