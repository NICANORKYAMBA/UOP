# CS 2203 Unit 1: Peer Responses

Author: Nicanor Maswili
Course: CS 2203 Databases 1

Post at least **2** replies by Wednesday, November 18 (minimum 75 words, three to four
sentences or more). Each reply below connects to the classmate's post, cites a course reading
with a link, and asks a question to keep the discussion going.

---

## Peer Response 1: to Cheto Kevin

Hi Cheto,

I liked how your Order_Details table keeps the quantity and price, because that price records
what the customer actually paid even if the product price changes later. To answer your
question, losing referential integrity would create orphan records, such as an order whose
Customer_ID points to nobody, so the store could not ship it or show it in the customer's
history (Watt & Eng, 2014, Chapter 9). A second risk is deleting a product that old orders
still reference. Watt and Eng explain that foreign key rules can block that delete or decide
what happens to the child rows, so for orders I would block it and mark the product as
discontinued instead. Would you allow cascade deletes anywhere in this design?

Best,
Nicanor

Reference:
Watt, A., & Eng, N. (2014). *Database design* (2nd ed.). BCcampus.
https://opentextbc.ca/dbdesign01/chapter/chapter-9-integrity-rules-and-constraints/

---

## Peer Response 2: to Lord Michael Yinn Yinn

Hi Lord Michael,

Your hybrid idea makes sense to me, since apparel sizes and laptop specifications really do not
fit one fixed set of columns. Our course reading supports it too: Sharma et al. (2010, pp. 31-32)
describe the object-relational model, with user-defined types, and XML models as good options for
semi-structured data, so a JSON column inside the relational database could hold the variable
attributes without adding a second system. On your question, I would keep orders and payments in
3NF because they are the source of truth, and denormalize only on the read side, for example a
cached product page that can be rebuilt at any time. The price copied into Order_Items is
another safe kind of redundancy, because it never needs to change after the sale. How would you
keep the cache from showing a stock level that is already out of date during a flash sale?

Best,
Nicanor

Reference:
Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M., &
Danubianu, M. (2010). *Database fundamentals*. IBM Corporation.
https://public.dhe.ibm.com/software/dw/db2/express-c/wiki/Database_fundamentals.pdf
