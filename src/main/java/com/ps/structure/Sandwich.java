package com.ps.structure;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
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

    public void addTopping(Topping topping) {
        if (!currentToppings.contains(topping)) {
            currentToppings.add(topping);
            System.out.println(topping.getName() + " added to your sandwich!");
        } else {
            System.out.println("The topping " + topping.getName() + " is already on your sandwich.");
        }
    }

    public void removeTopping(Topping topping) {
        if (currentToppings.contains(topping)) {
            currentToppings.remove(topping);

            if (defaultToppings.contains(topping) && !removedToppings.contains(topping)) {
                removedToppings.add(topping);
            }

            addedToppings.remove(topping);

            System.out.println(topping.getName() + " has been removed from your sandwich.");
        } else {
            System.out.println("The topping " + topping.getName() + " is not on your sandwich.");
        }
    }

    private boolean containsTopping(Topping topping) {
        return currentToppings.stream().anyMatch(t -> t.getName().equals(topping.getName()));
    }

    public double getBasePrice() {
        return switch (this.sandwichSize) {
            case SMALL -> 5.50;
            case MEDIUM -> 7.00;
            case LARGE -> 8.50;
        };
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
}