package org.academy.kata.implementation.Oyne;

import org.academy.kata.Base;
import org.academy.kata.Five;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.stream.LongStream;

public class FiveImpl extends Base implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        final long[] primeNumbers = LongStream.rangeClosed(m, n)
                .filter(org.academy.kata.implementation.Oyne.FiveImpl::isPrimeNumber).toArray();
        for (int i = 0; i + 1 < primeNumbers.length; i++) {
            if (primeNumbers[i + 1] - primeNumbers[i] == g) {
                return new long[]{primeNumbers[i], primeNumbers[i + 1]};
            }
        }
        return null;
    }

    private static boolean isPrimeNumber(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    @Override
    public int zeros(int n) {
        final BigDecimal num = new BigDecimal(String.valueOf(n));
        int zeros = 0;
        for (BigDecimal i = new BigDecimal("5"); i.compareTo(num) < 0; i = i.multiply(new BigDecimal("5"))) {
            zeros += num.divide(i, RoundingMode.DOWN).intValue();
        }
        return zeros;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return sumFibonacci(n.longValueExact()).multiply(BigInteger.valueOf(4L));
    }

    private static BigInteger sumFibonacci(long n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = a.add(b);

        for (int i = 2; i <= n + 1; i++) {
            BigInteger next = a.add(b);
            sum = sum.add(next);
            a = b;
            b = next;
        }

        return sum;
    }

    @Override
    public double solve(double m) {
        return (2 * m + 1 - Math.sqrt(1 + 4 * m)) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        final String s = Long.toString(n);
        final char[] digits = s.toCharArray(), sortedDigits = digits.clone();
        Arrays.sort(sortedDigits);

        for (int i = 0; i < s.length(); i++) {
            if (sortedDigits[i] == digits[i]) continue;

            int firstFromIndex = s.lastIndexOf(sortedDigits[i]), firstToIndex = i;
            final long firstNum = createNumber(s, firstFromIndex, firstToIndex, sortedDigits[i]);
            int secondFromIndex = i, secondToIndex = findSecondToIndex(secondFromIndex, s, digits);
            final long secondNum = createNumber(s, secondFromIndex, secondToIndex, digits[i]);

            if (firstNum < secondNum) {
                while (firstFromIndex > 0 && digits[firstFromIndex] == digits[firstFromIndex - 1]) firstFromIndex--;
                while (firstToIndex > 0 && sortedDigits[i] == digits[firstToIndex - 1]) firstToIndex--;
                return new long[]{firstNum, firstFromIndex, firstToIndex};
            }
            while (secondFromIndex > 0 && digits[secondFromIndex] == digits[secondFromIndex - 1]) secondFromIndex--;
            while (secondToIndex < s.length() - 1 && digits[i] == digits[secondToIndex + 1]) secondToIndex++;
            return new long[]{secondNum, secondFromIndex, secondToIndex};
        }
        return new long[]{n, -1, -1};
    }

    private static int findSecondToIndex(int fromIndex, String s, char[] digits) {
        for (int j = fromIndex; j < s.length() - 2; j++) {
            if (digits[fromIndex] < digits[j + 1]) {
                return j;
            }
        }
        return s.length() - 1;
    }

    private static long createNumber(String number, int fromIndex, int toIndex, char digit) {
        return Long.parseLong(new StringBuilder(number).deleteCharAt(fromIndex).insert(toIndex, digit).toString());
    }
}
