# Unit 1: Introduction to Computer Systems - Part 2: Von Neumann Architecture & Memory

## 1. Von Neumann Computer System Architecture

### What is Von Neumann Architecture?

The **Von Neumann Architecture** is a computer design model proposed by John von Neumann in 1945. It forms the basis of most modern computers.

**Key Innovation:** The **stored-program concept** - both data and instructions are stored in the same memory.

---

### Core Principles

**1. Stored-Program Concept:**
- Programs stored in memory (not hardwired)
- Instructions and data share same memory space
- Programs can be easily changed
- Computer can modify its own instructions

**2. Sequential Execution:**
- Instructions executed one at a time
- Fetch-decode-execute cycle
- Program counter tracks next instruction

---

### Components of Von Neumann Architecture

```
┌────────────────────────────────────────────┐
│         VON NEUMANN ARCHITECTURE           │
│                                            │
│  ┌──────────┐         ┌──────────┐       │
│  │  INPUT   │────────▶│  MEMORY  │       │
│  │  UNIT    │         │ (Unified) │       │
│  └──────────┘         │          │       │
│                       │ Data +   │       │
│                       │ Programs │       │
│                       └─────┬────┘       │
│                             │            │
│                             ↕            │
│                    ┌────────────────┐   │
│                    │      CPU       │   │
│                    │  ┌──────────┐  │   │
│                    │  │   ALU    │  │   │
│                    │  └──────────┘  │   │
│                    │  ┌──────────┐  │   │
│                    │  │ Control  │  │   │
│                    │  │   Unit   │  │   │
│                    │  └──────────┘  │   │
│                    │  ┌──────────┐  │   │
│                    │  │Registers │  │   │
│                    │  └──────────┘  │   │
│                    └────────┬───────┘   │
│                             │            │
│                             ↓            │
│                      ┌──────────┐       │
│                      │  OUTPUT  │       │
│                      │   UNIT   │       │
│                      └──────────┘       │
└────────────────────────────────────────────┘
```

### Key Components:

**1. Central Processing Unit (CPU):**
- **ALU:** Performs calculations
- **Control Unit:** Manages operations
- **Registers:** Fast temporary storage

**2. Memory (Unified):**
- Stores both instructions and data
- Single address space
- Random access

**3. Input/Output:**
- Communication with external world
- Separate from CPU and memory

**4. Bus System:**
- **Data Bus:** Transfers data
- **Address Bus:** Specifies memory locations
- **Control Bus:** Carries control signals

---

### Fetch-Decode-Execute Cycle

The CPU continuously repeats this cycle:

**1. FETCH:**
- Control Unit fetches instruction from memory
- Program Counter (PC) holds address of next instruction
- Instruction loaded into Instruction Register (IR)
- PC incremented to point to next instruction

**2. DECODE:**
- Control Unit decodes instruction
- Determines what operation to perform
- Identifies required operands

**3. EXECUTE:**
- ALU performs operation
- Results stored in register or memory
- Flags updated (zero, carry, overflow, etc.)

**4. STORE (if needed):**
- Results written back to memory
- Update memory or registers

**Example:**
```
Instruction: ADD R1, R2, R3  (R1 = R2 + R3)

1. FETCH: Get instruction from memory address in PC
2. DECODE: Identify as ADD operation, operands R2, R3, destination R1
3. EXECUTE: ALU adds values in R2 and R3
4. STORE: Result placed in R1
```

---

### Significance of Stored-Program Concept

**Before Von Neumann:**
- Computers were hardwired for specific tasks
- Changing program required physical rewiring
- Time-consuming and inflexible

**After Von Neumann:**
- Programs stored in memory like data
- Easy to change programs (just load new one)
- Same hardware runs different programs
- Foundation for modern computing

**Impact:**
- **Flexibility:** One computer, many tasks
- **Programmability:** Software development possible
- **Efficiency:** Quick program changes
- **Universality:** General-purpose computers

---

### Von Neumann Bottleneck

**Problem:**
- CPU and memory connected by single bus
- Only one instruction or data transfer at a time
- CPU often waits for memory access
- Limits performance

**Solutions:**
- Cache memory (faster intermediate storage)
- Pipelining (overlap instruction execution)
- Multiple cores (parallel processing)
- Harvard Architecture (separate instruction and data memory)

---

## 2. Computer Memory

Memory is where computer stores data and instructions. Two main types: **Primary** and **Secondary**.

---

### A. Primary Memory (Main Memory)

**Characteristics:**
- Directly accessible by CPU
- Fast access speed
- Volatile (most types lose data when power off)
- Limited capacity
- Expensive per byte

---

#### 1. RAM (Random Access Memory)

**Definition:** Temporary, volatile memory for active programs and data.

**Characteristics:**
- **Volatile:** Loses data when power off
- **Random Access:** Any location accessed directly
- **Read/Write:** Can read and write data
- **Fast:** Nanosecond access times
- **Temporary:** Holds current work

**Types:**

**a. DRAM (Dynamic RAM):**
- Needs constant refreshing
- Slower than SRAM
- Less expensive
- Higher density (more storage)
- Used for main system memory

**b. SRAM (Static RAM):**
- No refreshing needed
- Faster than DRAM
- More expensive
- Lower density
- Used for cache memory

**Uses:**
- Running programs
- Open documents
- Operating system
- Temporary calculations

**Example:**
When you open Word document:
1. Program loaded from hard drive to RAM
2. Document loaded to RAM
3. Edits made in RAM
4. Save writes from RAM to hard drive

