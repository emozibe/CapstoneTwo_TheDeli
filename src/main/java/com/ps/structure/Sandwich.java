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

    public Sandwich(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        this("Build Your Own", sandwichSize, breadType, isToasted, new ArrayList<>());
    }

    public abstract String getDescription();

    public void addTopping(Topping topping) {
        if (!currentToppings.contains(topping)) {
            currentToppings.add(topping);
            if (!defaultToppings.contains(topping)) {
                addedToppings.add(topping);
            }
            removedToppings.remove(topping);
        }
    }

    public void removeTopping(Topping topping) {
        if (currentToppings.contains(topping)) {
            currentToppings.remove(topping);
            if (defaultToppings.contains(topping)) {
                removedToppings.add(topping);
            }
            addedToppings.remove(topping);
        }
    }

    public void setCurrentToppings(List<Topping> newToppings) {
        addedToppings.clear();
        removedToppings.clear();

        currentToppings = new ArrayList<>(newToppings);

        for (Topping topping : currentToppings) {
            if (!defaultToppings.contains(topping)) {
                addedToppings.add(topping);
            }
        }
        for (Topping topping : defaultToppings) {
            if (!currentToppings.contains(topping)) {
                removedToppings.add(topping);
            }
        }
    }

    @Override
    public double calculatePrice() {
        double basePrice = switch (sandwichSize) {
            case SMALL -> 4.99;
            case MEDIUM -> 6.99;
            case LARGE -> 8.99;
        };

        for (Topping topping : currentToppings) {
            basePrice += topping.getPrice();
        }

        return basePrice;
    }

    @Override
    public String toString() {
        String summary = "Sandwich: " + name
                + ", Size: " + sandwichSize
                + ", Bread: " + breadType
                + ", Toasted: " + (isToasted ? "Yes" : "No")
                + ", Toppings: ";

        if (currentToppings.isEmpty()) {
            summary += "No toppings";
        } else {
            String toppings = String.join(", ", currentToppings.stream().map(Topping::getName).toList());
            summary += toppings;
        }

        if (!addedToppings.isEmpty()) {
            String additions = String.join(", ", addedToppings.stream().map(Topping::getName).toList());
            summary += "\nAdded Toppings: " + additions;
        }

        if (!removedToppings.isEmpty()) {
            String removals = String.join(", ", removedToppings.stream().map(Topping::getName).toList());
            summary += "\nRemoved Toppings: " + removals;
        }

        return summary;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public boolean getIsToasted() {
        return isToasted;
    }

    public void setIsToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Topping> getCurrentToppings() {
        return currentToppings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}