package org.academy.kata.implementation.Oyne;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        double denom = 1.0;
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            res += 1 / denom;
            System.out.println(res);
            denom += 3;
            System.out.println(denom);
        }
        return String.format("%1$,.2f", res);
    }
}
