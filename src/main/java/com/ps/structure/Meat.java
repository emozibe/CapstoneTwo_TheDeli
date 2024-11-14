package com.ps.structure;

import com.ps.enums.SandwichSize;

public class Meat extends Topping {
    private boolean extraMeat;

    public Meat(String name, SandwichSize size, boolean extraMeat) {
        super(name, size);
        this.extraMeat = extraMeat;
    }

    @Override
    public double getPrice() {
        double basePrice = switch (size) {
            case SMALL -> 1.00;
            case MEDIUM -> 2.00;
            case LARGE -> 3.00;
        };

        return extraMeat ? basePrice + switch (size) {
            case SMALL -> 0.50;
            case MEDIUM -> 1.00;
            case LARGE -> 1.50;
        } : basePrice;
    }

    @Override
    public boolean isExtra() {
        return extraMeat;
    }
}