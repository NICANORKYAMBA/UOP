# CS 1105 Unit 9 Review Quiz: Answers and Reasons

Ungraded review quiz for final exam preparation. Answers 4, 7, and 12 are confirmed by the quiz's own
feedback (the course key); 7 and 12 were corrected after the first attempt.

| Q | Answer | Why |
|---|---|---|
| 1 | It processes the source code in one go without requiring a separate linking stage | Single pass = reads the source once; multiple passes is the multipass compiler |
| 2 | Performs logical operations on one or more binary inputs to produce a single binary output | Definition of a logic gate (AND, OR, NOT...) |
| 3 | 8 | A 3-bit counter has 2³ = 8 states (0 to 7) |
| 4 | The propagation delay of the carry bit (confirmed by key) | Each full adder waits for the carry from the one before (ripple). Not the XOR gates |
| 5 | Simplifies the logic circuit by reducing the number of required gates | A mux can implement any function from its truth table directly |
| 6 | RAM | RAM is volatile; ROM, flash, and SSD keep data without power |
| 7 | To synchronize two states using clock edges (course key) | Master and slave latches work on opposite clock levels, so the two stages are synchronized by the clock edges. "Positive clock edge" is marked wrong |
| 8 | Minimizing propagation delay and power consumption | More levels = more gate delays and power |
| 9 | To notify the CPU of an event that requires immediate attention | Interrupts pause normal flow to run a handler (Unit 6, Z80 IM0/IM1/IM2, NMI) |
| 10 | To convert multiple input signals into a smaller set of outputs | Encoder: 2ⁿ inputs to n outputs (decoder is the reverse) |
| 11 | The result is a positive number | In 2's complement the MSB is the sign bit: 0 = positive (or zero) |
| 12 | RISC (course key) | Simple, fixed-length instructions that execute in predictable, often single-cycle times suit real-time control. Harvard is marked wrong |
| 13 | A device that takes a single input and distributes it to one of many outputs | Demux = one to many; mux = many to one |
| 14 | PLDs can be reprogrammed, while ASICs are custom-designed for a specific task | ASICs are fixed at manufacture |
| 15 | Idempotent Law | A + A = A and A · A = A |
| 16 | Disconnected (high impedance) state | Tri-state: 0, 1, or high-Z (Logisim shows it as a blue floating wire) |
| 17 | 8 | (-2) × (-4) = +8; Booth's algorithm handles signed 2's complement numbers |
| 18 | Transcoder (less certain) | Converting one code into another (e.g. BCD to Gray) is a code converter, also called a transcoder |
| 19 | They set or reset the initial state of the flip-flop | Asynchronous preset forces Q = 1, clear forces Q = 0, regardless of the clock |
| 20 | 4-bit Serial-in Parallel-out | SIPO: bits shift in one at a time, all bits are read at once |
