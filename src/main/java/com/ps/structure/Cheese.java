package com.ps.structure;

import com.ps.enums.SandwichSize;

public class Cheese extends Topping {

    private boolean extraCheese;

    public Cheese(String name, SandwichSize size, boolean extraCheese) {
        super(name, size);
        this.extraCheese = extraCheese;
    }

    @Override
    public double getPrice() {
        double basePrice = switch (size) {
            case SMALL -> 0.75;
            case MEDIUM -> 1.50;
            case LARGE -> 2.25;
        };

        if (extraCheese) {
            basePrice += switch (size) {
                case SMALL -> 0.30;
                case MEDIUM -> 0.60;
                case LARGE -> 0.90;
            };
        }

        return basePrice;
    }

    @Override
    public boolean isExtra() {
        return extraCheese;
    }
}