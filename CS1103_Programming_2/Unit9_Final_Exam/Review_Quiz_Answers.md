# CS1103 Review Quiz: Answers and Reasons

Questions marked "less certain" have loosely worded options; check them against the quiz
feedback after submitting and keep the course key's answer for the final.
Q16, Q14, Q25 and Q30 were checked by running real Java code (JDK, javac).

| Q | Answer | Why |
|---|---|---|
| 1 | UPDATE | SQL `UPDATE table SET ...` run through executeUpdate |
| 2 | GridLayout | Equal-sized rows and columns |
| 3 | To create a server socket (less certain) | ServerSocket listens on a port and accept() returns a Socket per client |
| 4 | Control the placement of components | Size and position of components in a container |
| 5 | Uniform Resource Locator | Standard name |
| 6 | To insert new data | Create = SQL INSERT |
| 7 | `MyClass<Integer> obj = new MyClass<>();` | Diamond operator; primitives like int are not allowed |
| 8 | 1package | Identifiers cannot start with a digit |
| 9 | read() | InputStreamReader has read(char[]) for many chars; readLine() belongs to BufferedReader |
| 10 | Displaying a dialog box | JDialog is a dialog window |
| 11 | Waits for a thread to finish its execution before proceeding | t.join() blocks until t ends |
| 12 | UDP | DatagramSocket sends UDP packets |
| 13 | HashMap | Map<K, V> stores key-value pairs |
| 14 | 5 | Thread.NORM_PRIORITY = 5 (verified) |
| 15 | FlowLayout (course key) | The quiz key says FlowLayout. Technically BoxLayout.Y_AXIS is the true single-column layout, but answer FlowLayout on the exam |
| 16 | 5 | Verified |
| 17 | Inet4Address | The only real Java class listed (subclass of InetAddress) |
| 18 | Thread | `class MyThread extends Thread`; Runnable is an interface |
| 19 | To group related classes and reduce naming conflicts | Main purpose of packages |
| 20 | Internet Protocol (course key) | Confirmed by the key. Careful: "Internal Protocol" is the trap option right above it |
| 21 | Basic file operations like creating, deleting, and copying files | java.nio.file.Files: createFile, delete, copy, move |
| 22 | Checks if the current thread has been interrupted | Static Thread.interrupted() (also clears the flag) |
| 23 | Public | Only public classes are visible outside the package |
| 24 | To handle timeout scenarios when establishing a socket connection (course key) | The quiz key ties it to connecting (Socket.connect with a timeout), not to data transfer |
| 25 | The code will not compile due to naming conflicts | Verified: javac reports "a type with the same simple name is already defined by the single-type-import" |
| 26 | Type safety and reduced code duplication | Errors caught at compile time; one class for many types |
| 27 | GraphicsContext | Canvas.getGraphicsContext2D() draws paths and shapes |
| 28 | FileReader reads characters, FileInputStream reads bytes | Reader vs InputStream |
| 29 | To enable communication with multiple recipients | Multicast groups |
| 30 | "Hello12" | Left to right string concatenation (verified) |
| 31 | It returns the character at the specified index | charAt |
| 32 | InetAddress | InetAddress.getByName("host") does DNS lookup |
| 33 | Using read(byte[] buffer, int offset, int length) method | Reads up to length bytes into the buffer |
| 34 | Creating a card-based user interface | Only one "card" panel visible at a time |
| 35 | Writing formatted text | print, println, printf |
| 36 | It represents the removal of generic type information during runtime (less certain) | Strictly, reified means type info is kept at runtime; Java generics are not reified because of type erasure. This option is the one about runtime type information |
| 37 | Number of rows affected | Returns an int row count |
| 38 | GridBagLayout | gridwidth / gridheight let a component span cells |
| 39 | Provides methods for querying thread information in the Java virtual machine | java.lang.management.ThreadMXBean |
| 40 | Linking a property of one object to another | e.g. label.textProperty().bind(...) |
