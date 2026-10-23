# CS 1103 Unit 8: Advanced GUI Programming

Learning notes by Nicanor Maswili. Due: programming assignment and Self-Quiz, October 28, 2026.
(No discussion forum this unit.)

## Learning Outcomes

1. Identify advanced graphical features available for GUI programming in Java.
2. Illustrate design skills for GUI applications, including effective user interfaces.

## Key Ideas

- **Event-driven programs** (Eck, Ch. 6): the program waits for events (clicks, keys) and runs a
  handler for each one, instead of running straight through.
- **Swing vs JavaFX:** Swing (javax.swing) ships with every JDK; JavaFX is newer, with CSS
  styling, properties and bindings, animations, and effects, but is installed separately.
- **Layout managers** (Chua; Morelli and Walde 13.7): BorderLayout (north, south, east, west,
  centre), FlowLayout (a row), GridLayout (equal cells), BoxLayout (a stack). They keep layouts
  platform-independent.
- **Event model** (Morelli and Walde 13.5): a component generates an event object, which is passed
  to the registered listener, e.g. JButton -> ActionEvent -> actionPerformed().
- **MVC** (Eck 13.3): the model holds data, the view displays it, and the controller responds to
  user actions.
- **Threads in Swing** (Oracle): all Swing updates happen on the event dispatch thread. Long work
  such as network calls goes in a SwingWorker; done() runs back on the event thread.
- **JavaFX extras:** CSS files describe visual styles; transitions animate nodes
  (RotateTransition, FadeTransition, TranslateTransition); properties and bindings keep the view in
  sync with the data.
- **JavaBeans:** reusable components with properties (get/set), events, and a no-argument
  constructor, which GUI builders can configure visually.

## Good GUI Design (Reading Questions)

1. **Essential design skills:** clear layout with one obvious main action, consistent spacing and
   fonts, immediate feedback (busy states and error messages near the action), forgiving input
   validation, and keyboard support (default button, mnemonics).
2. **Using Java's graphical features for appealing interfaces:** gradients (GradientPaint), custom
   painting (paintComponent with Graphics2D and antialiasing), drawn icons, translucent rounded
   panels, and fonts derived at larger sizes for hierarchy.
3. **User experience considerations:** never freeze the window (background threads), keep the
   last good result when an error happens, make text readable on every background, and remember
   user choices (units and history).

## This Week's Assignment

Weather Information App (Swing), using the Open-Meteo API. Current weather plus a 5-day forecast;
icons drawn with Java 2D; °C/°F and km/h, m/s, mph; clear error messages; timestamped history;
day-part backgrounds from the place's local time; 29 of 29 checks pass (26 offline, 3 live).

## Self-Quiz Unit 8

| Q | Answer | Why |
|---|---|---|
| 1 | RotateTransition | The JavaFX animation class for rotating a node |
| 2 | Describe visual styles | JavaFX CSS sets colours, fonts, borders, and so on |
| 3 | actionPerformed() | The ActionListener method called on a button click |
| 4 | Creating reusable components | JavaBeans are reusable software components |
| 5 | JavaFX | Java's modern library with advanced graphics features |
