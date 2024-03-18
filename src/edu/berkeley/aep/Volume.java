package edu.berkeley.aep;

public class Volume {
    private final double quantity;
    // private final String unit;

    private Volume(double quantity) {
        this.quantity = quantity;
    }

    public static Volume inTablespoon(double quantity) {
        return new Volume(quantity * 3);
    }

    public static Volume inTeaspoon(double quantity) {
        return new Volume(quantity);
    }

    public static Volume inOz(double quantity) {
        return new Volume(quantity * 6);
    }

    public static Volume inCup(double quantity) {
        return new Volume(quantity * 48);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Volume)) return false;
        return Double.compare(((Volume) other).quantity, quantity) == 0;
    }

    // Always override hashCode if overriding equals
    @Override
    public int hashCode() {
        return Double.hashCode(quantity);
    }
}
