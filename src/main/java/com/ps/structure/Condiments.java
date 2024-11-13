package com.ps.structure;

import com.ps.enums.SandwichSize;

public class Condiments extends Topping {

    private boolean extraSauce;

    public Condiments(String name, SandwichSize size, boolean extraSauce) {
        super(name, 0.00, size);
        this.extraSauce = extraSauce;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isExtra() {
        return extraSauce;
    }
}