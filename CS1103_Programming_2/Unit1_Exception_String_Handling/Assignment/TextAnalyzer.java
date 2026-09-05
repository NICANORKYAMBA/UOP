import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A simple text analysis tool for CS 1103 Programming 2, Unit 1.
 *
 * <p>The program reads a paragraph of text from the user and then reports
 * several statistics about it: the total character count, the total word
 * count, the most common character, the frequency of a user-chosen
 * character, the frequency of a user-chosen word, and the number of unique
 * words. Character and word frequency lookups are case-insensitive.</p>
 *
 * <p>The class demonstrates Unit 1 topics by combining Java String handling
 * with exception handling (try/catch and a finally block) so the program
 * behaves gracefully when the user provides invalid input.</p>
 *
 * @author Nicanor Kyamba
 */
public class TextAnalyzer {

    /** Scanner used to read all input from the user. */
    private Scanner scanner;

    /** The text supplied by the user, stored for repeated analysis. */
    private String text;

    /**
     * Constructs a TextAnalyzer that reads from standard input.
     */
    public TextAnalyzer() {
        this.scanner = new Scanner(System.in);
        this.text = "";
    }

    /**
     * Prompts the user for a paragraph of text and stores it.
     *
     * <p>The input is validated: an empty or whitespace-only entry is
     * rejected and the user is asked again until non-empty text is given.</p>
     */
    public void readText() {
        String input = "";
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter a paragraph or a lengthy text:");
            input = scanner.nextLine();

            if (input == null || input.trim().isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.\n");
            } else {
                valid = true;
            }
        }
        this.text = input;
    }

    /**
     * Counts the total number of characters in the stored text.
     *
     * @return the number of characters, including spaces and punctuation
     */
    public int countCharacters() {
        return text.length();
    }

    /**
     * Counts the total number of words in the stored text.
     *
     * <p>Words are assumed to be separated by whitespace. Leading and
     * trailing whitespace is ignored so it does not inflate the count.</p>
     *
     * @return the number of words in the text
     */
    public int countWords() {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        String[] words = trimmed.split("\\s+");
        return words.length;
    }

    /**
     * Finds the most common character in the stored text.
     *
     * <p>Whitespace characters are ignored so that the space character does
     * not dominate the result. Comparison is case-insensitive. If several
     * characters tie for the highest count, one of them is returned.</p>
     *
     * @return the most frequent non-whitespace character, or the null
     *         character ('\0') if the text contains no such character
     */
    public char findMostCommonCharacter() {
        Map<Character, Integer> counts = new HashMap<>();
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char current = lowerText.charAt(i);
            if (!Character.isWhitespace(current)) {
                counts.put(current, counts.getOrDefault(current, 0) + 1);
            }
        }

        char mostCommon = '\0';
        int highest = 0;
        for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > highest) {
                highest = entry.getValue();
                mostCommon = entry.getKey();
            }
        }
        return mostCommon;
    }

    /**
     * Counts how many times a given character appears in the stored text.
     *
     * <p>The comparison is case-insensitive, so 'a' and 'A' are treated as
     * the same character.</p>
     *
     * @param target the character to search for
     * @return the number of case-insensitive occurrences of the character
     */
    public int countCharacterFrequency(char target) {
        int frequency = 0;
        char lowerTarget = Character.toLowerCase(target);
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            if (lowerText.charAt(i) == lowerTarget) {
                frequency++;
            }
        }
        return frequency;
    }

    /**
     * Counts how many times a given word appears in the stored text.
     *
     * <p>The comparison is case-insensitive and matches whole words only,
     * so searching for "is" does not match inside "this".</p>
     *
     * @param targetWord the word to search for
     * @return the number of case-insensitive occurrences of the word
     */
    public int countWordFrequency(String targetWord) {
        int frequency = 0;
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }

        String cleanTarget = normalizeWord(targetWord);
        String[] words = trimmed.split("\\s+");
        for (String word : words) {
            if (normalizeWord(word).equalsIgnoreCase(cleanTarget)) {
                frequency++;
            }
        }
        return frequency;
    }

    /**
     * Normalizes a word for comparison by removing leading and trailing
     * punctuation and converting it to lower case.
     *
     * <p>This lets "mat." and "mat" be treated as the same word, and makes
     * word matching case-insensitive as required by the assignment.</p>
     *
     * @param word the raw word token to normalize
     * @return the word with surrounding punctuation removed, in lower case
     */
    private String normalizeWord(String word) {
        return word.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "").toLowerCase();
    }

    /**
     * Counts the number of unique words in the stored text.
     *
     * <p>Uniqueness is determined case-insensitively, so "The" and "the"
     * count as the same word.</p>
     *
     * @return the number of distinct words in the text
     */
    public int countUniqueWords() {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }

        Map<String, Boolean> seen = new HashMap<>();
        String[] words = trimmed.split("\\s+");
        for (String word : words) {
            String clean = normalizeWord(word);
            if (!clean.isEmpty()) {
                seen.put(clean, Boolean.TRUE);
            }
        }
        return seen.size();
    }

    /**
     * Reads a single character from the user for frequency analysis.
     *
     * <p>The input is validated so that the user must enter exactly one
     * character that is not whitespace. Any other entry (empty, more than
     * one character, or a space/tab) is rejected and requested again.</p>
     *
     * @return the single, non-whitespace character supplied by the user
     */
    public char readCharacter() {
        String input;

        while (true) {
            System.out.println("\nEnter a single character to count its frequency:");
            input = scanner.nextLine();

            if (input == null || input.isEmpty()) {
                System.out.println("Invalid input: please enter one character.");
            } else if (input.length() > 1) {
                System.out.println("Invalid input: enter only ONE character, not \""
                        + input + "\".");
            } else if (Character.isWhitespace(input.charAt(0))) {
                System.out.println("Invalid input: a blank space is not a valid "
                        + "character to search for.");
            } else {
                return input.charAt(0);
            }
        }
    }

    /**
     * Reads a single word from the user for frequency analysis.
     *
     * <p>The input is validated so that the user must enter exactly one
     * word. Empty entries and entries containing more than one word
     * (separated by whitespace) are rejected and requested again.</p>
     *
     * @return the single word supplied by the user
     */
    public String readWord() {
        String input;

        while (true) {
            System.out.println("\nEnter a single word to count its frequency:");
            input = scanner.nextLine();

            if (input == null || input.trim().isEmpty()) {
                System.out.println("Invalid input: please enter a non-empty word.");
                continue;
            }

            String trimmed = input.trim();
            if (trimmed.split("\\s+").length > 1) {
                System.out.println("Invalid input: please enter only ONE word.");
            } else {
                return trimmed;
            }
        }
    }

    /**
     * Runs the full analysis workflow and prints every result.
     *
     * <p>The core logic is wrapped in try/catch/finally to demonstrate
     * exception handling: any unexpected runtime problem is reported to the
     * user, and the Scanner resource is always closed in the finally
     * block.</p>
     */
    public void run() {
        try {
            readText();

            System.out.println("\n----- Text Analysis Results -----");
            System.out.println("Total characters: " + countCharacters());
            System.out.println("Total words: " + countWords());

            char mostCommon = findMostCommonCharacter();
            if (mostCommon == '\0') {
                System.out.println("Most common character: none found");
            } else {
                System.out.println("Most common character: '" + mostCommon + "'");
            }

            char targetChar = readCharacter();
            System.out.println("Frequency of '" + targetChar + "': "
                    + countCharacterFrequency(targetChar));

            String targetWord = readWord();
            System.out.println("Frequency of \"" + targetWord + "\": "
                    + countWordFrequency(targetWord));

            System.out.println("Number of unique words: " + countUniqueWords());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nAnalysis complete. Input closed.");
        }
    }

    /**
     * Program entry point. Creates a TextAnalyzer and starts the analysis.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        TextAnalyzer analyzer = new TextAnalyzer();
        analyzer.run();
    }
}
