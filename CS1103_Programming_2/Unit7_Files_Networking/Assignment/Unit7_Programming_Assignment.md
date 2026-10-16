# Programming Assignment Unit 7: Online Chat Application

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Instructor:** Dr. Abeena Azad
**Due:** October 21, 2026

## Overview

This program is a text-based online chat application in Java. A central server, ChatServer,
accepts any number of clients over TCP sockets, gives each user a unique ID, keeps a list of the
users who are online, and broadcasts every message to all of them. Each user runs ChatClient, which
sends what the user types and, at the same time, displays the messages of everyone else. As Eck
(2022) explains, Java treats a network connection like any other source of input and output, so
once a socket is open the program reads and writes it with the same stream classes it would use
for a file.

## Design

The program has four classes, each with one job (Table 1, Figure 1).

**Table 1**

*Classes in the Program*

| Class | Role |
|---|---|
| ChatServer | Opens the ServerSocket, accepts connections, assigns user IDs, keeps the user list, and broadcasts messages |
| ClientHandler | Serves one client on its own thread: asks for a name, reads messages and commands, and sends replies |
| ChatClient | The text-based client: one thread sends what the user types, another prints what the server sends |
| ChatTest | 17 automated checks that start a real server and connect real socket clients |

**Figure 1**

*Architecture of the Chat Application*

[FIGURE figures/fig1_architecture.png]

### Server Implementation

**Socket programming and connection handling.** ChatServer creates a ServerSocket on port 5000
(or a port given on the command line) and loops on accept(). Eck (2022) notes that accept()
blocks until a client connects and then returns a Socket for talking to that client. He also
names the key problem for a chat server: "to allow multiple clients to be connected at the same
time, it is necessary to use threads" (Eck, 2022, Section 11.4.2). My server therefore never talks to a client inside the
accept loop. It hands each new Socket to a ClientHandler running on a thread from a cached thread
pool and goes straight back to waiting for the next connection. This is the same structure as
Oracle's multi-client KKMultiServer example, where the main server only listens and a separate
thread object serves each connection (Oracle, n.d.-c). It is also the main difference from
Kumar's (2022) socket example, which reads one message per connection and serves clients one at
a time.

**User management.** Every accepted connection gets the next number from an AtomicInteger, so
user IDs are unique and are never reused, even after a user leaves. Once the user types a name,
the handler registers itself in connectedUsers, a ConcurrentHashMap<Integer, ClientHandler>
keyed by user ID. I chose ConcurrentHashMap because several handler threads add, remove, and
read users at the same time, and this class is fully thread-safe while still allowing reads
without locking (Oracle, n.d.-a). Users are shown as Name#ID, for example Alice#1, so two people
with the same name are still told apart. The /users command lists everyone online, ordered by ID.

**Broadcasting.** broadcast() sends a message to every handler in the map, including the
sender, so the sender sees that the message was delivered. ClientHandler.send() is synchronized,
so if two users send messages at the same instant, the two lines are never mixed together on one
connection.

**Leaving and failures.** Each handler opens its socket and reader in a try-with-resources
statement, which guarantees that they are closed when the handler finishes (Oracle, n.d.-b). The
user is removed from the map in a finally block, so the others are told that the user left
whether the user typed /quit, closed the window, or lost the network connection. When the server
is stopped with Ctrl+C, a shutdown hook closes every connection cleanly.

### Client Implementation

ChatClient connects with new Socket(host, port) and wraps the socket's streams in a
BufferedReader and an auto-flushing PrintWriter, both using UTF-8. Chat is two-way at the same
time, so the client uses two threads:

1. The **main thread** reads lines from the keyboard and sends each one to the server.
2. A background **listener thread** reads lines from the server and prints them.

Because the listener runs on its own, messages from other users appear immediately, even while
this user is in the middle of typing. When the user types /quit, the client sends it, waits for
the server's goodbye, and exits. If the server goes away, the listener reports that the server
closed the connection. If no server is running at all, the client prints a clear message
instead of a stack trace.

### The Text-Based User Interface and Protocol

The protocol is plain text, one message per line. The server greets each client with its user ID,
asks for a name, and then accepts messages and the commands in Table 2. Every chat message is
shown with a time stamp and the sender's name and ID.

**Table 2**

*What the User Can Type*

| Input | Result |
|---|---|
| any text | Broadcast to everyone as [time] Name#ID: text |
| /users | Lists everyone online with their user IDs |
| /help | Shows the list of commands |
| /quit | Leaves the chat; everyone else is told |

### Error Handling and Robustness

**Table 3**

*Error Cases and How They Are Handled*

