package org.academy.kata.implementation.oleksandrtkv;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double expectedTotal = navg * (arr.length + 1);
        for (int i = 0; i < arr.length; i++) {
            expectedTotal -= arr[i];
            if (expectedTotal <= 0){
                throw new IllegalArgumentException();
            }
        }
        return (long)Math.ceil(expectedTotal);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
