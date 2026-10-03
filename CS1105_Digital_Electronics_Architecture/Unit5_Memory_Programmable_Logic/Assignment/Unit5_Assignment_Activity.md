# A Digital Combination Lock Built Around a Programmable Logic Device

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** October 7, 2026

For this project I designed a digital combination lock in Logisim. The user enters a three-digit
code one digit at a time, and the door opens only when all three digits are correct and in the
right order. Three wrong digits set off an alarm and lock the keypad until an administrator
resets it. The heart of the design is a programmable logic device (PLD): a 128 × 4 programmable
read-only memory (PROM) that holds the lock's complete decision table. Around it sit a small state
register, a failed-attempt counter, a few gates, and a simple user interface of buttons, lights,
and displays. This paper explains the design, describes every component, shows how the PLD
improves the circuit, and explains why PLDs are valuable in digital design.

## 1. Design of the Digital Circuit Project

### 1.1 Requirements

The lock was designed to meet the requirements in Table 1.

**Table 1**

*Design Requirements for the Combination Lock*

| # | Requirement | How the design meets it |
|---|---|---|
| R1 | Accept a 3-digit code entered one digit at a time | 4-bit digit input plus an ENTER button |
| R2 | Open only for the correct sequence 7, 3, 9 | State machine that advances only on the right digit |
| R3 | A wrong digit restarts the sequence | PLD sends the state back to the start |
| R4 | Three wrong digits trigger an alarm and lock out the keypad | Failed-attempt counter plus a lockout input to the PLD |
| R5 | The user can relock the door at any time | LOCK button clears the state register |
| R6 | Only an administrator can clear the alarm | Separate ADMIN RESET button clears the counter |
| R7 | The code can be changed without rewiring | Code stored in the PLD's programmable contents |

### 1.2 The Lock as a State Machine

A combination lock has to remember how much of the code has been entered correctly, so it is a
sequential circuit: its output depends on the current input and on its stored state (Ndjountche,
2016). I modeled it as a finite state machine with four states, stored in two flip-flops:

| State | Meaning | Progress display |
|---|---|---|
| S0 (00) | Waiting for the first digit | 0 |
| S1 (01) | First digit (7) correct | 1 |
| S2 (10) | First two digits (7, 3) correct | 2 |
| S3 (11) | All three digits correct, door open | 3 |

Each press of ENTER is one clock pulse. On that pulse the machine moves to the next state if the
digit is right, or back to S0 if it is wrong. Once in S3 the door stays open until the LOCK button
is pressed. A separate rule overrides everything: while the alarm is active, every entry is
ignored and the state is held at S0.

```
          7            3            9
   S0 --------> S1 --------> S2 --------> S3  (DOOR OPEN)
   ^ |  wrong    |  wrong     |  wrong     |
   | +----<------+-----<------+            |  any digit: stay in S3
   |                                       |
   +------------------ LOCK ---------------+

   3 wrong digits in a row: ALARM on, keypad ignored until ADMIN RESET
```

### 1.3 Block Diagram

```
 KEYPAD DIGIT (4 bits) --+
                         |
 STATE (2 bits) ---------+--> [ PLD: 128 x 4 PROM ] --> NEXT STATE (2) --> [ STATE REGISTER ]
                         |     address = 7 bits          UNLOCK (1)  -----> DOOR OPEN light
 ALARM (1 bit) ----------+     data    = 4 bits          WRONG (1)   -----> [ ATTEMPT COUNTER ]
                                                                                |
 ENTER button  --> clock of state register and attempt counter                 v
 LOCK button   --> clears the state register                 [ = 3 ? ] --> ALARM light
 ADMIN RESET   --> clears the state register and the counter          (and back into the PLD)
```

The design follows a standard pattern: one block of combinational logic (the PLD) computes the
next state and the outputs, and a register stores the state between clock pulses (Harris &
Harris, 2013). Putting all of the decision logic in one programmable block, rather than spreading
it across many gates, is what makes the design efficient and easy to change.

