package org.academy.kata.implementation.smelovd;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        double result = 0;
        for (double i = 1; n > 0; i += 3, n--) {
            result += 1.0 / i;
        }

        return String.format("%.2f", result);
    }
}
