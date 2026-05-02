# CS 1102 — Unit 4 Programming Assignment
## Stock Price Analysis Using Arrays and ArrayLists

**Student**: Nicanor Kyamba
**Course**: CS 1102 — Programming 1
**Unit**: 4 — Arrays and ArrayLists

---

## 1. Program Overview

This program analyzes 10 days of opening stock prices using both a `float[]` array and an `ArrayList<Float>`. It implements all four required methods, with `calculateAveragePrice` and `findMaximumPrice` provided for **both** the array and the ArrayList as required by the rubric:

| Method | Input | Output |
|--------|-------|--------|
| `calculateAveragePrice(float[])` | Array of prices | Average price |
| `calculateAveragePrice(ArrayList<Float>)` | ArrayList of prices | Average price |
| `findMaximumPrice(float[])` | Array of prices | Maximum price |
| `findMaximumPrice(ArrayList<Float>)` | ArrayList of prices | Maximum price |
| `countOccurrences(float[], float)` | Array + target price | Count of occurrences |
| `computeCumulativeSum(ArrayList<Float>)` | ArrayList of prices | New ArrayList of cumulative sums |

Java allows **method overloading** — two methods can share the same name as long as their parameter types differ. This is why `calculateAveragePrice` and `findMaximumPrice` each appear twice with different parameter types (Eck, 2022, Section 4.3).

---

## 2. Method 1: calculateAveragePrice

### 1a — Array version

Takes a `float[]` array, sums all elements using a for-each loop, and divides by the array length:

```java
static float calculateAveragePrice(float[] prices) {
    float sum = 0;
    for (float price : prices) {       // for-each loop — Eck Section 7.1.1
        sum += price;
    }
    return sum / prices.length;
}
```

### 1b — ArrayList version

Takes an `ArrayList<Float>`, iterates using a standard for loop with `prices.get(i)`, and divides by `prices.size()`:

```java
static float calculateAveragePrice(ArrayList<Float> prices) {
    float sum = 0;
    for (int i = 0; i < prices.size(); i++) {
        sum += prices.get(i);          // get(i) retrieves element at index i
    }
    return sum / prices.size();
}
```

The for-each loop is used for the array version because no index is needed. The indexed for loop is used for the ArrayList version to demonstrate `get(i)` and `size()` — the ArrayList equivalents of `arr[i]` and `arr.length` (Eck, 2022, Section 7.3.1).

**Result (both versions)**: Average = **$103.74**

---

## 3. Method 2: findMaximumPrice

### 2a — Array version

Initializes `max` to the first element, then compares each subsequent element using a traditional for loop starting at index 1:

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

### 2b — ArrayList version

Same logic, using `prices.get(0)` and `prices.get(i)` instead of direct index access:

```java
static float findMaximumPrice(ArrayList<Float> prices) {
    float max = prices.get(0);
    for (int i = 1; i < prices.size(); i++) {
        if (prices.get(i) > max) {
            max = prices.get(i);
        }
    }
    return max;
}
```

Starting at index 1 in both versions avoids comparing the first element to itself, which would be redundant.

**Result (both versions)**: Maximum = **$108.40** (Day 8)

---

## 4. Method 3: countOccurrences

Takes the `float[]` array and a target price, counts exact matches using a for-each loop:

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
- `$105.0` appears **1 time** in the array
- `$99.7` appears **1 time** in the array

---

## 5. Method 4: computeCumulativeSum

Takes an `ArrayList<Float>` and returns a **new** `ArrayList<Float>` where position `i` contains the sum of all prices from index 0 through index `i`:

```java
static ArrayList<Float> computeCumulativeSum(ArrayList<Float> prices) {
    ArrayList<Float> cumulative = new ArrayList<>();
    float runningSum = 0;
    for (int i = 0; i < prices.size(); i++) {
        runningSum += prices.get(i);   // add current price to running total
        cumulative.add(runningSum);    // append cumulative sum to result list
    }
    return cumulative;
}
```

ArrayList is the correct return type here because `add()` appends each cumulative value without needing to pre-allocate a fixed size. Java's autoboxing automatically converts `float` to `Float` when calling `cumulative.add(runningSum)` (Eck, 2022, Section 7.3.2).

**Results**:
```
Day  1: $102.50    Day  6: $616.50
Day  2: $200.80    Day  7: $717.60
Day  3: $305.80    Day  8: $826.00
Day  4: $405.50    Day  9: $932.90
Day  5: $512.70    Day 10: $1037.40
```

---

## 6. Full Program Code

