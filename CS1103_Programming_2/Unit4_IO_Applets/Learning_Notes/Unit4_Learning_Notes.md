# Unit 4 Learning Notes: I/O Streams and Applets

Course: CS 1103 Programming 2
Reading: Eck (2022), *Javanotes 9*, Section 11.1 (I/O Streams, Readers, and Writers); Udemy
Blog, "Java applet tutorial" and "Java applet life cycle"
Videos: Intellipaat (applets), Keep On Coding (file I/O), SimpliCode (I/O streams)

Due this week: Discussion (first post by **Sunday Sep 27**, 2 replies by **Wednesday Sep 30**)
and the Self-Quiz. There is no programming assignment this unit.

---

## 1. What I/O streams are for

A program is useless unless it can talk to the outside world (files, keyboard, screen,
network). Java hides the details of each device behind one idea, the **stream**: a source you
read from or a destination you write to. The classes live in **java.io**.

## 2. Byte streams vs character streams

| | Byte streams | Character streams |
|---|---|---|
| For | Binary, machine-formatted data (images, audio, video, .class, zip) | Human-readable text |
| Base classes | InputStream / OutputStream | Reader / Writer |
| File classes | FileInputStream / FileOutputStream | FileReader / FileWriter |
| Buffered | BufferedInputStream / BufferedOutputStream | BufferedReader / BufferedWriter |
| Translation | none, bits copied as-is (fast) | converts between Unicode chars and file encoding |

Rule of thumb: text goes through Reader/Writer, everything else through InputStream/OutputStream.
System.in and System.out are actually byte streams.

## 3. Wrapper (decorator) streams

You build a stream by wrapping one inside another to add features:

```java
PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("data.txt")));
BufferedReader in = new BufferedReader(new FileReader("data.txt"));
DataOutputStream dout = new DataOutputStream(new FileOutputStream("nums.dat"));
```

- **PrintWriter:** print(), println(), printf() for text. It never throws IOException, so check
  checkError().
- **DataOutputStream / DataInputStream:** write and read primitive values (writeInt, readDouble)
  in binary.
- **ObjectOutputStream / ObjectInputStream:** serialize whole objects (class must implement
  Serializable).
- **Scanner:** convenient parsing of text input (nextInt, nextLine).
- **CharArrayReader:** reads characters **from a char array** in memory (CharArrayWriter writes
  to one).

Always close streams, ideally with **try-with-resources**, and handle **IOException**.

## 4. Applets

- A small Java program that runs **inside a web page**, not on its own. It has **no main()**.
- Extends **java.applet.Applet** (AWT) or **javax.swing.JApplet** (Swing).
- Runs in a **sandbox**: an unsigned applet cannot read or write the user's files and can only
  connect back to the server it came from.
- Can be tested with the **appletviewer** tool from JDK 8.

**Life cycle:**

| Method | When it runs | Typical use |
|---|---|---|
| init() | once, when loaded | set up components, load images |
| start() | after init and every time the page is shown again | start animation threads |
| stop() | when the page is left or hidden | pause threads, save CPU |
| destroy() | once, before unloading | release resources |
| paint(Graphics g) | whenever the applet must be drawn | draw text and shapes |

**Events:** keyboard input uses the KeyListener methods **keyPressed()**, keyReleased() and
keyTyped(). Mouse input uses MouseListener and MouseMotionListener. Call **repaint()** to ask
for paint() to run again.

**Today:** the Applet API was deprecated in Java 9 and marked for removal in Java 17 because
browsers dropped the Java plug-in (JEP 398). The ideas (life cycle, event handling, painting)
live on in JavaFX and Swing desktop apps.

---

## Self-Quiz answers

| # | Question | Answer |
|---|---|---|
| 1 | Package mainly used for I/O | **java.io** |
| 2 | What is an applet | **A small application program** |
| 3 | What I/O stands for | **Input/Output** |
| 4 | Method for keyboard events in an interactive applet | **keyPressed()** |
| 5 | Purpose of CharArrayReader | **Reading characters from a char array** |

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart
and William Smith Colleges. https://math.hws.edu/javanotes/c11/s1.html

OpenJDK. (2021). *JEP 398: Deprecate the Applet API for removal*.
https://openjdk.org/jeps/398
