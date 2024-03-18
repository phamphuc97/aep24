package edu.berkeley.aep;

// Understands how to compare measurements in a given unit
public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(int size, Unit unit) {
        super(size, unit);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        if (this.unit.measurementType != other.unit.measurementType) {
            throw new IllegalArgumentException("Cannot add different measurement types");
        } else {
            return new ArithmeticQuantity(this.size + other.unit.convertTo(this.unit, other.size), this.unit);
        }
    }
}