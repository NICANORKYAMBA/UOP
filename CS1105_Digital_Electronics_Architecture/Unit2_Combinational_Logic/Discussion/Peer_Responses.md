# Unit 2 Discussion — Peer Responses

Author: Nicanor Maswili
Course: CS 1105 Digital Electronics & Computer Architecture

You need to post **2** replies. Three drafts are provided below so you can choose the two
that fit best. Each is substantive, engages with the classmate's specific points, adds a
technical idea, and ends with a question.

---

## Peer Response 1 — to Nankya Joyce Sanyu

Hi Joyce,

I enjoyed your post, especially the way you separated the "instant" safety decisions from the
functions that need memory. Your example of an AND gate that only lets the motor run when the
door is closed and the car is not overloaded is a clean illustration of a combinational safety
interlock, and it matches the point that combinational output depends only on the present
inputs (Ndjountche, 2016).

One idea I would add to your AI section: the concern you raise about safety can be handled by
keeping the safety interlock in fixed gate logic that the AI cannot override. In practice this
is often done by wiring the safety condition as a hardware enable, so the AI can request a
move but the move only happens when the combinational interlock also agrees. That way the AI
optimizes convenience while the deterministic logic still holds the final veto, which lines up
with the layered "combinational logic plus memory" structure you cited from MIT OpenCourseWare
(2017).

Your traffic-light example is a good second case too. To answer your closing question, I would
implement door, overload, and floor-request-present checks in combinational logic for speed,
and put the queue of pending floor requests, the car's current position, and direction memory
in sequential logic, since those all depend on past events. How would you handle a situation
where two safety conditions momentarily disagree because of propagation delay before the
signals settle?

Best,
Nicanor

Reference:
MIT OpenCourseWare. (2017). *Computation structures: Annotated slides—Sequential logic*.
Massachusetts Institute of Technology.

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley &
Sons.

---

## Peer Response 2 — to Daniel Sang

Hi Daniel,

Your explanation of the memory distinction is very clear, and I like that you grounded the
gate examples (AND for motor-enable, OR for combining floor buttons, NOT for an unmet
condition) in Ndjountche (2016). Your point that a real elevator needs sequential logic to
remember floor, direction, and movement status is exactly the balance the unit is pointing at.

To build on your traffic-light example, I think the multiplexers and decoders you mentioned
are what make that system scale. If several intersections feed a central controller, a
multiplexer can select which intersection's sensor bundle is being evaluated at a given
moment, and a decoder can activate the correct signal head once the decision is made. That
keeps one decision circuit shared across many intersections rather than duplicating logic for
each, which is the same efficiency argument for using a decoder or demultiplexer in a
multi-room access system (Mano & Ciletti, 2018).

On your concern about AI overriding safety: I agree the hardware safety controls should be
independent. One concrete way to enforce that is to feed the safety signal into the enable
input of the output stage, so a granted decision is physically blocked whenever the safety
condition is false. To answer your question about other everyday systems, I would point to
automated parking gates and vending machines, both of which use gate logic plus a
selector to route one decision to the right actuator. In your traffic design, would you let
the emergency-vehicle input force a phase immediately, or still route it through the normal
priority logic?

Best,
Nicanor

Reference:
Mano, M. M., & Ciletti, M. D. (2018). *Digital design: With an introduction to the Verilog
HDL, VHDL, and SystemVerilog* (6th ed.). Pearson.

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley &
Sons.

---

## Peer Response 3 — to Daniel Daystar

Hi Daniel,

Your industrial machine-safety example is a strong choice, and I like that you tied it to
propagation delays and hazards from the reading. The AND-gate condition you described (guard
closed, emergency stop not active, authorized operator present) is a textbook combinational
interlock, and raising the hazard issue shows you are thinking past the ideal truth table into
how the circuit actually behaves when signals arrive at slightly different times (Ndjountche,
2016).

I would add that the hazard concern is a good reason to keep the safety interlock purely
combinational and shallow (few gate levels), so it settles quickly and predictably, while the
sequencing and timing that can tolerate a clock edge go into sequential logic. Your reference
to Karnaugh-map simplification connects here as well: a simpler expression usually means fewer
gate levels, which reduces both cost and the worst-case propagation delay before the safety
output is valid.

To answer your closing question about combining the two circuit types for a safer and faster
elevator, I would use combinational logic for the immediate go/no-go interlocks (door,
overload, obstruction) and sequential logic for the request queue and position tracking, then
gate the sequential controller's "move" command through the combinational interlock so the
memory-based logic can never bypass a live safety condition. How many gate levels do you think
is acceptable for a safety interlock before the propagation delay becomes a real design
concern?

Best,
Nicanor

Reference:
Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley &
Sons. https://ebookcentral.proquest.com/lib/univ-people-ebooks/detail.action?docID=4560567
