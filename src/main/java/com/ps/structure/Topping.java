package com.ps.structure;

import com.ps.enums.SandwichSize;

public abstract class Topping {

    protected String name;
    protected double price;
    protected SandwichSize size;

    public Topping(String name, double price, SandwichSize size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public abstract double getPrice();

    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    }

    public double getPriceBase() {
        return price;
    } public void setPrice(double price) {
        this.price = price;
    }
}