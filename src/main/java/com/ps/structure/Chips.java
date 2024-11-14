package com.ps.structure;

import com.ps.enums.*;

public class Chips implements Product {
    private final ChipFlavor flavor;
    private final double price = 1.50;

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
        return flavor + " Chips - $" + price;
    }

    public Chips(ChipFlavor flavor) {
        this.flavor = flavor;
    }

    public ChipFlavor getFlavor() {
        return flavor;
    }
}