import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The central server of the chat application.
 *
 * <p>The server listens on a TCP port and accepts any number of clients. Each client gets a
 * unique user ID and its own {@link ClientHandler} thread, so one slow client never blocks the
 * others. The server keeps the list of connected users and broadcasts every chat message to all
 * of them.
 */
public class ChatServer {

    /** Port used when none is given on the command line. */
    public static final int DEFAULT_PORT = 5000;

    private static final DateTimeFormatter CLOCK = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final int port;
    private final AtomicInteger nextUserId = new AtomicInteger(1);
    private final Map<Integer, ClientHandler> connectedUsers = new ConcurrentHashMap<>();
    private final ExecutorService clientThreads = Executors.newCachedThreadPool();
    private ServerSocket serverSocket;
    private volatile boolean running;

    /**
     * Creates a server that will listen on the given port.
     *
     * @param port the TCP port, or 0 to let the operating system choose a free one
     */
    public ChatServer(int port) {
        this.port = port;
    }

    /**
     * Opens the server socket so clients can start connecting.
     *
     * @return the port the server is actually listening on
     * @throws IOException if the port is already in use or cannot be opened
     */
    public int open() throws IOException {
        serverSocket = new ServerSocket(port);
        running = true;
        log("Chat server started on port " + serverSocket.getLocalPort()
                + ". Waiting for clients...");
        return serverSocket.getLocalPort();
    }

    /**
     * Accepts clients until {@link #stop()} is called. Every accepted client is given the next
     * user ID and handed to its own thread from the pool.
     */
    public void serve() {
        while (running) {
            try {
                Socket socket = serverSocket.accept();
                int userId = nextUserId.getAndIncrement();
                clientThreads.execute(new ClientHandler(this, socket, userId));
            } catch (IOException e) {
                if (running) {
                    log("Could not accept a connection: " + e.getMessage());
                }
            }
        }
    }

    /**
     * Adds a client to the list of connected users and tells everyone that the user joined.
     *
     * @param user the handler of the user who has just chosen a name
     */
    void addUser(ClientHandler user) {
        connectedUsers.put(user.getUserId(), user);
        log(user.getDisplayName() + " connected from " + user.getAddress()
                + " (users online: " + connectedUsers.size() + ")");
        broadcast("*** " + user.getDisplayName() + " joined the chat. Users online: "
                + connectedUsers.size());
    }

    /**
     * Removes a client from the list of connected users and tells the others that the user
     * left. Calling it twice for the same user has no further effect.
     *
     * @param user the handler of the user who disconnected
     */
    void removeUser(ClientHandler user) {
        if (connectedUsers.remove(user.getUserId()) != null) {
            log(user.getDisplayName() + " disconnected (users online: "
                    + connectedUsers.size() + ")");
            broadcast("*** " + user.getDisplayName() + " left the chat. Users online: "
                    + connectedUsers.size());
        }
    }

    /**
     * Sends a message to every connected user, including the sender, so the sender can see
     * that the message was delivered.
     *
     * @param message the text to send
     */
    void broadcast(String message) {
        for (ClientHandler user : connectedUsers.values()) {
            user.send(message);
        }
    }

    /**
     * Returns the display names of all connected users, ordered by user ID.
     *
     * @return a list such as [Alice#1, Bob#2]
     */
    List<String> getUserList() {
        return connectedUsers.values().stream()
                .sorted((a, b) -> Integer.compare(a.getUserId(), b.getUserId()))
                .map(ClientHandler::getDisplayName)
                .toList();
    }

    /** Stops accepting clients and closes every open connection. */
    public void stop() {
        running = false;
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            log("Error while closing the server socket: " + e.getMessage());
        }
        for (ClientHandler user : connectedUsers.values()) {
            user.close();
        }
        clientThreads.shutdownNow();
        log("Chat server stopped.");
    }

    /**
     * Returns the current time formatted for chat messages and log lines.
     *
     * @return the time as HH:mm:ss
     */
    static String timestamp() {
        return LocalTime.now().format(CLOCK);
    }

    /**
     * Prints a time-stamped line to the server console.
     *
     * @param text the event to log
     */
    void log(String text) {
        System.out.println("[" + timestamp() + "] " + text);
    }

    /**
     * Starts the server.
     *
     * @param args optional port number (default 5000)
     */
    public static void main(String[] args) {
        int port = DEFAULT_PORT;
        if (args.length > 0) {
            try {
                port = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("\"" + args[0] + "\" is not a valid port. Using "
                        + DEFAULT_PORT + ".");
            }
        }

        ChatServer server = new ChatServer(port);
        try {
            server.open();
        } catch (IOException e) {
            System.out.println("Could not start the server on port " + port + ": "
                    + e.getMessage());
            return;
        }
        Runtime.getRuntime().addShutdownHook(new Thread(server::stop));
        server.serve();
    }
}
