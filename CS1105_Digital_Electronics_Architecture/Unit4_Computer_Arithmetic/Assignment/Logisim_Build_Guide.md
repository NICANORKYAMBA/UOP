# Logisim Build Guide: CS 1105 Unit 4 Binary Calculator

Written for building the calculator from the assignment in Logisim 2.7.1, click by click. We
build a **4-bit prototype** of the 8-bit design in the paper. It has the same structure, just
smaller so it is realistic to wire by hand and screenshot:

- a **FullAdder** subcircuit (built from gates)
- an **AddSub4** subcircuit: 4 full adders plus XOR gates, so one circuit adds AND subtracts
- the **main** calculator: AddSub4, a Multiplier, a Divider, a MUX that picks the result by
  opcode, two hex displays, and three flags (Z, V, DIV0)

Run Logisim: `logisim`

> **Reference file:** `Unit4_Calculator_Reference.circ` in this folder is a finished,
> tested version. It was checked against all 1024 input combinations (16 values of A x 16 of
> B x 4 opcodes) and every result and flag was correct. Build your own by following this
> guide, and open the reference only if you get stuck or want to compare. Your own build and
> screenshots are what go in the paper.

Opcode used everywhere:

| OP | Operation | Result shown on the two hex digits |
|---|---|---|
| 00 | ADD | A + B (8-bit, sign extended) |
| 01 | SUB | A - B (8-bit, sign extended) |
| 10 | MUL | A x B (full 8-bit product) |
| 11 | DIV | high digit = remainder, low digit = quotient |

---

## Your tools

| Tool | What it does |
|---|---|
| **Edit (arrow)** | select, move, and change Properties |
| **Poke (hand)** | click an input pin bit to flip it 0/1 while simulating |
| **Wiring** | drag to draw wires |
| **Input pin / Output pin** | toolbar pins (or Wiring folder) |

Left **explorer tree** folders you need: **Gates** (AND, OR, XOR, NOT), **Wiring** (Splitter,
Tunnel, Constant, Bit Extender), **Plexers** (Multiplexer), **Arithmetic** (Multiplier,
Divider, Comparator), **Input/Output** (Hex Digit Display, LED).

Golden rules:
1. Place parts first, then wire.
2. **Hover over any port** of a Multiplier, Divider, MUX, or subcircuit and Logisim shows its
   name in a tooltip. Use this every time you are not sure which pin is which.
3. File then Save early as `calculator.circ` in this Assignment folder, and save often.

---

## Port cheat sheet (checked in Logisim 2.7.1)

| Component | Left side (inputs) | Right side (output) | Top / bottom |
|---|---|---|---|
| Multiplier | top = A, bottom = B | product, low 4 bits | top = carry in (leave empty), bottom = **carry out = high 4 bits** |
| Divider | top = dividend, bottom = divisor | quotient | top = upper (leave empty), bottom = **remainder** |
| Multiplexer (Select Bits 2) | inputs 0, 1, 2, 3 from top to bottom | chosen value | bottom = **select** |
| Splitter (facing East) | single fat wire | thin ends, **top end = bit 0** | |
| Subcircuit box | inputs in the same top-to-bottom order as the input pins inside it | outputs in the same top-to-bottom order as the output pins inside it | |

Divide by zero in Logisim does not show an error: the Divider just outputs the dividend as
the quotient and 0 as the remainder. That is why we build our own **DIV0** warning flag.

---

# PART A: The FullAdder subcircuit

A full adder adds three bits: A, B, and a carry in.

- **S = A XOR B XOR Cin**
- **Cout = (A AND B) OR (Cin AND (A XOR B))**

### Step 1: Create the subcircuit
1. Menu **Project then Add Circuit...**, type `FullAdder`, OK. It appears in the explorer and
   opens as an empty canvas.

