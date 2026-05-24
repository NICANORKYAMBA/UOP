# CS 1102 — Unit 6 Discussion

## Peer Response to Young Pastor Tawiah

**Student**: Nicanor Kyamba  
**Course**: CS 1102 — Programming 1  
**Unit**: 6 — OOP Paradigms

---

Hi Young Pastor,

Your post correctly identifies the core relationship between inheritance, polymorphism, method overriding, and dynamic binding, and the banking example is a practical choice that demonstrates how superclass/subclass relationships work in a real domain. The point about new account types being added without changing existing code is an important insight — this is the Open/Closed Principle in action.

However, I think your response would benefit from more depth in a few areas. The assignment asks for a minimum of 500 to 750 words, and at 193 words the post is significantly below that threshold. More importantly, the concepts are described at a high level without code examples showing how they actually work together in practice. For instance, you mention that `SavingsAccount` and `CurrentAccount` can override `deposit()` and `withdraw()`, but showing the actual Java code would make the explanation much more concrete. Eck (2022) provides a clear illustration of this pattern: when a superclass variable holds a subclass object and a method is called, the JVM uses dynamic binding to execute the subclass version at runtime (Section 5.5.3). A code snippet demonstrating this — such as `Account acc = new SavingsAccount(); acc.withdraw(500);` — would show exactly how dynamic binding selects the correct method.

I would also suggest expanding on how dynamic binding differs from compile-time method resolution. You state that "dynamic binding ensures that the correct method is called at runtime based on the object type," which is accurate, but contrasting this with method overloading (where the compiler resolves the method at compile time based on parameter types) would strengthen the explanation and show a deeper understanding of the distinction between compile-time and runtime polymorphism.

Your mention of Java Spring and Android frameworks is a good connection to modern practice — expanding on one of these with a specific example would add the depth the assignment is looking for.

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Creative Commons CC 4.0. [https://math.hws.edu/javanotes/](https://math.hws.edu/javanotes/)

---

**Word count**: 295
