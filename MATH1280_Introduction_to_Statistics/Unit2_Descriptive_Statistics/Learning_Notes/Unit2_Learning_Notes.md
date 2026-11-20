# MATH 1280 Unit 2 Learning Notes: Descriptive Statistics

Reading: Illowsky et al. (2023), Chapter 2.

## Graphs
- **Stem-and-leaf:** stem = leading digit(s), leaf = last digit; keeps every value; include empty stems to show gaps.
- **Histogram:** bars touch; class width = (max − min) / number of classes, rounded up; shows shape.
- **Box plot:** min, Q1, median, Q3, max; whiskers stop at the last value inside the fences; outliers drawn as points.

## Location
- Median: middle value (average of the two middle values when n is even).
- Q1 / Q3: medians of the lower / upper halves, leaving the median out when n is odd (OpenStax method).
- kth percentile position: i = (k / 100)(n + 1); if i is not a whole number, average the neighbours.
- Q1 = P25, median = Q2 = P50, Q3 = P75.

## Centre
- Mean x̄ = Σx / n (sensitive to outliers); median (resistant); mode (most frequent, can be several or none).
- Left skew: mean < median < mode. Right skew: mode < median < mean. Symmetric: about equal.

## Spread
- Range = max − min.
- IQR = Q3 − Q1. Fences: Q1 − 1.5·IQR and Q3 + 1.5·IQR; beyond them = potential outlier.
- Sample variance s² = Σ(x − x̄)² / (n − 1); population σ² = Σ(x − μ)² / N.
- Standard deviation = √variance. Values more than 2 SD from the mean are unusual (rule of thumb).
- Calculator: 1-Var Stats gives x̄, Sx (sample SD), σx (population SD), Q1, Med, Q3.
