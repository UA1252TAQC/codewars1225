package org.academy.kata;

import org.academy.kata.dataprovider.EightDataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EightTest extends EightDataProvider {



    @Test(dataProvider = "data-Liters")
    public void testLiters(Eight eight, double time, int expected) {
        int actual = eight.liters(time);
        assertEquals(actual, expected);
    }


    @Test
    public void testGetVolumeOfCuboid() {
    }

    @Test
    public void testMpgToKPM() {
    }

    @Test
    public void testSquareOrSquareRoot() {
    }

    @Test
    public void testCountPositivesSumNegatives() {
    }

    @Test(dataProvider = "data-stringToNumber")
    public void testStringToNumber(Eight eight, String str, int expected) {
        int actual = eight.stringToNumber(str);
        assertEquals(actual, expected);
    }

    @Test
    public void testTwoDecimalPlaces() {
    }

    @Test
    public void testDivisibleBy() {
    }

    @Test
    public void testAm_i_wilson() {
    }
}