### Step 2: Place the pins
1. Place 3 **input pins** down the left side, top to bottom, labeled `A`, `B`, `Cin`
   (Edit tool, click the pin, type the Label in Properties).
2. Place 2 **output pins** on the right, top to bottom: `S` then `Cout`.

Keep this top-to-bottom order. It decides the order of the ports on the subcircuit box later.

### Step 3: Place the gates
From **Gates**, place 2 x **XOR**, 2 x **AND**, 1 x **OR**. For each gate, set
**Number Of Inputs = 2** in Properties (Logisim 2.7 defaults to 5).

### Step 4: Wire it
1. `A` and `B` into **XOR 1**. Call its output X (this is A XOR B).
2. X and `Cin` into **XOR 2**. Its output goes to `S`.
3. `A` and `B` into **AND 1** (branch off the A and B wires: start a wire on the middle of an
   existing wire to make a junction dot).
4. X and `Cin` into **AND 2**.
5. AND 1 output and AND 2 output into the **OR**. Its output goes to `Cout`.

### Step 5: Test with the Poke tool

| A | B | Cin | S | Cout |
|---|---|---|---|---|
| 0 | 0 | 0 | 0 | 0 |
| 0 | 1 | 0 | 1 | 0 |
| 1 | 1 | 0 | 0 | 1 |
| 1 | 0 | 1 | 0 | 1 |
| 1 | 1 | 1 | 1 | 1 |

If every row matches, the full adder is done. **Screenshot this as Figure 1.**

---

# PART B: The AddSub4 subcircuit (adder AND subtractor)

The trick from the paper: **A - B = A + (NOT B) + 1**. Each B bit goes through an XOR gate
with a control line SUB. SUB = 0 passes B (add). SUB = 1 flips every B bit and also feeds a 1
into the first carry in (subtract).

### Step 6: Create the subcircuit
**Project then Add Circuit...**, name it `AddSub4`.

### Step 7: Pins
1. Inputs down the left, top to bottom: `A` (Data Bits **4**), `B` (Data Bits **4**),
   `SUB` (Data Bits 1).
2. Outputs on the right, top to bottom: `S` (Data Bits **4**), `C` (1 bit), `V` (1 bit).

### Step 8: Split A and B into single bits
1. From **Wiring**, place a **Splitter** next to `A`. Properties: **Fan Out = 4**,
   **Bit Width In = 4**, Facing = East. Wire `A` into its fat end.
2. Do the same for `B`.
3. The thin ends are bits 0 to 3, **bit 0 at the top**.

### Step 9: The four XOR gates (the subtract trick)
1. Place 4 **XOR** gates (2 inputs each).
2. Into XOR i: bit i of B, and `SUB`. Run one vertical SUB wire down past all four gates and
   branch into each one.
3. The outputs are "B or NOT B" bits. Call them bx0 to bx3.

### Step 10: Chain four FullAdders
1. In the explorer, click **FullAdder**, then click on the canvas 4 times to place 4 copies,
   stacked top (bit 0) to bottom (bit 3).
2. Each box has 3 inputs on the left (A, B, Cin, top to bottom) and 2 outputs on the right
   (S, Cout). Hover to confirm.
3. Wire full adder i: A input = bit i of A, B input = bx i.
4. Carries: **SUB into Cin of adder 0** (this is the "+1" for subtraction). Cout of adder 0
   into Cin of adder 1, Cout 1 into Cin 2, Cout 2 into Cin 3.

> Tidy option: instead of long wires, use **Tunnels** (Wiring folder). Two tunnels with the
> same Label are connected, like an invisible wire. The reference file uses tunnels named
> a0, bx0, c1 and so on.

### Step 11: Rebuild S and add the flags
1. Place another Splitter (Fan Out 4, Bit Width In 4) with **Facing = West**, so its fat end
   points right. Wire the S outputs of adders 0 to 3 into its thin ends (bit 0 at the top)
   and its fat end into the `S` output pin.
