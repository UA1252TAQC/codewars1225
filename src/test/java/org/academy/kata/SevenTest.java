package org.academy.kata;

import org.academy.kata.dataprovider.SevenDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SevenTest extends SevenDataProvider {

    @Test(dataProvider = "data-NewAvg")
    public void testNewAvg(Seven seven, double[] arr, double navg, long expected) {
        long  actual = seven.newAvg(arr, navg);
        assertEquals(actual, expected);
    }

    @Test
    public void testSeriesSum() {
    }
}