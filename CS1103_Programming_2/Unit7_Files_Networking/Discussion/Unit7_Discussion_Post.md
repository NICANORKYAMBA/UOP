# File Operations and Networking in a Java File-Sharing Application

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Due:** October 21, 2026

A file-sharing application must deliver every file complete and unchanged, and one user's
problem must never affect anyone else. Building a multi-user chat server this week shaped my
strategies.

## Implementing File Operations Efficiently

**1. Treat every shared file as bytes.** Shared files are often photos or ZIP archives, so I
would use the byte streams FileInputStream and FileOutputStream. Eck
(2022, Section 11.3) makes the same choice for his file-copy program, because a program that
copies any file cannot assume the data is human-readable. Character streams such as FileReader
are only for text (Codex, 2023).

**2. Stream in chunks instead of loading whole files.** I would wrap the streams in
BufferedInputStream and BufferedOutputStream and copy through an 8 KB array. Buffered streams read
data in chunks into an internal buffer, which keeps memory use low on large files (Codex, 2023),
unlike Eck's teaching example, which copies one byte at a time.

**3. Check before acting.** Before sending a file, I would use the File class (or the newer
Path) to confirm that it exists, is a regular file, and is readable. Bro Code (2020) shows how a
File object represents a file on disk, reports its path, and deletes it. Like Eck's copy program,
which refuses to overwrite an existing file unless the user adds the -f option, my application
would never silently overwrite a user's file (Eck, 2022, Section 11.3).

**4. Write safely.** Downloads go into a temporary .part file, which is renamed with Files.move
and ATOMIC_MOVE, a single file-system operation (Oracle, n.d.-b), only when every byte has
arrived. A half-finished download can never be mistaken
for the real file.

**5. Manage errors precisely.** Every stream opens in a try-with-resources block so it closes even
after an exception, and FileNotFoundException is caught separately from other IOExceptions to
give the user a specific message. Eck (2022, Section
11.1) also points out that PrintWriter methods never throw an IOException, so its checkError()
method must be called to detect write errors. That matters for the small text index of shared
files, which I would write with BufferedWriter and read back line by line with BufferedReader, as Coding with John (2021)
demonstrates.

## Networking Classes and Interfaces

**Establishing connections.** The server listens with a ServerSocket and calls accept(); each
user connects with a Socket. Both use TCP, which Eck (2022, Section 11.4) describes as reliable
two-way communication, so bytes arrive in order or the connection fails visibly. As in Kumar's
(2022) example, the socket's streams are then used like file streams, but unlike his
single-client server, mine gives each connection its own pooled thread, so a slow upload never
blocks other users.

**Interfaces that hold it together.** Socket and ServerSocket implement the Closeable interface,
so they work in try-with-resources and are closed even after an error (Oracle, n.d.-c). Each
connection handler implements Runnable so the thread pool can run it, and DataInputStream
implements the DataInput interface, which defines readFully() and the other typed read methods
(Oracle, n.d.-a). Since DataInputStream is not safe for concurrent threads, each connection
keeps its own streams.

**Transmitting data.** I would wrap the socket streams in DataOutputStream and
DataInputStream, then send the file name with writeUTF(), the size with
writeLong(), and finally the bytes. The receiver reads exactly that many bytes. If the connection
drops early, readFully() throws an EOFException instead of returning a partial file (Oracle,
n.d.-a). For downloads from a web mirror, URL and URLConnection give an input stream in a few
lines (Eck, 2022, Section 11.4).

**Robustness.** I would set a read timeout with setSoTimeout(), so a stalled read throws a
SocketTimeoutException instead of holding a thread forever (Oracle, n.d.-c). I would also limit
the maximum file size, compare a SHA-256 checksum after each transfer, and
let an interrupted download resume from the size of the .part file.

**Security.** Plain sockets send data unencrypted. SSLSocket and SSLServerSocket extend the
normal socket classes with TLS, which protects data against eavesdropping and modification and
lets the client authenticate the server (Oracle, n.d.-d). The server must also distrust file
names: a name such as ../../etc/passwd is a path traversal attack that tries to reach files
outside the shared folder (OWASP Foundation, n.d.). I would normalize every requested path, reject any
outside the shared directory, and require users to log in before uploading.

**Question for the class:** For a file-sharing application, would you transfer files over a raw
Socket with your own protocol, or over HTTP using URL and URLConnection? What would you gain or
lose in robustness and security with each choice?

Word count: 743

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

Oracle. (n.d.-c). *Class Socket*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/net/Socket.html

Oracle. (n.d.-d). *Class SSLSocket*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/javax/net/ssl/SSLSocket.html

OWASP Foundation. (n.d.). *Path traversal*. https://owasp.org/www-community/attacks/Path_Traversal
