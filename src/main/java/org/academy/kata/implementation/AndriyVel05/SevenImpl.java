package org.academy.kata.implementation.AndriyVel05;

import org.academy.kata.Base;
import org.academy.kata.Seven;

public class SevenImpl extends Base implements Seven {
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
        if (n == 0) {
            return "0.00";
        }
        double sum = 0.0;
        for (int i = 0; i < n; i++) {
            sum += 1.0 / (3 * i + 1);
        }
        return String.format("%.2f", sum);
    }
}