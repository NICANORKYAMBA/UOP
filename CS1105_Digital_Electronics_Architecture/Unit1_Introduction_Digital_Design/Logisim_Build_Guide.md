# Logisim Build Guide — CS 1105 Unit 1

Step-by-step instructions to build the two circuits you need to screenshot for the
Discussion and the Assignment. Classic Logisim 2.7.1 (install: `sudo apt-get install -y
logisim`, run: `logisim`).

---

## Logisim quick orientation

- **Toolbar / explorer (left):** expand the "Gates" and "Wiring" folders to find gates,
  input pins, and output pins.
- **Poke tool** (the hand icon): click input pins to toggle them 0/1 and watch outputs.
- **Wiring:** click and drag from one component's port to another to draw a wire.
- Green wire = logic 1, dark/gray = logic 0 when simulating.
- To screenshot: **File → Export Image** (PNG), or just use Flameshot on the canvas.

---

## Circuit 1 — 2-Bit Binary Adder (for the DISCUSSION)

Adds A = A1A0 and B = B1B0, producing Cout, S1, S0.

### Components to place
From **Wiring**: 4 Input pins (A0, A1, B0, B1), 3 Output pins (S0, S1, Cout).
From **Gates**: 3 XOR gates, 3 AND gates, 1 OR gate.

### Wiring — Bit 0 (Half Adder)
1. `A0 XOR B0  ->  S0`
2. `A0 AND B0  ->  C0` (this carry feeds bit 1)

### Wiring — Bit 1 (Full Adder)
3. `A1 XOR B1  ->  call it X1`
4. `X1 XOR C0  ->  S1`
5. `A1 AND B1  ->  call it G1`
6. `C0 AND X1  ->  call it G2`
7. `G1 OR G2   ->  Cout`

### Verify (use the Poke/hand tool)
Toggle inputs and confirm against the truth table:
- A=11 (A1=1,A0=1), B=01 (B1=0,B0=1)  ->  Cout=1, S1=0, S0=0  (3+1=4 = 100) ✓
- A=11, B=11  ->  Cout=1, S1=1, S0=0  (3+3=6 = 110) ✓
- A=01, B=01  ->  Cout=0, S1=1, S0=0  (1+1=2 = 010) ✓

Label the pins (right-click a pin → set its Label) so the screenshot is clear, then capture.

---

## Circuit 2 — Light Bulb Controlled by a Switch (for the ASSIGNMENT)

The logic is L = S, so the minimal circuit is a direct wire (0 gates). To make it read
clearly as a "circuit," use an input pin as the switch and an output pin (or an LED) as the
bulb.

### Option A — minimal (0 gates, recommended)
1. Place 1 Input pin, label it **S (Switch)**.
2. Place 1 Output pin (or an **LED** from the Input/Output folder), label it **L (Bulb)**.
3. Draw a wire directly from S to L.
4. Poke S: when S=1 the bulb/LED lights; when S=0 it is off. Screenshot both states if you can.

### Option B — with a buffer (1 gate, if you prefer to show a gate)
1. Input pin **S** → **Buffer** gate (Gates folder) → Output pin/LED **L**.
2. Same behavior (L = S); the buffer just passes the signal through.

Either option satisfies the assignment. Option A matches the "fewest gates" argument in the
write-up (zero gates); Option B is fine if you want a visible gate component.

---

## After building

- Discussion: paste the 2-bit adder screenshot directly into the Brightspace post editor.
- Assignment: paste the switch/bulb screenshot into `Unit1_Assignment_Activity.docx` at the
  `[ Insert Logisim circuit screenshot here ]` placeholder.
