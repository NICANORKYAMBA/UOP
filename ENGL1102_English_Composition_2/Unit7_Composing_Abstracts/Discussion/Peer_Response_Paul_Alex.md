# ENGL1102 Unit 7 — Peer Response to Paul Alex

**By**: Nicanor Kyamba  
**Date**: March 2026

---

Paul, your abstract is well-structured and covers all six required elements clearly. I particularly appreciated how your findings section goes beyond simply describing each paradigm and instead evaluates their trade-offs — noting, for example, that inheritance in OOP can introduce fragility if overused. That kind of critical nuance is exactly what Serdikoff (2021) means when describing findings as the section that should convey not just what was discovered but what it *means* for practice (pp. 121–122). It elevates your abstract from descriptive to genuinely informative.

One element worth strengthening is the problem statement. You identify the audience — students and novice developers — but the gap could be stated more precisely. Specifically, the literature already contains paradigm comparisons; what appears to be missing is guidance that maps paradigm selection to *concrete project characteristics* (team size, concurrency requirements, domain complexity). Sharpening that distinction would make the problem statement more defensible against the question: "Why does this study need to exist?"

Regarding your discussion question: functional programming would most clearly outperform OOP in financial systems requiring high-throughput transaction processing, distributed data pipelines (e.g., Apache Spark's functional core), and compiler or parser design — domains where immutability eliminates entire categories of concurrency bugs. The primary team-setting challenge is the paradigm shift you mention: developers accustomed to mutable state often find pure functions and monadic error handling counterintuitive initially. A practical mitigation is adopting a multi-paradigm language like Scala or Python first, allowing teams to introduce functional patterns incrementally rather than all at once.

Overall, this is a strong abstract that demonstrates clear command of all six elements.

---

## References

Serdikoff, S. (2021). *Research methods for the behavioral sciences* (5th ed.). GALILEO Open Learning Materials. https://oer.galileo.usg.edu/psychology-textbooks/12/

---

**Word Count**: ~280 words
