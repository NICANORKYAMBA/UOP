# Unit 1: Introduction to Computer Systems - Part 3: Secondary Storage & Software

## 1. Secondary Storage Devices

### What is Secondary Storage?

**Definition:** Non-volatile storage for permanent data retention, separate from primary memory (RAM).

**Purpose:**
- Long-term data storage
- Backup and archival
- Program storage
- Large capacity at lower cost

**Characteristics:**
- **Non-volatile:** Retains data when power off
- **Large capacity:** Terabytes of storage
- **Slower than RAM:** Millisecond access times
- **Permanent:** Data persists until deleted
- **Cost-effective:** Cheaper per byte than RAM

---

### Classification of Secondary Storage

#### A. DASD (Direct Access Storage Devices)

**Definition:** Devices that allow direct access to any data location without reading through other data.

**Characteristics:**
- Random access to data
- Fast retrieval of specific data
- No need to read sequentially

**Examples:**
- Hard Disk Drives (HDD)
- Solid State Drives (SSD)
- USB Flash Drives
- Memory Cards

---

#### B. SASD (Sequential Access Storage Devices)

**Definition:** Devices that must read data in sequence from beginning to desired location.

**Characteristics:**
- Sequential access only
- Must read through previous data
- Slower for random access
- Good for backup/archival

**Examples:**
- Magnetic Tape
- Older storage technologies

---

## 2. Types of Secondary Storage Devices

### 1. Hard Disk Drive (HDD)

**Technology:**
- Magnetic storage on rotating platters
- Read/write heads move over platters
- Mechanical device with moving parts

**Components:**
- **Platters:** Magnetic disks storing data
- **Spindle:** Rotates platters (5400-7200 RPM typical)
- **Read/Write Heads:** Magnetic sensors
- **Actuator Arm:** Positions heads
- **Controller:** Manages operations

**Characteristics:**
- **Capacity:** 500 GB - 20 TB
- **Speed:** 80-160 MB/s read/write
- **Access Time:** 5-10 milliseconds
- **Cost:** $0.02-0.05 per GB
- **Lifespan:** 3-5 years typical

**Advantages:**
- Large capacity
- Low cost per GB
- Mature, reliable technology
- Good for bulk storage

**Disadvantages:**
- Mechanical parts (can fail)
- Slower than SSD
- Fragile (sensitive to shock)
- Noisy operation
- Higher power consumption

**Use Cases:**
- Desktop computers
- Servers (bulk storage)
- Backup systems
- Archival storage
- Budget systems

---

### 2. Solid State Drive (SSD)

**Technology:**
- Flash memory (no moving parts)
- Electronic storage using transistors
- NAND flash technology

**Characteristics:**
- **Capacity:** 128 GB - 8 TB
- **Speed:** 200-550 MB/s (SATA), 2000-7000 MB/s (NVMe)
- **Access Time:** <0.1 milliseconds
- **Cost:** $0.10-0.20 per GB
- **Lifespan:** 5-10 years, limited write cycles

**Advantages:**
- Very fast (3-10x faster than HDD)
- No moving parts (more reliable)
- Silent operation
- Shock resistant
- Lower power consumption
- Lightweight

**Disadvantages:**
- More expensive per GB
- Limited write cycles (wears out)
- Smaller capacities (typically)
- Data recovery harder if fails

**Types:**
- **SATA SSD:** Uses SATA interface (slower)
- **NVMe SSD:** Uses PCIe interface (much faster)
- **M.2 SSD:** Form factor, can be SATA or NVMe

**Use Cases:**
- Operating system drive
- Applications and games
- Laptops (portability)
- High-performance systems
- Databases (fast access)

---

### 3. USB Flash Drive

**Technology:**
- Flash memory in portable form
- USB interface

**Characteristics:**
- **Capacity:** 8 GB - 1 TB
- **Speed:** 10-150 MB/s
- **Portable:** Pocket-sized
- **Plug-and-play:** No installation needed

**Advantages:**
- Highly portable
- No power needed (bus-powered)
- Durable
- Universal compatibility

**Disadvantages:**
- Easy to lose
- Limited capacity
- Slower than internal SSD
- Can be damaged/corrupted

**Use Cases:**
- File transfer
- Portable storage
- Bootable drives
- Backup (small files)

---

### 4. Optical Discs

**Types:**
- **CD (Compact Disc):** 700 MB
- **DVD (Digital Versatile Disc):** 4.7 GB (single layer), 8.5 GB (dual layer)
- **Blu-ray:** 25 GB (single layer), 50 GB (dual layer)

**Technology:**
- Laser reads pits and lands on disc surface
- Optical (light-based) storage

