package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.List;

public class ItalianSpecial extends Sandwich {

    public ItalianSpecial(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Italian Special", sandwichSize, breadType, isToasted, List.of(
                new Meat("Salami", 1.0, false),
                new Meat("Ham", 1.0, false),
                new Cheese("Provolone", 1.0, false),
                new Veggies("Lettuce", 0.5),
                new Veggies("Tomato", 0.5),
                new Condiments("Mayo", 0.0, false)
        ));
    }

    @Override
    public String getDescription() {
        return "An Italian Special sandwich with salami, pepperoni, provolone cheese, fresh lettuce, tomato, and a touch of mayonnaise.";
    }
}