2. `C` = Cout of adder 3 (carry out of the top bit).
3. `V` (overflow): place one XOR. Inputs = Cout of adder 2 (carry INTO the sign bit) and
   Cout of adder 3 (carry OUT of the sign bit). Output to `V`.

### Step 12: Test AddSub4

| A | B | SUB | S | C | V | Meaning |
|---|---|---|---|---|---|---|
| 0101 | 0010 | 0 | 0111 | 0 | 0 | 5 + 2 = 7 |
| 0101 | 0010 | 1 | 0011 | 1 | 0 | 5 - 2 = 3 (C = 1 means no borrow) |
| 0010 | 0101 | 1 | 1101 | 0 | 0 | 2 - 5 = -3 in two's complement |
| 0111 | 0001 | 0 | 1000 | 0 | 1 | 7 + 1 overflows 4-bit signed range |

**Screenshot this as Figure 2** (a subtract case like 5 - 2 looks best).

---

# PART C: The main calculator

Double-click **main** in the explorer to go back to it.

### Step 13: Inputs
Input pins on the left: `A` (4 bits), `B` (4 bits), `OP` (2 bits).

### Step 14: Split OP
Splitter: Fan Out 2, Bit Width In 2, facing East. Top end = **op0**, bottom end = **op1**.

### Step 15: Add/Sub block
1. Place one **AddSub4** (click it in the explorer, then the canvas).
2. Wire: A into its first input, B into the second, **op0 into SUB** (so OP 00 adds and
   OP 01 subtracts).
3. From **Wiring**, place a **Bit Extender**: Bit Width In 4, Bit Width Out 8,
   **Extension Type = Sign**. Wire AddSub4's S output into it. This turns 1101 (-3) into
   1111 1101 so negative results display correctly as 8 bits.

### Step 16: Multiplier block
1. From **Arithmetic**, place a **Multiplier**, Data Bits = 4. A into the top left input,
   B into the bottom left input. Leave carry in (top) empty.
2. The product comes out as two 4-bit parts: right side = low 4 bits, bottom = high 4 bits.
3. Join them with a Splitter: Fan Out 2, Bit Width In 8, **Facing = West**. Then check
   the bit mapping in Properties: **Bit 0 to Bit 3 = 0** (top end) and **Bit 4 to Bit 7 = 1**
   (bottom end). Wire the low part to the top end and the high part to the bottom end.
   Its fat end is now the 8-bit product.

### Step 17: Divider block
1. From **Arithmetic**, place a **Divider**, Data Bits = 4. A into the top left (dividend),
   B into the bottom left (divisor). Leave upper (top) empty.
2. Join quotient (right side) and remainder (bottom) with the same kind of splitter:
   quotient to the top end (low bits), remainder to the bottom end (high bits). So the display
   shows remainder then quotient: 13 / 3 shows **14** (remainder 1, quotient 4).

### Step 18: The MUX (operation select)
1. From **Plexers**, place a **Multiplexer**: **Select Bits = 2**, **Data Bits = 8**.
2. Inputs top to bottom: 0 = Add/Sub result, 1 = Add/Sub result again (same wire, branch it),
   2 = product, 3 = divider result.
3. Wire the full 2-bit `OP` into the select input at the bottom.
4. MUX output into an output pin `Result` (Data Bits 8).

### Step 19: Hex displays
1. Splitter on the Result wire: Fan Out 2, Bit Width In 8, facing East, bits 0 to 3 to the
   top end and 4 to 7 to the bottom end.
2. Place two **Hex Digit Display** (Input/Output folder) side by side. The input is at the
   bottom of each display.
3. Top end (low nibble) to the **right** display, bottom end (high nibble) to the **left**
   display, so they read like a normal number.

### Step 20: Flags
1. **Z (zero):** place a **Comparator** (Arithmetic, Data Bits 8). Result into the top input,
   an 8-bit **Constant** of 0 into the bottom input. The middle output (=) goes to an output
   pin or LED labeled `Z`.
