package org.academy.kata.implementation.sbekberov;

import org.academy.kata.Base;
import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;

public class EightImpl extends Base implements Eight {
    @Override
    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        if (length <= 0 || width <= 0 || height <= 0) return 0;
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float kpl = (mpg * 1.609344f) / 4.54609188f;
        return Math.round(kpl * 100) / 100.0f;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Input array must not be null or empty.");
        }

        int[] result = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int sqrt = (int) Math.sqrt(num);
            if (sqrt * sqrt == num) {
                result[i] = sqrt;
            } else {
                result[i] = num * num;
            }
        }

        return result;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int positiveCount = 0;
        int negativeSum = 0;

        for (int num : input) {
            if (num > 0) {
                positiveCount++;
            } else if (num < 0) {
                negativeSum += num;
            }
        }

        return new int[]{positiveCount, negativeSum};
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {

        ArrayList<Integer> resultList = new ArrayList<>();

        for (int number : numbers) {
            if (number % divider == 0) {
                resultList.add(number);
            }
        }

        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    @Override
    public boolean am_i_wilson(double n) {
        if (n != (int) n || n <= 1) {
            return false;
        }

        int P = (int) n;

        if (!isPrime(P)) {
            return false;
        }

        BigInteger factorial = factorial(P - 1);
        BigInteger P_squared = BigInteger.valueOf(P).multiply(BigInteger.valueOf(P));

        return factorial.add(BigInteger.ONE).mod(P_squared).equals(BigInteger.ZERO);
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    private static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}
