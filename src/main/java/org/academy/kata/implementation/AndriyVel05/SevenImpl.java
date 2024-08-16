package org.academy.kata.implementation.AndriyVel05;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double currentSum = 0;
        for (double donation : arr) {
            currentSum += donation;
        }

        double requiredTotal = (arr.length + 1)* navg;
        double requiredDonation = requiredTotal - currentSum;

        if (requiredDonation <= 0) {
            throw new IllegalArgumentException("The required donation must be a positive number.");
        }
        return (long) Math.ceil(requiredDonation);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
