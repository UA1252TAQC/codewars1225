package org.academy.kata.implementation.smelovd;

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
        final String s = Long.toString(n);
        long minNumber = n;
        int fromIndex = -1, toIndex = -1;

        for (int i = 0; i < s.length(); i++) {
            final String numWithoutFromIndex = s.substring(0, i) + s.substring(i + 1);

            for (int j = 0; j <= numWithoutFromIndex.length(); j++) {
                final long newNumber = Long.parseLong(numWithoutFromIndex.substring(0, j) + s.charAt(i) + numWithoutFromIndex.substring(j));

                if (newNumber < minNumber || (newNumber == minNumber && isIndexSmaller(fromIndex, toIndex, i, j))) {
                    minNumber = newNumber;
                    fromIndex = i;
                    toIndex = j;
                }
            }
        }

        return new long[] { minNumber, fromIndex, toIndex };
    }

    private boolean isIndexSmaller(int fromIndex, int toIndex, int i, int j) {
        return i < fromIndex || (i == fromIndex && j < toIndex);
    }
}
