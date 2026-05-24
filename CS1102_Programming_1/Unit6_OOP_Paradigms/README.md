# CS 1102 — Unit 6: OOP Paradigms

**Course**: CS 1102 — Programming 1  
**Unit**: 6 — OOP Paradigms (Inheritance, Polymorphism, Interfaces)  
**Term**: AY2026-T3  
**Student**: Nicanor Kyamba

---

## Topics Covered
- Inheritance and the superclass/subclass relationship
- Polymorphism through method overriding and dynamic binding
- Method overloading vs. method overriding
- Compile-time vs. runtime polymorphism
- Interfaces and their role in defining contracts
- Multiple interface implementation
- The `extends`, `implements`, `super`, and `@Override` keywords

## Learning Objectives
1. Apply polymorphism through method overriding and dynamic binding to achieve runtime flexibility
2. Explain inheritance and its role in OOP, including superclass and subclass concepts
3. Implement interfaces to define contracts and enforce common behavior across multiple classes

## Reading Assignments
- Eck, D. J. (2022). *Introduction to Programming Using Java* (Version 9, JavaFX ed.)
  - Chapter 5, Section 5.5: Inheritance and Polymorphism
  - Chapter 5, Section 5.7: Interfaces
  - https://math.hws.edu/javanotes/

### Videos
- Coding with John. (2021). *Java Polymorphism Fully Explained in 7 Minutes* [Video]. YouTube.
- Lee, A. (2019). *Inheritance in Java Tutorial* [Video]. YouTube.
- Pragada, S. (2020). *Compile-time Polymorphism vs. Runtime Polymorphism* [Video]. YouTube.
- Programming with Mosh. (2022). *Java Interfaces Tutorial* [Video]. YouTube.
- Simple Snippets. (2018). *Java Polymorphism — Method Overloading vs Method Overriding* [Video]. YouTube.

---

## Repository Structure

```
Unit6_OOP_Paradigms/
├── Assignment/
│   ├── Vehicle.java                      # Base interface
│   ├── CarVehicle.java                   # Car-specific interface
│   ├── MotorVehicle.java                 # Motorcycle-specific interface
│   ├── TruckVehicle.java                 # Truck-specific interface
│   ├── Car.java                          # Implements Vehicle + CarVehicle
│   ├── Motorcycle.java                   # Implements Vehicle + MotorVehicle
│   ├── Truck.java                        # Implements Vehicle + TruckVehicle
│   ├── VehicleInformationSystem.java     # Main program with interactive menu
│   ├── Unit6_Programming_Assignment.md   # Full write-up with documentation
│   └── Unit6_Programming_Assignment.docx # Formatted submission
├── Discussion/
│   ├── Unit6_Discussion_Assignment.md    # Main discussion post (750+ words)
│   ├── Unit6_Discussion_Assignment.docx  # Formatted submission
│   ├── Unit6_Peer_Response_1.md          # Peer response 1
│   ├── Unit6_Peer_Response_2.md          # Peer response 2
│   └── Unit6_Peer_Response_3.md          # Peer response 3
├── Learning_Notes/
│   └── Unit6_Learning_Notes.md           # Comprehensive notes on 5.5 and 5.7
└── README.md                             # This file
```

---

## Key Concepts Quick Reference

| Concept | Description |
|---------|-------------|
| Inheritance | Subclass acquires properties/methods of a superclass via `extends` |
| Polymorphism | Superclass variable can hold subclass objects; correct method called at runtime |
| Method Overriding | Subclass provides its own version of a superclass method (same signature) |
| Method Overloading | Multiple methods with same name but different parameters (same class) |
| Dynamic Binding | JVM decides which overridden method to call at runtime based on actual object type |
| Interface | Contract defining methods a class must implement; declared with `interface` |
| `implements` | Keyword for a class to declare it fulfills an interface contract |
| `extends` | Keyword for a class to inherit from a superclass |
| `super` | Reference to superclass — calls parent constructor or overridden method |
| `@Override` | Annotation verifying a method overrides a superclass/interface method |
| `instanceof` | Operator checking if an object is an instance of a class/interface |
| Loose coupling | Depending on interfaces rather than concrete classes |

---

## Unit Checklist
- [x] Read Chapter 5, Section 5.5: Inheritance and Polymorphism
- [x] Read Chapter 5, Section 5.7: Interfaces
- [x] Watch 5 assigned videos
- [x] Complete Learning Notes
- [x] Complete Discussion Assignment (post)
- [ ] Respond to 3 peers in Discussion Forum
- [x] Complete Programming Assignment
- [ ] Take Self-Quiz
- [ ] Take Graded Quiz

**Status**: 🚧 In Progress
