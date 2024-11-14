package com.ps.structure;

import com.ps.enums.SandwichSize;
import com.ps.enums.MeatType;

public class Meat extends Topping {
    private final MeatType type;
    private final boolean extraMeat;

    public Meat(MeatType type, SandwichSize size, boolean extraMeat) {
        super(type.name(), size); // Use enum name as display name
        this.type = type;
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

    @Override
    public Topping clone() {
        return new Meat(this.type, this.size, this.extraMeat);
    }

    public MeatType getType() {
        return type;
    }
}