# Unit 6 Learning Notes - Part 3: Computer Security

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 6 - Computer Networks and Security
- **Topic**: Security Principles, Threats, Attacks, Viruses, Trojans, Firewalls
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [Introduction to Computer Security](#introduction-to-computer-security)
2. [CIA Triad](#cia-triad)
3. [Additional Security Principles](#additional-security-principles)
4. [Types of Threats and Attacks](#types-of-threats-and-attacks)
5. [Malware Types](#malware-types)
6. [Firewalls and Defense Mechanisms](#firewalls-and-defense-mechanisms)
7. [Multi-Layered Security](#multi-layered-security)

---

## Introduction to Computer Security

### What is Computer Security?

**Computer Security (Cybersecurity)** is the practice of protecting computer systems, networks, and data from unauthorized access, theft, damage, or disruption.

### Why Security is Needed

**Threats in Digital Age**:
- Increasing cyber attacks
- Valuable data (personal, financial, corporate)
- Connected devices (IoT, mobile)
- Remote work and cloud computing
- Nation-state cyber warfare

**Consequences of Security Breaches**:
- **Financial Loss**: Theft, fraud, ransomware payments
- **Data Loss**: Customer data, intellectual property
- **Reputation Damage**: Loss of customer trust
- **Legal Liability**: GDPR, HIPAA violations
- **Operational Disruption**: Downtime, productivity loss

**Statistics**:
- Average cost of data breach: $4.45 million (2023)
- Ransomware attack every 11 seconds
- 95% of breaches caused by human error

### Security Goals

1. **Protect Assets**: Data, systems, networks
2. **Ensure Business Continuity**: Minimize disruptions
3. **Maintain Trust**: Customer confidence
4. **Comply with Regulations**: Legal requirements
5. **Prevent Financial Loss**: Reduce risk

---

## CIA Triad

The **CIA Triad** is the foundation of information security, consisting of three core principles.

### 1. Confidentiality

**Definition**: Ensuring information is accessible only to authorized individuals.

**Goal**: Prevent unauthorized disclosure of sensitive information

**Methods to Ensure Confidentiality**:

#### Encryption
- **Symmetric**: Same key for encryption/decryption (AES)
- **Asymmetric**: Public/private key pairs (RSA)
- **Use Cases**: HTTPS, VPN, encrypted files

#### Access Control
- **Authentication**: Verify identity (passwords, biometrics)
- **Authorization**: Grant appropriate permissions
- **Principle of Least Privilege**: Minimum necessary access

#### Data Classification
- **Public**: No restrictions
- **Internal**: Company employees only
- **Confidential**: Specific authorized personnel
- **Secret/Top Secret**: Highest sensitivity

#### Physical Security
- Locked server rooms
- Badge access systems
- Security cameras
- Visitor logs

**Examples of Confidentiality Breaches**:
- Stolen passwords
- Unauthorized database access
- Intercepted communications
- Insider threats
- Social engineering

**Real-World Example**: 
E-commerce platform must protect customer credit card information through encryption (HTTPS), access controls (only authorized staff), and secure storage (encrypted databases).

---

### 2. Integrity

**Definition**: Ensuring information remains accurate, complete, and unaltered by unauthorized parties.

**Goal**: Prevent unauthorized modification or deletion of data

**Methods to Ensure Integrity**:

#### Hashing
- **Purpose**: Detect data tampering
- **Algorithms**: MD5, SHA-256, SHA-512
- **Use**: File integrity verification, password storage

**Example**:
```
Original File: document.pdf
Hash (SHA-256): a3f5b8c9d2e1...
If file modified, hash changes completely
```

#### Digital Signatures
- **Purpose**: Verify authenticity and integrity
- **Method**: Encrypt hash with private key
- **Verification**: Decrypt with public key
- **Use**: Software updates, legal documents

#### Checksums
- **Purpose**: Detect transmission errors
- **Method**: Calculate value from data
- **Use**: File downloads, network packets

#### Version Control
- **Purpose**: Track changes, enable rollback
- **Tools**: Git, SVN
- **Use**: Source code, documents

#### Access Controls
- **Write Permissions**: Limit who can modify data
- **Audit Logs**: Track all changes
- **Change Management**: Approval processes

**Examples of Integrity Breaches**:
- Unauthorized database modifications
- Man-in-the-middle attacks altering data
- Malware corrupting files
- Accidental deletions
- SQL injection attacks

**Real-World Example**:
Banking system must ensure transaction records cannot be altered. Use digital signatures, audit logs, and checksums to verify all transactions remain accurate and unmodified.

---

### 3. Availability

**Definition**: Ensuring information and systems are accessible to authorized users when needed.

**Goal**: Prevent disruption of services and access to data

**Methods to Ensure Availability**:

#### Redundancy
- **RAID**: Redundant Array of Independent Disks
- **Server Clustering**: Multiple servers for same service
- **Load Balancing**: Distribute traffic across servers
- **Geographic Redundancy**: Data centers in multiple locations

#### Backup and Recovery
- **Regular Backups**: Daily, weekly, monthly
- **Backup Types**: Full, incremental, differential
- **Offsite Storage**: Cloud, remote data centers
- **Disaster Recovery Plan**: Procedures for restoration

#### High Availability (HA)
- **Uptime Target**: 99.9% (8.76 hours downtime/year)
- **99.99%**: 52.56 minutes downtime/year
- **99.999%**: 5.26 minutes downtime/year (five nines)

#### Fault Tolerance
- **Redundant Components**: Power supplies, network links
- **Failover Systems**: Automatic switch to backup
- **Hot Standby**: Backup system ready immediately

#### DDoS Protection
- **Traffic Filtering**: Block malicious requests
- **Rate Limiting**: Limit requests per IP
- **CDN**: Content Delivery Network (Cloudflare, Akamai)

#### Maintenance
- **Regular Updates**: Security patches
- **Hardware Maintenance**: Replace aging components
- **Capacity Planning**: Scale resources as needed

**Examples of Availability Breaches**:
- DDoS attacks overwhelming servers
- Hardware failures
- Power outages
- Natural disasters
- Ransomware locking systems
- Network congestion

**Real-World Example**:
E-commerce platform must remain accessible 24/7. Implement load balancers, redundant servers, regular backups, and DDoS protection to ensure 99.99% uptime.

---

### CIA Triad Summary

| Principle | Focus | Threats | Controls |
|-----------|-------|---------|----------|
| **Confidentiality** | Privacy | Unauthorized access, eavesdropping | Encryption, access control, authentication |
| **Integrity** | Accuracy | Unauthorized modification, corruption | Hashing, digital signatures, version control |
| **Availability** | Accessibility | DDoS, hardware failure, disasters | Redundancy, backups, fault tolerance |

### CIA Triad in E-Commerce Example

**Scenario**: Online shopping platform (ShopGuard)

**Confidentiality**:
- Encrypt customer credit card data (SSL/TLS)
- Secure login (passwords, 2FA)
- Access controls for employee systems

**Integrity**:
- Digital signatures for transactions
- Audit logs for all database changes
- Checksums for product information

**Availability**:
- Load balancers for high traffic
- Redundant servers (99.99% uptime)
- DDoS protection (Cloudflare)
- Daily backups with disaster recovery

---

## Additional Security Principles

### 4. Authenticity

**Definition**: Verifying the identity of users, systems, or data sources.

**Goal**: Ensure entities are who they claim to be

**Methods**:
- **Digital Certificates**: SSL/TLS certificates
- **Digital Signatures**: Verify sender identity
- **Multi-Factor Authentication (MFA)**: Something you know + have + are
- **Biometrics**: Fingerprint, face recognition

**Example**: Email digital signature proves sender identity

---

### 5. Non-Repudiation

**Definition**: Preventing denial of actions or transactions.

**Goal**: Provide proof of origin and delivery

**Methods**:
- **Digital Signatures**: Cryptographic proof
- **Audit Logs**: Timestamped records
- **Receipts**: Transaction confirmations
- **Blockchain**: Immutable transaction records

**Example**: Digital signature on contract prevents signer from denying they signed it

**Use Cases**:
- Legal contracts
- Financial transactions
- Email communications
- Software licensing

---

### 6. AAA Framework

#### Authentication
**What**: Verify identity
**Methods**: Passwords, biometrics, tokens, certificates

#### Authorization
**What**: Grant permissions
**Methods**: Role-based access control (RBAC), access control lists (ACL)

#### Accounting (Auditing)
**What**: Track activities
**Methods**: Logs, monitoring, reporting

---

## Types of Threats and Attacks

### Threat vs. Attack

- **Threat**: Potential danger (possibility of harm)
- **Attack**: Actual attempt to exploit vulnerability

### Attack Classification

#### 1. By Target

- **Network Attacks**: Target network infrastructure
- **Application Attacks**: Exploit software vulnerabilities
- **Social Engineering**: Manipulate humans
- **Physical Attacks**: Physical access to systems

#### 2. By Intent

- **Passive Attacks**: Eavesdropping, monitoring (no modification)
- **Active Attacks**: Modification, disruption, destruction

---

### Common Cyber Attacks

### 1. Phishing

**Definition**: Fraudulent attempt to obtain sensitive information by disguising as trustworthy entity.

**Method**:
- Fake emails appearing from legitimate sources (banks, companies)
- Malicious links to fake websites
- Request for passwords, credit card numbers

**Types**:
- **Spear Phishing**: Targeted at specific individuals
- **Whaling**: Targeted at executives (CEO, CFO)
- **Smishing**: SMS phishing
- **Vishing**: Voice call phishing

**Example**:
```
From: security@paypa1.com (note the "1" instead of "l")
Subject: Urgent: Verify Your Account
"Click here to verify your account or it will be suspended"
```

**Prevention**:
- Verify sender email address
- Don't click suspicious links
- Check URL before entering credentials
- Enable 2FA
- Security awareness training

---

### 2. Denial of Service (DoS) / Distributed DoS (DDoS)

**Definition**: Overwhelming system with traffic to make it unavailable.

**DoS**: Single source attack
**DDoS**: Multiple sources (botnet) attack

**Methods**:
- **Volume-Based**: Flood with traffic (UDP flood, ICMP flood)
- **Protocol-Based**: Exploit protocol weaknesses (SYN flood)
- **Application-Layer**: Target web applications (HTTP flood)

**Impact**:
- Website downtime
- Service unavailability
- Revenue loss
- Reputation damage

**Example**:
Botnet of 100,000 infected computers sends requests to target website, overwhelming servers and making site inaccessible to legitimate users.

**Prevention**:
- DDoS protection services (Cloudflare, AWS Shield)
- Rate limiting
- Traffic filtering
- Redundant infrastructure
- CDN (Content Delivery Network)

---

### 3. Man-in-the-Middle (MitM)

**Definition**: Attacker intercepts communication between two parties.

**Method**:
- Position between client and server
- Intercept, read, modify data
- Relay modified data to both parties

**Scenarios**:
- Public Wi-Fi eavesdropping
- DNS spoofing
- ARP poisoning
- SSL stripping

**Example**:
User connects to public Wi-Fi at coffee shop. Attacker intercepts traffic, captures login credentials for banking site.

**Prevention**:
- Use HTTPS (SSL/TLS encryption)
- VPN on public networks
- Certificate validation
- Avoid public Wi-Fi for sensitive transactions

---

### 4. SQL Injection

**Definition**: Inserting malicious SQL code into application queries.

**Method**:
- Exploit input validation weaknesses
- Inject SQL commands through forms
- Access, modify, or delete database data

**Example**:
```
Login Form:
Username: admin' OR '1'='1
Password: anything

Resulting SQL:
SELECT * FROM users WHERE username='admin' OR '1'='1' AND password='anything'
(Always true, bypasses authentication)
```

**Impact**:
- Unauthorized database access
- Data theft
- Data modification/deletion
- Complete system compromise

**Prevention**:
- Parameterized queries (prepared statements)
- Input validation and sanitization
- Least privilege database accounts
- Web Application Firewall (WAF)

---

### 5. Cross-Site Scripting (XSS)

**Definition**: Injecting malicious scripts into web pages viewed by other users.

**Method**:
- Exploit input validation weaknesses
- Inject JavaScript into web forms
- Script executes in victim's browser

**Types**:
- **Stored XSS**: Malicious script stored in database
- **Reflected XSS**: Script in URL, reflected back
- **DOM-based XSS**: Client-side script manipulation

**Impact**:
- Session hijacking (steal cookies)
- Credential theft
- Defacement
- Malware distribution

**Prevention**:
- Input validation and sanitization
- Output encoding
- Content Security Policy (CSP)
- HTTPOnly cookies

---

### 6. Password Attacks

#### Brute Force
**Method**: Try all possible password combinations
**Time**: Depends on password complexity
**Prevention**: Account lockout, rate limiting, strong passwords

#### Dictionary Attack
**Method**: Try common words and passwords
**Prevention**: Avoid common passwords, password complexity requirements

#### Credential Stuffing
**Method**: Use stolen credentials from other breaches
**Prevention**: Unique passwords per site, 2FA

#### Rainbow Table
**Method**: Precomputed hash tables
**Prevention**: Salted hashes

---

### 7. Social Engineering

**Definition**: Manipulating people to divulge confidential information or perform actions.

**Techniques**:
- **Pretexting**: Create false scenario
- **Baiting**: Offer something enticing (free USB drive with malware)
- **Tailgating**: Follow authorized person into secure area
- **Quid Pro Quo**: Offer service in exchange for information

**Example**:
Attacker calls employee pretending to be IT support, requests password to "fix" computer issue.

**Prevention**:
- Security awareness training
- Verify identity before sharing information
- Follow security policies
- Report suspicious requests

---

### 8. Ransomware

**Definition**: Malware that encrypts files and demands payment for decryption key.

**Method**:
1. Infect system (phishing, exploit)
2. Encrypt files
3. Display ransom note
4. Demand payment (usually cryptocurrency)

**Notable Examples**:
- **WannaCry** (2017): 200,000+ computers, $4 billion damage
- **NotPetya** (2017): $10 billion damage
- **Colonial Pipeline** (2021): US fuel supply disruption

**Impact**:
- Data loss
- Operational disruption
- Financial loss (ransom + downtime)
- Reputation damage

**Prevention**:
- Regular backups (offline, offsite)
- Security patches
- Email filtering
- User training
- Endpoint protection

---

### 9. Zero-Day Exploit

**Definition**: Attack exploiting unknown vulnerability (no patch available).

**Timeline**:
1. Vulnerability discovered
2. Exploit developed
3. Attack launched
4. Vendor learns of vulnerability
5. Patch developed and released

**Challenge**: No defense until patch available

**Prevention**:
- Intrusion detection systems
- Behavior-based security
- Network segmentation
- Principle of least privilege

---

## Malware Types

**Malware (Malicious Software)**: Software designed to harm, exploit, or compromise systems.

### 1. Virus

**Definition**: Malicious code that attaches to legitimate files and replicates when executed.

**Characteristics**:
- **Requires Host**: Attaches to files (executables, documents)
- **Requires User Action**: User must execute infected file
- **Self-Replicating**: Spreads to other files
- **Payload**: Malicious actions (delete files, steal data)

**Types**:
- **File Infector**: Infects executable files (.exe, .com)
- **Macro Virus**: Infects documents (Word, Excel macros)
- **Boot Sector**: Infects boot sector of hard drive
- **Polymorphic**: Changes code to evade detection

**Infection Process**:
1. User executes infected file
2. Virus code runs
3. Virus infects other files
4. Virus executes payload

**Example**:
User downloads infected game.exe. When executed, virus infects all .exe files on system and deletes random files weekly.

**Prevention**:
- Antivirus software
- Don't execute unknown files
- Keep software updated
- Scan downloads

---

### 2. Worm

**Definition**: Self-replicating malware that spreads automatically without user action.

**Characteristics**:
- **No Host Required**: Standalone program
- **Self-Propagating**: Spreads automatically over networks
- **No User Action**: Exploits vulnerabilities
- **Network-Based**: Uses network to spread

**Difference from Virus**:
- Virus needs host file, worm is standalone
- Virus needs user action, worm spreads automatically

**Famous Examples**:
- **ILOVEYOU** (2000): Email worm, $10 billion damage
- **Code Red** (2001): Exploited IIS vulnerability
- **Conficker** (2008): Infected 9-15 million computers

**Infection Process**:
1. Worm scans network for vulnerable systems
2. Exploits vulnerability to infect
3. Worm copies itself to infected system
4. Process repeats from new system

**Impact**:
- Network congestion
- System slowdown
- Data theft
- Botnet recruitment

**Prevention**:
- Security patches
- Firewall
- Network segmentation
- Intrusion detection

---

### 3. Trojan Horse

**Definition**: Malware disguised as legitimate software.

**Characteristics**:
- **Disguised**: Appears legitimate (game, utility, update)
- **No Self-Replication**: Doesn't spread itself
- **User Installation**: User must install
- **Backdoor**: Provides remote access

**Types**:
- **Remote Access Trojan (RAT)**: Remote control of system
- **Banking Trojan**: Steal financial credentials
- **Downloader**: Download additional malware
- **Fake Antivirus**: Pretend to be security software

**Example**:
User downloads "free video converter" that actually installs keylogger to steal passwords.

**Infection Process**:
1. User downloads seemingly legitimate software
2. User installs software
3. Trojan installs alongside or instead
4. Trojan performs malicious actions

**Impact**:
- Data theft
- System compromise
- Identity theft
- Financial loss

**Prevention**:
- Download from trusted sources only
- Verify digital signatures
- Antivirus software
- User awareness

---

### 4. Spyware

**Definition**: Software that secretly monitors and collects user information.

**Types**:
- **Keylogger**: Records keystrokes
- **Screen Capture**: Takes screenshots
- **Adware**: Displays unwanted ads, tracks browsing
- **Tracking Cookies**: Monitor web activity

**Impact**:
- Privacy violation
- Identity theft
- Credential theft
- Targeted advertising

**Prevention**:
- Anti-spyware software
- Browser privacy settings
- Avoid suspicious downloads

---

### 5. Rootkit

**Definition**: Malware that hides its presence and provides privileged access.

**Characteristics**:
- **Stealth**: Hides from antivirus and OS
- **Privileged Access**: Root/administrator level
- **Persistence**: Difficult to remove

**Types**:
- **User-Mode**: Application level
- **Kernel-Mode**: Operating system level
- **Bootkit**: Boot loader level
- **Firmware**: BIOS/UEFI level

**Prevention**:
- Secure boot
- Integrity checking
- Specialized rootkit scanners

---

### 6. Adware

**Definition**: Software that displays unwanted advertisements.

**Characteristics**:
- Displays pop-up ads
- Redirects browser
- Tracks browsing habits
- Slows system

**Prevention**:
- Ad blockers
- Careful software installation
- Anti-adware tools

---

### 7. Ransomware

(Covered in Attacks section above)

---

### Malware Comparison Table

| Type | Self-Replicating | Requires Host | User Action | Stealth | Primary Goal |
|------|------------------|---------------|-------------|---------|--------------|
| **Virus** | Yes | Yes | Yes | Medium | Damage, spread |
| **Worm** | Yes | No | No | Low | Spread, network damage |
| **Trojan** | No | No | Yes | High | Backdoor access |
| **Spyware** | No | No | Yes | High | Data theft |
| **Rootkit** | No | No | Yes | Very High | Persistent access |
| **Ransomware** | No | No | Yes | Medium | Financial gain |
| **Adware** | No | No | Yes | Low | Revenue (ads) |

---

## Firewalls and Defense Mechanisms

### What is a Firewall?

A **firewall** is a network security device that monitors and controls incoming and outgoing network traffic based on predetermined security rules.

**Function**: Barrier between trusted internal network and untrusted external network (internet)

**Analogy**: Security guard at building entrance checking IDs

### Firewall Types

#### 1. Packet-Filtering Firewall

**Operation**: Examines packet headers (IP, port, protocol)

**Decisions**: Allow or block based on rules

**Advantages**:
- Fast
- Low resource usage
- Simple

**Disadvantages**:
- No deep inspection
- Vulnerable to IP spoofing
- No application awareness

**Use**: Basic network protection

---

#### 2. Stateful Inspection Firewall

**Operation**: Tracks connection state, examines packet context

**Features**:
- Maintains connection table
- Understands protocols (TCP, UDP)
- More intelligent than packet filtering

**Advantages**:
- Better security than packet filtering
- Context-aware decisions
- Prevents certain attacks

**Disadvantages**:
- More resource-intensive
- Can be bypassed by application-layer attacks

**Use**: Most common firewall type

---

#### 3. Application-Layer Firewall (Proxy Firewall)

**Operation**: Inspects application-layer data (HTTP, FTP, SMTP)

**Features**:
- Deep packet inspection
- Content filtering
- Protocol validation

**Advantages**:
- Highest security level
- Can block specific content
- Hides internal network

**Disadvantages**:
- Slow (deep inspection)
- Resource-intensive
- Can break some applications

**Use**: High-security environments

---

#### 4. Next-Generation Firewall (NGFW)

**Operation**: Combines multiple security functions

**Features**:
- Traditional firewall functions
- Intrusion Prevention System (IPS)
- Application awareness and control
- Deep packet inspection
- Threat intelligence

**Advantages**:
- Comprehensive security
- Single device for multiple functions
- Advanced threat detection

**Disadvantages**:
- Expensive
- Complex configuration
- Resource-intensive

**Use**: Enterprise networks

---

### Firewall Deployment

#### Network Firewall

**Location**: Between networks (perimeter)
**Protects**: Entire network
**Examples**: Hardware appliances, router firewalls

#### Host-Based Firewall

**Location**: On individual devices
**Protects**: Single device
**Examples**: Windows Firewall, iptables (Linux)

#### Cloud Firewall

**Location**: Cloud provider infrastructure
**Protects**: Cloud resources
**Examples**: AWS Security Groups, Azure Firewall

---

### Firewall Rules

**Rule Components**:
- **Source IP**: Where traffic originates
- **Destination IP**: Where traffic is going
- **Port**: Service port number
- **Protocol**: TCP, UDP, ICMP
- **Action**: Allow or Deny

**Example Rules**:
```
1. Allow HTTP (port 80) from any to web server
2. Allow HTTPS (port 443) from any to web server
3. Allow SSH (port 22) from admin network to servers
4. Deny all other traffic (default deny)
```

**Best Practices**:
- Default deny (whitelist approach)
- Least privilege principle
- Regular rule review
- Document all rules

---

### Intrusion Detection/Prevention Systems

#### IDS (Intrusion Detection System)

**Function**: Monitor and alert on suspicious activity
**Action**: Passive (alerts only)
**Deployment**: Inline or out-of-band

#### IPS (Intrusion Prevention System)

**Function**: Monitor and block suspicious activity
**Action**: Active (blocks threats)
**Deployment**: Inline only

**Detection Methods**:
- **Signature-Based**: Match known attack patterns
- **Anomaly-Based**: Detect deviations from normal
- **Behavior-Based**: Analyze behavior patterns

---

### Other Defense Mechanisms

#### Antivirus/Anti-Malware

**Function**: Detect and remove malware
**Methods**: Signature-based, heuristic, behavioral

#### VPN (Virtual Private Network)

**Function**: Encrypt network traffic
**Use**: Secure remote access, privacy

#### DMZ (Demilitarized Zone)

**Function**: Isolated network segment for public-facing servers
**Purpose**: Protect internal network

#### Network Segmentation

**Function**: Divide network into segments
**Purpose**: Limit attack spread, improve security

#### Security Information and Event Management (SIEM)

**Function**: Centralized log collection and analysis
**Purpose**: Threat detection, compliance

---

## Multi-Layered Security

### Defense in Depth

**Concept**: Multiple layers of security controls

**Layers**:

1. **Physical Security**: Locks, cameras, guards
2. **Perimeter Security**: Firewall, IPS
3. **Network Security**: Segmentation, VLANs
4. **Endpoint Security**: Antivirus, host firewall
5. **Application Security**: Input validation, secure coding
6. **Data Security**: Encryption, access control
7. **User Security**: Training, policies

**Analogy**: Castle with moat, walls, guards, locked doors

**Benefit**: If one layer fails, others still protect

---

### Security Best Practices

**Technical Measures**:
- Keep software updated (patches)
- Use strong passwords + 2FA
- Encrypt sensitive data
- Regular backups
- Firewall and antivirus
- Network segmentation
- Least privilege access

**Procedural Measures**:
- Security policies and procedures
- User training and awareness
- Incident response plan
- Regular security audits
- Vendor security assessments
- Change management
- Disaster recovery plan

**Organizational Measures**:
- Security culture
- Executive support
- Dedicated security team
- Budget for security
- Compliance monitoring

---

## Key Takeaways

1. **CIA Triad**: Confidentiality, Integrity, Availability (foundation of security)
2. **Additional Principles**: Authenticity, Non-Repudiation, AAA framework
3. **Common Attacks**: Phishing, DDoS, MitM, SQL injection, ransomware
4. **Malware Types**: Virus (host-dependent), Worm (self-spreading), Trojan (disguised)
5. **Firewalls**: Essential defense, multiple types (packet-filtering, stateful, application, NGFW)
6. **Defense in Depth**: Multiple security layers for comprehensive protection

---

## Study Tips

1. **Memorize CIA Triad**: Core security principles
2. **Understand differences**: Virus vs. Worm vs. Trojan
3. **Know attack methods**: How each attack works and prevention
4. **Firewall types**: Understand capabilities and use cases
5. **Real-world scenarios**: Apply concepts to e-commerce, banking, healthcare

---

## References

Chauhan, S. R., & Jangra, S. (2020). *Computer security and encryption: An introduction*. Mercury Learning & Information.

Simplilearn. (2023, March 5). *What are the CIA triad, AAA, and non-repudiation in cybersecurity* [Video]. YouTube.

Simplilearn. (2025, May 16). *Understanding viruses, trojans, worms & malware for beginners* [Video]. YouTube.

Simplilearn. (2021, August 3). *What is firewall? | Firewall explained | Firewalls and network security* [Video]. YouTube.

---

**End of Unit 6 Learning Notes**

**Summary**: You have now covered all topics in Unit 6:
- Network Fundamentals (Types, Topologies, Transmission Modes, Devices)
- Internet Components (ISP, WWW, DNS, IP, Browsers, Search Engines)
- Computer Security (CIA Triad, Threats, Attacks, Malware, Firewalls)

**Next Steps**: Review all three parts, practice scenarios, and complete Unit 6 assignments!
