package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        if (arr.length == 0) return (long)navg;
        double sum = 0;
        for (double val: arr){
            sum += val;
        }
        double result = navg * (arr.length + 1) - sum;
        if (result < 0) throw new IllegalArgumentException();
        return (long)Math.ceil(result);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
