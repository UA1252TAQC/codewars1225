package org.academy.kata;

import java.math.BigInteger;

public interface Five {
    long[] gap(int g, long m, long n);

    int zeros(int n);

    BigInteger perimeter(BigInteger n);

    public class SequenceSolver implements Five {

        @Override
        public double solve(double m) {
            return (-m + Math.sqrt(m * (m + 4))) / (2 * m);
        }


            long[] smallest(long n);

}
