# CS1101 Unit 6 Discussion — Peer Response to Tariro Makombe

**Name**: Nicanor Kyamba  
**Course**: CS1101 Programming Fundamentals  
**Unit**: 6 — Lists  
**Date**: March 2026

---

## Response to Tariro Makombe

Hi Tariro,

Your post demonstrates a solid conceptual understanding of equivalent vs identical objects, aliasing, and reference-based argument passing. The prose explanations are clear and logically sequenced, and your discussion question about immutable objects is one of the most practically important questions in this unit.

One area to strengthen for future posts: the assignment prompt specifically asks to "illustrate the difference further using your own examples with Python lists and the `is` operator" and to "create your own example of a function that modifies a list." Your post describes these examples in words but does not include runnable code blocks or verified output. Including actual code — even a short snippet — makes the explanation much more concrete and verifiable. For instance, your `append_element` function could be shown as:

```python
def append_element(input_list, element):
    input_list.append(element)

my_list = [1, 2, 3]
append_element(my_list, 4)
print(my_list)   # [1, 2, 3, 4]
```

This makes it immediately clear that `input_list` is a reference to the same object as `my_list`, and that no `return` statement is needed for the change to persist (Downey, 2015, p. 109).

To answer your discussion question directly: when an immutable object like an integer is passed to a function and the function tries to "modify" it — for example, `n = n + 1` — Python creates a brand new integer object and binds the local parameter to it. The original variable outside the function is completely unaffected because the parameter and the argument are now pointing to different objects. This is why immutable objects behave as if passed by value, even though Python's mechanism is always reference-based (Downey, 2015, p. 109).

Good conceptual foundation — adding code examples will take your posts to the next level.

---

## References

Downey, A. (2015). *Think Python: How to think like a computer scientist*. Green Tea Press. https://greenteapress.com/thinkpython2/thinkpython2.pdf

---

**Word Count**: 283 words
