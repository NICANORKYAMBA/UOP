# Unit 6 Learning Notes: Computer Architecture, CPU Design, ISA, and the Z80

Course: CS 1105 Digital Electronics & Computer Architecture
Readings: Both (2020) CPU components; Computer Hope (2019) machine language; Cook (2015) Z80
interrupts; Wu (2023) computer architecture explained. Videos: Futurology (2017); Kuzechie (2020).

Due October 14, 2026: Discussion (post by **Sunday Oct 11**, 2 replies by **Wednesday Oct 14**),
Assignment Activity, and the **Graded Quiz** (counts toward the final grade).

---

## 1. Architecture levels (Wu, 2023)

- **ISA (instruction set architecture):** what software sees: instructions, registers, data types,
  addressing. The contract between software and hardware.
- **Microarchitecture:** how a specific chip implements the ISA (pipelines, caches, cores).
- **RTL (register-transfer level):** how data moves between registers each clock.

**CISC vs RISC:** CISC (x86, Z80) has many complex instructions of varying length. RISC (ARM,
RISC-V, MIPS) has fewer, simpler, fixed-length instructions, which suits pipelining and low power.

**Common ISAs:** x86 (Intel and AMD PCs, including Pentium), ARM (phones, Apple M-series), MIPS and
SPARC (older workstations and embedded), RISC-V (open).

## 2. The CPU (Both, 2020)

- **Control unit** coordinates everything. **ALU** does arithmetic and logic. **Registers** are the
  fastest storage. **Cache** sits between registers and RAM.
- **Instruction cycle:** fetch the instruction from memory, decode it, execute it, repeat.
- **Stack:** a last-in, first-out area of memory used to save **return addresses** for calls and
  interrupts and to hold **local variables** and saved registers.
- **Assembler:** translates assembly language into machine code.

## 3. Memory types to know

| Memory | Key facts |
|---|---|
| Registers and cache | fastest; cache is closest to the CPU with the smallest capacity |
| RAM | fast, volatile working memory |
| ROM | non-volatile; holds firmware, BIOS, and CPU **microcode** |
| EEPROM | non-volatile and can be **electrically erased and reprogrammed** |
| Flash | a fast, block-erasable kind of EEPROM, used for firmware and SSDs |
| Virtual memory | uses disk to extend RAM; slow |
| Disk, optical, tape | slowest, cheapest, largest |

**MMU (memory management unit):** translates virtual addresses to physical ones and protects each
program's memory from the others.

## 4. Arithmetic hardware

- **Barrel shifter:** shifts or rotates a word by any number of bits in one step.
- **Wallace tree multiplier:** adds the partial products of a multiplication in parallel layers,
  which makes multiplication much faster than adding them one by one.

## 5. Interrupts

- **Hardware interrupt:** triggered by an external device or event (key press, mouse, timer chip).
- **Software interrupt:** triggered by an instruction in the program.
- Z80: /NMI goes to 0066h; /INT in Mode 0 (device supplies an instruction), Mode 1 (0038h), or
  Mode 2 (I register + vector byte gives a table entry). EI/DI control IFF1 and IFF2. Return with
  RETI (maskable) or RETN (NMI).

---

## Graded Quiz preparation

The Graded Quiz counts toward your final grade, so these notes do not mark the answers. Every
question is covered by one of the sections above:

| Quiz topic | Read section |
|---|---|
| Processor architecture of Intel Pentium | 1 (common ISAs) |
| Memory for firmware, BIOS, microcode; EEPROM advantage; fastest memory; closest to CPU | 3 |
| Hardware vs software interrupts | 5 |
| Fetch-execute cycle, stack, assembler | 2 |
| Barrel shifter, Wallace tree | 4 |
| MMU | 3 |

Tip: for each question, eliminate the options that clearly describe a different component, then
check the one that matches the definition in these notes.

## References

Both, D. (2020, July 7). *The central processing unit (CPU): Its components and functionality*.
Red Hat. https://www.redhat.com/en/blog/cpu-components-functionality

Wu, H.-W. (2023, June 22). *Computer architecture explained: The bridge between software and
hardware*. DataSci Ocean. https://datasciocean.com/en/other/what-is-computer-architecture/

Zilog. (2016). *Z80 CPU user manual* (UM008011-0816). https://www.zilog.com/docs/z80/um0080.pdf
