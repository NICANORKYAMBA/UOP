═══════════════════════════════════════════════════════════════════════════════
CS 1111 UNIT 6: COMPUTER NETWORKS AND SECURITY
COMPREHENSIVE LEARNING NOTES
═══════════════════════════════════════════════════════════════════════════════

📚 TOPICS COVERED:
1. Network Types, Topologies, Transmission Modes, and Connecting Devices
2. Internet Components (ISP, WWW, DNS, IP Address, Browsers, Search Engines)
3. Computer Security (CIA Triad, Threats, Attacks, Viruses, Trojans, Firewalls)

═══════════════════════════════════════════════════════════════════════════════
PART 1: COMPUTER NETWORKS
═══════════════════════════════════════════════════════════════════════════════

1.1 NETWORK TYPES (Classification by Size/Scope)
───────────────────────────────────────────────────────────────────────────────

PAN (Personal Area Network):
- Smallest network type
- Coverage: ~10 meters (30 feet)
- Connects personal devices (smartphone, laptop, tablet, smartwatch)
- Technologies: Bluetooth, USB, Infrared
- Example: Connecting wireless earbuds to phone

LAN (Local Area Network):
- Coverage: Single building or campus
- Speed: 100 Mbps to 10 Gbps
- Connects computers, printers, servers within office/home
- Technologies: Ethernet (wired), Wi-Fi (wireless)
- Example: Office network connecting all employee computers
- Advantages: High speed, low cost, easy management
- Disadvantages: Limited geographic coverage

MAN (Metropolitan Area Network):
- Coverage: City or metropolitan area (up to 50 km)
- Connects multiple LANs within a city
- Technologies: Fiber optic cables, microwave links
- Example: University campus network connecting multiple buildings
- Used by: ISPs, cable TV networks, city governments

WAN (Wide Area Network):
- Coverage: Countries, continents, global
- Connects LANs and MANs across large distances
- Technologies: Leased lines, satellites, undersea cables
- Example: The Internet (largest WAN)
- Advantages: Global connectivity
- Disadvantages: Slower speeds, higher costs, complex management

KEY COMPARISON:
PAN < LAN < MAN < WAN (in terms of size)
LAN > MAN > WAN (in terms of speed)


1.2 NETWORK TOPOLOGIES (Physical/Logical Arrangement)
───────────────────────────────────────────────────────────────────────────────

BUS TOPOLOGY:
Structure: All devices connected to single cable (backbone)
Advantages:
- Simple, inexpensive
- Easy to install
- Requires less cable
Disadvantages:
- Single point of failure (cable break = entire network down)
- Performance degrades with more devices
- Difficult to troubleshoot
- Limited cable length
Status: OBSOLETE - not used in modern networks

RING TOPOLOGY:
Structure: Devices connected in circular chain
Data flow: Unidirectional (one direction around ring)
Advantages:
- Equal access for all devices
- No collisions
Disadvantages:
- Single device failure breaks entire network
- Difficult to add/remove devices
- Troubleshooting is complex
Status: OBSOLETE - replaced by switched networks

STAR TOPOLOGY: ⭐ MOST COMMON
Structure: All devices connect to central hub/switch
Advantages:
- Easy to install and manage
- Easy troubleshooting (problems isolated to one connection)
- Easy to add/remove devices
- One cable failure affects only that device
- Centralized management
Disadvantages:
- Central device failure = entire network down
- Requires more cable than bus
- Cost of central switch
Use case: Modern office networks, home networks
RECOMMENDED FOR: Small businesses, most applications

MESH TOPOLOGY:
Structure: Every device connected to every other device
Types:
- Full mesh: Every device connects to all others
- Partial mesh: Some devices have multiple connections
Advantages:
- Highly reliable (multiple paths)
- No single point of failure
- High performance
- Excellent for critical applications
Disadvantages:
- Very expensive (lots of cables/connections)
- Complex installation and management
- Difficult to maintain
Use case: Military networks, critical infrastructure, data centers

