# CS 2204 Unit 1 Learning Notes: Communication and Networks

Main reading: Dordal (2023), *An Introduction to Computer Networks*, Sections 1.1 to 1.5, 1.9, 5.5, 7.1 to 7.3.

## Data communication components
Message, sender, receiver, transmission medium (cable, fiber, radio), and protocol (the agreed rules).

## Network types
| Type | Range | Example |
|---|---|---|
| PAN | A few metres | Bluetooth earbuds, smartwatch |
| LAN | Room or building | Office Ethernet, home Wi-Fi |
| CAN (campus area) | Several buildings | University campus |
| MAN | A city | City fiber ring, public Wi-Fi |
| WAN | Countries and continents | The internet, company links between cities |

## Topologies
| Topology | Strength | Weakness |
|---|---|---|
| Bus | Cheap, little cable | One break or busy line affects all |
| Ring | Orderly, predictable | One failure breaks it (unless dual ring) |
| Star | Easy to add devices, one cable fault affects one device | Central switch is a single point of failure |
| Mesh | Redundant paths, best fault tolerance | Many links, expensive |
| Tree / Hybrid | Scales well, mixes strengths | More complex to design |

Dordal (Section 1.5): a loop-free tree has one path between nodes, so any broken link splits the network. Redundancy needs routing protocols to choose paths. Ethernet prefers trees; IP supports redundancy.

## OSI vs TCP/IP
| OSI layer | Job | TCP/IP layer | Examples |
|---|---|---|---|
| 7 Application | Services for users | Application | HTTP, DNS, FTP, SMTP |
| 6 Presentation | Format, encryption, compression | Application | TLS, JPEG |
| 5 Session | Start, manage, end sessions | Application | RPC, NetBIOS |
| 4 Transport | End-to-end delivery, ports | Transport | TCP (reliable), UDP (fast) |
| 3 Network | Logical addressing, routing | Internet | IP, ICMP |
| 2 Data link | Frames, MAC addresses | Network access | Ethernet, Wi-Fi (802.11) |
| 1 Physical | Bits as signals | Network access | Cables, radio, fiber |

Dordal uses a five-layer model: physical, LAN (link), IP, transport, application.

## Key data terms
- **Bandwidth:** the link's raw data rate. **Throughput:** the rate actually achieved.
- **Packet:** a chunk of data with headers. **Datagram forwarding:** each packet is routed by its destination address.
- **Delay types:** bandwidth (transmission) delay, propagation delay, queuing delay; queuing causes most variability (jitter).
- **ATM:** fixed 53-byte cells, virtual circuits.
- **Analog vs digital:** analog is continuous (infinite values in a range), digital is discrete. **Modulation:** digital data onto an analog carrier.
