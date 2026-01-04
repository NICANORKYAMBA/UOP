# Unit 4 Learning Notes - Part 2: File Systems and OS Types

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 4 - Operating Systems
- **Topic**: File Systems, Device Management, and OS Types
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [File System Management](#file-system-management)
2. [Device Management](#device-management)
3. [Types of Operating Systems](#types-of-operating-systems)
4. [Popular Operating Systems](#popular-operating-systems)

---

## File System Management

### What is a File System?

A **file system** controls how data is stored and retrieved on storage devices.

**Purpose**:
- Organize data into files and directories
- Manage storage space
- Provide access control
- Enable data retrieval
- Ensure data integrity

---

### File Concepts

#### File Attributes

- **Name**: Human-readable identifier
- **Type**: Extension indicating content (.txt, .exe, .jpg)
- **Location**: Physical address on storage
- **Size**: Space occupied
- **Protection**: Access permissions
- **Time/Date**: Creation, modification, last access
- **Owner**: User who created file

#### File Types

**By Content**:
- **Text Files**: Human-readable characters
- **Binary Files**: Machine-readable format
- **Executable Files**: Programs (.exe, .app)
- **Object Files**: Compiled code
- **Library Files**: Reusable code modules

**By Purpose**:
- **System Files**: OS components
- **Application Files**: User programs
- **Data Files**: User data
- **Temporary Files**: Short-term storage

---

### File Operations

**Basic Operations**:
1. **Create**: Make new file
2. **Open**: Prepare file for access
3. **Read**: Get data from file
4. **Write**: Put data into file
5. **Seek**: Move to specific position
6. **Close**: Finish file access
7. **Delete**: Remove file
8. **Rename**: Change file name
9. **Copy**: Duplicate file
10. **Move**: Change file location

**File Access Methods**:

#### 1. Sequential Access

**Method**: Read/write from beginning to end

**Characteristics**:
- Simple implementation
- Efficient for processing entire file
- Cannot skip records

**Use Cases**:
- Log files
- Tape backups
- Streaming media

**Example**:
```
Read record 1
Read record 2
Read record 3
...
```

---

#### 2. Direct Access (Random Access)

**Method**: Jump to any location directly

**Characteristics**:
- Fast access to specific records
- Requires record number or address
- More complex implementation

**Use Cases**:
- Databases
- Disk files
- Memory-mapped files

**Example**:
```
Read record 50
Read record 10
Read record 100
```

---

#### 3. Indexed Access

**Method**: Use index to locate records

**Characteristics**:
- Fast search using index
- Efficient for large files
- Requires index maintenance

**Use Cases**:
- Database systems
- Large data files
- Search applications

**Example**:
```
Index: Name → Record Number
Search "John" → Record 45
Read record 45
```

---

### Directory Structure

**Purpose**: Organize files into logical groups

#### 1. Single-Level Directory

**Structure**: All files in one directory

**Advantages**:
- Simple to implement
- Easy to understand

**Disadvantages**:
- Naming conflicts
- No organization
- Not scalable

**Example**:
```
/
├── file1.txt
├── file2.doc
├── program.exe
└── data.csv
```

---

#### 2. Two-Level Directory

**Structure**: Separate directory for each user

**Advantages**:
- Isolates users
- Prevents naming conflicts
- Simple access control

**Disadvantages**:
- No file sharing
- Limited organization

**Example**:
```
/
├── user1/
│   ├── file1.txt
│   └── file2.doc
└── user2/
    ├── file1.txt
    └── program.exe
```

---

#### 3. Tree-Structured Directory (Hierarchical)

**Structure**: Directories can contain subdirectories

**Advantages**:
- Flexible organization
- Efficient searching
- Supports file sharing
- Most common structure

**Disadvantages**:
- More complex
- Longer pathnames

**Example**:
```
/
├── home/
│   ├── user1/
│   │   ├── documents/
│   │   │   └── report.doc
│   │   └── pictures/
│   │       └── photo.jpg
│   └── user2/
│       └── projects/
│           └── code.py
└── system/
    └── config.ini
```

**Path Types**:
- **Absolute Path**: From root (/)
  - `/home/user1/documents/report.doc`
- **Relative Path**: From current directory
  - `../user2/projects/code.py`

---

### File System Types

#### 1. FAT32 (File Allocation Table)

**Characteristics**:
- Developed by Microsoft (1996)
- Maximum file size: 4 GB
- Maximum partition size: 8 TB
- Simple structure
- Wide compatibility

**Advantages**:
- Universal compatibility
- Simple and fast
- Low overhead

**Disadvantages**:
- 4 GB file size limit
- No journaling
- No built-in security
- Fragmentation issues

**Use Cases**:
- USB flash drives
- Memory cards
- External drives
- Cross-platform storage

---

#### 2. NTFS (New Technology File System)

**Characteristics**:
- Developed by Microsoft (1993)
- Maximum file size: 16 EB (exabytes)
- Journaling support
- Advanced features

**Advantages**:
- Large file support
- File compression
- Encryption (EFS)
- Access control lists (ACL)
- Journaling (crash recovery)
- Disk quotas

**Disadvantages**:
- Limited compatibility (mainly Windows)
- More overhead than FAT32
- Complex structure

**Use Cases**:
- Windows system drives
- Enterprise storage
- Large files (videos, databases)

---

#### 3. ext4 (Fourth Extended Filesystem)

**Characteristics**:
- Linux standard (2008)
- Maximum file size: 16 TB
- Maximum partition size: 1 EB
- Journaling support

**Advantages**:
- Excellent performance
- Journaling
- Large file support
- Backward compatible (ext2, ext3)
- Delayed allocation

**Disadvantages**:
- Limited Windows support
- No built-in encryption

**Use Cases**:
- Linux system drives
- Servers
- High-performance storage

---

#### 4. APFS (Apple File System)

**Characteristics**:
- Developed by Apple (2017)
- Optimized for SSDs
- Native encryption
- Space sharing

**Advantages**:
- Fast on SSDs
- Strong encryption
- Snapshots
- Space efficient
- Crash protection

**Disadvantages**:
- macOS/iOS only
- Not for HDDs
- Limited compatibility

**Use Cases**:
- macOS system drives
- iOS devices
- Apple ecosystem

---

### File System Comparison

| Feature | FAT32 | NTFS | ext4 | APFS |
|---------|-------|------|------|------|
| **Max File Size** | 4 GB | 16 EB | 16 TB | 8 EB |
| **Journaling** | No | Yes | Yes | Yes |
| **Encryption** | No | Yes | No | Yes |
| **Compression** | No | Yes | No | Yes |
| **Permissions** | Basic | Advanced | Advanced | Advanced |
| **Platform** | Universal | Windows | Linux | macOS/iOS |
| **Best For** | USB drives | Windows | Linux | Apple devices |

---

## Device Management

### Device Categories

#### 1. Block Devices

**Characteristics**:
- Data accessed in fixed-size blocks
- Random access possible
- Addressable
- Buffering used

**Examples**:
- Hard drives
- SSDs
- USB drives
- CD/DVD drives

**Operations**:
- Read block
- Write block
- Seek to block

---

#### 2. Character Devices

**Characteristics**:
- Data accessed as stream of characters
- Sequential access
- Not addressable
- No buffering

**Examples**:
- Keyboards
- Mice
- Printers
- Serial ports
- Network cards

**Operations**:
- Get character
- Put character

---

### Device Drivers

**Definition**: Software that enables OS to communicate with hardware

**Functions**:
- Translate OS commands to device-specific operations
- Handle device interrupts
- Manage device buffers
- Implement device protocols

**Driver Types**:
- **Kernel-Mode Drivers**: Run in kernel space (privileged)
- **User-Mode Drivers**: Run in user space (safer)

**Driver Loading**:
- **Static**: Loaded at boot time
- **Dynamic**: Loaded on demand

---

### I/O Management Techniques

#### 1. Programmed I/O (Polling)

**Method**: CPU directly controls I/O

**Process**:
1. CPU initiates I/O operation
2. CPU continuously checks device status
3. CPU waits until operation complete
4. CPU processes data

**Advantages**:
- Simple implementation
- No special hardware needed

**Disadvantages**:
- CPU wastes time waiting
- Inefficient for slow devices

---

#### 2. Interrupt-Driven I/O

**Method**: Device notifies CPU when ready

**Process**:
1. CPU initiates I/O operation
2. CPU continues other work
3. Device sends interrupt when ready
4. CPU handles interrupt
5. CPU processes data

**Advantages**:
- CPU can do other work
- More efficient than polling

**Disadvantages**:
- Interrupt overhead
- Complex programming

---

#### 3. Direct Memory Access (DMA)

**Method**: Device controller transfers data directly to/from memory

**Process**:
1. CPU sets up DMA controller
2. DMA controller transfers data
3. CPU continues other work
4. DMA sends interrupt when complete

**Advantages**:
- Minimal CPU involvement
- Very efficient for large transfers
- Highest performance

**Disadvantages**:
- Requires DMA hardware
- More complex

**Use Cases**:
- Disk I/O
- Network transfers
- Video streaming
- Audio playback

---

### Buffering and Spooling

#### Buffering

**Definition**: Temporary storage for data transfer

**Types**:
- **Single Buffer**: One buffer between device and process
- **Double Buffer**: Two buffers (one filling, one emptying)
- **Circular Buffer**: Ring of buffers

**Purpose**:
- Smooth speed differences
- Reduce I/O wait time
- Enable concurrent operations

---

#### Spooling (Simultaneous Peripheral Operations OnLine)

**Definition**: Queue for device operations

**Process**:
1. Output sent to disk queue (spool)
2. Device processes queue in order
3. Multiple processes can submit jobs

**Example**: Print Spooling
```
User 1 prints document → Print queue
User 2 prints document → Print queue
User 3 prints document → Print queue
Printer processes queue in order
```

**Advantages**:
- Multiple users can share device
- No waiting for device
- Jobs processed in order

---

## Types of Operating Systems

### 1. Batch Operating System

**Characteristics**:
- Jobs grouped into batches
- No user interaction during execution
- Sequential processing
- Efficient for repetitive tasks

**Advantages**:
- High throughput
- Efficient resource utilization
- Minimal idle time

**Disadvantages**:
- No interaction
- Long turnaround time
- Difficult debugging

**Use Cases**:
- Payroll processing
- Bank statement generation
- Scientific calculations

**Example**: IBM mainframes (1960s-1970s)

---

### 2. Time-Sharing Operating System (Multitasking)

**Characteristics**:
- Multiple users share CPU time
- Each user gets time slice
- Interactive
- Rapid context switching

**Advantages**:
- Multiple users simultaneously
- Interactive response
- Efficient CPU utilization
- Fair resource allocation

**Disadvantages**:
- Complex scheduling
- Security concerns
- Overhead from context switching

**Use Cases**:
- University computer systems
- Corporate servers
- Cloud computing

**Examples**: UNIX, Linux, Windows Server

---

### 3. Real-Time Operating System (RTOS)

**Characteristics**:
- Guaranteed response time
- Time-critical operations
- Deterministic behavior
- Minimal latency

**Types**:

**Hard Real-Time**:
- Strict deadlines
- Failure unacceptable
- Examples: Aircraft control, medical devices, nuclear reactors

**Soft Real-Time**:
- Flexible deadlines
- Degraded performance acceptable
- Examples: Video streaming, online gaming

**Advantages**:
- Predictable timing
- High reliability
- Efficient for time-critical tasks

**Disadvantages**:
- Complex design
- Limited flexibility
- Expensive

**Use Cases**:
- Industrial control systems
- Automotive systems
- Medical equipment
- Robotics

**Examples**: VxWorks, QNX, FreeRTOS

---

### 4. Distributed Operating System

**Characteristics**:
- Multiple computers work together
- Appears as single system
- Resource sharing across network
- Transparent to users

**Advantages**:
- Resource sharing
- Increased reliability
- Scalability
- Load balancing

**Disadvantages**:
- Complex design
- Network dependency
- Security challenges

**Use Cases**:
- Cloud computing
- Distributed databases
- Grid computing

**Examples**: Google's infrastructure, Hadoop

---

### 5. Network Operating System

**Characteristics**:
- Manages network resources
- File and printer sharing
- Centralized administration
- Client-server architecture

**Advantages**:
- Centralized management
- Resource sharing
- Security control
- Backup services

**Disadvantages**:
- Server dependency
- Network overhead
- Cost

**Use Cases**:
- Corporate networks
- File servers
- Print servers

**Examples**: Windows Server, Novell NetWare

---

### 6. Mobile Operating System

**Characteristics**:
- Optimized for mobile devices
- Touch interface
- Power management
- App ecosystem

**Advantages**:
- User-friendly
- App marketplace
- Cloud integration
- Regular updates

**Disadvantages**:
- Limited multitasking
- Restricted file access
- Battery constraints

**Examples**: Android, iOS, HarmonyOS

---

## Popular Operating Systems

### 1. Windows

**Developer**: Microsoft

**Versions**:
- Windows 11 (2021)
- Windows 10 (2015)
- Windows 8/8.1 (2012)
- Windows 7 (2009)

**Characteristics**:
- GUI-based
- Wide software compatibility
- Gaming support
- Enterprise features

**Market Share**: ~70% desktop

**Use Cases**:
- Personal computers
- Business workstations
- Gaming
- General purpose

---

### 2. macOS

**Developer**: Apple

**Versions**:
- macOS Sonoma (2023)
- macOS Ventura (2022)
- macOS Monterey (2021)

**Characteristics**:
- Unix-based
- Elegant interface
- Apple ecosystem integration
- Creative professional tools

**Market Share**: ~15% desktop

**Use Cases**:
- Creative professionals
- Software development
- Apple ecosystem users

---

### 3. Linux

**Developer**: Open source community

**Popular Distributions**:
- Ubuntu
- Fedora
- Debian
- CentOS
- Arch Linux

**Characteristics**:
- Open source
- Highly customizable
- Secure and stable
- Free

**Market Share**: ~3% desktop, 90%+ servers

**Use Cases**:
- Servers
- Development
- Embedded systems
- Supercomputers

---

### 4. Unix

**Developer**: AT&T Bell Labs (1969)

**Variants**:
- Solaris (Oracle)
- AIX (IBM)
- HP-UX (HP)

**Characteristics**:
- Multi-user, multitasking
- Portable
- Powerful shell
- Stable

**Use Cases**:
- Enterprise servers
- Scientific computing
- Legacy systems

---

### 5. Android

**Developer**: Google

**Characteristics**:
- Linux-based
- Open source
- App ecosystem
- Customizable

**Market Share**: ~70% mobile

**Use Cases**:
- Smartphones
- Tablets
- Smart TVs
- IoT devices

---

### 6. iOS

**Developer**: Apple

**Characteristics**:
- Closed ecosystem
- Secure
- Optimized performance
- Regular updates

**Market Share**: ~27% mobile

**Use Cases**:
- iPhones
- iPads
- Apple Watch

---

## OS Comparison Table

| OS | Type | Open Source | Best For | Market |
|----|------|-------------|----------|--------|
| **Windows** | Desktop | No | General use, gaming | Desktop leader |
| **macOS** | Desktop | No | Creative work, Apple users | Premium desktop |
| **Linux** | Desktop/Server | Yes | Servers, development | Server leader |
| **Unix** | Server | No | Enterprise, legacy | Enterprise |
| **Android** | Mobile | Yes | Smartphones, tablets | Mobile leader |
| **iOS** | Mobile | No | iPhones, iPads | Premium mobile |

---

## Key Takeaways

1. **File Systems** organize data storage (FAT32, NTFS, ext4, APFS)
2. **Device Management** controls hardware through drivers and I/O techniques
3. **OS Types** serve different purposes (Batch, Time-Sharing, Real-Time, Distributed)
4. **Popular OSes** include Windows, macOS, Linux, Unix, Android, iOS
5. **DMA** is most efficient I/O technique for large data transfers
6. **Spooling** enables multiple users to share devices like printers

---

## Study Tips

1. **Compare file systems**: Know when to use each type
2. **Understand I/O techniques**: Polling vs. Interrupts vs. DMA
3. **Memorize OS types**: Match type to use case
4. **Know popular OSes**: Market share and characteristics
5. **Practice scenarios**: Which OS for which application?

---

## References

Borodin, V. (Ed.). (2024). *Computer systems application*. Toronto Academic Press.

---

**End of Unit 4 Learning Notes**

**Summary**: You have covered:
- Process and Memory Management
- File Systems and Device Management
- Types of Operating Systems
- Popular Operating Systems

**Next Steps**: Review both parts and complete Unit 4 assignments!
