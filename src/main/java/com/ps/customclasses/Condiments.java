package com.ps.customclasses;

public class Condiments extends Topping {

    private boolean sideSauce;

    public Condiments(String name, double price, boolean sideSauce) {
        super(name, price);
        this.sideSauce = sideSauce;
    }

    @Override
    public double getPrice() {
        return sideSauce ? price + 0.50 : price;
    }
}