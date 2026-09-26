# Designing a Binary Calculator: Adder, Subtractor, Multiplier, and Divider Modules

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** September 30, 2026

For this project our team is designing a digital calculator for a mathematics competition.
Contestants type decimal numbers, but inside the calculator every value is handled in binary.
The goal is to show that addition, subtraction, multiplication, and division can all be done
quickly and correctly with a small amount of hardware, as long as the four modules are planned
together instead of being built as four separate machines.

Three design decisions shape everything that follows. First, numbers are stored as 8-bit
two's complement values, so the calculator handles whole numbers from -128 to +127, and a
multiplication produces a full 16-bit result. Second, one fast adder is the shared core of all
four operations. Third, the design was developed bottom-up and tested as it grew: a full adder
was built from gates, four full adders were combined into a 4-bit adder/subtractor, and the
complete calculator was then assembled and tested in Logisim as a 4-bit prototype. The
prototype has exactly the same structure as the 8-bit design, only narrower, so it could be
wired by hand and checked against the worked examples in Section 3. This paper explains the
design of each module, shows how the modules are integrated, gives worked examples for every
operation, compares binary with decimal arithmetic, and explains why building this calculator
is a strong way to understand number systems.

## 1. Design and Development of the Binary Arithmetic Modules

### 1.1 Number Format

Two's complement was chosen over sign-magnitude and one's complement because it has only one
representation of zero and, more importantly, because the same adder circuit works for positive
and negative numbers without any special cases (Ndjountche, 2016a). A negative number is formed
by inverting every bit of the positive value and adding 1, so -27 is 11100101. The most
significant bit acts as the sign bit. This single choice is what allows subtraction to reuse
the adder, as Section 1.3 shows.

### 1.2 The Adder

The adder is designed first because every other module depends on it. The smallest building
block is the full adder, which adds two operand bits A and B plus a carry-in, and produces a sum
bit and a carry-out (Ndjountche, 2016b). Its behavior is fully described by Table 1.

**Table 1**

*Full Adder Truth Table*

| A | B | Cin | Sum | Cout |
|---|---|---|---|---|
| 0 | 0 | 0 | 0 | 0 |
| 0 | 0 | 1 | 1 | 0 |
| 0 | 1 | 0 | 1 | 0 |
| 0 | 1 | 1 | 0 | 1 |
| 1 | 0 | 0 | 1 | 0 |
| 1 | 0 | 1 | 0 | 1 |
| 1 | 1 | 0 | 0 | 1 |
| 1 | 1 | 1 | 1 | 1 |

From the table, the sum is 1 when an odd number of inputs are 1, and the carry is 1 when at
least two inputs are 1. This gives two equations that need only five gates:

```
Sum  = A XOR B XOR Cin
Cout = (A AND B) OR (Cin AND (A XOR B))
```

Figure 1 shows this full adder built in Logisim from two XOR gates, two AND gates, and one OR
gate, and saved as a reusable subcircuit.

**Figure 1**

*Full Adder Subcircuit Built From Logic Gates in Logisim*

[FIGURE figures/fig1_fulladder.png]

Chaining full adders, with each carry-out feeding the next carry-in, gives a ripple-carry adder.
It is simple and uses few gates, which makes it the right first version to build and test. Its
weakness is speed: the carry may have to travel through every stage before the top bit is
correct, so the delay grows in proportion to the number of bits, roughly two gate delays per
bit (Harris & Harris, 2013). For an 8-bit word that is about 16 gate delays on the worst case.

The final design therefore uses a carry-lookahead adder. For every bit position it computes a
generate signal Gi = Ai AND Bi (this bit creates a carry by itself) and a propagate signal
Pi = Ai XOR Bi (this bit passes an incoming carry along). Each carry can then be written
directly in terms of the inputs instead of waiting for the previous stage:

```
C1 = G0 + P0.C0
C2 = G1 + P1.G0 + P1.P0.C0
C3 = G2 + P2.G1 + P2.P1.G0 + P2.P1.P0.C0
C4 = G3 + P3.G2 + P3.P2.G1 + P3.P2.P1.G0 + P3.P2.P1.P0.C0
```

