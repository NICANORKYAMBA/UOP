import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Serves one connected client on its own thread.
 *
 * <p>The handler greets the client with its user ID, asks for a name, registers the user with
 * the server, and then reads the client's lines one at a time. Plain text is broadcast to
 * everyone; lines that start with "/" are commands (/users, /help, /quit).
 */
public class ClientHandler implements Runnable {

    /** Longest chat message the server accepts, in characters. */
    static final int MAX_MESSAGE_LENGTH = 500;

    /** Longest user name, in characters. Longer names are shortened. */
    static final int MAX_NAME_LENGTH = 20;

    private static final String HELP =
            "Commands: /users (who is online), /help (this list), /quit (leave)";

    private final ChatServer server;
    private final Socket socket;
    private final int userId;
    private PrintWriter out;
    private String name;

    /**
     * Creates a handler for a newly accepted connection.
     *
     * @param server the server that owns this client
     * @param socket the client's socket
     * @param userId the unique ID the server assigned to this client
     */
    public ClientHandler(ChatServer server, Socket socket, int userId) {
        this.server = server;
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        try (socket;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8))) {
            out = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

            send("Welcome to the chat server! Your user ID is " + userId + ".");
            send("Please enter your name:");
            name = cleanName(in.readLine());
            if (name == null) {
                return; // the client disconnected before choosing a name
            }
            server.addUser(this);
            send("Hi " + name + "! Type a message and press Enter to send it to everyone.");
            send(HELP);

            String line;
            while ((line = in.readLine()) != null) {
                if (!handleLine(line.strip())) {
                    break;
                }
            }
        } catch (IOException e) {
            server.log("Connection with user " + userId + " was lost: " + e.getMessage());
        } finally {
            server.removeUser(this);
        }
    }

    /**
     * Processes one line typed by the client.
     *
     * @param line the line with surrounding spaces removed
     * @return false if the client wants to leave, true otherwise
     */
    private boolean handleLine(String line) {
        if (line.isEmpty()) {
            return true; // ignore empty lines
        }
        switch (line.toLowerCase()) {
            case "/quit" -> {
                send("Goodbye, " + name + "!");
                return false;
            }
            case "/users" -> {
                send("Users online (" + server.getUserList().size() + "): "
                        + String.join(", ", server.getUserList()));
                return true;
            }
            case "/help" -> {
                send(HELP);
                return true;
            }
            default -> {
                if (line.startsWith("/")) {
                    send("Unknown command \"" + line + "\". Type /help to see the commands.");
                } else if (line.length() > MAX_MESSAGE_LENGTH) {
                    send("Message not sent: it is longer than " + MAX_MESSAGE_LENGTH
                            + " characters.");
                } else {
                    server.broadcast("[" + ChatServer.timestamp() + "] " + getDisplayName()
                            + ": " + line);
                }
                return true;
            }
        }
    }

    /**
     * Turns the raw name the client typed into a safe display name.
     *
     * @param rawName the line the client sent, or null if it disconnected
     * @return the cleaned name, a default name if it was blank, or null if disconnected
     */
    private String cleanName(String rawName) {
        if (rawName == null) {
            return null;
        }
        String cleaned = rawName.strip().replaceAll("[^A-Za-z0-9_-]", "");
        if (cleaned.isEmpty()) {
            return "User";
        }
        return cleaned.length() > MAX_NAME_LENGTH ? cleaned.substring(0, MAX_NAME_LENGTH) : cleaned;
    }

    /**
     * Sends one line to this client. Synchronized so that two broadcasts arriving at the same
     * time cannot mix their characters together.
     *
     * @param message the line to send
     */
    synchronized void send(String message) {
        if (out != null) {
            out.println(message);
        }
    }

    /** Closes the connection; the reading loop then ends and the user is removed. */
    void close() {
        try {
            socket.close();
        } catch (IOException e) {
            server.log("Error while closing the connection of user " + userId);
        }
    }

    /**
     * Returns this client's unique user ID.
     *
     * @return the user ID
     */
    int getUserId() {
        return userId;
    }

    /**
     * Returns the name shown in the chat: the chosen name plus the unique ID, e.g. Alice#1.
     * The ID keeps two users with the same name apart.
     *
     * @return the display name
     */
    String getDisplayName() {
        return name + "#" + userId;
    }

    /**
     * Returns the client's network address, for the server log.
     *
     * @return the remote address and port
     */
    String getAddress() {
        return socket.getRemoteSocketAddress().toString();
    }
}
