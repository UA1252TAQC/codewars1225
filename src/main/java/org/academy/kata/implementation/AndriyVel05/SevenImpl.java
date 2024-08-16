package org.academy.kata.implementation.AndriyVel05;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        if (m==0) {
            return "0.00"
        }
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / 3 (3 * i + 1);
        }
        return String.format("%.2f", sum);
    }
}