TREE (HIERARCHICAL) TOPOLOGY:
Structure: Combination of star topologies in hierarchy
Advantages:
- Scalable
- Easy to manage and maintain
- Supports future expansion
Disadvantages:
- If backbone fails, entire segment goes down
- More cable required
Use case: Large organizations with departments

HYBRID TOPOLOGY:
Structure: Combination of two or more topologies
Example: Star-Bus, Star-Ring
Advantages:
- Flexible
- Scalable
- Reliable
Use case: Large enterprise networks


1.3 TRANSMISSION MODES (Direction of Data Flow)
───────────────────────────────────────────────────────────────────────────────

SIMPLEX:
Direction: One-way only (unidirectional)
Sender → Receiver (no reverse communication)
Examples:
- Television broadcasting (station → TV)
- Radio broadcasting
- Keyboard → Computer
- Security cameras → Monitor
- Digital signage
Advantages:
- Simple
- Cost-effective
- No coordination needed
Disadvantages:
- No feedback possible
- No error correction
Use when: Feedback not required

HALF-DUPLEX:
Direction: Two-way, but one direction at a time
Device A ⇄ Device B (taking turns)
Examples:
- Walkie-talkies (push to talk, release to listen)
- CB radios
- Old Ethernet with hubs
- Some wireless networks
Process:
1. Device A transmits (Device B listens)
2. Device A stops
3. Device B transmits (Device A listens)
Advantages:
- Two-way communication
- Uses single channel
- More efficient than simplex
Disadvantages:
- Delays (waiting for turn)
- Collision detection needed
- Lower effective bandwidth
Use when: Bidirectional needed but simultaneous not required

FULL-DUPLEX: ⭐ MODERN STANDARD
Direction: Two-way simultaneously (bidirectional)
Device A ⇄ Device B (both directions at once)
Examples:
- Telephone conversations
- Modern Ethernet with switches
- Video conferencing
- VoIP (Voice over IP)
- Cell phone calls
- Fiber optic networks
Mechanism:
- Separate transmit and receive channels
- Dedicated wire pairs in Ethernet
- Different frequencies in wireless
Advantages:
- Maximum efficiency
- No waiting
- Doubles effective bandwidth
- No collisions
- Real-time communication
Disadvantages:
- More complex
- Higher cost
- Requires more infrastructure
Use when: Real-time bidirectional communication needed

COMPARISON:
Simplex: →
Half-Duplex: ⇄ (one at a time)
Full-Duplex: ⇄ (simultaneous)


1.4 CONNECTING DEVICES (Network Hardware)
───────────────────────────────────────────────────────────────────────────────

HUB (Physical Layer - Layer 1):
Function: Broadcasts data to all connected devices
Operation:
- Receives signal on one port
- Amplifies and sends to ALL other ports
- No intelligence or filtering
Types:
- Passive hub: Just connects wires
- Active hub: Amplifies signal
Advantages:
- Very simple
- Inexpensive
Disadvantages:
- Creates network congestion
- Security issues (all devices see all traffic)
- Collisions occur
- Wastes bandwidth
Status: OBSOLETE - replaced by switches

SWITCH (Data Link Layer - Layer 2): ⭐ MODERN STANDARD
Function: Intelligently forwards data to specific devices
Operation:
- Maintains MAC address table
- Learns which device is on which port
- Forwards data only to destination port
- Creates dedicated communication channels
Types:
- Unmanaged switch: Plug-and-play, no configuration
- Managed switch: Configurable, VLANs, QoS, security features
Advantages:
- Reduces collisions
- Improves performance
- Better security
- Full-duplex support
- Efficient bandwidth use
Features (Managed):
- VLANs (Virtual LANs) for network segmentation
- QoS (Quality of Service) for traffic prioritization
- Port security
- Link aggregation
- Monitoring and management
Use case: All modern networks

