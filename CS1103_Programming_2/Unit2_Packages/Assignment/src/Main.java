import java.util.ArrayList;
import java.util.List;

import com.ecommerce.Customer;
import com.ecommerce.Product;
import com.ecommerce.orders.Order;

/**
 * Demonstration program for the simple e-commerce system.
 *
 * <p>This class lives outside the {@code com.ecommerce} and
 * {@code com.ecommerce.orders} packages and uses the import statement to bring
 * in the {@code Product}, {@code Customer}, and {@code Order} classes. It shows
 * a customer browsing a product catalog, adding items to a shopping cart,
 * removing an item, and placing an order, then prints the results. Order
 * placement is wrapped in try/catch so invalid operations are reported
 * gracefully rather than crashing the program.</p>
 *
 * @author Nicanor Maswili
 */
public class Main {

    /**
     * Program entry point.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("===== Welcome to the Online Store =====\n");

        // 1. Build the product catalog.
        List<Product> catalog = new ArrayList<>();
        catalog.add(new Product(101, "Wireless Mouse", 15.99));
        catalog.add(new Product(102, "Mechanical Keyboard", 49.50));
        catalog.add(new Product(103, "USB-C Cable", 8.75));
        catalog.add(new Product(104, "Laptop Stand", 27.00));

        // 2. Browse (display) the available products.
        System.out.println("Available products:");
        for (Product product : catalog) {
            System.out.println("  " + product);
        }
        System.out.println();

        // 3. Create a customer and add products to the shopping cart.
        Customer customer = new Customer(1, "Nicanor");
        System.out.println(customer + "\n");

        customer.addProduct(catalog.get(0));   // Wireless Mouse
        customer.addProduct(catalog.get(1));   // Mechanical Keyboard
        customer.addProduct(catalog.get(2));   // USB-C Cable

        // 4. Remove one product to show cart management.
        customer.removeProduct(catalog.get(2));   // remove USB-C Cable
        System.out.println();

        // 5. Show the current cart and its total.
        System.out.println("Current cart for " + customer.getName() + ":");
        for (Product product : customer.getShoppingCart()) {
            System.out.println("  " + product);
        }
        System.out.printf("Cart total: $%.2f%n%n", customer.calculateTotal());

        // 6. Place an order, handling any errors gracefully.
        try {
            Order order = new Order(5001, customer, customer.getShoppingCart());
            System.out.println(order.generateOrderSummary());
            System.out.println();

            // Update the order status through the fulfilment process.
            order.updateStatus("SHIPPED");
            System.out.println("Final status of order " + order.getOrderID()
                    + ": " + order.getStatus());
        } catch (IllegalArgumentException e) {
            System.out.println("Could not place order: " + e.getMessage());
        }

        // 7. Demonstrate validation: attempt an order with an empty cart.
        System.out.println("\n--- Validation demo: ordering with an empty cart ---");
        try {
            Customer emptyCartCustomer = new Customer(2, "Test User");
            Order badOrder = new Order(5002, emptyCartCustomer,
                    emptyCartCustomer.getShoppingCart());
            System.out.println(badOrder.generateOrderSummary());
        } catch (IllegalArgumentException e) {
            System.out.println("Order rejected as expected: " + e.getMessage());
        }

        System.out.println("\n===== Thank you for shopping with us! =====");
    }
}
