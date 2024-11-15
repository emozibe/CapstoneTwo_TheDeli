package com.ps.structure;

import com.ps.enums.*;

public class Cheese extends Topping {
    private final CheeseType type;
    private final boolean extraCheese;

    public Cheese(CheeseType type, SandwichSize size, boolean extraCheese) {
        super(type.name(), size);
        this.type = type;
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

    @Override
    public Topping clone() {
        return new Cheese(this.type, this.size, this.extraCheese);
    }

    @Override
    public String toString() {
        return type.toString() + (extraCheese ? " (Extra)" : "");
    }

    public CheeseType getType() {
        return type;
    }
}