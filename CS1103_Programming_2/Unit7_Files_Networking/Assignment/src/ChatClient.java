import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Text-based chat client.
 *
 * <p>The client connects to the {@link ChatServer} and uses two threads. A background
 * listener thread prints every message the server sends, while the main thread reads what the
 * user types and sends it to the server. Because the two jobs run at the same time, messages
 * from other users appear even while this user is typing.
 */
public class ChatClient {

    private final String host;
    private final int port;
    private final BufferedReader keyboard;
    private final PrintStream screen;
    private volatile boolean quitting;

    /**
     * Creates a client. The input and output streams are parameters so the automated tests
     * can drive a client without a real keyboard.
     *
     * @param host   the server's host name or IP address
     * @param port   the server's port
     * @param input  where the user's typing comes from (normally System.in)
     * @param output where messages are shown (normally System.out)
     */
    public ChatClient(String host, int port, InputStream input, PrintStream output) {
        this.host = host;
        this.port = port;
        this.keyboard = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        this.screen = output;
    }

    /** Connects to the server and runs the chat until the user types /quit. */
    public void run() {
        try (Socket socket = new Socket(host, port);
             BufferedReader fromServer = new BufferedReader(
                     new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter toServer = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
                     true)) {

            screen.println("=== Java Chat Client: connected to " + host + ":" + port + " ===");

            Thread listener = new Thread(() -> listen(fromServer), "server-listener");
            listener.setDaemon(true);
            listener.start();

            String typed;
            while ((typed = keyboard.readLine()) != null) {
                if (!listener.isAlive()) {
                    break; // the server has closed the connection
                }
                if (typed.strip().equalsIgnoreCase("/quit")) {
                    quitting = true; // set before sending, so the listener knows we chose to leave
                    toServer.println(typed);
                    break;
                }
                toServer.println(typed);
            }
            listener.join(2000); // let the server's goodbye message be printed
        } catch (ConnectException e) {
            screen.println("Could not connect to the chat server at " + host + ":" + port
                    + ". Is ChatServer running?");
        } catch (IOException e) {
            screen.println("Connection error: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Prints every line the server sends until the connection closes.
     *
     * @param fromServer the reader connected to the server
     */
    private void listen(BufferedReader fromServer) {
        try {
            String message;
            while ((message = fromServer.readLine()) != null) {
                screen.println(message);
            }
            if (!quitting) {
                screen.println("The server closed the connection. Press Enter to exit.");
            }
        } catch (IOException e) {
            if (!quitting) {
                screen.println("Lost the connection to the server.");
            }
        }
    }

    /**
     * Starts the client.
     *
     * @param args optional host (default localhost) and port (default 5000)
     */
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        int port = ChatServer.DEFAULT_PORT;
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("\"" + args[1] + "\" is not a valid port. Using "
                        + ChatServer.DEFAULT_PORT + ".");
            }
        }
        new ChatClient(host, port, System.in, System.out).run();
    }
}
