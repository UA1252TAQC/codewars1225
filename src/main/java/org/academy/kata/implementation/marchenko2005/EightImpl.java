package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Eight;
import java.math.RoundingMode;
import java.math.BigDecimal;
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
        double a = 1.609344 / 4.54609188;
        return mpg * (float)a;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int[] array2 =  new int[array.length];
        for(int i = 0; i < array.length; i++){
            int sqrt = (int) Math.sqrt(array[i]);
            if(sqrt *sqrt == array[i]){
                array2[i] = sqrt;
            }
            else{
                array2[i] = array[i]*array[i];
            }
        }
        return array2;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        return new int[0];
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
        return false;
    }
}
