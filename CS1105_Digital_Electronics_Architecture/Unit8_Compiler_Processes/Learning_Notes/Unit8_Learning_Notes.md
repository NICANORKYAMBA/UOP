# CS 1105 Unit 8: Compiler Processes and Symbol Resolution

Learning notes by Nicanor Maswili. Due: discussion post Sunday Oct 25 (final Oct 28), peer
replies Wednesday Oct 28, assignment Oct 28, 2026.

## Learning Outcomes

1. Determine why accurate symbol placement matters for computing systems.
2. Explain symbol resolution in digital logic, microprocessors, and assembly programming.

## The Build Chain (Bhargav, Baeldung)

| Stage | Input -> output | Symbol work it does |
|---|---|---|
| Compiler | source code -> assembly | names variables and functions |
| Assembler | assembly -> object file | builds the symbol table; resolves local labels |
| Linker | object files -> executable | resolves global/external symbols; relocates addresses |
| Loader | executable -> running process | places code in memory; starts at the entry point |

## Single-Pass vs Multipass (Pediaa; Brainkart)

- **Single pass:** reads the source once. Fast, but a label used before it is defined (a forward
  reference) needs extra tricks, such as patching it later.
- **Two-pass (multipass) assembler:** pass 1 counts bytes with a program location counter (PLC)
  and records every label's address in the **symbol table**; pass 2 assembles the instructions
  using those addresses.

## Symbol Types and Linker Rules (Arun, Binary Dodo)

- Three kinds: **defined**, **undefined**, **tentative**.
- One definition: resolved. None: `undefined reference`. Two global definitions: fatal
  `multiple definition`. Global vs weak: **global wins silently**.
- nm letters: `T`/`t` code (global/local), `D`/`d` data, `U` undefined, `V` weak object,
  `a` absolute constant.

## Resolution, Then Relocation

The object file holds placeholders plus relocation entries. After matching each symbol, the
linker writes the real address in. From my example:
`call print_msg`: `E8 FC FF FF FF` in main.o became `E8 1B 00 00 00` in the executable
(0x08049020 - 0x08049005 = 0x1B).

## Symbols in Hardware

- Bits (0/1) are the basic symbols; buses carry groups of them.
- A **net** must carry one value. In Logisim, tunnels with the same label are one net, and
  conflicting drivers give the error value **E** (red wire).
- The CPU's **decoder** resolves opcode bits into an operation; the **address bus** carries the
  resolved address (8085: 16-bit address bus, 8-bit data bus).
- Kann 4.4: in `LDR r1, =num`, `num` is the **address** of the value, not the value.

## Reading Questions

1. **Why is symbol resolution critical in digital systems?** Every name and every wire must map
   to exactly one thing. Otherwise a signal has no defined value, or a program reads the wrong
   memory, and the hardware cannot detect the mistake by itself.
2. **How does it influence instruction execution and addressing?** The processor executes only
   numbers. Resolution produces the opcode and the exact operand address (absolute, or a
   PC-relative distance) that the decoder and address bus use, so execution can run at full speed
   without any lookups.

## Self-Quiz Unit 8

| Q | Answer | Note |
|---|---|---|
| 1 | Multiple meanings | Ambiguity = a symbol that could mean more than one thing |
| 2 | Symbol tables | Built by the assembler in pass 1 |
| 3 | Instruction decoding | The decoder resolves opcode bits into an operation |
| 4 | Resolve conflicts | Pick one meaning when names clash |
| 5 | Manage memory | Labels become memory addresses (least certain; check the feedback) |
| 6 | Digital Logic Design | |
| 7 | Web development | Not a digital logic technique |
| 8 | Registers | Register names and mnemonics become machine-code bits |
| 9 | Translation | Between assembly and machine code |
| 10 | Compiler optimization | Least certain; check the feedback |
