package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        double a = navg * (arr.length+1) - sum;
        if(a <= 0)
            throw new IllegalArgumentException();
        return (long) Math.ceil(a);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
