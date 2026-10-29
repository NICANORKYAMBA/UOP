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

# Review Quiz 2: Answers and Reasons

| Q | Answer | Why |
|---|---|---|
| 1 | Substring() | String.substring(begin, end) |
| 2 | read() method in FileReader | FileReader.read() reads characters; the other names do not exist |
| 3 | To retrieve an element at the specified index | list.get(i) |
| 4 | equalsIgnoreCase() | Returns true/false ignoring case (compareToIgnoreCase returns an int order) |
| 5 | Easier code navigation and management (less certain) | Packages organize a shared code base so a team can find and manage classes |
| 6 | No, a class can belong to only one package | One package declaration per file |
| 7 | A connection to a specific database | DriverManager.getConnection(url) |
| 8 | setExecutable(), setReadable(), and setWritable() methods in File class | Real File methods |
| 9 | The code will not be compiled due to naming conflicts | Same as Review Quiz 1, accepted by the key |
| 10 | default package | The unnamed package |
| 11 | printf() (less certain) | PrintWriter has both printf and format; printf is the usual answer |
| 12 | FileReader | Readers/Writers are character streams |
| 13 | Checked exception | The compiler forces catch or throws |
| 14 | Implementing DragSource and DropTarget | java.awt.dnd classes |
| 15 | Public | Confirmed by the Review Quiz 1 key |
| 16 | Naming conflicts between classes (less certain) | Importing the exact class you mean resolves which one is used |
| 17 | Setting the cursor property of a component | Toolkit.createCustomCursor(...) then component.setCursor(...) |
| 18 | Retrieves the value of a parameter specified in the HTML tag | <param name=... value=...> |
| 19 | write () method | FileWriter.write(String) |
| 20 | import mypackage.ClassName; (less certain) | The import statement; the fully qualified name also works but is not "the statement" |
| 21 | By using the synchronized keyword | Locks a monitor so one thread runs the block at a time |
| 22 | Yes, a "finally" block can be used independently | try { } finally { } is legal |
| 23 | Execute repetitive tasks | Fires an ActionEvent every n ms on the EDT |
| 24 | When using wildcard imports (less certain) | import java.util.*; import java.awt.*; then List is ambiguous |
| 25 | Interactive applet | Uses buttons and text fields |
| 26 | To get the character at a specific index | charAt |
| 27 | True | Classes with no package statement go in the default package |
| 28 | rollBack() | Connection.rollback() |
| 29 | To avoid naming conflicts | Package names make class names unique |
| 30 | To create instances of generic classes without specifying the type parameter | new ArrayList<>() infers the type |
| 31 | class MyClass<T> { } | Type parameter goes after the class name |
| 32 | Unlimited | No limit in the language |
| 33 | To execute stored procedures | {call proc(?)} |
| 34 | WHERE | Filters rows in SELECT |
| 35 | Update the user interface | Schedules a paint of the component |
| 36 | Optimize repainting of components (less certain) | Collapses many repaint requests into fewer paints; double buffering is a side job |
| 37 | close() | All streams implement Closeable |
| 38 | To assign a local address to a socket | bind attaches the IP and port |
| 39 | False | A default-package class cannot be imported by classes in a named package |
| 40 | JList (less certain) | The list component; JComboBox is a drop-down |
