package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Eight;

import java.math.BigInteger;
import java.util.Arrays;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        final float gallonToLiter = 4.54609188f;
        final float mileToKilometer = 1.609344f;
        float kpm = mpg * (mileToKilometer / gallonToLiter);
        return Math.round(kpm * 100.0f) / 100.0f;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        return Arrays.stream(array)
                .map(x -> {
                    double sqrt = Math.sqrt(x);
                    if (sqrt == (int) sqrt) {
                        return (int) sqrt;
                    } else {
                        return x * x;
                    }
                })
                .toArray();
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
        if (n < 2) return false;

        long nLong = (long) n;
        BigInteger factorial = factorial(BigInteger.valueOf(nLong - 1));
        BigInteger add = factorial.add(BigInteger.ONE);
        BigInteger divide= BigInteger.valueOf(nLong * nLong);

        return add.mod(divide).equals(BigInteger.ZERO);
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) <= 0) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
