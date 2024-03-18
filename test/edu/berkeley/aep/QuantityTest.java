package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityTest {
    @Test
    public void twelveInchesShouldEqualOneFoot() {
        ArithmeticQuantity twelveInches = new ArithmeticQuantity(12, Unit.INCHES);
        ArithmeticQuantity oneFoot = new ArithmeticQuantity(1, Unit.FEET);
        assertEquals(twelveInches, oneFoot);
    }

    @Test
    public void threeFeetShouldEqualOneYard() {
        ArithmeticQuantity oneYard = new ArithmeticQuantity(1, Unit.YARDS);
        ArithmeticQuantity threeFeet = new ArithmeticQuantity(3, Unit.FEET);
        assertEquals(oneYard, threeFeet);
    }

    @Test
    public void oneMileShouldEqual1760Feet() {
        ArithmeticQuantity oneMile = new ArithmeticQuantity(1, Unit.MILES);
        ArithmeticQuantity oneMileInYards = new ArithmeticQuantity(1760, Unit.YARDS);
        assertEquals(oneMile, oneMileInYards);
    }

    @Test
    public void oneTablespoonShouldEqual3Teaspoons() {
        ArithmeticQuantity oneTablespoon = new ArithmeticQuantity(1, Unit.TABLESPOON);
        ArithmeticQuantity threeTeaspoons = new ArithmeticQuantity(3, Unit.TEASPOON);
        assertEquals(oneTablespoon, threeTeaspoons);
    }

    @Test
    public void oneCupShouldEqual16Tablespoons() {
        ArithmeticQuantity oneCup = new ArithmeticQuantity(1, Unit.CUP);
        ArithmeticQuantity sixteenTablespoons = new ArithmeticQuantity(16, Unit.TABLESPOON);
        assertEquals(oneCup, sixteenTablespoons);
    }

    @Test
    public void twoDifferentMeasurementTypesAreNotComparable() {
        ArithmeticQuantity oneMile = new ArithmeticQuantity(1, Unit.MILES);
        ArithmeticQuantity threeTeaspoons = new ArithmeticQuantity(3, Unit.TEASPOON);
        assertThrows(RuntimeException.class, () -> {
            oneMile.equals(threeTeaspoons);
        });
    }

    @Test
    public void twoTablespoonsAnd1OzEquals12Teaspoons() {
        ArithmeticQuantity twoTableSpoon = new ArithmeticQuantity(2, Unit.TABLESPOON);
        ArithmeticQuantity oneOz = new ArithmeticQuantity(1, Unit.OUNCE);
        ArithmeticQuantity twelveTeaspoons = new ArithmeticQuantity(12, Unit.TEASPOON);
        assertEquals(twoTableSpoon.add(oneOz), twelveTeaspoons);
    }

    @Test
    public void lengthAndVolumeCannotBeAdded() {
        ArithmeticQuantity twoTableSpoon = new ArithmeticQuantity(2, Unit.TABLESPOON);
        ArithmeticQuantity oneMile = new ArithmeticQuantity(1, Unit.MILES);
        assertThrows(IllegalArgumentException.class, () -> {
            twoTableSpoon.add(oneMile);
        });
    }

    @Test
    public void oneHundredCelsiusEquals212Fahrenheit() {
        ScaledQuantity oneHundredCelsius = new ScaledQuantity(100, Unit.CELSIUS);
        ScaledQuantity twoHundredAndTwelveFahrenheit = new ScaledQuantity(212, Unit.FAHRENHEIT);
        assertEquals(oneHundredCelsius, twoHundredAndTwelveFahrenheit);
    }

    @Test
    public void thirtyTwoFahrenheitEqualsZeroCelsius() {
        ScaledQuantity thirtyTwoFahrenheit = new ScaledQuantity(32, Unit.FAHRENHEIT);
        ScaledQuantity zeroCelsius = new ScaledQuantity(0, Unit.CELSIUS);
        assertEquals(thirtyTwoFahrenheit, zeroCelsius);
    }

    @Test
    public void oneOzIsBetterThan3Tsp() {
        ArithmeticQuantity oneOz = new ArithmeticQuantity(1, Unit.OUNCE);
        ArithmeticQuantity threeTsp = new ArithmeticQuantity(3, Unit.TEASPOON);
        assertTrue(oneOz.isBetterThan(threeTsp));
    }

    @Test
    public void oneHundredCIsBetterThan32F() {
        ScaledQuantity oneHundredC = new ScaledQuantity(100, Unit.CELSIUS);
        ScaledQuantity thirtyTwoF = new ScaledQuantity(32, Unit.FAHRENHEIT);
        assertTrue(oneHundredC.isBetterThan(thirtyTwoF));
    }
}