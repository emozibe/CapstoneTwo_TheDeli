package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.enums.*;
import com.ps.structure.*;
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
                new Cheese(CheeseType.CHEDDAR, sandwichSize, false)
        ));
    }

    @Override
    public String getDescription() {
        return "A fresh Veggie Delight sandwich packed with lettuce, tomato, cucumber, peppers, onion, and cheddar cheese.";
    }

    @Override
    public double calculatePrice() {
        return 0.0;
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