package org.academy.kata.implementation.oleksandrtkv;

import org.academy.kata.Eight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return (int)(time / 2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return new BigDecimal(mpg * 1.609344 / 4.54609188).setScale(2, RoundingMode.HALF_UP).floatValue();
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % Math.sqrt(array[i]) == 0){
                array[i] = (int) Math.sqrt(array[i]);
            } else {
                array[i] *= array[i];
            }
        }
        return array;
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
        return Integer.parseInt(str);
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
        return n == 5 || n == 13 || n == 563;
    }
}
