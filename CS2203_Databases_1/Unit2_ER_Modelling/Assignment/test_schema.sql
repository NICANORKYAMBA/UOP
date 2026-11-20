PRAGMA foreign_keys = ON;
.read schema.sql
INSERT INTO Customer VALUES (1, 'Amina', 'Otieno', 'amina@example.com', '+254700000001', '12 Moi Ave, Nairobi');
INSERT INTO Customer VALUES (2, 'Brian', 'Kamau', 'brian@example.com', NULL, '4 Kenyatta Rd, Nakuru');
INSERT INTO Product VALUES (10, 'SKU-MUG-01', 'Ceramic Mug', 'Kitchen', 450.00);
INSERT INTO Product VALUES (11, 'SKU-TEE-02', 'Cotton T-Shirt', 'Clothing', 900.00);
INSERT INTO Orders VALUES (100, 1, '2026-11-20', 'Paid', 1800.00);
INSERT INTO Order_Item VALUES (100, 10, 2, 450.00);
INSERT INTO Order_Item VALUES (100, 11, 1, 900.00);
INSERT INTO Inventory VALUES (1, 10, 'Nairobi-WH1', 120, 20, '2026-11-20');
INSERT INTO Inventory VALUES (2, 10, 'Mombasa-WH2', 35, 10, '2026-11-20');
INSERT INTO Inventory VALUES (3, 11, 'Nairobi-WH1', 8, 15, '2026-11-20');
.headers on
.mode column
SELECT o.order_id, c.first_name || ' ' || c.last_name AS customer, p.product_name, oi.quantity, oi.unit_price
FROM Orders o JOIN Customer c ON c.customer_id = o.customer_id
JOIN Order_Item oi ON oi.order_id = o.order_id JOIN Product p ON p.product_id = oi.product_id;
SELECT p.product_name, i.warehouse_location, i.quantity_on_hand, i.reorder_level FROM Inventory i JOIN Product p USING (product_id) WHERE i.quantity_on_hand < i.reorder_level;
.print '--- constraint tests (each must fail) ---'
INSERT INTO Orders VALUES (101, 99, '2026-11-20', 'Paid', 0);
INSERT INTO Order_Item VALUES (100, 10, 5, 450.00);
INSERT INTO Customer VALUES (3, 'C', 'D', 'amina@example.com', NULL, 'x');
INSERT INTO Inventory VALUES (4, 11, 'Nairobi-WH1', 5, 10, '2026-11-20');
INSERT INTO Order_Item VALUES (100, 11, 0, 900.00);