### 1.4 The Logisim Circuit

Figure 1 shows the complete circuit in Logisim. The blocks are laid out left to right in the order
signals flow: the keypad and buttons, the PLD, the state register and counter, the reset and alarm
logic, and the outputs. Named tunnels connect the blocks, so each block can be read on its own.

**Figure 1**

*The Complete Combination Lock Circuit in Logisim*

[FIGURE figures/fig1_lock_overview.png]

### 1.5 Testing

I tested the design in two ways. First, I checked all 256 combinations of the current state, the
number of failed tries, and the digit, and confirmed that the PLD produced the correct next state,
UNLOCK, and WRONG signals every time. Second, I ran whole entry sequences through the working
circuit with real flip-flops. Table 2 shows the results.

**Table 2**

*Test Sequences and Results*

| Test | Digits entered | Progress after each digit | Failed tries | Result |
|---|---|---|---|---|
| Correct code | 7, 3, 9 | 1, 2, 3 | 0 | DOOR OPEN lights |
| One slip | 7, 5, 7, 3, 9 | 1, 0, 1, 2, 3 | 1, then cleared on opening | DOOR OPEN lights |
| Three wrong | 1, 2, 4, then 7, 3, 9 | 0, 0, 0, then held at 0 | 1, 2, 3 | ALARM lights; the correct code is ignored |
| Relock | press LOCK when open | 0 | 0 | Door closes |
| Admin reset | press ADMIN RESET during alarm | 0 | 0 | Alarm clears, keypad works again |

Figures 2 and 3 show the two most important outcomes: the door opening after the correct code,
and the alarm locking the keypad after three wrong digits.

**Figure 2**

*Door Open After Entering 7, 3, 9 (Progress Display Shows 3)*

[FIGURE figures/fig2_unlocked.png]

**Figure 3**

*Alarm Active After Three Wrong Digits (Wrong Tries Display Shows 3)*

[FIGURE figures/fig3_alarm.png]

## 2. Key Components and Their Functions

Table 3 lists every component in the circuit and the job it does.

**Table 3**

*Components of the Combination Lock*

| Component | Type | Function in the circuit |
|---|---|---|
| DIGIT input | 4-bit input pin | The keypad: the digit 0 to 9 the user is entering |
| ENTER button | Push button | Submits the digit; its press is the clock pulse for the state register and counter |
| LOCK button | Push button | Relocks the door by clearing the state register to S0 |
| ADMIN RESET button | Push button | Clears both the state register and the attempt counter, ending an alarm |
| Address splitter | Splitter | Joins DIGIT (4 bits), STATE (2 bits), and ALARM (1 bit) into the PLD's 7-bit address |
| LOCK PLD | 128 × 4 PROM | Holds the lock's truth table and outputs NEXT STATE, UNLOCK, and WRONG |
| Data splitter | Splitter | Separates the PLD's 4-bit output into its three signals |
| State register | 2-bit register (2 D flip-flops) | Stores the current state between button presses |
| Attempt counter | 2-bit counter, stops at 3 | Counts wrong digits; counts only when WRONG is 1 |
| Comparator | 2-bit equality check | Raises ALARM when the counter reaches 3 |
| Reset OR gates | 2 OR gates | CLEAR STATE = LOCK or ADMIN; CLEAR TRIES = ADMIN or UNLOCK |
| DOOR OPEN and ALARM lights | LEDs | Show the lock's result to the user |
| Hex displays | 3 hex digit displays | Show the digit entered, the progress (0 to 3), and the failed tries |
| Bit extenders | 2-bit to 4-bit | Widen STATE and TRIES so the hex displays can show them |
| Tunnels | Named connectors | Carry signals between blocks without crossing wires |

A few of these choices deserve explanation.

**The state register** is two D flip-flops sharing one clock. On each rising edge of ENTER they
copy the NEXT STATE value from the PLD, then hold it steady until the next press. Because the PLD's
output only matters at that edge, the lock ignores any changes to the digit switches between
presses, which is exactly how a keypad should behave.

