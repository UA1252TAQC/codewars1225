package org.academy.kata.implementation.ol271176;

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
        String smallestNum = numStr;
        int minI = -1;
        int minJ = -1;

        // Overrides all possible positions to move the number
        for (int i = 0; i < numStr.length(); i++) {
            char digit = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i); // Delete digit
            for (int j = 0; j <= sb.length(); j++) {
                sb.insert(j, digit); // Insert digit to new position
                String newNumStr = sb.toString();
                if (newNumStr.compareTo(smallestNum) < 0) {
                    smallestNum = newNumStr;
                    minI = i;
                    minJ = j;
                }
                sb.deleteCharAt(j); // Delete inserted digit
            }
        }

        return new long[]{Long.parseLong(smallestNum), minI, minJ};
    }
}
