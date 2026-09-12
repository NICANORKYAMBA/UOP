# Written Assignment Unit 2: Smart Home Electronic Security System

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili

## Introduction

As an intern, I have been asked to design a simple electronic security system for a smart
home using combinational circuits. The system controls access to several rooms and lets
authorized users enter by typing a code or presenting a keycard. Because the decision to
grant or deny access depends only on the current inputs (the entered code and the selected
room) and needs to be immediate, a combinational design built from logic gates, an encoder,
a multiplexer, a decoder, and a demultiplexer is well suited to the task (Ndjountche, 2016).
This journal presents the design, explains how each component is integrated, and shows how a
demultiplexer extends the system to handle many rooms efficiently.

## (a) Design of the Electronic Security System

The system has four functional stages that flow from input to action:

1. **Input capture (keypad/keycard) with an encoder.** A user enters a code on a keypad or
   presents a keycard. The keypad has one line per key; an **encoder** compresses those many
   one-hot input lines into a compact binary code. For example, a decimal-to-BCD (10-to-4)
   encoder turns a pressed digit into a 4-bit binary value, so the rest of the circuit works
   with a few bits instead of many wires (Ndjountche, 2016).

2. **Room selection with a multiplexer.** Each room stores its own authorized code. A
   **multiplexer (MUX)** uses the room-select bits as its control lines to route the correct
   stored code (or the correct comparison result) for the room the user is trying to enter.
   The MUX therefore chooses "which room's rule applies right now."

3. **Authorization decision with logic gates.** A comparator built from **XNOR and AND
   gates** checks whether the entered binary code matches the stored code for the selected
   room. Each bit pair is compared with an XNOR gate, which outputs 1 only when its two bits
   are equal; this equality behavior is the standard building block of a digital magnitude/
   equality comparator (Mano & Ciletti, 2018). The XNOR outputs are then combined with a
   single AND gate, so the AND output is 1 (ACCESS GRANTED) only when **every** bit matches.
   For a 4-bit code, the grant expression is:

   **Grant = (A₀ XNOR S₀) AND (A₁ XNOR S₁) AND (A₂ XNOR S₂) AND (A₃ XNOR S₃)**

   where A is the entered code and S is the stored code. A keycard-present signal can be
   AND-ed in for high-security rooms (requiring both a valid card and a valid code) or OR-ed
   in for convenience doors (a valid card **or** a valid code), and a NOT gate on a tamper or
   door-open sensor can force Grant to 0 under unsafe conditions.

4. **Room activation with a decoder/demultiplexer.** Once access is granted, a **decoder**
   takes the room-select bits and activates exactly one of its output lines, which unlocks the
   corresponding door. The single "grant" signal is thus directed to only the intended room.

A simplified signal path is:

```
Keypad/Keycard --> ENCODER --> entered code (binary)
Room buttons ------------------> select bits ---> MUX (pick room's stored code)
entered code + stored code ---> XNOR per bit ---> AND ---> GRANT signal
GRANT + select bits ----------> DECODER/DEMUX ---> unlock only the selected room
```

*(A Logisim implementation of this circuit is inserted below.)*

**[ Insert Logisim circuit screenshot here ]**

## (b) Integration of Components and How They Work Together

**Encoder.** The encoder is the entry point. Without it, every key or card line would need
its own wire through the whole circuit. By compressing, say, ten input lines into a 4-bit
code, the encoder reduces wiring and lets the comparison logic operate on a small, fixed
number of bits (Ndjountche, 2016). Its output (the entered binary code) feeds the comparator.

**Multiplexer.** The MUX makes the system scalable across rooms. Each room has a stored
authorized code; the room-select control lines tell the MUX which stored code to present to
the comparator. This means one comparison circuit is reused for every room rather than
duplicating a comparator per room. The MUX output (the selected room's stored code) is one of
the two inputs to the comparator.

**Logic gates (XNOR + AND, with NOT/OR as needed).** The gates perform the actual
authorization decision. Bit-by-bit, an **XNOR** gate reports whether the entered bit equals
the stored bit; equality on every bit is required, so the XNOR outputs feed a single **AND**
gate whose output is the GRANT signal. NOT gates can invert a "door already open" or "tamper"
sensor so that access is blocked under unsafe conditions, and an OR gate can allow either a
valid code **or** a master keycard to open a low-security room. Because these are
combinational gates, the grant/deny result appears immediately for the current inputs.

**Decoder.** The decoder converts the room-select bits into a one-hot activation: for n
select bits it drives one of 2^n outputs high (Ndjountche, 2016). Combined (AND-ed) with the
GRANT signal, the decoder ensures the unlock pulse reaches only the room the user selected and
was authorized for, never another room.

**Working together.** The flow is a clean pipeline: the encoder shrinks the raw input into a
code; the MUX selects the relevant room's stored code; the gate-based comparator decides
grant or deny; and the decoder routes that decision to the correct door. Each block does one
job, and their combinational nature means the entire path settles to the correct outputs as
soon as the inputs are stable, which is exactly what a responsive door-access system needs.

## (c) Enhancing the Design with a Demultiplexer

A **demultiplexer (DEMUX)** is the natural way to scale access control to many rooms
efficiently. A DEMUX takes a single data input and, using select lines, routes it to exactly
one of several outputs, the reverse of a multiplexer (Ndjountche, 2016). In this system, the
single GRANT signal from the comparator becomes the DEMUX data input, and the room-select
bits become the DEMUX select lines. The DEMUX then sends the unlock pulse to only the selected
room's actuator, leaving all other doors locked.

This is efficient because it reuses **one** comparison/authorization circuit for the whole
house instead of building a separate authorizer for each room: the MUX chooses which room's
code to check on the way in, and the DEMUX distributes the single decision to the right door
on the way out. Adding more rooms simply requires more select-line width (n select lines
support 2^n rooms) rather than duplicating logic, keeping the design compact and scalable.

**Academic integrity:** This assignment is my own original work. The system design and all
explanations were written by me, and ideas drawn from the course readings are cited in APA
style below.

## References

Harris, D. M., & Harris, S. L. (2012). *Digital design and computer architecture* (2nd ed.).
Morgan Kaufmann.

Mano, M. M., & Ciletti, M. D. (2018). *Digital design: With an introduction to the Verilog
HDL, VHDL, and SystemVerilog* (6th ed.). Pearson.

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley &
Sons. https://ebookcentral.proquest.com/
