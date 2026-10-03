# CS 1105 Unit 5: Peer Responses

Author: Nicanor Maswili
Course: CS 1105 Digital Electronics & Computer Architecture

You need to post **2** replies by Wednesday (minimum 75 words each). Three drafts are provided
so you can pick the two that fit best. Each one engages the classmate's specific points, adds a
technical idea, answers their question, and ends with a question.

---

## Peer Response 1: to Nankya Joyce Sanyu

Hi Joyce,

Your post explains the hierarchy very clearly, and I liked the everyday example of opening a
browser and several apps at once, because it shows exactly when RAM is doing its job. To answer
your question, a bigger cache raises the hit rate, so the CPU waits on RAM less often. Watkins
(2017) shows why that matters with the average access time: hit time plus miss rate times miss
penalty. The catch is that a larger cache is also slower to search, uses more chip area and power,
and costs more, so its hit time goes up. Once a program's working set already fits, extra cache
adds cost without much speed. That is why designers keep L1 small and very fast and make L3 large
but slower. One small note: the reading's author is spelled McClanahan. Do you think a phone chip
should spend its limited space on more cache or on more cores?

Best,
Nicanor

Reference:
Watkins, M. (2017, March 29). *Memory hierarchy introduction* [Video]. YouTube.
https://www.youtube.com/watch?v=_kZY4orPQW0

---

## Peer Response 2: to M S Kamran

Hi Kamran,

Your scenarios are well chosen, especially the car ECU, where on-chip SRAM avoids DRAM refresh
delays during real-time sensor work. On your question, one small clarification: write-through and
write-back are write policies, while eviction (replacement) policies such as least recently used
decide which line leaves the cache. A write-through cache sends every write to main memory, so
memory is always up to date and keeping cores consistent is simpler, but the memory bus carries a
lot of traffic. A write-back cache only writes a line out when it is evicted, using a dirty bit to
track changes, which cuts bus traffic sharply but means memory can hold stale data (Harris &
Harris, 2013). In a multi-core chip, that forces the cores to track each other's copies with a
coherence protocol. Which do you think suits your automotive ECU better, given its safety needs?

Best,
Nicanor

Reference:
Harris, D. M., & Harris, S. L. (2013). *Digital design and computer architecture* (2nd ed.).
Morgan Kaufmann. https://doi.org/10.1016/C2011-0-04377-6

---

## Peer Response 3: to Kazi Shariful Islam

Hi Kazi,

Your 3D rendering example is a great illustration of the hierarchy working as a pipeline, from SSD
to DRAM to the L2 and L3 caches. I would add one detail to the database server scenario: besides
battery-backed power, databases protect against DRAM's volatility by writing every change to a log
on the SSD before confirming it, so the data survives a crash. To answer your question with a
concrete case, imagine two cores updating the same bank balance. With write-through, every update
goes straight to main memory, so the other core can read the correct value, but the bus fills with
writes. With write-back, updates stay in one core's cache until eviction, which saves bus traffic
but means the second core could read an old value unless the hardware first invalidates or updates
its copy (Harris & Harris, 2013). Would you combine write-back with a write buffer to get some of
the benefits of both?

Best,
Nicanor

Reference:
Harris, D. M., & Harris, S. L. (2013). *Digital design and computer architecture* (2nd ed.).
Morgan Kaufmann. https://doi.org/10.1016/C2011-0-04377-6
