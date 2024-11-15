package com.ps.structure;

import com.ps.enums.*;

public class Condiments extends Topping {
    private final CondimentType type;
    private final SideCondimentType sideType;
    private final boolean onSide;

    public Condiments(CondimentType type, SandwichSize size) {
        super(type.toString(), size);
        this.type = type;
        this.sideType = null;
        this.onSide = false;
    }

    public Condiments(SideCondimentType sideType, SandwichSize size, boolean onSide) {
        super(sideType.toString(), size);
        this.type = null;
        this.sideType = sideType;
        this.onSide = onSide;
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
        if (sideType != null) {
            return new Condiments(this.sideType, this.size, this.onSide);
        }
        return new Condiments(this.type, this.size);
    }

    @Override
    public boolean isSideCondiment() {
        return onSide;
    }

    @Override
    public String toString() {
        String sideLabel = isSideCondiment() ? " (On the Side)" : "";
        return String.format("%s%s", type != null ? type.toString() : sideType.toString(), sideLabel);
    }

    public CondimentType getType() {
        return type;
    }

    public SideCondimentType getSideType() {
        return sideType;
    }
}