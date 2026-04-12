# CS 1102 — Unit 1 Programming Assignment
## Java Quiz Game

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1
**Unit**: 1 — Introduction to Java Programming
**Instructor**: Vishal Kumar Sharma

---

## 1. Program Overview

This program implements a five-question multiple-choice quiz game on Java fundamentals. The user answers each question by typing A, B, C, or D. The program validates every input, evaluates each answer using a `switch` statement with all four cases, tracks the running score, and displays the final result as a percentage with a performance message. The program satisfies all six rubric criteria: it compiles without errors, validates user input, performs correct logic and computation, follows a clear program flow and structure, produces documented output, and adheres to consistent code style.

---

## 2. Compilation (Rubric Criterion 1)

The program is contained in a single public class named `QuizGame`, stored in `QuizGame.java`. It imports only `java.util.Scanner`, which is the one library required for reading keyboard input. No other imports are needed. The program compiles cleanly with `javac QuizGame.java` under Java 17 (OpenJDK 17.0.15) with zero errors and zero warnings.

The class and method structure follows the standard Java application pattern described by Eck (2022): a `public class` containing a `public static void main(String[] args)` method as the program entry point (§2.1). All variable declarations use appropriate primitive types (`int`, `double`) and reference types (`String`, `Scanner`), ensuring type correctness at compile time.

---

## 3. Input Validation (Rubric Criterion 2)

Every answer is read with `input.next().trim().toUpperCase()`. The `.trim()` call removes accidental leading or trailing whitespace, and `.toUpperCase()` normalizes lowercase letters so that both `"b"` and `"B"` are treated as the same answer. This means the program accepts valid input in any case without penalizing the user for capitalization.

An `if` statement then checks whether the normalized answer is one of the four valid options:

```java
if (ans1.equals("A") || ans1.equals("B") || ans1.equals("C") || ans1.equals("D")) {
    // process the answer
} else {
    System.out.println("Invalid input '" + ans1 + "'. Please enter A, B, C, or D. Question skipped.");
}
```

If the user types anything outside A–D — a number, a word, or a symbol — the program prints a clear error message that includes the invalid value, skips the question without crashing, and continues to the next question. This ensures the program handles unexpected input gracefully and never throws an uncaught exception due to bad user input (Liang, 2020, p. 492).

---

## 4. Logic and Computation (Rubric Criterion 3)

After validation, a `switch` statement with all four cases (A, B, C, D) evaluates the user's answer. Using all four cases — rather than one correct case and a `default` — means the program can provide specific, informative feedback for every wrong answer, not just a generic "incorrect" message. This is a deliberate design choice that improves the educational value of the quiz:

```java
switch (ans1) {
    case "A":
        System.out.println("Incorrect. 'define' is not a Java keyword. The correct answer is B.");
        break;
    case "B":
        System.out.println("Correct! 'class' is the keyword used to define a class in Java.");
        score++;
        break;
    case "C":
        System.out.println("Incorrect. 'struct' is a C/C++ keyword, not Java. The correct answer is B.");
        break;
    case "D":
        System.out.println("Incorrect. 'object' is not a declaration keyword. The correct answer is B.");
        break;
}
```

The `score` integer variable is incremented only when the correct case is matched. After all five questions, the final percentage is computed with a `(double)` cast to prevent integer truncation:

```java
double percentage = ((double) score / totalQuestions) * 100;
```

Without the cast, `score / totalQuestions` would perform integer division — `3 / 5` would give `0` instead of `0.6` — producing a wrong result. The cast forces floating-point division, giving an accurate percentage to one decimal place via `System.out.printf("Your final score: %.1f%%%n", percentage)`.

A final `if-else if` chain maps the percentage to a performance message. The `switch` statement cannot evaluate ranges such as `>= 80`, so `if-else if` is the correct tool here, as Eck (2022) explains: switch is for equality checks against fixed values, while if-else handles range conditions (§3.5.2, §3.6):

```java
if (percentage == 100.0) {
    System.out.println("Outstanding! You achieved a perfect score.");
} else if (percentage >= 80.0) {
    System.out.println("Great work! You have a strong grasp of the material.");
} else if (percentage >= 60.0) {
    System.out.println("Good effort! Review the questions you missed and try again.");
} else {
    System.out.println("Keep studying — revisit Chapter 2 and 3 of Eck (2022) for review.");
}
```

