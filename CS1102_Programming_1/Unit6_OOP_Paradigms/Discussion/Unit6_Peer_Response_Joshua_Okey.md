# CS 1102 — Unit 6 Discussion

## Peer Response to Joshua Okey

**Student**: Nicanor Kyamba  
**Course**: CS 1102 — Programming 1  
**Unit**: 6 — OOP Paradigms

---

Hi Joshua,

Your post does an excellent job of connecting inheritance, polymorphism, method overriding, and dynamic binding into a coherent narrative rather than treating them as isolated concepts. The payment processing example is particularly effective because it demonstrates the full chain — a `Payment` superclass defines the contract, `CreditCardPayment` overrides the method with specific logic, and dynamic binding ensures the correct version executes at runtime without the caller needing to know the concrete type. This is exactly the pattern that makes polymorphism practically useful in production systems.

I want to expand on your point about the "Open-Closed" principle. You correctly state that software entities should be open for extension but closed for modification. The mechanism that makes this possible is specifically the combination of dynamic binding and method overriding — not inheritance alone. Without dynamic binding, adding a new `ApplePayPayment` subclass would still require modifying the processing engine to add a conditional check for the new type. It is dynamic binding that allows `myPayment.processPayment(100.0)` to automatically dispatch to the correct implementation without any `instanceof` checks or conditional logic. Eck (2022) describes this as one of the most powerful features of OOP — the same code operates on objects of different types, and the correct behavior is selected automatically at runtime (Section 5.5.3).

Your database driver example is strong, but it is worth noting that this scenario typically uses interfaces rather than class inheritance. The application depends on a `DatabaseConnection` interface, and `MySQLConnection`, `PostgreSQLConnection`, and `MongoConnection` are implementations. This distinction matters because interfaces enforce the contract without imposing an implementation hierarchy — the database drivers are unrelated classes that happen to fulfill the same contract. Eck (2022) explains that interfaces enable polymorphism across unrelated class hierarchies, which is something inheritance alone cannot achieve (Section 5.7). This makes your database example even more powerful than presented — it demonstrates interface-based polymorphism rather than inheritance-based polymorphism.

Your reference to Agile environments and evolving requirements is a practical insight that connects these academic concepts to real development workflows. Well-structured post with strong examples across multiple domains.

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Creative Commons CC 4.0. [https://math.hws.edu/javanotes/](https://math.hws.edu/javanotes/)

---

**Word count**: 340
