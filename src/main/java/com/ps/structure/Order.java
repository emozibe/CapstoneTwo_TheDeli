package com.ps.structure;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private int orderID;
    private static int nextOrderID = 1;
    private String customerName;
    private List<Product> products;

    public Order(String customerName) {
        this.orderID = nextOrderID++;
        this.customerName = customerName;
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
        System.out.println("Customer Name: " + customerName);
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("Total : $" + calculateTotal());
    }

    public int getOrderID() {
        return orderID;
    }

    public List<Product> getItems() {
        return products;
    }

    public String getCustomerName() {
        return customerName;
    }
}