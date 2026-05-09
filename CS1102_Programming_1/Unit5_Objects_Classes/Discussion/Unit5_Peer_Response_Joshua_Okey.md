# CS 1102 — Unit 5 Discussion
## Peer Response to Joshua Okey

**Student**: Nicanor Kyamba  
**Course**: CS 1102 — Programming 1  
**Unit**: 5 — Objects and Classes

---

Hi Joshua,

Your post is one of the most architecturally sophisticated in this discussion. The "ripple effect" framing is particularly strong — it captures exactly why encapsulation matters in large codebases where a single change can cascade through dozens of dependent modules if boundaries are not properly enforced. The Array-to-ArrayList example is a clean illustration of how the public interface acts as a contract that remains stable even when the internal implementation changes entirely.

I want to build on your point about access modifiers and data integrity. You correctly identify that setter methods can include validation logic, and your BankAccount example demonstrates this well. But there is a subtlety worth making explicit: encapsulation does not just prevent invalid states — it makes invalid states *unrepresentable*. Eck (2022) describes this when explaining that private variables combined with validated setters ensure that "an object can never be left in an invalid state" (Section 5.1.3). The difference is important. If `balance` were public, you could write `account.balance = -500` and the object would silently accept an invalid state. With encapsulation, the only way to modify balance is through `deposit()` or `withdraw()`, and those methods enforce the invariant that balance must always be non-negative. The invalid state is not just prevented — it is structurally impossible to create.

Your e-commerce password example is strong, but it raises a related design question that is worth considering. You mention that `updatePassword()` verifies the old password before accepting the new one. This is correct, but it also means the `User` object must store the old password in a way that allows comparison. In real systems, this is typically done by storing a salted hash rather than the plaintext password. The encapsulation principle still applies — the `password` field remains private — but the internal representation is not what the external caller expects. The caller passes a plaintext string to `updatePassword()`, but internally the class hashes it before comparison. This is a perfect example of the information hiding you describe: the external interface is simple (`updatePassword(String oldPassword, String newPassword)`), but the internal implementation is complex and security-critical. Eck (2022) makes this point when he notes that getters and setters allow you to change the internal representation without affecting any code that uses the class (Section 5.1.3).

The debugging benefit you mention — that encapsulation localizes the search space for bugs — is underappreciated in introductory discussions but is one of the most practical advantages in real development. If a variable can be modified from anywhere in the program, tracking down where an incorrect value originated requires tracing every line of code that touches that variable. With encapsulation, the only code that can modify the variable is within the class itself, so the search space shrinks from the entire codebase to a single class. This is not just a convenience — it is the difference between a bug that takes five minutes to find and one that takes five hours.

One addition to your security analysis: encapsulation also supports the principle of least privilege. By making everything private by default and exposing only what is necessary through public methods, you ensure that each part of the system has access only to the data and operations it genuinely needs. This reduces the attack surface not just for external attackers but also for internal programming errors — a module that does not have access to a variable cannot accidentally corrupt it.

Well-structured post with strong real-world examples and clear architectural reasoning.

**References**

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
