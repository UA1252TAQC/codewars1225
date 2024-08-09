package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Eight;
import java.util.ArrayList;

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
        return new int[0];
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
        ArrayList<Integer> divided = new ArrayList<Integer>();
        for (int val: numbers){
            if (val % divider == 0) divided.add(val);
        }
        return divided.stream().mapToInt(i -> i).toArray();
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
