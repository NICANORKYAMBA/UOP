# Physical Layer Design for a Manufacturing Plant, Office Complex, and Customer Network

**Course:** CS 2204 Communications and Networking
**Student:** Nicanor Maswili
**Due:** November 25, 2026

The startup's network has three environments: a plant floor with heavy electromagnetic interference (EMI), an office that needs high bandwidth, and a new service for nearby homes and businesses. This paper selects a line coding scheme, transmission media, and a multiplexing technique for them, comparing the alternatives for each.

## 1. Line Coding for the Manufacturing Plant

Line coding turns bits into electrical signal levels. Two problems matter most on a noisy factory floor. First, the receiver must stay synchronized with the sender, which it can only do by watching for transitions in the signal, so long runs without a transition let its clock drift (Dordal, 2023, Section 6.1). Second, a noise spike from a motor or welder can push a voltage level up or down, so a scheme that depends on exact levels is easier to corrupt than one that depends on transitions.

**Figure 1**

*The Bit Pattern 0100111000 in Four Line Coding Schemes*

[FIGURE figures/fig1_line_coding.png]

*Note.* NRZ-L: 1 = high. NRZ-I: 1 = transition at the start of the bit. Manchester (IEEE 802.3 convention): 0 = high-to-low and 1 = low-to-high at mid-bit. Differential Manchester: a transition at every mid-bit, plus one at the start of each 0. Created by the author in Python.

**Table 1**

*Line Coding Schemes Compared for a High-EMI Environment*

| Feature | NRZ-L | NRZ-I | Manchester | Differential Manchester |
|---|---|---|---|---|
| How a bit is read | Absolute level | Transition or none at bit start | Direction of the mid-bit transition | Transition or none at bit start |
| Self-clocking | No | Only for runs of 1s | Yes, every bit | Yes, every bit |
| DC component | Yes | Yes | No | No |
| Effect of reversed wire polarity | Every bit inverted | Unaffected | Every bit inverted | Unaffected |
| Signaling rate | 1 × bit rate | 1 × bit rate | 2 × bit rate | 2 × bit rate |
| Noise resistance | Lowest | Moderate | High | Highest of the four |

**NRZ (Non-Return to Zero).** NRZ-L sends a 0 as one level and a 1 as another. It is simple and uses the least bandwidth, but a long run of identical bits produces no transitions, so the receiver can "lose count" and misread the stream (Dordal, 2023, Section 6.1.1). Because it reads absolute levels, a noise spike that crosses the threshold flips a bit directly. NRZ-I improves synchronization by encoding a 1 as a transition, but long runs of 0s still have none (Dordal, 2023, Section 6.1.2).

**Manchester.** Manchester adds a transition in the middle of every bit, so the clock can resynchronize on every bit period and the signal has no DC component (Dordal, 2023, Section 6.1.3). Classic 10 Mbps Ethernet uses it. Because the clock is carried inside the signal, Manchester suits synchronous transmission, where sender and receiver must stay coordinated on a shared clock (Korucuoğlu, 2024). The cost is a signaling rate twice the data rate, which is the difference between baud rate and bit rate (TeachingCS, 2018). Manchester still depends on the direction of each transition, so if a pair of wires is reversed, every bit is inverted.

**Differential Manchester.** This scheme also transitions in the middle of every bit, but the data is carried by whether there is an extra transition at the start of the bit, not by the direction or level (Esoteric Ray, 2021). The receiver only has to detect that a change happened, which is more reliable in noise than measuring an exact voltage, and reversed wiring does not change the data.

**Recommendation.** For the plant's control links between sensors, programmable logic controllers, and machines, I recommend **Differential Manchester**. Its guaranteed transitions keep the clocks locked even when interference distorts parts of the signal, it has no DC component, and it tolerates polarity errors, which are common when cables are repaired on a busy plant floor. Its doubled signaling rate is acceptable for small control traffic. Line coding alone cannot remove EMI, however, so I would also run these links over shielded twisted pair, use fiber for longer or high-speed runs, and rely on error-detecting codes at the data link layer to catch any corrupted frames (Dordal, 2023, Section 7.4).

## 2. Transmission Media for the Office Network

**Table 2**

*Comparison of Guided Transmission Media*

| Criterion | Twisted pair (Cat 6) | Coaxial cable | Fiber-optic cable |
|---|---|---|---|
| Bandwidth | Up to 1 to 10 Gbps | Hundreds of Mbps to a few Gbps | 10 Gbps to 100 Gbps and beyond |
| Distance per segment | About 100 m | Up to about 500 m (thick coax) | Hundreds of meters (multimode) to 40 to 80 km (single-mode) |
| EMI susceptibility | Moderate; twisting cancels some noise, shielding helps | Low; the metal shield blocks much noise | None; light is not affected by EMI |
| Cost | Lowest; easy to install | Moderate | Highest for cable, optics, and splicing |