All four carries are produced at the same time by two levels of AND and OR gates, so a 4-bit
block settles in a few gate delays no matter which carry pattern arrives (Ndjountche, 2016b;
Harris & Harris, 2013). The 8-bit adder is built from two 4-bit lookahead blocks, with the
carry out of the lower block feeding the upper block. The cost is more gates, but because
every other module passes through this adder, this is the place where extra hardware pays off
the most.

### 1.3 The Subtractor

Rather than building a separate subtractor, the calculator subtracts by adding. In two's
complement, A - B = A + (NOT B) + 1 (Ndjountche, 2016a). Each bit of B passes through an XOR
gate whose other input is a control line called SUB. When SUB = 0, the XOR gates pass B
unchanged and the circuit adds. When SUB = 1, the XOR gates invert every bit of B, and the same
SUB line is connected to the carry-in of the lowest full adder, which supplies the "+1". One
control wire and eight XOR gates turn the adder into an adder/subtractor.

Two flags come out of this module almost for free. The carry-out (C) shows an unsigned carry
when adding, and for subtraction C = 1 means no borrow occurred. The overflow flag (V) catches
signed results that do not fit the word size. Overflow happens exactly when the carry into the
sign bit differs from the carry out of it, so V = C7 XOR C8 in the 8-bit design, which costs
one more XOR gate. Figure 2 shows the 4-bit prototype of this module, where four copies of the
Figure 1 full adder are chained and the XOR row sits on the B inputs.

**Figure 2**

*Four-Bit Adder/Subtractor Subcircuit Performing 5 - 2 With SUB = 1*

[FIGURE figures/fig2_addsub4.png]

### 1.4 The Multiplier

Binary multiplication is simpler than decimal multiplication because each partial product is
either the multiplicand (when the multiplier bit is 1) or zero (when it is 0), so no times
table is needed. The calculator uses the shift-and-add method (Ndjountche, 2016b). The hardware
has three registers: M holds the multiplicand, Q holds the multiplier, and P is an accumulator
that starts at zero, with a carry bit C above it. For each of the n multiplier bits, the control
unit looks at the lowest bit of Q. If it is 1, the shared adder adds M into P. Then C, P, and Q
shift right together by one place. After n steps, P and Q together hold the full 2n-bit
product. This design reuses the adder and adds only a shift register and a step counter, so it
is small. Its cost is time: an 8-bit multiplication takes 8 clock cycles.

Two refinements make the multiplier better suited to a competition. For signed numbers, a
simple approach is to record the signs, multiply the magnitudes, and negate the result if
exactly one input was negative. A neater approach is Booth's algorithm, which works
directly on two's complement numbers and replaces a run of 1s in the multiplier with one
subtraction and one addition, which reduces the number of additions for many inputs (Booth,
1951). For speed, an array multiplier can be added as an option. It forms all partial products
at once with a grid of AND gates (n x n gates) and adds them with rows of full adders, giving
the product in one pass instead of n cycles (Ndjountche, 2016b). The trade-off between these
two designs is the classic one in hardware: area against time.

### 1.5 The Divider

Division uses the restoring method, which is the binary form of long division (Ndjountche,
2016b). It uses a remainder register, a quotient register, and the same shared adder in
subtract mode. For each dividend bit, from the most significant down, the control unit repeats
three steps:

1. Shift the remainder left and bring in the next dividend bit.
2. Subtract the divisor from the remainder using the adder with SUB = 1.
3. If the result is negative, add the divisor back (restore) and write 0 as the next quotient
   bit. Otherwise keep the result and write 1.

