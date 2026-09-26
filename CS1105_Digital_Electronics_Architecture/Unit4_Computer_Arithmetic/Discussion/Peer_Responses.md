# Unit 4 Discussion: Peer Responses

Author: Nicanor Maswili
Course: CS 1105 Digital Electronics & Computer Architecture

You need to post **2** replies (minimum 75 words each). Three drafts are provided so you can
pick the two that fit best. Each one engages the classmate's specific points, adds a technical
idea, answers their question, and ends with a question.

---

## Peer Response 1: to Mohammed Arashed

Hi Mohammed,

Your post covers a lot of ground, and I like that you brought in Booth's algorithm and
non-restoring division, since both show how multiplication and division can share the same
adder and shift registers. One small point: hexadecimal does not really need its own
processing mode, because a hex digit is just a group of four binary bits, so a binary ALU
already handles it with no conversion. BCD is the format that actually needs extra hardware,
the +6 correction. To answer your question, I think dedicated decimal hardware pays off when
decimal work takes up a large share of the processor's time and the results must be exact,
as in bank batch jobs, billing, and tax systems. Cowlishaw (2003) made this argument, noting
that commercial programs spend a large part of their time on decimal arithmetic done in
software. For a phone or a gaming chip, the extra silicon would sit idle. Do you think a
decimal unit would make more sense as a separate accelerator than inside every CPU core?

Best,
Nicanor

Reference:
Cowlishaw, M. F. (2003). Decimal floating-point: Algorism for computers. In *Proceedings of
the 16th IEEE Symposium on Computer Arithmetic* (pp. 104-111). IEEE.
https://doi.org/10.1109/ARITH.2003.1207666

---

## Peer Response 2: to Chilufya Mulenga

Hi Chilufya,

Your post is clear and easy to follow, especially the idea of converting everything to one
internal format, then converting back for display. I took the same approach in my post. One
thing I would add is that this conversion works perfectly for whole numbers but not always
for fractions. A value like 0.1 becomes a repeating pattern in binary and has to be rounded
(Ndjountche, 2016), which is why your point about accuracy in financial services matters so
much. To answer your question, if a computer had to handle several number systems at the same
time, each operand would probably need a small tag saying which format it is in, and the ALU
would need a separate path for each format, for example a BCD adder with its +6 correction
next to the normal binary adder. That means more gates and more control logic, but no
conversion delay. Would you accept that extra hardware for a bank's system, or keep converting
and store money as whole cents instead?

Best,
Nicanor

Reference:
Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. ISTE; John Wiley & Sons. https://doi.org/10.1002/9781119318620

---

## Peer Response 3: to Rohith Dayalan

Hi Rohith,

This is a strong post. I especially liked your section on Residue Number Systems and FP8/BF16
formats, which shows that choosing a number format is a real engineering decision and not
just theory. One small correction: two's complement saves a whole subtractor, but I would not
say it halves the transistor budget, since the XOR row it needs still costs one gate per bit.
On your question about thresholds, I think it depends on three things: how much of the
workload is decimal, whether regulations demand exact decimal results, and how sensitive the
system is to delay. Interestingly, many trading systems avoid the problem another way, by
storing prices as whole integer "ticks" or cents, which binary hardware handles exactly and
very quickly. The IEEE 754 decimal formats (IEEE, 2019) make more sense where values need many
decimal places, such as interest and tax calculations. Do you think scaled integers would be
enough for HFT, or does derivatives pricing need true decimal floating point?

Best,
Nicanor

Reference:
IEEE. (2019). *IEEE standard for floating-point arithmetic* (IEEE Std 754-2019).
https://doi.org/10.1109/IEEESTD.2019.8766229
