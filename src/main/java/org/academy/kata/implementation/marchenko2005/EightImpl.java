package org.academy.kata.implementation.marchenko2005;

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
        if(input == null || input.length == 0)
        return new int[0];
        int negSum = 0;
        int posCount = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] < 0){
                negSum += input[i];
            }
            if(input[i] > 0){
                posCount++;
            }
        }
        int[] result = new int[] {posCount, negSum};
        return result;
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
    public int[] divisibleBy(int[] numbers, int divider) {   return new int[0];}

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
