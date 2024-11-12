package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.List;

public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteak(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Philly Cheese Steak", sandwichSize, breadType, isToasted, List.of(
                new Meat("Steak", 1.0, false),
                new Cheese("American", 1.0, true),
                new Veggies("Peppers", 0.5),
                new Condiments("Mayo", 0.5, false)
        ));
    }

    @Override
    public String getDescription() {
        return "A classic Philly Cheese Steak with tender steak, American cheese, fresh peppers, and creamy mayo.";
    }
}
