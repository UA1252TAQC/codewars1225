package org.academy.kata.implementation.sbekberov;

import org.academy.kata.Seven;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        if (navg <= 0) {
            throw new IllegalArgumentException("The target average must be greater than 0.");
        }

        double totalCurrentSum = 0;
        for (double donation : arr) {
            totalCurrentSum += donation;
        }

        double totalRequiredSum = navg * (arr.length + 1);

        double requiredDonation = totalRequiredSum - totalCurrentSum;

        if (requiredDonation <= 0) {
            throw new IllegalArgumentException("The required donation must be greater than 0.");
        }

        return (long) Math.ceil(requiredDonation);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
