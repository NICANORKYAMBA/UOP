# Building the Network for a Smart Campus

**Course:** CS 2204 Communications and Networking
**Student:** Nicanor Maswili
**Due:** November 18, 2026

## Topologies, Efficiency, and Reliability

A bus shares one cable, so a single break or heavy traffic affects everyone, and a ring stops working when one link fails unless it has a second ring. A star connects each device to a switch, so one bad cable affects only one device, but the switch becomes a single point of failure. A mesh gives several paths and the best fault tolerance, at a higher cost in links and setup (Make It Easy Education, 2021). Dordal (2023, Section 1.5) explains the trade-off: a loop-free tree has exactly one path between nodes, so any broken link splits the network, while redundant paths need protocols that choose a route and switch over when a link fails. For the campus I would use a hybrid design: star networks inside each building, linked by a partial mesh of fiber between the core switches. This scales by adding switches and keeps the campus connected if one link goes down.

## Integrating PANs, MANs, and WANs

Each network type serves a different range (Code-exe, 2020). PANs link phones, wearables, and Bluetooth sensors on a shuttle or in a parking space. Those devices reach the campus LAN through Wi-Fi, a city MAN carries data between campus traffic cameras, bus stops, and public Wi-Fi access points, and a WAN connects everything to cloud servers. A shuttle's position can then travel from a sensor to a cloud service and back to every student's phone within seconds. The benefits are smart traffic lights that cut congestion, faster safety alerts, and free Wi-Fi in public spaces.

## Protocols and Layers

When a student opens a course page, Ethernet (or Wi-Fi) moves frames to the nearest switch using MAC addresses, which is the OSI data link and physical layers, or the TCP/IP network access layer (CertBros, 2020). IP gives every device an address and routes packets out to the internet (network or internet layer). TCP splits data into segments, numbers them, and resends lost ones (transport layer), and HTTP requests the page (application layer).

The most relevant layers depend on the task:

- **File sharing** relies on the transport layer, since TCP must deliver every byte correctly.
- **Web browsing** relies on the application layer (HTTP and HTTPS, plus DNS), running over TCP.
- **Video conferencing** cares most about delay. Dordal (2023, Sections 7.2 and 7.3.2) notes that delay varies with queuing and that routers can give real-time traffic priority over large bulk packets. The OSI session and presentation layers, which handle the call session and compression, sit inside the TCP/IP application layer.

**Question for the class:** If the campus gives video calls priority over large downloads, how would you keep the downloads from being slowed to a crawl during busy hours?

## References

CertBros. (2020, April 21). *TCP/IP model explained | Cisco CCNA 200-301* [Video]. YouTube. https://www.youtube.com/watch?v=OTwp3xtd4dg

Code-exe. (2020, October 10). *Networks - Episode 2 | LAN, WAN & PAN* [Video]. YouTube. https://www.youtube.com/watch?v=IXkMgGhUcgE

Dordal, P. L. (2023). *An introduction to computer networks* (2nd ed.). http://intronetworks.cs.luc.edu/current2/html/index.html

Make It Easy Education. (2021, April 7). *Computer networks topology || Mesh, bus, star, ring, and hybrid topology* [Video]. YouTube. https://www.youtube.com/watch?v=mpFWIZ318eQ
