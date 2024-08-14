package org.academy.kata.implementation.sbekberov;

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
        long minNumber = n;
        int fromIndex = 0;
        int toIndex = 0;

        for (int i = 0; i < numStr.length(); i++) {
            char digit = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i);

            for (int j = 0; j <= sb.length(); j++) {
                StringBuilder temp = new StringBuilder(sb);
                temp.insert(j, digit);
                long candidate = Long.parseLong(temp.toString());

                if (candidate < minNumber) {
                    minNumber = candidate;
                    fromIndex = i;
                    toIndex = j;
                }
            }
        }

        return new long[]{minNumber, fromIndex, toIndex};
    }
}
