# Sampling, Dot Plots, and Frequency Tables

**Course:** MATH 1280 Introduction to Statistics
**Student:** Nicanor Maswili
**Due:** November 18, 2026

This paper explains key statistical terms and sampling methods, then organizes two data sets.

## Question 1

### a. Statistics, probability, population, and sample

Imagine a café owner who wants to know which drink customers like best.

- **Statistics** is the science of collecting, organizing, analyzing, and interpreting data so we can make decisions (Illowsky et al., 2023, Section 1.1). For the café, it is the whole process from asking customers to deciding the menu.
- **Probability** is the mathematics of chance: how likely an event is to happen (Illowsky et al., 2023, Section 1.1). If 30 of 100 surveyed customers chose cappuccino, the estimated probability that the next customer orders a cappuccino is 30/100 = 0.30.
- **Population** is the whole group we want to learn about (Brief Tutorial Statistics, 2015). Here it is every customer of the café.
- **Sample** is the smaller part of the population that we actually study. Surveying everyone is costly, so the owner surveys 100 customers. The sample's 30% is a statistic, used to estimate the population's true value, the parameter (Illowsky et al., 2023, Section 1.1).

### b. Simple random sampling vs stratified sampling

In a **simple random sample**, every member of the population has the same chance of being chosen (Illowsky et al., 2023, Section 1.2). The café could number all 1,000 customers on its loyalty list and use a random number generator to pick 100 of them.

In a **stratified sample**, the population is first divided into groups called strata that share a feature, and then a random sample is taken from every stratum, usually in proportion to its size (Illowsky et al., 2023, Section 1.2).

Suppose 60% of the café's customers come in the morning and 40% in the evening. A simple random sample of 100 could, by chance, include 80 morning customers and overstate morning tastes. A stratified sample fixes this by randomly choosing 60 morning customers and 40 evening customers.

The key difference is that simple random sampling chooses from the whole population at once, while stratified sampling guarantees that every important group is represented. When strata differ from each other, a stratified sample gives more precise estimates than a simple random sample of the same size, so sampling variability is lower (Statistics Canada, 2021).

## Question 2

### a. Dot plot

Household size is quantitative discrete data at the ratio level, since it is a count with a true zero (Dr. Kyle Besing, 2020), so a dot plot suits it well. Each dot in Figure 1 represents one family, so the 23 dots match the table.

**Figure 1**

*Dot Plot of Household Size in a Small Rural Area*

[FIGURE figures/fig1_dot_plot.png]

*Note.* N = 23 families. Created by the author in Python (Matplotlib) from the table in Question 2.

Most households have 4 or 5 members.

### b. Families with more than four members

"More than four" means 5, 6, or 7 members, so 4 itself is excluded (Table 1).

**Table 1**

*Households With More Than Four Members*

| Members (x) | Families (f) |
|---|---|
| 5 | 6 |
| 6 | 3 |
| 7 | 2 |
| **Total (x > 4)** | **11** |

Number of families with x > 4 = 6 + 3 + 2 = **11 families**.

Check: 23 − (1 + 4 + 7) = 23 − 12 = 11.

## Question 3

Each cumulative frequency is a running total of all students up to the upper boundary of the interval (Illowsky et al., 2023, Section 1.3). Grouping data into classes keeps it readable (FuseSchool - Global Education, 2017), and the frequency of a single class is found by subtracting the previous cumulative frequency (Table 2).

**Table 2**

*Class Frequencies Derived From the Cumulative Frequencies*

| Hours studied | Cumulative frequency | Class frequency |
|---|---|---|
| 0 ≤ h < 5 | 8 | 8 |
| 5 ≤ h < 10 | 18 | 18 − 8 = 10 |
| 10 ≤ h < 15 | 30 | 30 − 18 = 12 |
| 15 ≤ h < 20 | 45 | 45 − 30 = 15 |
| 20 ≤ h ≤ 25 | 55 | 55 − 45 = 10 |

### a. Students who studied between 10 and 15 hours

The interval 10 ≤ h < 15 is the cumulative count up to 15 hours minus the count up to 10 hours: 30 − 18 = **12 students**.

### b. Students who studied less than 20 hours

The row "0 to 20" counts every student with 0 ≤ h < 20, because the upper boundary 20 is excluded. No subtraction is needed, so the answer is read directly: **45 students**.

## References

Brief Tutorial Statistics. (2015, November 3). *Statistics - terms and definitions: Population, sample, attributes, data values* [Video]. YouTube. https://www.youtube.com/watch?v=qcnkA7iA3QI

Dr. Kyle Besing. (2020, January 15). *Levels of measurement, frequency, and relative frequency* [Video]. YouTube. https://www.youtube.com/watch?v=OAtx6-H3JdE

FuseSchool - Global Education. (2017, December 6). *Frequency tables | Statistics | Maths | FuseSchool* [Video]. YouTube. https://www.youtube.com/watch?v=JC7DG8Qko9I

Illowsky, B., Dean, S., Birmajer, D., Blount, B., Boyd, S., Einsohn, M., Helmreich, J., Kenyon, L., Lee, S., & Taub, J. (2023). *Introductory statistics* (2nd ed.). OpenStax. https://openstax.org/details/books/introductory-statistics-2e

Statistics Canada. (2021, September 2). *3.2 Sampling*. In *Power from data!* https://www150.statcan.gc.ca/n1/edu/power-pouvoir/ch13/prob/5214899-eng.htm
