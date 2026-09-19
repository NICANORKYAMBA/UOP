# Unit 3 Learning Notes — Threads and Multithreading in Java

Course: CS 1103 Programming 2
Student: Nicanor Maswili
Readings: Eck (2022), Chapter 12; Samoylov (2018), Chapter 11 (Threads, pp. 381–387)

---

## 1. What a thread is and why we use multithreading

A **thread** is a single sequential flow of control within a program — a task that the CPU
can execute. A normal program has one thread (starting at `main`). **Multithreading** means a
program runs several threads at once, so more than one task progresses "at the same time."

Reasons to use multithreading:

- **Responsiveness.** A long or blocking task (reading a file, waiting on the network, a
  continuous background loop) can run on its own thread so the rest of the program stays
  responsive. In the clock app, the updater runs in the background while the display keeps
  printing.
- **Parallel performance.** On a multi-core CPU, independent threads can run on different
  cores simultaneously, so work finishes faster. Modern machines have multiple cores, and
  multithreading is how a program takes advantage of them (Eck, 2022).
- **Natural structure.** Some problems are naturally concurrent (a background updater plus a
  foreground display), and separating them onto threads makes the design cleaner.

The trade-off: concurrent code is harder to reason about because threads share memory, so we
must guard shared data (see synchronization below).

---

## 2. The thread life cycle (states)

A Java thread moves through several states (`Thread.State`):

1. **NEW** — the `Thread` object exists but `start()` has not been called yet.
2. **RUNNABLE** — after `start()`; the thread is eligible to run and may be running or waiting
   for CPU time from the scheduler.
3. **BLOCKED** — waiting to acquire a monitor lock (e.g., to enter a `synchronized` block held
   by another thread).
4. **WAITING** — waiting indefinitely for another thread to act (e.g., `join()` with no
   timeout, `Object.wait()`).
5. **TIMED_WAITING** — waiting for a set time (e.g., `Thread.sleep(ms)`, `join(ms)`). The
   clock threads spend most of their time here, sleeping between ticks.
6. **TERMINATED** — the `run()` method has finished (or the thread was stopped), and the
   thread will not run again.

Typical transitions: NEW → (start) → RUNNABLE → (sleep) → TIMED_WAITING → (wake) → RUNNABLE →
(run() ends) → TERMINATED. A thread cannot be restarted once TERMINATED.

---

## 3. Two ways to create a thread

**a) Extend the Thread class:**

```java
class MyTask extends Thread {
    public void run() { /* work */ }
}
new MyTask().start();
```

**b) Implement the Runnable interface (preferred):**

```java
class MyTask implements Runnable {
    public void run() { /* work */ }
}
new Thread(new MyTask()).start();
```

Why Runnable is usually preferred (Eck, 2022; Samoylov, 2018):

- Java allows a class to extend only one class; implementing `Runnable` leaves that single
  inheritance slot free.
- It cleanly separates the **task** (the `Runnable`) from the **worker** (the `Thread`).
- The same `Runnable` can be reused, handed to a thread pool, or written as a lambda.

Since Java 8, a `Runnable` can be a lambda: `new Thread(() -> doWork()).start();`

**Important:** always call `start()`, not `run()`. Calling `run()` directly just executes the
code on the current thread (no new thread is created). `start()` creates the new thread and
then calls `run()` on it.

---

## 4. Thread priorities

- Every thread has a priority from `Thread.MIN_PRIORITY` (1) to `Thread.MAX_PRIORITY` (10),
  with `Thread.NORM_PRIORITY` (5) as the default.
- `setPriority(int)` is a **hint** to the scheduler to favor higher-priority threads; it is
  not a guarantee, and exact behavior depends on the operating system.
- In the clock app, the display thread is set to 10 and the background updater to 1, so the
  scheduler favors printing the time for smoother timekeeping.

---

## 5. sleep, interrupt, and clean termination

- `Thread.sleep(ms)` pauses the current thread for at least the given time (TIMED_WAITING). It
  throws `InterruptedException`, so it must be in a `try-catch`.
- **Never** use the deprecated `Thread.stop()`. Instead, stop a loop cooperatively with a
  `volatile boolean` flag that the loop checks each iteration (the approach used in
  `ClockUpdater`/`ClockDisplay`).
- When `sleep` is interrupted, the recommended pattern is to restore the interrupt flag with
  `Thread.currentThread().interrupt()` and let the loop exit, so the interruption is not
  silently swallowed.
- `join()` makes one thread wait for another to finish — `Main` joins both worker threads so
  the program ends only after they stop.

---

## 6. Sharing data safely (synchronization)

When two threads access the same data and at least one writes, we need synchronization to
avoid a **race condition** (reading a half-updated value).

- The `synchronized` keyword gives a thread exclusive access to an object's monitor lock while
  it runs the method/block; other threads must wait (BLOCKED).
- In `Clock`, both `updateTime()` (writer) and `getFormattedTime()` (reader) are
  `synchronized`, so the display never reads a torn value while the updater is writing.
- `volatile` (used for the `running` flags) ensures a change made by one thread is visible to
  another; it is enough for a simple stop flag but does **not** replace `synchronized` for
  compound read-modify-write operations.

---

## 7. Performance benefits and where multithreading helps

- **Improved responsiveness:** background work does not freeze the foreground (UI or output).
- **Parallel speedup:** independent CPU-bound tasks run on multiple cores at once.
- **Better resource use:** while one thread waits on I/O (network, disk), another can use the
  CPU, so the program does useful work instead of idling (Eck, 2022).

Where it does **not** help: tasks that are inherently sequential, or where the overhead of
creating threads and synchronizing exceeds the benefit. Too many threads or careless sharing
can cause race conditions, deadlocks, or slowdowns from lock contention.

---

## Self-Quiz preparation (key facts)

- `start()` launches a new thread; `run()` alone does not.
- `Runnable` is preferred over extending `Thread` (keeps inheritance free, separates task from
  worker, works as a lambda).
- Priorities range 1–10 (default 5) and are only scheduling hints.
- `sleep()` throws `InterruptedException` and puts the thread in TIMED_WAITING.
- Use a `volatile` flag (not `Thread.stop()`) to end a thread's loop cleanly.
- `synchronized` protects shared mutable data from race conditions.

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, JavaFX ed.). Hobart
and William Smith Colleges. Licensed under CC BY-NC-SA 4.0. https://math.hws.edu/javanotes/

Samoylov, N. (2018). *Introduction to programming: Learn to program in Java with data
structures, algorithms, and logic*. Packt Publishing.
