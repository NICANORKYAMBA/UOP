# Building the Network for a Smart Campus

**Course:** CS 2204 Communications and Networking
**Student:** Nicanor Maswili
**Due:** November 18, 2026

## Topologies, Efficiency, and Reliability

A bus shares one cable, so one break affects everyone, and a ring fails with one link unless it has a second ring. A star connects each device to a switch, so one bad cable affects only one device, but the switch becomes a single point of failure. A mesh gives several paths and the best fault tolerance, at a higher cost (Make It Easy Education, 2021). Dordal (2023, Section 1.5) explains the trade-off: a loop-free tree has exactly one path between nodes, so any broken link splits the network, while redundant paths need protocols that choose a route and switch over when a link fails. For the campus I would use a hybrid design: star networks inside each building, linked by a partial mesh of fiber between the core switches. To remove single points of failure, each building switch gets two uplinks to two core switches. The design scales by adding access switches and stays connected if one link or core switch fails.

## Integrating PANs, MANs, and WANs

Each network type serves a different range (Code-exe, 2020). PANs link phones, wearables, and Bluetooth sensors on shuttles and in parking spaces. These reach the campus LAN through Wi-Fi, a city MAN links traffic cameras, bus stops, and public Wi-Fi access points, and a WAN connects everything to cloud servers.

- **Real-time traffic monitoring:** cameras and road sensors send counts over the MAN, so traffic lights near campus adjust their timing and cut congestion.
- **Intelligent transportation:** a shuttle's GPS position travels to a cloud service and back to students' phones as a live arrival time.
- **Public Wi-Fi:** access points on the MAN give free internet at bus stops, and the same network can push emergency alerts, which improves safety.

## Protocols and Layers

When a student opens a page, Ethernet (or Wi-Fi) moves frames to the nearest switch using MAC addresses, which is the OSI data link and physical layers, or the TCP/IP network access layer (CertBros, 2020). IP gives every device an address and routes packets out to the internet (network or internet layer). TCP splits data into segments, numbers them, and resends lost ones (transport layer), and HTTP requests the page (application layer).

| Task | Key OSI layers | Key TCP/IP layers | Why |
|---|---|---|---|
| File sharing | Transport (4) | Transport | TCP must deliver every byte |
| Web browsing | Application (7) | Application | HTTP/HTTPS and DNS over TCP |
| Video conferencing | Session (5), Presentation (6), Transport (4) | Application, Transport | Call setup, compression, low delay |

Video is the hardest case. Dordal (2023, Sections 7.2 and 7.3.2) notes that queuing makes delay vary and that routers can give real-time traffic priority over large bulk packets.

**Question for the class:** If the campus gives video calls priority over large downloads, how would you keep the downloads from being slowed to a crawl during busy hours?

## References

CertBros. (2020, April 21). *TCP/IP model explained | Cisco CCNA 200-301* [Video]. YouTube. https://www.youtube.com/watch?v=OTwp3xtd4dg

Code-exe. (2020, October 10). *Networks - Episode 2 | LAN, WAN & PAN* [Video]. YouTube. https://www.youtube.com/watch?v=IXkMgGhUcgE

Dordal, P. L. (2023). *An introduction to computer networks* (2nd ed.). http://intronetworks.cs.luc.edu/current2/html/index.html

Make It Easy Education. (2021, April 7). *Computer networks topology || Mesh, bus, star, ring, and hybrid topology* [Video]. YouTube. https://www.youtube.com/watch?v=mpFWIZ318eQ
