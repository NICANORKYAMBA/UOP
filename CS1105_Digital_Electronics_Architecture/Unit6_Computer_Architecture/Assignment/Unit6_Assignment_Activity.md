# How the Z80 Microprocessor Executes Instructions and Handles Interrupts

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** October 14, 2026

The Zilog Z80 is an 8-bit microprocessor introduced in 1976 that powered early personal computers
and is still found in embedded systems. It is a good processor to study because it is simple
enough to follow one clock cycle at a time, yet it has a complete interrupt system with three
modes. This paper explains how the Z80 fetches, decodes, and executes instructions, how it
responds to interrupts, and why interrupt handling is essential to its smooth operation. Every
example program in this paper was run on a Z80 emulator, so the register values and addresses
shown are the ones the processor actually produced.

## 1. How the Z80 Executes Instructions

### 1.1 The Parts That Take Part

Figure 1 shows the parts of the Z80 involved in running a program. The **program counter (PC)**
holds the address of the next instruction. The **instruction register and decoder** receive each
opcode, and the **control unit** turns it into a sequence of timed control signals. The **ALU**
does arithmetic and logic and records results in the flag register F, while the **register
file** holds the accumulator A, the pairs BC, DE, and HL, a complete alternate set (A', F', B',
C', D', E', H', L'), the index registers IX and IY, the stack pointer SP, and the special I and R
registers (Zilog, 2016). The CPU reaches memory and I/O through a 16-bit address bus, which can
address 64 KB, and an 8-bit data bus. As Both (2020) explains for CPUs in general, the control
unit is what coordinates these parts so that each instruction is carried out in the right order.

**Figure 1**

*Simplified Internal Architecture of the Z80*

[FIGURE figures/fig1.png]

### 1.2 The Fetch, Decode, Execute Cycle in Z80 Terms

Like every CPU, the Z80 repeats a fetch, decode, and execute cycle (Both, 2020; Futurology, 2017).
The Z80 measures this cycle in two units (Zilog, 2016, p. 8):

- A **T-state** is one clock period. At 4 MHz, one T-state lasts 0.25 microseconds.
- A **machine cycle (M-cycle)** is one basic bus operation, such as reading or writing one byte,
  and takes three to six T-states.

Every instruction begins with the **M1 cycle**, the opcode fetch, which always takes four T-states
(Zilog, 2016, pp. 8-9):

1. **T1 and T2, fetch.** The CPU places the PC on the address bus and activates the memory request
   (MREQ) and read (RD) signals.
2. **T3, read.** On the rising clock edge of T3, the CPU samples the opcode from the data bus into
   the instruction register, and the PC is incremented to point to the next byte.
3. **T3 and T4, decode.** While the CPU decodes the opcode, it uses the bus for something useful:
   it places a refresh address from the R register on the bus so that dynamic RAM can be refreshed
   without slowing the program down.
4. **Execute.** If the instruction needs more data, such as an operand or a memory location, the
   control unit runs further machine cycles (M2, M3, and so on). Simple instructions finish inside
   M1.

The Z80 can execute 158 instruction types (Zilog, 2016), and with all their register and
addressing variations there are far more opcodes than the 256 values one byte can hold, so some
instructions start with a **prefix byte** (CBh, DDh, EDh, or FDh) that tells the decoder to
read a second opcode byte. For example, the instruction IM 1 is encoded as ED 56h.

### 1.3 A Worked Example in Machine Language

Machine language is the binary code that the processor understands directly; assembly language
gives each instruction a readable name called a mnemonic, and an assembler converts the mnemonics
into those bytes (Computer Hope, 2019; Kuzechie, 2020). Table 1 shows a short program in both
forms. It adds 5 and 3, stores the result in memory, then waits for an interrupt.

**Table 1**

*Example Program in Assembly and Machine Language (Tested on an Emulator)*

| Address | Machine code (hex) | Assembly | What happens |
|---|---|---|---|
| 0000h | 31 00 FF | LD SP,FF00h | Set up the stack (needed before interrupts) |
| 0003h | ED 56 | IM 1 | Select interrupt mode 1 |
| 0005h | FB | EI | Enable maskable interrupts |
| 0006h | 3E 05 | LD A,05h | A = 5 |
| 0008h | 06 03 | LD B,03h | B = 3 |
| 000Ah | 80 | ADD A,B | A = A + B = 8 |
| 000Bh | 32 00 80 | LD (8000h),A | Store A at address 8000h |
| 000Eh | 76 | HALT | Stop and wait for an interrupt |
| 000Fh | 18 FD | JR 000Eh | After an interrupt, go back to HALT |

When the program ran on the emulator, A held 08h, memory address 8000h held 08h, the stack pointer
was FF00h, and the CPU was halted with interrupts enabled, exactly as the table predicts.

Figure 2 follows one of these instructions, LD (8000h),A, through its four machine cycles.
According to the Z80 manual, this instruction takes 4 M-cycles and 13 T-states, broken down as
4, 3, 3, and 3 (Zilog, 2016, p. 93). M1 fetches and decodes the opcode 32h, M2 and M3 read the
two bytes of the address (low byte first, as the Z80 stores 16-bit values), and M4 writes the
contents of A to that address. At 4 MHz the whole instruction takes 3.25 microseconds.

**Figure 2**

*Execution of LD (8000h),A Broken Into Machine Cycles and T-States*

[FIGURE figures/fig2.png]

## 2. How the Z80 Handles Interrupts

### 2.1 Two Kinds of Interrupt

An interrupt is a signal from hardware that asks the CPU to pause its current program and deal
with an event, such as a key being pressed. The Z80 has two interrupt inputs (Zilog, 2016):

- **/NMI, the non-maskable interrupt**, cannot be switched off by software. It is meant for urgent
  events such as an imminent power failure.
- **/INT, the maskable interrupt**, can be enabled with EI and disabled with DI. It is used for
  ordinary devices such as keyboards, timers, and serial ports.

Two interrupt flip-flops store whether maskable interrupts are allowed. **IFF1** is the actual
enable switch, and **IFF2** keeps a copy of it so that the previous state can be restored after a
non-maskable interrupt. EI sets both to 1 and DI clears both. One subtle but important detail is
that interrupts stay disabled during EI and the instruction after it (Zilog, 2016). This lets a
service routine end with EI followed by RETI and be sure the return completes before another
interrupt can arrive.

### 2.2 The Steps of an Interrupt

Figure 3 shows the decision the Z80 makes. The key point is that the CPU only checks for an
interrupt **at the end of an instruction**, so an instruction is never left half finished.

**Figure 3**

*Flowchart of Z80 Interrupt Acceptance and the Three Maskable Modes*

[FIGURE figures/fig3.png]

When a maskable interrupt is accepted, the Z80:

1. Finishes the current instruction.
2. Runs a special **interrupt acknowledge cycle**, an M1 cycle with the IORQ signal active, and adds
   two wait states so that slower peripherals and priority daisy-chains have time to respond
   (Zilog, 2016, p. 19).
3. Clears IFF1 and IFF2, so a second interrupt cannot interrupt the first one.
4. Pushes the PC onto the stack, so it knows where to return.
5. Jumps to the service routine chosen by the current **interrupt mode**.

### 2.3 The Three Interrupt Modes

The interrupt mode is chosen in software with IM 0, IM 1, or IM 2. The Z80 starts in Mode 0 after
a reset (Zilog, 2016, p. 19).

**Table 2**

*The Z80's Interrupt Modes Compared*

| Mode | Set with | Where the CPU goes | Best suited to |
|---|---|---|---|
| Mode 0 | IM 0 (ED 46) | Executes whatever instruction the device places on the data bus, usually a one-byte restart (RST n) | Systems designed for the older Intel 8080 |
| Mode 1 | IM 1 (ED 56) | Always calls address 0038h | Simple systems with one interrupt source |
| Mode 2 | IM 2 (ED 5E) | Builds a pointer from the I register (high byte) and a byte from the device (low byte), then reads the service routine's address from that table entry | Systems with several devices, each with its own routine |
| NMI | (always on) | Always calls address 0066h | Emergencies such as power failure |

Cook (2015) points out that most general peripherals cannot supply the bytes that Modes 0 and 2
need, so he recommends Mode 1 for simple home-built systems, where one routine at 0038h checks
which device needs attention. Mode 2 is the most powerful, because each device can point
directly to its own routine; Zilog's own peripheral chips are designed to supply the vector byte
for it (Zilog, 2016, pp. 19-20).

For the **non-maskable interrupt**, the CPU copies IFF1 into IFF2, clears IFF1, pushes the PC, and
restarts at 0066h. The routine ends with RETN, which returns and restores IFF1 from IFF2, so the
interrupted program gets back exactly the interrupt setting it had before (Zilog, 2016).

### 2.4 Worked Example: A Mode 1 Keyboard Interrupt

The program in Table 1 selected Mode 1 and halted. The service routine below, placed at 0038h,
reads a keyboard on I/O port 10h and stores the key code at 8001h.

```
0038h  F5        PUSH AF        ; save A and the flags
0039h  DB 10     IN A,(10h)     ; read the key code from port 10h
003Bh  32 01 80  LD (8001h),A   ; store it
003Eh  F1        POP AF         ; restore A and the flags
003Fh  FB        EI             ; allow interrupts again (after the next instruction)
0040h  ED 4D     RETI           ; return to the main program
```

On the emulator, a key code of 42h was supplied on port 10h and an interrupt was triggered while
the CPU was halted. Table 3 traces what happened.

**Table 3**

*Trace of the Mode 1 Interrupt on the Emulator*

| Moment | PC | SP | IFF1 | Result |
|---|---|---|---|---|
| Halted in main program | 000Fh (after HALT) | FF00h | 1 | A = 08h |
| Interrupt accepted | 0038h | FEFEh | 0 | Return address 000Fh pushed on the stack |
| After RETI | back at the HALT loop | FF00h | 1 | Memory 8001h = 42h, A still 08h |

The trace shows every step from Section 2.2: the CPU jumped to 0038h, saved the return address on
the stack (SP dropped by two bytes), disabled further interrupts, handled the keyboard, and
returned with A unchanged because the routine saved and restored it.

### 2.5 Worked Example: A Mode 2 Vectored Interrupt

Mode 2 was tested in the same way. The program loaded 90h into the I register with LD A,90h and
LD I,A, selected IM 2, and stored the address 0200h in the vector table at 9020h. When a device
supplied the vector byte 20h, the CPU formed the pointer 9020h, read the address 0200h from the
table, and jumped straight to the routine at 0200h, as shown in Figure 4. A second device could
supply a different byte, for example 22h, and reach its own routine without any polling.

**Figure 4**

*Mode 2 Vectored Interrupt From the Tested Example*

[FIGURE figures/fig4.png]

## 3. The Significance of Interrupt Handling in the Z80

### 3.1 Why Interrupts Matter

Without interrupts, a program would have to **poll**: check every device again and again in a loop
to see whether it needs attention. Polling wastes most of the processor's time, because devices are
usually idle, and it can still miss an event that happens between two checks. Interrupts reverse
the relationship: the CPU gets on with useful work, or halts to save power, and each device asks
for attention only when something actually happens. This is why the example program can simply
HALT until a key is pressed. Home computers built on the Z80, such as the ZX Spectrum, used a
regular timer interrupt in Mode 1 to scan the keyboard and keep time while the main program ran.

Interrupts also give the Z80 **priorities**. The non-maskable interrupt always wins, which
guarantees that an emergency such as a power failure is handled even if software has disabled
ordinary interrupts. Among maskable devices, Zilog's design lets peripherals be wired in a
daisy-chain so that the highest-priority device answers first, which is why the CPU adds two wait
states to the acknowledge cycle (Zilog, 2016, p. 19).

### 3.2 How the Design Ensures Smooth Operation

Several features of the Z80 work together so that an interrupt never disrupts the program it
interrupts:

1. **Interrupts only between instructions.** Because the CPU checks only after an instruction
   completes, it never stops halfway through one, so registers and memory are always in a
   consistent state.
2. **Automatic return address.** Pushing the PC onto the stack means the program resumes at
   exactly the right instruction. This is also why the stack pointer must be set up before
   interrupts are enabled, as the example program does first.
3. **Automatic disable.** Clearing IFF1 on entry stops a second interrupt from arriving before the
   routine has saved its registers, preventing a chain of half-finished routines.
4. **Saving and restoring registers.** The routine pushes the registers it uses and pops them before
   returning, as the PUSH AF and POP AF in the example show. The Z80 can also swap to its alternate
   register set in one instruction (EX AF,AF' and EXX), which makes context switching very fast.
5. **The EI delay and RETI.** Because EI only takes effect after the next instruction, EI followed by
   RETI always returns before a new interrupt is accepted. RETI also signals Zilog peripherals that
   the routine has finished, so the next device in the daisy-chain can be served.
6. **RETN for the non-maskable interrupt.** Restoring IFF1 from IFF2 means an emergency routine
   leaves the interrupt setting exactly as it found it.
7. **Vectored Mode 2.** With one table entry per device, the CPU reaches the correct routine
   immediately, without spending time asking each device whether it raised the interrupt.

Together these features let the Z80 respond to the outside world quickly and predictably while
the main program continues as if nothing had happened. For a programmer, the practical lessons are
to set up the stack first, choose the right mode for the hardware, keep service routines short,
save and restore every register they use, and end them with EI and RETI.

## Conclusion

The Z80 executes every instruction as a series of machine cycles, beginning with a four-T-state
opcode fetch in which it also refreshes memory, followed by any extra cycles needed to read or
write data. Interrupts fit neatly into this cycle: they are checked only between instructions,
acknowledged with a special cycle, and handled through one of three maskable modes or the
non-maskable interrupt at 0066h. The tested examples showed the processor saving its place,
running a service routine, and returning to exactly where it left off. That careful design is
what allows a small 8-bit processor to react to keyboards, timers, and emergencies without
losing track of the work it was doing.

## References

Both, D. (2020, July 7). *The central processing unit (CPU): Its components and functionality*.
Red Hat. https://www.redhat.com/en/blog/cpu-components-functionality

Computer Hope. (2019, June 30). *Machine language*.
https://www.computerhope.com/jargon/m/machlang.htm

Cook, M. (2015, April 15). *Z80 interrupts*. Z80 Journal.
https://z80journal.wordpress.com/2015/04/15/z80-interrupts/

Futurology. (2017, December 7). *How a CPU works | The CPU explained* [Video]. YouTube.
https://www.youtube.com/watch?v=XQq_1yaVDpM

Kuzechie, A. (2020, June 8). *Programming Z80 microprocessor* [Video]. YouTube.
https://www.youtube.com/watch?v=UrLHufXCRGc

Zilog. (2016). *Z80 CPU user manual* (UM008011-0816). https://www.zilog.com/docs/z80/um0080.pdf
