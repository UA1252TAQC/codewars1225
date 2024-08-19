package org.academy.kata;

import org.academy.kata.dataprovider.FiveDataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class FiveTest extends FiveDataProvider {

    @Test
    public void testGap() {
    }

    @Test(dataProvider = "data-Zeros")
    public void testZeros(Five five, int n, int expected) {
        int actual = five.zeros(n);
        assertEquals(actual, expected);
    }

    @Test
    public void testPerimeter() {
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