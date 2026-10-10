# CS 1103 Unit 6: Peer Responses

Author: Nicanor Maswili
Course: CS 1103 Programming 2

You need to post **2** replies by Wednesday (minimum 75 words each). Each one engages the
classmate's specific points, adds a technical idea, answers their question, and ends with a
question.

---

## Peer Response 1: to Bismark Asiedu

Hi Bismark,

Your Box<T> example shows the idea of one class serving many types very clearly, and I liked your
plan to learn bounded wildcards by testing small examples. A rule that helped me is in Oracle's
wildcard guidelines: a parameter that only supplies data to a method should use extends, and one
that only receives data should use super (Oracle, n.d.). So a copy(src, dest) method reads from a
List<? extends T> and writes into a List<? super T>.

To answer your question, I ask where the type needs to live. If the object stores the value
between calls, like the item field in your Box or the items in my library catalog, the class
should be generic. If the type only links one method's parameters to its return value, a generic
method is enough, and it can even be static. If several unrelated classes must follow the same
contract, a generic interface fits, the way Comparable<T> lets any class define compareTo(T)
without casts. Do you think it is better to start with a generic method and only make the whole
class generic later if you need it?

Best,
Nicanor

Reference:
Oracle. (n.d.). *Guidelines for wildcard use*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/java/generics/wildcardGuidelines.html

---

## Peer Response 2: to Mary Njeri

Hi Mary,

I agree with your point that using generics does not automatically make a program well designed,
and your advice to choose the simplest design that works is a good one. One small tip: the forum
seems to have removed everything inside angle brackets, so ArrayList<String> shows up as just
ArrayList in your post. Putting a space around the brackets or describing the type in words should
fix it.

To answer your question, I think type safety is the most important advantage, because the other
two follow from it. Oracle (n.d.) lists stronger type checks at compile time first and explains
that compile-time errors are easier to fix than runtime errors, which can be hard to find.
Reusability was already possible before generics by storing everything as Object, but it was
unsafe. Casts disappear only because the compiler now knows the type. Without generics, a wrong
item in a list causes a ClassCastException later, often far from the line that added it. Have you
ever seen one of those errors appear in a different part of the program from the real mistake?

Best,
Nicanor

Reference:
Oracle. (n.d.). *Why use generics?* The Java Tutorials.
https://docs.oracle.com/javase/tutorial/java/generics/why.html
