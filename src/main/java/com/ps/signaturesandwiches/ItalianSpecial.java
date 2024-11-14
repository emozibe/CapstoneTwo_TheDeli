package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.ArrayList;
import java.util.List;

public class ItalianSpecial extends Sandwich {

    public ItalianSpecial(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Italian Special", sandwichSize, breadType, isToasted, List.of(
                new Meat("Salami", sandwichSize, false),
                new Meat("Ham", sandwichSize, false),
                new Cheese("Provolone", sandwichSize, false),
                new Veggies("Lettuce", sandwichSize),
                new Veggies("Tomato", sandwichSize),
                new Condiments("Mayo", sandwichSize, false)
        ));
    }

    @Override
    public String getDescription() {
        return "An Italian Special sandwich with salami, pepperoni, provolone cheese, fresh lettuce, tomato, and a touch of mayonnaise.";
    }

    @Override
    public double calculatePrice() {
        return 0.0;
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