package com.ps.signaturesandwiches;

import com.ps.enums.BreadType;
import com.ps.enums.SandwichSize;
import com.ps.structure.*;
import java.util.List;

public class MeatLovers extends Sandwich {

    public MeatLovers(SandwichSize sandwichSize, BreadType breadType, boolean isToasted) {
        super("Meat Lover's", sandwichSize, breadType, isToasted, List.of(
                new Meat("Bacon", 1.0, false),
                new Meat("Ham", 1.0, false),
                new Meat("Roast Beef", 1.0, false),
                new Cheese("Swiss", 1.0, false)
        ));
    }

    @Override
    public String getDescription() {
        return "A hearty Meat Lover's sandwich loaded with bacon, ham, roast beef, and Swiss cheese.";
    }
}