package com.ps.products.signatures;

import com.ps.enums.*;
import com.ps.products.*;
import com.ps.toppings.*;

import java.util.ArrayList;
import java.util.List;

public class VeggieDelight extends Sandwich {

    public VeggieDelight(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Veggie Delight", sandwichSize, breadType, isToasted, List.of(
                new Veggies(VeggieType.LETTUCE, sandwichSize),
                new Veggies(VeggieType.TOMATO, sandwichSize),
                new Veggies(VeggieType.CUCUMBER, sandwichSize),
                new Veggies(VeggieType.PEPPERS, sandwichSize),
                new Veggies(VeggieType.ONION, sandwichSize),
                new Cheese(CheeseType.CHEDDAR, sandwichSize, false),
                new Condiments(CondimentType.VINAIGRETTE, sandwichSize)
        ));
    }

    @Override
    public String getDescription() {
        return "A fresh Veggie Delight sandwich packed with lettuce, tomato, cucumber, peppers, onion, cheddar cheese, and vinaigrette.";
    }

    @Override
    public Sandwich clone() {
        VeggieDelight clonedSandwich = new VeggieDelight(this.sandwichSize, this.breadType, this.isToasted);

        List<Topping> clonedToppings = new ArrayList<>();
        for (Topping topping : this.getCurrentToppings()) {
            clonedToppings.add(topping.clone());
        }

        clonedSandwich.setCurrentToppings(clonedToppings);
        return clonedSandwich;
    }
}