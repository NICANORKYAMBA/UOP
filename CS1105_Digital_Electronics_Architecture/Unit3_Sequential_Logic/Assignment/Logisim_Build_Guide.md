# Logisim Build Guide — CS 1105 Unit 3 Scoreboard (Counter + Register)

A first-timer walkthrough for a **representative** version of the scoreboard: a 4-bit counter
feeding a 4-bit register that latches the count to a display. Logisim has ready-made Counter
and Register components, so this is quick to build and screenshot.

Run Logisim: `logisim`  (installed at `/usr/bin/logisim`)

---

## Tools & where things live
- **Edit (arrow)** = select/move; **Poke (hand)** = click inputs to pulse them; **Wiring** = drag wires.
- Left **explorer tree**: open **Memory** for **Counter** and **Register**; **Input/Output** for **Clock**, **Button**, and the **7-Segment Display** / **Hex Digit Display**; **Wiring** for pins and a splitter.

Golden rule: place parts first, then wire. Save early: File → Save (`scoreboard.circ`).

---

## Step 1 — Place a Counter (the score tally)
1. Explorer → **Memory** → drag a **Counter** onto the canvas.
2. Select it → in **Properties** set **Data Bits = 4** (counts 0–15, i.e. modulo-16).
3. The Counter has inputs on its edges: a **clock** (triangle), and usually **clear** and
   **load** pins. Its 4-bit output comes out one side labelled with the bit width `4`.

## Step 2 — Give the Counter a clock (score pulses)
1. Explorer → **Input/Output** → drag a **Clock** (or a **Button**) near the Counter's clock input.
2. Wire it to the Counter's **clock** (triangle) input.
   - A **Button** lets you pulse manually (each poke = one score); a **Clock** ticks
     automatically. For a clear screenshot, a Button is easier to control.

## Step 3 — Place a Register (the display latch)
1. Explorer → **Memory** → drag a **Register** onto the canvas, to the right of the Counter.
2. Select it → **Properties** → **Data Bits = 4** (matches the counter).
3. The Register has a **D** data input (4-bit), a **clock** (triangle), and an **enable/load**
   pin, plus a 4-bit **Q** output.

## Step 4 — Wire Counter output → Register input
1. Wire the Counter's **4-bit output** to the Register's **D (data) input**.
   - Both are 4-bit, so the wire is a 4-bit bus (thick line). If Logisim complains about
     width, re-check both are set to Data Bits = 4.

## Step 5 — Give the Register its own latch clock
1. Drag a second **Button** (or Clock) for the **latch** signal.
2. Wire it to the Register's **clock** input.
   - Now: pulsing the *counter* button increments the count; pulsing the *register* button
     latches the current count into the register.

## Step 6 — Show the value on a display
1. Explorer → **Input/Output** → drag a **Hex Digit Display** (simplest) OR a
   **7-Segment Display** with a **BCD decoder**.
   - Easiest: the **Hex Digit Display** takes a 4-bit input directly and shows 0–F.
2. Wire the Register's **Q (4-bit output)** to the Hex Digit Display's input.
   - (If you use a true 7-segment display, put a **BCD-to-7-segment decoder** between the
     register output and the display, per the assignment diagram.)

## Step 7 — Add a reset
1. Drag one more **Button**, label it `RESET`.
2. Wire it to the **clear (clr)** input of **both** the Counter and the Register so one press
   zeroes everything.

---

## Step 8 — Test with the Poke tool (hand)
1. Poke the **counter button** a few times → the counter output climbs 0,1,2,3,...
2. Poke the **latch button** → the Hex display updates to the counter's current value and
   then stays put even if you keep incrementing the counter.
3. Poke **RESET** → counter and display return to 0.

This visibly demonstrates the input/output behavior: count events in, a stable latched number
out.

---

## Step 9 — Screenshot for the assignment
1. Set up a clear state, e.g. counter = 5, register latched at 5, display showing "5".
2. Capture the canvas (Flameshot, or Logisim menu **File → Export Image**).
3. Paste into `Unit3_Assignment_Activity.docx` at:
   **[ Insert Logisim screenshot of the counter + register + display here ]**
4. Delete the bracket placeholder line after inserting.

Optional second screenshot: counter incremented past the latched value (e.g. counter = 8 but
display still showing 5) to prove the register is holding a stable snapshot.

---

## Tips
- **Red/orange wire** = width mismatch: make sure Counter, Register, and bus are all 4-bit.
- To pulse a Button: Poke tool → click it (it goes 1 then back to 0 on release), which is one
  clock edge.
- Save often: File → Save (`scoreboard.circ`).
