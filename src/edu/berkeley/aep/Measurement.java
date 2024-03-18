package edu.berkeley.aep;

public class Measurement {
    final double unit;

    private Measurement(double unit) {
        this.unit = unit;
    }

    public static Measurement createYard(double unit) {
        return new Measurement(unit);
    }

    public static Measurement createFeet(double unit) {
        return new Measurement(unit);
    }

    public static Measurement createInch(double unit) {
        return new Measurement(unit);
    }

    public static Measurement createMile(double unit) {
        return new Measurement(unit);
    }

    // Convert yard to feet by the standard 1 yd = 3 ft
    public Measurement yardToFeet() {
        return createFeet(unit * 3);
    }

    public Measurement feetToYard() {
        return createYard(unit / 3);
    }

    public Measurement inchToFeet() {
        return createFeet(unit / 12);
    }

    public Measurement feetToInch() {
        return createInch(unit * 12);
    }

    public Measurement yardToMile() {
        return createMile(unit / 1760);
    }

    public Measurement mileToYard() {
        return createYard(unit * 1760);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Measurement)) return false;
        return Double.compare(((Measurement) other).unit, unit) == 0;
    }

    // Always override hashCode if overriding equals
    @Override
    public int hashCode() {
        return Double.hashCode(unit);
    }
}
