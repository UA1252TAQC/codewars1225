package org.academy.kata;

import org.academy.kata.dataprovider.EightDataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

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

    @Test(dataProvider = "data-SquareOrSquareRoot")
    public void testSquareOrSquareRoot(Eight eight, int[] array, int[] expected) {
        System.out.println("Input data: " + Arrays.toString(array) + " " + Arrays.toString(expected));
        int[] actual = eight.squareOrSquareRoot(array);
        System.out.println("Result: " + Arrays.toString(expected));
        assertEquals(actual, expected);
    }

    @Test
    public void testCountPositivesSumNegatives() {
    }

    @Test(dataProvider = "data-stringToNumber")
    public void testStringToNumber(Eight eight, String str, int expected) {
        int acutal = eight.stringToNumber(str);
        assertEquals(acutal, expected);
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