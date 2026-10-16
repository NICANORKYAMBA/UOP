import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.StandardCharsets;

/**
 * Automated tests for the chat application.
 *
 * <p>Each test starts a real {@link ChatServer} on a free port and connects real TCP clients
 * to it, so the tests check the actual networking code, not a simulation. Run it with
 * {@code java ChatTest}; it prints PASS or FAIL for every check.
 */
public class ChatTest {

    /** How long a test client waits for an expected line before the check fails. */
    private static final int TIMEOUT_MS = 3000;

    /** Number of checks that passed. */
    private static int passed;

    /** Number of checks that failed. */
    private static int failed;

    /** Utility class: not meant to be instantiated. */
    private ChatTest() {
    }

    /**
     * A minimal client that talks to the server directly through a socket.
     */
    private static final class TestClient implements AutoCloseable {
        /** The connection to the server. */
        private final Socket socket;

        /** Lines coming from the server. */
        private final BufferedReader in;

        /** Lines going to the server. */
        private final PrintWriter out;

        /**
         * Connects to the server on this computer.
         *
         * @param port the server's port
         * @throws IOException if the connection fails
         */
        TestClient(int port) throws IOException {
            socket = new Socket("localhost", port);
            socket.setSoTimeout(TIMEOUT_MS);
            in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            out = new PrintWriter(
                    new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
        }

        /**
         * Sends one line to the server.
         *
         * @param line the text to send
         */
        void send(String line) {
            out.println(line);
        }

        /**
         * Reads lines from the server until one contains the given text.
         *
         * @param text the text to wait for
         * @return the first line containing the text, or null if the connection closes or
         *         nothing matching arrives before the timeout
         * @throws IOException if reading fails for another reason
         */
        String readUntil(String text) throws IOException {
            try {
                String line;
                while ((line = in.readLine()) != null) {
                    if (line.contains(text)) {
                        return line;
                    }
                }
            } catch (SocketTimeoutException e) {
                // nothing matching arrived in time: fall through and report null
            }
            return null;
        }

        /**
         * Connects, reads the welcome line, sends a name, and waits for the greeting.
         *
         * @param port    the server's port
         * @param name    the name to join with
         * @param welcome receives the welcome line, so the test can check the user ID
         * @return the connected client
         * @throws IOException if the connection fails
         */
        static TestClient join(int port, String name, StringBuilder welcome) throws IOException {
            TestClient client = new TestClient(port);
            welcome.append(client.readUntil("Your user ID is"));
            client.send(name);
            client.readUntil("Hi ");
            return client;
        }

        /**
         * Drops the connection without /quit, like a crash or a closed window.
         *
         * @throws IOException if closing fails
         */
        void disconnect() throws IOException {
            socket.close();
        }

        /**
         * Closes the connection when the try-with-resources block ends.
         *
         * @throws IOException if closing fails
         */
        @Override
        public void close() throws IOException {
            disconnect();
        }
    }

