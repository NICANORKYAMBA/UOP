# Unit 6 Learning Notes - Part 1: Network Fundamentals

## Course Information
- **Course**: CS1111 Computer Science Fundamentals
- **Unit**: 6 - Computer Networks and Security
- **Topic**: Network Types, Topologies, Transmission Modes, and Connecting Devices
- **Author**: Nicanor Kyamba
- **Date**: January 2025

---

## Table of Contents
1. [Introduction to Computer Networks](#introduction-to-computer-networks)
2. [Types of Networks](#types-of-networks)
3. [Network Topologies](#network-topologies)
4. [Transmission Modes](#transmission-modes)
5. [Network Connecting Devices](#network-connecting-devices)
6. [Network Protocols](#network-protocols)
7. [Comparison Tables](#comparison-tables)

---

## Introduction to Computer Networks

### What is a Computer Network?

A **computer network** is a collection of interconnected devices (computers, servers, printers, etc.) that can communicate and share resources with each other.

### Key Components

1. **Nodes**: Devices connected to the network (computers, servers, printers)
2. **Links**: Physical or wireless connections between nodes
3. **Protocols**: Rules governing communication between devices
4. **Network Interface Cards (NICs)**: Hardware enabling network connectivity
5. **Transmission Media**: Cables (copper, fiber optic) or wireless signals

### Purpose of Networks

- **Resource Sharing**: Printers, files, storage, applications
- **Communication**: Email, messaging, video conferencing
- **Data Transfer**: File sharing, backup, synchronization
- **Centralized Management**: Easier administration and security
- **Cost Efficiency**: Shared resources reduce hardware costs

### Network Evolution

1. **1960s**: ARPANET (first packet-switching network)
2. **1970s**: Ethernet developed by Xerox PARC
3. **1980s**: TCP/IP protocol standardized
4. **1990s**: World Wide Web emerges
5. **2000s**: Wireless networks (Wi-Fi) become mainstream
6. **2010s-Present**: Cloud computing, IoT, 5G networks

---

## Types of Networks

Networks are classified based on **geographical coverage**, **ownership**, and **purpose**.

### 1. Personal Area Network (PAN)

**Definition**: Network for personal devices within a very short range (typically 10 meters).

**Characteristics**:
- **Range**: Up to 10 meters (33 feet)
- **Devices**: Smartphones, tablets, laptops, wearables, wireless headphones
- **Technology**: Bluetooth, USB, Infrared
- **Ownership**: Individual user

**Examples**:
- Bluetooth connection between phone and wireless earbuds
- Smartwatch syncing with smartphone
- Wireless keyboard/mouse connected to computer
- File transfer between phone and laptop via Bluetooth

**Advantages**:
- Easy to set up
- Low cost
- Portable
- No infrastructure required

**Disadvantages**:
- Very limited range
- Low data transfer rates
- Limited number of devices

---

### 2. Local Area Network (LAN)

**Definition**: Network connecting devices within a limited geographical area (building, campus, office).

**Characteristics**:
- **Range**: Up to 1-2 kilometers
- **Devices**: Computers, printers, servers, switches
- **Technology**: Ethernet (wired), Wi-Fi (wireless)
- **Ownership**: Private (organization, home)
- **Speed**: 100 Mbps to 10 Gbps

**Examples**:
- Office network connecting employee computers
- Home network with multiple devices
- School computer lab
- Hospital network connecting medical equipment

**Advantages**:
- High data transfer rates
- Low latency
- Easy resource sharing
- Centralized data management
- Cost-effective for small areas

**Disadvantages**:
- Limited geographical coverage
- Requires infrastructure (cables, switches)
- Security risks if not properly configured

**LAN Technologies**:
- **Ethernet**: Wired LAN using twisted-pair or fiber optic cables
- **Wi-Fi**: Wireless LAN using radio waves (802.11 standards)
- **Token Ring**: Legacy technology (rarely used today)

---

### 3. Metropolitan Area Network (MAN)

**Definition**: Network covering a city or large campus (larger than LAN, smaller than WAN).

**Characteristics**:
- **Range**: 5-50 kilometers (city-wide)
- **Devices**: Multiple LANs interconnected
- **Technology**: Fiber optic cables, microwave links
- **Ownership**: Private or public (ISP, government)
- **Speed**: 100 Mbps to 1 Gbps

**Examples**:
- City-wide Wi-Fi network
- Cable TV network
- University campus network spanning multiple buildings
- Government network connecting city departments

**Advantages**:
- Covers larger area than LAN
- High-speed connectivity
- Centralized management for city services
- Cost-effective for metropolitan areas

**Disadvantages**:
- Expensive to set up and maintain
- Requires significant infrastructure
- Complex management

---

### 4. Wide Area Network (WAN)

**Definition**: Network spanning large geographical areas (countries, continents, global).

**Characteristics**:
- **Range**: Unlimited (global coverage)
- **Devices**: Multiple LANs and MANs interconnected
- **Technology**: Leased lines, satellites, fiber optic cables
- **Ownership**: Multiple organizations, ISPs, telecom companies
- **Speed**: Varies (1 Mbps to 100+ Gbps)

**Examples**:
- **The Internet**: Largest WAN connecting billions of devices worldwide
- Corporate network connecting branch offices across countries
- Banking network connecting ATMs and branches globally
- Military network connecting bases worldwide

**Advantages**:
- Global connectivity
- Centralized data for distributed organizations
- Remote access to resources
- Enables cloud computing

**Disadvantages**:
- Expensive to establish and maintain
- Lower speeds compared to LAN
- Higher latency
- Complex security challenges
- Dependent on third-party providers (ISPs)

**WAN Technologies**:
- **Leased Lines**: Dedicated point-to-point connections
- **MPLS (Multiprotocol Label Switching)**: High-performance routing
- **VPN (Virtual Private Network)**: Secure connections over public internet
- **Satellite**: Remote area connectivity
- **Frame Relay**: Legacy packet-switching technology

---

### Network Classification Summary

| Network Type | Range | Speed | Cost | Use Case |
|--------------|-------|-------|------|----------|
| **PAN** | 0-10 m | Low (1-3 Mbps) | Very Low | Personal devices |
| **LAN** | 0-2 km | High (100 Mbps-10 Gbps) | Low-Medium | Office, home, school |
| **MAN** | 5-50 km | Medium-High (100 Mbps-1 Gbps) | Medium-High | City-wide services |
| **WAN** | Unlimited | Variable (1 Mbps-100 Gbps) | High | Global connectivity |

---

## Network Topologies

**Network topology** refers to the physical or logical arrangement of devices (nodes) and connections (links) in a network.

### Types of Topologies

1. **Physical Topology**: Actual physical layout of cables and devices
2. **Logical Topology**: How data flows through the network

---

### 1. Bus Topology

**Description**: All devices connected to a single central cable (backbone/bus).

**Structure**:
```
[Device 1] ---- [Device 2] ---- [Device 3] ---- [Device 4]
                    |
                [Backbone Cable]
```

**Characteristics**:
- Single cable acts as shared communication medium
- Terminators at both ends prevent signal reflection
- Data travels in both directions
- All devices receive transmitted data (only intended recipient processes it)

**Advantages**:
- Easy to install and extend
- Requires less cable than star topology
- Cost-effective for small networks
- Simple design

**Disadvantages**:
- Single point of failure (backbone cable)
- Performance degrades with more devices
- Difficult to troubleshoot
- Limited cable length
- Collisions can occur (requires CSMA/CD)

**Use Cases**:
- Small networks (10-15 devices)
- Temporary setups
- Legacy systems (rarely used today)

---

### 2. Star Topology

**Description**: All devices connected to a central hub or switch.

**Structure**:
```
        [Device 1]
             |
[Device 2] - [Hub/Switch] - [Device 3]
             |
        [Device 4]
```

**Characteristics**:
- Central device manages all communication
- Each device has dedicated connection to hub/switch
- Data passes through central device
- Most common topology in modern LANs

**Advantages**:
- Easy to install and manage
- Failure of one device doesn't affect others
- Easy to detect and isolate faults
- Easy to add/remove devices
- Better performance (switch-based)
- Centralized management

**Disadvantages**:
- Single point of failure (central hub/switch)
- Requires more cable than bus topology
- Cost of central device
- Limited by hub/switch capacity

**Use Cases**:
- Office networks
- Home networks
- Most modern LANs
- Ethernet networks

---

### 3. Ring Topology

**Description**: Devices connected in a circular fashion, forming a closed loop.

**Structure**:
```
[Device 1] ---- [Device 2]
    |               |
[Device 4] ---- [Device 3]
```

**Characteristics**:
- Data travels in one direction (unidirectional) or both (bidirectional)
- Each device acts as a repeater
- Token passing protocol often used
- No collisions (controlled access)

**Advantages**:
- Equal access for all devices
- No collisions (token-based)
- Predictable performance
- Can handle high traffic better than bus

**Disadvantages**:
- Single device failure can break entire network (unidirectional)
- Difficult to troubleshoot
- Adding/removing devices disrupts network
- More expensive than bus topology

**Use Cases**:
- Token Ring networks (legacy)
- FDDI (Fiber Distributed Data Interface)
- SONET/SDH networks (telecom)

**Variants**:
- **Single Ring**: Data flows in one direction
- **Dual Ring**: Data flows in both directions (fault tolerance)

---

### 4. Mesh Topology

**Description**: Every device connected to every other device (full mesh) or some devices (partial mesh).

**Structure (Full Mesh)**:
```
[Device 1] ---- [Device 2]
    |  \      /  |
    |   \    /   |
    |    \  /    |
[Device 3] ---- [Device 4]
```

**Characteristics**:
- Multiple paths between devices
- High redundancy and reliability
- No single point of failure
- Complex cabling

**Full Mesh**:
- Every device connected to every other device
- Number of connections = n(n-1)/2 (where n = number of devices)
- Example: 5 devices = 5(4)/2 = 10 connections

**Partial Mesh**:
- Some devices connected to multiple devices
- Critical devices have redundant connections
- More practical than full mesh

**Advantages**:
- High reliability and redundancy
- No single point of failure
- Multiple paths for data (load balancing)
- Fault tolerance
- High security (dedicated links)

**Disadvantages**:
- Very expensive (cabling, ports)
- Complex installation and maintenance
- Requires many ports per device
- Difficult to manage

**Use Cases**:
- Critical infrastructure (military, finance)
- Backbone networks
- Wireless mesh networks (Wi-Fi)
- Internet backbone (partial mesh)

---

### 5. Tree Topology (Hierarchical)

**Description**: Combination of star topologies arranged in a hierarchy.

**Structure**:
```
            [Root Hub]
           /          \
    [Hub 1]            [Hub 2]
     /    \            /    \
[Dev 1] [Dev 2]   [Dev 3] [Dev 4]
```

**Characteristics**:
- Hierarchical structure (root, branches, leaves)
- Combines multiple star topologies
- Scalable design
- Used in large organizations

**Advantages**:
- Scalable (easy to expand)
- Hierarchical management
- Fault isolation (branch failure doesn't affect others)
- Supports multiple hardware/software vendors

**Disadvantages**:
- Root hub failure affects entire network
- Requires more cable than star
- Complex configuration
- Expensive

**Use Cases**:
- Large organizations with departments
- University campus networks
- Corporate networks with branches

---

### 6. Hybrid Topology

**Description**: Combination of two or more different topologies.

**Examples**:
- **Star-Bus**: Multiple star networks connected via bus backbone
- **Star-Ring**: Star networks connected in ring configuration
- **Tree-Mesh**: Hierarchical structure with mesh at critical points

**Advantages**:
- Flexible design
- Scalable
- Combines benefits of multiple topologies
- Fault tolerance

**Disadvantages**:
- Complex design and management
- Expensive
- Difficult to troubleshoot

**Use Cases**:
- Large enterprise networks
- ISP networks
- Data centers

---

### Topology Comparison Table

| Topology | Cost | Reliability | Scalability | Performance | Fault Tolerance | Use Case |
|----------|------|-------------|-------------|-------------|-----------------|----------|
| **Bus** | Low | Low | Poor | Degrades | Poor | Small networks |
| **Star** | Medium | Medium | Good | Good | Medium | Office LANs |
| **Ring** | Medium | Medium | Medium | Good | Poor-Medium | Legacy systems |
| **Mesh** | Very High | Very High | Poor | Excellent | Excellent | Critical systems |
| **Tree** | High | Medium | Excellent | Good | Medium | Large organizations |
| **Hybrid** | High | High | Excellent | Good | High | Enterprise networks |

---

## Transmission Modes

**Transmission mode** refers to the direction of data flow between devices in a network.

### 1. Simplex Mode

**Definition**: Data flows in **one direction only** (unidirectional).

**Characteristics**:
- One device transmits, other receives
- No reverse communication
- Full bandwidth available for one direction

**Diagram**:
```
[Sender] =========> [Receiver]
         (One-way)
```

**Examples**:
- **Keyboard to Computer**: Keyboard sends input, doesn't receive
- **Traditional Radio/TV Broadcasting**: Station transmits, receivers listen
- **Computer to Printer**: Computer sends print jobs
- **Sensors to Monitoring System**: Temperature sensor sends data

**Advantages**:
- Simple implementation
- Full bandwidth utilization in one direction
- Cost-effective

**Disadvantages**:
- No feedback or acknowledgment
- Cannot detect errors easily
- Limited use cases

---

### 2. Half-Duplex Mode

**Definition**: Data flows in **both directions, but not simultaneously** (bidirectional, one at a time).

**Characteristics**:
- Both devices can transmit and receive
- Only one device transmits at a time
- Requires switching between send/receive modes
- Full bandwidth available when transmitting

**Diagram**:
```
[Device A] <=======> [Device B]
           (Two-way, alternating)
```

**Examples**:
- **Walkie-Talkies**: Press button to talk, release to listen
- **CB Radio**: One person talks at a time
- **Old Ethernet (10BASE-T with hubs)**: CSMA/CD protocol
- **Intercom Systems**: Push-to-talk functionality

**Advantages**:
- Two-way communication
- Full bandwidth when transmitting
- More efficient than simplex

**Disadvantages**:
- Delay in switching between modes
- Cannot send and receive simultaneously
- Potential for collisions (requires protocols like CSMA/CD)

---

### 3. Full-Duplex Mode

**Definition**: Data flows in **both directions simultaneously** (bidirectional, concurrent).

**Characteristics**:
- Both devices can transmit and receive at the same time
- No switching required
- Requires separate channels for each direction
- Most efficient transmission mode

**Diagram**:
```
[Device A] ========> [Device B]
           <========
           (Two-way, simultaneous)
```

**Examples**:
- **Telephone Conversations**: Both parties can talk simultaneously
- **Modern Ethernet (switches)**: Dedicated send/receive pairs
- **Fiber Optic Networks**: Separate fibers for each direction
- **Video Conferencing**: Audio/video sent and received simultaneously
- **Cell Phone Calls**: Full-duplex communication

**Advantages**:
- Most efficient (no waiting)
- Faster communication
- Better user experience
- No collisions

**Disadvantages**:
- More complex implementation
- Requires more bandwidth/channels
- Higher cost

---

### Transmission Mode Comparison

| Feature | Simplex | Half-Duplex | Full-Duplex |
|---------|---------|-------------|-------------|
| **Direction** | One-way | Two-way (alternating) | Two-way (simultaneous) |
| **Bandwidth Usage** | 100% one direction | 100% alternating | 50% each direction |
| **Complexity** | Simple | Medium | Complex |
| **Cost** | Low | Medium | High |
| **Efficiency** | Low | Medium | High |
| **Examples** | Keyboard, TV | Walkie-talkie | Telephone, Ethernet |
| **Feedback** | No | Yes (delayed) | Yes (immediate) |

---

## Network Connecting Devices

Network devices facilitate communication, manage traffic, and connect different network segments.

### 1. Network Interface Card (NIC)

**Definition**: Hardware component that connects a device to a network.

**Functions**:
- Converts data into electrical/optical signals
- Provides MAC address (unique identifier)
- Implements data link layer protocols

**Types**:
- **Wired NIC**: Ethernet port (RJ-45)
- **Wireless NIC**: Wi-Fi adapter (802.11)

**Characteristics**:
- **MAC Address**: 48-bit unique identifier (e.g., 00:1A:2B:3C:4D:5E)
- **Speed**: 10/100/1000 Mbps (Gigabit Ethernet)
- **Layer**: Physical and Data Link Layer (OSI Layer 1 & 2)

---

### 2. Hub

**Definition**: Basic networking device that connects multiple devices in a star topology.

**Functions**:
- Receives data on one port
- Broadcasts to all other ports
- No intelligence (doesn't filter or route)

**Characteristics**:
- **OSI Layer**: Physical Layer (Layer 1)
- **Operation**: Broadcast (all ports receive data)
- **Collision Domain**: Single collision domain (all devices share bandwidth)
- **Speed**: 10/100 Mbps
- **Status**: Obsolete (replaced by switches)

**Types**:
- **Passive Hub**: No signal amplification
- **Active Hub**: Amplifies and regenerates signals

**Advantages**:
- Simple and inexpensive
- Easy to install

**Disadvantages**:
- Inefficient (broadcasts to all devices)
- Security risk (all devices see all traffic)
- Performance degrades with more devices
- Collisions occur frequently

**Use Cases**:
- Legacy networks (rarely used today)
- Small home networks (historical)

---

### 3. Switch

**Definition**: Intelligent networking device that connects devices and forwards data based on MAC addresses.

**Functions**:
- Learns MAC addresses of connected devices
- Forwards data only to intended recipient
- Creates separate collision domains for each port
- Filters traffic based on MAC address table

**Characteristics**:
- **OSI Layer**: Data Link Layer (Layer 2)
- **Operation**: Unicast (targeted forwarding)
- **Collision Domain**: Separate per port
- **Speed**: 100 Mbps to 100 Gbps
- **Intelligence**: MAC address learning and filtering

**How Switches Work**:
1. **Learning**: Records MAC addresses and associated ports
2. **Forwarding**: Sends data only to destination port
3. **Filtering**: Blocks unnecessary traffic
4. **Flooding**: Broadcasts if destination unknown

**Types**:
- **Unmanaged Switch**: Plug-and-play, no configuration
- **Managed Switch**: Configurable (VLANs, QoS, security)
- **Layer 3 Switch**: Routing capabilities (IP-based)

**Advantages**:
- Efficient (targeted forwarding)
- Better performance than hubs
- Separate collision domains
- Improved security
- Full-duplex support

**Disadvantages**:
- More expensive than hubs
- Managed switches require configuration

**Use Cases**:
- Modern LANs (offices, homes, data centers)
- Enterprise networks
- All Ethernet networks today

---

### 4. Router

**Definition**: Device that connects different networks and routes data based on IP addresses.

**Functions**:
- Connects multiple networks (LAN to WAN, LAN to LAN)
- Routes data packets based on IP addresses
- Determines best path for data transmission
- Provides network address translation (NAT)
- Implements firewall and security features

**Characteristics**:
- **OSI Layer**: Network Layer (Layer 3)
- **Operation**: Routing based on IP addresses
- **Broadcast Domain**: Separates broadcast domains
- **Intelligence**: Routing tables, protocols (RIP, OSPF, BGP)
- **Features**: NAT, DHCP, firewall, VPN

**How Routers Work**:
1. **Receives packet**: Examines destination IP address
2. **Consults routing table**: Determines best path
3. **Forwards packet**: Sends to next hop or destination
4. **Updates tables**: Learns network topology

**Types**:
- **Home Router**: Connects home network to ISP
- **Enterprise Router**: Connects corporate networks
- **Core Router**: Backbone of internet (ISP networks)
- **Edge Router**: Connects organization to external networks

**Advantages**:
- Connects different networks
- Intelligent path selection
- Security features (firewall, NAT)
- Broadcast domain separation
- Supports multiple protocols

**Disadvantages**:
- More expensive than switches
- Complex configuration
- Higher latency than switches

**Use Cases**:
- Connecting LAN to internet
- Connecting multiple LANs
- Inter-office connectivity (WAN)
- ISP networks

---

### 5. Bridge

**Definition**: Device that connects two network segments and filters traffic based on MAC addresses.

**Functions**:
- Divides large network into smaller segments
- Filters traffic between segments
- Reduces collisions
- Extends network distance

**Characteristics**:
- **OSI Layer**: Data Link Layer (Layer 2)
- **Operation**: MAC address filtering
- **Collision Domain**: Separates collision domains
- **Status**: Largely replaced by switches

**Advantages**:
- Reduces network congestion
- Extends network distance
- Filters traffic

**Disadvantages**:
- Limited to two segments
- Slower than switches
- Obsolete technology

---

### 6. Gateway

**Definition**: Device that connects networks using different protocols.

**Functions**:
- Protocol conversion
- Connects dissimilar networks
- Translates between different architectures

**Characteristics**:
- **OSI Layer**: All layers (Layer 1-7)
- **Operation**: Protocol translation
- **Complexity**: Most complex networking device

**Examples**:
- Email gateway (SMTP to proprietary system)
- VoIP gateway (telephone to IP network)
- IoT gateway (sensor protocols to internet)

**Use Cases**:
- Connecting legacy systems to modern networks
- Protocol translation
- IoT device connectivity

---

### 7. Modem

**Definition**: Device that modulates and demodulates signals for data transmission over telephone lines or cable.

**Functions**:
- Converts digital signals to analog (modulation)
- Converts analog signals to digital (demodulation)
- Enables internet connectivity over phone/cable lines

**Types**:
- **DSL Modem**: Digital Subscriber Line (phone line)
- **Cable Modem**: Coaxial cable (TV cable)
- **Fiber Modem**: Fiber optic connection
- **Dial-up Modem**: Legacy (56 Kbps)

**Use Cases**:
- Home internet connectivity
- ISP connection

---

### 8. Access Point (AP)

**Definition**: Device that allows wireless devices to connect to a wired network.

**Functions**:
- Creates wireless network (Wi-Fi)
- Bridges wireless and wired networks
- Manages wireless clients

**Characteristics**:
- **OSI Layer**: Data Link Layer (Layer 2)
- **Technology**: Wi-Fi (802.11 standards)
- **Range**: 30-100 meters indoors

**Use Cases**:
- Office Wi-Fi networks
- Public Wi-Fi hotspots
- Home wireless networks

---

### 9. Repeater

**Definition**: Device that amplifies and regenerates signals to extend network distance.

**Functions**:
- Receives weak signal
- Amplifies and regenerates
- Retransmits signal

**Characteristics**:
- **OSI Layer**: Physical Layer (Layer 1)
- **Purpose**: Extend network range

**Use Cases**:
- Long-distance cable runs
- Wi-Fi range extenders

---

### Network Device Comparison

| Device | OSI Layer | Function | Intelligence | Use Case |
|--------|-----------|----------|--------------|----------|
| **NIC** | 1, 2 | Network interface | None | Connect device to network |
| **Hub** | 1 | Broadcast | None | Legacy (obsolete) |
| **Switch** | 2 | MAC forwarding | Medium | Modern LANs |
| **Router** | 3 | IP routing | High | Connect networks |
| **Bridge** | 2 | Segment networks | Low | Legacy (obsolete) |
| **Gateway** | 1-7 | Protocol conversion | Very High | Dissimilar networks |
| **Modem** | 1, 2 | Signal conversion | Low | ISP connection |
| **Access Point** | 2 | Wireless connectivity | Medium | Wi-Fi networks |
| **Repeater** | 1 | Signal amplification | None | Extend range |

---

## Network Protocols

### Common Protocols

1. **TCP/IP**: Transmission Control Protocol/Internet Protocol (internet standard)
2. **HTTP/HTTPS**: Web browsing
3. **FTP**: File transfer
4. **SMTP**: Email sending
5. **DNS**: Domain name resolution
6. **DHCP**: Automatic IP address assignment

---

## Comparison Tables

### Network Types Quick Reference

| Aspect | PAN | LAN | MAN | WAN |
|--------|-----|-----|-----|-----|
| **Coverage** | 10 m | 2 km | 50 km | Global |
| **Speed** | 1-3 Mbps | 100 Mbps-10 Gbps | 100 Mbps-1 Gbps | Variable |
| **Ownership** | Personal | Private | Public/Private | Multiple |
| **Example** | Bluetooth | Office | City Wi-Fi | Internet |

### Topology Selection Guide

**Choose Bus when**: Small network, temporary setup, budget-constrained
**Choose Star when**: Office LAN, easy management needed, most common choice
**Choose Ring when**: Legacy system, token-based access required
**Choose Mesh when**: High reliability critical, no single point of failure acceptable
**Choose Tree when**: Large organization, hierarchical structure, scalability needed

---

## Key Takeaways

1. **Network types** classified by geographical coverage (PAN, LAN, MAN, WAN)
2. **Topologies** define physical/logical arrangement (Bus, Star, Ring, Mesh, Tree, Hybrid)
3. **Transmission modes**: Simplex (one-way), Half-duplex (alternating), Full-duplex (simultaneous)
4. **Connecting devices**: Hub (broadcast), Switch (MAC-based), Router (IP-based)
5. **Modern networks** use star topology with switches and routers
6. **Full-duplex** is most efficient transmission mode

---

## Study Tips

1. **Memorize network ranges**: PAN (10m), LAN (2km), MAN (50km), WAN (global)
2. **Understand topology trade-offs**: Cost vs. reliability vs. scalability
3. **Know device layers**: Hub (L1), Switch (L2), Router (L3)
4. **Practice scenarios**: Which topology/device for specific business needs?
5. **Draw diagrams**: Visualize topologies and data flow

---

## References

ALL ABOUT ELECTRONICS. (2024, April 8). *Simplex, half-duplex and full-duplex communication | Transmission modes in communication system* [Video]. YouTube. https://www.youtube.com/watch?v=example

Borodin, V. (Ed.). (2024). *Computer systems application*. Toronto Academic Press.

Neso Academy. (2019, November 8). *Classification of computer networks* [Video]. YouTube. https://www.youtube.com/watch?v=example

Simplilearn. (2022, February 4). *What is network topology? | Types of network topology | BUS, RING, STAR, TREE, MESH | Simplilearn* [Video]. YouTube. https://www.youtube.com/watch?v=example

WhiteboardDoodles. (2024, October 27). *Network devices explained: Routers, switches, hubs & more | Networking basics* [Video]. YouTube. https://www.youtube.com/watch?v=example

---

**Next**: Part 2 - Internet Components (ISP, WWW, DNS, IP Address, Web Browsers, Search Engines)