---

#### 2. ROM (Read-Only Memory)

**Definition:** Permanent, non-volatile memory with pre-written data.

**Characteristics:**
- **Non-volatile:** Retains data when power off
- **Read-Only:** Cannot be easily modified
- **Permanent:** Data written during manufacturing
- **Stores:** Firmware, BIOS, boot instructions

**Types:**

**a. PROM (Programmable ROM):**
- Programmed once after manufacturing
- Cannot be erased

**b. EPROM (Erasable PROM):**
- Can be erased with UV light
- Reprogrammable

**c. EEPROM (Electrically Erasable PROM):**
- Erased electrically
- Byte-by-byte erasure
- Used in BIOS chips

**d. Flash Memory:**
- Type of EEPROM
- Block erasure (faster)
- Used in USB drives, SSDs, memory cards

**Uses:**
- BIOS (Basic Input/Output System)
- Firmware in devices
- Boot instructions
- Embedded systems

---

#### 3. Cache Memory

**Definition:** Very fast memory between CPU and RAM.

**Purpose:**
- Speed up memory access
- Store frequently used data/instructions
- Reduce CPU wait time

**Levels:**
- **L1 Cache:** Smallest, fastest, inside CPU
- **L2 Cache:** Larger, slightly slower, near CPU
- **L3 Cache:** Largest, shared among cores

**How it Works:**
1. CPU needs data
2. Checks L1 cache first (fastest)
3. If not found, checks L2, then L3
4. If still not found, fetches from RAM (slowest)

---

### Memory Hierarchy

```
┌─────────────────────────────────────┐
│         CPU REGISTERS               │  Fastest
│         (Bytes)                     │  Smallest
├─────────────────────────────────────┤  Most Expensive
│         L1 CACHE                    │
│         (KB)                        │
├─────────────────────────────────────┤
│         L2 CACHE                    │
│         (KB-MB)                     │
├─────────────────────────────────────┤
│         L3 CACHE                    │
│         (MB)                        │
├─────────────────────────────────────┤
│         RAM                         │
│         (GB)                        │
├─────────────────────────────────────┤
│         SECONDARY STORAGE           │
│         (TB)                        │  Slowest
│         (HDD, SSD)                  │  Largest
└─────────────────────────────────────┘  Least Expensive
```

---

### Units of Memory Measurement

| Unit | Symbol | Size | Equivalent |
|------|--------|------|------------|
| **Bit** | b | 1 binary digit | 0 or 1 |
| **Byte** | B | 8 bits | 1 character |
| **Kilobyte** | KB | 1,024 bytes | ~1 thousand bytes |
| **Megabyte** | MB | 1,024 KB | ~1 million bytes |
| **Gigabyte** | GB | 1,024 MB | ~1 billion bytes |
| **Terabyte** | TB | 1,024 GB | ~1 trillion bytes |
| **Petabyte** | PB | 1,024 TB | ~1 quadrillion bytes |

**Examples:**
- Text character: 1 byte
- Page of text: ~2 KB
- Photo: 2-5 MB
- Song (MP3): 3-5 MB
- Movie (HD): 4-8 GB
- Hard drive: 500 GB - 2 TB

---

### RAM vs. ROM Comparison

| Feature | RAM | ROM |
|---------|-----|-----|
| **Volatility** | Volatile (loses data) | Non-volatile (retains data) |
| **Access** | Read/Write | Read-only (mostly) |
| **Speed** | Fast | Slower than RAM |
| **Cost** | More expensive | Less expensive |
| **Capacity** | GB (4-64 GB typical) | MB (few MB typical) |
| **Purpose** | Temporary storage | Permanent storage |
| **Content** | Programs, data | Firmware, BIOS |
| **Modifiable** | Easily changed | Difficult to change |

---

## Key Takeaways

1. **Von Neumann Architecture:** Stored-program concept, unified memory for data and instructions
2. **Fetch-Decode-Execute Cycle:** How CPU processes instructions
3. **Significance:** Enabled programmable, general-purpose computers
4. **Von Neumann Bottleneck:** Single bus limits performance
5. **Primary Memory:** RAM (volatile, fast, temporary) and ROM (non-volatile, permanent)
6. **Memory Hierarchy:** Registers → Cache → RAM → Secondary Storage (speed vs. capacity trade-off)
7. **Units:** Bit → Byte → KB → MB → GB → TB

---

## Essential Questions

1. **What is the significance of the stored-program concept?**
   - Programs stored in memory like data
   - Easy to change programs without hardware changes
   - Foundation for modern programmable computers
   - Enables software development

2. **How does Von Neumann architecture affect computer decisions?**
   - Understand CPU-memory bottleneck
   - Importance of RAM capacity
   - Cache memory for performance
   - Balance between processing power and memory

---

## References

Bawden, D., & Robinson, L. (2022). *Introduction to information science*. Facet Publishing.

Gupta, C. P., & Goyal, K. K. (2020). *Computer concepts and management information systems*. Mercury Learning & Information.

Neso Academy. (2025). *Von Neumann architecture* [Video]. YouTube. https://www.youtube.com/watch?v=example

MIT OpenCourseWare. (2019b, July 12). *9.2.3 The von Neumann model* [Video]. YouTube. https://www.youtube.com/watch?v=example

Club Academia. (2024, October 22). *RAM, ROM, cache & more: Understanding computer memory!* [Video]. YouTube. https://www.youtube.com/watch?v=example
