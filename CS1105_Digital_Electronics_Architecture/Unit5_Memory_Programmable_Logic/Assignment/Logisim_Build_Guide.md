# Logisim Build Guide: CS 1105 Unit 5 Combination Lock with a PLD

The project is a **3-digit combination lock** (code **7, 3, 9**). A ROM programmed as a PROM is
the PLD: it holds the lock's whole truth table. Around it are a 2-bit state register, a
failed-attempt counter, an alarm comparator, two OR gates, buttons, lights, and displays.

Files in this folder:

| File | What it is |
|---|---|
| `Unit5_Combination_Lock.circ` | The finished, tested circuit (open it in Logisim) |
| `lock_pld_rom.txt` | The PLD program (128 values), for loading into a ROM if you build it yourself |

> The reference circuit was tested on all 256 combinations of state, failed tries, and digit,
> plus full sequences with the real flip-flops: correct code, a slip, three wrong digits with
> lockout, LOCK, and ADMIN RESET. Every result matched the design.

Run Logisim: `logisim`

---

## PART A: Using the lock (Poke tool)

Open `Unit5_Combination_Lock.circ`. Select the **Poke tool (hand)** in the toolbar.

**How to enter a digit:**
1. Click the bits of the **DIGIT (0-9)** pin to set the digit. The leftmost bit is the 8s, then
   4s, 2s, 1s. So 7 = `0111`, 3 = `0011`, 9 = `1001`.
2. The **Digit entered** display shows the digit, so you can check it.
3. Click the **ENTER** button once. That is one "key press".

**What you see:**
- **Progress** display: 0, 1, 2, 3 as you get each digit right.
- **Wrong tries** display: counts wrong digits.
- **DOOR OPEN** light (green) when the code is complete.
- **ALARM** light (red) after 3 wrong digits.

**Buttons:**
- **LOCK** closes the door again (progress back to 0).
- **ADMIN RESET** clears everything, including the alarm.

---

## PART B: Test script (do these in order)

| # | Do this | You should see |
|---|---|---|
| 1 | Set DIGIT `0111` (7), click ENTER | Progress 1 |
| 2 | Set DIGIT `0011` (3), click ENTER | Progress 2 |
| 3 | Set DIGIT `1001` (9), click ENTER | Progress 3, **DOOR OPEN lit**. **Take screenshot 2 now.** |
| 4 | Click LOCK | Progress 0, light off |
| 5 | Enter 7, then 5 (`0101`) | Progress 1, then back to 0, Wrong tries 1 |
| 6 | Enter 7, 3, 9 | DOOR OPEN lit, Wrong tries back to 0 |
| 7 | Click LOCK | Progress 0 |
| 8 | Enter 1, 2, 4 (`0001`, `0010`, `0100`) | Wrong tries 1, 2, 3, **ALARM lit**. **Take screenshot 3 now.** |
| 9 | Enter 7, 3, 9 | Nothing happens: the keypad is locked out |
| 10 | Click ADMIN RESET | Alarm off, Wrong tries 0, Progress 0 |

**Screenshot 1** can be taken at any idle moment, for example right after opening the file.

---

## PART C: Screenshots for the paper

Save into `Assignment/figures/` with these exact names, then run `python3 build_docx.py` from the
Unit 5 folder. Missing images just leave a placeholder.

| File | Show |
|---|---|
| `fig1_lock_overview.png` | The whole circuit (zoom out so every block fits) |
| `fig2_unlocked.png` | After 7, 3, 9: Progress 3 and DOOR OPEN lit (step 3) |
| `fig3_alarm.png` | After 3 wrong digits: Wrong tries 3 and ALARM lit (step 8) |

How: **File → Export Image...** → PNG. To fit the whole circuit, use the zoom box at the bottom
left of the Logisim window (try 75%) before exporting. You can also leave the files in Downloads
and ask me to move them.

---

## PART D: Building it yourself (optional)

Use **tunnels** (Wiring folder) with the same names as the reference so blocks connect without
long wires. Hover over any port to see its name.

### Step 1: The PLD (ROM)
1. **Memory** folder → **ROM**. Properties: **Address Bit Width = 7**, **Data Bit Width = 4**,
   Label `LOCK PLD`.
2. Right-click the ROM → **Load Image...** → choose `lock_pld_rom.txt`. The grid fills with values
   (mostly `8`, `1`, `2`, `3`, `7`, and zeros in the second half).
3. Address input **A** is on the left, data output **D** on the right.

### Step 2: Build the 7-bit address
Splitter, **Facing = West**, **Fan Out = 3**, **Bit Width In = 7**. Set the bit mapping:
Bits 0 to 3 → end 0 (DIGIT), Bits 4 to 5 → end 1 (STATE), Bit 6 → end 2 (ALARM).
Fat end → ROM address A.

### Step 3: Split the 4-bit data
Splitter, **Facing = East**, **Fan Out = 3**, **Bit Width In = 4**:
Bits 0 to 1 → end 0 (**NEXT STATE**), Bit 2 → end 1 (**UNLOCK**), Bit 3 → end 2 (**WRONG**).

### Step 4: State register
**Memory → Register**, Data Bits 2, label `STATE`.
- **D** ← NEXT STATE, **clock** (triangle) ← ENTER, **0 / clear** (bottom) ← CLEAR STATE.
- **Q** → tunnel STATE.

### Step 5: Failed-attempt counter
**Memory → Counter**, Data Bits 2, **Maximum Value 3**, **Action On Overflow = Stay At Value**,
label `TRIES`.
- **ct** (count enable) ← WRONG, **clock** ← ENTER, **0 / clear** ← CLEAR TRIES.
- Leave **load** and the data input empty. **Q** → tunnel TRIES.

### Step 6: Reset logic
- OR gate (2 inputs): LOCK, ADMIN → **CLEAR STATE**.
- OR gate (2 inputs): ADMIN, UNLOCK → **CLEAR TRIES** (a successful entry clears old mistakes).

### Step 7: Alarm
**Arithmetic → Comparator**, Data Bits 2: top input TRIES, bottom input a 2-bit **Constant 3**.
The **=** output → tunnel **ALARM**.

### Step 8: User interface
- **Input pin** DIGIT, 4 bits. **Buttons** (Input/Output folder) ENTER, LOCK, ADMIN RESET.
- **LEDs**: UNLOCK → green "DOOR OPEN", ALARM → red "ALARM".
- **Hex Digit Displays** for DIGIT, and for STATE and TRIES through **Bit Extenders**
  (2 → 4 bits, Extension Type Zero).

---

## Changing the code (shows off the PLD)

The code lives only in the PLD's contents. To change it, regenerate `lock_pld_rom.txt` for a new
code and load it into the ROM again. No wires change. Ask me and I will generate a new file, for
example for code 2-5-8.

## Troubleshooting

| Problem | Fix |
|---|---|
| Clicking ENTER does nothing | Make sure you are using the **Poke tool (hand)**, not the arrow |
| Progress never moves | Check the DIGIT bits: 7 is `0111`, not `1110` |
| Alarm stuck on | Click **ADMIN RESET** (LOCK does not clear the alarm, by design) |
| Orange or red wires | Width mismatch: STATE and TRIES are 2 bits, DIGIT is 4, the ROM address is 7 |
