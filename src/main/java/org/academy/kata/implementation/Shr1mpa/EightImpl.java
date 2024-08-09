package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Eight;

import java.util.Arrays;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return 0;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return 0;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        int numberOfPositives = 0;
        int sumOfNegatives = 0;
        for (int number : input) {
            if (number > 0) {
                numberOfPositives++;
            }
            else {
                sumOfNegatives += number;
            }
        }

        return new int[]{numberOfPositives, sumOfNegatives};
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100.0) / 100.0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        return Arrays.stream(numbers)
                .filter(i -> i % divider == 0)
                .toArray();
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
