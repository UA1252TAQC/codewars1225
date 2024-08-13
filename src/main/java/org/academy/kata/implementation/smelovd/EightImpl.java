package org.academy.kata.implementation.smelovd;

import org.academy.kata.Eight;

import java.util.Arrays;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return 0;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return Math.round(mpg * (1.609344f / 4.54609188f) * 100.0f) / 100.0f;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            double sqrtValue = Math.sqrt(array[i]);
            if (sqrtValue == Math.floor(sqrtValue)) {
                array[i] = (int) sqrtValue;
            } else {
                array[i] = (int) Math.pow(array[i], 2);
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int positiveCount = 0, negativeSum = 0;
        for (int num : input) {
            if (num > 0) {
                positiveCount++;
            } else {
                negativeSum += num;
            }
        }

        return new int[] { positiveCount, negativeSum };
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
        return Arrays.stream(numbers).filter(num -> num % divider == 0).toArray();
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
