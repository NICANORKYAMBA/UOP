# Describing Test Scores With Numbers and Graphs

**Course:** MATH 1280 Introduction to Statistics
**Student:** Nicanor Maswili
**Due:** November 25, 2026

This paper summarizes two sets of test scores, first with numerical measures and then with graphs, following the methods in Chapter 2 of Illowsky et al. (2023).

## Question 1

The ordered data are 45, 62, 75, 85, 90, 93, 95, 95, 100, so n = 9.

### a. Range

Range = highest − lowest = 100 − 45 = **55**.

### b. Quartiles and percentiles

The median is the 5th value, 90. Q1 is the median of the lower half (45, 62, 75, 85) and Q3 is the median of the upper half (93, 95, 95, 100), leaving the median out of both halves (Illowsky et al., 2023, Section 2.3):

- **Q1** = (62 + 75) / 2 = **68.5**
- **Q3** = (95 + 95) / 2 = **95**

For the kth percentile, the position is i = (k / 100)(n + 1), and a decimal position means averaging the two neighbouring values (Illowsky et al., 2023, Section 2.3):

- **25th percentile:** i = 0.25 × 10 = 2.5, between the 2nd and 3rd values, so (62 + 75) / 2 = **68.5**
- **50th percentile:** i = 0.50 × 10 = 5, the 5th value, **90**

### c. Mean, median, mode, variance, and standard deviation

- **Mean:** x̄ = Σx / n = 740 / 9 ≈ **82.22**
- **Median:** the middle (5th) value, **90**
- **Mode:** **95**, the only value that appears twice (MarinStatsLectures-R Programming & Statistics, 2019c)

The sample variance is s² = Σ(x − x̄)² / (n − 1) (Illowsky et al., 2023, Section 2.7).

**Table 1**

*Squared Deviations From the Mean (x̄ ≈ 82.22)*

| x | x − x̄ | (x − x̄)² |
|---|---|---|
| 45 | −37.22 | 1385.49 |
| 62 | −20.22 | 408.94 |
| 75 | −7.22 | 52.16 |
| 85 | 2.78 | 7.72 |
| 90 | 7.78 | 60.49 |
| 93 | 10.78 | 116.16 |
| 95 | 12.78 | 163.27 |
| 95 | 12.78 | 163.27 |
| 100 | 17.78 | 316.05 |
| **Sum** | **0** | **2673.56** |

- **Variance:** s² = 2673.56 / 8 ≈ **334.19**
- **Standard deviation:** s = √334.19 ≈ **18.28**

Dividing by n − 1 corrects for using the sample mean instead of the unknown population mean (MarinStatsLectures-R Programming & Statistics, 2018). If the nine scores were treated as the whole population, σ² = 2673.56 / 9 ≈ 297.06 and σ ≈ 17.24.

### d. Equal values in (b) and (c)

- **Q1 = 25th percentile = 68.5.** These are the same by definition: the first quartile is the 25th percentile, since a quarter of the data lies below it (MarinStatsLectures-R Programming & Statistics, 2019d).
- **Median = 50th percentile = 90.** The median is the second quartile, the point with half the data below it.
- **Q3 = mode = 95.** This one is a coincidence of this data set. Q3 is the average of the 7th and 8th values, and both are 95, which is also the repeated value that makes the mode. A small change, such as one 95 becoming 96, would separate them.

The mean (82.22) is below the median (90), which is below the mode (95). This order shows a left-skewed distribution: the single low score of 45 pulls the mean down far more than it moves the median (Illowsky et al., 2023, Section 2.6).

## Question 2

The 25 ordered scores give a median of 84 (13th value), Q1 = 77.5, Q3 = 90.5, and IQR = 90.5 − 77.5 = 13. A value is a potential outlier if it lies more than 1.5 × IQR beyond a quartile (Illowsky et al., 2023, Section 2.4):

- Lower fence = 77.5 − 1.5(13) = 58, so no low outliers.
- Upper fence = 90.5 + 1.5(13) = 110, so **119 is a potential outlier**.

**Figure 1**

*Stem-and-Leaf Plot of 25 Statistics Test Scores*

[FIGURE figures/fig1_stem_and_leaf.png]

The empty stem 10 shows a clear gap between 95 and 119 (The Organic Chemistry Tutor, 2019).

**Figure 2**

*Histogram of 25 Statistics Test Scores*

[FIGURE figures/fig2_histogram.png]

Most scores fall between 70 and 99, and the isolated bar at 110 to 119 is the potential outlier (MarinStatsLectures-R Programming & Statistics, 2019a).

**Figure 3**

*Box Plot of 25 Statistics Test Scores*

[FIGURE figures/fig3_box_plot.png]

The upper whisker stops at 95, the largest value inside the fence, and 119 is drawn as a separate point (MarinStatsLectures-R Programming & Statistics, 2019b).

All three graphs agree that 119 is a potential outlier. It should be checked rather than deleted: it may be a typing error for a score like 91, or a real bonus score above 100.

## References

Illowsky, B., Dean, S., Birmajer, D., Blount, B., Boyd, S., Einsohn, M., Helmreich, J., Kenyon, L., Lee, S., & Taub, J. (2023). *Introductory statistics* (2nd ed.). OpenStax. https://openstax.org/details/books/introductory-statistics-2e

MarinStatsLectures-R Programming & Statistics. (2018, June 19). *Standard deviation & degrees of freedom explained | Statistics tutorial | MarinStatsLectures* [Video]. YouTube. https://www.youtube.com/watch?v=nlm9gfso4mw

MarinStatsLectures-R Programming & Statistics. (2019a, August 20). *Histograms and density plots for numeric variables | Statistics tutorial | MarinStatsLectures* [Video]. YouTube. https://www.youtube.com/watch?v=p-VOptZ0E5Y

MarinStatsLectures-R Programming & Statistics. (2019b, August 27). *Boxplots in statistics | Statistics tutorial | MarinStatsLectures* [Video]. YouTube. https://www.youtube.com/watch?v=9AKLd5FHzfI

MarinStatsLectures-R Programming & Statistics. (2019c, September 3). *Mean, median and mode in statistics | Statistics tutorial | MarinStatsLectures* [Video]. YouTube. https://www.youtube.com/watch?v=2pyq0TJmpzs

MarinStatsLectures-R Programming & Statistics. (2019d, October 8). *Percentiles, quantiles and quartiles in statistics | Statistics tutorial | MarinStatsLectures* [Video]. YouTube. https://www.youtube.com/watch?v=Ky7QeVgv-BA

The Organic Chemistry Tutor. (2019, January 11). *Stem and leaf plot* [Video]. YouTube. https://www.youtube.com/watch?v=MUCvUgGfzdo
