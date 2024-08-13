package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Seven;
import java.util.stream.IntStream;

import java.util.Arrays;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        int n = arr.length;
        double sum = Arrays.stream(arr)
                .sum();
        long result = (long) Math.ceil((navg * (n + 1) - sum));
        if (result > 0) {
            return result;
        } else {
            throw new IllegalArgumentException("Result must be positive.");
        }
    }

    @Override
    public String seriesSum(int n) {
        double sum = IntStream.range(0, n)
                .mapToDouble(i -> 1.0 / (1 + 3 * i))
                .sum();
        return String.format("%.2f", sum);
    }
}
