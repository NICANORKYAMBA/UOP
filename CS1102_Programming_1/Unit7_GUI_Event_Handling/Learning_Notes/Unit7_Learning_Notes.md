# CS 1102 — Unit 7: Graphical User Interfaces (GUIs) with Event Handling
## Comprehensive Learning Notes
### Source: Eck (2022), Chapter 6 (Sections 6.1–6.7), Chapter 13 (Sections 13.1–13.3)

---

## Part 1: The Basic GUI Application (Section 6.1)

### 1.1 What is a GUI?

A **Graphical User Interface (GUI)** is a visual interface that allows users to interact with a program through graphical elements — windows, buttons, text fields, menus — rather than text-based commands. Eck (2022) explains that GUI programming is fundamentally different from console programming because it is **event-driven**: the program waits for user actions (clicks, key presses, mouse movements) and responds to them (Section 6.1).

### 1.2 Java GUI Frameworks

| Framework | Description | Status |
|-----------|-------------|--------|
| **Swing** | Mature, lightweight GUI toolkit built into Java SE | Stable, widely used |
| **JavaFX** | Modern GUI framework with CSS styling, FXML, animations | Recommended for new projects |
| **AWT** | Original Java GUI toolkit (heavyweight, platform-dependent) | Legacy — avoid for new code |

### 1.3 Basic Swing Application Structure

```java
import javax.swing.*;
import java.awt.*;

public class BasicGUI {
    public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame("My First GUI");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);  // center on screen

        // Add a label
        JLabel label = new JLabel("Hello, GUI!", SwingConstants.CENTER);
        frame.add(label);

        // Make visible
        frame.setVisible(true);
    }
}
```

### 1.4 Key Swing Components

| Component | Class | Purpose |
|-----------|-------|---------|
| Window/Frame | `JFrame` | Top-level container for the application |
| Label | `JLabel` | Displays text or images (non-editable) |
| Button | `JButton` | Clickable button that triggers an action |
| Text Field | `JTextField` | Single-line text input |
| Text Area | `JTextArea` | Multi-line text input |
| Checkbox | `JCheckBox` | Toggle option (on/off) |
| Radio Button | `JRadioButton` | Mutually exclusive selection (grouped) |
| Combo Box | `JComboBox` | Dropdown selection list |
| Table | `JTable` | Displays data in rows and columns |
| Menu Bar | `JMenuBar` | Top menu bar with dropdown menus |
| Panel | `JPanel` | Container for organizing components |
| Dialog | `JOptionPane` | Popup messages, inputs, confirmations |

---

## Part 2: Event-Driven Programming (Section 6.3–6.4)

### 2.1 What is Event-Driven Programming?

In event-driven programming, the flow of the program is determined by **events** — user actions like clicking a button, typing text, or selecting a menu item. The program does not execute sequentially from top to bottom; instead, it sets up the GUI, registers **event listeners**, and then waits for events to occur (Eck, 2022, Section 6.3).

### 2.2 The Event Handling Model

```
User Action → Event Object Created → Event Listener Notified → Handler Method Executes
```

**Three components:**
1. **Event Source** — the component that generates the event (e.g., a JButton)
2. **Event Object** — contains information about the event (e.g., ActionEvent)
3. **Event Listener** — the object that receives and handles the event

### 2.3 ActionListener Interface

The most common event listener for buttons and menu items:

```java
import java.awt.event.*;

public class MyApp implements ActionListener {
    JButton button;

    public MyApp() {
        button = new JButton("Click Me");
        button.addActionListener(this);  // register this object as listener
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // This method is called when the button is clicked
        System.out.println("Button was clicked!");
    }
}
```

### 2.4 Lambda Expressions for Event Handling (Java 8+)

A more concise way to handle events:

```java
button.addActionListener(e -> {
    System.out.println("Button clicked!");
    label.setText("You clicked the button");
});
```

### 2.5 Common Event Types

| Event | Listener Interface | Triggered By |
|-------|-------------------|--------------|
| Button click | `ActionListener` | JButton, JMenuItem, JTextField (Enter) |
| Mouse click | `MouseListener` | Any component |
| Mouse movement | `MouseMotionListener` | Any component |
| Key press | `KeyListener` | Any focused component |
| Window events | `WindowListener` | JFrame (close, minimize, etc.) |
| Selection change | `ItemListener` | JCheckBox, JComboBox |
| List selection | `ListSelectionListener` | JList, JTable |

---

## Part 3: Basic Components (Section 6.5)

### 3.1 JButton

```java
JButton btn = new JButton("Submit");
btn.addActionListener(e -> handleSubmit());
```

### 3.2 JTextField and JLabel

```java
JLabel nameLabel = new JLabel("Name:");
JTextField nameField = new JTextField(20);  // 20 columns wide

// Get text from field
String name = nameField.getText();

// Set text in field
nameField.setText("Default Value");
```

### 3.3 JCheckBox and JRadioButton

```java
// Checkbox — independent toggle
JCheckBox check = new JCheckBox("I agree");
check.addItemListener(e -> {
    boolean selected = check.isSelected();
});

// Radio buttons — mutually exclusive (must be grouped)
JRadioButton opt1 = new JRadioButton("Option A");
JRadioButton opt2 = new JRadioButton("Option B");
ButtonGroup group = new ButtonGroup();
group.add(opt1);
group.add(opt2);
```

### 3.4 JComboBox (Dropdown)

