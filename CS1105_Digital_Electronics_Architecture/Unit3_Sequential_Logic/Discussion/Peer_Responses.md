# Unit 3 Discussion — Peer Responses

Author: Nicanor Maswili
Course: CS 1105 Digital Electronics & Computer Architecture

You need to post **2** replies (minimum 75 words each). Three drafts are provided so you can
pick the two that fit best. Each engages the classmate's specific points, adds a technical
idea, and ends with a question.

---

## Peer Response 1 — to Nankya Joyce Sanyu

Hi Joyce,

Your breakdown of the D flip-flop counter is clear, especially the point that the surrounding
combinational logic decides the next state while the flip-flops simply store each bit. I also
liked how you tied the T flip-flop's toggle behavior to a repeating LED and buzzer pattern.
Building on your closing question about combining all three types: I would let D flip-flops
hold the score, feed that count into a decoder for the display, and use a JK stage for a
"game-over" light so its reset input (J = 0, K = 1) can clear the light the instant the game
ends, rather than waiting for a toggle edge (Ndjountche, 2016). One small addition to your
scoring counter: if it is a ripple design, decoding the outputs during the brief settling
window can produce glitches, so latching the count into a register before display keeps the
shown score clean. When you combine the three types, would you clock them all from one shared
clock, or give the flashing stages a separate slower clock?

Best,
Nicanor

Reference:
Ndjountche, T. (2016). *Digital electronics 2: Sequential and arithmetic logic circuits*.
ISTE Ltd/John Wiley & Sons. https://doi.org/10.1002/9781119318613

---

## Peer Response 2 — to Rohith Dayalan

Hi Rohith,

This is a strong, precise post. I appreciate that you gave the actual next-state equation
(Di = Qi XOR (Qi-1 AND ... AND Q0)) for a synchronous counter rather than just describing it,
and your split of the T flip-flop into a frequency divider for lights and an event latch for
audio is a clean way to reuse one component for two jobs (Roth & Kinney, 2020). To engage your
closing question about ripple versus synchronous counters: the ripple design is cheaper and
simpler but its carry has to propagate stage by stage, so the worst-case delay grows with bit
count and the outputs pass through transient states, which is exactly where decoding glitches
appear. A synchronous counter clocks every flip-flop together, so all bits settle within one
propagation delay and a registered or Gray-coded output avoids most decode hazards, at the
cost of extra steering logic. Given arcade scoring is bursty rather than truly high-speed,
would you still pay that extra logic cost, or accept a ripple counter with a latched display?

Best,
Nicanor

Reference:
Roth, C. H., & Kinney, L. L. (2020). *Fundamentals of logic design* (8th ed.). Cengage
Learning. https://www.cengage.com

---

## Peer Response 3 — to Winny Makumbe

Hi Winny,

Your post is very readable, and the explicit bit-value table (1s, 2s, 4s, 8s) makes the score
counter easy to follow. I also like that you noted the T flip-flop is really a JK with J and K
tied together, and that JK adds direct set/reset for an immediate "Game Over" light. To answer
your question about counting down instead of up: I would keep the same flip-flops but change
the next-state logic to decrement, so a down counter steps 1111, 1110, 1101, and so on, which
in a ripple version means clocking each stage from the previous stage's Q rather than its
inverted output (Ndjountche, 2016). A practical touch for a game would be adding a parallel
load input so the counter can be preset to the starting score, then count down to zero and
trigger an end-of-game signal. Would you detect "zero" with an AND/NOR gate on the outputs to
fire that end signal, and how would you avoid a false trigger during the brief ripple settling
time?

Best,
Nicanor

Reference:
Ndjountche, T. (2016). *Digital electronics 2: Sequential and arithmetic logic circuits*.
ISTE Ltd/John Wiley & Sons. https://doi.org/10.1002/9781119318613
