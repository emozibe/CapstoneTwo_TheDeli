package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.enums.*;
import com.ps.structure.*;
import java.util.ArrayList;
import java.util.List;

public class ItalianSpecial extends Sandwich {

    public ItalianSpecial(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Italian Special", sandwichSize, breadType, isToasted, List.of(
                new Meat(MeatType.SALAMI, sandwichSize, false),
                new Meat(MeatType.HAM, sandwichSize, false),
                new Cheese(CheeseType.PROVOLONE, sandwichSize, false),
                new Veggies(VeggieType.LETTUCE, sandwichSize),
                new Veggies(VeggieType.TOMATO, sandwichSize),
                new Condiments(CondimentType.MAYO, sandwichSize, false)
        ));
    }

    @Override
    public String getDescription() {
        return "An Italian Special sandwich with salami, ham, provolone cheese, fresh lettuce, tomato, and a touch of mayonnaise.";
    }

    @Override
    public Sandwich clone() {
        ItalianSpecial clonedSandwich = new ItalianSpecial(this.sandwichSize, this.breadType, this.isToasted);

        List<Topping> clonedToppings = new ArrayList<>();
        for (Topping topping : this.getCurrentToppings()) {
            clonedToppings.add(topping.clone());
        }

        clonedSandwich.setCurrentToppings(clonedToppings);
        return clonedSandwich;
    }
}