**The attempt counter** only counts when the PLD's WRONG output is 1 at the moment ENTER is
pressed, and it is set to stop at 3 rather than wrap back to 0, so an attacker cannot clear the
alarm by entering a fourth wrong digit. It is cleared automatically when the door opens, so
earlier mistakes do not count against a user who then enters the code correctly.

**The reset logic** separates two kinds of reset. LOCK only clears the state, so any user can
close the door but cannot clear the alarm. Clearing the alarm needs ADMIN RESET. This separation
is a simple security feature built from just two OR gates.

## 3. PLD Integration and How It Enhances the Circuit

### 3.1 How a PROM Works as a PLD

A PROM is one of the simplest programmable logic devices. Inside, it has two parts: a fixed AND
array, which is the address decoder, and a programmable OR array, which is the stored data (Harris
& Harris, 2013). The decoder takes the 7 address bits and activates exactly one of 128 lines, one
for every possible combination of inputs, so each line is a minterm. The programmable OR array
then decides which of those minterms switch each output bit on. In other words, the PROM stores
a complete truth table and can implement any combinational function of its inputs, which is why
memory arrays are often used as lookup tables for logic (Harris & Harris, 2013).

In this lock, the PLD's 7 inputs are ALARM, the 2 STATE bits, and the 4 DIGIT bits, and its 4
outputs are WRONG, UNLOCK, and the 2 NEXT STATE bits. Table 4 shows part of its program.

**Table 4**

*Part of the PLD Program*

| Address (binary) | ALARM | STATE | DIGIT | Data (WRONG, UNLOCK, NEXT) | Meaning |
|---|---|---|---|---|---|
| 0 00 0111 | 0 | S0 | 7 | 0 0 01 | Right first digit, go to S1 |
| 0 00 0000 | 0 | S0 | 0 | 1 0 00 | Wrong digit, stay at S0, count a try |
| 0 01 0011 | 0 | S1 | 3 | 0 0 10 | Right second digit, go to S2 |
| 0 01 0101 | 0 | S1 | 5 | 1 0 00 | Wrong digit, back to S0, count a try |
| 0 10 1001 | 0 | S2 | 9 | 0 0 11 | Right third digit, go to S3 |
| 0 11 xxxx | 0 | S3 | any | 0 1 11 | Door open, stay open |
| 1 xx xxxx | 1 | any | any | 0 0 00 | Alarm: ignore every entry |

All 128 words were generated from these rules and loaded into the PROM. Half of them, every
address with ALARM = 1, are simply zero, which is how the lockout feature is built.

### 3.2 How the PLD Enhances the Circuit

**It replaces a large tangle of gates with one part.** Without the PLD, the lock would need a
4-bit equality comparator for each of the three code digits, a multiplexer to choose which
comparison applies in each state, next-state logic for both flip-flops, and extra gating for the
alarm and the open state. That is roughly 30 gates plus a multiplexer, with many wires, each a chance for a
wiring mistake. The PLD does all of it in one component with one level of lookup delay, so the timing is
the same no matter how complicated the rules are.

Table 5 compares the two approaches for the decision logic alone.

**Table 5**

*Decision Logic Built From Discrete Gates Compared With the PLD*

| Function | Discrete gates (approximate) | With the PLD |
|---|---|---|
| Compare the digit with 7, 3, and 9 | 3 four-bit comparators: 12 XNOR + 3 AND gates | stored in the table |
| Pick the comparison for the current state | 1 four-input multiplexer | stored in the table |
| Next-state logic for 2 flip-flops | about 6 to 8 gates | stored in the table |
| UNLOCK, WRONG, and lockout gating | about 5 gates | stored in the table |
| **Total** | **about 30 gates and 1 multiplexer, many wires** | **1 PROM, 2 splitters** |

