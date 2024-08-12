package org.academy.kata.implementation.smelovd;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.Arrays;

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
        final String s = Long.toString(n);
        final char[] digits = s.toCharArray(), sortedDigits = digits.clone();
        Arrays.sort(sortedDigits);

        for (int i = 0; i < s.length(); i++) {
            if (sortedDigits[i] == digits[i]) continue;

            int firstFromIndex = s.lastIndexOf(sortedDigits[i]), firstToIndex = i;
            final long firstNum = createNumber(s, firstFromIndex, firstToIndex, sortedDigits[i]);
            int secondFromIndex = i, secondToIndex = calculateSecondToIndex(secondFromIndex, s, digits);
            final long secondNum = createNumber(s, secondFromIndex, secondToIndex, digits[i]);

            if (firstNum < secondNum) {
                while (firstFromIndex > 0 && digits[firstFromIndex] == digits[firstFromIndex - 1]) firstFromIndex--;
                while (firstToIndex > 0 && sortedDigits[i] == digits[firstToIndex - 1]) firstToIndex--;
                return new long[] { firstNum, firstFromIndex, firstToIndex };
            }
            while (secondFromIndex > 0 && digits[secondFromIndex] == digits[secondFromIndex - 1]) secondFromIndex--;
            while (secondToIndex < s.length() - 1 && digits[i] == digits[secondToIndex + 1]) secondToIndex++;
            return new long[] { secondNum, secondFromIndex, secondToIndex };
        }
        return new long[] { n, -1, -1 };
    }

    private static int calculateSecondToIndex(int fromIndex, String s, char[] digits) {
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
