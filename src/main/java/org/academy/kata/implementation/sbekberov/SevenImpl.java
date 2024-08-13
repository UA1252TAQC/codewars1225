package org.academy.kata.implementation.sbekberov;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        if (n == 0){
            return "0.00";
        }

        double sum = 0.0;

        for (int i = 0; i < n; i++){
            double denaminator = 1 + 3 * i;
            sum += 1.0 / denaminator;
        }

        return String.format("%.2f", sum);
    }
}
