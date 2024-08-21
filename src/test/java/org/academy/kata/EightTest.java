package org.academy.kata;

import org.academy.kata.dataproviders.EightDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.testng.Assert.assertEquals;

public class EightTest extends EightDataProvider {
    @BeforeClass()
    public void beforeClass() {
        Locale.setDefault(Locale.US);
    }

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

    @Test(dataProvider = "data-MpgToKPM")
    public void testMpgToKPM(Eight eight, float mpg, float expected) {
        float actual = eight.mpgToKPM(mpg);
        assertEquals(actual, expected);
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

    @Test(dataProvider = "data-divisibleBy")
    public void testDivisibleBy(Eight eight, int[] numbers, int divider, int[] expected) {
        int[] actual = eight.divisibleBy(numbers, divider);
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "data-Wilson")
    public void testAm_i_wilson(Eight eight, double n, boolean expected) {
        boolean actual = eight.am_i_wilson(n);
        assertEquals(actual, expected);
    }
}
