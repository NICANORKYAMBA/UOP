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
