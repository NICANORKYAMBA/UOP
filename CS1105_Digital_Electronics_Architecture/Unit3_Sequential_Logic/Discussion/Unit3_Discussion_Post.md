# Arcade Game Circuit Design: Choosing Among D, T, and JK Flip-Flops

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** September 23, 2026

The arcade game's control circuit is a good use of sequential logic: unlike combinational
circuits, sequential circuits use memory elements (flip-flops) whose outputs depend on both
the current inputs and the stored past state, driven by a clock (Ndjountche, 2016). The score
must be remembered and updated, and the lights and sound must toggle on events, so flip-flops
— the bistable memory elements shown in the SR latch video (Computer Science, 2016) — are the
right components.

## Connecting D Flip-Flops to Build the Score Counter

A binary counter for the player's score can be built from D flip-flops, one per bit. A D
flip-flop copies its D input to Q on the active clock edge, so it holds one bit until the next
update (Ndjountche, 2016). In a simple ripple counter the first flip-flop is fed its own
inverted output (D0 = NOT Q0) so it flips every clock pulse, and each following stage is
clocked by the previous stage's output, toggling only when the lower bits roll over. The
outputs Q0, Q1, Q2, ... form the binary score, and each flip-flop stores one bit: Q0 the
least-significant bit (value 1), Q1 the next (value 2), Q2 the next (value 4), and so on. Four
D flip-flops store scores 0000 to 1111 (0–15); adding flip-flops widens the range. So each D
flip-flop holds one weighted binary digit of the current score, and together they store the
whole score as a binary number that, because the flip-flops are edge-triggered, stays stable
between clock pulses (Ndjountche, 2016; Down to the Wires, 2020).

## Where T Flip-Flops Control Lights and Sound

T (toggle) flip-flops are the natural choice for the flashing lights and sound, because a T
flip-flop with T held at 1 flips its output on every clock pulse, giving a steady on-off
pattern (Ndjountche, 2016). I would use one T flip-flop per blinking light: tie T high and
clock it from a slow pulse to flash at a regular rate. For an event-driven effect, T becomes
the control — setting T = 1 only when a game event occurs (say, a bonus is hit) toggles a
light or sound-enable line, while T = 0 holds state. T flip-flops thus fit any "flip on or off
each time something happens" behavior, exactly what blinking indicators and toggled sound
effects need.

## Using JK Flip-Flops Instead of T Flip-Flops

A JK flip-flop can set (J=1, K=0), reset (J=0, K=1), hold (J=K=0), or toggle (J=K=1) on the
clock edge (Mano & Ciletti, 2018). The key behavioral difference is that a T flip-flop has one
input and can only toggle or hold, so a single pulse merely inverts its current state, whereas
a JK can also deterministically force the output on or off — in effect the JK is a superset of
the T. To reproduce pure toggling I would tie J = K = T (J=K=1 toggles, J=K=0 holds), so a JK
with joined inputs acts as a T flip-flop (Ndjountche, 2016). Two circuit changes follow.
First, each effect flip-flop now needs two control lines instead of one, so I would add a
little combinational logic to drive J and K from the game-event signals. Second, I could use
that control for exact states rather than toggles — for example, J=1, K=0 to force a warning
light on when time is low, and J=0, K=1 to force all lights off at game over, instead of
hoping a toggle lands right (Mano & Ciletti, 2018). The trade-off is more wiring for finer
control.

## Conclusion and Question

In short, D flip-flops build the score counter (one bit each), T flip-flops toggle the lights
and sound, and JK flip-flops add independent set/reset at the cost of an extra input, so the
choice depends on how much control each part needs.

**Question for the class:** When a counter or effect must reset instantly at game over, is it
better to use a flip-flop's asynchronous clear input or to build the reset into the
synchronous logic, and what are the timing risks of each?

Word count: 749

## References

Computer Science. (2016, July 29). *Latches and flip-flops 1 – the SR latch* [Video]. YouTube.
https://youtu.be/-aQH0ybMd3U

Down to the Wires. (2020, October 4). *Registers and counters* [Video]. YouTube.
https://youtu.be/ikrNRrIRyMk

Mano, M. M., & Ciletti, M. D. (2018). *Digital design: With an introduction to the Verilog
HDL, VHDL, and SystemVerilog* (6th ed.). Pearson.

Ndjountche, T. (2016). *Digital electronics 2: Sequential and arithmetic logic circuits*. ISTE
Ltd/John Wiley & Sons. https://doi.org/10.1002/9781119318613
