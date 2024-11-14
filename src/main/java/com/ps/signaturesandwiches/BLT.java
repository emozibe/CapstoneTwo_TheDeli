package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.ArrayList;
import java.util.List;

public class BLT extends Sandwich {

    public BLT(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("BLT", sandwichSize, breadType, isToasted, List.of(
                new Meat("Bacon", sandwichSize, false),
                new Veggies("Lettuce", sandwichSize),
                new Veggies("Tomato", sandwichSize)
        ));
    }

    @Override
    public String getDescription() {
        return "A classic BLT sandwich with crispy bacon, fresh lettuce, and tomato.";
    }

    @Override
    public double calculatePrice() {
        return 0.0;
    }

    @Override
    public Sandwich clone() {
        BLT clonedSandwich = new BLT(this.sandwichSize, this.breadType, this.isToasted);

        List<Topping> clonedToppings = new ArrayList<>();
        for (Topping topping : this.getCurrentToppings()) {
            clonedToppings.add(topping.clone());
        }

        clonedSandwich.setCurrentToppings(clonedToppings);
        return clonedSandwich;
    }
}