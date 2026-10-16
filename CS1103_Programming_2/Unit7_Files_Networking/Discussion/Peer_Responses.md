# CS 1103 Unit 7: Peer Responses

Author: Nicanor Maswili
Course: CS 1103 Programming 2

You need to post **2** replies by Wednesday (minimum 75 words, three to four sentences or more).
Three drafts are provided so you can pick the two that fit best. Each one engages the classmate's
specific points, adds a technical idea, answers their question, and ends with a question.

---

## Peer Response 1: to Fanny Phiri

Hi Fanny,

I liked how you separated small files (Files.readString) from large ones (buffered streams), and
your point that a fast system is useless if it exposes users' data. One small thing caught my eye:
your copyFile example uses REPLACE_EXISTING, which silently overwrites the destination. Eck's
file-copy program does the opposite and refuses to overwrite an existing file unless the user adds
a -f option (Eck, 2022, Section 11.3), which seems safer for shared folders.

To answer your question, I would give every transfer a fixed buffer, for example 64 KB, and run
transfers on a thread pool with a fixed number of threads. Memory then has a hard ceiling (buffer
size times pool size), and extra uploads wait in the queue instead of exhausting the server. Each
upload would go into a temporary file that is renamed with Files.move and ATOMIC_MOVE only when it
is complete (Oracle, n.d.), so users never see half a file. Would you let users choose to
overwrite, or always save a second copy with a new name?

Best,
Nicanor

References:
Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart and
William Smith Colleges. https://math.hws.edu/javanotes/c11/s3.html

Oracle. (n.d.). *Class Files*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html

---

## Peer Response 2: to Ayhab Benashur

Hi Ayhab,

Your post is very practical, especially sending the file name, size, and checksum with
DataOutputStream alongside the raw bytes. To answer your question, TCP guarantees that the bytes
arrive in order, but it delivers one continuous stream with no message boundaries. Without a
protocol, the receiver cannot tell where the file name ends and the file begins, or whether the
connection closed because the file was finished or because the sender crashed halfway. A length
prefix solves the second problem neatly: if the receiver calls readFully() for the announced size
and the stream ends early, it throws an EOFException instead of quietly saving a truncated file
(Oracle, n.d.). The checksum then covers what TCP cannot, such as a file that was read wrongly from
disk. One suggestion: linking your points to Eck (2022, Section 11.4), our course text, would
strengthen your references. Would you send the checksum before the file data or after it?

Best,
Nicanor

References:
Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart and
William Smith Colleges. https://math.hws.edu/javanotes/c11/s4.html

Oracle. (n.d.). *Class DataInputStream*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/DataInputStream.html

---

## Peer Response 3: to Kevin Mong'Are

Hi Kevin,

Your distinction between successful transmission and successful verification is excellent, and I
agree that a transfer should only count as complete after the size and hash both match. I use the
same temporary-file idea in my own post, and there is one detail worth adding. If the temporary
file is renamed with Files.move and ATOMIC_MOVE, it must be on the same file store as the final
location, because Java throws AtomicMoveNotSupportedException when an atomic move across file
stores is impossible (Oracle, n.d.). Keeping the .part file in the destination folder avoids that.

To answer your question, I would not trade security for speed at all. I would cap memory with a
fixed buffer per transfer and a bounded thread pool, and always validate paths, because a name like
../../etc/passwd is a classic path traversal attack (OWASP Foundation, n.d.). Do you think TLS
encryption slows large transfers enough to matter?

Best,
Nicanor

References:
Oracle. (n.d.). *Class Files*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html

OWASP Foundation. (n.d.). *Path traversal*. https://owasp.org/www-community/attacks/Path_Traversal
