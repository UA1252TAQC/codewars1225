package org.academy.kata;

import org.academy.kata.dataprovider.SixDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.*;

public class SixTest extends SixDataProvider {
    @BeforeClass()
    public void beforeClass() {
        Locale.setDefault(Locale.US);
    }

    @Test(dataProvider = "data-findNb")
    public void testFindNb(Six six, long input, long expected) {
        long actual = six.findNb(input);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-balance")
    public void testBalance(Six six, String book, String expected) {
        String actual = six.balance(book);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-f")
    public void testF(Six six, double input, double expected) {
        double actual = six.f(input);
        assertEquals(actual, expected, 1e-9);
    }

    @Test(dataProvider = "data-mean")
    public void testMean(Six six, String town, String strng, double expected) {
        double actual = six.mean(town, strng);
        assertEquals(actual, expected, 1e-2);
    }

    @Test(dataProvider = "data-variance")
    public void testVariance(Six six, String town, String strng, double expected) {
        double actual = six.variance(town, strng);
        assertEquals(expected, actual, 1e-2);
    }

    @Test(dataProvider = "data-nbaCup")
    public void testNbaCup(Six six, String resultSheet, String toFind, String expected) {
        String actual = six.nbaCup(resultSheet, toFind);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-stockSummary")
    public void testStockSummary(Six six, String[] l, String[] m, String expected) {
        String actual = six.stockSummary(l, m);
        assertEquals(actual, expected);
    }
}
