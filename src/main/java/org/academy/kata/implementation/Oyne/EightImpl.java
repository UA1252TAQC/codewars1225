package org.academy.kata.implementation.Oyne;

import org.academy.kata.Eight;

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
            if ((double) Math.sqrt(array[i]) == (int) Math.sqrt(array[i])) {
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
        return new int[0];
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
