package org.academy.kata;

import static org.testng.Assert.assertEquals;

import org.academy.kata.dataprovider.EightDataProvider;
import org.testng.annotations.Test;

public class EightTest extends EightDataProvider {

    @Test(dataProvider = "data-Liters")
    public void testLiters(Eight eight, double time, int expected) {
        int actual = eight.liters(time);
        assertEquals(actual, expected);
    }


    @Test(dataProvider = "data-getVolumeOfCuboid")
    public void testGetVolumeOfCuboid(Eight eight, double length, double width, double height, double expected) {
        double actual = eight.getVolumeOfCuboid(length, width, height);
        assertEquals(actual, expected);
    }

    @Test
    public void testMpgToKPM() {
    }

    @Test(dataProvider = "data-SquareOrSquareRoot")
    public void testSquareOrSquareRoot(Eight eight, int[] array, int[] expected) {
        int[] actual = eight.squareOrSquareRoot(array);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-countPositivesSumNegatives")
    public void testCountPositivesSumNegatives(Eight eight, int[] input, int[] expected) {
        int[] actual = eight.countPositivesSumNegatives(input);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-stringToNumber")
    public void testStringToNumber(Eight eight, String str, int expected) {
        int actual = eight.stringToNumber(str);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-decimal-places")
    public void testTwoDecimalPlaces(Eight eight, double number, double expected) {
        double actual = eight.TwoDecimalPlaces(number);
        assertEquals(actual, expected);
    }

    @Test
    public void testDivisibleBy() {
    }

    @Test(dataProvider = "data-Wilson")
    public void testAm_i_wilson(Eight eight, double n, boolean expected) {
        boolean actual = eight.am_i_wilson(n);
        assertEquals(actual, expected);
    }
}