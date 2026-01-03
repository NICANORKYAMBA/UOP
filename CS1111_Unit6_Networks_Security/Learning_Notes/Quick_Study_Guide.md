═══════════════════════════════════════════════════════════════════════════════
CS 1111 UNIT 6: QUICK STUDY GUIDE
Computer Networks and Security - Key Concepts
═══════════════════════════════════════════════════════════════════════════════

📚 USE THIS FOR: Quick review before assignments, quizzes, and discussions

═══════════════════════════════════════════════════════════════════════════════
NETWORK TYPES - QUICK COMPARISON
═══════════════════════════════════════════════════════════════════════════════

| Type | Coverage | Speed | Example | Best For |
|------|----------|-------|---------|----------|
| PAN | ~10m | Medium | Bluetooth devices | Personal devices |
| LAN | Building | Fast | Office network | Small business ⭐ |
| MAN | City | Medium | Campus network | Universities |
| WAN | Global | Varies | Internet | Connecting cities |

REMEMBER: PAN < LAN < MAN < WAN (size increases)

═══════════════════════════════════════════════════════════════════════════════
NETWORK TOPOLOGIES - PROS & CONS
═══════════════════════════════════════════════════════════════════════════════

STAR ⭐ (RECOMMENDED):
✅ Easy troubleshooting
✅ Easy to add/remove devices
✅ One cable failure = only one device affected
❌ Central device failure = entire network down
USE FOR: Small business, modern networks

BUS (OBSOLETE):
✅ Simple, cheap
❌ Single cable break = entire network down
❌ Performance degrades with more devices
STATUS: Don't use

RING (OBSOLETE):
✅ Equal access
❌ One device failure = entire network down
STATUS: Don't use

MESH:
✅ Highly reliable, no single point of failure
❌ Very expensive, complex
USE FOR: Critical infrastructure only

═══════════════════════════════════════════════════════════════════════════════
TRANSMISSION MODES - QUICK GUIDE
═══════════════════════════════════════════════════════════════════════════════

SIMPLEX (→):
- One direction only
- Example: TV broadcast, security camera
- Use when: No feedback needed

HALF-DUPLEX (⇄ one at a time):
- Two-way, but taking turns
- Example: Walkie-talkie
- Use when: Bidirectional but not simultaneous

FULL-DUPLEX (⇄ simultaneous): ⭐
- Two-way simultaneously
- Example: Phone call, modern Ethernet
- Use when: Real-time communication needed
- BEST FOR: Modern business networks

═══════════════════════════════════════════════════════════════════════════════
CONNECTING DEVICES - WHAT THEY DO
═══════════════════════════════════════════════════════════════════════════════

HUB (Layer 1):
- Broadcasts to ALL devices
- STATUS: Obsolete, don't use
- REPLACED BY: Switch

SWITCH (Layer 2): ⭐
- Forwards to SPECIFIC device
- Uses MAC addresses
- Creates dedicated channels
- USE FOR: Connecting devices in LAN

ROUTER (Layer 3): ⭐
- Connects different networks
- Uses IP addresses
- Gateway to Internet
- Includes: Firewall, NAT, DHCP, Wi-Fi
- USE FOR: Connecting LAN to Internet

TYPICAL SETUP:
Internet → Modem → Router → Switch → Computers
                      ↓
                 Access Point → Wireless Devices

═══════════════════════════════════════════════════════════════════════════════
INTERNET COMPONENTS - KEY DEFINITIONS
═══════════════════════════════════════════════════════════════════════════════

ISP (Internet Service Provider):
- Provides internet access
- Types: DSL, Cable, Fiber, Satellite
- Tiers: Tier 1 (backbone), Tier 2 (regional), Tier 3 (local)

WWW (World Wide Web):
- System of linked web pages
- Runs ON the Internet (not the same as Internet)
- Uses HTTP/HTTPS protocol

