package org.academy.kata.implementation.marchenko2005;

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
