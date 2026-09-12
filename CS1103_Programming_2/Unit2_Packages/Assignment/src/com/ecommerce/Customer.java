package com.ecommerce;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer of the e-commerce system.
 *
 * <p>A customer has an identifier, a name, and a shopping cart that holds the
 * products they intend to buy. The class provides methods to add and remove
 * products from the cart and to calculate the total cost of the cart.</p>
 *
 * @author Nicanor Maswili
 */
public class Customer {

    /** Unique identifier for the customer. */
    private int customerID;

    /** Name of the customer. */
    private String name;

    /** The products currently in the customer's shopping cart. */
    private List<Product> shoppingCart;

    /**
     * Constructs a Customer with the given identifier and name and an empty cart.
     *
     * @param customerID the unique customer identifier
     * @param name       the customer name (must not be null or empty)
     * @throws IllegalArgumentException if the name is null or empty
     */
    public Customer(int customerID, String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be empty.");
        }
        this.customerID = customerID;
        this.name = name;
        this.shoppingCart = new ArrayList<>();
    }

    /**
     * Returns the customer identifier.
     *
     * @return the customer ID
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Returns the customer name.
     *
     * @return the customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the list of products currently in the shopping cart.
     *
     * @return the shopping cart contents
     */
    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    /**
     * Adds a product to the shopping cart.
     *
     * @param product the product to add (must not be null)
     * @throws IllegalArgumentException if the product is null
     */
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Cannot add a null product.");
        }
        shoppingCart.add(product);
        System.out.println(name + " added " + product.getName() + " to the cart.");
    }

    /**
     * Removes a product from the shopping cart.
     *
     * @param product the product to remove
     * @return true if the product was present and removed, false otherwise
     */
    public boolean removeProduct(Product product) {
        boolean removed = shoppingCart.remove(product);
        if (removed) {
            System.out.println(name + " removed " + product.getName()
                    + " from the cart.");
        } else {
            System.out.println(product.getName() + " was not found in the cart.");
        }
        return removed;
    }

    /**
     * Calculates the total cost of all products in the shopping cart.
     *
     * @return the sum of the prices of the products in the cart
     */
    public double calculateTotal() {
        double total = 0.0;
        for (Product product : shoppingCart) {
            total += product.getPrice();
        }
        return total;
    }

    /**
     * Returns a readable description of the customer.
     *
     * @return a formatted string with the ID and name
     */
    @Override
    public String toString() {
        return String.format("Customer [ID %d]: %s", customerID, name);
    }
}
