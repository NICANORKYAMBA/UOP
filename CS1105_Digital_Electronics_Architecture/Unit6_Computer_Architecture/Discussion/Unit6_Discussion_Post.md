# Choosing a Computer Architecture: Matching the Design to the Job

**Course:** CS 1105 Digital Electronics & Computer Architecture
**Student:** Nicanor Maswili
**Instructor:** Muhammad Aligohar Bilal
**Due:** October 14, 2026

If I were building a presentation comparing computer architectures, my main message would be that
there is no "best" architecture, only the best fit for a particular job. Wu (2023) describes
computer architecture as the bridge between software and hardware, and the instruction set
architecture (ISA) as the contract on that bridge: it defines which instructions, registers, and
data types the software can rely on. Choosing an architecture therefore means choosing both the
hardware and the software world that comes with it.

## Critical Factors When Selecting an Architecture

**1. The workload.** The first question is what the system will actually do. A laptop runs many
varied programs and needs strong single-thread speed, a web server handles thousands of small
requests in parallel and benefits from many cores, and a microwave controller only needs to read
buttons and drive a timer. Both (2020) explains that CPU performance depends on how efficiently
the fetch, decode, and execute cycle is used, for example by overlapping its stages, and on having
several cores that can run threads at the same time, and different workloads benefit from these
in different ways.

**2. ISA and software compatibility.** Software is compiled into machine language for one ISA, and
machine code for one processor family will not run on another (Computer Hope, 2019). A company
with years of x86 software may find that moving to ARM costs more in rewriting and testing than it
saves in hardware.

**3. Power efficiency.** For phones, laptops, and data centres, performance per watt often matters
more than peak speed, because it decides battery life and electricity bills. Simpler RISC designs
such as ARM and RISC-V usually do well here.

**4. Cost and licensing.** Cost includes the chip, the licence, and the long-term running cost. x86
is controlled by two companies, ARM designs are licensed, and RISC-V is an open standard that anyone
can implement without royalties.

**5. Real-time and I/O needs.** Embedded systems care about predictable response to hardware
events. This week's Z80 readings show how much the interrupt design matters: a simple system can
use Mode 1 with one fixed handler, while a system with many devices benefits from vectored Mode 2
(Cook, 2015).

| Architecture | ISA style | Strength | Typical use |
|---|---|---|---|
| x86 | CISC | Huge software base, high peak speed | Desktops, many servers |
| ARM | RISC | Performance per watt | Phones, Apple Macs, cloud servers |
| RISC-V | RISC, open | No licence fees, customizable | Microcontrollers, research, new chips |
| Z80 | CISC, 8-bit | Simple, cheap, predictable | Classic and embedded controllers |

## The Future of Computer Architecture

I expect three trends to shape the next decade. First, **heterogeneous chips**: instead of one kind
of core, a single chip will combine fast cores, efficient cores, a GPU, and AI accelerators, and
software will send each task to the unit that handles it best. Second, **chiplets**: designers will
build processors from smaller dies joined in one package, which improves manufacturing yield and
lets companies mix parts. Third, **open ISAs such as RISC-V** will keep growing, because companies
can design custom processors without paying licence fees.

The impact on the industry will be large. Competition will lower costs and weaken the old x86
dominance, especially in servers. Energy efficiency will become a selling point as AI data centres
consume more power. For developers, the biggest change is that software must be portable across
ISAs, so cross-compiling and testing on more than one architecture will become a normal skill.

## A Real-World Example: AWS Graviton

Amazon Web Services designed its own ARM-based Graviton processors for cloud servers instead of
relying only on x86 chips. AWS reports that Graviton instances give the best price performance for
a broad range of cloud workloads and use up to 60% less energy than comparable EC2 instances for
the same performance (Amazon Web Services, n.d.). For a customer running web servers or databases,
moving to Graviton can therefore cut both the monthly bill and the carbon footprint, often with
little change to code written in portable languages such as Java or Python. The example shows
every factor above working together: a workload that suits many efficient cores, an ISA with good
software support, and large savings in power and cost.

**Question for the class:** Since RISC-V is free to use and customize, do you think it will
eventually replace ARM in phones and embedded devices, or will ARM's mature software ecosystem keep
it ahead? What would a company need to consider before switching?

Word count: 732

## References

Amazon Web Services. (n.d.). *AWS Graviton processors*. https://aws.amazon.com/ec2/graviton/

Both, D. (2020, July 7). *The central processing unit (CPU): Its components and functionality*.
Red Hat. https://www.redhat.com/en/blog/cpu-components-functionality

Computer Hope. (2019, June 30). *Machine language*.
https://www.computerhope.com/jargon/m/machlang.htm

Cook, M. (2015, April 15). *Z80 interrupts*. Z80 Journal.
https://z80journal.wordpress.com/2015/04/15/z80-interrupts/

Wu, H.-W. (2023, June 22). *Computer architecture explained: The bridge between software and
hardware*. DataSci Ocean. https://datasciocean.com/en/other/what-is-computer-architecture/