After one step per bit, the quotient register holds the answer and the remainder register holds
what is left. Before starting, the control unit checks whether the divisor is zero. If it is,
the operation stops and the calculator shows an error. This check matters in practice: while
testing the Logisim prototype I found that its built-in divider does not signal an error when
dividing by zero, it simply returns the dividend as the quotient, which would give a contestant
a wrong answer with no warning. A dedicated DIV0 flag solves this. For signed division, the
magnitudes are divided and the signs are fixed afterward, with the remainder taking the sign of
the dividend. A non-restoring divider, which skips the restore step by adding on the next cycle
instead, would save time but is harder to explain and test, so the restoring version was chosen
for a teaching calculator.

### 1.6 Development and Testing Approach

The modules were developed in the order that each one depends on the last. The full adder was
built first and tested against all eight rows of Table 1. The 4-bit adder/subtractor was built
from four full adders and tested on positive, negative, and overflow cases. The multiplier,
divider, output multiplexer, and flags were then added to form the complete calculator, and it
was tested with the cases in Table 7. Building and testing in this order meant that when a
result was wrong, the fault could only be in the newest part, which made debugging quick. It
also means the design scales cleanly: the 8-bit version is the same circuit with eight full
adders in place of four and wider registers.

## 2. Integration and Organization of the Modules

The central idea of the integration is that the four modules are not four separate circuits.
They share one adder/subtractor, one set of registers, and one output path, and a small control
unit decides how those shared parts are used on each clock cycle. This is the same organization
as the arithmetic logic unit in a processor, which receives two operands and an operation code
and returns a result plus status flags (Learn Computer Science, 2022; Ndjountche, 2016b).

```
 Keypad (decimal digits)
        |
        v
 Input converter (BCD to binary)
        |
   +----+-----+
   v          v
 Reg A      Reg B ---> [ XOR x8 ] <--- SUB (from control)
   |          |             |
   v          v             v
 +--------------------------------------+
 |  8-bit carry-lookahead adder         | <--- Cin = SUB
 +--------------------------------------+
   |               |              |
   |               |              +--> Flags: C, Z, N, V, DIV0
   |               v
   |       Registers P, Q + step counter
   |       (product / quotient / remainder)
   v               v
 +--------------------------------------+
 |  Output multiplexer (select = opcode) |
 +--------------------------------------+
        |
        v
 Result register --> Output converter (binary to BCD) --> Display

 Control unit (finite state machine): decodes the opcode, sets SUB,
 runs 8 steps for MUL and DIV, checks for division by zero
```

### 2.1 Data Path

Data moves through the calculator in a fixed order. The contestant types a number on the
keypad and the input converter changes the decimal digits into an 8-bit binary value, which is
loaded into register A. The second number goes into register B. The operation key sets a 3-bit
opcode (Table 2). The shared adder and the multiply/divide registers do the work, and an output
multiplexer controlled by the opcode chooses which result reaches the result register. Finally,
the output converter turns the binary result back into decimal digits for the display, adding a
minus sign when the N flag is set and an error symbol when V or DIV0 is set.

**Table 2**

*Opcodes and the Control Signals Each One Sets*

| Opcode | Operation | SUB | Steps | Result taken from | Flags that matter |
|---|---|---|---|---|---|
| 000 | ADD | 0 | 1 | Adder | C, Z, N, V |
| 001 | SUBTRACT | 1 | 1 | Adder | C, Z, N, V |
| 010 | MULTIPLY | 0 | 8 | P and Q (16 bits) | Z |
| 011 | DIVIDE | 1 | 1 + 8 | Quotient and remainder | Z, DIV0 |
| 100 | BCD ADD | 0 | 1 + correction | Adder with +6 fix | C |
| 101 | COMPARE | 1 | 1 | Flags only | Z, N, V |

### 2.2 Control Unit

The control unit is a finite state machine built from flip-flops, the same kind of sequential
circuit studied in Unit 3. Its states are listed in Table 3. ADD, SUBTRACT, BCD ADD, and
COMPARE finish in one execute cycle. MULTIPLY and DIVIDE enter a loop state that repeats eight
times under the control of a 3-bit step counter, and on each pass the control unit sets SUB
(0 for multiply, 1 for divide), enables the adder only when needed, and triggers the shift.

