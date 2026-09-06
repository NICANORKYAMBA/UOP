# Discussion Forum Unit 1: Designing a 2-Bit Binary Adder with Logic Gates

Binary addition is one of the clearest ways to see how simple logic gates combine to perform real arithmetic. In this post I design a combinational circuit that adds two 2-bit numbers, A = A₁A₀ and B = B₁B₀, using only AND, OR, and XOR gates, and I trace how the inputs flow through the gates to the output.

## Building Blocks: Half Adder and Full Adder

A single-column binary addition follows four rules: 0+0=0, 0+1=1, 1+0=1, and 1+1=10 (a sum of 0 with a carry of 1). A **half adder** captures this for two bits. Its outputs are produced by exactly two gates (Ndjountche, 2016):

- Sum = A ⊕ B (XOR)
- Carry = A · B (AND)

The XOR gate gives a 1 only when the inputs differ, which matches the sum bit, and the AND gate gives a 1 only when both inputs are 1, which is exactly when a carry is generated.

To add multi-bit numbers, each higher column must also accept a carry coming in from the column below it. That circuit is the **full adder**, which adds three bits (A, B, and Cin):

- Sum = A ⊕ B ⊕ Cin
- Cout = (A · B) + (Cin · (A ⊕ B))

## Designing the 2-Bit Adder

To add A₁A₀ + B₁B₀, I chain a half adder for the least significant bit with a full adder for the next bit:

- **Bit 0 (half adder):** S₀ = A₀ ⊕ B₀ and C₀ = A₀ · B₀
- **Bit 1 (full adder):** S₁ = A₁ ⊕ B₁ ⊕ C₀ and Cout = (A₁ · B₁) + (C₀ · (A₁ ⊕ B₁))

The complete result is the three-bit value **Cout S₁ S₀**. This is an important point: although A and B are each 2 bits, their sum can be as large as 3 + 3 = 6, which is 110 in binary and needs three bits. Reporting only S₁S₀ without the carry-out would misrepresent results such as 2 + 2, so I include Cout as the most significant result bit.

## Truth Table

The table below lists representative rows spanning the full range of the two 2-bit inputs
(A and B each range from 0 to 3), with the three output bits Cout, S₁, S₀. Every row equals
the ordinary sum A + B, and I confirmed all sixteen input combinations produce correct
results in Logisim.

| A (A₁A₀) | B (B₁B₀) | A + B | Cout | S₁ | S₀ | Result |
|----------|----------|-------|------|----|----|--------|
| 0 (00) | 0 (00) | 0 | 0 | 0 | 0 | 000 = 0 |
| 1 (01) | 1 (01) | 2 | 0 | 1 | 0 | 010 = 2 |
| 2 (10) | 1 (01) | 3 | 0 | 1 | 1 | 011 = 3 |
| 3 (11) | 1 (01) | 4 | 1 | 0 | 0 | 100 = 4 |
| 2 (10) | 2 (10) | 4 | 1 | 0 | 0 | 100 = 4 |
| 2 (10) | 3 (11) | 5 | 1 | 0 | 1 | 101 = 5 |
| 3 (11) | 3 (11) | 6 | 1 | 1 | 0 | 110 = 6 |

For example, 3 + 3 = 6 gives Cout S₁ S₀ = 110, which is decimal 6, and 2 + 3 = 5 gives 101.

## Step-by-Step Signal Flow

Take A = 11 (3) and B = 01 (1) as an example. First, A₀ = 1 and B₀ = 1 enter the half adder: the XOR gate outputs S₀ = 0, and the AND gate outputs C₀ = 1. Next, A₁ = 1, B₁ = 0, and the carry C₀ = 1 enter the full adder: A₁ ⊕ B₁ = 1, and XOR-ing with C₀ gives S₁ = 0. For the carry-out, (A₁ · B₁) = 0 and (C₀ · (A₁ ⊕ B₁)) = 1, so the OR gate makes Cout = 1. The output is 100, which is decimal 4, exactly matching 3 + 1.

## Analysis of Circuit Behavior

Categorizing the outcomes by binary arithmetic rules, the circuit shows three cases: additions with no carry at all (small sums such as 1 + 1 = 010), additions that generate an internal carry from bit 0 into bit 1 (such as 1 + 1 in the low column), and additions large enough to overflow two bits and set Cout (such as 2 + 2 and 3 + 3). Because the outputs depend only on the current inputs and not on any stored state, this is a purely combinational circuit (Ndjountche, 2016). I built and verified this design in Logisim, confirming each truth-table row by toggling the input pins; the circuit diagram is included below.

**Question for the group:** Since a 2-bit addition can overflow into a third bit, do you think a well-designed adder should always expose a carry-out line, or are there situations where discarding the overflow is the correct engineering choice?

**Word count: 630**

## References

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley & Sons. https://ebookcentral.proquest.com/
