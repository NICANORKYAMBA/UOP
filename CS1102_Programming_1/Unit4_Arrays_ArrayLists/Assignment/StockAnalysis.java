import java.util.ArrayList;

/**
 * StockAnalysis.java
 *
 * Analyzes 10 days of opening stock prices using both a float[] array
 * and an ArrayList<Float>. Implements six methods:
 *
 *   1a. calculateAveragePrice(float[])         — average from array
 *   1b. calculateAveragePrice(ArrayList<Float>) — average from ArrayList
 *   2a. findMaximumPrice(float[])              — maximum from array
 *   2b. findMaximumPrice(ArrayList<Float>)     — maximum from ArrayList
 *   3.  countOccurrences(float[], float)       — count of a target price in array
 *   4.  computeCumulativeSum(ArrayList<Float>) — cumulative sum as new ArrayList
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 — Programming 1, Unit 4
 */
public class StockAnalysis {

    // ── Method 1a: Calculate Average Price from Array ───────────
    /**
     * Calculates the average of all stock prices in a float array.
     *
     * @param prices  float array of stock prices (not null, length >= 1)
     * @return        the average price as a float
     */
    static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {       // for-each loop over the array
            sum += price;
        }
        return sum / prices.length;
    }

    // ── Method 1b: Calculate Average Price from ArrayList ───────
    /**
     * Calculates the average of all stock prices in an ArrayList.
     *
     * @param prices  ArrayList of Float stock prices (not null, size >= 1)
     * @return        the average price as a float
     */
    static float calculateAveragePrice(ArrayList<Float> prices) {
        float sum = 0;
        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);          // retrieve each element by index
        }
        return sum / prices.size();
    }

    // ── Method 2a: Find Maximum Price from Array ─────────────────
    /**
     * Finds the maximum stock price in a float array.
     *
     * @param prices  float array of stock prices (not null, length >= 1)
     * @return        the maximum price as a float
     */
    static float findMaximumPrice(float[] prices) {
        float max = prices[0];             // initialize with the first element
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    // ── Method 2b: Find Maximum Price from ArrayList ─────────────
    /**
     * Finds the maximum stock price in an ArrayList.
     *
     * @param prices  ArrayList of Float stock prices (not null, size >= 1)
     * @return        the maximum price as a float
     */
    static float findMaximumPrice(ArrayList<Float> prices) {
        float max = prices.get(0);         // initialize with the first element
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > max) {
                max = prices.get(i);
            }
        }
        return max;
    }

    // ── Method 3: Count Occurrences in Array ─────────────────────
    /**
     * Counts how many times a specific target price appears in the array.
     *
     * @param prices  float array of stock prices (not null, length >= 1)
     * @param target  the price to search for
     * @return        the number of times target appears in prices
     */
    static int countOccurrences(float[] prices, float target) {
        int count = 0;
        for (float price : prices) {
            if (price == target) {
                count++;
            }
        }
        return count;
    }

    // ── Method 4: Compute Cumulative Sum from ArrayList ──────────
    /**
     * Computes the cumulative (running) sum of stock prices from an ArrayList.
     * The element at position i in the result is the sum of all prices
     * from index 0 through index i.
     *
     * @param prices  ArrayList of Float stock prices (not null, size >= 1)
     * @return        a new ArrayList<Float> containing the cumulative sums
     */
    static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulative = new ArrayList<>();
        float runningSum = 0;
        for (int i = 0; i < prices.size(); i++) {
            runningSum += prices.get(i);   // add current price to running total
            cumulative.add(runningSum);    // store cumulative sum at position i
        }
        return cumulative;
    }

    // ── Main: Demonstrate all methods ────────────────────────────
    public static void main(String[] args) {

        // ── 10 days of opening stock prices (float array) ────────
        float[] priceArray = {
            102.5f, 98.3f, 105.0f, 99.7f, 107.2f,
            103.8f, 101.1f, 108.4f, 106.9f, 104.5f
        };

        // Build the ArrayList from the same data
        ArrayList<Float> priceList = new ArrayList<>();
        for (float p : priceArray) {
            priceList.add(p);              // autoboxing: float → Float
        }

        System.out.println("============================================");
        System.out.println("         Stock Price Analysis Report        ");
        System.out.println("============================================");

        // Print the raw data
        System.out.print("10-Day Prices (Array):     ");
        for (int i = 0; i < priceArray.length; i++) {
            System.out.printf("%.1f", priceArray[i]);
            if (i < priceArray.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.println("10-Day Prices (ArrayList): " + priceList);
        System.out.println();

        // ── Method 1: Average Price ───────────────────────────────
        float avgArray     = calculateAveragePrice(priceArray);
        float avgArrayList = calculateAveragePrice(priceList);
        System.out.printf("1a. Average Price (Array):     $%.2f%n", avgArray);
        System.out.printf("1b. Average Price (ArrayList): $%.2f%n", avgArrayList);
        System.out.println();

        // ── Method 2: Maximum Price ───────────────────────────────
        float maxArray     = findMaximumPrice(priceArray);
        float maxArrayList = findMaximumPrice(priceList);
        System.out.printf("2a. Maximum Price (Array):     $%.2f%n", maxArray);
        System.out.printf("2b. Maximum Price (ArrayList): $%.2f%n", maxArrayList);
        System.out.println();

        // ── Method 3: Count Occurrences ──────────────────────────
        float target = 105.0f;
        int count1 = countOccurrences(priceArray, target);
        System.out.printf("3.  Occurrences of $%.1f in Array: %d time(s)%n",
                          target, count1);

        float target2 = 99.7f;
        int count2 = countOccurrences(priceArray, target2);
        System.out.printf("    Occurrences of $%.1f in Array: %d time(s)%n",
                          target2, count2);
        System.out.println();

        // ── Method 4: Cumulative Sum ─────────────────────────────
        ArrayList<Float> cumSum = computeCumulativeSum(priceList);
        System.out.println("4.  Cumulative Sum of Stock Prices (ArrayList):");
        for (int i = 0; i < cumSum.size(); i++) {
            System.out.printf("    Day %2d: $%.2f%n", i + 1, cumSum.get(i));
        }

        System.out.println("============================================");
    }
}
