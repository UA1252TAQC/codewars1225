package org.academy.kata;

import org.academy.kata.dataprovider.FiveDataProvider;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.Arrays;

import static org.testng.Assert.*;

public class FiveTest extends FiveDataProvider {

    @Test(dataProvider = "data-gap")
    public void testGap(Five five, int g, long m, long n, long[] expected) {
        long[] actual = five.gap(g, m, n);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-Zeros")
    public void testZeros(Five five, int n, int expected) {
        int actual = five.zeros(n);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-perimeter")
    public void testPerimeter(Five five, BigInteger n, BigInteger expected) {
        BigInteger actual = five.perimeter(n);
        assertEquals(actual, expected);
    }

    @Test
    public void testSolve() {
    }

    @Test(dataProvider = "data-Smallest")
    public void testSmallest(Five five, long n, long[] expected) {
        long[] actual = five.smallest(n);
        assertEquals(actual, expected);
    }
}