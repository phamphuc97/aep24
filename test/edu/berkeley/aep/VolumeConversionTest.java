package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.*;

public class VolumeConversionTest {
    @Test
    public void oneTablespoonIs3Teaspoons() {
        var oneTableSpoon = Volume.inTablespoon(1);
        assertEquals(Volume.inTeaspoon(3), oneTableSpoon);
    }

    @Test
    public void fourOzAre8Tablespoons() {
        var fourOz = Volume.inOz(4);
        assertEquals(Volume.inTablespoon(8), fourOz);
    }

    @Test
    public void halfACupIs4Oz() {
        var halfACup = Volume.inCup(1.0 / 2.0);
        assertEquals(Volume.inOz(4), halfACup);
    }
}
