package org.academy.kata.implementation.Shr1mpa;

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
        long[] result = new long[3];
        long minNum = n;

        for (int i = 0; i < numStr.length(); i++) {
            for (int j = 0; j < numStr.length(); j++) {
                StringBuilder sb = new StringBuilder(numStr);
                char c = sb.charAt(i);
                sb.deleteCharAt(i);
                sb.insert(j, c);
                String num = sb.toString();
                if (Long.parseLong(num) < minNum) {
                    minNum = Long.parseLong(num);
                    result[0] = minNum;
                    result[1] = i;
                    result[2] = j;
                }
                sb.deleteCharAt(j);
            }
        }

        return result;
    }
}
