package com.ps.structure;

import com.ps.enums.SandwichSize;
import com.ps.enums.CheeseType;

public class Cheese extends Topping {
    private final CheeseType type;
    private final boolean extraCheese;

    public Cheese(CheeseType type, SandwichSize size, boolean extraCheese) {
        super(type.name(), size); // Use enum name as display name
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

    public CheeseType getType() {
        return type;
    }
}