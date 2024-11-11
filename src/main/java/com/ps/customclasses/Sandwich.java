package com.ps.customclasses;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements Product {

    private SandwichSize sandwichSize;
    private BreadType breadType;
    private boolean isToasted;
    private List<Topping> toppings;

    public Sandwich(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.toppings = new ArrayList<>();
    }

    public void addTopping (Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping (Topping topping) {
        toppings.remove(topping);
    }

    @Override
    public double calculatePrice() {
        double basePrice = switch (sandwichSize) {
            case SMALL -> 4.99;
            case MEDIUM -> 6.99;
            case LARGE -> 8.99;
        };

        for (Topping topping : toppings) {
            basePrice += topping.getPrice();
        }

        return basePrice;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    } public void setSandwichSize(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public BreadType getBreadType() {
        return breadType;
    } public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public boolean getIsToasted() {
        return isToasted;
    } public void setIsToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Topping> getToppings() {
        return toppings;
    } public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }
}