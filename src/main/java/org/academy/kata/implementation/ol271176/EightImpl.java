package org.academy.kata.implementation.ol271176;

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
        int dividerCnt = 0;
        for(int e : numbers){
            if(e % divider == 0) dividerCnt++;
        }

        int[] resultArr = new int[dividerCnt];
        int index = 0;
        for(int e : numbers){
            if(e % divider == 0){
                resultArr[index++] = e;
            }
        }

        return resultArr;
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
