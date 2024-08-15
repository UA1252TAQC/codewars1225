package org.academy.kata.implementation.oleksandrtkv;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        return 0;
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
        String numStr = Long.toString(n);
        int len = numStr.length();

        long minNumber = Long.MAX_VALUE;
        int bestI = -1;
        int bestJ = -1;

        for (int i = 0; i < len; i++) {
            char digit = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i);
            String remaining = sb.toString();

            for (int j = 0; j <= remaining.length(); j++) {
                StringBuilder newNumber = new StringBuilder(remaining);
                newNumber.insert(j, digit);

                long newNumberValue = Long.parseLong(newNumber.toString());
                if (newNumberValue < minNumber) {
                    minNumber = newNumberValue;
                    bestI = i;
                    bestJ = j;
                } else if (newNumberValue == minNumber) {
                    if (i < bestI || (i == bestI && j < bestJ)) {
                        bestI = i;
                        bestJ = j;
                    }
                }
            }
        }
        return new long[]{minNumber, bestI, bestJ};
    }
}
