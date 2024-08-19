package org.academy.kata.implementation.AndriyVel05;

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
        String numStr = String.valueOf(n);
        int len = numStr.length();
        long smallestNum = n;
        int[] result = {0, 0, 0}; // {smallestNum, i, j}

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                StringBuilder sb = new StringBuilder(numStr);
                char ch = sb.charAt(i);
                sb.deleteCharAt(i);
                sb.insert(j, ch);
                long newNum = Long.parseLong(sb.toString());

                if (newNum < smallestNum || (newNum == smallestNum && i < result[1])) {
                    smallestNum = newNum;
                    result[0] = (int) smallestNum;
                    result[1] = i;
                    result[2] = j;
                }
            }
        }
        return new long[]{smallestNum, result[1], result[2]};
    }
}