DNS (Domain Name System):
- "Phone book of the Internet"
- Translates: google.com → 142.250.185.46
- Process: Browser → Local DNS → Root → TLD → Authoritative → IP

IP ADDRESS:
- IPv4: 192.168.1.1 (32-bit, 4.3 billion addresses)
- IPv6: 2001:db8::1 (128-bit, virtually unlimited)
- Private: 192.168.x.x, 10.x.x.x (not routable on Internet)
- Public: Assigned by ISP (routable on Internet)

WEB BROWSER:
- Software to access websites
- Examples: Chrome, Firefox, Safari, Edge
- Functions: Render HTML, execute JavaScript, manage cookies

SEARCH ENGINE:
- Finds information on web
- Process: Crawl → Index → Rank
- Examples: Google, Bing, DuckDuckGo

═══════════════════════════════════════════════════════════════════════════════
CIA TRIAD - SECURITY PRINCIPLES
═══════════════════════════════════════════════════════════════════════════════

CONFIDENTIALITY:
- What: Only authorized access
- How: Encryption, passwords, access controls
- Example: Medical records, financial data
- Threat: Data breaches, eavesdropping

INTEGRITY:
- What: Data accuracy, no unauthorized changes
- How: Hashing, digital signatures, checksums
- Example: Bank balances, legal documents
- Threat: Unauthorized modifications, SQL injection

AVAILABILITY:
- What: System accessible when needed
- How: Redundancy, backups, DDoS mitigation
- Example: E-commerce sites, emergency services
- Threat: DDoS attacks, hardware failures, ransomware

BONUS PRINCIPLES:
- Authenticity: Verify identity (MFA, biometrics)
- Non-repudiation: Prevent denial (digital signatures, logs)

═══════════════════════════════════════════════════════════════════════════════
MALWARE COMPARISON
═══════════════════════════════════════════════════════════════════════════════

| Type | Needs Host? | Self-Replicates? | User Action? | Spreads How? |
|------|-------------|------------------|--------------|--------------|
| VIRUS | Yes | Yes | Yes | Infects files |
| WORM | No | Yes | No | Network automatically |
| TROJAN | No | No | Yes | Disguised as legit software |

VIRUS:
- Attaches to programs
- Needs user to run infected file
- Example: Macro virus in Word document

WORM:
- Standalone program
- Spreads automatically across network
- Example: WannaCry ransomware worm

TROJAN:
- Looks legitimate but is malicious
- User installs it voluntarily
- Example: Fake antivirus software

═══════════════════════════════════════════════════════════════════════════════
FIREWALL ESSENTIALS
═══════════════════════════════════════════════════════════════════════════════

WHAT IT DOES:
- Monitors and controls network traffic
- Blocks unauthorized access
- Allows legitimate traffic

TYPES:
1. Packet-Filtering: Checks headers (fast, basic)
2. Stateful: Tracks connections (most common) ⭐
3. Proxy: Acts as intermediary (secure, slow)
4. Next-Gen: Deep inspection, app-aware (advanced)

PLACEMENT:
Internet ← → Firewall ← → Internal Network

RULES:
- Default Deny: Block everything, allow specific
- Allow: HTTP (80), HTTPS (443)
- Deny: All other incoming

LIMITATIONS:
❌ Cannot stop: Insider threats, social engineering, malware in allowed traffic

═══════════════════════════════════════════════════════════════════════════════
COMMON ATTACKS - QUICK REFERENCE
═══════════════════════════════════════════════════════════════════════════════

SQL INJECTION:
- Inserts malicious SQL code
- Target: Web applications with databases
- Result: Data theft, unauthorized access
- Prevention: Input validation, parameterized queries

PHISHING:
- Fake emails/websites to steal credentials
- Target: Users (social engineering)
- Result: Stolen passwords, financial fraud
- Prevention: User training, email filters

DDoS (Distributed Denial of Service):
- Overwhelms server with traffic
- Target: Websites, servers
- Result: Service unavailable
- Prevention: DDoS mitigation services, load balancing