**Variants:**
- **ROM:** Read-only (pre-recorded)
- **R:** Recordable (write once)
- **RW:** Rewritable (multiple writes)

**Advantages:**
- Inexpensive
- Portable
- Long shelf life (if stored properly)
- Universal compatibility

**Disadvantages:**
- Limited capacity
- Slow access speed
- Fragile (scratches affect data)
- Becoming obsolete

**Use Cases:**
- Software distribution
- Movies and music
- Archival storage
- Backup (declining use)

---

### 5. Memory Cards

**Types:**
- SD (Secure Digital)
- microSD
- CompactFlash (CF)

**Characteristics:**
- **Capacity:** 8 GB - 1 TB
- **Speed:** Varies by class (Class 10, UHS-I, UHS-II)
- **Portable:** Very small
- **Removable:** Easy to swap

**Use Cases:**
- Cameras and camcorders
- Smartphones and tablets
- Gaming consoles
- Drones and action cameras

---

### 6. Cloud Storage

**Technology:**
- Data stored on remote servers
- Accessed via internet
- Managed by service provider

**Characteristics:**
- **Capacity:** Scalable (GB to TB)
- **Access:** From anywhere with internet
- **Cost:** Subscription-based
- **Redundancy:** Multiple copies for reliability

**Popular Services:**
- Google Drive
- Dropbox
- Microsoft OneDrive
- iCloud
- Amazon S3

**Advantages:**
- Access from any device
- Automatic backup
- Collaboration features
- No local storage needed
- Disaster recovery

**Disadvantages:**
- Requires internet connection
- Ongoing subscription cost
- Privacy concerns
- Dependent on provider
- Upload/download speeds

**Use Cases:**
- File backup
- File sharing
- Collaboration
- Mobile device storage
- Disaster recovery

---

## 3. Storage Comparison Table

| Device | Type | Capacity | Speed | Cost/GB | Portability | Durability | Use Case |
|--------|------|----------|-------|---------|-------------|------------|----------|
| **HDD** | Magnetic | 500GB-20TB | Slow | Low | Low | Moderate | Bulk storage |
| **SSD** | Flash | 128GB-8TB | Very Fast | Medium | Medium | High | OS, apps |
| **USB Flash** | Flash | 8GB-1TB | Medium | Medium | Very High | High | File transfer |
| **Optical** | Optical | 700MB-50GB | Slow | Very Low | High | Low | Archival |
| **Memory Card** | Flash | 8GB-1TB | Medium | Medium | Very High | High | Cameras |
| **Cloud** | Network | Unlimited | Varies | Medium | Very High | Very High | Backup, sharing |

---

## 4. Data Persistence, Capacity, and Access Speed

### Data Persistence
**Definition:** How long data remains stored without power.

**Ranking (Best to Worst):**
1. Optical discs (decades if stored properly)
2. HDD (years, but mechanical failure risk)
3. SSD (years, but data degradation if unpowered long-term)
4. Flash drives (years, similar to SSD)
5. RAM (seconds after power loss - not persistent)

**Key Point:** All secondary storage is persistent; primary memory (RAM) is not.

---

### Capacity
**Definition:** Amount of data that can be stored.

**Ranking (Largest to Smallest):**
1. Cloud storage (virtually unlimited, scalable)
2. HDD (up to 20 TB)
3. SSD (up to 8 TB consumer, more for enterprise)
4. USB flash drives (up to 1 TB)
5. Optical discs (up to 50 GB Blu-ray)
6. Memory cards (up to 1 TB)

**Trend:** Capacities increasing, prices decreasing over time.

---

### Access Speed
**Definition:** How quickly data can be read or written.

**Ranking (Fastest to Slowest):**
1. NVMe SSD (2000-7000 MB/s)
2. SATA SSD (200-550 MB/s)
3. HDD (80-160 MB/s)
4. USB 3.0 Flash (10-150 MB/s)
5. Optical disc (10-50 MB/s)
6. Cloud storage (depends on internet speed)

**Note:** RAM is much faster than all secondary storage (10,000+ MB/s).

---

## 5. Software

### What is Software?

**Definition:** Set of instructions (programs) that tell computer hardware what to do.

**Characteristics:**
- Intangible (cannot touch)
- Logical component
- Can be copied and distributed
- Can be updated/modified
- Requires hardware to run

---

## 6. Types of Software

### A. System Software

**Definition:** Software that manages and controls computer hardware, providing platform for application software.

**Purpose:**
- Manage hardware resources
- Provide services to applications
- Interface between hardware and user

---

#### 1. Operating System (OS)

**Definition:** Core system software that manages all computer operations.

**Functions:**

**a. Process Management:**
- Create, schedule, terminate processes
- Allocate CPU time
- Handle multitasking

