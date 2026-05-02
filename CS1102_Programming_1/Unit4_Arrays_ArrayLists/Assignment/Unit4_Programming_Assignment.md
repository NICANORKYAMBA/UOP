# CS 1102 — Unit 4 Programming Assignment
## Stock Price Analysis Using Arrays and ArrayLists

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1
**Unit**: 4 — Arrays and ArrayLists

---

## 1. Program Overview

This program analyzes 10 days of opening stock prices using both a `float[]` array and an `ArrayList<Float>`. It implements four methods as required:

1. `calculateAveragePrice` — computes the average of all prices in the array
2. `findMaximumPrice` — finds the highest price in the array
3. `countOccurrences` — counts how many times a specific price appears
4. `computeCumulativeSum` — builds a running total from the ArrayList

The program demonstrates the practical difference between arrays and ArrayLists: the array is used for fixed-size numerical computation (average, max, count), while the ArrayList is used for the cumulative sum because it naturally accumulates results of unknown final size.

---

## 2. Method 1: calculateAveragePrice

This method takes the `float[]` array as input and returns the average price. It uses a for-each loop to sum all elements, then divides by the array length:

```java
static float calculateAveragePrice(float[] prices) {
    float sum = 0;
    for (float price : prices) {
        sum += price;
    }
    return sum / prices.length;
}
```

The for-each loop is appropriate here because we need every element and do not need the index. Eck (2022) explains that the for-each loop is designed specifically for processing all values in a data structure without needing to know the index (Section 7.1.1).

**Result for the 10-day dataset**: Average = **$103.74**

---

## 3. Method 2: findMaximumPrice

This method finds the maximum price using a traditional for loop. It initializes `max` to the first element, then compares each subsequent element:

```java
static float findMaximumPrice(float[] prices) {
    float max = prices[0];
    for (int i = 1; i < prices.length; i++) {
        if (prices[i] > max) {
            max = prices[i];
        }
    }
    return max;
}
```

Starting the loop at index 1 (not 0) avoids comparing the first element to itself. The traditional for loop is used here because we need the index to start at 1.

**Result**: Maximum = **$108.40** (Day 8)

---

## 4. Method 3: countOccurrences

This method counts how many times a target price appears in the array using a for-each loop and an integer counter:

```java
static int countOccurrences(float[] prices, float target) {
    int count = 0;
    for (float price : prices) {
        if (price == target) {
            count++;
        }
    }
    return count;
}
```

**Results**:
- `$105.0` appears **1 time**
- `$102.5` appears **1 time**

---

## 5. Method 4: computeCumulativeSum

This method takes an `ArrayList<Float>` and returns a new `ArrayList<Float>` containing the running total at each position. Position `i` in the result holds the sum of all prices from index 0 through index `i`:

```java
static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
    ArrayList<Float> cumulative = new ArrayList<>();
    float runningSum = 0;
    for (int i = 0; i < prices.size(); i++) {
        runningSum += prices.get(i);
        cumulative.add(runningSum);
    }
    return cumulative;
}
```

ArrayList is the correct choice for the return type here because the size of the result equals the size of the input, but using ArrayList makes it easy to `add()` each cumulative value without pre-allocating. Eck (2022) notes that ArrayList's `add()` method appends to the end and automatically manages resizing (Section 7.3.1).

Java's **autoboxing** handles the conversion between `float` (primitive) and `Float` (wrapper object) automatically when calling `prices.get(i)` and `cumulative.add(runningSum)`.

**Results**:
```
Day  1: $102.50
Day  2: $200.80
Day  3: $305.80
Day  4: $405.50
Day  5: $512.70
Day  6: $616.50
Day  7: $717.60
Day  8: $826.00
Day  9: $932.90
Day 10: $1037.40
```

---

## 6. Full Program Code

```java
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

    static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    static float findMaximumPrice(float[] prices) {
        float max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    static int countOccurrences(float[] prices, float target) {
        int count = 0;
        for (float price : prices) {
            if (price == target) {
                count++;
            }
        }
        return count;
    }

    static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
        ArrayList<Float> cumulative = new ArrayList<>();
        float runningSum = 0;
        for (int i = 0; i < prices.size(); i++) {
            runningSum += prices.get(i);
            cumulative.add(runningSum);
        }
        return cumulative;
    }

    public static void main(String[] args) {

        float[] priceArray = {
            102.5f, 98.3f, 105.0f, 99.7f, 107.2f,
            103.8f, 101.1f, 108.4f, 106.9f, 104.5f
        };

        ArrayList<Float> priceList = new ArrayList<>();
        for (float p : priceArray) {
            priceList.add(p);
        }

        System.out.println("============================================");
        System.out.println("         Stock Price Analysis Report        ");
        System.out.println("============================================");

        System.out.print("10-Day Prices: ");
        for (int i = 0; i < priceArray.length; i++) {
            System.out.printf("%.1f", priceArray[i]);
            if (i < priceArray.length - 1) System.out.print(", ");
        }
        System.out.println("\n");

        float avg = calculateAveragePrice(priceArray);
        System.out.printf("1. Average Price:   $%.2f%n", avg);

        float max = findMaximumPrice(priceArray);
        System.out.printf("2. Maximum Price:   $%.2f%n", max);

        float target = 105.0f;
        int occurrences = countOccurrences(priceArray, target);
        System.out.printf("3. Occurrences of $%.1f: %d time(s)%n", target, occurrences);

        float target2 = 102.5f;
        int occ2 = countOccurrences(priceArray, target2);
        System.out.printf("   Occurrences of $%.1f: %d time(s)%n", target2, occ2);

        ArrayList<Float> cumSum = computeCumulativeSum(priceList);
        System.out.println("4. Cumulative Sum at each position:");
        for (int i = 0; i < cumSum.size(); i++) {
            System.out.printf("   Day %2d: $%.2f%n", i + 1, cumSum.get(i));
        }

        System.out.println("============================================");
    }
}
```

---

## 7. Output (Screenshots)

*Run StockAnalysis.java in IntelliJ IDEA and insert screenshots below.*

### Screenshot 1 — IDE Screenshot
*[INSERT: IntelliJ editor showing StockAnalysis.java with project panel visible]*

### Screenshot 2 — Console Output
*[INSERT: IntelliJ Run console showing the full output:*
- *10-Day Prices listed*
- *Average: $103.74*
- *Maximum: $108.40*
- *Occurrences of $105.0: 1 time(s)*
- *Cumulative sums Day 1 through Day 10]*

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
