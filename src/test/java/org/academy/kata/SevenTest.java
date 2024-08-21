package org.academy.kata;

import org.academy.kata.dataproviders.SevenDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;


public class SevenTest extends SevenDataProvider {
    @BeforeClass()
    public void beforeClass() {
        Locale.setDefault(Locale.US);
    }

    @Test(dataProvider = "data-NewAvg")
    public void testNewAvg(Seven seven, Class<? extends Throwable> expectedException, double[] arr, double navg, long expected) {
        if (expectedException != null) {
            assertThrows(expectedException, () -> seven.newAvg(arr, navg));
        } else {
            long actual = seven.newAvg(arr, navg);
            assertEquals(actual, expected);
        }
    }

    @Test(dataProvider = "data-SeriesSum")
    public void testSeriesSum(Seven seven, int n, String expected) {
        String actual = seven.seriesSum(n);
        assertEquals(actual, expected);
    }

}