package org.academy.kata.implementation.ol271176;

import org.academy.kata.Base;
import org.academy.kata.Seven;

public class SevenImpl extends Base implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double arrSum = 0;
        for (double e : arr) {
            arrSum += e;
        }
        long result = (long) Math.ceil(navg * (arr.length + 1) - arrSum);
        if (result > 0) {
            return result;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String seriesSum(int n) {
        if (n == 0) return "0.00";
        double result = 0;
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            result += 1.0 / cnt;
            cnt += 3;
        }
        return String.format("%.2f", result);
    }
}
