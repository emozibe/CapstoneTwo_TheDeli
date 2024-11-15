package com.ps.products;

import com.ps.enums.*;
import com.ps.toppings.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Sandwich implements Product {

    protected String name;
    protected SandwichSize sandwichSize;
    protected BreadType breadType;
    protected boolean isToasted;
    protected List<Topping> defaultToppings;
    protected List<Topping> currentToppings;
    protected List<Topping> addedToppings;
    protected List<Topping> removedToppings;

    public Sandwich(String name, SandwichSize sandwichSize, BreadType breadType, boolean isToasted, List<Topping> defaultToppings) {
        this.name = name;
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.defaultToppings = new ArrayList<>(defaultToppings);
        this.currentToppings = new ArrayList<>(defaultToppings);
        this.addedToppings = new ArrayList<>();
        this.removedToppings = new ArrayList<>();
    }

    public abstract String getDescription();

    public abstract Sandwich clone();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" - ")
                .append("Size: ").append(getSandwichSize())
                .append(", Bread: ").append(getBreadType())
                .append(", Toasted: ").append(isToasted() ? "Yes" : "No")
                .append(", Toppings: ");
        for (Topping topping : getCurrentToppings()) {
            sb.append("\n    - ").append(topping);
        }
        sb.append("\n  Sandwich Total: $").append(String.format("%.2f", calculatePrice()));
        return sb.toString();
    }

    public void addTopping(Topping topping) {
        if (!currentToppings.contains(topping) && !addedToppings.contains(topping)) {
            currentToppings.add(topping);
            addedToppings.add(topping);
            removedToppings.remove(topping);

            if (!(topping instanceof Condiments) || !topping.isSideCondiment()) {
                System.out.println("\n" + topping + " added to your sandwich!");
            }
        } else {
            if (!(topping instanceof Condiments) || !topping.isSideCondiment()) {
                System.out.println("\nThe topping " + topping + " is already on your sandwich!");
            }
        }
    }

    public void removeTopping(Topping topping) {
        if (currentToppings.contains(topping)) {
            currentToppings.remove(topping);
            removedToppings.add(topping);
            addedToppings.remove(topping);

            System.out.println("\n" + topping + " removed from your sandwich!");
        } else {
            System.out.println("\nThe topping " + topping + " is not on your sandwich!");
        }
    }

    public double calculatePrice() {
        double totalPrice = getBasePrice();

        for (Topping topping : currentToppings) {
            if (isChargeableTopping(topping)) {
                totalPrice += topping.getPrice();
            }
        }

        return Math.round(totalPrice * 100.0) / 100.0;
    }

    public double getBasePrice() {
        return switch (this.sandwichSize) {
            case SMALL -> 5.50;
            case MEDIUM -> 7.00;
            case LARGE -> 8.50;
        };
    }

    private boolean isChargeableTopping(Topping topping) {
        return topping instanceof Meat || topping instanceof Cheese;
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

    public boolean isToasted() {
        return this.isToasted;
    }

    public List<Topping> getCurrentToppings() {
        return currentToppings;
    } public void setCurrentToppings(List<Topping> toppings) {
        currentToppings = new ArrayList<>(toppings);
    }

    public String getName() {
        return name;
    } public void setName(String name) {
        this.name = name;
    }

    public boolean isCustom() {
        return this instanceof CustomSandwich;
    }
}