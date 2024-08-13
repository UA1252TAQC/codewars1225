package org.academy.kata.implementation.ol271176;

import org.academy.kata.Eight;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        return (int)(time/2);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length*width*height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return (float)((mpg/4.54609188)*1.609344);
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        int length = array.length;
        for(int i = 0; i < length; i++){
            if(Math.sqrt(array[i]) != Math.floor(Math.sqrt(array[i]))){
                array[i] *= array[i];
            } else{
                array[i] = (int)Math.sqrt(array[i]);
            }
        }
        return array;
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        if(input == null || input.length == 0)
            return new int[0];

        int positiveCnt = 0;
        int negativeSum = 0;

        for(int e : input) {
            if(e > 0) positiveCnt++;
            else if(e < 0) negativeSum += e;
        }

        return new int[]{positiveCnt, negativeSum};
    }

    @Override
    public int stringToNumber(String str) {
        return Integer.parseInt(str);
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        return Double.parseDouble(String.format("%.2f", number));
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
        if(n<2) return false;
        long factorial = 1;
        for(int i=2; i<=n-1; i++){
            factorial *= i;
        }
        double result = (factorial +1)/(n*n);
        return (long) result == result;
    }
}