RANSOMWARE:
- Encrypts files, demands payment
- Target: Businesses, individuals
- Result: Data loss, downtime
- Prevention: Backups, patching, user training

MAN-IN-THE-MIDDLE:
- Intercepts communication
- Target: Unencrypted connections
- Result: Data theft, eavesdropping
- Prevention: HTTPS, VPN, encryption

═══════════════════════════════════════════════════════════════════════════════
SECURITY BEST PRACTICES
═══════════════════════════════════════════════════════════════════════════════

TECHNICAL MEASURES:
✅ Use firewalls (network and host-based)
✅ Install antivirus/anti-malware
✅ Enable encryption (HTTPS, VPN)
✅ Implement multi-factor authentication (MFA)
✅ Regular software updates and patches
✅ Network segmentation
✅ Intrusion detection systems (IDS)
✅ Regular backups (3-2-1 rule)

PROCEDURAL MEASURES:
✅ Security awareness training
✅ Strong password policies
✅ Least privilege access
✅ Incident response plan
✅ Regular security audits
✅ Vulnerability assessments
✅ Audit logging and monitoring
✅ Disaster recovery planning

═══════════════════════════════════════════════════════════════════════════════
KEY TERMS GLOSSARY
═══════════════════════════════════════════════════════════════════════════════

Bandwidth: Amount of data transmitted per unit time
Encryption: Converting data to unreadable format
Firewall: Security barrier controlling network traffic
Gateway: Device connecting different networks
IP Address: Unique identifier for network devices
ISP: Company providing internet access
LAN: Local Area Network (building/campus)
MAC Address: Hardware address of network interface
Malware: Malicious software
NAT: Network Address Translation (private → public IP)
Packet: Unit of data transmitted over network
Protocol: Rules for communication (HTTP, TCP/IP)
Router: Device connecting different networks
Switch: Device connecting devices in LAN
Topology: Physical/logical network arrangement
VPN: Virtual Private Network (secure remote access)
WAN: Wide Area Network (large geographic area)

═══════════════════════════════════════════════════════════════════════════════
EXAM/QUIZ TIPS
═══════════════════════════════════════════════════════════════════════════════

KNOW THE DIFFERENCES:
- Hub vs Switch vs Router
- Virus vs Worm vs Trojan
- LAN vs WAN
- IPv4 vs IPv6
- Simplex vs Half-Duplex vs Full-Duplex
- Confidentiality vs Integrity vs Availability

MEMORIZE:
- Star topology = best for small business
- Full-duplex = modern standard
- Switch = Layer 2, Router = Layer 3
- DNS = domain name → IP address
- CIA Triad = Confidentiality, Integrity, Availability

UNDERSTAND CONCEPTS:
- Why star topology is better than bus/ring
- How DNS resolution works
- How firewalls protect networks
- Difference between malware types
- Defense-in-depth strategy

═══════════════════════════════════════════════════════════════════════════════
ASSIGNMENT PREPARATION
═══════════════════════════════════════════════════════════════════════════════

DISCUSSION TOPICS:
- Network types and topologies for small business
- Role of connecting devices (switch, router, hub)
- Transmission modes and practical scenarios

ASSIGNMENT TOPICS:
- ISP security risks for e-commerce
- CIA triad application to customer data
- Common cybersecurity threats
- Multi-layered defense strategy

KEY POINTS TO EMPHASIZE:
✅ Star topology for small business (easy management)
✅ Full-duplex for modern networks (simultaneous communication)
✅ Switch for LAN, Router for Internet gateway
✅ CIA triad for security framework
✅ Defense-in-depth (multiple security layers)
✅ Technical + Procedural measures

═══════════════════════════════════════════════════════════════════════════════

🎯 YOU'RE READY! Use this guide alongside the complete notes for success!

═══════════════════════════════════════════════════════════════════════════════
