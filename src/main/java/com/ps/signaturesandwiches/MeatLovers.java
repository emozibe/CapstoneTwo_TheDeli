package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.List;

public class MeatLovers extends Sandwich {

    public MeatLovers(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Meat Lover's", sandwichSize, breadType, isToasted, List.of(
                new Meat("Bacon", sandwichSize, false),
                new Meat("Ham", sandwichSize, false),
                new Meat("Roast Beef", sandwichSize, false),
                new Cheese("Swiss", sandwichSize, false)
        ));
    }

    @Override
    public String getDescription() {
        return "A hearty Meat Lover's sandwich loaded with bacon, ham, roast beef, and Swiss cheese.";
    }

    @Override
    public double calculatePrice() {
        return 0.0;
    }
}