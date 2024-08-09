package org.academy.kata.implementation.VladyslavaNezhnova;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double currentSum = 0;
        for (double donation : arr) {
            currentSum += donation;
        }
        double requiredSum = navg * (arr.length + 1);
        double newDonation = requiredSum - currentSum;

        if (newDonation <= 0) {
            throw new IllegalArgumentException("New donation must be positive");
        }

        return (long) Math.ceil(newDonation);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