**b. Memory Management:**
- Allocate and deallocate memory
- Virtual memory management
- Protect memory spaces

**c. File Management:**
- Organize files and directories
- Read/write operations
- File permissions and security

**d. Device Management:**
- Control input/output devices
- Device drivers
- Interrupt handling

**e. User Interface:**
- **GUI (Graphical User Interface):** Windows, icons, menus
- **CLI (Command Line Interface):** Text commands

**f. Security:**
- User authentication
- Access control
- Virus protection

**Popular Operating Systems:**
- **Windows:** Most popular desktop OS, user-friendly
- **macOS:** Apple computers, Unix-based, elegant
- **Linux:** Open-source, customizable, servers
- **Android:** Mobile devices, Linux-based
- **iOS:** Apple mobile devices, secure

---

#### 2. Device Drivers

**Definition:** Software that enables OS to communicate with hardware devices.

**Purpose:**
- Translate OS commands to device-specific instructions
- Enable hardware functionality

**Examples:**
- Printer drivers
- Graphics card drivers
- Network adapter drivers
- Sound card drivers

---

#### 3. Utility Software

**Definition:** Programs that perform maintenance and optimization tasks.

**Examples:**
- **Antivirus:** Protect against malware
- **Disk Cleanup:** Remove unnecessary files
- **Backup Software:** Create data backups
- **Compression Tools:** Reduce file size (WinZip, 7-Zip)
- **Disk Defragmenter:** Optimize HDD performance

---

### B. Application Software

**Definition:** Programs designed for end-users to perform specific tasks.

**Categories:**

**1. Productivity Software:**
- **Word Processors:** Microsoft Word, Google Docs
- **Spreadsheets:** Excel, Google Sheets
- **Presentations:** PowerPoint, Google Slides
- **Email Clients:** Outlook, Gmail

**2. Multimedia Software:**
- **Image Editing:** Photoshop, GIMP
- **Video Editing:** Premiere Pro, Final Cut Pro
- **Audio Editing:** Audacity, GarageBand
- **Media Players:** VLC, Windows Media Player

**3. Web Browsers:**
- Chrome, Firefox, Safari, Edge

**4. Communication Software:**
- Zoom, Skype, Slack, Teams

**5. Database Software:**
- MySQL, Oracle, MongoDB

**6. Entertainment:**
- Games, streaming apps

**7. Educational:**
- Learning management systems
- Educational games
- Reference software

---

### C. Embedded Software

**Definition:** Software built into hardware devices to control specific functions.

**Characteristics:**
- Dedicated to specific task
- Stored in ROM or flash memory
- Real-time operation
- Resource-constrained
- Rarely updated

**Examples:**

**1. Consumer Electronics:**
- Smart TV firmware
- Digital camera software
- Washing machine controllers
- Microwave oven programs

**2. Automotive:**
- Engine control units (ECU)
- Anti-lock braking systems (ABS)
- Infotainment systems
- Navigation systems

**3. Medical Devices:**
- Pacemakers
- Insulin pumps
- MRI machines
- Patient monitors

**4. Industrial:**
- Factory robots
- CNC machines
- Process controllers
- Sensors and actuators

**5. IoT Devices:**
- Smart thermostats
- Security cameras
- Fitness trackers
- Smart speakers

---

## 7. Software Comparison

| Type | Purpose | Examples | User Interaction | Modifiable |
|------|---------|----------|------------------|------------|
| **System** | Manage hardware | Windows, Linux | Indirect | Rarely |
| **Application** | Perform tasks | Word, Chrome | Direct | Frequently |
| **Embedded** | Control devices | TV firmware | Minimal | Rarely |

---

## Key Takeaways

1. **Secondary Storage:** Non-volatile, permanent, large capacity, slower than RAM
2. **DASD:** Direct access (HDD, SSD, USB)
3. **SASD:** Sequential access (magnetic tape)
4. **HDD:** Magnetic, large capacity, slow, cheap
5. **SSD:** Flash, fast, expensive, no moving parts
6. **Trade-offs:** Persistence, capacity, speed, cost
7. **System Software:** Manages hardware (OS, drivers, utilities)
8. **Application Software:** User tasks (Word, browsers, games)
9. **Embedded Software:** Device control (firmware, IoT)

---

## References

Gupta, C. P., & Goyal, K. K. (2020). *Computer concepts and management information systems*. Mercury Learning & Information.

Make It Easy Education. (2020, September 23). *Types of software* [Video]. YouTube. https://www.youtube.com/watch?v=example

Embedded 101. (2021, March 10). *Embedded 101 course: Embedded software* [Video]. YouTube. https://www.youtube.com/watch?v=example
