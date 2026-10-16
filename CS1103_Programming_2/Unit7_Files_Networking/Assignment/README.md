# Online Chat Application (CS 1103 Unit 7)

Author: Nicanor Maswili

A text-based chat application written in Java. One ChatServer accepts any number of ChatClient
programs over TCP sockets, gives every user a unique ID, keeps the list of who is online, and
broadcasts each message to everyone.

## Files

| File | Purpose |
|---|---|
| src/ChatServer.java | The server: listens on a port, accepts clients, assigns user IDs, keeps the user list, broadcasts messages |
| src/ClientHandler.java | Serves one connected client on its own thread: name, messages, and commands |
| src/ChatClient.java | The text-based client: one thread sends what you type, another prints incoming messages |
| src/ChatTest.java | 17 automated checks that start a real server and connect real socket clients |

## Requirements

Java 17 or newer (the code uses switch expressions and Stream.toList). No external libraries.

## How to Run (Terminal)

1. Open a terminal in the Assignment folder and compile:

   javac -d out src/*.java

2. Start the server (default port 5000, or give another port as an argument):

   java -cp out ChatServer
   java -cp out ChatServer 6000

3. Open a second terminal for each user and start a client (default localhost and 5000):

   java -cp out ChatClient
   java -cp out ChatClient 192.168.1.20 6000

4. Type your name when asked, then type messages and press Enter.

5. Run the automated tests (no server needs to be running; the test starts its own):

   java -cp out ChatTest

## How to Run (IntelliJ IDEA)

1. Open the Assignment folder as a project.
2. Right-click ChatServer and choose Run.
3. Right-click ChatClient and choose Run. To start a second client, open Run > Edit
   Configurations, select ChatClient, choose Modify options > Allow multiple instances, and run
   it again. Each client gets its own tab in the Run window.
4. Click inside a client's Run tab to type.

## Commands

| Type | Effect |
|---|---|
| any text | Sent to everyone, shown as [time] Name#ID: text |
| /users | Lists everyone online with their user IDs |
| /help | Shows the list of commands |
| /quit | Leaves the chat |

Press Ctrl+C in the server window to stop the server. Every client is told that the server
closed the connection.

## Implementation Details

- **Server and user management.** ChatServer opens a ServerSocket and loops on accept(). Every
  new connection gets the next number from an AtomicInteger, so user IDs are unique and never
  reused, even after a user leaves. Connected users are stored in a
  ConcurrentHashMap<Integer, ClientHandler>, which is safe to read and change from many threads.
- **Connection handling.** Each client runs on its own ClientHandler thread from a cached thread
  pool, so many users can chat at once and a slow user never blocks the others. Sockets and
  streams are opened in try-with-resources blocks, and the user is removed in a finally block,
  so a user who closes the window without /quit is still cleaned up.
- **Broadcasting.** ClientHandler.send is synchronized, so two messages arriving at the same
  moment are never mixed together on one connection. Every message is also sent back to its
  sender as confirmation that it was delivered.
- **Client.** ChatClient uses two threads. The main thread reads the keyboard and sends each line;
  a background listener thread prints every line from the server, so messages appear even while
  the user is typing.
- **Protocol.** Plain UTF-8 text, one message per line. The server greets the client, asks for a
  name, and then accepts messages and commands.
- **Validation.** Names are limited to letters, digits, _ and - (at most 20 characters). Empty
  messages are ignored, messages over 500 characters are rejected with a reason, and unknown
  commands get a helpful reply.
- **Errors.** A client started with no server running prints a clear message instead of a stack
  trace. Invalid port arguments fall back to the default port.
