package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        double term = 0;
        for (int i = 1, j = 1; i <= n; i++, j += 3){
            term += (1. / j);
        }
        return String.format("%.2f", term);
    }
}
