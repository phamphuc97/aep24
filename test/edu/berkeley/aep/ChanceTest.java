package edu.berkeley.aep;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ChanceTest {
    @Test
    public void twoCoinTossChancesShouldBeEqualToEachOther() {
        var coinToss = new Chance(0.5);
        var anotherCoinToss = new Chance(0.5);
        assertEquals(coinToss, anotherCoinToss);
    }

    @Test
    public void testIfHashCodeIsWorking() {
        Map<String, Chance> map = new HashMap<String, Chance>();
        map.put("Coin Toss", new Chance(0.5));
        assertEquals(map.get("Coin Toss"), new Chance(0.5));
    }

    @Test
    public void testTheProbabilityOfARiggedCoinTurningHead() {
        var riggedCoinWithLessProbabilityTurningTail = new Chance(1.0 / 4.0);
        assertEquals(new Chance(3.0 / 4.0), riggedCoinWithLessProbabilityTurningTail.not());
    }

    @Test
    public void testTheProbabilityOfTwoEventsHappenTogether() {
        var eventA = new Chance(0.4);
        var eventB = new Chance(0.6);
        assertEquals(new Chance(0.24), eventA.and(eventB));
    }

    @Test
    public void testTheProbabilityThatEitherOneOfTheEventsHappens() {
        var eventA = new Chance(0.3);
        var eventB = new Chance(0.5);
        assertEquals(new Chance(0.65), eventA.or(eventB));
    }
}
