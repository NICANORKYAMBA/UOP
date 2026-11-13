# CS 2204 Unit 1: Peer Responses

Author: Nicanor Maswili
Course: CS 2204 Communications and Networking

Post at least **2** replies by Wednesday, November 18 (minimum 75 words, three to four sentences or more). Each reply connects to the classmate's post, answers or extends it, cites the course textbook with a link, and asks a question. Three drafts are provided; pick any two.

---

## Peer Response 1: to Noel Naing Ye Kyaw

Hi Noel,

Your hierarchical star-mesh design matches what I proposed, and your question about cost is a good one. I would not use a full mesh anywhere; redundancy pays off at the core and distribution switches, where one failure would cut off whole buildings. At the access layer, overlapping Wi-Fi coverage is cheaper, because if one access point fails, devices can roam to a neighbouring one. One catch is that Dordal (2023, Section 1.5) explains Ethernet prefers loop-free tree networks, while redundant paths need protocols to choose a route and switch over on failure, so extra switch links only help if those protocols are configured correctly. Would you place the thousands of IoT sensors on their own VLAN to keep their traffic and security risks away from student devices?

Best,
Nicanor

Reference:
Dordal, P. L. (2023). *An introduction to computer networks* (2nd ed.). http://intronetworks.cs.luc.edu/current2/html/intro.html#topology

---

## Peer Response 2: to Abubakar Maryam

Hi Abubakar,

I liked how you followed web browsing through every layer, from HTTP down to Ethernet, because it shows how each layer only talks to the one above and below it. To answer your question, I would choose a hierarchical hybrid: star networks inside each building, connected by a partial mesh between core switches, so a single broken link never isolates a building. I would also add a point about video conferencing. Dordal (2023, Section 7.3.2) explains that once a large bulk packet starts sending, a router cannot interrupt it, so real-time traffic still waits behind it even when it has priority. This is one reason calls feel choppy when the network is busy with downloads. Have you noticed this during video lessons on a shared connection?

Best,
Nicanor

Reference:
Dordal, P. L. (2023). *An introduction to computer networks* (2nd ed.). http://intronetworks.cs.luc.edu/current2/html/packets.html#packet-size-and-real-time-traffic

---

## Peer Response 3: to Temitope Akingbade

Hi Temitope,

Your example of phones receiving traffic updates and alternative routes is a nice way to show the PAN, MAN, and WAN working together for one service. On your question, I would also pick a star-mesh hybrid and reduce the impact of failures in layers: give each building switch two uplinks to two core switches, put core equipment on backup power, and monitor every link so the team is alerted before users notice. In my cloud work we follow the same idea by spreading servers across separate data centres, so one outage never takes down the whole service. Dordal (2023, Section 1.5) supports this, noting that a loop-free network has no redundancy, so any broken link splits it into two parts. How much redundancy do you think a university can realistically afford?

Best,
Nicanor

Reference:
Dordal, P. L. (2023). *An introduction to computer networks* (2nd ed.). http://intronetworks.cs.luc.edu/current2/html/intro.html#topology
