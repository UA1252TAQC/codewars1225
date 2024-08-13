package org.academy.kata.implementation.VladyslavaNezhnova;

import org.academy.kata.Eight;

import java.util.ArrayList;
import java.util.List;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return (int) Math.floor (time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        final float milesToKilometers = 1.609344f;
        final float gallonsToLiters = 4.54609188f;

        float kpl = (mpg * milesToKilometers) / gallonsToLiters;
        kpl = Math.round(kpl * 100.0f) / 100.0f;
        return kpl;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int sqrt = (int) Math.sqrt(array[i]);
            if (sqrt * sqrt == array[i]) {
                result[i] = sqrt;
            } else {
                result[i] = array[i] * array[i];
            }
        }
        return result;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }
        
        int countPositives = 0;
        int sumNegatives = 0;

        for (int number : input) {
            if (number > 0) {
                countPositives++;
            } else if (number < 0) {
                sumNegatives += number;
            }
        }
        return new int[]{countPositives, sumNegatives};
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
        List <Integer> resultList = new ArrayList<Integer>();
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
        return n == 5 || n == 13 || n == 563;
    }
}
