# One Arithmetic Core for Many Number Systems

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** September 30, 2026

For a computer that does arithmetic in several number systems, my first decision would be to
keep one internal format and treat the others as input and output formats. Decimal, octal,
hexadecimal, and BCD are different ways of writing the same values (Ndjountche, 2016a), so
the machine needs one good binary core and conversion at the edges.

## An Integrated Approach to the Four Operations

The adder should sit at the center, because the other three operations can be built from it.
With numbers stored in two's complement, A minus B
equals A plus the inverted bits of B plus 1, so a row of XOR gates on the B input, controlled
by a SUB line that also feeds the carry-in, turns one adder into an adder/subtractor
(Ndjountche, 2016a, 2016b). Multiplication can be done by shift-and-add, where every 1 bit in
the multiplier adds a shifted copy of the multiplicand, and division by shift-and-subtract,
restoring the value whenever a trial subtraction goes negative (Ndjountche, 2016b). All four operations then share one adder, a shift register, and
a small control unit, and an opcode drives a multiplexer that picks which result goes out.
That is basically what an ALU is: one block that performs arithmetic and logic operations and
is told which one to run (Learn Computer Science, 2022).

Since every operation passes through the adder, its speed sets the speed of the whole unit. A
ripple-carry adder is small, but the carry has to travel through every bit, so for wider words
I would use a carry-lookahead adder, which computes generate (AB) and propagate (A XOR B)
signals so all carries are ready sooner (Ndjountche, 2016b). The status flags (carry, zero,
sign, overflow) also come from the adder, so a compare is really a subtraction whose result is
thrown away. For a workload heavy on
multiplication I would add a dedicated array multiplier, since shift-and-add costs one clock
cycle per bit. The trade-off is chip area against speed.

## The Industry Most Affected: Banking and Finance

I think banking and finance would change the most. The reason is a small detail from the
reading on fractions: a value like 0.1 cannot be stored exactly in binary, because it turns
into a repeating pattern, the same way 1/3 repeats in decimal (Ndjountche, 2016a). For one
calculation the error is tiny, but a bank running millions of interest, tax, and currency
conversions a day can end up with totals that are off by a cent, and in finance that is not
acceptable. Most software works around this by storing money as whole cents or doing
decimal math in software, which is slower.

Now picture processors that handle decimal and binary equally well in hardware, using BCD or
the decimal formats that researchers pushed for and the IEEE 754 standard now
defines (Cowlishaw, 2003; IEEE, 2019). Money could be calculated
exactly and at full hardware speed. Cross-currency payments could be settled and checked in
real time. Audits would get simpler because the numbers the machine produces would match what
an accountant gets on paper. In regions where mobile money carries a large share of daily payments, exact and
fast arithmetic could also push down the cost of very small transactions.

## Why Number Systems and Arithmetic Matter for Advanced Systems

Understanding number systems is what lets a designer make real trade-offs instead of
guessing. The representation decides the range, the precision, and how much hardware is
needed. Two's complement is a good example: once you understand it, you see why one adder
handles both positive and negative values, and why overflow happens when two positive numbers
give a negative-looking result (Ndjountche, 2016a). Knowing fixed point versus floating point
tells you when a cheap integer unit is enough, which matters in phones and embedded devices
with tight power budgets. Hexadecimal matters too, since engineers read memory and machine
code in hex, and the Learning Vibes (2023) video presents it mainly as a shorter way to write
binary. Modern GPUs and AI chips rely on small 8-bit and 16-bit
formats, and that only works because designers know exactly how much precision each format
keeps.

**Question for the class:** If you were building a processor for a bank, would you add a
dedicated decimal (BCD) arithmetic unit, or keep a binary-only ALU and store money as whole
cents in software? What would you gain and lose with each choice?

Word count: 733

## References

Cowlishaw, M. F. (2003). Decimal floating-point: Algorism for computers. In *Proceedings of the
16th IEEE Symposium on Computer Arithmetic* (pp. 104-111). IEEE.
https://doi.org/10.1109/ARITH.2003.1207666

IEEE. (2019). *IEEE standard for floating-point arithmetic* (IEEE Std 754-2019).
https://doi.org/10.1109/IEEESTD.2019.8766229

Learn Computer Science. (2022, May 31). *What is arithmetic logic unit? | ALU in computer
architecture explained* [Video]. YouTube. https://www.youtube.com/watch?v=H_aoaQYgKT8

Learning Vibes. (2023, January 9). *Number system in digital electronics | Introduction to
number system | Digital electronics | Mruduraj* [Video]. YouTube.
https://www.youtube.com/watch?v=XICyh0hO254

Ndjountche, T. (2016a). *Digital electronics 1: Combinational logic circuits*. ISTE; John Wiley & Sons. https://doi.org/10.1002/9781119318620

Ndjountche, T. (2016b). *Digital electronics 2: Sequential and arithmetic logic circuits*.
ISTE; John Wiley & Sons. https://doi.org/10.1002/9781119329756