    /**
     * Runs every check against a real server and prints the results.
     *
     * @param args not used
     * @throws Exception if the server cannot be started
     */
    public static void main(String[] args) throws Exception {
        PrintStream console = System.out;
        System.setOut(new PrintStream(OutputStream.nullOutputStream())); // hide server log

        ChatServer server = new ChatServer(0);
        int port = server.open();
        Thread serverThread = new Thread(server::serve, "server");
        serverThread.setDaemon(true);
        serverThread.start();

        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();
        StringBuilder w3 = new StringBuilder();
        try (TestClient alice = TestClient.join(port, "Alice", w1);
             TestClient bob = TestClient.join(port, "Bob", w2);
             TestClient carol = TestClient.join(port, "Carol", w3)) {

            check(console, "each client is welcomed with a user ID",
                    w1.toString().contains("Your user ID is 1")
                            && w2.toString().contains("Your user ID is 2")
                            && w3.toString().contains("Your user ID is 3"));

            check(console, "existing users are told when someone joins",
                    alice.readUntil("Carol#3 joined the chat. Users online: 3") != null);

            alice.send("/users");
            check(console, "/users lists every connected user with their ID",
                    "Users online (3): Alice#1, Bob#2, Carol#3".equals(
                            alice.readUntil("Users online (")));

            alice.send("Hello everyone!");
            String atBob = bob.readUntil("Alice#1: Hello everyone!");
            String atCarol = carol.readUntil("Alice#1: Hello everyone!");
            String atAlice = alice.readUntil("Alice#1: Hello everyone!");
            check(console, "a message is broadcast to all clients, including the sender",
                    atBob != null && atCarol != null && atAlice != null);
            check(console, "broadcast messages carry a time stamp",
                    atBob != null && atBob.matches("\\[\\d{2}:\\d{2}:\\d{2}] Alice#1: .*"));

            bob.send("Hi Alice, Bob here.");
            check(console, "any client can send, and the others receive it",
                    alice.readUntil("Bob#2: Hi Alice, Bob here.") != null
                            && carol.readUntil("Bob#2: Hi Alice, Bob here.") != null);

            carol.send("   ");
            carol.send("x".repeat(ClientHandler.MAX_MESSAGE_LENGTH + 1));
            check(console, "an over-long message is rejected with a clear reason",
                    carol.readUntil("Message not sent") != null);

            carol.send("/dance");
            check(console, "an unknown command gets a helpful reply",
                    carol.readUntil("Unknown command \"/dance\"") != null);

            carol.send("/quit");
            check(console, "/quit says goodbye to the leaving user",
                    carol.readUntil("Goodbye, Carol!") != null);
            check(console, "the others are told when a user leaves",
                    alice.readUntil("Carol#3 left the chat. Users online: 2") != null);

            bob.disconnect();
            check(console, "a dropped connection is detected and the user removed",
                    alice.readUntil("Bob#2 left the chat. Users online: 1") != null);

            StringBuilder w4 = new StringBuilder();
            try (TestClient dave = TestClient.join(port, "  D@ve!  ", w4)) {
                check(console, "user IDs are never reused after users leave",
                        w4.toString().contains("Your user ID is 4"));
                dave.send("/users");
                check(console, "names are cleaned of spaces and symbols",
                        "Users online (2): Alice#1, Dve#4".equals(
                                dave.readUntil("Users online (")));
            }

            testChatClient(console, port, alice);
        }

        testClientWithoutServer(console);

        server.stop();
        System.setOut(console);
        console.println();
        console.println("Tests passed: " + passed + ", failed: " + failed);
    }

    /**
     * Runs the real ChatClient class with scripted keyboard input.
     *
     * @param console where results are printed
     * @param port    the running server's port
     * @param alice   a connected user who should receive the client's message
     * @throws Exception if the client cannot be run
     */
    private static void testChatClient(PrintStream console, int port, TestClient alice)
            throws Exception {
        String typed = "Erin\nHello from ChatClient\n/quit\n";
        ByteArrayOutputStream screen = new ByteArrayOutputStream();
        ChatClient client = new ChatClient("localhost", port,
                new ByteArrayInputStream(typed.getBytes(StandardCharsets.UTF_8)),
                new PrintStream(screen, true, StandardCharsets.UTF_8));
        client.run();
        String shown = screen.toString(StandardCharsets.UTF_8);

        check(console, "ChatClient connects and shows the server's welcome",
                shown.contains("connected to localhost:" + port)
                        && shown.contains("Your user ID is"));
        check(console, "ChatClient sends typed messages that other users receive",
                alice.readUntil("Hello from ChatClient") != null);
        check(console, "ChatClient leaves cleanly with /quit",
                shown.contains("Goodbye, Erin!"));
    }

    /**
     * Checks that a client started while no server is running explains the problem instead of
     * crashing.
     *
     * @param console where results are printed
     * @throws IOException if a free port cannot be found
     */
    private static void testClientWithoutServer(PrintStream console) throws IOException {
        int unusedPort;
        try (ServerSocket probe = new ServerSocket(0)) {
            unusedPort = probe.getLocalPort(); // free port; closed again right away
        }
        ByteArrayOutputStream screen = new ByteArrayOutputStream();
        new ChatClient("localhost", unusedPort, new ByteArrayInputStream(new byte[0]),
                new PrintStream(screen, true, StandardCharsets.UTF_8)).run();
        check(console, "ChatClient reports a clear error when no server is running",
                screen.toString(StandardCharsets.UTF_8).contains("Is ChatServer running?"));
    }

    /**
     * Records one check and prints PASS or FAIL.
     *
     * @param console     where results are printed
     * @param description what the check verifies
     * @param condition   true if the check passed
     */
    private static void check(PrintStream console, String description, boolean condition) {
        if (condition) {
            passed++;
            console.println("PASS  " + description);
        } else {
            failed++;
            console.println("FAIL  " + description);
        }
    }
}