ROUTER (Network Layer - Layer 3): ⭐ CRITICAL DEVICE
Function: Connects different networks, routes traffic between them
Operation:
- Examines IP addresses
- Determines best path for data
- Forwards packets between networks
- Connects LAN to Internet
Key Features:
- NAT (Network Address Translation): Multiple devices share one public IP
- DHCP (Dynamic Host Configuration Protocol): Assigns IP addresses automatically
- Firewall: Blocks unauthorized traffic
- Wireless Access Point: Provides Wi-Fi
- VPN support: Secure remote access
Routing Process:
1. Receives packet
2. Examines destination IP address
3. Consults routing table
4. Determines best path
5. Forwards to next hop
Types:
- Home/Small business router: All-in-one device
- Enterprise router: High-performance, advanced features
- Core router: Backbone of large networks
Use case: Gateway between LAN and Internet, connecting networks

BRIDGE:
Function: Connects two LAN segments
Operation:
- Filters traffic between segments
- Reduces collisions
- Extends network distance
Use case: Connecting two building networks

ACCESS POINT (AP):
Function: Provides wireless connectivity
Operation:
- Connects wireless devices to wired network
- Broadcasts Wi-Fi signal
- Handles wireless authentication
Features:
- Multiple SSIDs
- Security (WPA2, WPA3)
- Guest networks
Use case: Providing Wi-Fi in offices, homes

MODEM (Modulator-Demodulator):
Function: Converts digital signals to analog and vice versa
Types:
- DSL modem: Uses phone lines
- Cable modem: Uses coaxial cable
- Fiber modem (ONT): Uses fiber optic
Operation:
- Modulation: Digital → Analog (for transmission)
- Demodulation: Analog → Digital (for reception)
Use case: Connecting to ISP

GATEWAY:
Function: Connects networks using different protocols
Operation:
- Protocol conversion
- Data format translation
Use case: Connecting different network types

REPEATER:
Function: Amplifies and regenerates signals
Operation:
- Receives weak signal
- Amplifies it
- Retransmits
Use case: Extending network distance


DEVICE HIERARCHY IN TYPICAL NETWORK:
Internet → Modem → Router → Switch → End Devices (Computers, Printers)
                      ↓
                 Access Point → Wireless Devices


═══════════════════════════════════════════════════════════════════════════════
PART 2: INTERNET COMPONENTS
═══════════════════════════════════════════════════════════════════════════════

2.1 INTERNET SERVICE PROVIDER (ISP)
───────────────────────────────────────────────────────────────────────────────

Definition: Company that provides internet access to customers

Types of ISPs:
1. Tier 1 ISPs:
   - Largest ISPs (AT&T, Verizon, Level 3)
   - Own backbone infrastructure
   - Connect directly to other Tier 1 ISPs
   - No upstream providers

2. Tier 2 ISPs:
   - Regional ISPs
   - Buy bandwidth from Tier 1
   - Sell to Tier 3 and end users

3. Tier 3 ISPs:
   - Local ISPs
   - Buy from Tier 2
   - Serve end customers directly

Connection Types:
- DSL (Digital Subscriber Line): Uses phone lines, 1-100 Mbps
- Cable: Uses coaxial cable, 10-500 Mbps
- Fiber: Fiber optic cables, 100-1000+ Mbps (fastest)
- Satellite: Remote areas, 12-100 Mbps (high latency)
- Mobile/Cellular: 4G/5G, 10-1000 Mbps

ISP Services:
- Internet connectivity
- Email accounts
- Web hosting
- Domain registration
- DNS servers
- Technical support


2.2 WORLD WIDE WEB (WWW)
───────────────────────────────────────────────────────────────────────────────

Definition: System of interlinked hypertext documents accessed via Internet

Key Concepts:
- Web ≠ Internet (Web runs ON the Internet)
- Internet: Infrastructure (cables, routers, protocols)
- Web: Service that uses the Internet

Components:
1. Web Pages: Documents written in HTML
2. Websites: Collections of related web pages
3. Web Servers: Computers hosting websites
4. Hyperlinks: Links connecting pages
5. URLs: Addresses of web resources

Protocols:
- HTTP (HyperText Transfer Protocol): Port 80
- HTTPS (HTTP Secure): Port 443, encrypted

