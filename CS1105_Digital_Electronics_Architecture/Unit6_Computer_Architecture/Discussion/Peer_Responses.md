# CS 1105 Unit 6: Peer Responses

Author: Nicanor Maswili
Course: CS 1105 Digital Electronics & Computer Architecture

You need to post **2** replies by Wednesday (minimum 75 words each). Each one engages the
classmate's specific points, adds a technical idea, answers their question, and ends with a
question.

---

## Peer Response 1: to Rohith Dayalan

Hi Rohith,

Your post goes deep, and I liked how you tied the end of Dennard scaling to the move toward
domain-specific architectures. To answer your question, I think the CISC and RISC difference has
blurred inside the chip but not disappeared. Modern x86 processors translate their instructions
into simpler, RISC-like micro-operations on the fly, so the execution core of an Intel chip and
an ARM chip now look surprisingly similar (Hennessy & Patterson, 2019). The ISA still matters at
the front end, though. x86 instructions vary in length, so the decoder must work out where each
one starts before it can decode several at once, while ARM's fixed-length instructions make a very
wide decoder, like the 8-wide one you mentioned in the M1, much easier to build. That decoding
work costs power on every instruction. One small suggestion: linking your factors to Wu (2023),
who describes the ISA as the bridge between software and hardware, would strengthen the connection
to our readings. Do you think RISC-V's simple, fixed-length design gives it the same advantage?

Best,
Nicanor

References:
Hennessy, J. L., & Patterson, D. A. (2019). A new golden age for computer architecture.
*Communications of the ACM, 62*(2), 48-60. https://doi.org/10.1145/3282307

Wu, H.-W. (2023, June 22). *Computer architecture explained: The bridge between software and
hardware*. DataSci Ocean. https://datasciocean.com/en/other/what-is-computer-architecture/

---

## Peer Response 2: to Mohammed Arashed

Hi Mohammed,

Your post is balanced and practical, and I especially liked your point that AWS advises testing
a workload before migrating, because the Lambda result of 34% better price performance only
applies to suitable workloads. To answer your question, for an AI-enabled mobile device I would
prioritize energy efficiency through a specialized accelerator, rather than maximum CPU speed. A
phone has a small battery and no fan, so running AI on the CPU wastes power and creates heat. Your
own M1 example shows the alternative: Apple's 16-core Neural Engine performs 11 trillion operations
per second and gives up to 15 times faster machine learning, while battery life is up to twice as
long as earlier Macs (Apple, 2020). ISA compatibility is mostly settled on phones, since ARM
already dominates, so the real design choice is how much chip area to give the accelerator. Would
you run small AI models on the device for privacy, or send them to the cloud to save battery?

Best,
Nicanor

Reference:
Apple. (2020, November 10). *Apple unleashes M1*.
https://www.apple.com/newsroom/2020/11/apple-unleashes-m1/
