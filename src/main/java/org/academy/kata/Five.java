package org.academy.kata;

import java.math.BigInteger;

public interface Five {
    long[] gap(int g, long m, long n);

    static int zeros(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    BigInteger perimeter(BigInteger n);

    double solve(double m);

    long[] smallest(long n);

}
