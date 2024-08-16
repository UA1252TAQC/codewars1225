package org.academy.kata.implementation.Oyne;

import org.academy.kata.Eight;

import java.math.BigInteger;
import java.util.ArrayList;


public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return (int) (time / 2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float onempg = (float) (1.609344 / 4.54609188);
        return (float) (Math.round(onempg * mpg * 100.0) / 100.0);
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (Math.sqrt(array[i]) == (int) Math.sqrt(array[i])) {
                array[i] = (int) Math.sqrt(array[i]);
            } else {
                array[i] = array[i] * array[i];
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        int[] res = new int[2];
        int pos = 0;
        int neg = 0;
        if (input == null || input.length == 0)
            return new int[0];
        else {
            for (int j : input) {
                if (j < 0) {
                    neg += j;
                } else if (j > 0) {
                    pos++;
                }
            }
            res[0] = pos;
            res[1] = neg;
            return res;
        }
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
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i : numbers) {
            if (i % divider == 0) {
                res.add(i);
            }
        }

        int[] resInt = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            resInt[i] = res.get(i);
        }
        return resInt;
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
        BigInteger denominator = BigInteger.valueOf((long) n).multiply(BigInteger.valueOf((long) n));
        BigInteger[] divisionResult = numerator.divideAndRemainder(denominator);

        return divisionResult[1].equals(BigInteger.ZERO);
    }
}
