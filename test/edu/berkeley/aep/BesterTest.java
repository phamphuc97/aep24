package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BesterTest {
    @Test
    public void bestLength() {
        ArithmeticQuantity oneMile = new ArithmeticQuantity(1, Unit.MILES);
        ArithmeticQuantity oneYard = new ArithmeticQuantity(1, Unit.YARDS);
        ArithmeticQuantity threeFeet = new ArithmeticQuantity(3, Unit.FEET);
        Bester list = new Bester(oneMile, oneYard, threeFeet);
        assertEquals(oneMile, list.best());
    }

    @Test
    public void oneIsTheBestProbability() {
        Chance one = new Chance(1);
        Chance half = new Chance(0.5);
        Chance quarter = new Chance(0.25);
        Bester bestProbability = new Bester(one, half, quarter);
        assertEquals(one, bestProbability.best());
    }

    @Test(expected = RuntimeException.class)
    public void emptyListResultsInRuntimeException() {
        Bester nullList = new Bester();
        /*assertThrows(RuntimeException.class, () -> {
            nullList.best();
        });*/
        nullList.best();
    }
}
