# CS1101 Unit 7 Discussion — Peer Response to Ebuka Obasi

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 7 — Dictionaries and Tuples  
**Date**: March 2026

---

## Response to Ebuka Obasi

Hi Ebuka,

Using your Tasklite app as the context for this post is a genuinely effective approach — mapping `zip`, `enumerate`, and `.items()` to real development tasks, feature lists, and user settings makes the abstract concepts immediately concrete. All three code examples are correct and the outputs are accurate.

A small correction worth noting: your reference lists the publisher as "Green Tree Press" — the correct name is **Green Tea Press**. It is a minor detail but worth fixing before submission to avoid a citation error.

On your discussion question: the framing is interesting but the connection to tuple immutability is slightly off. When you call `zip(taskNames, taskStatus)`, Python evaluates both lists at that moment and creates an iterator over them. If you mutate `taskNames` *after* calling `zip` but *before* the loop finishes, the behaviour depends on whether the iterator has already consumed those elements — it is a list mutation issue rather than a tuple immutability issue. The tuples that `zip` produces are indeed immutable, but that is separate from whether the source lists can change. Downey (2015) notes that `zip` returns an iterator that is consumed lazily, meaning elements are paired one at a time as the loop progresses (p. 121) — so mutating a source list mid-loop can produce unexpected results, but not because of the tuples themselves.

One more thing to consider: your `enumerate` loop starts at index 0, which is the default. For a user-facing feature list, starting at 1 with `enumerate(features, start=1)` would read more naturally as "Feature number 1 is Dark Mode."

Great real-world framing overall — the app development context makes this one of the more memorable posts in the thread.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: 286 words
