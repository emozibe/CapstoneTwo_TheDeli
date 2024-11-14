package com.ps.structure;

import com.ps.enums.SandwichSize;

public abstract class Topping {

    protected String name;
    protected SandwichSize size;

    public Topping(String name, SandwichSize size) {
        this.name = name;
        this.size = size;
    }

    public abstract double getPrice();

    public abstract boolean isExtra();

    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    }
}