# CS 1103 Unit 7: Files and Networking

Learning notes by Nicanor Maswili. Due: discussion post Sunday Oct 18 (final Oct 21), peer
replies Wednesday Oct 21, programming assignment Oct 21, 2026.

## Learning Outcomes

1. Demonstrate file operations and programming with files.
2. Discuss the networking classes and interfaces in Java.
3. Illustrate socket programming.

## Files (Eck 11.2 and 11.3)

| Need | Class | Notes |
|---|---|---|
| Represent a file or folder name | File (or Path in java.nio.file) | exists(), isFile(), length(), delete(), getPath(); does NOT read or write |
| Read text | FileReader wrapped in BufferedReader | readLine() returns null at end of file |
| Write text | FileWriter wrapped in PrintWriter or BufferedWriter | PrintWriter never throws IOException: call checkError() |
| Read or write any file (binary) | FileInputStream / FileOutputStream | bytes; read() returns -1 at end |
| Read or write primitive values | DataInputStream / DataOutputStream | readInt, writeLong, writeUTF, readFully |
| Modern helpers | Files | readAllLines, copy, move (ATOMIC_MOVE), size |

- Opening a missing file for reading throws **FileNotFoundException** (a subclass of IOException).
- Always close streams. The cleanest way is **try-with-resources**: `try (BufferedReader in = ...) { }`.
- Relative paths are resolved from the program's working directory; absolute paths start at the
  root (/ on Linux, C:\ on Windows).
- **Persistent data** (Eck 11.3): save program state to a file on exit and load it on start.
  Choose a meaningful, readable file format so the data can be shared and checked.

## Networking (Eck 11.4)

- java.net is the standard networking package.
- **URL and URLConnection**: open an input stream to a web resource (for example, over HTTP) and
  read it like a file.
- **TCP/IP** gives reliable, ordered, two-way communication. UDP is faster but unreliable.
- **Client/server model**: the server listens with a **ServerSocket** on a port; `accept()`
  blocks until a client connects and returns a **Socket**. The client connects with
  `new Socket(host, port)`.
- After connecting, both sides use `getInputStream()` and `getOutputStream()`, exactly like
  file streams.
- A server that must handle several clients at once needs **threads** (one per client, or a
  thread pool).
- **Security**: SSLSocket and SSLServerSocket add TLS encryption, integrity, and authentication.

### Minimal Server and Client

```java
// Server
try (ServerSocket server = new ServerSocket(5000)) {
    while (true) {
        Socket client = server.accept();             // waits for a connection
        new Thread(() -> serve(client)).start();     // one thread per client
    }
}

// Client
try (Socket socket = new Socket("localhost", 5000);
     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
    out.println("Hello server");
    System.out.println(in.readLine());
}
```

## Reading Questions

1. **Essential file operations and data management:** create or open, read, write or append,
   close, and check or delete (File). Together they let a program keep data between runs, share
   data with other programs, and process data too large for memory, by streaming it.
2. **How protocols shape networked applications:** TCP guarantees complete, ordered data, so it
   suits chat, file transfer, and web pages. UDP drops that guarantee for speed, so it suits live
   video or games. HTTP sits on top of TCP and is what URLConnection speaks. The protocol choice
   decides how the application handles lost data, ordering, and connections.
3. **Role of sockets:** a socket is one endpoint of a two-way connection, identified by an IP
   address and a port. The ServerSocket waits for connections; each accepted Socket gives the
   program input and output streams, so sending data over the network looks like writing to a
   file.

## This Week's Work

- **Assignment:** Online Chat Application (ChatServer, ClientHandler, ChatClient, ChatTest). It
  has unique user IDs, a ConcurrentHashMap user list, a thread per client, broadcasting, the
  commands /users, /help and /quit, and 17 automated socket tests that all pass.
- **Discussion:** file operations and networking for a file-sharing application. It covers byte
  streams, buffering, safe .part downloads with ATOMIC_MOVE, DataInputStream framing, TLS with
  SSLSocket, and path traversal protection.

## Self-Quiz Unit 7

| Q | Answer | Why |
|---|---|---|
| 1 | To read primitive data types from a file | DataInputStream reads int, double, boolean, and so on in binary form |
| 2 | A connection to an HTTP resource | URLConnection is the link to the resource a URL names, usually over HTTP |
| 3 | Writes data to a file | FileWriter is a character output stream to a file |
| 4 | To represent the pathname of a file or directory | File describes a name; streams do the reading and writing |
| 5 | To read text from a character-based input stream | BufferedReader buffers a Reader and adds readLine() |
