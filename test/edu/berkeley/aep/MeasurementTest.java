package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.*;

public class MeasurementTest {
    @Test
    public void nineYardsShouldEqual27Feet() {
        var nineYard = Measurement.createYard(9);
        assertEquals(Measurement.createFeet(27), nineYard.yardToFeet());
    }

    @Test
    public void twentyOneFeetShouldEqual7Yards() {
        var twentyOneFeet = Measurement.createFeet(21);
        assertEquals(Measurement.createYard(7), twentyOneFeet.feetToYard());
    }

    @Test
    public void twentyFourInchesShouldEqual2Feet() {
        var twentyFourInches = Measurement.createInch(24);
        assertEquals(Measurement.createFeet(2), twentyFourInches.inchToFeet());
    }

    @Test
    public void fiveMilesShouldEqual8800Yards() {
        var fiveMiles = Measurement.createMile(5);
        assertEquals(Measurement.createYard(8800), fiveMiles.mileToYard());
    }
}
