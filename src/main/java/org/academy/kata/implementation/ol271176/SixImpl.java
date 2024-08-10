package org.academy.kata.implementation.ol271176;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        return "";
    }

    @Override
    public double f(double x) {
        return 0;
    }

    @Override
    public double mean(String town, String strng) {
        String[] cities = strng.split("\n");
        String townLine = null;
        for (String cityLine : cities) {
            String[] parts = cityLine.split(":");
            String city = parts[0];
            if (city.equals(town)) {
                townLine = parts[1];
                break;
            }
        }

        if (townLine == null) {
            return -1.0;
        }

        String[] townRecordsLine = townLine.replaceAll("[^0-9. ]", "").trim().split(" ");
        double[] townRecords = new double[townRecordsLine.length];
        for (int i = 0; i < townRecordsLine.length; i++) {
            townRecords[i] = Double.parseDouble(townRecordsLine[i]);
        }

        double sum = 0;
        for (double e : townRecords) {
            sum += e;
        }

        return sum / townRecords.length;
    }

    @Override
    public double variance(String town, String strng) {
        String[] cities = strng.split("\n");
        String townLine = null;
        for (String cityLine : cities) {
            String[] parts = cityLine.split(":");
            String city = parts[0];
            if (city.equals(town)) {
                townLine = parts[1];
                break;
            }
        }

        if (townLine == null) return -1.0;

        String[] townRecordsLine = townLine.replaceAll("[^0-9. ]", "").trim().split(" ");
        double[] townRecords = new double[townRecordsLine.length];
        for (int i = 0; i < townRecordsLine.length; i++) {
            townRecords[i] = Double.parseDouble(townRecordsLine[i]);
        }

        double mean = mean(town, strng);
        double sumOfSquares = 0;
        for (double e : townRecords) {
            sumOfSquares += (e - mean) * (e - mean);
        }

        return sumOfSquares / townRecords.length;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
