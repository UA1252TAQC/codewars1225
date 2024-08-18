package org.academy.kata;

import org.academy.kata.dataprovider.SixDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SixTest extends SixDataProvider {

    @Test(dataProvider = "data-findNb")
    public void testFindNb(Six six, long input, long expected) {
        long actual = six.findNb(input);
        assertEquals(actual, expected);
    }

    @Test
    public void testBalance() {
    }

    @Test
    public void testF() {
    }

    @Test
    public void testMean() {
    }

    @Test
    public void testVariance() {
    }

    @Test
    public void testNbaCup() {
    }

    @Test
    public void testStockSummary() {
    }
}