How WWW Works:
1. User enters URL in browser
2. Browser sends HTTP request to web server
3. Server processes request
4. Server sends HTML, CSS, JavaScript back
5. Browser renders page for user


2.3 DOMAIN NAME SYSTEM (DNS)
───────────────────────────────────────────────────────────────────────────────

Definition: "Phone book of the Internet" - translates domain names to IP addresses

Why DNS Needed:
- Computers use IP addresses (192.168.1.1)
- Humans prefer names (google.com)
- DNS translates names → IP addresses

Domain Name Structure:
www.example.com
│   │       │
│   │       └─ TLD (Top-Level Domain): .com, .org, .edu, .uk
│   └───────── Second-Level Domain: example
└───────────── Subdomain: www

DNS Hierarchy:
1. Root DNS Servers: Top level (13 worldwide)
2. TLD DNS Servers: Handle .com, .org, etc.
3. Authoritative DNS Servers: Store actual records
4. Local DNS Servers: ISP's DNS cache

DNS Resolution Process:
1. User types "www.google.com"
2. Browser checks local cache
3. If not found, queries local DNS server (ISP)
4. Local DNS queries root server
5. Root directs to .com TLD server
6. TLD directs to google.com authoritative server
7. Authoritative server returns IP address
8. Local DNS caches result
9. Browser connects to IP address

DNS Record Types:
- A Record: Domain → IPv4 address
- AAAA Record: Domain → IPv6 address
- CNAME: Alias (www → example.com)
- MX: Mail server
- NS: Name server
- TXT: Text information

DNS Caching:
- Speeds up subsequent requests
- TTL (Time To Live): How long to cache
- Reduces DNS server load


2.4 IP ADDRESS
───────────────────────────────────────────────────────────────────────────────

Definition: Unique numerical identifier for devices on network

IPv4 (Internet Protocol version 4):
- Format: 32-bit, four octets
- Example: 192.168.1.100
- Range: 0.0.0.0 to 255.255.255.255
- Total addresses: ~4.3 billion
- Problem: Running out of addresses

IPv4 Classes:
- Class A: 1.0.0.0 to 126.255.255.255 (large networks)
- Class B: 128.0.0.0 to 191.255.255.255 (medium networks)
- Class C: 192.0.0.0 to 223.255.255.255 (small networks)

Private IP Ranges (not routable on Internet):
- 10.0.0.0 to 10.255.255.255
- 172.16.0.0 to 172.31.255.255
- 192.168.0.0 to 192.168.255.255

Special Addresses:
- 127.0.0.1: Localhost (your own computer)
- 0.0.0.0: Default route
- 255.255.255.255: Broadcast

IPv6 (Internet Protocol version 6):
- Format: 128-bit, eight groups of hexadecimal
- Example: 2001:0db8:85a3:0000:0000:8a2e:0370:7334
- Shortened: 2001:db8:85a3::8a2e:370:7334
- Total addresses: 340 undecillion (virtually unlimited)
- Adoption: Gradually replacing IPv4

Static vs Dynamic IP:
- Static: Manually assigned, never changes
  - Use: Servers, printers, network devices
- Dynamic: Automatically assigned by DHCP, can change
  - Use: End-user devices (computers, phones)

Public vs Private IP:
- Public: Routable on Internet, globally unique
  - Assigned by ISP
- Private: Used within LANs, not routable on Internet
  - NAT translates private → public


2.5 WEB BROWSERS
───────────────────────────────────────────────────────────────────────────────

Definition: Software application for accessing and viewing websites

Popular Browsers:
- Google Chrome (most popular, ~65% market share)
- Safari (Apple devices)
- Mozilla Firefox (open-source)
- Microsoft Edge (Windows default)
- Opera, Brave

Browser Functions:
1. Rendering Engine: Displays HTML, CSS, JavaScript
2. Networking: Sends HTTP/HTTPS requests
3. JavaScript Engine: Executes JavaScript code
4. Storage: Cookies, cache, local storage
5. Security: HTTPS, certificate validation, sandboxing

