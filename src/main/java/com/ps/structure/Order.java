package com.ps.structure;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderID;
    private static int nextOrderID;
    private List<Product> products;

    public Order() {
        this.orderID = nextOrderID++;
        products = new ArrayList<>();
    }

    public void addItem(Product product) {
        products.add(product);
    }

    public void removeItem(Product product) {
        products.remove(product);
    }

    public void clearOrder() {
        products.clear();
    }

    public double calculateTotal() {
        double total = 0.0;
        for (Product product : products) {
            total += product.calculatePrice();
        }
        return total;
    }

    public void printOrderSummary() {
        System.out.println("Order ID: " + orderID);
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Total : $" + calculateTotal());
    }

    public int getOrderID() {
        return orderID;
    }
}