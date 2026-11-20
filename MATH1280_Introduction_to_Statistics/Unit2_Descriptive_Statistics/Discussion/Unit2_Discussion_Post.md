# Skewed Data and Outliers: Choosing the Right Summary

**Course:** MATH 1280 Introduction to Statistics
**Student:** Nicanor Maswili
**Due:** November 25, 2026

## Measures of Location and Central Tendency in Skewed Data

In a skewed distribution, the three measures of centre separate. The mean reacts to every value, including extreme ones, so it is pulled toward the long tail; the median only depends on the middle position; and the mode stays at the peak. When data are skewed to the left, the mean is usually below the median, and when they are skewed to the right, it is usually above it (Illowsky et al., 2023, Section 2.6).

Quartiles and percentiles show the skew too. In right-skewed data, the gap from the median to Q3 is wider than the gap from Q1 to the median, and upper percentiles such as the 90th sit far from the centre. A box plot makes this visible, because the four quarters of the data have different widths and the extreme values lie far from the middle half (Illowsky et al., 2023, Section 2.4).

Two examples show what this means for interpretation:

- **Left skew (test scores).** In our assignment data set (45, 62, 75, 85, 90, 93, 95, 95, 100), the mean is 82.2, the median 90, and the mode 95. Saying "the class averaged 82" hides that most students scored 90 or above; one score of 45 drags the mean down. The median better describes a typical student, while the mean warns that someone is struggling.
- **Right skew (response times).** In my DevOps work, most web requests finish in about 100 milliseconds, but a few take several seconds. The mean looks worse than what most users feel, the median describes the typical user, and the 95th or 99th percentile describes the slowest users, which is why engineers report percentiles rather than only the mean.

So for skewed data, the median and IQR give the fairest typical value and spread, the mean shows the total effect of the tail, and percentiles show how far the tail reaches.

## Sources of Variability and Outliers

Outliers can be found in three steps:

1. **Identify:** use a box plot and the 1.5 × IQR rule, where values below Q1 − 1.5(IQR) or above Q3 + 1.5(IQR) are potential outliers (Illowsky et al., 2023, Section 2.4), or flag values more than two standard deviations from the mean (Illowsky et al., 2023, Section 2.7). The two rules can disagree, because the outlier itself inflates the standard deviation, so the IQR rule is safer for skewed data.
2. **Assess:** ask why the value is extreme. Is it a typing or measurement error, a value from a different population, or a real but rare case?
3. **Address:** correct clear errors, and report results with and without the outlier so readers can see its effect. Using the median and IQR, which resist outliers, is another option (MarinStatsLectures-R Programming & Statistics, 2019).

Excluding an outlier gives better insight when it is an error, such as a test score of 119 on a test marked out of 100. Keeping it would distort the mean and standard deviation.

Excluding outliers misrepresents the data when the extreme values are the story. In my work, the rare slow requests are exactly the incidents we must fix, so removing them would make the system look healthy when users are suffering. The same holds for bank fraud.

**Question for the class:** When you find an outlier in your own data, how do you decide whether it is an error or an important real case?

## References

Illowsky, B., Dean, S., Birmajer, D., Blount, B., Boyd, S., Einsohn, M., Helmreich, J., Kenyon, L., Lee, S., & Taub, J. (2023). *Introductory statistics* (2nd ed.). OpenStax. https://openstax.org/details/books/introductory-statistics-2e

MarinStatsLectures-R Programming & Statistics. (2019, August 27). *Boxplots in statistics | Statistics tutorial | MarinStatsLectures* [Video]. YouTube. https://www.youtube.com/watch?v=9AKLd5FHzfI