How Browsers Work:
1. User enters URL
2. DNS lookup (domain → IP)
3. Establish TCP connection
4. Send HTTP request
5. Receive HTTP response (HTML, CSS, JS, images)
6. Parse HTML, build DOM (Document Object Model)
7. Parse CSS, apply styles
8. Execute JavaScript
9. Render page on screen

Browser Components:
- Address bar: Enter URLs
- Tabs: Multiple pages simultaneously
- Bookmarks: Save favorite sites
- History: Track visited sites
- Extensions/Add-ons: Additional features
- Developer tools: Debug websites

Browser Security Features:
- HTTPS enforcement
- Certificate warnings
- Pop-up blockers
- Phishing protection
- Sandboxing (isolate tabs)
- Private/Incognito mode


2.6 SEARCH ENGINES
───────────────────────────────────────────────────────────────────────────────

Definition: Software system that searches for information on the Web

Major Search Engines:
- Google (90%+ market share)
- Bing (Microsoft)
- Yahoo
- DuckDuckGo (privacy-focused)
- Baidu (China)

How Search Engines Work:

1. CRAWLING:
   - Web crawlers (spiders/bots) visit websites
   - Follow links from page to page
   - Discover new and updated content
   - Googlebot, Bingbot

2. INDEXING:
   - Analyze crawled pages
   - Extract keywords, content, metadata
   - Store in massive database (index)
   - Organize for fast retrieval

3. RANKING:
   - User enters search query
   - Search algorithm evaluates indexed pages
   - Ranks results by relevance
   - Considers 200+ factors

Ranking Factors:
- Keyword relevance
- Content quality
- Page speed
- Mobile-friendliness
- Backlinks (other sites linking to page)
- User engagement
- Domain authority
- Freshness of content

Search Operators:
- "exact phrase": Search exact words
- site:example.com: Search specific site
- filetype:pdf: Search specific file types
- -word: Exclude word
- OR: Either term
- *: Wildcard

SEO (Search Engine Optimization):
- Techniques to improve search rankings
- On-page: Content, keywords, meta tags
- Off-page: Backlinks, social signals
- Technical: Site speed, mobile optimization


═══════════════════════════════════════════════════════════════════════════════
PART 3: COMPUTER SECURITY
═══════════════════════════════════════════════════════════════════════════════

3.1 CIA TRIAD (Core Security Principles)
───────────────────────────────────────────────────────────────────────────────

CONFIDENTIALITY:
Definition: Ensuring information is accessible only to authorized parties
Goal: Prevent unauthorized disclosure
Mechanisms:
- Encryption (AES, RSA)
- Access controls (passwords, permissions)
- Authentication (who you are)
- Authorization (what you can access)
- Data classification (public, confidential, secret)
Examples:
- Medical records (HIPAA)
- Financial data
- Personal information
- Trade secrets
Threats:
- Eavesdropping
- Shoulder surfing
- Data breaches
- Social engineering

INTEGRITY:
Definition: Ensuring data accuracy and preventing unauthorized modification
Goal: Maintain data trustworthiness
Mechanisms:
- Hashing (SHA-256, MD5)
- Digital signatures
- Checksums
- Version control
- Access controls
- Audit logs
Examples:
- Bank account balances
- Medical prescriptions
- Legal documents
- Software code
Threats:
- Unauthorized modifications
- Data corruption
- Man-in-the-middle attacks
- SQL injection

AVAILABILITY:
Definition: Ensuring authorized users can access systems/data when needed
Goal: Maintain system uptime and accessibility
Mechanisms:
- Redundancy (backup servers)
- Load balancing
- Failover systems
- DDoS mitigation
- Regular backups
- Disaster recovery plans
- UPS (Uninterruptible Power Supply)
Examples:
- E-commerce websites (24/7 access)
- Emergency services
- Banking systems
- Email servers
Threats:
- DDoS attacks
- Hardware failures
- Natural disasters
- Power outages
- Ransomware

ADDITIONAL PRINCIPLES:

