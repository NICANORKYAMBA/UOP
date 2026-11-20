# MATH 1280 Unit 2: Peer Responses

Author: Nicanor Maswili
Course: MATH 1280 Introduction to Statistics

Post at least **2** replies by Wednesday, November 25 (minimum 75 words, three to four sentences or more). All numbers in these replies were checked by calculation. Three drafts are provided; pick any two.

---

## Peer Response 1: to Danny Morales

Hi Danny,

Your market basket example is a great real case, and I checked your numbers: the mean of $27.86, Q1 of $10, Q3 of $20, and the upper fence of $35 are all correct. One extra step that could help is the outer fence from the NIST handbook, Q3 + 3(IQR) = 20 + 30 = $50, which separates mild outliers from extreme ones (National Institute of Standards and Technology [NIST], n.d.). The $125 stroller is beyond it, so it is an extreme outlier, and without it the mean falls from $27.86 to about $11.67, very close to your median of $12. That shows how much a single sale can move the figure you compare with your $45 target. Would tracking the median basket alongside the mean change how you plan promotions?

Best,
Nicanor

Reference:
National Institute of Standards and Technology. (n.d.). *What are outliers in the data?* In *NIST/SEMATECH e-handbook of statistical methods* (Section 7.1.6). https://www.itl.nist.gov/div898/handbook/prc/section1/prc16.htm

---

## Peer Response 2: to Sierra Annala

Hi Sierra,

I agree with your point that an outlier should be investigated before it is removed, and that the median is more resistant than the mean. One thing I found interesting is that the two detection methods you mention, the IQR rule and the standard deviation rule, can give different answers. The textbook treats values more than two standard deviations from the mean as unusual, but only as a rule of thumb (Illowsky et al., 2023, Section 2.7). A large outlier inflates the standard deviation itself, which can hide it from the two-standard-deviation check, while the IQR rule is based on quartiles and is not affected that way (Illowsky et al., 2023, Section 2.4). For skewed data, would you trust the box plot over the standard deviation rule?

Best,
Nicanor

Reference:
Illowsky, B., Dean, S., Birmajer, D., Blount, B., Boyd, S., Einsohn, M., Helmreich, J., Kenyon, L., Lee, S., & Taub, J. (2023). *Introductory statistics* (2nd ed.). OpenStax. https://openstax.org/details/books/introductory-statistics-2e

---

## Peer Response 3: to Daniel Kamwada

Hi Daniel,

Your salary example shows the problem with the mean very clearly, and your quartiles and fence check out: Q1 = 32, Q3 = 45, and the upper fence of 64.5 flags the 250. Taking it one step further, the NIST handbook's outer fence is Q3 + 3(IQR) = 45 + 39 = 84, so the 250 is an extreme outlier rather than a mild one (National Institute of Standards and Technology [NIST], n.d.). Without it, the mean drops from about 67 to about 36.7, much closer to the median of 38. A small tip: the two video links in your references open Khan Academy videos, so you may want to swap in the MarinStatsLectures links from the course page. How would you report the executive's salary to a company if it is genuine?

Best,
Nicanor

Reference:
National Institute of Standards and Technology. (n.d.). *What are outliers in the data?* In *NIST/SEMATECH e-handbook of statistical methods* (Section 7.1.6). https://www.itl.nist.gov/div898/handbook/prc/section1/prc16.htm
