package org.academy.kata;

import java.math.BigInteger;

public interface Five {
    public class PrimeGap {
        public static long[] gap(int g, long m, long n) {
            long prevPrime = 0;

            for (long i = m; i <= n; i++) {
                if (isPrime(i)) {
                    if (prevPrime != 0 && i - prevPrime == g) {
                        return new long[]{prevPrime, i};
                    }
                    prevPrime = i;
                }
            }
            return null;
        }

        private static boolean isPrime(long num) {
            if (num < 2) return false;
            for (long i = 2; i * i <= num; i++) {
                if (num % i == 0) return false;
            }
            return true;
        }

    }


        int zeros(int n);

    BigInteger perimeter(BigInteger n);

    double solve(double m);

    long[] smallest(long n);

}