AUTHENTICITY:
Definition: Verifying identity of users/systems
Mechanisms:
- Digital certificates
- Biometrics
- Multi-factor authentication (MFA)

NON-REPUDIATION:
Definition: Preventing denial of actions
Mechanisms:
- Digital signatures
- Audit logs
- Timestamps
Example: Proving someone sent an email


3.2 THREATS AND ATTACKS
───────────────────────────────────────────────────────────────────────────────

TYPES OF THREATS:

1. MALWARE (Malicious Software):
   - Viruses
   - Worms
   - Trojans
   - Ransomware
   - Spyware
   - Adware

2. NETWORK ATTACKS:
   - DDoS (Distributed Denial of Service)
   - Man-in-the-Middle (MITM)
   - Packet sniffing
   - IP spoofing
   - DNS poisoning

3. WEB APPLICATION ATTACKS:
   - SQL Injection
   - Cross-Site Scripting (XSS)
   - Cross-Site Request Forgery (CSRF)
   - Session hijacking

4. SOCIAL ENGINEERING:
   - Phishing
   - Spear phishing
   - Pretexting
   - Baiting
   - Tailgating

5. PASSWORD ATTACKS:
   - Brute force
   - Dictionary attacks
   - Rainbow tables
   - Credential stuffing

6. INSIDER THREATS:
   - Malicious employees
   - Negligent users
   - Compromised accounts


3.3 VIRUSES
───────────────────────────────────────────────────────────────────────────────

Definition: Malicious code that attaches to legitimate programs and replicates

Characteristics:
- Requires host program
- Needs user action to execute
- Replicates by infecting other files
- Can spread via email, USB, downloads

Types of Viruses:

1. FILE INFECTOR:
   - Attaches to executable files (.exe, .com)
   - Activates when infected program runs

2. BOOT SECTOR:
   - Infects boot sector of hard drive
   - Loads before operating system
   - Very difficult to remove

3. MACRO VIRUS:
   - Infects documents (Word, Excel)
   - Uses macro programming language
   - Spreads via email attachments

4. POLYMORPHIC:
   - Changes code each time it replicates
   - Evades antivirus detection

5. STEALTH:
   - Hides from antivirus software
   - Intercepts system calls

Virus Lifecycle:
1. Infection: Attaches to host
2. Activation: Triggered by event (date, action)
3. Replication: Copies itself to other files
4. Payload: Executes malicious action

Prevention:
- Antivirus software
- Don't open suspicious attachments
- Keep software updated
- Use firewalls
- Regular backups


3.4 WORMS
───────────────────────────────────────────────────────────────────────────────

Definition: Self-replicating malware that spreads without user action

Characteristics:
- Standalone program (no host needed)
- Self-propagating
- Spreads automatically across networks
- Consumes bandwidth and resources

Difference from Virus:
- Virus: Needs host file, requires user action
- Worm: Independent, spreads automatically

Famous Worms:
- Morris Worm (1988): First major worm
- ILOVEYOU (2000): Email worm
- Conficker (2008): Exploited Windows vulnerability
- WannaCry (2017): Ransomware worm

How Worms Spread:
- Email attachments
- Network vulnerabilities
- Instant messaging
- File sharing
- USB drives

Worm Actions:
- Consume network bandwidth
- Delete files
- Install backdoors
- Send spam
- Launch DDoS attacks

Prevention:
- Patch systems regularly
- Use firewalls
- Disable unnecessary services
- Network segmentation
- Intrusion detection systems


3.5 TROJAN HORSES
───────────────────────────────────────────────────────────────────────────────

Definition: Malware disguised as legitimate software

Characteristics:
- Appears harmless or useful
- User voluntarily installs it
- Does NOT self-replicate (unlike viruses/worms)
- Creates backdoor for attackers

Name Origin: Greek mythology (Trojan Horse used to enter Troy)

Types of Trojans:

1. BACKDOOR TROJAN:
   - Provides remote access to attacker
   - Allows full system control

2. BANKING TROJAN:
   - Steals financial information
   - Captures login credentials
   - Modifies web pages