**The code can be changed without touching the hardware.** To change the combination from 7-3-9
to, for example, 2-5-8, the only step is reprogramming the PROM with a new table. In Logisim this
means loading a new contents file into the ROM. In a fixed-gate design the comparators would have
to be rewired. This is the core strength of programmable logic: the function lives in the
programming, not in the wiring (Bandakkanavar, 2023).

**New features cost almost nothing.** The keypad lockout needed no extra gates. I simply connected
the ALARM signal to one more address line and programmed every word in that half of the PROM to
zero. Other rules could be added the same way, for example a duress code that opens the door but
also raises a silent alarm, by programming one more output bit.

**It is easy to verify.** Because the whole behavior is one table, it can be checked line by line.
That is how I was able to test all 256 combinations of state, tries, and digit before testing full
sequences.

### 3.3 Moving to a Real Chip

In Logisim the PLD is a ROM, but the same design maps directly onto real devices. A registered PAL
or GAL chip could hold both the next-state logic and the two state flip-flops in one package, and
a CPLD could add the counter and alarm logic too. State machines like this lock are one of the
most common uses of PLDs (Bandakkanavar, 2023). For a larger keypad or a longer code, an FPGA would
handle the extra states and inputs without changing the design approach.

## 4. Why PLDs Are Valuable Tools in Digital Circuit Design

PLDs sit between fixed-function chips and fully custom chips. A designer gets custom logic without
paying to manufacture a custom chip, and gets far more flexibility than a board full of standard
gates. Bandakkanavar (2023) groups them into three families, each suited to a different scale:

- **Simple PLDs (PROMs, PALs, PLAs)** replace a handful of gate chips with one part, as in this
  lock's decision logic.
- **CPLDs** combine many simple blocks and suit control tasks such as bus interfaces, power-up
  sequencing on motherboards, and state machines.
- **FPGAs** contain thousands of programmable logic blocks and are used for large jobs, such as
  signal processing in network equipment, prototyping new processor designs before they are made
  as chips, and hardware accelerators.

Their value comes from four advantages:

1. **Flexibility and field updates.** The same hardware can be reprogrammed to fix a bug or add a
   feature after a product has shipped, which is impossible with fixed logic (Bandakkanavar,
   2023).
2. **Fewer parts.** One PLD can replace many logic chips, which saves board space, power, and
   assembly cost, and removes many possible wiring faults.
3. **Faster development.** A design can be simulated, programmed, tested, and changed in hours,
   as I did with the lock, instead of waiting weeks for new boards.
4. **Lower risk.** Teams can prove a design on a PLD or FPGA before committing to an expensive
   custom chip.

PLDs do have trade-offs. Per unit, they cost more than a custom chip when millions are made, and
their programmable connections use more power and run slower than fixed wiring. For low and medium
volumes, prototypes, and any product that may need to change, however, PLDs are usually the better
choice, which is why they appear everywhere from simple controllers like this lock to the largest
networking systems.

## Conclusion

The combination lock shows how a PLD turns a design problem into a programming problem. Instead
of wiring dozens of gates to compare digits and decide the next state, the lock stores its entire
behavior as a 128-entry table in a PROM. That made the circuit smaller and easier to test, let me
add a keypad lockout at no hardware cost, and means the code can be changed by reprogramming
instead of rewiring. Those same strengths, scaled up from a PROM to CPLDs and FPGAs, are what make
programmable logic one of the most useful tools in digital design.

## References

Bandakkanavar, R. (2023, March 9). *Application and types of programmable logic devices*.
KrazyTech. https://krazytech.com/technical-papers/programmable-logic-devices-pld

Harris, D. M., & Harris, S. L. (2013). *Digital design and computer architecture* (2nd ed.).
Morgan Kaufmann. https://doi.org/10.1016/C2011-0-04377-6

Ndjountche, T. (2016). *Digital electronics 2: Sequential and arithmetic logic circuits*. ISTE;
John Wiley & Sons. https://doi.org/10.1002/9781119329756
