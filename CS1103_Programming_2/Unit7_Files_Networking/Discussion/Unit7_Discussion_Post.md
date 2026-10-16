# File Operations and Networking in a Java File-Sharing Application

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Due:** October 21, 2026

In a file-sharing application, two things must never fail silently: a file must arrive complete
and unchanged, and one user's problem must not break the service for everyone else. Building a
multi-user chat server with sockets this week shaped the strategies below.

## Implementing File Operations Efficiently

**1. Treat every shared file as bytes.** Users share photos, PDFs, and ZIP archives, not only
text, so I would read and write with the byte streams FileInputStream and FileOutputStream. Eck
(2022, Section 11.3) makes the same choice for his file-copy program, because a program that
copies any file cannot assume the data is human-readable. Character streams such as FileReader
are only for text (Codex, 2023).

**2. Stream in chunks instead of loading whole files.** I would wrap the streams in
BufferedInputStream and BufferedOutputStream and copy through an 8 KB array. Buffered streams read
data in chunks into an internal buffer, which keeps memory use low on large files (Codex, 2023).
Memory stays flat even for an 8 GB file, and each read moves thousands of bytes instead of the
single byte in Eck's teaching example.

**3. Check before acting.** Before sending a file, I would use the File class (or the newer
Path) to confirm that it exists, is a regular file, and is readable. Bro Code (2020) shows how a
File object represents a file on disk, reports its path, and deletes it. Like Eck's copy program, which refuses to overwrite an existing file
unless the user adds the -f option, my application would never silently overwrite a user's file
(Eck, 2022, Section 11.3).

**4. Write safely.** A download goes into a temporary .part file first. Only when every byte has
arrived is it renamed with Files.move and the ATOMIC_MOVE option, which performs the move as a
single file-system operation (Oracle, n.d.-b). A half-finished download can never be mistaken
for the real file.

**5. Manage errors precisely.** I would open every stream in a try-with-resources block so it is
closed even when an exception occurs, and catch FileNotFoundException separately from other
IOExceptions so the user sees "file not found" rather than a generic failure. Eck (2022, Section
11.1) also points out that PrintWriter methods never throw an IOException, so its checkError()
method must be called to detect write errors. That matters for the small text index of shared files, which I would write with
BufferedWriter and read back line by line with BufferedReader, as Coding with John (2021)
demonstrates.

## Networking Classes and Interfaces

**Establishing connections.** The server listens with a ServerSocket and calls accept(); each
user connects with a Socket. Both use TCP, which Eck (2022, Section 11.4) describes as reliable
two-way communication, so bytes arrive in order or the connection fails visibly. As in my chat
server and in Kumar's (2022) example, the socket's streams are then used exactly like file
streams. Unlike Kumar's single-client example, I would give each connection its own thread from a
thread pool, so a slow upload never blocks other users.

**Transmitting data.** A file needs a simple protocol. I would wrap the socket streams in
DataOutputStream and DataInputStream, then send the file name with writeUTF(), the size with
writeLong(), and finally the bytes. The receiver reads exactly that many bytes. If the connection
drops early, readFully() throws an EOFException instead of returning a partial file (Oracle,
n.d.-a). For downloads from a web mirror, URL and URLConnection give an input stream in a few
lines (Eck, 2022, Section 11.4).

**Robustness.** I would set a read timeout with setSoTimeout() so a stalled client cannot hold a
thread forever, limit the maximum file size, compare a SHA-256 checksum after each transfer, and
let an interrupted download resume from the size of the .part file.

**Security.** Plain sockets send data unencrypted. SSLSocket and SSLServerSocket extend the
normal socket classes with TLS, which protects data against eavesdropping and modification and
lets the client authenticate the server (Oracle, n.d.-c). The server must also distrust file
names: a name such as ../../etc/passwd is a path traversal attack that tries to reach files
outside the shared folder (OWASP Foundation, n.d.). I would normalize every requested path and
reject any that does not stay inside the shared directory, and require users to log in before
they can upload.

**Question for the class:** For large file transfers, would you use one connection per file with
blocking sockets and a thread pool, or a single non-blocking connection (java.nio channels) that
handles many transfers at once? Which trade-offs drive your choice?

Word count: 736

## References

Bro Code. (2020, October 6). *Java File class* [Video]. YouTube.
https://www.youtube.com/watch?v=MwYRVKfb2M0

Codex, A. C. (2023, April 18). *Java file handling: Reading and writing text and binary files*.
REINTECH. https://reintech.io/blog/java-file-handling-reading-writing-text-binary-files

Coding with John. (2021, April 26). *Java file input/output - It's way easier than you think*
[Video]. YouTube. https://www.youtube.com/watch?v=ScUJx4aWRi0

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart and
William Smith Colleges. https://math.hws.edu/javanotes/

Kumar, P. (2022, August 4). *Java socket programming: Server-client tutorial*. DigitalOcean.
https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client

Oracle. (n.d.-a). *Class DataInputStream*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/io/DataInputStream.html

Oracle. (n.d.-b). *Class Files*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/nio/file/Files.html

Oracle. (n.d.-c). *Class SSLSocket*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/javax/net/ssl/SSLSocket.html

OWASP Foundation. (n.d.). *Path traversal*. https://owasp.org/www-community/attacks/Path_Traversal
