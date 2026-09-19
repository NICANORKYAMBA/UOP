# Unit 3 Learning Notes — Sequential Logic: Latches, Flip-Flops, Counters, Registers

Course: CS 1105 Digital Electronics & Computer Architecture
Reading: Ndjountche (2016), *Digital electronics 2*, Ch. 1 (Latches/Flip-Flops),
Ch. 2 (Binary Counters), Ch. 3 (Shift Registers)

---

## 1. Combinational vs sequential

- **Combinational:** output depends only on current inputs (no memory).
- **Sequential:** output depends on current inputs **and** stored past state; uses **memory
  elements** (latches/flip-flops), usually coordinated by a **clock**.

## 2. Bistability

A latch/flip-flop is **bistable**: it has two stable states (0 and 1) and stays in one until
told to change. This is what lets it **store one bit** of information. It is typically built
from cross-coupled gates (e.g., two NOR or two NAND gates) that feed back into each other.

## 3. Latches (level-sensitive)

- **SR latch:** Set/Reset. S = 1 sets Q = 1; R = 1 resets Q = 0; S = R = 0 holds; S = R = 1 is
  invalid (forbidden).
- **Gated SR latch:** adds an enable/clock so S and R only act while enable = 1.
- **Gated D latch:** one data input D; while enable = 1, Q follows D (transparent); when
  enable = 0, Q holds. Removes the invalid state of SR.

Latches are **level-sensitive** (they respond while the enable level is high).

## 4. Flip-flops (edge-triggered)

Flip-flops change only on a **clock edge** (rising or falling), which gives precise timing.

- **D flip-flop:** Q takes the value of D on the clock edge. Used to store/delay one bit;
  building block of registers.
- **JK flip-flop:** J and K inputs. J=1,K=0 set; J=0,K=1 reset; J=K=0 hold; **J=K=1 toggle**.
  Most flexible; no invalid state.
- **T flip-flop:** one input T. T=1 toggles on each edge; T=0 holds. Great for counters and
  blinking. A JK with J=K=T behaves as a T flip-flop.
- **Master-slave / edge-triggered:** two stages so the output updates once per clock edge,
  preventing the output from changing more than once per cycle.
- **Asynchronous inputs (preset/clear):** force Q to 1 or 0 immediately, independent of the
  clock — used for power-on reset.

## 5. Operational characteristics

- **Setup time:** data must be stable *before* the clock edge.
- **Hold time:** data must stay stable *after* the edge.
- **Propagation delay:** time from clock edge to output change.
- **Clock skew:** clock reaching different flip-flops at slightly different times — can cause
  errors if not managed.

## 6. Counters

- A **counter** steps through a fixed sequence of states on each clock pulse.
- **Modulo-N:** counts 0 .. N-1 then wraps. Mod-4 = 2 flip-flops, mod-8 = 3, mod-16 = 4.
- **Ripple (asynchronous):** each flip-flop clocked by the previous stage's output; simple but
  has cumulative delay.
- **Synchronous:** all flip-flops share one clock; faster and cleaner timing.
- **Up / down / reversible:** count up, down, or either direction (with a direction control).
- **Parallel load:** can be preset to a starting value.

## 7. Registers and shift registers

- **Register:** a group of flip-flops (usually D) that stores a multi-bit word; a parallel
  register loads all bits at once on the clock and holds them.
- **Shift register:** moves bits one position per clock. Types: **serial-in**, **parallel-in**,
  **bidirectional** (shift both ways). **Register file:** a small set of addressable registers.
  **Shift-register counter:** (e.g., ring or Johnson counter) uses a shift register to cycle
  through states.

## 8. Applying to this unit's work

- **Discussion (arcade game):** D flip-flops → binary score counter (one bit each);
  T flip-flops → toggle lights/sound; JK → same toggling plus independent set/reset.
- **Assignment (scoreboard):** mod-16 counter tallies events; a 4-bit D-register latches the
  count so a 7-segment display shows a stable value; asynchronous clear resets both.

## 9. Self-Quiz reminders

- Flip-flops store **digital** data.
- The **clock** synchronizes operations (an AND gate commonly gates the clock into the inputs).
- Sequential circuits are distinguished from combinational ones by **memory elements**.

---

## References

Ndjountche, T. (2016). *Digital electronics 2: Sequential and arithmetic logic circuits*. John
Wiley & Sons. https://ebookcentral.proquest.com/

Mano, M. M., & Ciletti, M. D. (2018). *Digital design: With an introduction to the Verilog
HDL, VHDL, and SystemVerilog* (6th ed.). Pearson.

Harris, D. M., & Harris, S. L. (2012). *Digital design and computer architecture* (2nd ed.).
Morgan Kaufmann.