| Situation | Handling |
|---|---|
| Client started with no server running | ConnectException caught: "Could not connect ... Is ChatServer running?" |
| User closes the window without /quit | readLine returns null or throws; finally block removes the user and tells the others |
| Server stopped with Ctrl+C | Shutdown hook closes all sockets; clients print "The server closed the connection" |
| Port already in use or invalid port argument | Clear message, or fall back to the default port 5000 |
| Empty message | Ignored |
| Message longer than 500 characters | Rejected with the reason |
| Unknown command such as /hello | Reply suggests /help |
| Name with spaces or symbols | Cleaned to letters, digits, _ and -, at most 20 characters |

## Requirements Checklist

**Table 4**

*Assignment Requirements and Where They Are Met*

| Requirement | Where it is met |
|---|---|
| ChatServer class using socket programming | ServerSocket and accept() loop in ChatServer |
| Manage connections from multiple clients | One ClientHandler thread per client from a thread pool |
| Assign a unique user ID to each client | AtomicInteger nextUserId; IDs are never reused |
| Maintain a list of connected users | ConcurrentHashMap connectedUsers, shown with /users |
| ChatClient connects using sockets | new Socket(host, port) in ChatClient.run |
| Send messages to the server, which broadcasts them | ChatClient main thread, then ChatServer.broadcast |
| Receive messages from other users | ChatClient listener thread |
| Simple text-based user interface | Prompts, commands, time stamps, join and leave notices (Figures 3 and 4) |
| Well-commented source code | Javadoc on every class and method |
| README file | README.md and README.txt in the Assignment folder (also summarized below) |

## Testing

### Automated Tests

ChatTest starts a real server on a free port and connects real TCP clients to it, so it tests the
actual networking code rather than a simulation. It also drives the real ChatClient class by
giving it scripted keyboard input. All 17 checks pass (Figure 2), and they passed in ten repeated
runs, which matters for multi-threaded code. To make sure the tests can catch real mistakes, I
temporarily broke the broadcast method so that half of the users stopped receiving messages, and
the tests reported the failures.

**Figure 2**

*Compiling the Program and Running the 17 Automated Checks*

[FIGURE figures/fig2_tests.png]

### Live Chat Session

I then ran the server and two clients in three terminal windows. In Figure 3, Alice (user ID 1)
and Bob (user ID 2) join, exchange messages that both of them receive, Bob lists the users with
/users, Alice tries an unknown command, and Bob leaves with /quit. The server window logs every
connection with its user ID.

**Figure 3**

*Server and Two Clients: Joining, Broadcasting, /users, an Unknown Command, and /quit*

[FIGURE figures/fig3_chat_session.png]

In Figure 4, Carol joins in Bob's old window and receives user ID 3, which shows that IDs are not
reused. Carol and Alice chat, Carol lists the users, Alice leaves, and finally the server is
stopped with Ctrl+C. Carol's client reports that the server closed the connection instead of
crashing.

**Figure 4**

*A New User Joining, a User Leaving, and the Server Shutting Down*

[FIGURE figures/fig4_join_leave_shutdown.png]

## README: How to Run the Application

The README file submitted with the code contains these instructions.

```
1. Compile (Java 17 or newer), from the Assignment folder:
       javac -d out src/*.java
2. Start the server (default port 5000; another port can be given):
       java -cp out ChatServer
       java -cp out ChatServer 6000
3. In a new terminal for each user, start a client (default localhost 5000):
       java -cp out ChatClient
       java -cp out ChatClient 192.168.1.20 6000
4. Type your name, then type messages and press Enter.
   Commands: /users  /help  /quit
5. Run the automated tests (they start their own server):
       java -cp out ChatTest

In IntelliJ IDEA: run ChatServer, then run ChatClient. For a second client,
open Run > Edit Configurations > ChatClient > Modify options >
Allow multiple instances, and run ChatClient again.
```

## Source Code

[CODE src/ChatServer.java]

[CODE src/ClientHandler.java]

[CODE src/ChatClient.java]

[CODE src/ChatTest.java]

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart and
William Smith Colleges. https://math.hws.edu/javanotes/c11/s4.html

Kumar, P. (2022, August 4). *Java socket programming: Server-client tutorial*. DigitalOcean.
https://www.digitalocean.com/community/tutorials/java-socket-programming-server-client

Oracle. (n.d.-a). *Class ConcurrentHashMap<K,V>*. Java SE 21 & JDK 21 API documentation.
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/ConcurrentHashMap.html

Oracle. (n.d.-b). *The try-with-resources statement*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html

Oracle. (n.d.-c). *Writing the server side of a socket*. The Java Tutorials.
https://docs.oracle.com/javase/tutorial/networking/sockets/clientServer.html
