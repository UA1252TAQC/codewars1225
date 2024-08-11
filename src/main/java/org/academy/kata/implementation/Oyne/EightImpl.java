package org.academy.kata.implementation.Oyne;

import org.academy.kata.Eight;

import java.math.BigInteger;

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
        return new int[0];
    }

    @Override
    public int stringToNumber(String str) {
        return 0;
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return 0;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        return new int[0];
    }

    @Override
    public boolean am_i_wilson(double n) {
        if (n <= 1) {
            return false;
        }

        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= n - 1; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        BigInteger numerator = factorial.add(BigInteger.ONE);
        BigInteger denominator = BigInteger.valueOf((long)n).multiply(BigInteger.valueOf((long)n));
        BigInteger[] divisionResult = numerator.divideAndRemainder(denominator);

        return divisionResult[1].equals(BigInteger.ZERO);
    }
}