2. **V (overflow):** AND gate with inputs: V from AddSub4, and **NOT op1** (NOT gate on op1).
   Output to `V`. This hides V during MUL and DIV, where it means nothing.
3. **DIV0:** Comparator (Data Bits 4) with B on top and a 4-bit Constant 0 below. Then a
   3-input AND of: the = output, op1, op0. Output to `DIV0`. It lights only for OP 11 with
   B = 0.

---

# PART D: Test the whole calculator

Set A, B, and OP with the Poke tool and check each row. These are the exact values the
reference circuit produces.

| Test | A | B | OP | Result (binary) | Hex display | Flags |
|---|---|---|---|---|---|---|
| 5 + 2 | 0101 | 0010 | 00 | 0000 0111 | 07 | all 0 |
| 5 - 2 | 0101 | 0010 | 01 | 0000 0011 | 03 | all 0 |
| 2 - 5 | 0010 | 0101 | 01 | 1111 1101 | FD (= -3) | all 0 |
| 7 + 1 | 0111 | 0001 | 00 | 1111 1000 | F8 | **V = 1** |
| 6 - 6 | 0110 | 0110 | 01 | 0000 0000 | 00 | **Z = 1** |
| 13 x 11 | 1101 | 1011 | 10 | 1000 1111 | 8F (= 143) | all 0 |
| 13 / 3 | 1101 | 0011 | 11 | 0001 0100 | 14 (r 1, q 4) | all 0 |
| 13 / 0 | 1101 | 0000 | 11 | 0000 1101 | 0D | **DIV0 = 1** |

The 13 x 11 and 13 / 3 rows are the same examples worked by hand in the paper, so the
screenshots prove the hand calculations.

---

# PART E: Screenshots for the paper

Save each screenshot into the `figures` folder with exactly these names. Then run
`python3 build_docx.py` from the Unit 4 folder and the images go into the Word file
automatically in the right places (if a file is missing, a placeholder box is left instead).

| File name | What to show |
|---|---|
| `figures/fig1_fulladder.png` | FullAdder with A = 1, B = 1, Cin = 1 (S = 1, Cout = 1) |
| `figures/fig2_addsub4.png` | AddSub4 doing 5 - 2 (SUB = 1, S = 0011) |
| `figures/fig3_multiply.png` | main with 13 x 11, display shows **8F** |
| `figures/fig4_divide.png` | main with 13 / 3, display shows **14** |
| `figures/fig5_flags.png` | main with 13 / 0, **DIV0** lit (or 7 + 1 with V lit) |

How to capture: **File then Export Image...** in Logisim (choose PNG), or Flameshot. Crop so
the circuit fills the picture.

---

## Troubleshooting

- **Orange wire / "Incompatible widths":** a 1-bit wire hit a 4-bit or 8-bit port. Check the
  Data Bits of both ends.
- **Red wire / E:** two outputs are driving the same wire. Often a wire end landed on the
  wrong port or two outputs touched. Delete it and redraw.
- **Blue wire:** nothing is driving it (floating). A wire does not quite reach a port.
- **Product or divider value looks scrambled:** the 8-bit splitter bit mapping is wrong.
  Set Bit 0 to 3 = 0 and Bit 4 to 7 = 1 in Properties.
- **Negative results show 0D instead of FD:** the Bit Extender type is Zero, set it to Sign.
- **Subtraction is off by one:** SUB is not connected to Cin of the first full adder.
- **Rotate a part:** select it, then Properties then Facing.

## Scaling to the 8-bit design in the paper

Nothing new is needed: chain 8 FullAdders instead of 4 (an "AddSub8"), set the Multiplier and
Divider to Data Bits 8, make the product 16 bits, and use four hex digits. The structure,
opcodes, and flags stay exactly the same, which is the point of the integrated design.
