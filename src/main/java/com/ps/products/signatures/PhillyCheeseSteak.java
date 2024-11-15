package com.ps.products.signatures;

import com.ps.enums.*;
import com.ps.products.*;
import com.ps.toppings.*;

import java.util.ArrayList;
import java.util.List;

public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteak(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Philly Cheese Steak", sandwichSize, breadType, isToasted, List.of(
                new Meat(MeatType.STEAK, sandwichSize, false),
                new Cheese(CheeseType.AMERICAN, sandwichSize, true),
                new Veggies(VeggieType.PEPPERS, sandwichSize),
                new Veggies(VeggieType.ONION, sandwichSize),
                new Condiments(CondimentType.MAYO, sandwichSize)
        ));
    }

    @Override
    public String getDescription() {
        return "A classic Philly Cheese Steak with tender steak, American cheese, fresh peppers, onions, and creamy mayo.";
    }

    @Override
    public Sandwich clone() {
        PhillyCheeseSteak clonedSandwich = new PhillyCheeseSteak(this.sandwichSize, this.breadType, this.isToasted);

        List<Topping> clonedToppings = new ArrayList<>();
        for (Topping topping : this.getCurrentToppings()) {
            clonedToppings.add(topping.clone());
        }

        clonedSandwich.setCurrentToppings(clonedToppings);
        return clonedSandwich;
    }
}
