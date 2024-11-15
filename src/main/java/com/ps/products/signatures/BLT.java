package com.ps.products.signatures;

import com.ps.enums.*;
import com.ps.products.*;
import com.ps.toppings.*;

import java.util.ArrayList;
import java.util.List;

public class BLT extends Sandwich {

    public BLT(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("BLT", sandwichSize, breadType, isToasted, List.of(
                new Meat(MeatType.BACON, sandwichSize, false),
                new Veggies(VeggieType.LETTUCE, sandwichSize),
                new Veggies(VeggieType.TOMATO, sandwichSize),
                new Condiments(CondimentType.MAYO, sandwichSize)
        ));
    }

    @Override
    public String getDescription() {
        return "A classic BLT sandwich with crispy bacon, fresh lettuce, tomato, and a touch of mayo.";
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