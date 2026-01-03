# CS1111 Final Exam Study Guide

## 📚 Complete Course Overview

This comprehensive study guide covers all units in CS1111 Computer Science Fundamentals. Use this to prepare for quizzes, midterm, and final exam.

---

## 📖 Table of Contents

1. [Unit 1: Introduction to Computer Science](#unit-1-introduction)
2. [Unit 2: Number Systems and Codes](#unit-2-number-systems)
3. [Unit 3: Logic Design](#unit-3-logic-design)
4. [Unit 4: Operating Systems](#unit-4-operating-systems)
5. [Unit 5: Database Management Systems](#unit-5-database-management)
6. [Unit 6: Networks and Security](#unit-6-networks-and-security)
7. [Unit 7: Programming Fundamentals](#unit-7-programming-fundamentals)
8. [Unit 8: Emerging Trends](#unit-8-emerging-trends)
9. [Exam Tips and Strategies](#exam-tips)
10. [Quick Reference Tables](#quick-reference)

---

## Unit 1: Introduction to Computer Science

### Key Concepts

**Computer Hardware:**
- **CPU (Central Processing Unit)**: Brain of computer, executes instructions
- **RAM (Random Access Memory)**: Temporary storage, volatile (loses data when powered off)
- **Storage**: Permanent storage (HDD, SSD), non-volatile
- **Input Devices**: Keyboard, mouse, scanner, microphone
- **Output Devices**: Monitor, printer, speakers

**Software Types:**
- **System Software**: Operating systems (Windows, macOS, Linux), manages hardware
- **Application Software**: Programs for specific tasks (Word, Excel, browsers)
- **Utility Software**: Maintenance tools (antivirus, disk cleanup)

**Programming Basics:**
- **Variables**: Store data values
- **Data Types**: Integer, float, string, boolean
- **Control Structures**: Loops, conditionals
- **Functions**: Reusable code blocks

### Essential Questions
1. What is the difference between hardware and software?
2. What are the main components of a computer system?
3. What is the role of the operating system?
4. What are the basic programming concepts?

---

## Unit 2: Number Systems and Codes

### Key Concepts

**Number Systems:**
- **Binary (Base-2)**: Uses 0, 1; foundation of computing
- **Decimal (Base-10)**: Standard human counting (0-9)
- **Hexadecimal (Base-16)**: Uses 0-9, A-F; compact binary representation
- **Octal (Base-8)**: Uses 0-7; less common

**Conversions:**

**Binary to Decimal:**
```
1011₂ = (1×2³) + (0×2²) + (1×2¹) + (1×2⁰) = 8+0+2+1 = 11₁₀
```

**Decimal to Binary:**
```
13₁₀: Divide by 2, record remainders
13÷2=6 r1, 6÷2=3 r0, 3÷2=1 r1, 1÷2=0 r1
Read bottom to top: 1101₂
```

**Binary to Hex:**
```
Group by 4: 11010110₂ = 1101 0110 = D6₁₆
```

**Binary Arithmetic:**
- Addition: 0+0=0, 0+1=1, 1+0=1, 1+1=10 (carry)
- Subtraction: 0-0=0, 1-0=1, 1-1=0, 0-1=1 (borrow)

**Character Encoding:**
- **ASCII**: 7-bit (128 chars), Extended 8-bit (256 chars)
  - 'A' = 65₁₀, 'a' = 97₁₀, '0' = 48₁₀
- **Unicode**: Universal encoding, UTF-8/16/32

### Essential Questions
1. Convert 1101₂ to decimal
2. Convert 25₁₀ to binary
3. Convert FF₁₆ to binary
4. What is ASCII code for 'A'?
5. Why is hexadecimal useful in computing?

---

## Unit 3: Logic Design

### Logic Gates (Memorize These!)

| Gate | Symbol | Truth Table | Description |
|------|--------|-------------|-------------|
| **AND** | ──┐<br>  ├── | 0,0→0; 0,1→0; 1,0→0; 1,1→1 | True only if ALL inputs true |
| **OR** | ──┐<br>  ├── | 0,0→0; 0,1→1; 1,0→1; 1,1→1 | True if ANY input true |
| **NOT** | ──▷○── | 0→1; 1→0 | Inverts input |
| **NAND** | ──┐<br>  ├──○ | 0,0→1; 0,1→1; 1,0→1; 1,1→0 | NOT-AND (opposite of AND) |
| **NOR** | ──┐<br>  ├──○ | 0,0→1; 0,1→0; 1,0→0; 1,1→0 | NOT-OR (opposite of OR) |
| **XOR** | ──┐<br>  ├── | 0,0→0; 0,1→1; 1,0→1; 1,1→0 | True if inputs DIFFER |

### Key Concepts
- **Boolean Logic**: True/False (1/0) operations
- **Truth Tables**: Show all input/output combinations
- **Circuit Design**: Combining gates to solve problems
- **Universal Gates**: NAND and NOR can create any other gate

### Essential Questions
1. What is the output of an AND gate with inputs 1 and 0?
2. How do you create a truth table?
3. What makes NAND a universal gate?
4. How do logic gates relate to computer processors?

---

## Unit 4: Operating Systems

### Key Concepts

**OS Functions:**
1. **Process Management**: Create, schedule, terminate processes
2. **Memory Management**: Allocate/deallocate, virtual memory, paging
3. **File System Management**: Create, delete, organize files
4. **Device Management**: Control I/O devices, drivers
5. **Security**: Authentication, access control, protection

**Process States:**
```
New → Ready → Running → Waiting → Terminated
         ↑       ↓
         └───────┘
```

**CPU Scheduling Algorithms:**
- **FCFS (First-Come, First-Served)**: Simple, can cause long waits
- **SJF (Shortest Job First)**: Minimizes average wait time
- **Round Robin**: Time slices, fair for interactive systems
- **Priority**: Based on priority levels, can cause starvation

**Memory Management:**
- **Paging**: Fixed-size pages, eliminates external fragmentation
- **Segmentation**: Variable-size logical segments
- **Virtual Memory**: Use disk as RAM extension, demand paging

**File Systems:**
- **FAT32**: Simple, 4GB file limit
- **NTFS**: Windows, large files, security
- **ext4**: Linux, journaling
- **APFS**: macOS, SSD-optimized

**OS Types:**
- **Batch**: Process jobs in batches
- **Time-Sharing**: Multiple users share CPU
- **Distributed**: Multiple computers as one system
- **Real-Time**: Guaranteed response time
- **Mobile**: Touch interface, power management

**Popular Operating Systems:**
- **Windows**: Proprietary, GUI, general use
- **macOS**: Proprietary, Unix-based, creative work
- **Linux**: Open-source, CLI/GUI, servers
- **Unix**: Enterprise servers, stable
- **Android**: Mobile, Linux-based
- **iOS**: Apple mobile, secure

### Essential Questions
1. What are the five main OS functions?
2. What are the process states?
3. What is the difference between paging and segmentation?
4. Compare FCFS and Round Robin scheduling
5. What is virtual memory?
6. Compare Windows, Linux, and macOS

---

## Unit 5: Database Management Systems

### Key Concepts

**Database Models:**

**Relational:**
- Tables (rows and columns)
- SQL for querying
- ACID compliance
- Examples: MySQL, PostgreSQL, Oracle

**NoSQL:**
- **Document**: JSON/XML (MongoDB)
- **Key-Value**: Simple pairs (Redis)
- **Column-Family**: Column storage (Cassandra)
- **Graph**: Nodes and relationships (Neo4j)

**SQL Basics:**
```sql
-- Create
CREATE TABLE students (id INT, name VARCHAR(50));

-- Insert
INSERT INTO students VALUES (1, 'Alice');

-- Select
SELECT * FROM students WHERE id = 1;

-- Update
UPDATE students SET name = 'Bob' WHERE id = 1;

-- Delete
DELETE FROM students WHERE id = 1;
```

**Keys:**
- **Primary Key**: Uniquely identifies row, cannot be NULL
- **Foreign Key**: References primary key in another table
- **Composite Key**: Multiple columns together

**Normalization:**
- **1NF**: Atomic values, no repeating groups
- **2NF**: 1NF + no partial dependencies
- **3NF**: 2NF + no transitive dependencies
- **Purpose**: Reduce redundancy, ensure integrity

**ACID Properties:**
- **Atomicity**: All or nothing
- **Consistency**: Valid state maintained
- **Isolation**: Transactions don't interfere
- **Durability**: Changes permanent after commit

**Transactions:**
```sql
BEGIN TRANSACTION;
  UPDATE accounts SET balance = balance - 100 WHERE id = 1;
  UPDATE accounts SET balance = balance + 100 WHERE id = 2;
COMMIT; -- or ROLLBACK if error
```

**Popular DBMS:**
- **MySQL**: Open-source, web apps, fast
- **PostgreSQL**: Open-source, advanced features
- **MongoDB**: NoSQL, flexible schema, JSON
- **Oracle**: Enterprise, robust, expensive
- **SQL Server**: Microsoft, Windows integration
- **SQLite**: Lightweight, mobile apps

### Essential Questions
1. What is the difference between relational and NoSQL databases?
2. What are the basic SQL commands (CRUD)?
3. What is a primary key vs. foreign key?
4. Explain the three normal forms
5. What are ACID properties?
6. What is a database transaction?
7. Compare MySQL, PostgreSQL, and MongoDB

---

## Unit 6: Networks and Security

### Network Fundamentals

**Network Topologies:**
- **Bus**: Single cable, all devices connected (simple, single point of failure)
- **Star**: Central hub/switch (easy to manage, hub is single point of failure)
- **Ring**: Circular connection (equal access, break affects all)
- **Mesh**: Multiple connections (redundant, expensive)

**Network Protocols:**
- **TCP/IP**: Transmission Control Protocol/Internet Protocol (reliable data transfer)
- **HTTP/HTTPS**: Web browsing (HTTPS is secure)
- **DNS**: Domain Name System (converts names to IP addresses)
- **DHCP**: Dynamic Host Configuration Protocol (assigns IP addresses)

**Network Devices:**
- **Router**: Connects different networks, directs traffic
- **Switch**: Connects devices within network, intelligent forwarding
- **Hub**: Connects devices, broadcasts to all (outdated)
- **Firewall**: Filters traffic, blocks unauthorized access

### Security Principles

**CIA Triad:**
- **Confidentiality**: Only authorized access (encryption, access controls)
- **Integrity**: Data accuracy and completeness (checksums, digital signatures)
- **Availability**: Systems accessible when needed (redundancy, backups)

**Common Threats:**
- **Phishing**: Fake emails/websites to steal credentials
- **Malware**: Viruses, trojans, ransomware
- **DDoS**: Distributed Denial of Service (overwhelm system)
- **Man-in-the-Middle**: Intercept communications
- **SQL Injection**: Exploit database vulnerabilities

**Defense Strategies:**
- **Firewalls**: Filter network traffic
- **Encryption**: Protect data confidentiality
- **Authentication**: Verify user identity (passwords, MFA)
- **IDS/IPS**: Intrusion Detection/Prevention Systems
- **Regular Updates**: Patch vulnerabilities
- **Backups**: Ensure data availability

### Essential Questions
1. What are the advantages of star topology?
2. What is the difference between HTTP and HTTPS?
3. Explain the CIA triad with examples
4. How does a firewall protect a network?
5. What is phishing and how to prevent it?

---

## Unit 7: Programming Fundamentals

### Programming Paradigms

**Structured Programming:**
- **Principles**: Modularity, top-down design, clear control flow
- **Control Structures**: Sequence, selection (if/else), iteration (loops)
- **Benefits**: Readable, maintainable, easy to debug
- **Example**: C, Pascal

**Functional Programming:**
- **Principles**: Pure functions, immutability, no side effects
- **Key Concepts**: First-class functions, higher-order functions (map, filter, reduce)
- **Benefits**: Predictable, testable, good for concurrency
- **Example**: Haskell, Lisp, functional features in Python/JavaScript

**Object-Oriented Programming (OOP):**
- **Principles**: Encapsulation, inheritance, polymorphism, abstraction
- **Key Concepts**: Classes, objects, methods, attributes
- **Benefits**: Modular, reusable, models real-world entities
- **Example**: Java, C++, Python

### Comparison Table

| Aspect | Structured | Functional | OOP |
|--------|-----------|-----------|-----|
| **Focus** | Procedures | Functions | Objects |
| **Data** | Separate from functions | Immutable | Encapsulated |
| **Reuse** | Function calls | Function composition | Inheritance |
| **State** | Mutable | Immutable | Encapsulated |

### Algorithm Constructs

**Sequencing:**
- Execute statements in order
- Step-by-step instructions
- Example: Read input → Process → Display output

**Selection (Conditionals):**
- Make decisions based on conditions
- IF-THEN-ELSE statements
- Example: IF age >= 18 THEN "Adult" ELSE "Minor"

**Iteration (Loops):**
- Repeat actions
- FOR loop: Known number of iterations
- WHILE loop: Condition-based repetition
- Example: FOR i = 1 TO 10: Print i

### Debugging Techniques

**Types of Errors:**
- **Syntax Errors**: Code doesn't follow language rules (caught by compiler)
- **Runtime Errors**: Errors during execution (division by zero, file not found)
- **Logical Errors**: Code runs but produces wrong results (hardest to find)

**Debugging Strategies:**
- **Print Debugging**: Insert print statements to track values
- **Trace Tables**: Manually track variable values through execution
- **Debugger Tools**: Step through code, set breakpoints, inspect variables
- **Test Cases**: Use known inputs/outputs to verify correctness

### Essential Questions
1. What are the three programming paradigms?
2. What is encapsulation in OOP?
3. What are the three algorithm constructs?
4. What is the difference between syntax and logical errors?
5. How do you debug a program with incorrect output?

---

## Unit 8: Emerging Trends

### Machine Learning

**Three Types (Remember: SUR):**

**Supervised Learning:**
- Labeled data (input + correct output)
- Learn input-output mapping
- Examples: Spam detection, image recognition, credit scoring

**Unsupervised Learning:**
- Unlabeled data
- Discover patterns
- Examples: Customer segmentation, anomaly detection

**Reinforcement Learning:**
- Learn through trial and error
- Rewards and penalties
- Examples: Game AI, robotics, autonomous vehicles

### Cloud Computing

**Service Models (Remember: IPS):**
- **IaaS**: Infrastructure as a Service (rent servers, storage)
- **PaaS**: Platform as a Service (development platform)
- **SaaS**: Software as a Service (complete applications)

**Deployment Models:**
- **Public**: Open to anyone (AWS, Azure, Google Cloud)
- **Private**: Single organization (more control, higher cost)
- **Hybrid**: Mix of public and private
- **Community**: Shared by group with common needs

**Five Properties:**
1. On-demand self-service
2. Broad network access
3. Resource pooling
4. Rapid elasticity
5. Measured service

### Big Data

**5 V's (Remember: VVVVV):**
1. **Volume**: Massive amounts of data
2. **Velocity**: High-speed generation and processing
3. **Variety**: Different formats (structured, unstructured)
4. **Veracity**: Quality and accuracy
5. **Value**: Extracting meaningful insights

### Blockchain

**Five Components (Remember: BCNCC):**
1. **Block**: Container for data
2. **Chain**: Linked blocks
3. **Network**: Distributed nodes
4. **Consensus**: Agreement mechanism
5. **Cryptography**: Security layer

**Key Characteristics:**
- Decentralized (no central authority)
- Immutable (cannot change past records)
- Transparent (all participants see transactions)
- Secure (cryptographic protection)

### IoT and Robotics

**Sensors (Input Devices):**
- Detect environmental conditions
- Types: Temperature, motion, proximity, vision, force, sound
- Convert physical phenomena to electrical signals

**Actuators (Output Devices):**
- Perform physical actions
- Types: Electric motors, hydraulic, pneumatic
- Convert electrical signals to motion/force

**Sense-Think-Act Cycle:**
1. **SENSE**: Sensors gather data
2. **THINK**: Controller processes information
3. **ACT**: Actuators execute commands
4. **REPEAT**: Continuous feedback loop

### Virtual Reality

**VR vs. AR vs. MR:**
- **VR**: Replaces reality (fully immersive)
- **AR**: Enhances reality (overlays digital content)
- **MR**: Blends reality (digital objects interact with physical)

**Applications:**
- Gaming and entertainment
- Education and training
- Healthcare and therapy
- Real estate and architecture
- Manufacturing and engineering

### Essential Questions
1. What are the three types of machine learning?
2. What is the difference between IaaS, PaaS, and SaaS?
3. What are the 5 V's of Big Data?
4. What makes blockchain secure and transparent?
5. What is the Sense-Think-Act cycle in robotics?
6. What is the difference between VR and AR?

---

## Exam Tips and Strategies

### Before the Exam

**1. Review All Quick Study Guides**
- Unit 6: Networks and Security Quick Guide
- Unit 7: Programming Fundamentals Quick Guide
- Unit 8: Emerging Trends Quick Study Guide

**2. Memorize Key Mnemonics**
- **SUR**: Machine Learning types
- **IPS**: Cloud service models
- **VVVVV**: Big Data 5 V's
- **BCNCC**: Blockchain components
- **CIA**: Security triad

**3. Practice with Comparison Tables**
- Programming paradigms comparison
- Network topologies comparison
- Logic gates truth tables
- Cloud deployment models

**4. Understand Relationships**
- How technologies integrate (IoT + Cloud, ML + Big Data)
- How concepts build on each other
- Real-world applications

### During the Exam

**1. Read Questions Carefully**
- Identify key terms
- Understand what's being asked
- Look for qualifiers (all, some, never, always)

**2. Eliminate Wrong Answers**
- Cross out obviously incorrect options
- Narrow down to best answer
- Use process of elimination

**3. Manage Your Time**
- Don't spend too long on one question
- Mark difficult questions and return later
- Leave time to review answers

**4. Use Context Clues**
- Later questions may provide hints for earlier ones
- Related questions may help recall information

**5. Trust Your First Instinct**
- Usually correct unless you find clear error
- Don't second-guess without good reason

### Common Question Types

**Definition Questions:**
- "What is [concept]?"
- Focus on core definition and key characteristics

**Comparison Questions:**
- "What is the difference between X and Y?"
- Use comparison tables from study guides

**Application Questions:**
- "How would [technology] be used in [scenario]?"
- Think about real-world examples and benefits

**True/False Questions:**
- Look for absolute terms (always, never) - often false
- Qualified statements (usually, sometimes) - often true

**Multiple Choice:**
- Read all options before selecting
- Eliminate obviously wrong answers
- Choose most complete/accurate answer

---

## Quick Reference Tables

### Network Topologies

| Topology | Advantages | Disadvantages | Use Case |
|----------|-----------|---------------|----------|
| **Bus** | Simple, cheap | Single point of failure | Small networks |
| **Star** | Easy to manage, isolate faults | Hub failure affects all | Most common |
| **Ring** | Equal access, no collisions | Break affects all | Token ring networks |
| **Mesh** | Redundant, reliable | Expensive, complex | Critical systems |

### Programming Paradigms

| Paradigm | Key Feature | Best For | Example Language |
|----------|-------------|----------|------------------|
| **Structured** | Procedures, clear flow | Algorithmic problems | C, Pascal |
| **Functional** | Pure functions, immutable | Data processing | Haskell, Lisp |
| **OOP** | Objects, encapsulation | Complex systems | Java, Python |

### Machine Learning Types

| Type | Data | Feedback | Goal | Example |
|------|------|----------|------|---------|
| **Supervised** | Labeled | Correct answers | Predict | Spam filter |
| **Unsupervised** | Unlabeled | None | Find patterns | Customer groups |
| **Reinforcement** | Sequential | Rewards | Maximize reward | Game AI |

### Cloud Service Models

| Model | You Manage | Provider Manages | Example |
|-------|-----------|------------------|---------|
| **IaaS** | Apps, data, runtime, OS | Servers, storage, network | AWS EC2 |
| **PaaS** | Apps, data | Runtime, OS, servers | Heroku |
| **SaaS** | Data only | Everything else | Gmail, Office 365 |

### Logic Gates Quick Reference

| Gate | Inputs (A,B) | Output | Remember |
|------|-------------|--------|----------|
| **AND** | 1,1 | 1 | Both must be true |
| **OR** | 0,0 | 0 | At least one true |
| **NOT** | 1 | 0 | Inverts |
| **NAND** | 1,1 | 0 | Opposite of AND |
| **NOR** | 0,0 | 1 | Opposite of OR |
| **XOR** | Same | 0 | Inputs must differ |

---

## Final Checklist

### Content Review
- [ ] Unit 1: Computer basics, hardware, software
- [ ] Unit 2: Number systems, conversions, binary arithmetic
- [ ] Unit 3: Logic gates, truth tables, circuits
- [ ] Unit 4: Operating systems, process/memory management
- [ ] Unit 5: Databases, SQL, normalization, ACID
- [ ] Unit 6: Networks, security, CIA triad
- [ ] Unit 7: Programming paradigms, algorithms, debugging
- [ ] Unit 8: ML, Cloud, Big Data, Blockchain, IoT, VR

### Memorization
- [ ] All mnemonics (SUR, IPS, VVVVV, BCNCC, CIA)
- [ ] Logic gate truth tables
- [ ] Programming paradigm characteristics
- [ ] Network topology features
- [ ] Security threat types

### Practice
- [ ] Review all quick study guides
- [ ] Complete practice questions
- [ ] Create flashcards for key terms
- [ ] Explain concepts to someone else
- [ ] Take practice quizzes

### Exam Day
- [ ] Get good sleep night before
- [ ] Eat a healthy meal
- [ ] Arrive early/log in early
- [ ] Have scratch paper ready
- [ ] Stay calm and focused

---

## 🎓 Good Luck!

**Remember:**
- You've completed all assignments successfully
- You have comprehensive notes for every unit
- You understand the concepts, not just memorization
- Trust your preparation and stay confident

**Final Tip**: If you get stuck on a question, move on and come back. Your subconscious will often work on it while you answer other questions.

---

**Study smart, not just hard. Focus on understanding relationships between concepts, not just isolated facts.**
