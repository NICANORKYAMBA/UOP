# CS 1102 — Unit 1 Programming Assignment
## Java Quiz Game

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1
**Unit**: 1 — Introduction to Java Programming

---

## Program Overview

This program simulates a five-question multiple-choice quiz game. The user answers each question by typing A, B, C, or D. After all five questions, the program computes and displays the final score as a percentage, along with feedback based on performance. The program uses both `if` statements and `switch` statements as required, and validates user input before processing each answer.

---

## Section 1: Program Structure and Setup

The program is contained in a single class, `QuizGame`, with a `main` method as the entry point. A `Scanner` object reads user input from the keyboard:

```java
Scanner input = new Scanner(System.in);
int score = 0;
```

The `score` variable is initialized to zero and incremented each time the user answers correctly. Using `int` for the score is appropriate because it holds whole numbers — there are no fractional correct answers (Eck, 2022, §2.2).

---

## Section 2: Questions, Input Validation, and if Statements

Each question follows the same pattern: display the question and four labeled options, read the user's answer, normalize it to uppercase with `.toUpperCase()` so that both `"b"` and `"B"` are accepted, then validate and evaluate it.

Input validation uses an `if` statement to check whether the answer is one of the four valid options:

```java
if (!answer1.equals("A") && !answer1.equals("B") &&
    !answer1.equals("C") && !answer1.equals("D")) {
    System.out.println("Invalid input. Skipping question 1.");
}
```

This guards against unexpected input — if the user types something other than A, B, C, or D, the question is skipped without crashing the program. This satisfies the input validation rubric criterion.

---

## Section 3: Answer Checking with switch Statements

After validation, a `switch` statement compares the user's answer to the correct answer. The new Java 17 arrow syntax is used, which eliminates the need for `break` statements and prevents accidental fall-through:

```java
switch (answer1) {
    case "B" -> {
        System.out.println("Correct!");
        score++;
    }
    default -> System.out.println("Incorrect. The correct answer is B.");
}
```

The `switch` statement is the appropriate tool here because it tests a single variable (`answer1`) against a fixed set of values — exactly the use case Eck (2022) describes for switch: "to test the value of an expression and, depending on that value, to jump directly to some location" (§3.6). Using `if-else` for this would be more verbose and less readable.

---

## Section 4: Score Computation and Output

After all five questions, the program computes the percentage score using a cast to `double` to ensure decimal division:

```java
double percentage = ((double) score / totalQuestions) * 100;
System.out.printf("Your final score: %.1f%%%n", percentage);
```

Without the `(double)` cast, integer division would truncate — for example, `3 / 5` would give `0` instead of `0.6`. The `printf` format `%.1f` displays one decimal place, and `%%` prints a literal `%` sign.

A final `if-else if` chain provides feedback based on the score:

```java
if (percentage == 100) {
    System.out.println("Excellent! Perfect score!");
} else if (percentage >= 80) {
    System.out.println("Great job! Well done.");
} else if (percentage >= 60) {
    System.out.println("Good effort! Keep practicing.");
} else {
    System.out.println("Keep studying — you'll get there!");
}
```

This demonstrates multiway branching with range conditions — a scenario where `if-else if` is more appropriate than `switch`, since `switch` cannot evaluate ranges (Eck, 2022, §3.5.2).

---

## Full Program Code

