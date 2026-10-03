# Layers of Memory: How Computers Trade Speed, Size, and Cost

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** October 7, 2026

No single type of memory is fast, large, cheap, and permanent all at once, so modern computers
stack several types into a hierarchy. Kumar (2025) presents this hierarchy as a central part of
system design because it largely decides how fast and efficient a computer feels.

## How Computers Organize Memory to Boost Performance

Think of the hierarchy as a pyramid. At the top are the CPU's registers, then the cache levels
L1, L2, and L3, then main memory (RAM), and at the bottom secondary storage such as SSDs and hard
drives. Each step down is larger and cheaper per byte but slower. McClanahan (n.d.) points out
that the processor can only work directly with data held in its cache, which must be filled from
RAM, and because RAM loses its contents when the power is off, everything permanent has to live
in secondary storage. Data therefore moves up the pyramid on demand: from the SSD into RAM when a
program opens, and from RAM into the cache when the CPU needs it.

The reason a small cache can serve a huge program is locality. Temporal locality means data used
recently is likely to be used again soon, and spatial locality means data stored near something
just used is likely to be needed next (McClanahan, n.d.; Watkins, 2017). A simple example is a
loop adding up the numbers in an array. The loop counter is touched on every pass (temporal),
and the array elements sit side by side in memory (spatial), so when the cache loads one block it
brings in the next few elements for free. Watkins (2017) shows how designers measure the payoff
with the hit rate: if most requests are found in the cache, the average access time stays close
to the cache's speed even though RAM is many times slower.

The same idea explains a slowdown most of us have seen. When too many programs are open, RAM
fills up and the operating system starts moving pages out to the SSD. Every time those pages are
needed again, the CPU waits on storage that is far slower than RAM, and the whole computer
crawls. One more piece sits outside the pyramid: ROM or flash firmware holds the start-up
instructions, because when the power comes on RAM is empty and something non-volatile must tell
the processor what to do first.

## Combining Memory Types to Match a System's Needs

**Smartphone.** A phone pairs a modest amount of low-power RAM with fast flash storage and no
hard drive at all. The benefits are long battery life, a thin body, and no moving parts. The
trade-off is that RAM is limited, so the operating system closes background apps to free memory,
which is why an app sometimes restarts from scratch when you switch back to it.

**Gaming PC or workstation.** Here a CPU with a large L3 cache is paired with 32 GB or more of
RAM, a fast NVMe SSD for the operating system and current games, and a big hard drive for photo
and video archives. The fast tiers keep active work smooth, while the hard drive gives cheap
capacity for files that are rarely opened. The trade-offs are higher cost and some management,
since the user has to decide what lives on the fast drive and what can sit on the slow one.

**Embedded controller.** A microwave, a smart door lock, or a car's airbag controller uses a few
kilobytes of SRAM and firmware in ROM or flash, with no secondary storage. This makes the device
cheap, instant-on, and predictable, which matters when timing must be guaranteed. The trade-off
is that it can only run small, fixed software, and updating it means reprogramming the firmware.
This week's assignment shows the same idea in hardware: the combination lock I designed stores
its whole decision table in a ROM used as a programmable logic device.

Across all three cases, the designer matches each memory type to the job it does best: the
fastest memory for what is used constantly, the cheapest memory for what is stored long term,
and non-volatile memory for anything that must survive a power cut.

**Question for the class:** SSDs are now fast enough that some games load in seconds. Do you
think future computers could merge RAM and secondary storage into one fast, non-volatile tier,
and what would we gain or lose if the separate RAM level disappeared?

Word count: 735

## References

Kumar, P. V. (2025). *Kickstart operating system design: Master operating system design from
core concepts to cutting-edge applications for real-time, mobile, and network systems* (English
ed.). Orange Education. https://proxy.lirn.net/UnivOfThePeople?groupID=2&qurl=https%3A%2F%2Febookcentral.proquest.com%2Flib%2Funiv-people-ebooks%2Fdetail.action%3FdocID%3D31914761

McClanahan, P. (n.d.). *5.1: Memory hierarchy*. In *Introduction to operating systems*.
LibreTexts. https://eng.libretexts.org/Courses/Delta_College/Introduction_to_Operating_Systems/05:_Computer_Architecture_-_Memory/5.01:_Memory_Hierarchy

Watkins, M. (2017, March 29). *Memory hierarchy introduction* [Video]. YouTube.
https://www.youtube.com/watch?v=_kZY4orPQW0
