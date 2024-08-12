package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Seven;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        BigDecimal res = new BigDecimal("0.0");
        for (int i = 0; i < n; i++) {
            BigDecimal term = BigDecimal.valueOf(1.0 / (1 + 3 * i));
            res = res.add(term);
        }
        res = res.setScale(2, RoundingMode.HALF_UP);

        return res.toString();
    }
}
