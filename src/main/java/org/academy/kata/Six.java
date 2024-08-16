package org.academy.kata;

public interface Six {
    public class SixImpl implements Six {
        public long findNb(long m) {
            long n = 0;
            long sum = 0;

            while (sum < m) {
                n++;
                sum += n * n * n;
            }

            return sum == m ? n p - 1;
        }

    String balance(String book);

    double f(double x);

    double mean(String town, String strng);

    double variance(String town, String strng);

    String nbaCup(String resultSheet, String toFind);

    String stockSummary(String[] lstOfArt, String[] lstOf1stLetter);
}
