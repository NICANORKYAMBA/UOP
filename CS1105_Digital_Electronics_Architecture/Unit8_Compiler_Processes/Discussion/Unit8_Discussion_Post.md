# Symbols: The Puzzle Pieces of a Computer

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Due:** October 28, 2026

## The Role of Symbols in Digital Logic

In digital logic, every piece of information is built from a tiny alphabet of symbols: 0 and 1,
represented by two voltage levels on a wire. Groups of these bits then stand for larger symbols,
such as a number, a letter, or an instruction. Circuits also use names. In Logisim, a tunnel
connects every point that carries the same label, so one named signal can travel across a
circuit without a visible wire (Burch, n.d.-b).

Resolution decides what each symbol actually is at any moment. A wire must carry exactly one
value, so when several components drive the same net, the simulator has to settle on a single
result. To see this, I built a small Logisim circuit where two inputs drive one net through
tunnels labelled bus. When both inputs were 0 or both were 1, the net resolved cleanly. When one
was 0 and the other 1, the wire turned red and the output showed E, an error value, which
Logisim's documentation explains as a conflict between components driving opposite values onto
one wire (Burch, n.d.-a). A circuit whose symbols cannot be resolved cannot be trusted, because
everything connected to that wire receives meaningless data.

## How Digital Language, Microprocessor Smarts, and Assembly Fit Together

I see three layers, each turning symbols into something the next layer can use.

1. **Digital language, the foundation.** Logic gates combine bits into adders, registers, and
decoders. These are the building blocks of every processor.
2. **Microprocessor smarts, the interpreter.** A processor is a machine for resolving instruction
symbols. WatElectronics (2020) describes the 8085, whose architecture includes an instruction
register and a decoder, and whose 16-bit address bus carries the address of every memory access.
The decoder turns opcode bits into one specific operation, and the address bus delivers exactly
the location the instruction names.
3. **Assembly instructions, the human interface.** Assembly lets people write symbolic
instructions such as mov and call instead of raw binary (Fernando, 2026). The assembler records
every label in a symbol table during a first pass, then uses it to assemble the instructions in a
second pass (*Assembly and Linking*, n.d.). The linker then combines all object files and resolves
every memory reference into a final address (Bhargav, 2024).

This layering is what makes computers both fast and smart. All the name-to-number work happens
once, before the program runs, so the processor never wastes time looking anything up. In a
two-file assembly program I linked this week, the instruction call print_msg went from the
placeholder bytes E8 FC FF FF FF in the object file to E8 1B 00 00 00 in the executable: the
linker had computed the 0x1B-byte distance to print_msg. When the program runs, the processor
simply reads the opcode E8, adds 0x1B to its program counter, and jumps, all at hardware speed.
People get to write clear names, and the hardware gets plain numbers.

## Accurate Placement: Making the Puzzle Fit

Like puzzle pieces, every symbol must fit exactly one place. Kann (2021, Section 4.4) shows that
in LDR r1, =num, the label num stands for the address where the value is stored, not for the
value itself. If that address were placed wrongly, the program would quietly load the wrong data.

The linker enforces the "exactly one piece" rule. Arun (2016) explains that the link-editor
searches the symbol tables of all input files for each undefined reference; one definition
resolves it, while two global definitions are a fatal error and a global definition overrides a
weak one. I saw each case for real. Linking my program without the file that defines print_msg
produced "undefined reference to print_msg", which is a missing piece. Adding a second global
print_msg produced "multiple definition", which is two pieces competing for one spot. Only with
exactly one definition did the program run and print its message. Kanich (2020) shows the same
binding process step by step. Accurate placement turns separately written files and separately
designed circuits into one picture that works.

**Question for the class:** Symbol resolution can happen when a program is built (static
linking) or when it starts running (dynamic linking with shared libraries). Which would you
choose for software on a small embedded microprocessor, and why?

Word count: 685

## References

Arun. (2016, July 1). *Symbol resolution during link-editing*. Binary Dodo.
https://binarydodo.wordpress.com/2016/07/01/symbol-resolution-during-link-editing/

*Assembly and linking*. (n.d.). Brainkart. https://www.brainkart.com/article/Assembly-and-Linking_11818/

Bhargav, N. (2024, March 18). *Compiler, linker, assembler, and loader*. Baeldung on Computer
Science. https://www.baeldung.com/cs/compiler-linker-assembler-loader

Burch, C. (n.d.-a). *Wire colors*. Logisim 2.7 user's guide.
https://cburch.com/logisim/docs/2.7/en/html/guide/bundles/colors.html

Burch, C. (n.d.-b). *Tunnel*. Logisim 2.7 library reference.
https://cburch.com/logisim/docs/2.7/en/html/libs/wiring/tunnel.html

Fernando, J. (2026, July 30). *A beginner's guide to assembly languages*. Investopedia.
https://www.investopedia.com/terms/a/assembly-language.asp

Kanich, C. (2020, September 1). *How do linkers resolve symbols? Systems programming CS lecture*
[Video]. YouTube. https://www.youtube.com/watch?v=6XVUIeAaROU

Kann, C. W. (2021). *Introduction to assembly language programming: From soup to nuts: ARM
edition*. Open Educational Resources, 8. Gettysburg College. https://cupola.gettysburg.edu/oer/8/

WatElectronics. (2020, April 27). *Microprocessor: Architecture, types, examples and its
applications*. https://www.watelectronics.com/what-is-a-microprocessor-architecture-types-its-applications/
