# Unit 5 Learning Notes: Memory Hierarchy, ROM and RAM, Programmable Logic

Course: CS 1105 Digital Electronics & Computer Architecture
Readings: McClanahan (n.d.), Memory hierarchy (LibreTexts); Kumar (2025), Chapter 7(a) and 7(b);
Bandakkanavar (2023), Application and types of programmable logic devices (KrazyTech)
Videos: Watkins (2017), Memory hierarchy introduction; Curious Cat (2023), RAM and ROM

Due October 7, 2026: Discussion (post by **Sunday Oct 4**, 2 replies by **Wednesday Oct 7**),
Assignment Activity (PLD project), Self-Quiz.

---

## 1. The memory hierarchy

| Level | Technology | Speed | Size | Volatile? |
|---|---|---|---|---|
| Registers | flip-flops in the CPU | fastest | bytes | yes |
| L1, L2, L3 cache | SRAM | very fast | KB to MB | yes |
| Main memory (RAM) | DRAM | fast | GB | yes |
| Secondary storage | SSD (flash), HDD | slow | hundreds of GB to TB | no |

Going down: **bigger, cheaper per byte, slower**. The CPU works directly only with registers and
cache; data is copied up the hierarchy as it is needed.

**Why it works: locality**
- **Temporal locality:** data used recently will probably be used again soon (loop counters).
- **Spatial locality:** data near recently used data will probably be used next (array elements).

**Performance terms**
- **Hit:** data found in the cache. **Miss:** must fetch from a lower level.
- **Average access time = hit time + miss rate × miss penalty.**
- Cache lines (blocks), associativity (direct-mapped, set-associative, fully associative),
  replacement (eviction) policies like LRU, and addresses split into **tag, index, offset**.

## 2. RAM vs ROM

| | RAM | ROM |
|---|---|---|
| Read/write | read and write | read only (or rarely rewritten) |
| Volatile | yes, loses data without power | no, keeps data |
| Use | running programs and their data | boot firmware (BIOS/UEFI), fixed tables |
| Types | SRAM (fast, used for cache), DRAM (dense, main memory) | Mask ROM, PROM (program once), EPROM (UV erase), EEPROM and flash (electrical erase) |

## 3. Programmable Logic Devices (PLDs)

A chip whose logic function is set by **programming**, not by its wiring.

| Family | Structure | Notes |
|---|---|---|
| **PROM** | fixed AND (decoder), **programmable OR** | stores a full truth table; any function of its inputs |
| **PAL / GAL** | **programmable AND**, fixed OR | fast, common in glue logic; GAL is reprogrammable |
| **PLA** | **programmable AND and OR** | most flexible SPLD, slower |
| **CPLD** | many PAL-like blocks + interconnect | control logic, state machines |
| **FPGA** | thousands of lookup-table logic blocks + flip-flops + routing | large designs, prototyping, DSP |

**Why PLDs matter:** fewer chips, reprogrammable (field updates), fast prototyping, ideal for
state machines. Trade-off: more power and cost per unit than a custom chip (ASIC) at high volume.

---

## Self-Quiz answers

| # | Question | Answer |
|---|---|---|
| 1 | Secondary memory keeps data after power off | **True** |
| 2 | Memory for multimedia files, apps, documents | **Secondary memory** |
| 3 | Cache stores frequently used instructions and data for the CPU | **True** |
| 4 | Memory holding boot-up instructions | **ROM (Read-Only Memory)** |
| 5 | Bridge between CPU and main memory for faster access | **Cache memory** |

## References

Bandakkanavar, R. (2023, March 9). *Application and types of programmable logic devices*.
KrazyTech. https://krazytech.com/technical-papers/programmable-logic-devices-pld

McClanahan, P. (n.d.). *5.1: Memory hierarchy*. In *Introduction to operating systems*.
LibreTexts. https://eng.libretexts.org/Courses/Delta_College/Introduction_to_Operating_Systems/05:_Computer_Architecture_-_Memory/5.01:_Memory_Hierarchy

Watkins, M. (2017, March 29). *Memory hierarchy introduction* [Video]. YouTube.
https://www.youtube.com/watch?v=_kZY4orPQW0
