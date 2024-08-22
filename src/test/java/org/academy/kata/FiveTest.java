package org.academy.kata;

import org.academy.kata.dataproviders.FiveDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class FiveTest extends FiveDataProvider {
    @BeforeClass()
    public void beforeClass() {
        Locale.setDefault(Locale.US);
    }

    @Test(dataProvider = "data-gap")
    public void testGap(Five five, int g, long m, long n, long[] expected) {
        final long[] actual = five.gap(g, m, n);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-Zeros")
    public void testZeros(Five five, int n, int expected) {
        final int actual = five.zeros(n);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-perimeter")
    public void testPerimeter(Five five, BigInteger n, BigInteger expected) {
        final BigInteger actual = five.perimeter(n);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-solve")
    public void testSolve(Five five, double input, double expected) {
        final double actual = five.solve(input);
        assertEquals(actual, expected, 1e-6);
    }

    @Test(dataProvider = "data-Smallest")
    public void testSmallest(Five five, long n, long[] expected) {
        final long[] actual = five.smallest(n);
        assertEquals(actual, expected);
    }
}