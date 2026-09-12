package com.ecommerce;

/**
 * Represents a single product available for purchase in the e-commerce system.
 *
 * <p>Each product has a unique identifier, a name, and a price. The class
 * provides constructors, getters, and setters, and validates that the price is
 * never negative.</p>
 *
 * @author Nicanor Maswili
 */
public class Product {

    /** Unique identifier for the product. */
    private int productID;

    /** Display name of the product. */
    private String name;

    /** Price of the product in dollars; never negative. */
    private double price;

    /**
     * Constructs a Product with the given identifier, name, and price.
     *
     * @param productID the unique product identifier
     * @param name      the product name (must not be null or empty)
     * @param price     the product price (must not be negative)
     * @throws IllegalArgumentException if name is null/empty or price is negative
     */
    public Product(int productID, String name, double price) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative.");
        }
        this.productID = productID;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the product identifier.
     *
     * @return the product ID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Returns the product name.
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product price.
     *
     * @return the price in dollars
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets a new product name.
     *
     * @param name the new name (must not be null or empty)
     * @throws IllegalArgumentException if the name is null or empty
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty.");
        }
        this.name = name;
    }

    /**
     * Sets a new product price.
     *
     * @param price the new price (must not be negative)
     * @throws IllegalArgumentException if the price is negative
     */
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Product price cannot be negative.");
        }
        this.price = price;
    }

    /**
     * Returns a readable description of the product.
     *
     * @return a formatted string with the ID, name, and price
     */
    @Override
    public String toString() {
        return String.format("[ID %d] %s - $%.2f", productID, name, price);
    }
}
