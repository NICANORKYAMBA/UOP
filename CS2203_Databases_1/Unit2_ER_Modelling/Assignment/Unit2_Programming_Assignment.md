# E-Commerce Database Design: From ER Model to Tables

**Course:** CS 2203 Databases 1
**Student:** Nicanor Maswili
**Due:** November 25, 2026

As the database administrator for a small online store, I modelled four entities, Product, Customer, Order, and Inventory, then turned the model into tested tables.

## a. Entities, Key Attributes, and Relationships

**Table 1**

*Entities and Key Attributes*

| Entity | Primary key | Other key attributes |
|---|---|---|
| Customer | customer_id | first_name, last_name, email (unique), phone, shipping_address |
| Product | product_id | sku (unique), product_name, category, unit_price |
| Order | order_id | order_date, status, total_amount |
| Inventory | inventory_id | warehouse_location, quantity_on_hand, reorder_level, last_updated |

Each relationship has a cardinality (how many) and a participation constraint (whether taking part is mandatory). Total participation means every instance must take part, while partial participation means it may not (Vidhya et al., 2016, pp. 43-60).

- **Customer places Order (1:N).** A customer can place many orders, and each order belongs to exactly one customer. Order participates totally; Customer partially, since a new customer may not have ordered yet.
- **Order contains Product (M:N).** An order holds one or more products, and a product can appear in many orders. Order participates totally; Product partially. The relationship has its own attributes, quantity and unit_price.
- **Product is tracked in Inventory (1:N).** A product can be stocked in several warehouses, and each inventory record describes exactly one product. Inventory participates totally; Product partially, because a new product may not be stocked yet.

Inventory has no direct link to Customer or Order. It connects to them through Product: when an order is paid, the quantity_on_hand of each product in that order is reduced, so all four entities work together.

## b. Tables With Primary and Foreign Keys

A relational table cannot store an M:N relationship directly, so it becomes an associative table whose key combines the keys of both entities (Watt & Eng, 2014, Chapter 8). This gives five tables.

**Table 2**

*Relational Schema*

| Table | Primary key | Foreign keys |
|---|---|---|
| Customer | customer_id | none |
| Product | product_id | none |
| Orders | order_id | customer_id → Customer |
| Order_Item | (order_id, product_id) | order_id → Orders; product_id → Product |
| Inventory | inventory_id | product_id → Product |

"Order" is a reserved word in SQL, so the table is named Orders. Order_Item stores the price paid, so later price changes do not alter past orders, and Inventory has UNIQUE (product_id, warehouse_location) so a product is listed once per warehouse. I wrote the tables in SQL and tested them with sample data: the database rejected an order for a non-existent customer, a duplicate email, and a quantity of zero, which confirms that the keys and constraints work.

## c. Entity-Relationship Diagrams

**Figure 1**

*Conceptual ER Diagram in Chen Notation*

[FIGURE figures/fig1_chen_erd.png]

*Note.* Double lines show total participation and single lines show partial participation. Primary keys are underlined.

**Figure 2**

*Physical ER Diagram in Crow's Foot Notation*

[FIGURE figures/fig2_physical_erd.png]

*Note.* Each line end shows the minimum and maximum, so participation and cardinality appear together (for example, 1..1 to 0..* for Customer to Orders).

Figure 1 shows the business view, and Figure 2 shows the same design as tables with data types and keys. In crow's foot notation, a circle means optional (partial participation) and a bar means mandatory (total participation).

## d. Two Differences Between Conceptual and Physical Design

**1. Level of detail and audience.** A conceptual model sketches the entities and how they relate, stays free of technical terms, and lets business users review the design (Nalimov, 2021). Figure 1 is something the store's managers can check: does a customer really need an account before ordering, and can a product be in several warehouses? The physical model adds what developers need: data types such as DECIMAL(10,2), primary and foreign keys, unique constraints, and indexes on foreign keys for faster joins.

**2. Independence from technology.** The conceptual model is not tied to any DBMS or hardware, so changing either has no effect on it (Watt & Eng, 2014, Chapter 5). The physical design is tied to the chosen system, here MySQL, and covers storage and indexing (Watt & Eng, 2014, Chapter 5). In this scenario, renaming Order to Orders, choosing column types, and adding the Order_Item table are physical decisions that would change if the company moved to another DBMS, while the conceptual model would stay the same. A logical model sits between the two, adding attributes and relationships before the DBMS is chosen (Ellie, 2022; Nalimov, 2021).

## References

Ellie. (2022, July 6). *Conceptual vs logical data models - What are the key differences?* [Video]. YouTube. https://www.youtube.com/watch?v=Ex6wszg2XZ8

Nalimov, C. (2021, September 22). *What is a conceptual data model? With examples!* Gleek. https://www.gleek.io/blog/conceptual-data-model.html

Vidhya, V., Jeyaram, G., & Ishwarya, K. R. (2016). *Database management systems*. Alpha Science International.

Watt, A., & Eng, N. (2014). *Database design* (2nd ed.). BCcampus. https://opentextbc.ca/dbdesign01/
