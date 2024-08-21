package org.academy.kata.implementation.Mihailll333;

import org.academy.kata.Base;
import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FiveImpl extends Base implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
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
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = BigInteger.ONE;

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n.add(BigInteger.ONE)) <= 0;
             i = i.add(BigInteger.ONE)) {
            BigInteger tmp = a.add(b);
            a = b;
            b = tmp;
            sum = sum.add(b);
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    private static BigInteger fibonacci(int n) {
        if (n < 2) {
            return BigInteger.valueOf(n);
        }
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }
        return b;
    }

    @Override
    public double solve(double m) {
        double discriminant = Math.sqrt((1 + 2 * m) * (1 + 2 * m) - 4 * m * m);

        double x1 = (1 + 2 * m - discriminant) / (2 * m);
        double x2 = (1 + 2 * m + discriminant) / (2 * m);

        if (x1 > 0 && x1 < 1) {
            return x1;
        } else {
            return x2;
        }
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
