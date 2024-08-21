package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Base;
import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;

public class EightImpl extends Base implements Eight {
    @Override
    public int liters(double time) {
        double res = time / 2;
        return (int) res;
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
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int sqrt = (int) Math.sqrt(array[i]);
            if (sqrt * sqrt == array[i]) {
                array2[i] = sqrt;
            } else {
                array2[i] = array[i] * array[i];
            }
        }
        return array2;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0)
            return new int[0];
        int negSum = 0;
        int posCount = 0;
        for (int j : input) {
            if (j < 0) {
                negSum += j;
            }
            if (j > 0) {
                posCount++;
            }
        }
        return new int[]{posCount, negSum};
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        BigDecimal bd = new BigDecimal(Double.toString(number));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int number : numbers) {
            if (number % divider == 0)
                a.add(number);
        }
        return a.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public boolean am_i_wilson(double n) {
        final int num = (int) n;
        if (num <= 1) {
            return false;
        }
        BigInteger factorialValue = BigInteger.ONE;
        for (int i = 2; i < num; i++) {
            factorialValue = factorialValue.multiply(BigInteger.valueOf(i));
        }
        final BigInteger denominator = BigInteger.valueOf((long) num * num);
        final BigInteger numerator = factorialValue.add(BigInteger.ONE);

        return numerator.remainder(denominator).equals(BigInteger.ZERO);
    }

}
