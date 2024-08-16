package org.academy.kata.implementation.Mihailll333;

import org.academy.kata.Eight;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return (int) (time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return width * height * length;
    }

    @Override
    public float mpgToKPM(float mpg) {
        float milesToKilometers = 1.609344f;
        float gallonToLiters = 4.54609188f;

        float kpl = mpg * (milesToKilometers / gallonToLiters);

        return Math.round(kpl * 100.0f) / 100.0f;
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
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countPositives = 0;
        int sumNegatives = 0;

        for (int num : input) {
            if (num > 0) {
                countPositives++;
            } else if (num < 0) {
                sumNegatives += num;
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
        int count = 0;
        for (int number : numbers) {
            if (number % divider == 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int number : numbers) {
            if (number % divider == 0) {
                result[index++] = number;
            }
        }
        return result;
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
