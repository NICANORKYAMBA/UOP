# Assignment Activity Unit 1: Controlling a Light Bulb with a Switch Using Logic Gates

## Introduction

In this learning journal, I design the simplest possible digital circuit that lets a switch
control a light bulb: the bulb turns on when the switch is closed (ON) and off when the
switch is open (OFF). The goal is to meet this behavior using the fewest logic gates
possible, and to justify the design with Boolean algebra. I follow three steps: identifying
the input and output signals, applying Boolean algebra, and depicting the final circuit.

## Step 1: Identification of Input and Output Signals

A digital design begins by defining the signals and assigning binary values to their states
(Ndjountche, 2016).

- **Input signal (S) — the switch.** I represent the switch position as a single binary
  variable S. When the switch is closed (ON) the input is logic 1; when it is open (OFF)
  the input is logic 0.
- **Output signal (L) — the light bulb.** The bulb is the output variable L. L = 1 means
  the bulb is lit, and L = 0 means it is off.

The required behavior stated in the scenario maps directly to these values: switch closed
(S = 1) must give bulb on (L = 1), and switch open (S = 0) must give bulb off (L = 0).

## Step 2: Truth Table and Application of Boolean Algebra

With one input and one output, the complete behavior fits in a two-row truth table:

| Switch S | Bulb L |
|----------|--------|
| 0 (open) | 0 (off) |
| 1 (closed) | 1 (on) |

Deriving the function from the truth table, I write a product term (minterm) for every row
where the output L is 1. Only the second row qualifies, giving the sum-of-products
expression:

**L = S** (the single minterm where S = 1)

To confirm this is fully simplified, I can show that even a more complex-looking expression
collapses to L = S using Boolean algebra laws (Ndjountche, 2016). Suppose a naive design
expressed the output as:

**L = S·S + S·0**

Applying the laws step by step:

1. **L = S·S + S·0**  — starting expression
2. **L = S + S·0**    — Idempotent law: S·S = S
3. **L = S + 0**      — Null (domination) law: S·0 = 0
4. **L = S**          — Identity law: S + 0 = S

The result reduces to **L = S**, the **identity law** in its simplest form: a variable
passed through unchanged equals itself. I can also verify there is no hidden redundancy
using the complement law (S + S′ = 1 and S·S′ = 0), which shows the output depends on S
alone and never on its inverse. Because the output must always equal the input, no AND, OR,
or NOT operation is needed — any added gate would only introduce cost, delay, and complexity
without changing the logic. This is the most efficient result: the function L = S already
uses the fewest gates, which is **zero logic gates**, since the switch drives the bulb
directly.

If the design requires an actual gate (for example, to buffer or strengthen the signal so
the switch is electrically isolated from the bulb), the correct minimal choice is a single
**buffer gate**, whose output equals its input (L = S). A buffer does not change the logic
value; it only restores signal strength. I would avoid two inverters in series (NOT-NOT),
because although (S')' = S is logically valid by the involution law, it uses two gates to
accomplish what one buffer, or no gate at all, already does.

## Step 3: Depiction of the Final Circuit

The final circuit is a direct connection from the switch to the bulb, optionally through a
single buffer:

```
   S (switch) ─────────────▶ L (bulb)         [minimal: direct connection, 0 gates]

   S (switch) ────▷────────▶ L (bulb)         [if a gate is required: 1 buffer]
                 buffer
```

- When S = 1 (switch closed), the logic 1 passes to L and the bulb turns on.
- When S = 0 (switch open), the logic 0 passes to L and the bulb stays off.

*(A Logisim screenshot of the circuit — an input pin wired to an output pin, optionally
through a buffer — is inserted below.)*

**[ Insert Logisim circuit screenshot here ]**

## Reasoning Behind the Gate Choice

The scenario asks for the fewest gates for simplicity and efficiency. Boolean simplification
shows the function is L = S, so the ideal implementation needs no logic gate at all; the
switch controls the bulb directly. Where a physical design calls for signal buffering, one
buffer is the minimal and most appropriate component because it preserves the logic value
while isolating and strengthening the signal. Choosing anything more, such as an AND gate
with both inputs tied to S (which also yields S · S = S) or a double inverter, would satisfy
the truth table but waste gates, contradicting the efficiency requirement (Ndjountche, 2016).

## References

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley &
Sons. https://ebookcentral.proquest.com/
