package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.List;

public class BLT extends Sandwich {

    public BLT(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("BLT", sandwichSize, breadType, isToasted, List.of(
                new Meat("Bacon", sandwichSize, false),
                new Veggies("Lettuce", sandwichSize),
                new Veggies("Tomato", sandwichSize)
        ));
    }

    @Override
    public String getDescription() {
        return "A classic BLT sandwich with crispy bacon, fresh lettuce, and tomato.";
    }

    @Override
    public double calculatePrice() {
        return 0.0;
    }

    @Override
    public Sandwich cloneWithSizeAndBread(SandwichSize size, BreadType breadType) {
        return new BLT(size, breadType, this.isToasted());
    }
}