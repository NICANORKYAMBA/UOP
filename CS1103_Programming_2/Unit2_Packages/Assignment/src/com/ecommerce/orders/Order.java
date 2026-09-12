package com.ecommerce.orders;

import java.util.ArrayList;
import java.util.List;

import com.ecommerce.Customer;
import com.ecommerce.Product;

/**
 * Represents an order placed by a customer in the e-commerce system.
 *
 * <p>An order records which customer placed it, the products included, the
 * total cost, and a status that moves through the fulfilment process. This
 * class lives in the {@code com.ecommerce.orders} package and imports the
 * {@code Product} and {@code Customer} classes from the {@code com.ecommerce}
 * package, demonstrating cross-package use with the import statement.</p>
 *
 * @author Nicanor Maswili
 */
public class Order {

    /** Unique identifier for the order. */
    private int orderID;

    /** The customer who placed the order. */
    private Customer customer;

    /** The products included in the order. */
    private List<Product> products;

    /** The total cost of the order. */
    private double orderTotal;

    /** The current status of the order (e.g., PLACED, SHIPPED, DELIVERED). */
    private String status;

    /**
     * Constructs an Order for the given customer using a copy of the products
     * supplied (typically the customer's shopping cart).
     *
     * @param orderID  the unique order identifier
     * @param customer the customer placing the order (must not be null)
     * @param products the products to include (must not be null or empty)
     * @throws IllegalArgumentException if customer is null, or products is null
     *                                  or empty
     */
    public Order(int orderID, Customer customer, List<Product> products) {
        if (customer == null) {
            throw new IllegalArgumentException("Order must have a customer.");
        }
        if (products == null || products.isEmpty()) {
            throw new IllegalArgumentException(
                    "Cannot place an order with an empty cart.");
        }
        this.orderID = orderID;
        this.customer = customer;
        this.products = new ArrayList<>(products);
        this.orderTotal = calculateOrderTotal();
        this.status = "PLACED";
    }

    /**
     * Calculates the total cost of the products in this order.
     *
     * @return the sum of the product prices
     */
    private double calculateOrderTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    /**
     * Returns the order identifier.
     *
     * @return the order ID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Returns the total cost of the order.
     *
     * @return the order total
     */
    public double getOrderTotal() {
        return orderTotal;
    }

    /**
     * Returns the current status of the order.
     *
     * @return the order status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the order.
     *
     * @param status the new status (must not be null or empty)
     * @throws IllegalArgumentException if the status is null or empty
     */
    public void updateStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status cannot be empty.");
        }
        this.status = status;
        System.out.println("Order " + orderID + " status updated to " + status
                + ".");
    }

    /**
     * Builds a readable summary of the order, listing the customer, each
     * product, the total, and the current status.
     *
     * @return a multi-line summary of the order
     */
    public String generateOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("===== Order Summary =====\n");
        summary.append("Order ID: ").append(orderID).append("\n");
        summary.append(customer.toString()).append("\n");
        summary.append("Products:\n");
        for (Product product : products) {
            summary.append("  - ").append(product.toString()).append("\n");
        }
        summary.append(String.format("Order Total: $%.2f%n", orderTotal));
        summary.append("Status: ").append(status).append("\n");
        summary.append("=========================");
        return summary.toString();
    }
}