3. DOWNLOADER TROJAN:
   - Downloads additional malware
   - Updates itself

4. RANSOMWARE TROJAN:
   - Encrypts files
   - Demands payment for decryption

5. SPYWARE TROJAN:
   - Monitors user activity
   - Captures keystrokes
   - Takes screenshots

6. ROOTKIT TROJAN:
   - Hides malware presence
   - Provides persistent access

Distribution Methods:
- Email attachments
- Fake software downloads
- Pirated software
- Malicious websites
- Social engineering

Prevention:
- Download software from trusted sources only
- Use antivirus software
- Be cautious with email attachments
- Keep software updated
- Use firewalls


3.6 FIREWALLS
───────────────────────────────────────────────────────────────────────────────

Definition: Security system that monitors and controls network traffic

Purpose:
- Block unauthorized access
- Allow legitimate traffic
- Act as barrier between trusted and untrusted networks

Firewall Placement:
Internet ← → Firewall ← → Internal Network

Types of Firewalls:

1. PACKET-FILTERING FIREWALL:
   - Examines packet headers
   - Checks: Source IP, Destination IP, Port, Protocol
   - Fast but limited
   - Stateless (doesn't track connections)

2. STATEFUL INSPECTION FIREWALL:
   - Tracks connection state
   - Remembers previous packets
   - More secure than packet-filtering
   - Most common type

3. PROXY FIREWALL (Application-Level):
   - Acts as intermediary
   - Inspects application-layer data
   - Hides internal IP addresses
   - Slower but more secure

4. NEXT-GENERATION FIREWALL (NGFW):
   - Deep packet inspection
   - Application awareness
   - Intrusion prevention
   - Malware detection
   - SSL/TLS inspection

5. SOFTWARE FIREWALL:
   - Installed on individual computers
   - Windows Firewall, iptables (Linux)
   - Protects single device

6. HARDWARE FIREWALL:
   - Dedicated physical device
   - Protects entire network
   - Higher performance

Firewall Rules:
- Allow: Permit traffic
- Deny: Block traffic
- Log: Record traffic for analysis

Rule Components:
- Source address
- Destination address
- Port number
- Protocol (TCP, UDP, ICMP)
- Action (allow/deny)

Example Rules:
- Allow HTTP (port 80) from anywhere
- Allow HTTPS (port 443) from anywhere
- Deny all other incoming traffic
- Allow all outgoing traffic

Firewall Limitations:
- Cannot protect against:
  - Insider threats
  - Social engineering
  - Malware in allowed traffic
  - Attacks through allowed ports
  - Physical security breaches

Best Practices:
- Default deny policy (block everything, allow specific)
- Regular rule reviews
- Log monitoring
- Keep firmware updated
- Use multiple layers (defense-in-depth)


═══════════════════════════════════════════════════════════════════════════════
QUICK REFERENCE SUMMARY
═══════════════════════════════════════════════════════════════════════════════

NETWORK TYPES:
PAN < LAN < MAN < WAN (size)

BEST TOPOLOGY:
Star (for small business)

BEST TRANSMISSION MODE:
Full-Duplex (modern networks)

KEY DEVICES:
- Switch: Connects devices in LAN
- Router: Connects networks, gateway to Internet
- Firewall: Security barrier

INTERNET COMPONENTS:
- ISP: Provides internet access
- DNS: Translates domain names → IP addresses
- Browser: Accesses websites
- Search Engine: Finds information

SECURITY PRINCIPLES (CIA):
- Confidentiality: Only authorized access
- Integrity: Data accuracy
- Availability: System uptime

MALWARE TYPES:
- Virus: Needs host, requires user action
- Worm: Self-replicating, spreads automatically
- Trojan: Disguised as legitimate software

PROTECTION:
- Firewall: Network security
- Antivirus: Malware detection
- Encryption: Data protection
- Backups: Disaster recovery

═══════════════════════════════════════════════════════════════════════════════
END OF LEARNING NOTES
═══════════════════════════════════════════════════════════════════════════════
