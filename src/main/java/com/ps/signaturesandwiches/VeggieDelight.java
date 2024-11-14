package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.ArrayList;
import java.util.List;

public class VeggieDelight extends Sandwich {

    public VeggieDelight(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Veggie Delight", sandwichSize, breadType, isToasted, List.of(
                new Veggies("Lettuce", sandwichSize),
                new Veggies("Tomato", sandwichSize),
                new Veggies("Cucumber", sandwichSize),
                new Veggies("Peppers", sandwichSize),
                new Veggies("Onion", sandwichSize),
                new Cheese("Cheddar", sandwichSize, false)
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