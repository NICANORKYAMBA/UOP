# Designing Generic Classes That Stay Flexible

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Due:** October 14, 2026

Generics let one class or method work with many data types while the compiler still checks
every type, so mistakes show up at compile time instead of as a ClassCastException at run time
(Divertitto, 2022). This week I built a generic library catalog for books, DVDs, and magazines,
and that project shaped both my design priorities and the challenges described below.

## Factors I Prioritize for Flexibility and Maintainability

**1. Keep the common part fixed and make only the varying part generic.** Every library item has a
title, an author, and an ID, but the rest differs: a book has pages, a DVD has a runtime. So I made
the class LibraryItem<T>, where only the details field has type T. Adding a new item type later
needs one new details class and no change to existing code.

**2. Use bounded type parameters to state what a type must be.** My catalog is
Catalog<T extends LibraryItem<?>>. The bound documents the design in the code itself and lets the
catalog call getItemID() on any item safely. Eck (2022) describes bounded types as the way to
restrict a type parameter while keeping full type checking.

**3. Use wildcards in method parameters so callers have more freedom.** A search method that
takes Predicate<? super T> accepts a condition written for any supertype of T, so one
condition can be reused across catalogs. Kumar (2023) explains how upper-bounded (extends) and
lower-bounded (super) wildcards widen what a method accepts.

**4. Never fall back to raw types.** A raw ArrayList with no type in angle brackets compiles, but
only with an "unchecked" warning, and it gives away all the safety generics provide (Divertitto,
2022). I compile with all warnings turned on and treat every warning as something to fix.

**5. Name type parameters clearly and document them.** Short names such as T and E follow Java
convention, but each one gets a Javadoc @param line explaining what it stands for, which makes
the class far easier for the next developer to maintain.

## Challenges I Faced and How I Overcame Them

**Challenge 1: one catalog for mixed items.** My first attempt used Catalog<LibraryItem<Object>>,
expecting it to accept any item. The compiler rejected it:

```
error: incompatible types: LibraryItem<BookDetails> cannot be converted to LibraryItem<Object>
```

This happens because generic types are invariant: even though BookDetails is an Object,
LibraryItem<BookDetails> is not a LibraryItem<Object>. I fixed it with the wildcard type
LibraryItem<?>, meaning "a library item with details of some type", so a Catalog<LibraryItem<?>>
now holds books, DVDs, and magazines together, while a Catalog<LibraryItem<BookDetails>> still
accepts only books (Eck, 2022).

**Challenge 2: type erasure.** I wanted the catalog to create items itself with new T(), but Java
does not allow it, because type information is erased after compilation and T is unknown at run
time (Divertitto, 2022; Oracle, n.d.). I changed the design so that the caller creates each item
and passes it in, which also made the catalog simpler to test. Erasure also affected equals(): I
compare with instanceof LibraryItem<?> rather than LibraryItem<T>, since T cannot be checked at
run time.

**Challenge 3: primitives and static methods.** A type argument cannot be a primitive, so
LibraryItem<int> is illegal (Oracle, n.d.). Using records with int fields inside the details class,
or wrapper types such as Integer, solved this. I also learned that a static method cannot use the
class's T, so my static printItems method declares its own type parameter,
<E extends LibraryItem<?>>, as Coding with John (2021) demonstrates for generic methods.

Testing confirmed that each fix worked: fifteen automated checks covering every item type and
every error case all pass.

**Question for the class:** When writing a generic method, how do you decide between a bounded
type parameter, such as <T extends Number> void process(List<T> list), and a wildcard, such as
void process(List<? extends Number> list)? Is there a case where only one of them works?

Word count: 644

## References

Coding with John. (2021, December 20). *Generics in Java - Full simple tutorial* [Video]. YouTube.
https://www.youtube.com/watch?v=K1iu1kXkVoA

Divertitto, A. (2022, August 18). *Java generics: How to use angled brackets in practice*. CodeGym.
https://codegym.cc/groups/posts/generics-in-java

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart and
William Smith Colleges. https://math.hws.edu/javanotes/c10/s5.html

Kumar, A. (2023, April 18). *Mastering generics in Java: A comprehensive guide for Java developers*.
Tech Thoughts Explorer.
https://techthoughtsexplorer.hashnode.dev/mastering-generics-in-java-a-comprehensive-guide-for-java-developers

Oracle. (n.d.). *Restrictions on generics*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/java/generics/restrictions.html
