package org.academy.kata;

import org.academy.kata.dataprovider.FiveDataProvider;
import org.testng.annotations.Test;

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

    @Test
    public void testSmallest() {
    }
}