```java
String[] courses = {"CS1101", "CS1102", "MATH101"};
JComboBox<String> courseBox = new JComboBox<>(courses);
courseBox.addActionListener(e -> {
    String selected = (String) courseBox.getSelectedItem();
});
```

### 3.5 JTable

```java
String[] columns = {"ID", "Name", "Grade"};
Object[][] data = {
    {1001, "Alice Smith", "A"},
    {1002, "Bob Jones", "B+"},
};
JTable table = new JTable(data, columns);
JScrollPane scrollPane = new JScrollPane(table);
```

### 3.6 JOptionPane (Dialogs)

```java
// Information message
JOptionPane.showMessageDialog(frame, "Student added successfully!");

// Error message
JOptionPane.showMessageDialog(frame, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);

// Input dialog
String input = JOptionPane.showInputDialog(frame, "Enter student name:");

// Confirmation dialog
int result = JOptionPane.showConfirmDialog(frame, "Are you sure?");
```

---

## Part 4: Layout Management (Section 6.6)

### 4.1 Layout Managers

Layout managers control how components are arranged within a container:

| Layout | Description | Use Case |
|--------|-------------|----------|
| `FlowLayout` | Left-to-right, wraps to next line | Simple toolbars |
| `BorderLayout` | 5 regions: North, South, East, West, Center | Main window layout |
| `GridLayout` | Equal-sized grid of rows and columns | Forms, calculators |
| `BoxLayout` | Single row or column | Vertical/horizontal stacking |
| `GridBagLayout` | Flexible grid with varying cell sizes | Complex forms |

### 4.2 BorderLayout Example

```java
JFrame frame = new JFrame("Layout Demo");
frame.setLayout(new BorderLayout());

frame.add(new JButton("Menu"), BorderLayout.NORTH);
frame.add(new JButton("Content"), BorderLayout.CENTER);
frame.add(new JButton("Status"), BorderLayout.SOUTH);
```

### 4.3 Nested Panels for Complex Layouts

```java
JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
formPanel.add(new JLabel("Name:"));
formPanel.add(new JTextField(20));
formPanel.add(new JLabel("ID:"));
formPanel.add(new JTextField(20));
formPanel.add(new JLabel("Email:"));
formPanel.add(new JTextField(20));

JPanel buttonPanel = new JPanel(new FlowLayout());
buttonPanel.add(new JButton("Save"));
buttonPanel.add(new JButton("Cancel"));

JFrame frame = new JFrame();
frame.setLayout(new BorderLayout());
frame.add(formPanel, BorderLayout.CENTER);
frame.add(buttonPanel, BorderLayout.SOUTH);
```

---

## Part 5: Menus and Complete Programs (Section 6.7)

### 5.1 Menu Bar Structure

```java
JMenuBar menuBar = new JMenuBar();

JMenu fileMenu = new JMenu("File");
JMenuItem addItem = new JMenuItem("Add Student");
JMenuItem exitItem = new JMenuItem("Exit");

addItem.addActionListener(e -> showAddStudentForm());
exitItem.addActionListener(e -> System.exit(0));

fileMenu.add(addItem);
fileMenu.addSeparator();
fileMenu.add(exitItem);

menuBar.add(fileMenu);
frame.setJMenuBar(menuBar);
```

---

## Part 6: Dynamic Interface Updates

### 6.1 Updating Components at Runtime

GUI components can be updated dynamically in response to events:

```java
// Update a label
label.setText("New text");

// Update a table model
DefaultTableModel model = (DefaultTableModel) table.getModel();
model.addRow(new Object[]{1003, "Carol White", "A-"});

// Remove a row
model.removeRow(selectedRow);

// Refresh a combo box
comboBox.removeAllItems();
for (String item : newItems) {
    comboBox.addItem(item);
}
```

### 6.2 TableModel for Dynamic Tables

```java
DefaultTableModel model = new DefaultTableModel(
    new String[]{"ID", "Name", "Email"}, 0  // 0 initial rows
);
JTable table = new JTable(model);

// Add data dynamically
model.addRow(new Object[]{1001, "Alice", "alice@email.com"});
model.addRow(new Object[]{1002, "Bob", "bob@email.com"});

// Table automatically updates when model changes
```

---

## Key Terms Summary

| Term | Definition |
|------|-----------|
| GUI | Graphical User Interface — visual interface for user interaction |
| Event | User action (click, key press, selection) that triggers a response |
| Event Listener | Object that receives and handles events |
| Event Handler | Method that executes in response to an event |
| Event Source | Component that generates the event |
| Swing | Java's built-in lightweight GUI toolkit |
| JavaFX | Modern Java GUI framework with CSS and FXML support |
| Layout Manager | Object that controls component arrangement in a container |
| JFrame | Top-level window container in Swing |
| JPanel | Lightweight container for grouping components |
| ActionListener | Interface for handling button clicks and menu selections |
| DefaultTableModel | Data model for JTable that supports dynamic updates |
| JOptionPane | Utility class for standard dialog boxes |

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Creative Commons CC 4.0. [https://math.hws.edu/javanotes/](https://math.hws.edu/javanotes/)

BoostMyTool. (2021, August 17). *Create your first Java GUI using Eclipse IDE 2021* [Video]. YouTube. https://youtu.be/5vSyylPPEko

Ken. (2020, May 7). *Java tutorial 82 — Event-driven programming* [Video]. YouTube. https://youtu.be/sNPXpMSge0g

Lee, A. (2020, February 7). *Java GUI tutorial — Make a GUI in 13 minutes* [Video]. YouTube. https://youtu.be/Kmgo00avvEw
