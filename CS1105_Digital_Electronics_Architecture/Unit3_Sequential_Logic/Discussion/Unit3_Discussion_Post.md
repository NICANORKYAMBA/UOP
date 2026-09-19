# Arcade Game Circuit Design: Choosing Among D, T, and JK Flip-Flops

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** September 23, 2026

Designing the arcade game's control circuit is a good use of sequential logic, because unlike
combinational circuits, sequential circuits use memory elements (flip-flops) whose outputs
depend on both the current inputs and the stored past state, driven by a clock (Ndjountche,
2016). The score must be remembered and updated, and the lights and sound must toggle on game
events, so flip-flops are the right building blocks.

## Connecting D Flip-Flops to Build the Score Counter

A binary counter for the player's score can be built from D flip-flops, one per bit. A D
flip-flop copies its D input to Q on the active clock edge, so it holds one bit until the next
update (Ndjountche, 2016). In a simple ripple counter the first flip-flop is fed its own
inverted output (D0 = NOT Q0) so it flips every clock pulse, and each following stage is
clocked by the previous stage's output, toggling only when the lower bits roll over. The
outputs Q0, Q1, Q2, ... form the binary score. Each flip-flop stores one bit: Q0 = value 1,
Q1 = value 2, Q2 = value 4, and so on. Four flip-flops store scores 0–15; adding more widens
the range.

## Where T Flip-Flops Control Lights and Sound

T (toggle) flip-flops fit the flashing lights and sound: with T = 1 the output flips on every
clock pulse, giving a steady on-off pattern (Ndjountche, 2016). Tie T high and clock it from a
slow pulse to blink a light; or set T = 1 only when a game event occurs so that event toggles
a light or sound-enable line, while T = 0 holds state.

## Using JK Flip-Flops Instead of T Flip-Flops

A JK flip-flop can set (J=1,K=0), reset (J=0,K=1), hold (J=K=0), or toggle (J=K=1) on the
clock edge (Mano & Ciletti, 2018). Versus a T flip-flop (toggle/hold only), JK can also force
the output on or off independently, at the cost of a second input. To mimic a T flip-flop, tie
J = K = T. JK also lets you force all effect lights off instantly at game over (J=0, K=1)
rather than waiting for a toggle.

## Conclusion and Question

D flip-flops build the score counter (one bit each), T flip-flops toggle lights and sound, and
JK flip-flops add independent set/reset at the price of an extra input.

**Question for the class:** When a counter or effect must reset instantly at game over, is it
better to use a flip-flop's asynchronous clear input or to build the reset into the
synchronous logic, and what are the timing risks of each?

Word count: 725

## References

Ndjountche, T. (2016). *Digital electronics 2: Sequential and arithmetic logic circuits*. ISTE
Ltd/John Wiley & Sons. Retrieved from ProQuest Ebook Central via the UoPeople LIRN Library.
https://ebookcentral.proquest.com/lib/univ-people-ebooks/

Mano, M. M., & Ciletti, M. D. (2018). *Digital design: With an introduction to the Verilog
HDL, VHDL, and SystemVerilog* (6th ed.). Pearson.
