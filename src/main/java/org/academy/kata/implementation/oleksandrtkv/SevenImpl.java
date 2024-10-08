package org.academy.kata.implementation.oleksandrtkv;

import org.academy.kata.Base;
import org.academy.kata.Seven;

public class SevenImpl extends Base implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double expectedTotal = navg * (arr.length + 1);
        for (int i = 0; i < arr.length; i++) {
            expectedTotal -= arr[i];
            if (expectedTotal <= 0) {
                throw new IllegalArgumentException();
            }
        }
        return (long) Math.ceil(expectedTotal);
    }

    @Override
    public String seriesSum(int n) {
        String result;
        if (n == 0) {
            result = "0.00";
        } else if (n == 1) {
            result = "1.00";
        } else {
            double sum = 0;
            double denominator = 1;
            for (int i = 0; i < n; i++) {
                sum += 1 / denominator;
                denominator += 3;
            }
            result = String.format("%.2f", Math.round(sum * 100.0) / 100.0);
        }
        return result;
    }
}
