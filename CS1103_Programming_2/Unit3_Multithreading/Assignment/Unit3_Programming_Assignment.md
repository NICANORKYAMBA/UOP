# Programming Assignment Unit 3: Simple Clock Application

**Course:** CS 1103 Programming 2
**Student:** Nicanor Maswili
**Instructor:** Chibuike Agu
**Due:** September 23, 2026

## Overview

This program implements a simple clock application in Java that uses multiple threads to keep
and display the current date and time concurrently. A thread is a separate task that can run
at the same time as other tasks within a single program, which lets the program do more than
one thing at once (Eck, 2022). The application separates two responsibilities onto two
threads: a background thread continuously updates the clock's stored time, while a separate,
higher-priority thread continuously prints that time to the console. This mirrors the common
pattern of running background work on one thread while a foreground thread handles output
(Samoylov, 2018).

The design uses four classes:

- **Clock** — holds the current time and formats it as `HH:mm:ss dd-MM-yyyy`.
- **ClockUpdater** — implements `Runnable`; the background loop that refreshes the clock.
- **ClockDisplay** — implements `Runnable`; the loop that prints the clock.
- **Main** — creates one shared clock, wraps each task in a `Thread`, sets priorities, starts
  them, runs the clock, and stops the threads cleanly.

## Design and Key Decisions

- **Runnable instead of extending Thread.** Both tasks implement `Runnable`, keeping the task
  separate from the thread that runs it — the more flexible, generally preferred approach
  (Eck, 2022).
- **Thread priorities.** The display thread is set to `Thread.MAX_PRIORITY` (10) and the
  updater to `Thread.MIN_PRIORITY` (1), so the display is favored by the scheduler for better
  timekeeping precision, as required.
- **Safe sharing.** The shared time is written by one thread and read by another, so
  `updateTime` and `getFormattedTime` are `synchronized` to avoid a half-updated read.
- **Clean termination and error handling.** Each task uses a `volatile boolean` flag and a
  `stop` method; constructors validate arguments (`IllegalArgumentException`); every
  `Thread.sleep` handles `InterruptedException` by restoring the interrupt status and exiting.

## Compile and Run

From the `src` directory:

```
javac -d ../bin Clock.java ClockUpdater.java ClockDisplay.java Main.java
java -cp ../bin Main
```

## Source Code

See `src/Clock.java`, `src/ClockUpdater.java`, `src/ClockDisplay.java`, and `src/Main.java`.
The full source is embedded in the submission `.docx`.

## Sample Run and Output

Compiled with `javac -Xlint:all` (no errors or warnings). Output:

```
Starting clock application...
Updater thread priority: 1 | Display thread priority: 10
(The clock will run for 15 seconds.)

Current time: 07:30:31 19-09-2026
Current time: 07:30:32 19-09-2026
...
Current time: 07:30:45 19-09-2026
Clock application stopped.
```

In the live console the time refreshes on a single line (via a carriage return), so it reads
like a real ticking clock. The header confirms the display thread (priority 10) outranks the
background updater (priority 1).

## Screenshots of Output

**[ Insert Screenshot 1 here ]** — Program running in IntelliJ, showing the two thread
priorities and the updating clock.

**[ Insert Screenshot 2 here ]** — The clock a few seconds later, showing the time has
advanced.

## Academic Integrity Statement

This assignment is my own original work. I designed and wrote all of the Java source code and
the accompanying explanations myself. Ideas drawn from the course readings are cited in APA
style, and the sources are listed in the References section.

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart
and William Smith Colleges. Licensed under CC BY-NC-SA 4.0. https://math.hws.edu/javanotes/

Samoylov, N. (2018). *Introduction to programming: Learn to program in Java with data
structures, algorithms, and logic*. Packt Publishing.
