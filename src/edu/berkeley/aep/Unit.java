package edu.berkeley.aep;

// Understands how to convert between different measurement scales
public enum Unit {
    // Length units
    FEET(MeasurementType.LENGTH, 12),
    INCHES(MeasurementType.LENGTH, 1),
    YARDS(MeasurementType.LENGTH, 36),
    MILES(MeasurementType.LENGTH, 1760 * 36),

    // Volume units
    TEASPOON(MeasurementType.VOLUME, 1),
    TABLESPOON(MeasurementType.VOLUME, 3),
    OUNCE(MeasurementType.VOLUME, 6),
    CUP(MeasurementType.VOLUME, 48),

    // Temperature units
    FAHRENHEIT(MeasurementType.TEMPERATURE, 1),
    CELSIUS(MeasurementType.TEMPERATURE, 1);

    protected final MeasurementType measurementType;
    private final int inBaseUnits;

    Unit(MeasurementType measurementType, int inBaseUnits) {
        this.measurementType = measurementType;
        this.inBaseUnits = inBaseUnits;
    }

    public int convertTo(Unit unit, int size) {
        if (this.measurementType != unit.measurementType) {
            throw new IllegalArgumentException("Cannot convert between different measurement types");
        }
        // Temperature conversion
        if (this.measurementType == MeasurementType.TEMPERATURE) {
            if (this == FAHRENHEIT && unit == CELSIUS) {
                return (size - 32) * 5 / 9;
            } else if (this == CELSIUS && unit == FAHRENHEIT) {
                return (size * 9 / 5) + 32;
            }
        }
        return size * inBaseUnits / unit.inBaseUnits;
    }

    public int hashCode(int size) {
        return Integer.hashCode(inBaseUnits * size);
    }
}

enum MeasurementType {
    LENGTH,
    VOLUME,
    TEMPERATURE
}
