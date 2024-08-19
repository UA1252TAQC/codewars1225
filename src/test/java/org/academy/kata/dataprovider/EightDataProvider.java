package org.academy.kata.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EightDataProvider extends AbstractDataProvider {

    @DataProvider(name = "data-Liters")
    public static Iterator<Object[]> dpLiters() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{80, 40});
        inputs.add(new Object[]{1600.20, 800});
        inputs.add(new Object[]{14.64, 7});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-SquareOrSquareRoot")
    public static Iterator<Object[]> dpSquareOrSquareRoot() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[]{4, 3, 9, 7, 2, 1}, new int[]{2, 9, 3, 49, 4, 1}});
        inputs.add(new Object[]{new int[]{100, 101, 5, 5, 1, 1}, new int[]{10, 10201, 25, 25, 1, 1}});
        inputs.add(new Object[]{new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 4, 9, 2, 25, 36}});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-Wilson")
    public static Iterator<Object[]> dpWilson() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{-1, false});
        inputs.add(new Object[]{1, false});
        inputs.add(new Object[]{1.1, false});
        inputs.add(new Object[]{2, false});
        inputs.add(new Object[]{5, true});
        inputs.add(new Object[]{13, true});
        inputs.add(new Object[]{12, false});
        inputs.add(new Object[]{563, true});
        inputs.add(new Object[]{562, false});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-decimal-places")
    public static Iterator<Object[]> dpDecimalPlaces() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{5.5589, 5.56});
        inputs.add(new Object[]{3.3424, 3.34});
        inputs.add(new Object[]{7.1234, 7.12});
        inputs.add(new Object[]{1.9999, 2.00});
        inputs.add(new Object[]{0.005, 0.01});
        inputs.add(new Object[]{-2.678, -2.68});
        inputs.add(new Object[]{-256789.567890, -256789.57});
        inputs.add(new Object[]{100.0049, 100.00});
        inputs.add(new Object[]{0.0, 0.00});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-stringToNumber")
    public static Iterator<Object[]> dpStringToNumber() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{"1234", 1234});
        inputs.add(new Object[]{"605", 605});
        inputs.add(new Object[]{"1405", 1405});
        inputs.add(new Object[]{"-7", -7});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-countPositivesSumNegatives")
    public static Iterator<Object[]> dpCountPositivesSumNegatives() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[]{1, 2, 3, -1, -2, -3}, new int[]{3, -6}});
        inputs.add(new Object[]{new int[]{}, new int[0]});
        inputs.add(new Object[]{new int[]{0}, new int[]{0, 0}});
        inputs.add(new Object[]{new int[]{10}, new int[]{1, 0}});
        inputs.add(new Object[]{new int[]{-10}, new int[]{0, -10}});
        inputs.add(new Object[]{new int[]{1, 2, 3, 4}, new int[]{4, 0}});
        inputs.add(new Object[]{new int[]{-1, -2, -3, -4}, new int[]{0, -10}});
        inputs.add(new Object[]{new int[]{0, 1, 2, 3}, new int[]{3, 0}});
        inputs.add(new Object[]{new int[]{0, -1, -2, -3}, new int[]{0, -6}});
        inputs.add(new Object[]{new int[]{1, 1, 1, -1, -1, -1}, new int[]{3, -3}});
        inputs.add(new Object[]{new int[]{1, -1, 2, -2, 3, -3}, new int[]{3, -6}});
        inputs.add(new Object[]{new int[]{0}, new int[]{0, 0}});
        inputs.add(new Object[]{null, new int[0]});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-getVolumeOfCuboid")
    public static Iterator<Object[]> dpGetVolumeOfCuboid() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{2.0, 3.0, 4.0, 24.0});
        inputs.add(new Object[]{1.5, 2.5, 3.5, 13.125});
        inputs.add(new Object[]{0.0, 3.0, 4.0, 0.0});
        inputs.add(new Object[]{5.0, 5.0, 5.0, 125.0});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-MpgToKPM")
    public static Iterator<Object[]> dpmpgToKPM() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{10f, 3.54f});
        inputs.add(new Object[]{20f, 7.08f});
        inputs.add(new Object[]{30f, 10.62f});
        inputs.add(new Object[]{50f, 17.7f});
        inputs.add(new Object[]{70f, 24.78f});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-divisibleBy")
    public static Iterator<Object[]> findNumbersWhichAreDivisibleByGivenNumber() {
        List<Object[]> inputs = new ArrayList<>();

        inputs.add(new Object[] { new int[]{2, 4, 6, 8, 10}, 2, new int[]{2, 4, 6, 8, 10}});            // All numbers are divisible by the divisor.
        inputs.add(new Object[] { new int[]{3, 5, 7, 10, 15}, 5, new int[]{5, 10, 15}});                // Some numbers are divisible by the divisor, and some are not.
        inputs.add(new Object[] { new int[]{1, 2, 3}, 4, new int[]{}});                                 // None of the numbers is divisible by the divisor.
        inputs.add(new Object[] { new int[]{}, 3, new int[]{}});                                        // Checks if the input array is empty.
        inputs.add(new Object[] { new int[]{10}, 5, new int[]{10}});                                    // The input array has only one element.
        inputs.add(new Object[] { new int[]{1, 2, 3}, 10, new int[]{}});                                // The divisor is greater than all the numbers
        inputs.add(new Object[] { new int[]{3, 5, 7}, 1, new int[]{3, 5, 7} });                         // The divisor is equal to 1
        inputs.add(new Object[] { new int[]{-2, -4, -6, -8, -10}, 2, new int[]{-2, -4, -6, -8, -10}});  // Negative numbers in an array with a positive divisor
        inputs.add(new Object[] { new int[]{2, 4, 6, 8, 10}, -2, new int[]{2, 4, 6, 8, 10}});           // Positive numbers with a negative divisor
        inputs.add(new Object[] { new int[]{-2, -4, -6, -8, -10}, -2, new int[]{-2, -4, -6, -8, -10}}); // Negative numbers with a negative divisor

        return combineData(inputs, EIGHT);
    }
}
