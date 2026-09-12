# Programming Assignment Unit 2: Simple E-commerce System

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili

## Overview

This program implements a simple e-commerce system in Java, organized with packages for
clean encapsulation. A package groups related classes into a single namespace, which avoids
naming conflicts and keeps larger programs organized (Eck, 2022). Products and customers live
in the `com.ecommerce` package, and orders live in the `com.ecommerce.orders` package, which
imports the `Product` and `Customer` classes to demonstrate cross-package use of the `import`
statement; the import statement lets one package use the public classes of another (Samoylov,
2018). A separate `Main` class (outside the packages) imports all three classes and
demonstrates the full workflow: browsing a product catalog, adding and removing items from a
shopping cart, calculating the cart total, reading and validating user input, placing an
order, generating an order summary, and updating the order status. All fields are declared
private with public getters and setters, which enforces encapsulation and data hiding (Eck,
2022), and the constructors validate their inputs so invalid data is rejected.

**Academic integrity:** This assignment is my own original work; all source code and
explanations were written by me, with ideas from the course readings cited in APA style.

## Package Structure

```
src/
  Main.java                         (default package)
  com/
    ecommerce/
      Product.java                  package com.ecommerce
      Customer.java                 package com.ecommerce
      orders/
        Order.java                  package com.ecommerce.orders
```

**Compile and run (from the `src` directory):**

```
javac -d ../bin com/ecommerce/Product.java com/ecommerce/Customer.java \
      com/ecommerce/orders/Order.java Main.java
java -cp ../bin Main
```

In IntelliJ IDEA: open the project, mark `src` as **Sources Root**, then run `Main`.

## How Each Requirement Is Met

| Requirement | Where |
|-------------|-------|
| Package `com.ecommerce` | `Product` and `Customer` classes |
| Package `com.ecommerce.orders` | `Order` class |
| Product class (id, name, price, constructors, getters/setters) | `Product.java` |
| Customer class (id, name, cart, add/remove, total, order) | `Customer.java` |
| Order class (id, customer, products, total, summary, status) | `Order.java` |
| Main program using `import` from both packages | `Main.java` |
| Access modifiers / encapsulation | private fields + public getters/setters |
| Input validation & error handling | constructor checks + Scanner validation + try/catch |

## Source Code

The full source of each file is embedded in the accompanying Word document
(`Unit2_Programming_Assignment.docx`) and stored under `src/`:

- `src/com/ecommerce/Product.java`
- `src/com/ecommerce/Customer.java`
- `src/com/ecommerce/orders/Order.java`
- `src/Main.java`

## Sample Run and Output

The program compiles with `javac -Xlint:all` (no errors or warnings). A sample run browses the
catalog, adds three items, removes one, reads a validated quantity from the user, calculates
the cart total, places the order, and updates its status; it also demonstrates rejecting an
empty-cart order.

## Screenshots

Insert two screenshots into the Word document before submitting:
1. The program compiling and running with full output.
2. The input-validation behavior (rejecting invalid input and/or an empty-cart order).

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart
and William Smith Colleges. Licensed under CC BY-NC-SA 4.0. https://math.hws.edu/javanotes/

Samoylov, N. (2018). *Introduction to programming: Learn to program in Java with data
structures, algorithms, and logic*. Packt Publishing.
