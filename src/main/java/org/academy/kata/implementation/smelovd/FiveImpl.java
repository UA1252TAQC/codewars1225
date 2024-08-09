package org.academy.kata.implementation.smelovd;

import org.academy.kata.Five;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        final BigDecimal num = new BigDecimal(String.valueOf(n));
        int zeros = 0;
        for (BigDecimal i = new BigDecimal("5"); i.compareTo(num) < 0; i = i.multiply(new BigDecimal("5"))) {
            zeros += num.divide(i, RoundingMode.DOWN).intValue();
        }
        return zeros;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    @Override
    public double solve(double m) {
        return 0;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