**Table 3**

*Control Unit States*

| State | What happens | Next state |
|---|---|---|
| IDLE | Wait for the equals key | LOAD |
| LOAD | Copy the operands into A and B, clear P, Q, and the counter | CHECK |
| CHECK | If DIVIDE and B = 0, set DIV0 | ERROR, or EXECUTE |
| EXECUTE | One-cycle operations finish here | DONE, or STEP for MUL/DIV |
| STEP | One add or subtract plus one shift, counter + 1 | STEP until 8 steps, then DONE |
| DONE | Load the result register and update the display | IDLE |
| ERROR | Show "Error" until the clear key is pressed | IDLE |

### 2.3 Why This Organization Works

Organizing the calculator this way has four benefits. First, it saves hardware, because one
fast adder serves all four operations instead of four separate arithmetic circuits. Second,
any improvement to that adder, such as the lookahead carry logic, makes every operation faster
at once. Third, the flags give extra features at no cost: COMPARE is a subtraction whose result
is thrown away, and the Z and N flags tell the contestant whether A is equal to, greater than,
or less than B (Ndjountche, 2016b). Fourth, errors are caught in one place. Overflow and
division by zero are both detected by the control unit before a result is shown, so the
calculator never displays a wrong answer silently.

### 2.4 Logisim Prototype of the Integrated Design

Figures 3 and 4 show the integrated 4-bit prototype. The inputs A, B, and a 2-bit opcode (00
add, 01 subtract, 10 multiply, 11 divide) feed three blocks in parallel: the adder/subtractor
from Figure 2 (with opcode bit 0 wired to SUB), a multiplier, and a divider. A 4-input
multiplexer controlled by the opcode chooses which result goes to the output, and two hex
displays show the 8-bit result. The flags are built beside the multiplexer: Z from a comparator
that checks the result against zero, V from the adder/subtractor (active only for add and
subtract), and DIV0 from a comparator on B combined with the divide opcode. Figure 5 shows the
DIV0 flag stopping a division by zero.

**Figure 3**

*Integrated Calculator Multiplying 13 x 11 (Display Shows 8F = 143)*

[FIGURE figures/fig3_multiply.png]

**Figure 4**

*Integrated Calculator Dividing 13 by 3 (Display Shows Remainder 1, Quotient 4)*

[FIGURE figures/fig4_divide.png]

**Figure 5**

*Error Flag Raised for Division by Zero*

[FIGURE figures/fig5_flags.png]

## 3. Examples of Binary Calculations

All examples use 8-bit two's complement unless stated otherwise, and each one is checked by
converting the answer back to decimal.

### 3.1 Converting the Input

The keypad value 45 is converted by repeated division by 2, reading the remainders from bottom
to top (Ndjountche, 2016a).

**Table 4**

*Converting 45 to Binary by Repeated Division*

| Division | Quotient | Remainder |
|---|---|---|
| 45 / 2 | 22 | 1 |
| 22 / 2 | 11 | 0 |
| 11 / 2 | 5 | 1 |
| 5 / 2 | 2 | 1 |
| 2 / 2 | 1 | 0 |
| 1 / 2 | 0 | 1 |

Reading upward gives 101101, stored as 00101101 (hexadecimal 2D). Check: 32 + 8 + 4 + 1 = 45.
In the same way, 27 = 00011011 (hexadecimal 1B).

### 3.2 Addition: 45 + 27 = 72

```
   carries  0 1 1 1 1 1 1 0
            0 0 1 0 1 1 0 1   (45)
          + 0 0 0 1 1 0 1 1   (27)
          -----------------
            0 1 0 0 1 0 0 0   (72)
```

Check: 64 + 8 = 72 (hexadecimal 48). The carry into and out of the sign bit are both 0, so
there is no overflow. Flags: C = 0, Z = 0, N = 0, V = 0.

### 3.3 Subtraction: 45 - 27 = 18

SUB = 1, so the XOR row inverts B and the carry-in supplies the +1:

