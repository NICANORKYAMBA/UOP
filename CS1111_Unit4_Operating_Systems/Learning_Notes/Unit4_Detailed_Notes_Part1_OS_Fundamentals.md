# Unit 4 Learning Notes - Part 1: Operating Systems Fundamentals

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 4 - Operating Systems
- **Topic**: OS Introduction, Functions, and Process Management
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [Introduction to Operating Systems](#introduction-to-operating-systems)
2. [Core Functions of Operating Systems](#core-functions-of-operating-systems)
3. [Process Management](#process-management)
4. [Memory Management](#memory-management)

---

## Introduction to Operating Systems

### What is an Operating System?

An **Operating System (OS)** is system software that acts as an intermediary between computer hardware and application software, managing resources and providing services.

**Key Definition**: The OS is the most important software that runs on a computer, managing memory, processes, devices, files, and security.

### Primary Roles

1. **Resource Manager**: Allocates CPU time, memory, storage, I/O devices
2. **Interface Provider**: GUI or CLI for user interaction
3. **Program Executor**: Loads and runs applications
4. **Error Handler**: Detects and responds to errors
5. **Security Manager**: Controls access to resources

### Why Operating Systems are Needed

**Without OS**:
- Direct hardware programming required
- No multitasking
- No file organization
- No security
- Complex application development

**With OS**:
- Abstraction layer over hardware
- Efficient resource utilization
- Multitasking support
- Standardized interfaces
- Security and protection

---

## Core Functions of Operating Systems

### 1. Process Management

**Definition**: Managing program execution from creation to termination.

**Key Responsibilities**:
- Process creation and deletion
- Process scheduling
- Process synchronization
- Inter-process communication (IPC)
- Deadlock handling

---

### 2. Memory Management

**Definition**: Controlling and coordinating computer memory allocation.

**Key Responsibilities**:
- Memory allocation and deallocation
- Memory protection
- Memory tracking
- Virtual memory management

---

### 3. File System Management

**Definition**: Organizing and controlling data storage and retrieval.

**Key Responsibilities**:
- File creation and deletion
- Directory management
- Access control
- Backup and recovery
- Space allocation

---

### 4. Device Management

**Definition**: Controlling and coordinating hardware devices.

**Key Responsibilities**:
- Device allocation and deallocation
- Device monitoring
- Buffering and spooling
- Error handling
- Driver management

---

## Process Management

### What is a Process?

A **process** is a program in execution, including:
- Program code (text section)
- Current activity (program counter, registers)
- Stack (temporary data)
- Data section (global variables)
- Heap (dynamically allocated memory)

### Process vs. Program

| Feature | Program | Process |
|---------|---------|---------|
| **Nature** | Passive entity | Active entity |
| **State** | Static (on disk) | Dynamic (in memory) |
| **Lifespan** | Permanent | Temporary |
| **Resources** | None | CPU, memory, I/O |
| **Example** | chrome.exe file | Running Chrome browser |

---

### Process States

**Five-State Model**:

1. **New**: Process being created
2. **Ready**: Waiting for CPU assignment
3. **Running**: Instructions being executed
4. **Waiting (Blocked)**: Waiting for I/O or event
5. **Terminated**: Finished execution

**State Transitions**:
```
New → Ready: Process admitted to system
Ready → Running: Scheduler dispatches process
Running → Ready: Time slice expired (preemption)
Running → Waiting: I/O request or event wait
Waiting → Ready: I/O completion or event occurs
Running → Terminated: Process completes
```

**Example**:
```
1. User clicks Chrome icon (New)
2. OS loads Chrome into memory (Ready)
3. CPU executes Chrome code (Running)
4. Chrome waits for webpage data (Waiting)
5. Data arrives, Chrome ready again (Ready)
6. User closes Chrome (Terminated)
```

---

### Process Control Block (PCB)

**Definition**: Data structure containing process information.

**PCB Contents**:
- **Process ID (PID)**: Unique identifier
- **Process State**: Current state (ready, running, etc.)
- **Program Counter**: Address of next instruction
- **CPU Registers**: Register values when process suspended
- **Memory Management Info**: Page tables, segment tables
- **I/O Status**: Open files, I/O devices allocated
- **Accounting Info**: CPU time used, time limits
- **Priority**: Scheduling priority

**Purpose**: Enables OS to pause and resume processes

---

### Process Scheduling

**Goal**: Maximize CPU utilization and system throughput

**Scheduling Queues**:
- **Job Queue**: All processes in system
- **Ready Queue**: Processes ready to execute
- **Device Queues**: Processes waiting for I/O devices

---

### Scheduling Algorithms

#### 1. First-Come, First-Served (FCFS)

**Method**: Process arriving first gets CPU first

**Characteristics**:
- Non-preemptive
- Simple to implement
- Fair in arrival order

**Example**:
```
Process | Arrival | Burst Time
--------|---------|------------
P1      |    0    |     24
P2      |    1    |      3
P3      |    2    |      3

Execution Order: P1 → P2 → P3
Waiting Time: P1=0, P2=23, P3=26
Average Waiting Time: (0+23+26)/3 = 16.33
```

**Advantages**:
- Simple and easy to understand
- No starvation

**Disadvantages**:
- Convoy effect (short processes wait for long ones)
- Poor average waiting time
- Not suitable for time-sharing systems

---

#### 2. Shortest Job First (SJF)

**Method**: Process with shortest burst time executes first

**Characteristics**:
- Can be preemptive or non-preemptive
- Optimal for minimizing average waiting time
- Requires burst time prediction

**Example (Non-Preemptive)**:
```
Process | Arrival | Burst Time
--------|---------|------------
P1      |    0    |      7
P2      |    2    |      4
P3      |    4    |      1
P4      |    5    |      4

Execution Order: P1 → P3 → P2 → P4
Average Waiting Time: 4
```

**Advantages**:
- Minimum average waiting time
- Optimal algorithm

**Disadvantages**:
- Difficult to predict burst time
- Starvation possible (long processes may never execute)
- Not practical for interactive systems

---

#### 3. Round Robin (RR)

**Method**: Each process gets fixed time slice (quantum) in circular order

**Characteristics**:
- Preemptive
- Time quantum typically 10-100 milliseconds
- Fair to all processes

**Example** (Time Quantum = 4):
```
Process | Burst Time
--------|------------
P1      |     24
P2      |      3
P3      |      3

Execution: P1(4) → P2(3) → P3(3) → P1(4) → P1(4) → P1(4) → P1(4) → P1(4)
```

**Advantages**:
- Fair allocation
- Good for time-sharing systems
- No starvation

**Disadvantages**:
- Higher average waiting time than SJF
- Context switching overhead
- Performance depends on time quantum size

**Time Quantum Selection**:
- Too large: Becomes FCFS
- Too small: Too much context switching overhead
- Typical: 10-100 ms

---

#### 4. Priority Scheduling

**Method**: Process with highest priority executes first

**Characteristics**:
- Can be preemptive or non-preemptive
- Priority assigned based on various factors
- Lower number = higher priority (or vice versa)

**Priority Assignment Factors**:
- Internal: Time limits, memory requirements, I/O to CPU ratio
- External: Process importance, payment, department

**Example**:
```
Process | Burst Time | Priority
--------|------------|----------
P1      |     10     |    3
P2      |      1     |    1
P3      |      2     |    4
P4      |      1     |    5
P5      |      5     |    2

Execution Order: P2 → P5 → P1 → P3 → P4
```

**Advantages**:
- Important processes get preference
- Flexible priority assignment

**Disadvantages**:
- Starvation (low-priority processes may never execute)
- Complex priority determination

**Solution to Starvation**: **Aging**
- Gradually increase priority of waiting processes
- Ensures all processes eventually execute

---

#### 5. Multilevel Queue Scheduling

**Method**: Separate queues for different process types

**Queue Categories**:
- System processes (highest priority)
- Interactive processes
- Batch processes (lowest priority)

**Characteristics**:
- Each queue has own scheduling algorithm
- Fixed priority between queues
- No process movement between queues

**Example**:
```
Queue 1 (System): Round Robin (quantum=8)
Queue 2 (Interactive): Round Robin (quantum=16)
Queue 3 (Batch): FCFS
```

---

### Context Switching

**Definition**: Saving state of current process and loading state of next process

**Steps**:
1. Save current process state to PCB
2. Update PCB (state, accounting info)
3. Move PCB to appropriate queue
4. Select next process to run
5. Load next process state from PCB
6. Resume execution

**Context Switch Time**: Pure overhead (no useful work done)

**Factors Affecting Speed**:
- Hardware support (multiple register sets)
- Memory speed
- Number of registers
- Special instructions

---

### Inter-Process Communication (IPC)

**Purpose**: Enable processes to exchange data and synchronize actions

**IPC Mechanisms**:

#### 1. Shared Memory

**Method**: Processes share common memory region

**Advantages**:
- Fast (no kernel involvement after setup)
- Efficient for large data

**Disadvantages**:
- Synchronization required
- Complex programming

**Example**: Producer-Consumer problem

---

#### 2. Message Passing

**Method**: Processes communicate via messages

**Operations**:
- send(message)
- receive(message)

**Types**:
- Direct: Processes name each other
- Indirect: Messages sent to mailboxes/ports

**Advantages**:
- No shared memory conflicts
- Works across networks
- Easier synchronization

**Disadvantages**:
- Slower than shared memory
- Kernel overhead

---

### Deadlock

**Definition**: Situation where processes wait indefinitely for resources held by each other

**Example**:
```
Process P1 holds Resource R1, needs R2
Process P2 holds Resource R2, needs R1
Both wait forever!
```

**Necessary Conditions** (all must hold):
1. **Mutual Exclusion**: Resources cannot be shared
2. **Hold and Wait**: Process holds resources while waiting for others
3. **No Preemption**: Resources cannot be forcibly taken
4. **Circular Wait**: Circular chain of processes waiting for resources

**Deadlock Handling**:

**1. Prevention**: Ensure at least one condition cannot hold
**2. Avoidance**: Careful resource allocation (Banker's algorithm)
**3. Detection and Recovery**: Detect deadlock and break it
**4. Ignore**: Ostrich algorithm (assume deadlock won't happen)

---

## Memory Management

### Memory Hierarchy

**From Fastest to Slowest**:
1. **Registers**: CPU internal, fastest, smallest
2. **Cache**: L1, L2, L3 (SRAM)
3. **Main Memory**: RAM (DRAM)
4. **Secondary Storage**: SSD, HDD
5. **Tertiary Storage**: Tape, optical

**Trade-off**: Speed vs. Capacity vs. Cost

---

### Memory Management Functions

1. **Allocation**: Assign memory to processes
2. **Deallocation**: Free memory when process terminates
3. **Protection**: Prevent unauthorized access
4. **Relocation**: Load process at different addresses
5. **Sharing**: Allow multiple processes to share memory

---

### Memory Allocation Techniques

#### 1. Contiguous Allocation

**Fixed Partitioning**:
- Memory divided into fixed-size partitions
- One process per partition
- Simple but inflexible

**Problems**:
- Internal fragmentation (unused space within partition)
- Limited number of processes

**Dynamic Partitioning**:
- Partitions created based on process size
- More flexible

**Problems**:
- External fragmentation (unused space between partitions)

**Allocation Strategies**:
- **First Fit**: Allocate first hole large enough
- **Best Fit**: Allocate smallest hole large enough
- **Worst Fit**: Allocate largest hole

---

#### 2. Paging

**Concept**: Divide memory into fixed-size blocks

**Components**:
- **Frame**: Fixed-size block of physical memory
- **Page**: Fixed-size block of logical memory
- **Page Table**: Maps pages to frames

**Advantages**:
- No external fragmentation
- Easy to allocate memory
- Supports virtual memory

**Disadvantages**:
- Internal fragmentation (last page)
- Page table overhead

**Address Translation**:
```
Logical Address = Page Number + Page Offset
Physical Address = Frame Number + Page Offset
```

**Example**:
```
Page Size = 4 KB
Logical Address = 8196
Page Number = 8196 / 4096 = 2
Page Offset = 8196 % 4096 = 4
If Page 2 maps to Frame 5:
Physical Address = 5 * 4096 + 4 = 20484
```

---

#### 3. Segmentation

**Concept**: Divide memory into variable-size segments

**Segments**:
- Code segment
- Data segment
- Stack segment
- Heap segment

**Advantages**:
- Logical division
- Easy sharing and protection
- Supports programmer's view

**Disadvantages**:
- External fragmentation
- Complex memory management

---

#### 4. Virtual Memory

**Definition**: Technique allowing execution of processes not completely in memory

**Benefits**:
- Run programs larger than physical RAM
- More processes in memory simultaneously
- Less I/O needed for loading

**Implementation**:
- **Demand Paging**: Load pages only when needed
- **Demand Segmentation**: Load segments only when needed

**Page Fault**: Reference to page not in memory
1. Trap to OS
2. Find page on disk
3. Load page into free frame
4. Update page table
5. Restart instruction

**Page Replacement Algorithms**:

**1. FIFO (First-In-First-Out)**:
- Replace oldest page
- Simple but not optimal
- Belady's Anomaly possible

**2. LRU (Least Recently Used)**:
- Replace page not used for longest time
- Good performance
- Expensive to implement

**3. Optimal**:
- Replace page not used for longest future time
- Best performance
- Impossible to implement (requires future knowledge)

---

## Key Takeaways

1. **Operating Systems** manage hardware resources and provide services to applications
2. **Process Management** handles program execution, scheduling, and synchronization
3. **Scheduling Algorithms** determine CPU allocation (FCFS, SJF, RR, Priority)
4. **Memory Management** optimizes RAM usage through paging, segmentation, and virtual memory
5. **Deadlock** occurs when processes wait indefinitely for resources
6. **Virtual Memory** allows running programs larger than physical RAM

---

## Study Tips

1. **Understand process states**: Draw state transition diagrams
2. **Practice scheduling**: Work through algorithm examples
3. **Memorize deadlock conditions**: All four must hold
4. **Learn page table calculations**: Practice address translation
5. **Compare algorithms**: Know advantages/disadvantages of each

---

## References

Borodin, V. (Ed.). (2024). *Computer systems application*. Toronto Academic Press.

---

**Next**: Part 2 - File Systems and Device Management
