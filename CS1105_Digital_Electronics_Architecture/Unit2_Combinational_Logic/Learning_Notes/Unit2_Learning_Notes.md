# Unit 2 Learning Notes: Combinational Logic & Function Blocks

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili

> My own notes from the Unit 2 reading (Ndjountche, 2016) and videos. Sources cited at the end.

---

## 1. Combinational vs. Sequential

- **Combinational:** output depends ONLY on current inputs; no memory, no clock. Built from
  logic gates. Same inputs → same outputs, always.
- **Sequential:** output depends on current inputs AND stored past state (memory via
  flip-flops/latches), usually clocked.

---

## 2. Function Blocks (the key components)

| Block | Inputs → Outputs | What it does |
|-------|------------------|--------------|
| **Multiplexer (MUX)** | 2ⁿ data + n select → 1 output | Selects ONE of many inputs (data selector) |
| **Demultiplexer (DEMUX)** | 1 data + n select → 2ⁿ outputs | Routes one input to ONE of many outputs |
| **Decoder** | n inputs → 2ⁿ outputs | Activates one output line per input code (one-hot) |
| **Encoder** | 2ⁿ inputs → n outputs | Compresses many lines into a binary code |
| **Transcoder** | code → different code | Converts one code to another (e.g., BCD→7-seg) |

**Key relationships to memorize:**
- MUX: n select lines → 2ⁿ data inputs (4-to-1 needs 2 select; 8-to-1 needs 3; 16-to-1 needs 4)
- Decoder: n inputs → 2ⁿ outputs (3-to-8 decoder: 3 in, 8 out)
- Encoder is the reverse of a decoder; DEMUX is the reverse of a MUX.

---

## 3. Universal gates

- **NAND** and **NOR** are universal — any function can be built from only NANDs or only NORs.
- Example: a 2-input AND = a NAND followed by a NAND used as an inverter (two NANDs).

---

## 4. Karnaugh Maps (K-maps) — simplification

- A visual tool to minimize Boolean expressions (Ndjountche, 2016).
- Number of cells = 2^(number of variables): 2 vars → 4 cells, 3 vars → 8, **4 vars → 16**.
- Group adjacent 1s in powers of 2 (1, 2, 4, 8...) to eliminate variables and get the
  simplest sum-of-products.

---

## 5. Other blocks

- **Parity check generator:** adds/checks a parity bit for error detection in transmitted data.
- **Barrel shifter:** shifts/rotates binary data by multiple positions in one step; used in
  arithmetic and data manipulation.

---

## 6. Connection to Unit 2 work

- **Discussion:** combinational (no memory) vs sequential (memory); elevator safety
  interlocks are combinational for instant, predictable response.
- **Assignment:** security system = encoder (compress keypad) → MUX (pick room code) →
  XNOR/AND comparator (grant/deny) → decoder/DEMUX (route unlock to one room).

---

## Self-check (Unit 2 outcomes)
1. Can I explain combinational circuits and their applications? ✅
2. Can I design combinational circuits using logic gates and function blocks? ✅

---

## Reference

Ndjountche, T. (2016). *Digital electronics 1: Combinational logic circuits*. John Wiley &
Sons. https://ebookcentral.proquest.com/
