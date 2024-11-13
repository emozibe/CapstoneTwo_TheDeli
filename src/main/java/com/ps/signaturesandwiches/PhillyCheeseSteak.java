package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.List;

public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteak(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Philly Cheese Steak", sandwichSize, breadType, isToasted, List.of(
                new Meat("Steak", sandwichSize, false),
                new Cheese("American", sandwichSize, true),
                new Veggies("Peppers", sandwichSize),
                new Condiments("Mayo", sandwichSize, false)
        ));
    }

    @Override
    public String getDescription() {
        return "A classic Philly Cheese Steak with tender steak, American cheese, fresh peppers, and creamy mayo.";
    }

    @Override
    public double calculatePrice() {
        return 0.0;
    }
}
