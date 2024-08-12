package org.academy.kata.implementation.oleksandrtkv;

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
        double[] rainfallData = getRainfallData(town, strng);
        if (rainfallData == null) {
            return -1;
        }

        double sum = 0;
        for (double rainfall : rainfallData) {
            sum += rainfall;
        }

        return sum / rainfallData.length;
    }

    @Override
    public double variance(String town, String strng) {
        double[] rainfallData = getRainfallData(town, strng);
        if (rainfallData == null) {
            return -1;
        }

        double meanValue = mean(town, strng);

        double sum = 0;
        for (double rainfall : rainfallData) {
            sum += Math.pow(rainfall - meanValue, 2);
        }

        return sum / rainfallData.length;
    }

    private double[] getRainfallData(String town, String strng) {
        String[] townData = strng.split("\n");
        for (String data : townData) {
            if (data.startsWith(town + ":")) {
                String[] monthlyData = data.split(":")[1].split(",");
                double[] rainfall = new double[monthlyData.length];
                for (int i = 0; i < monthlyData.length; i++) {
                    rainfall[i] = Double.parseDouble(monthlyData[i].split(" ")[1]);
                }
                return rainfall;
            }
        }
        return null;
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
