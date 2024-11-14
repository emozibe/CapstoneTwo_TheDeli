package com.ps.structure;

import com.ps.enums.SandwichSize;

public class Condiments extends Topping {

    private boolean extraSauce;

    public Condiments(String name, SandwichSize size, boolean extraSauce) {
        super(name, size);
        this.extraSauce = extraSauce;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public boolean isExtra() {
        return extraSauce;
    }
}
