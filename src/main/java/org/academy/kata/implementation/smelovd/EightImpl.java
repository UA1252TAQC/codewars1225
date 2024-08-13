package org.academy.kata.implementation.smelovd;

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
        final int p = (int) n;
        if (p <= 1) {
            return false;
        }
        final BigInteger denominator = BigInteger.valueOf((long) p * p);
        final BigInteger numeric = factorial(p - 1);
        return numeric.add(BigInteger.ONE).remainder(denominator).equals(BigInteger.ZERO);
    }

    private static BigInteger factorial(int n) {
        BigInteger factorial = new BigInteger(String.valueOf(1));
        for (int i = 1; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
