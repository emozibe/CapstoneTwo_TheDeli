package com.ps.structure;

import com.ps.enums.SandwichSize;

public class Condiments extends Topping {

    private boolean extraSauce;

    public Condiments(String name, double price, SandwichSize size, boolean extraSauce) {
        super(name, price, size);
        this.extraSauce = extraSauce;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public boolean isExtraSauce() {
        return extraSauce;
    }

    public void setExtraSauce(boolean extraSauce) {
        this.extraSauce = extraSauce;
    }
}