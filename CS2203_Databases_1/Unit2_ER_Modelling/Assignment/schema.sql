-- E-commerce physical model for CS 2203 Unit 2.
-- Standard SQL that runs on MySQL 8 and SQLite (run PRAGMA foreign_keys = ON first in SQLite).

CREATE TABLE Customer (
    customer_id      INT           PRIMARY KEY,
    first_name       VARCHAR(50)   NOT NULL,
    last_name        VARCHAR(50)   NOT NULL,
    email            VARCHAR(100)  NOT NULL UNIQUE,
    phone            VARCHAR(20),
    shipping_address VARCHAR(255)  NOT NULL
);

CREATE TABLE Product (
    product_id   INT            PRIMARY KEY,
    sku          VARCHAR(30)    NOT NULL UNIQUE,
    product_name VARCHAR(100)   NOT NULL,
    category     VARCHAR(50)    NOT NULL,
    unit_price   DECIMAL(10,2)  NOT NULL CHECK (unit_price >= 0)
);

-- "Order" is a reserved word in SQL, so the table is named Orders.
CREATE TABLE Orders (
    order_id     INT            PRIMARY KEY,
    customer_id  INT            NOT NULL,
    order_date   DATE           NOT NULL,
    status       VARCHAR(20)    NOT NULL DEFAULT 'Pending'
                 CHECK (status IN ('Pending', 'Paid', 'Shipped', 'Delivered', 'Cancelled')),
    total_amount DECIMAL(10,2)  NOT NULL DEFAULT 0,
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);

-- Associative table that resolves the M:N relationship between Orders and Product.
CREATE TABLE Order_Item (
    order_id   INT            NOT NULL,
    product_id INT            NOT NULL,
    quantity   INT            NOT NULL CHECK (quantity > 0),
    unit_price DECIMAL(10,2)  NOT NULL,  -- price at the time of sale
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id)   REFERENCES Orders (order_id),
    FOREIGN KEY (product_id) REFERENCES Product (product_id)
);

CREATE TABLE Inventory (
    inventory_id       INT          PRIMARY KEY,
    product_id         INT          NOT NULL,
    warehouse_location VARCHAR(50)  NOT NULL,
    quantity_on_hand   INT          NOT NULL CHECK (quantity_on_hand >= 0),
    reorder_level      INT          NOT NULL DEFAULT 10,
    last_updated       DATE         NOT NULL,
    UNIQUE (product_id, warehouse_location),
    FOREIGN KEY (product_id) REFERENCES Product (product_id)
);

CREATE INDEX idx_orders_customer ON Orders (customer_id);
CREATE INDEX idx_item_product    ON Order_Item (product_id);
