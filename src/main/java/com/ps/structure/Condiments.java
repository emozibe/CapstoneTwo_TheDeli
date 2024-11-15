package com.ps.structure;

import com.ps.enums.SandwichSize;
import com.ps.enums.CondimentType;

public class Condiments extends Topping {
    private final CondimentType type;
    private final boolean onSide;

    public Condiments(CondimentType type, SandwichSize size, boolean onSide) {
        super(type.toString(), size);
        this.type = type;
        this.onSide = onSide;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public boolean isExtra() {
        return onSide;
    }

    @Override
    public Topping clone() {
        return new Condiments(this.type, this.size, this.onSide);
    }

    @Override
    public boolean isSideCondiment() {
        return onSide;
    }

    @Override
    public String toString() {
        return String.format("%s%s", type.toString(), isSideCondiment() ? " (On the Side)" : "");
    }


    public CondimentType getType() {
        return type;
    }
}