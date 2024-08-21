package org.academy.kata.implementation.sbekberov;

import org.academy.kata.Base;
import org.academy.kata.Seven;

public class SevenImpl extends Base implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
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
        if (n == 0) {
            return "0.00";
        }

        double sum = 0.0;

        for (int i = 0; i < n; i++) {
            double denaminator = 1 + 3 * i;
            sum += 1.0 / denaminator;
        }

        return String.format("%.2f", sum);
    }
}
