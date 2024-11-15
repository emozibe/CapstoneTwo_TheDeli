package com.ps.toppings;

import com.ps.enums.*;

public class Veggies extends Topping {
    private final VeggieType type;

    public Veggies(VeggieType type, SandwichSize size) {
        super(type.name(), size);
        this.type = type;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public boolean isExtra() {
        return false;
    }

    @Override
    public Topping clone() {
        return new Veggies(this.type, this.size);
    }

    @Override
    public String toString() {
        return type.toString();
    }
}