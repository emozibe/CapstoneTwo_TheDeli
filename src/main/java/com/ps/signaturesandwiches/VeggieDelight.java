package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.List;

public class VeggieDelight extends Sandwich {

    public VeggieDelight(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Veggie Delight", sandwichSize, breadType, isToasted, List.of(
                new Veggies("Lettuce", 0.0),
                new Veggies("Tomato", 0.0),
                new Veggies("Cucumber", 0.0),
                new Veggies("Peppers", 0.0),
                new Veggies("Onion", 0.0),
                new Cheese("Cheddar", 1.0, false)
        ));
    }

    @Override
    public String getDescription() {
        return "A fresh Veggie Delight sandwich packed with lettuce, tomato, cucumber, peppers, onion, and cheddar cheese.";
    }
}