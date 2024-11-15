package com.ps.receipts;

import com.ps.structure.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {

    private static final String RECEIPT_DIR = "receipts/";

    public static void saveReceipt(Order order, String customerName) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
        String fileName = RECEIPT_DIR + "receipt_" + timestamp + ".txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            // Order Header
            bw.write("Order ID: " + order.getOrderID());
            bw.newLine();
            bw.write("Customer Name: " + customerName);
            bw.newLine();
            bw.write("=================================");
            bw.newLine();

            // Sandwiches
            bw.write("Sandwiches:");
            bw.newLine();
            for (Product product : order.getItems()) {
                if (product instanceof Sandwich sandwich) {
                    bw.write("- " + (sandwich.isCustom() ? "Build-Your-Own" : sandwich.getName()));
                    bw.newLine();
                    bw.write("  Size: " + sandwich.getSandwichSize());
                    bw.newLine();
                    bw.write("  Bread: " + sandwich.getBreadType());
                    bw.newLine();
                    bw.write("  Toasted: " + (sandwich.isToasted() ? "Yes" : "No"));
                    bw.newLine();
                    bw.write("  Toppings:");
                    bw.newLine();
                    for (Topping topping : sandwich.getCurrentToppings()) {
                        bw.write("    - " + topping.toString());
                        bw.newLine();
                    }
                    bw.write("  Sandwich Total: $" + sandwich.calculatePrice());
                    bw.newLine();
                }
            }

            // Drinks
            bw.newLine();
            bw.write("Drinks:");
            bw.newLine();
            for (Product product : order.getItems()) {
                if (product instanceof Drink drink) {
                    bw.write(String.format("- %s (%s): $%.2f", drink.getType(), drink.getSize(), drink.calculatePrice()));
                    bw.newLine();
                }
            }

            // Chips
            bw.newLine();
            bw.write("Chips:");
            bw.newLine();
            for (Product product : order.getItems()) {
                if (product instanceof Chips chips) {
                    bw.write(String.format("- %s: $%.2f", chips.getFlavor(), chips.calculatePrice()));
                    bw.newLine();
                }
            }

            // Order Total
            bw.write("=================================");
            bw.newLine();
            bw.write(String.format("Order Total: $%.2f", order.calculateTotal()));
            bw.newLine();

            System.out.println("Receipt saved to: " + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}