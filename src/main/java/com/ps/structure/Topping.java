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

    public abstract Topping clone();

    public abstract String toString();

    public boolean isSideCondiment() {
        return false;
    }

    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    }

    public SandwichSize getSize() {
        return size;
    } public void setSize(SandwichSize size) {
        this.size = size;
    }
}