---

## 5. Program Flow and Structure (Rubric Criterion 4)

The program follows a clear, linear flow:

1. **Setup** — declare `Scanner`, initialize `score = 0` and `totalQuestions = 5`
2. **Question loop (×5)** — display question → read answer → validate with `if` → evaluate with `switch` → update score
3. **Output** — compute percentage → display score → display performance message → close Scanner

All variable names are meaningful: `score`, `totalQuestions`, `percentage`, `ans1`–`ans5`. Primitive types are used where appropriate (`int` for score and question count, `double` for percentage), and `String` is used for answers since `switch` on `String` is supported from Java 7 onward (Eck, 2022, §3.6). Every section of the code is preceded by a comment explaining its purpose. The program closes the `Scanner` with `input.close()` at the end to release the system resource properly.

---

## 6. Full Program Code

```java
import java.util.Scanner;

/**
 * QuizGame.java
 *
 * A five-question multiple-choice quiz game on Java fundamentals.
 * Each question has four options labeled A, B, C, and D.
 *
 * Program flow:
 *   1. Display each question and its four options.
 *   2. Read and normalize the user's answer.
 *   3. Use an if statement to validate the input (A–D only).
 *   4. Use a switch statement with all four cases to compare the
 *      answer to the correct option and update the score.
 *   5. After all five questions, compute and display the final
 *      score as a percentage, with a performance message.
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 – Programming 1, Unit 1
 */
public class QuizGame {

    public static void main(String[] args) {

        // ── Setup ────────────────────────────────────────────────
        Scanner input = new Scanner(System.in);
        int score = 0;          // number of correct answers
        int totalQuestions = 5; // total questions in the quiz

        System.out.println("============================================");
        System.out.println("        Welcome to the Java Quiz Game       ");
        System.out.println("============================================");
        System.out.println("Type A, B, C, or D to answer each question.");
        System.out.println();

        // ── Question 1 ───────────────────────────────────────────
        // Correct answer: B (class)
        System.out.println("Question 1: Which keyword is used to define a class in Java?");
        System.out.println("  A. define");
        System.out.println("  B. class");
        System.out.println("  C. struct");
        System.out.println("  D. object");
        System.out.print("Your answer: ");
        String ans1 = input.next().trim().toUpperCase(); // normalize input

        // if statement: validate that input is one of A, B, C, D
        if (ans1.equals("A") || ans1.equals("B") || ans1.equals("C") || ans1.equals("D")) {
            // switch statement: evaluate all four options
            switch (ans1) {
                case "A":
                    System.out.println("Incorrect. 'define' is not a Java keyword. The correct answer is B.");
                    break;
                case "B":
                    System.out.println("Correct! 'class' is the keyword used to define a class in Java.");
                    score++;
                    break;
                case "C":
                    System.out.println("Incorrect. 'struct' is a C/C++ keyword, not Java. The correct answer is B.");
                    break;
                case "D":
                    System.out.println("Incorrect. 'object' is not a declaration keyword. The correct answer is B.");
                    break;
            }
        } else {
            System.out.println("Invalid input '" + ans1 + "'. Please enter A, B, C, or D. Question skipped.");
        }
        System.out.println();

        // ── Question 2 ───────────────────────────────────────────
        // Correct answer: C (0)
        System.out.println("Question 2: What is the default value of an int variable in Java?");
        System.out.println("  A. null");
        System.out.println("  B. 1");
        System.out.println("  C. 0");
        System.out.println("  D. undefined");
        System.out.print("Your answer: ");
        String ans2 = input.next().trim().toUpperCase();

        if (ans2.equals("A") || ans2.equals("B") || ans2.equals("C") || ans2.equals("D")) {
            switch (ans2) {
                case "A":
                    System.out.println("Incorrect. 'null' is the default for reference types, not int. The correct answer is C.");
                    break;
                case "B":
                    System.out.println("Incorrect. int variables do not default to 1. The correct answer is C.");
                    break;
                case "C":
                    System.out.println("Correct! The default value of an int in Java is 0.");
                    score++;
                    break;
                case "D":
                    System.out.println("Incorrect. Java always initializes instance variables; int defaults to 0. The correct answer is C.");
                    break;
            }
        } else {
            System.out.println("Invalid input '" + ans2 + "'. Please enter A, B, C, or D. Question skipped.");
        }
        System.out.println();

        // ── Question 3 ───────────────────────────────────────────
        // Correct answer: C (double)
        System.out.println("Question 3: Which of the following is a primitive data type in Java?");
        System.out.println("  A. String");
        System.out.println("  B. Array");
        System.out.println("  C. double");
        System.out.println("  D. Scanner");
        System.out.print("Your answer: ");
        String ans3 = input.next().trim().toUpperCase();

        if (ans3.equals("A") || ans3.equals("B") || ans3.equals("C") || ans3.equals("D")) {
            switch (ans3) {
                case "A":
                    System.out.println("Incorrect. String is a reference type (a class), not a primitive. The correct answer is C.");
                    break;
                case "B":
                    System.out.println("Incorrect. Arrays are reference types in Java. The correct answer is C.");
                    break;
                case "C":
                    System.out.println("Correct! 'double' is one of Java's eight primitive data types.");
                    score++;
                    break;
                case "D":
                    System.out.println("Incorrect. Scanner is a class (reference type). The correct answer is C.");
                    break;
            }
        } else {
            System.out.println("Invalid input '" + ans3 + "'. Please enter A, B, C, or D. Question skipped.");
        }
        System.out.println();

        // ── Question 4 ───────────────────────────────────────────
        // Correct answer: B (remainder of division)
        System.out.println("Question 4: What does the % operator compute in Java?");
        System.out.println("  A. The result of dividing two numbers");
        System.out.println("  B. The remainder after integer division");
        System.out.println("  C. The product of two numbers");
        System.out.println("  D. A number converted to a percentage");
        System.out.print("Your answer: ");
        String ans4 = input.next().trim().toUpperCase();

        if (ans4.equals("A") || ans4.equals("B") || ans4.equals("C") || ans4.equals("D")) {
            switch (ans4) {
                case "A":
                    System.out.println("Incorrect. Division is performed by /. The correct answer is B.");
                    break;
                case "B":
                    System.out.println("Correct! % is the modulo operator; it returns the remainder of division.");
                    score++;
                    break;
                case "C":
                    System.out.println("Incorrect. Multiplication uses *. The correct answer is B.");
                    break;
                case "D":
                    System.out.println("Incorrect. % does not convert to a percentage. The correct answer is B.");
                    break;
            }
        } else {
            System.out.println("Invalid input '" + ans4 + "'. Please enter A, B, C, or D. Question skipped.");
        }
        System.out.println();

        // ── Question 5 ───────────────────────────────────────────
        // Correct answer: D (switch)
        System.out.println("Question 5: Which conditional statement is best suited for testing");
        System.out.println("           a variable against many fixed, discrete values?");
        System.out.println("  A. for loop");
        System.out.println("  B. while loop");
        System.out.println("  C. if-else");
        System.out.println("  D. switch");
        System.out.print("Your answer: ");
        String ans5 = input.next().trim().toUpperCase();

        if (ans5.equals("A") || ans5.equals("B") || ans5.equals("C") || ans5.equals("D")) {
            switch (ans5) {
                case "A":
                    System.out.println("Incorrect. A for loop is used for iteration, not value matching. The correct answer is D.");
                    break;
                case "B":
                    System.out.println("Incorrect. A while loop is used for repetition. The correct answer is D.");
                    break;
                case "C":
                    System.out.println("Incorrect. if-else works but becomes verbose with many fixed values. The correct answer is D.");
                    break;
                case "D":
                    System.out.println("Correct! switch is designed to test one expression against multiple constant values.");
                    score++;
                    break;
            }
        } else {
            System.out.println("Invalid input '" + ans5 + "'. Please enter A, B, C, or D. Question skipped.");
        }
        System.out.println();

        // ── Score Computation and Output ─────────────────────────
        // Cast score to double before dividing to avoid integer truncation
        double percentage = ((double) score / totalQuestions) * 100;

        System.out.println("============================================");
        System.out.println("              Quiz Complete!                ");
        System.out.println("============================================");
        System.out.println("You answered " + score + " out of " + totalQuestions + " questions correctly.");
        System.out.printf("Your final score: %.1f%%%n", percentage);
        System.out.println();

        // if-else chain: provide performance feedback based on score range
        // switch cannot evaluate ranges, so if-else is the correct tool here
        if (percentage == 100.0) {
            System.out.println("Outstanding! You achieved a perfect score.");
        } else if (percentage >= 80.0) {
            System.out.println("Great work! You have a strong grasp of the material.");
        } else if (percentage >= 60.0) {
            System.out.println("Good effort! Review the questions you missed and try again.");
        } else {
            System.out.println("Keep studying — revisit Chapter 2 and 3 of Eck (2022) for review.");
        }

        input.close(); // release the Scanner resource
    }
}
```

