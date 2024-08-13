package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Eight;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.ArrayList;

public class EightImpl implements Eight {
    @Override
    public int liters(double time) {
        double res = time / 2;
        return (int)res;
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
    public static long factorial(double n){
        long res = 1;
        while((int)n > 0){
            res *= n;
            n--;
        }
        return res;
    }
    public static boolean isPrime(double n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
    @Override
    public boolean am_i_wilson(double n) {
        if(!isPrime(n))
            return false;
        if((factorial(n-1)/ n*n) % 1 == 0)
            return true;
        return false;
    }
}
