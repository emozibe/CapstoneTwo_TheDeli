package com.ps.customclasses;

public abstract class Topping {

    protected String name;
    protected double price;

    public Topping(String name, double price) {
        this.name = name;
        this.price = price;
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