```java
import java.util.Scanner;

/**
 * QuizGame.java
 * A simple multiple-choice quiz game with 5 questions.
 * Tracks correct answers and displays a final score as a percentage.
 */
public class QuizGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int score = 0;

        System.out.println("========================================");
        System.out.println("       Welcome to the Java Quiz Game    ");
        System.out.println("========================================");
        System.out.println("Answer each question by typing A, B, C, or D.\n");

        // Question 1
        System.out.println("Question 1: Which keyword is used to define a class in Java?");
        System.out.println("  A. define");
        System.out.println("  B. class");
        System.out.println("  C. struct");
        System.out.println("  D. object");
        System.out.print("Your answer: ");
        String answer1 = input.next().toUpperCase();

        if (!answer1.equals("A") && !answer1.equals("B") &&
            !answer1.equals("C") && !answer1.equals("D")) {
            System.out.println("Invalid input. Skipping question 1.\n");
        } else {
            switch (answer1) {
                case "B" -> { System.out.println("Correct!\n"); score++; }
                default -> System.out.println("Incorrect. The correct answer is B.\n");
            }
        }

        // Question 2
        System.out.println("Question 2: What is the default value of an int variable in Java?");
        System.out.println("  A. null");
        System.out.println("  B. 1");
        System.out.println("  C. 0");
        System.out.println("  D. undefined");
        System.out.print("Your answer: ");
        String answer2 = input.next().toUpperCase();

        if (!answer2.equals("A") && !answer2.equals("B") &&
            !answer2.equals("C") && !answer2.equals("D")) {
            System.out.println("Invalid input. Skipping question 2.\n");
        } else {
            switch (answer2) {
                case "C" -> { System.out.println("Correct!\n"); score++; }
                default -> System.out.println("Incorrect. The correct answer is C.\n");
            }
        }

        // Question 3
        System.out.println("Question 3: Which of the following is a primitive data type in Java?");
        System.out.println("  A. String");
        System.out.println("  B. Array");
        System.out.println("  C. double");
        System.out.println("  D. Scanner");
        System.out.print("Your answer: ");
        String answer3 = input.next().toUpperCase();

        if (!answer3.equals("A") && !answer3.equals("B") &&
            !answer3.equals("C") && !answer3.equals("D")) {
            System.out.println("Invalid input. Skipping question 3.\n");
        } else {
            switch (answer3) {
                case "C" -> { System.out.println("Correct!\n"); score++; }
                default -> System.out.println("Incorrect. The correct answer is C.\n");
            }
        }

        // Question 4
        System.out.println("Question 4: What does the % operator do in Java?");
        System.out.println("  A. Divides two numbers");
        System.out.println("  B. Returns the remainder of division");
        System.out.println("  C. Multiplies two numbers");
        System.out.println("  D. Converts a number to a percentage");
        System.out.print("Your answer: ");
        String answer4 = input.next().toUpperCase();

        if (!answer4.equals("A") && !answer4.equals("B") &&
            !answer4.equals("C") && !answer4.equals("D")) {
            System.out.println("Invalid input. Skipping question 4.\n");
        } else {
            switch (answer4) {
                case "B" -> { System.out.println("Correct!\n"); score++; }
                default -> System.out.println("Incorrect. The correct answer is B.\n");
            }
        }

        // Question 5
        System.out.println("Question 5: Which conditional statement is best for checking many fixed values?");
        System.out.println("  A. for loop");
        System.out.println("  B. while loop");
        System.out.println("  C. if-else");
        System.out.println("  D. switch");
        System.out.print("Your answer: ");
        String answer5 = input.next().toUpperCase();

        if (!answer5.equals("A") && !answer5.equals("B") &&
            !answer5.equals("C") && !answer5.equals("D")) {
            System.out.println("Invalid input. Skipping question 5.\n");
        } else {
            switch (answer5) {
                case "D" -> { System.out.println("Correct!\n"); score++; }
                default -> System.out.println("Incorrect. The correct answer is D.\n");
            }
        }

        // Final score
        int totalQuestions = 5;
        double percentage = ((double) score / totalQuestions) * 100;

        System.out.println("========================================");
        System.out.println("             Quiz Complete!             ");
        System.out.println("========================================");
        System.out.println("You answered " + score + " out of " + totalQuestions + " questions correctly.");
        System.out.printf("Your final score: %.1f%%%n", percentage);

        if (percentage == 100) {
            System.out.println("Excellent! Perfect score!");
        } else if (percentage >= 80) {
            System.out.println("Great job! Well done.");
        } else if (percentage >= 60) {
            System.out.println("Good effort! Keep practicing.");
        } else {
            System.out.println("Keep studying — you'll get there!");
        }

        input.close();
    }
}
```

---

## Console Output

### Test 1: All Correct Answers (B, C, C, B, D)

```
========================================
       Welcome to the Java Quiz Game
========================================
Answer each question by typing A, B, C, or D.

Question 1: Which keyword is used to define a class in Java?
  A. define
  B. class
  C. struct
  D. object
Your answer: B
Correct!

Question 2: What is the default value of an int variable in Java?
  A. null
  B. 1
  C. 0
  D. undefined
Your answer: C
Correct!

Question 3: Which of the following is a primitive data type in Java?
  A. String
  B. Array
  C. double
  D. Scanner
Your answer: C
Correct!

Question 4: What does the % operator do in Java?
  A. Divides two numbers
  B. Returns the remainder of division
  C. Multiplies two numbers
  D. Converts a number to a percentage
Your answer: B
Correct!

Question 5: Which conditional statement is best for checking many fixed values?
  A. for loop
  B. while loop
  C. if-else
  D. switch
Your answer: D
Correct!

========================================
             Quiz Complete!
========================================
You answered 5 out of 5 questions correctly.
Your final score: 100.0%
Excellent! Perfect score!
```

### Test 2: All Wrong Answers (A, A, A, A, A)

```
You answered 0 out of 5 questions correctly.
Your final score: 0.0%
Keep studying — you'll get there!
```

### Test 3: Invalid Input (X) on Question 1, then correct answers

```
Your answer: X
Invalid input. Skipping question 1.

You answered 3 out of 5 questions correctly.
Your final score: 60.0%
Good effort! Keep practicing.
```

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
