import java.util.Scanner;

/**
 * QuizGame.java
 * A simple multiple-choice quiz game with 5 questions.
 * Tracks correct answers and displays a final score as a percentage.
 *
 * Author: Nicanor Kyamba
 * Course: CS 1102 - Programming 1, Unit 1
 */
public class QuizGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int score = 0; // tracks number of correct answers

        System.out.println("========================================");
        System.out.println("       Welcome to the Java Quiz Game    ");
        System.out.println("========================================");
        System.out.println("Answer each question by typing A, B, C, or D.\n");

        // -------------------------------------------------------
        // Question 1
        // -------------------------------------------------------
        System.out.println("Question 1: Which keyword is used to define a class in Java?");
        System.out.println("  A. define");
        System.out.println("  B. class");
        System.out.println("  C. struct");
        System.out.println("  D. object");
        System.out.print("Your answer: ");
        String answer1 = input.next().toUpperCase(); // normalize to uppercase

        // Validate input and compare to correct answer using if statement
        if (!answer1.equals("A") && !answer1.equals("B") &&
            !answer1.equals("C") && !answer1.equals("D")) {
            System.out.println("Invalid input. Skipping question 1.\n");
        } else {
            // Use switch to check the answer
            switch (answer1) {
                case "B" -> {
                    System.out.println("Correct!\n");
                    score++;
                }
                default -> System.out.println("Incorrect. The correct answer is B.\n");
            }
        }

        // -------------------------------------------------------
        // Question 2
        // -------------------------------------------------------
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
                case "C" -> {
                    System.out.println("Correct!\n");
                    score++;
                }
                default -> System.out.println("Incorrect. The correct answer is C.\n");
            }
        }

        // -------------------------------------------------------
        // Question 3
        // -------------------------------------------------------
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
                case "C" -> {
                    System.out.println("Correct!\n");
                    score++;
                }
                default -> System.out.println("Incorrect. The correct answer is C.\n");
            }
        }

        // -------------------------------------------------------
        // Question 4
        // -------------------------------------------------------
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
                case "B" -> {
                    System.out.println("Correct!\n");
                    score++;
                }
                default -> System.out.println("Incorrect. The correct answer is B.\n");
            }
        }

        // -------------------------------------------------------
        // Question 5
        // -------------------------------------------------------
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
                case "D" -> {
                    System.out.println("Correct!\n");
                    score++;
                }
                default -> System.out.println("Incorrect. The correct answer is D.\n");
            }
        }

        // -------------------------------------------------------
        // Compute and display final score as a percentage
        // -------------------------------------------------------
        int totalQuestions = 5;
        double percentage = ((double) score / totalQuestions) * 100;

        System.out.println("========================================");
        System.out.println("             Quiz Complete!             ");
        System.out.println("========================================");
        System.out.println("You answered " + score + " out of " + totalQuestions + " questions correctly.");
        System.out.printf("Your final score: %.1f%%%n", percentage);

        // Provide feedback based on score using if-else
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
