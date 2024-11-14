package com.ps.enums;

public enum SandwichSize {
    SMALL(5.50),
    MEDIUM(7.00),
    LARGE(8.50);

    private final double price;

    SandwichSize(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}