*Note.* Distances are from Dordal (2023, Sections 2.1, 2.2, and 6.2.4).

Twisted pair is cheap and simple, but its segments are limited to about 100 meters, while thick coaxial cable could run 500 meters (Dordal, 2023, Section 2.1). Fiber carries light rather than electricity, so it is immune to EMI and resists lightning damage; long-reach fiber Ethernet supports links of 40 to 80 km (Dordal, 2023, Section 6.2.4).

Based on this comparison, I recommend:

- **Workstations: Category 6 unshielded twisted pair.** Desks are within 100 meters of a wiring closet, the office has little EMI, and Cat 6 supports gigabit speeds for video conferencing at the lowest cost. It can also carry Power over Ethernet for phones, access points, and cameras.
- **Backbone: fiber-optic cable.** Multimode fiber connects the floor switches, and single-mode fiber links the office building to the plant. Fiber handles the combined traffic of many users, and its immunity to EMI matters on the run toward the machinery. Dordal (2023, Section 2.2) notes that fiber is the effective choice for links between buildings that twisted pair cannot reach.
- **Link to the service provider: single-mode fiber,** with a coaxial cable internet connection as a cheaper backup. Fiber gives the bandwidth and stable latency that cloud applications need, while coax keeps the company online if the main link fails.

Coax is not the main medium anywhere, but it remains a useful low-cost backup.

## 3. Multiplexing for the Customer Network

Multiplexing lets many users share one transmission medium. Frequency Division Multiplexing (FDM) gives each user a separate frequency band, while Time Division Multiplexing (TDM) gives each user the whole bandwidth for short, repeating time slots (Ankit Verma, 2021). FDM requires each signal to be modulated onto its own carrier frequency (ALL ABOUT ELECTRONICS, 2020).

**Table 3**

*TDM Compared With FDM*

| Criterion | Time Division Multiplexing | Frequency Division Multiplexing |
|---|---|---|
| Bandwidth allocation | Each user gets the full channel during its time slot; slots can be fixed or assigned on demand | Each user gets a fixed slice of the spectrum all the time; guard bands between slices waste some bandwidth |
| Scalability | Add users by adding slots or raising the line rate; works well with digital and optical systems | Limited by available spectrum; each new user needs a new band and carrier |
| Resistance to interference | Digital signals can be regenerated, but all users depend on precise timing | Adjacent bands can leak into each other (crosstalk), and analog noise accumulates |

In classic synchronous TDM, each of N senders gets 1/N of the bandwidth, and an idle sender's slot cannot be used by anyone else, which is why plain TDM was rejected for bursty data traffic (Dordal, 2023, Section 6.2). Customer traffic is bursty: households peak in the evening, businesses during the day.

**Recommendation.** The most effective choice is **TDM in its dynamic (statistical) form over a fiber network**. Instead of fixed slots, the provider assigns time slots according to each customer's current demand, so bandwidth left unused by one customer goes to another, and business customers can be given guaranteed minimums. This uses the fiber's capacity far better than FDM's fixed bands, which would sit empty when a customer is idle. TDM is also digital, so it can be regenerated without accumulating noise, and it scales by raising the line rate.

FDM still plays a supporting role in its optical form, wavelength-division multiplexing. Each wavelength on a fiber can carry its own TDM stream, and dense wavelength-division multiplexing greatly increases the capacity of a single fiber (Dordal, 2023, Section 6.2.3). As the customer base grows, the company can add wavelengths instead of digging up streets for new cable.

## Conclusion

Differential Manchester protects the plant's links from interference, twisted pair and fiber give the office a fast and affordable network, and dynamic TDM over fiber, later expanded with wavelength-division multiplexing, serves the customer base efficiently.

## References

ALL ABOUT ELECTRONICS. (2020, May 18). *What is modulation? Why modulation is required? Types of modulation explained* [Video]. YouTube. https://www.youtube.com/watch?v=mHvV_Tv8HDQ

Ankit Verma. (2021, May 18). *Types of multiplexing | FDM TDM WDM | Analog digital | Computer networks* [Video]. YouTube. https://www.youtube.com/watch?v=WXof7bg_Zys

Dordal, P. L. (2023). *An introduction to computer networks* (2nd ed.). http://intronetworks.cs.luc.edu/current2/html/index.html

Esoteric Ray. (2021, July 28). *Differential Manchester encoding tutorial* [Video]. YouTube. https://www.youtube.com/watch?v=7BaJyQmXVbc

Korucuoğlu, İ. (2024, October 30). *Synchronous vs. asynchronous transmission: Key differences, benefits, and use cases*. Siberoloji. https://www.siberoloji.com/synchronous-vs-asynchronous-transmission-key-differences-benefits-and-use-cases/

TeachingCS. (2018, September 14). *Baud rate vs bit rate* [Video]. YouTube. https://www.youtube.com/watch?v=f5nM_TBAodA
