package org.academy.kata.implementation.marchenko2005;

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
        int length = numStr.length();
        long smallestNumber = n;
        int fromIndex = 0;
        int toIndex = 0;

        for (int i = 0; i < length; i++) {
            char digit = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i);
            for (int j = 0; j <= sb.length(); j++) {
                sb.insert(j, digit);
                long newNumber = Long.parseLong(sb.toString());
                if (newNumber < smallestNumber) {
                    smallestNumber = newNumber;
                    fromIndex = i;
                    toIndex = j;
                }
                sb.deleteCharAt(j);
            }
        }
        return new long[]{smallestNumber, fromIndex, toIndex};
    }
}
