package com.ps.structure;

import com.ps.enums.SandwichSize;

public class Veggies extends Topping {

    public Veggies(String name, SandwichSize size) {
        super(name, 0.0, size);
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public boolean isExtra() {
        return false;
    }
}