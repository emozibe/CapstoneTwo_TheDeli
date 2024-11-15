package com.ps.products;

import com.ps.enums.*;

public class Chips implements Product {
    private final ChipFlavor flavor;
    private final double price = 1.50;

    public Chips(ChipFlavor flavor) {
        this.flavor = flavor;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s: $%.2f", flavor, price);
    }

    public ChipFlavor getFlavor() {
        return flavor;
    }
}