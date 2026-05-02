import java.util.ArrayList;

/**
 * StockAnalysis.java
 *
 * Analyzes 10 days of opening stock prices using both an array (float[])
 * and an ArrayList<Float>. Implements four methods:
 *
 *   1. calculateAveragePrice  — average of all prices in the array
 *   2. findMaximumPrice       — maximum price in the array
 *   3. countOccurrences       — how many times a target price appears
 *   4. computeCumulativeSum   — running total at each position (ArrayList)
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 — Programming 1, Unit 4
 */
public class StockAnalysis {

    // ── Method 1: Calculate Average Price ───────────────────────
    /**
     * Calculates the average of all stock prices in the array.
     *
     * @param prices  array of float stock prices (not null, length >= 1)
     * @return        the average price as a float
     */
    static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {   // for-each loop over the array
            sum += price;
        }
        return sum / prices.length;
    }

    // ── Method 2: Find Maximum Price ────────────────────────────
    /**
     * Finds the maximum stock price in the array.
     *
     * @param prices  array of float stock prices (not null, length >= 1)
     * @return        the maximum price as a float
     */
    static float findMaximumPrice(float[] prices) {
        float max = prices[0];         // start with the first element
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    // ── Method 3: Count Occurrences ─────────────────────────────
    /**
     * Counts how many times a specific target price appears in the array.
     *
     * @param prices  array of float stock prices (not null, length >= 1)
     * @param target  the price to search for
     * @return        the number of times target appears in prices
     */
    static int countOccurrences(float[] prices, float target) {
        int count = 0;
        for (float price : prices) {
            if (price == target) {     // exact float comparison
                count++;
            }
        }
        return count;
    }

    // ── Method 4: Compute Cumulative Sum ────────────────────────
    /**
     * Computes the cumulative (running) sum of stock prices from an ArrayList.
     * Position i in the result contains the sum of all prices from index 0 to i.
     *
     * @param prices  ArrayList of Float stock prices (not null, size >= 1)
     * @return        a new ArrayList<Float> containing the cumulative sums
     */
    static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulative = new ArrayList<>();
        float runningSum = 0;
        for (int i = 0; i < prices.size(); i++) {
            runningSum += prices.get(i);          // add current price to running total
            cumulative.add(runningSum);            // store cumulative sum at position i
        }
        return cumulative;
    }

    // ── Main: Test all four methods ──────────────────────────────
    public static void main(String[] args) {

        // ── Setup: 10 days of opening stock prices ───────────────
        float[] priceArray = {
            102.5f, 98.3f, 105.0f, 99.7f, 107.2f,
            103.8f, 101.1f, 108.4f, 106.9f, 104.5f
        };

        // Build the ArrayList from the same data
        ArrayList<Float> priceList = new ArrayList<>();
        for (float p : priceArray) {
            priceList.add(p);   // autoboxing: float → Float
        }

        System.out.println("============================================");
        System.out.println("         Stock Price Analysis Report        ");
        System.out.println("============================================");

        // Print the raw data
        System.out.print("10-Day Prices: ");
        for (int i = 0; i < priceArray.length; i++) {
            System.out.printf("%.1f", priceArray[i]);
            if (i < priceArray.length - 1) System.out.print(", ");
        }
        System.out.println("\n");

        // ── Method 1: Average ────────────────────────────────────
        float avg = calculateAveragePrice(priceArray);
        System.out.printf("1. Average Price:   $%.2f%n", avg);

        // ── Method 2: Maximum ────────────────────────────────────
        float max = findMaximumPrice(priceArray);
        System.out.printf("2. Maximum Price:   $%.2f%n", max);

        // ── Method 3: Count Occurrences ──────────────────────────
        float target = 105.0f;
        int occurrences = countOccurrences(priceArray, target);
        System.out.printf("3. Occurrences of $%.1f: %d time(s)%n", target, occurrences);

        // Test with a price that appears twice
        float target2 = 102.5f;
        int occ2 = countOccurrences(priceArray, target2);
        System.out.printf("   Occurrences of $%.1f: %d time(s)%n", target2, occ2);

        // ── Method 4: Cumulative Sum ─────────────────────────────
        ArrayList<Float> cumSum = computeCumulativeSum(priceList);
        System.out.println("4. Cumulative Sum at each position:");
        for (int i = 0; i < cumSum.size(); i++) {
            System.out.printf("   Day %2d: $%.2f%n", i + 1, cumSum.get(i));
        }

        System.out.println("============================================");
    }
}
