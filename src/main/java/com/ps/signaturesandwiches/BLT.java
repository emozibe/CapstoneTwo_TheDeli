package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.List;

public class BLT extends Sandwich {

    public BLT(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("BLT", sandwichSize, breadType, isToasted, List.of(
                new Meat("Bacon", 1.0, false),
                new Veggies("Lettuce", 0.0),
                new Veggies("Tomato", 0.0)
        ));
    }

    @Override
    public String getDescription() {
        return "A classic BLT sandwich with crispy bacon, fresh lettuce, and tomato.";
    }
}