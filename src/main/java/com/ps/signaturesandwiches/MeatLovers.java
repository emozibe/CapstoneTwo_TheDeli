package com.ps.signaturesandwiches;

import com.ps.enums.*;
import com.ps.structure.*;
import java.util.ArrayList;
import java.util.List;

public class MeatLovers extends Sandwich {

    public MeatLovers(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Meat Lover's", sandwichSize, breadType, isToasted, List.of(
                new Meat(MeatType.BACON, sandwichSize, false),
                new Meat(MeatType.HAM, sandwichSize, false),
                new Meat(MeatType.ROAST_BEEF, sandwichSize, false),
                new Meat(MeatType.SALAMI, sandwichSize, false),
                new Cheese(CheeseType.SWISS, sandwichSize, false)
        ));
    }

    @Override
    public String getDescription() {
        return "A hearty Meat Lover's sandwich loaded with bacon, ham, roast beef, salami, and Swiss cheese.";
    }

    @Override
    public Sandwich clone() {
        MeatLovers clonedSandwich = new MeatLovers(this.sandwichSize, this.breadType, this.isToasted);

        List<Topping> clonedToppings = new ArrayList<>();
        for (Topping topping : this.getCurrentToppings()) {
            clonedToppings.add(topping.clone());
        }

        clonedSandwich.setCurrentToppings(clonedToppings);
        return clonedSandwich;
    }
}