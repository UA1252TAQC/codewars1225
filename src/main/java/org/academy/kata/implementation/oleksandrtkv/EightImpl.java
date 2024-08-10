package org.academy.kata.implementation.oleksandrtkv;

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
        int[] output = new int[0];
        if (input != null && input.length != 0){
            output = new int[2];
            int posCount = 0;
            int negSum = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] > 0){
                    posCount++;
                } else {
                    negSum += input[i];
                }
            }
            output[0] = posCount;
            output[1] = negSum;
        }
        return output;
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
