package org.academy.kata.implementation.Oyne;

import org.academy.kata.Eight;

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
        return false;
    }
}
