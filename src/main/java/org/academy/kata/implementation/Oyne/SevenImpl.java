package org.academy.kata.implementation.Oyne;

import org.academy.kata.Base;
import org.academy.kata.Seven;

public class SevenImpl extends Base implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double i : arr) {
            sum += i;
        }
        double count = arr.length + 1;
        long res = (long) (Math.ceil(navg * count - sum));
        if (res < 0) {
            throw new IllegalArgumentException();
        } else return res;
    }

    @Override
    public String seriesSum(int n) {
        double denom = 1.0;
        double res = 0.0;
        for (int i = 0; i < n; i++) {
            res += 1 / denom;
            System.out.println(res);
            denom += 3;
            System.out.println(denom);
        }
        return String.format("%1$,.2f", res);
    }
}
