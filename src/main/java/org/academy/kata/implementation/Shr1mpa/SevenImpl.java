package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Seven;
import java.util.stream.IntStream;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        double sum = IntStream.range(0, n)
                .mapToDouble(i -> 1.0 / (1 + 3 * i))
                .sum();
        return String.format("%.2f", sum);
    }
}
