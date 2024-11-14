package com.ps.structure;

import com.ps.enums.SandwichSize;
import com.ps.enums.CondimentType;

public class Condiments extends Topping {
    private final CondimentType type;
    private final boolean extraSauce;

    public Condiments(CondimentType type, SandwichSize size, boolean extraSauce) {
        super(type.name(), size); // Use enum name as display name
        this.type = type;
        this.extraSauce = extraSauce;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public boolean isExtra() {
        return extraSauce;
    }

    @Override
    public Topping clone() {
        return new Condiments(this.type, this.size, this.extraSauce);
    }

    public CondimentType getType() {
        return type;
    }
}