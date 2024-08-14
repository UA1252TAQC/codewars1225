package org.academy.kata.implementation.Mihailll333;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        long sumArr = 0;
        for (double donation : arr) {
            sumArr += (long) donation;
        }
        int n = arr.length;
        long newDonation = (long) Math.ceil(navg * (n + 1) - sumArr);

        if (newDonation <= 0) {
            throw new IllegalArgumentException("Invalid donation amount");
        }
        return (int) newDonation;
    }

    @Override
    public String seriesSum(int n) {
        if (n == 0) {
            return "0.00";
        }

        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            sum += 1.0 / (1 + 3 * i);
        }
        return String.format("%.2f", sum);
    }
}