---

## 7. Console Output (Rubric Criterion 5)

*Note: Screenshots of the program running in Eclipse IDE are included in the submitted Word document.*

### Test Run 1 — All Correct Answers (B, C, C, B, D)

```
============================================
        Welcome to the Java Quiz Game
============================================
Type A, B, C, or D to answer each question.

Question 1: Which keyword is used to define a class in Java?
  A. define
  B. class
  C. struct
  D. object
Your answer: B
Correct! 'class' is the keyword used to define a class in Java.

Question 2: What is the default value of an int variable in Java?
  A. null
  B. 1
  C. 0
  D. undefined
Your answer: C
Correct! The default value of an int in Java is 0.

Question 3: Which of the following is a primitive data type in Java?
  A. String
  B. Array
  C. double
  D. Scanner
Your answer: C
Correct! 'double' is one of Java's eight primitive data types.

Question 4: What does the % operator compute in Java?
  A. The result of dividing two numbers
  B. The remainder after integer division
  C. The product of two numbers
  D. A number converted to a percentage
Your answer: B
Correct! % is the modulo operator; it returns the remainder of division.

Question 5: Which conditional statement is best suited for testing
           a variable against many fixed, discrete values?
  A. for loop
  B. while loop
  C. if-else
  D. switch
Your answer: D
Correct! switch is designed to test one expression against multiple constant values.

============================================
              Quiz Complete!
============================================
You answered 5 out of 5 questions correctly.
Your final score: 100.0%

Outstanding! You achieved a perfect score.
```

