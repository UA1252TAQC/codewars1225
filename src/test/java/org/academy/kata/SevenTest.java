package org.academy.kata;

import org.academy.kata.dataprovider.SevenDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.*;

public class SevenTest extends SevenDataProvider {
    @BeforeClass()
    public void beforeClass() {
        Locale.setDefault(Locale.US);
    }

    @Test(dataProvider = "data-NewAvg")
    public void testNewAvg(Seven seven, double[] arr, double navg, long expected) {
        long actual = seven.newAvg(arr, navg);
        assertEquals(actual, expected);
    }

    @Test
    public void testSeriesSum() {
    }
}