```
  27        = 0 0 0 1 1 0 1 1
  NOT 27    = 1 1 1 0 0 1 0 0
  +1 (Cin)  = 1 1 1 0 0 1 0 1   (-27 in two's complement)

            0 0 1 0 1 1 0 1   (45)
          + 1 1 1 0 0 1 0 1   (-27)
          -----------------
        1   0 0 0 1 0 0 1 0   (18, carry out = 1 means no borrow)
```

Check: 16 + 2 = 18.

### 3.4 Subtraction With a Negative Result: 27 - 45 = -18

```
            0 0 0 1 1 0 1 1   (27)
          + 1 1 0 1 0 0 1 1   (-45)
          -----------------
            1 1 1 0 1 1 1 0   (-18)
```

The sign bit is 1, so N = 1. To read the size of the answer, invert and add 1:
00010001 + 1 = 00010010 = 18, so the display shows -18.

### 3.5 Overflow Detection: 100 + 50

```
            0 1 1 0 0 1 0 0   (100)
          + 0 0 1 1 0 0 1 0   (50)
          -----------------
            1 0 0 1 0 1 1 0   (looks like -106)
```

Two positive numbers produced a negative-looking result. The carry into the sign bit is 1 and
the carry out of it is 0, so V = 1 XOR 0 = 1, and the calculator shows an overflow error
instead of a wrong answer, because 150 is outside the 8-bit range of -128 to +127.

### 3.6 Multiplication: 13 x 11 = 143

Shown with 4-bit operands so each step fits on one line. The pencil-and-paper form is:

```
          1 1 0 1      (13, multiplicand)
        x 1 0 1 1      (11, multiplier)
        ---------
          1 1 0 1      bit 0 = 1: add 1101
        1 1 0 1        bit 1 = 1: add 1101 shifted 1
      0 0 0 0          bit 2 = 0: add nothing
    1 1 0 1            bit 3 = 1: add 1101 shifted 3
  ---------------
  1 0 0 0 1 1 1 1      (143)
```

Table 5 shows how the hardware from Section 1.4 does the same job, one clock cycle per row,
with M = 1101 and Q starting as 1011.

**Table 5**

*Shift-and-Add Register Trace for 13 x 11*

| Step | Lowest bit of Q | Action | C, P after add | P after shift | Q after shift |
|---|---|---|---|---|---|
| Start | | | 0, 0000 | 0000 | 1011 |
| 1 | 1 | P = P + M | 0, 1101 | 0110 | 1101 |
| 2 | 1 | P = P + M | 1, 0011 | 1001 | 1110 |
| 3 | 0 | No add | 0, 1001 | 0100 | 1111 |
| 4 | 1 | P = P + M | 1, 0001 | 1000 | 1111 |

The final P and Q together read 1000 1111 = 143 (hexadecimal 8F), which matches the paper
calculation and the Logisim display in Figure 3.

### 3.7 Division: 13 / 3 = 4 Remainder 1

Dividend 1101 (13) and divisor 0011 (3), using restoring division:

**Table 6**

*Restoring Division Trace for 13 / 3*

| Step | Bit shifted in | Remainder after shift | Minus 3 | Negative? | Quotient bit | Remainder kept |
|---|---|---|---|---|---|---|
| 1 | 1 | 0001 (1) | -2 | Yes, restore | 0 | 0001 |
| 2 | 1 | 0011 (3) | 0 | No | 1 | 0000 |
| 3 | 0 | 0000 (0) | -3 | Yes, restore | 0 | 0000 |
| 4 | 1 | 0001 (1) | -2 | Yes, restore | 0 | 0001 |

Quotient = 0100 (4) and remainder = 0001 (1). Check: 3 x 4 + 1 = 13. Figure 4 shows the
prototype giving the same answer.

### 3.8 Decimal Mode (BCD Addition): 58 + 27 = 85

The BCD ADD opcode lets the calculator add decimal digits directly. In BCD, 58 = 0101 1000 and
27 = 0010 0111.

