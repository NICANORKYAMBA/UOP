# CS 1102 — Unit 6 Discussion

## Peer Response to Ima-Obong Iko

**Student**: Nicanor Kyamba  
**Course**: CS 1102 — Programming 1  
**Unit**: 6 — OOP Paradigms

---

Hi Ima-Obong,

Your post provides a clear and well-structured overview of how inheritance, polymorphism, method overriding, and dynamic binding connect to enhance code organization. The Animal/Dog example is a good choice for illustrating method overriding because it is simple enough to follow while clearly demonstrating how the subclass provides its own implementation of an inherited method. Your banking system example is also practical — it shows a real-world scenario where superclass/subclass relationships directly improve maintainability by isolating changes to individual subclasses.

I want to build on your explanation of dynamic binding. You correctly state that "the program chooses the appropriate method during execution rather than at compile time," but it is worth making the mechanism more explicit. When you write `Animal a = new Dog(); a.sound();`, the compiler sees the reference type `Animal` and verifies that `Animal` has a `sound()` method — this is compile-time type checking. But at runtime, the JVM inspects the actual object stored in memory (which is a `Dog`) and calls `Dog.sound()` instead of `Animal.sound()`. Eck (2022) describes this as the JVM determining which method to execute based on the actual object type rather than the declared variable type (Section 5.5.3). This two-phase process — compile-time verification followed by runtime dispatch — is what makes dynamic binding both safe and flexible.

One area where your post could go deeper is the connection between these principles and the Open/Closed Principle. You mention that "changes to one subclass do not affect the entire system," which is correct. The deeper insight is that polymorphism combined with dynamic binding means new subclasses can be added without modifying any existing code that processes objects through the superclass reference. For example, if your banking system processes transactions through a `BankAccount` reference, adding a new `InvestmentAccount` subclass requires zero changes to the transaction processing logic — dynamic binding automatically dispatches to the correct method at runtime. This is what makes these principles essential for scalable systems in Agile environments where requirements evolve continuously.

Good use of multiple references to support your points throughout the post.

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Creative Commons CC 4.0. [https://math.hws.edu/javanotes/](https://math.hws.edu/javanotes/)

---

**Word count**: 330