### Test Run 2 — All Wrong Answers (A, A, A, A, A)

```
============================================
        Welcome to the Java Quiz Game
============================================
Type A, B, C, or D to answer each question.

Question 1: ...
Your answer: A
Incorrect. 'define' is not a Java keyword. The correct answer is B.

Question 2: ...
Your answer: A
Incorrect. 'null' is the default for reference types, not int. The correct answer is C.

Question 3: ...
Your answer: A
Incorrect. String is a reference type (a class), not a primitive. The correct answer is C.

Question 4: ...
Your answer: A
Incorrect. Division is performed by /. The correct answer is B.

Question 5: ...
Your answer: A
Incorrect. A for loop is used for iteration, not value matching. The correct answer is D.

============================================
              Quiz Complete!
============================================
You answered 0 out of 5 questions correctly.
Your final score: 0.0%

Keep studying — revisit Chapter 2 and 3 of Eck (2022) for review.
```

### Test Run 3 — Invalid Input on Question 1, then Mixed Answers (X, B, C, B, D)

```
Question 1: ...
Your answer: X
Invalid input 'X'. Please enter A, B, C, or D. Question skipped.

Question 2: ...
Your answer: B
Incorrect. int variables do not default to 1. The correct answer is C.

Question 3: ...
Your answer: C
Correct! 'double' is one of Java's eight primitive data types.

Question 4: ...
Your answer: B
Correct! % is the modulo operator; it returns the remainder of division.

Question 5: ...
Your answer: D
Correct! switch is designed to test one expression against multiple constant values.

============================================
              Quiz Complete!
============================================
You answered 3 out of 5 questions correctly.
Your final score: 60.0%

Good effort! Review the questions you missed and try again.
```

---

## 8. Code Style and Readability (Rubric Criterion 6)

The code follows consistent four-space indentation throughout. Every logical section — setup, each question, and score output — is separated by a clearly labeled comment block. Variable names are descriptive (`score`, `totalQuestions`, `percentage`, `ans1`–`ans5`) and follow Java's camelCase convention (Eck, 2022, §2.2). There is no redundant or dead code. The `Scanner` is closed at the end of `main` to avoid a resource leak. The Javadoc comment at the top of the class documents the program's purpose, flow, author, and course, making the code immediately understandable to any reader.

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/

Liang, Y. D. (2020). *Introduction to Java programming and data structures* (12th ed.). Pearson.
