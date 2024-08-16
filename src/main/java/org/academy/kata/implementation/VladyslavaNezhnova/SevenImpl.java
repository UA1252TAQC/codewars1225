package org.academy.kata.implementation.VladyslavaNezhnova;

import org.academy.kata.Base;
import org.academy.kata.Seven;

public class SevenImpl extends Base implements Seven {
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