```java
import java.util.ArrayList;

/**
 * StockAnalysis.java
 *
 * Analyzes 10 days of opening stock prices using both a float[] array
 * and an ArrayList<Float>. Implements six methods:
 *
 *   1a. calculateAveragePrice(float[])
 *   1b. calculateAveragePrice(ArrayList<Float>)
 *   2a. findMaximumPrice(float[])
 *   2b. findMaximumPrice(ArrayList<Float>)
 *   3.  countOccurrences(float[], float)
 *   4.  computeCumulativeSum(ArrayList<Float>)
 *
 * Author : Nicanor Kyamba
 * Course : CS 1102 — Programming 1, Unit 4
 */
public class StockAnalysis {

    // Method 1a: Average from array
    static float calculateAveragePrice(float[] prices) {
        float sum = 0;
        for (float price : prices) {
            sum += price;
        }
        return sum / prices.length;
    }

    // Method 1b: Average from ArrayList
    static float calculateAveragePrice(ArrayList<Float> prices) {
        float sum = 0;
        for (int i = 0; i < prices.size(); i++) {
            sum += prices.get(i);
        }
        return sum / prices.size();
    }

    // Method 2a: Maximum from array
    static float findMaximumPrice(float[] prices) {
        float max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
            }
        }
        return max;
    }

    // Method 2b: Maximum from ArrayList
    static float findMaximumPrice(ArrayList<Float> prices) {
        float max = prices.get(0);
        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) > max) {
                max = prices.get(i);
            }
        }
        return max;
    }

    // Method 3: Count occurrences in array
    static int countOccurrences(float[] prices, float target) {
        int count = 0;
        for (float price : prices) {
            if (price == target) {
                count++;
            }
        }
        return count;
    }

    // Method 4: Cumulative sum from ArrayList
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

        System.out.print("10-Day Prices (Array):     ");
        for (int i = 0; i < priceArray.length; i++) {
            System.out.printf("%.1f", priceArray[i]);
            if (i < priceArray.length - 1) System.out.print(", ");
        }
        System.out.println();
        System.out.println("10-Day Prices (ArrayList): " + priceList);
        System.out.println();

        // Method 1: Average
        float avgArray     = calculateAveragePrice(priceArray);
        float avgArrayList = calculateAveragePrice(priceList);
        System.out.printf("1a. Average Price (Array):     $%.2f%n", avgArray);
        System.out.printf("1b. Average Price (ArrayList): $%.2f%n", avgArrayList);
        System.out.println();

        // Method 2: Maximum
        float maxArray     = findMaximumPrice(priceArray);
        float maxArrayList = findMaximumPrice(priceList);
        System.out.printf("2a. Maximum Price (Array):     $%.2f%n", maxArray);
        System.out.printf("2b. Maximum Price (ArrayList): $%.2f%n", maxArrayList);
        System.out.println();

        // Method 3: Count occurrences
        float target = 105.0f;
        int count1 = countOccurrences(priceArray, target);
        System.out.printf("3.  Occurrences of $%.1f in Array: %d time(s)%n",
                          target, count1);
        float target2 = 99.7f;
        int count2 = countOccurrences(priceArray, target2);
        System.out.printf("    Occurrences of $%.1f in Array: %d time(s)%n",
                          target2, count2);
        System.out.println();

        // Method 4: Cumulative sum
        ArrayList<Float> cumSum = computeCumulativeSum(priceList);
        System.out.println("4.  Cumulative Sum of Stock Prices (ArrayList):");
        for (int i = 0; i < cumSum.size(); i++) {
            System.out.printf("    Day %2d: $%.2f%n", i + 1, cumSum.get(i));
        }

        System.out.println("============================================");
    }
}
```

---

## 7. Output (Screenshots)

*Open StockAnalysis.java in IntelliJ IDEA and insert screenshots below.*

### Screenshot 1 — IDE Screenshot
*[INSERT: IntelliJ editor showing StockAnalysis.java with project panel visible on the left]*

### Screenshot 2 — Console Output
*[INSERT: IntelliJ Run console showing the complete output including:*
- *10-Day Prices for both Array and ArrayList*
- *Average Price: $103.74 (both versions)*
- *Maximum Price: $108.40 (both versions)*
- *Occurrences of $105.0: 1 time(s)*
- *Cumulative sums Day 1 through Day 10]*

---

## References

Eck, D. J. (2022). *Introduction to programming using Java* (Version 9, Swing ed.). Creative Commons CC 4.0. https://math.hws.edu/javanotes/
