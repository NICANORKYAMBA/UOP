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

# Review Quiz 2: Answers and Reasons

Questions marked "less certain" have loosely worded options; check them against the quiz's
feedback after submitting, and remember the course key's answer for the final.

| Q | Answer | Why |
|---|---|---|
| 1 | A method for specifying operands | Immediate, direct, register, indirect... say where the operand is |
| 2 | To translate virtual addresses to physical addresses | The MMU's job (plus memory protection) |
| 3 | Linked list | A data structure built from nodes and pointers (Unit 7 notes) |
| 4 | Multipass compilers can perform more sophisticated optimizations | They can look at the whole program across passes |
| 5 | Present input only | Combinational = no memory; sequential uses past state |
| 6 | By specifying its truth table | Logisim's Combinational Analysis uses truth tables |
| 7 | Ambiguity | Two meanings for one symbol in the same context |
| 8 | Compiler (less certain) | The only build tool in the list; symbols must resolve for the build tools |
| 9 | Instruction pipelining (less certain) | Resolved addresses let instructions flow through the pipeline without stalls |
| 10 | 4 | 2 inputs give 2² = 4 combinations |
| 11 | A ⊕ B | XOR symbol |
| 12 | Decoding | Matches Unit 8 self-quiz: "role in architecture = instruction decoding" |
| 13 | Symbolic reduction | Reduction = fewer symbols |
| 14 | Faster execution (less certain) | Resolved numbers let the CPU run without lookups |
| 15 | To perform arithmetic and logic operations | ALU = Arithmetic Logic Unit |
| 16 | Data processing | The ALU processes data |
| 17 | A sequence of simpler instructions (less certain) | Microcode breaks a machine instruction into simple control steps |
| 18 | A machine instruction's operation code | Opcode = the part that says which operation |
| 19 | 32 | n-to-2ⁿ: 5 inputs give 2⁵ = 32 outputs |
| 20 | One of the inputs | A mux selects one input to pass through |
| 21 | Logic gate | Digital circuits are built from gates |
| 22 | A + B + C + D | In Boolean algebra + means OR |
| 23 | Binary code | Machine code is binary |
| 24 | The number of clock cycles per second | Measured in hertz (e.g. 3 GHz) |
| 25 | 0 | Anything × 0 = 0 |
| 26 | Resolving memory addresses to corresponding symbols (less certain) | Closest to matching symbols with addresses |
| 27 | Execution (confirmed by course key) | Resolved, decoded instructions are simpler to execute. Note: a Studocu answer said "Design" and was wrong |
| 28 | Data storage and memory | Flip-flops and latches each store one bit |
| 29 | All inputs are true | NAND is NOT AND: 0 only when every input is 1 |
| 30 | Ensuring correctness | Every signal must have one correct meaning (Unit 8 assignment) |
