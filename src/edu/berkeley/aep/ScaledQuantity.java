package edu.berkeley.aep;

public class ScaledQuantity implements Bestable<ScaledQuantity> {
    protected final int size;
    protected final Unit unit;

    public ScaledQuantity(int size, Unit unit) {
        this.size = size;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof ScaledQuantity otherQuantity)) return false;
        if (this.unit.measurementType != otherQuantity.unit.measurementType) {
            throw new RuntimeException("Trying to compare to different types"); // Units belong to different measurement types, cannot be compared
        }
        return otherQuantity.unit.convertTo(this.unit, otherQuantity.size) == size;
    }

    @Override
    public boolean isBetterThan(ScaledQuantity other) {
        if (this.unit.measurementType != other.unit.measurementType) {
            throw new RuntimeException("Trying to compare to different types"); // Units belong to different measurement types, cannot be compared
        }
        return other.unit.convertTo(this.unit, other.size) < size;
    }

    @Override
    public int hashCode() {
        return unit.hashCode(size);
    }

    @Override
    public String toString() {
        return size + " " + unit;
    }
}