```
  Low digit:  1000 + 0111 = 1111   (15, more than 9, so add 0110)
              1111 + 0110 = 1 0101 -> digit 5, carry 1
  High digit: 0101 + 0010 + 1 = 1000 (8)
  Result:     1000 0101 = 85
```

The +6 correction is needed because 4 bits can count to 15 but a decimal digit stops at 9, so
six codes must be skipped (Ndjountche, 2016a).

### 3.9 Test Results From the Prototype

Table 7 lists the test cases run on the 4-bit Logisim prototype. Every result matched the
expected value, including the flag cases.

**Table 7**

*Prototype Test Cases and Results*

| Test | A | B | Opcode | Result | Display | Flags |
|---|---|---|---|---|---|---|
| 5 + 2 | 0101 | 0010 | 00 | 0000 0111 | 07 | none |
| 5 - 2 | 0101 | 0010 | 01 | 0000 0011 | 03 | none |
| 2 - 5 | 0010 | 0101 | 01 | 1111 1101 | FD (-3) | none |
| 7 + 1 | 0111 | 0001 | 00 | 1111 1000 | F8 | V = 1 (overflow) |
| 6 - 6 | 0110 | 0110 | 01 | 0000 0000 | 00 | Z = 1 (equal) |
| 13 x 11 | 1101 | 1011 | 10 | 1000 1111 | 8F (143) | none |
| 13 / 3 | 1101 | 0011 | 11 | 0001 0100 | 14 (r 1, q 4) | none |
| 13 / 0 | 1101 | 0000 | 11 | 0000 1101 | 0D | DIV0 = 1 (error) |

## 4. Advantages and Challenges of Binary Compared With Decimal Arithmetic

**Table 8**

*Binary and Decimal (BCD) Arithmetic Compared*

| Feature | Binary | Decimal (BCD) |
|---|---|---|
| Hardware | Two states per digit, small and reliable circuits | Needs +6 correction logic for every digit |
| Storage | Uses every code: 8 bits hold 256 values | Wastes codes: 8 bits hold only 100 values |
| Speed | One adder does add, subtract, and compare | Slower because of the correction step |
| Human use | Must be converted before display | Matches what people read and type |
| Fractions | Values like 0.1 repeat forever and are rounded | 0.1 and 0.01 are stored exactly |

### 4.1 Advantages

The main advantage of binary is how well it fits electronics. A circuit only has to tell two
voltage levels apart, which makes it cheap, fast, and resistant to noise, and the rules are
tiny: the whole addition table has four cases, which is why a full adder needs only five gates
(Learning Vibes, 2023; Ndjountche, 2016a). Two's complement adds a second advantage, since one
adder handles positive numbers, negative numbers, subtraction, and comparison, as the examples
in Section 3 show. Binary is also more compact. Eight bits hold 256 values in binary but only
100 in BCD, so BCD uses only about 39% of the codes available. Multiplication and division are
simpler as well, because each partial product is either the number or zero, which is what
makes the short shift-and-add loop in Table 5 possible. Finally, binary arithmetic is the
native language of every processor, so a binary calculator design can move straight into a
real CPU's arithmetic logic unit.

### 4.2 Challenges

The challenges come mostly from people and from fractions. Humans think in decimal, so the
calculator needs converters on the way in and on the way out, which adds circuits and time.
Long binary strings are hard to read and easy to copy wrongly, which is why engineers write
them in hexadecimal. The most serious problem is that many decimal fractions cannot be written
exactly in binary. The value 0.1 becomes 0.000110011... with the 0011 pattern repeating forever,
so it has to be rounded (Ndjountche, 2016a). This is the reason 0.1 + 0.2 does not exactly
equal 0.3 in most programming languages. For a competition calculator, that could produce
answers that differ from a contestant's hand calculation in the last digit. In commercial and
financial computing the effect is serious enough that researchers argued for decimal
floating-point arithmetic in hardware (Cowlishaw, 2003), and the IEEE 754 standard now defines
decimal formats alongside the binary ones (IEEE, 2019). A last challenge is the fixed word
size. An 8-bit calculator overflows past 127, so the design must detect overflow, and a real
product would use wider words.

