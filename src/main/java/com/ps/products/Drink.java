package com.ps.products;

import com.ps.enums.*;

public class Drink implements Product {
    private final DrinkSize size;
    private final DrinkType type;
    private final double price;

    public Drink(DrinkSize size, DrinkType type) {
        this.size = size;
        this.type = type;
        this.price = (type == DrinkType.WATER) ? 0.00 : switch (size) {
            case SMALL -> 2.00;
            case MEDIUM -> 2.50;
            case LARGE -> 3.00;
        };
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s (%s): $%.2f", type.toString(), size, price);
    }

    public DrinkSize getSize() {
        return size;
    }

    public DrinkType getType() {
        return type;
    }
}