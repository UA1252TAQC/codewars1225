package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Base;
import org.academy.kata.Eight;

import java.util.ArrayList;

public class EightImpl extends Base implements Eight {
    @Override
    public int liters(double time) {
        return (int) Math.floor(time * 0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length * width * height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return Math.round((mpg * 1.609344f / 4.54609188f) * 100f) / 100f;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        for (int i = 0; i < array.length; i++) {
            double root = Math.sqrt(array[i]);
            if (root == (int) root) {
                array[i] = (int) root;
            } else {
                array[i] *= array[i];
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) return new int[0];
        int[] result = {0, 0};
        for (int val : input) {
            if (val > 0) result[0]++;
            else if (val < 0) result[1] += val;
        }
        return result;
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Math.round(number * 100) / 100.;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> divided = new ArrayList<Integer>();
        for (int val : numbers) {
            if (val % divider == 0) divided.add(val);
        }
        return divided.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public boolean am_i_wilson(double n) {
        if (n <= 1) return false;
        double factorial_mod = 1;
        for (int i = 2; i < n; i++) {
            factorial_mod = (factorial_mod * i) % (n * n);
        }
        return (((factorial_mod + 1) % (n * n)) == 0);
    }
}