Overall, binary is the right internal format because it gives the smallest and fastest
hardware, while the input and output converters and the BCD mode handle the decimal world that
contestants live in. The design uses the strengths of each system where they fit best.

## 5. Significance of the Calculator for Understanding Number Systems

Building this calculator turns number systems from rules to memorize into something that can be
seen working. When a student converts 45 into 00101101 by hand and then sees the same bits on
register A, place value in base 2 becomes real. Working through the subtraction example shows
why two's complement exists: it is not a trick, it is the representation that lets one adder do
two jobs. Watching the overflow flag catch 100 + 50, or the DIV0 flag catch a division by zero,
teaches that computer numbers have limits, a lesson many programmers only learn when their
software fails.

The design also shows how the four operations are connected. Subtraction is addition with an
inverted input, multiplication is repeated shifting and adding, and division is repeated
shifting and subtracting. Once students see in Tables 5 and 6 that the multiplier and divider
are loops around the same adder, they understand why the adder is the most important circuit
in a processor, and why engineers spend so much effort on faster carry logic (Ndjountche,
2016b). For a mathematics competition this also suggests a useful feature: a "show steps" mode
that displays registers P, Q, and the remainder after each clock cycle, so contestants can check
each stage of a long multiplication or division instead of trusting only the final number.

These ideas reach far beyond a classroom calculator:

- **Processors:** every CPU contains an arithmetic logic unit with the same structure, and the
  flags in this design are the ones processors use to decide branches in if-statements and
  loops (Harris & Harris, 2013). This links directly to the computer architecture and
  assembly language units later in this course.
- **Signal processing:** phones, hearing aids, and audio equipment run millions of
  multiply-and-add operations per second, which is the shift-and-add idea done in parallel.
- **Security:** encryption multiplies and divides very large binary integers, so fast
  multipliers and dividers directly affect how quickly a secure connection can be made.
- **Finance:** banks need exact decimal results, and the BCD mode here shows the exact
  problem that decimal hardware formats solve (Cowlishaw, 2003).
- **Artificial intelligence:** AI chips use short 8-bit and 16-bit number formats to save power,
  and choosing them well requires understanding precision and overflow, the same trade-offs
  this calculator makes visible.

For a computer science student, this project connects the number systems of Chapter 1 with the
arithmetic circuits of Chapter 4 and with the processors that will run every program they
write. That connection, from a single full adder to a working calculator, is the deeper
understanding the project is meant to build.

## Conclusion

The calculator is built around one idea: design a good adder and reuse it. With two's
complement, subtraction becomes addition, multiplication becomes shift-and-add, and division
becomes shift-and-subtract, all coordinated by a small control unit and a 3-bit opcode. The
worked examples and the Logisim prototype tests show that each operation gives correct results
and that the flags catch overflow and division by zero. Binary is the right internal format
because it fits hardware so well, while the converters and the BCD mode handle the decimal side
that people use.

## Academic Integrity Statement

This assignment is my own original work. The calculator design, the Logisim prototype, the
examples, and the explanations were produced by me, and ideas drawn from the course readings and
other sources are cited in APA style in the References section below.

## References

Booth, A. D. (1951). A signed binary multiplication technique. *The Quarterly Journal of
Mechanics and Applied Mathematics, 4*(2), 236-240. https://doi.org/10.1093/qjmam/4.2.236

Cowlishaw, M. F. (2003). Decimal floating-point: Algorism for computers. In *Proceedings of the
16th IEEE Symposium on Computer Arithmetic* (pp. 104-111). IEEE.
https://doi.org/10.1109/ARITH.2003.1207666

Harris, D. M., & Harris, S. L. (2013). *Digital design and computer architecture* (2nd ed.).
Morgan Kaufmann. https://doi.org/10.1016/C2011-0-04377-6

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
