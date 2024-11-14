package com.ps.structure;

import com.ps.enums.SandwichSize;
import com.ps.enums.VeggieType;

public class Veggies extends Topping {
    private final VeggieType type;

    public Veggies(VeggieType type, SandwichSize size) {
        super(type.name(), size); // Use enum name as display name
        this.type = type;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public boolean isExtra() {
        return false;
    }

    @Override
    public Topping clone() {
        return new Veggies(this.type, this.size);
    }

    public VeggieType getType() {
        return type;
    }
}