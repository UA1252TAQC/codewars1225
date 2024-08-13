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
        return "";
    }
}
