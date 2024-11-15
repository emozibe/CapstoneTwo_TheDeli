package com.ps.products;

import com.ps.enums.*;
import com.ps.toppings.*;

import java.util.ArrayList;

public class CustomSandwich extends Sandwich {

    public CustomSandwich(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Build Your Own", sandwichSize, breadType, isToasted, new ArrayList<>());
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Custom Sandwich with ").append(breadType).append(" bread, ")
                .append(sandwichSize).append(" size");

        if (isToasted) {
            description.append(", toasted");
        }

        description.append(", with toppings: ");
        if (currentToppings.isEmpty()) {
            description.append("No toppings");
        } else {
            for (Topping topping : currentToppings) {
                description.append(topping.getName()).append(", ");
            }
            description.setLength(description.length() - 2);
        }
        return description.toString();
    }

    @Override
    public CustomSandwich clone() {
        CustomSandwich clonedSandwich = new CustomSandwich(this.sandwichSize, this.breadType, this.isToasted);
        clonedSandwich.setCurrentToppings(new ArrayList<>(this.getCurrentToppings()));
        return clonedSandwich;
    }
}