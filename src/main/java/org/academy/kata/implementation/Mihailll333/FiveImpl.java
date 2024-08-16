package org.academy.kata.implementation.Mihailll333;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        if (g < 2 || m < 2 || n < m) {
            return new long[]{0, 0};
        }

        boolean[] isPrime = new boolean[(int) (n + 1)];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; (long) i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        List<Long> primesInRange = new ArrayList<>();
        for (long i = Math.max(m, 2); i <= n; i++) {
            if (isPrime[(int) i]) {
                primesInRange.add(i);
            }
        }

        for (int i = 0; i < primesInRange.size() - 1; i++) {
            long p1 = primesInRange.get(i);
            long p2 = primesInRange.get(i + 1);
            if (p2 - p1 == g) {
                return new long[]{p1, p2};
            }
        }

        return new long[]{0, 0};
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        if (n.compareTo(BigInteger.ZERO) < 0) {
            return BigInteger.ZERO;
        }

        int intN = n.intValue();

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger c;

        if (intN == 0) {
            return BigInteger.valueOf(4);
        } else if (intN == 1) {
            return BigInteger.valueOf(12);
        }

        for (int i = 2; i <= intN + 1; i++) {
            c = a.add(b);
            a = b;
            b = c;
        }

        BigInteger sumOfFib = b.subtract(BigInteger.ONE);
        return sumOfFib.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        double discriminant = (m - 1) * (m - 1) + 4 * m;
        double sqrtDiscriminant = Math.sqrt(discriminant);

        // Calculate the two possible roots
        double x1 = (m - 1 + sqrtDiscriminant) / 2;
        double x2 = (m - 1 - sqrtDiscriminant) / 2;

        // Return the root in the range (0, 1)
        if (x1 > 0 && x1 < 1) {
            return x1;
        } else if (x2 > 0 && x2 < 1) {
            return x2;
        }
        return discriminant;
    }

    @Override
    public long[] smallest(long n) {
        String numStr = Long.toString(n);
        int len = numStr.length();

        String minNumber = numStr;
        int minI = -1, minJ = -1;

        for (int i = 0; i < len; i++) {
            char digit = numStr.charAt(i);

            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                StringBuilder sb = new StringBuilder(numStr);
                sb.deleteCharAt(i);
                sb.insert(j, digit);

                String newNumber = sb.toString();

                if (newNumber.compareTo(minNumber) < 0) {
                    minNumber = newNumber;
                    minI = i;
                    minJ = j;
                }
            }
        }

        long smallestNumber = Long.parseLong(minNumber);
        return new long[]{smallestNumber, minI, minJ};
    }
}
