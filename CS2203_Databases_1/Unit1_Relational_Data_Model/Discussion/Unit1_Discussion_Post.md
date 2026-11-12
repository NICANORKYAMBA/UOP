# Designing the Database for a Dynamic E-Commerce Platform

**Course:** CS 2203 Databases 1
**Student:** Nicanor Maswili
**Due:** November 18, 2026

An online store adds products, customers and orders every minute while thousands of people shop
at once. Vidhya et al. (2016, pp. 24-25)
explain that file processing systems suffer from duplicated and inconsistent data and from
programs that are tied to the file layout, which are exactly the problems a DBMS removes.

## Four Key Characteristics of Databases and DBMS

1. **Self-describing nature.** The database keeps metadata about its own tables in a system
catalogue (Watt & Eng, 2014, Chapter 3). For the store, it records that a price is a decimal and
that every order must point to a real customer, so a new mobile app reads these rules from the DBMS.
2. **Insulation between programs and data.** Because the structure lives in the catalogue, I can
add a brand column to the product table without rewriting the checkout code. Codd designed the
relational model for this kind of data independence (Sharma et al., 2010, p. 29).
3. **Support for multiple views.** Shoppers see the catalogue and their own orders, warehouse staff
see stock levels, and finance sees sales totals. Payment details stay hidden from all of them.
4. **Data sharing and multiuser transactions.** In a flash sale, many buyers may reach for the last
item at once. Concurrency control keeps the data correct so the item is not sold twice (Watt & Eng,
2014, Chapter 3).

### Structuring the data with information models

Sharma et al. (2010, pp. 26-27) separate an information model, a conceptual picture without
implementation details, from data models, which are the detailed blueprints that developers
build. I would start with an entity-relationship model, the usual high-level conceptual model
(Watt & Eng, 2014, Chapter 4), and then map it to the relational model. Older models fit badly:
a hierarchical tree lets a product sit under only one parent, and the network model links records
with pointers that programs must follow (Sharma et al., 2010, pp. 28-29). The relational tables:

| Table | Primary key | Foreign keys | Main data |
|---|---|---|---|
| Customer | customer_id | none | name, email (unique), address |
| Category | category_id | parent_id to Category | product groups and subgroups |
| Product | product_id | category_id | name, SKU, price, stock |
| Orders | order_id | customer_id | order date, status, total |
| OrderItem | order_id + product_id | order_id, product_id | quantity, unit price |

## Essential Job Roles

Sharma et al. (2010, pp. 32-34) describe four main roles:

- **Data architect:** sets the data strategy and standards, so product, customer and sales data
are named and linked the same way across the business.
- **Database architect:** turns business requirements into a solution, chooses the DBMS, and plans
high availability and backups so the store stays online during holiday sales.
- **Database administrator (DBA):** looks after performance, integrity and security. Here that
means controlling access to customer data, tuning slow searches, and testing recovery plans. Vidhya et al. (2016, pp. 31-34) also give the DBA central control over
the schema and access rights.
- **Application developer:** writes the website and app code that query the database. In a small startup, one person may hold several roles (Sharma et al., 2010, p. 34).

## Developing Relations and Facing the Challenges

The relational model stores data as relations (tables) made of tuples and attributes, with each
attribute drawing its values from a domain (Watt & Eng, 2014, Chapter 7). Relationships are built
with keys. One customer places many orders, a 1:M relationship, so Orders carries customer_id as a
foreign key. Orders and products form an M:N relationship, which a relational table cannot hold
directly, so the bridge table OrderItem stores both keys (Watt & Eng, 2014, Chapter 8). Entity integrity keeps every primary key filled, and
referential integrity rejects an order whose customer does not exist, so no orphan rows appear
(Watt & Eng, 2014, Chapter 9).

Implementation brings real challenges:

- **Different product attributes.** A shirt has a size and a colour, while a laptop has memory and
a processor. One wide table would be full of nulls, so these belong in a separate variant
table. The object-relational model, with its user-defined types, is another
option (Sharma et al., 2010, p. 31).
- **Price history.** If an order only points to the product, a later price change would rewrite old
receipts. Storing unit_price in OrderItem is a small, controlled redundancy that keeps history
correct.
- **Stock under concurrency.** Placing an order and lowering the stock must happen in one
transaction, so the stock can never fall below zero.

**Question for the class:** Would you copy the price into OrderItem even though it already exists
in Product? When is a little redundancy worth it, and how would you stop it from causing
inconsistent data?

## References

Sharma, N., Perniu, L., Chong, R. F., Iyer, A., Nandan, C., Mitea, A. C., Nonvinkere, M., &
Danubianu, M. (2010). *Database fundamentals*. IBM Corporation.
https://public.dhe.ibm.com/software/dw/db2/express-c/wiki/Database_fundamentals.pdf

Vidhya, V., Jeyaram, G., & Ishwarya, K. R. (2016). *Database management systems*. Alpha Science
International.

Watt, A., & Eng, N. (2014). *Database design* (2nd ed.). BCcampus. https://opentextbc.ca/dbdesign01/
