package org.academy.kata.implementation.YanOleks;

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
        int iMin = 0, jMin = 0;
        String smallest = numStr;
        for (int i = 0; i < len; i++) {
            char currentChar = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i);

            for (int j = 0; j <= len - 1; j++) {
                StringBuilder newSb = new StringBuilder(sb);
                newSb.insert(j, currentChar);

                String newValStr = newSb.toString();

                if (newValStr.compareTo(smallest) < 0 ||
                        (newValStr.equals(smallest) && i < iMin)) {
                    smallest = newValStr;
                    iMin = i;
                    jMin = j;
                }
            }
        }

        long minVal = Long.parseLong(smallest);
        return new long[] { minVal, iMin, jMin };
    }
}
