═══════════════════════════════════════════════════════════════════════════════
LOGIC GATE DIAGRAM FOR A⋅(I + L′)
═══════════════════════════════════════════════════════════════════════════════

SIMPLIFIED EXPRESSION: A⋅(I + L′)

This requires 3 gates:
1. NOT gate (to create L′ from L)
2. OR gate (to create I + L′)
3. AND gate (to create final output A⋅(I + L′))

═══════════════════════════════════════════════════════════════════════════════
ASCII DIAGRAM:
═══════════════════════════════════════════════════════════════════════════════

                                    ┌─────────┐
                            ┌──────►│         │
                            │       │   OR    │──────┐
Input I ────────────────────┘       │  GATE   │      │
                                    │         │      │
                                    └─────────┘      │
                                                     │
                                                     │    ┌─────────┐
                                                     └───►│         │
                                                          │   AND   │────► OUTPUT
Input A ─────────────────────────────────────────────────►│  GATE   │
                                                          │         │
                                                          └─────────┘
                    ┌─────────┐
Input L ───────────►│   NOT   │──────┐
                    │  GATE   │      │
                    └─────────┘      │
                                     │       ┌─────────┐
                                     └──────►│         │
                                             │   OR    │
                                             │  GATE   │
                                             │         │
                                             └─────────┘


═══════════════════════════════════════════════════════════════════════════════
CLEANER VERSION:
═══════════════════════════════════════════════════════════════════════════════

                           ┌────────┐
              ┌───────────►│        │
              │            │   OR   │───────┐
Input I ──────┘            │        │       │
                           └────────┘       │
                                            │     ┌────────┐
                                            └────►│        │
                                                  │  AND   │──► OUTPUT
Input A ─────────────────────────────────────────►│        │
                                                  └────────┘
              ┌────────┐
Input L ─────►│  NOT   │───┐
              └────────┘   │
                           │   ┌────────┐
                           └──►│        │
                               │   OR   │
                               │        │
                               └────────┘


═══════════════════════════════════════════════════════════════════════════════
DETAILED STEP-BY-STEP FLOW:
═══════════════════════════════════════════════════════════════════════════════

STEP 1: NOT Gate
Input:  L
Output: L′ (NOT L)

STEP 2: OR Gate
Inputs:  I and L′
Output:  I + L′

STEP 3: AND Gate
Inputs:  A and (I + L′)
Output:  A⋅(I + L′) = Final Output


═══════════════════════════════════════════════════════════════════════════════
GATE SYMBOLS (For Drawing):
═══════════════════════════════════════════════════════════════════════════════

NOT GATE (Inverter):
    ──►▷○── 
    
OR GATE:
    ──┐
      ├─D──
    ──┘

AND GATE:
    ──┐
      ├─┐──
    ──┘ │

═══════════════════════════════════════════════════════════════════════════════
PROFESSIONAL DIAGRAM DESCRIPTION (For Word Document):
═══════════════════════════════════════════════════════════════════════════════

To draw this in Word or by hand:

1. Draw a NOT gate on the left
   - Label input as "L"
   - Label output as "L′"

2. Draw an OR gate in the middle
   - Connect L′ from NOT gate to top input of OR gate
   - Connect input I directly to bottom input of OR gate
   - Label output as "I + L′"

3. Draw an AND gate on the right
   - Connect output from OR gate to top input of AND gate
   - Connect input A directly to bottom input of AND gate
   - Label output as "OUTPUT" or "A⋅(I + L′)"

═══════════════════════════════════════════════════════════════════════════════
COMPONENT COUNT:
═══════════════════════════════════════════════════════════════════════════════

Simplified Expression A⋅(I + L′):
- NOT gates: 1
- OR gates:  1
- AND gates: 1
- TOTAL:     3 gates

Original Expression (I⋅A) + (L′⋅A):
- NOT gates: 1
- OR gates:  1
- AND gates: 2
- TOTAL:     4 gates

Savings: 1 gate (25% reduction in complexity)

═══════════════════════════════════════════════════════════════════════════════
SIGNAL FLOW TABLE:
═══════════════════════════════════════════════════════════════════════════════

Example: A=1, I=1, L=1

Input L = 1  →  [NOT] → L′ = 0
                         ↓
Input I = 1  ──────────→ [OR] → I + L′ = 1 + 0 = 1
                                  ↓
Input A = 1  ────────────────→ [AND] → Output = 1⋅1 = 1


Example: A=1, I=0, L=1

Input L = 1  →  [NOT] → L′ = 0
                         ↓
Input I = 0  ──────────→ [OR] → I + L′ = 0 + 0 = 0
                                  ↓
Input A = 1  ────────────────→ [AND] → Output = 1⋅0 = 0


═══════════════════════════════════════════════════════════════════════════════
HOW TO INCLUDE IN YOUR WORD DOCUMENT:
═══════════════════════════════════════════════════════════════════════════════

OPTION 1: Use the ASCII diagram above
- Copy the "CLEANER VERSION" diagram
- Paste into Word
- Use Courier New or Consolas font for proper alignment

OPTION 2: Draw using Word Shapes
- Insert → Shapes → Select rectangles for gates
- Add text labels inside shapes
- Use arrows/lines to connect gates
- Label all inputs and outputs

OPTION 3: Hand-draw and insert image
- Draw the circuit on paper using proper gate symbols
- Take a clear photo or scan
- Insert image into Word document
- Add caption: "Figure 1: Logic Gate Diagram for A⋅(I + L′)"

OPTION 4: Use online tool
- Visit: logic.ly or circuitverse.org
- Create the circuit diagram
- Export as image
- Insert into Word document

═══════════════════════════════════════════════════════════════════════════════
