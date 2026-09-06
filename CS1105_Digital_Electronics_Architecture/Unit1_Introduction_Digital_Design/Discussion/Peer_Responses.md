# CS 1105 Unit 1 — Peer Responses

*(Minimum two substantive replies, 75+ words each, 3–4 sentences, connecting to the peer's
post and adding value. Post by Wednesday. Reply under each person's thread.)*

---

## Peer Response 1 — to Mohammed Arashed

Hi Mohammed,

Your description of the full adder in Stage 2 was very clear, especially the point that the
middle sum bit turns on only when an odd number of the three signals are active. That "odd
number of ones" framing is exactly why two XOR gates chained together produce the correct
sum bit, and it matches what Ndjountche (2016) describes about how XOR behaves in
combinational logic. I also appreciated that you separated the internal carry from the final
carry-out, because that distinction is easy to blur. On your carry-propagation question, when
I built this adder in Logisim I could see that Cout only settles after the first-stage AND
resolves, which is a small, visible version of the ripple delay you mention. A carry-lookahead
adder computes each stage's "generate" (Aᵢ·Bᵢ) and "propagate" (Aᵢ⊕Bᵢ) terms in parallel, so
higher bits do not have to wait for lower ones. Do you think that speed gain is worth the
extra gate fan-in it demands at 64 bits?

Reference: Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John
Wiley & Sons.

(Word count: 152)

---

## Peer Response 2 — to Utomobong Nse William William

Hi Utomobong,

I really liked how thoroughly you tied each design choice back to specific sections of
Ndjountche (2016) — connecting the XOR sum, the AND carry, and the OR combination to the
gate definitions in Section 2.2 makes your reasoning easy to follow. Your full 16-row truth
table is a strong touch, and I agree with your observation that 11 + 11 = 110 shows a 2-bit
output register cannot hold the result, which is exactly why a carry-out bit is needed. When
I built and tested this circuit in Logisim, that overflow case was the clearest confirmation
that the third bit is essential rather than optional. Your closing question about Boolean
simplification versus propagation delay is a great one: reducing gate count can shorten some
paths but sometimes increases fan-in on a single gate, which can slow it down. In your view,
should a designer optimize for the fewest gates or for the shortest critical path first?

Reference: Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John
Wiley & Sons.

(Word count: 156)

---

## (Optional) Peer Response 3 — to Rohith Dayalan

Hi Rohith,

Your post was impressively rigorous, and I especially liked that you named the two carry
terms explicitly — the "generate" term G1 = A1·B1 and the "propagate" term T1 = C0·(A1⊕B1) —
because that vocabulary is exactly what carry-lookahead designs build on. Your complete
16-state truth table with the overflow cases marked makes the modulo-4 truncation behavior
very clear, and it lines up with what I saw when I simulated the circuit in Logisim: sums of
4, 5, and 6 all set Cout while the low two bits wrap around. On your carry-lookahead question,
the trade-off that stands out to me is fan-in, since the lookahead logic for high bit
positions needs increasingly wide AND/OR gates. Do you think that is why real 64-bit adders
often use hybrid designs, such as carry-select or hierarchical lookahead blocks, rather than
one giant lookahead unit?

(Word count: 139)
