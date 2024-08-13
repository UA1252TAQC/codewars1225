package org.academy.kata.implementation.YanOleks;

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
        double[] rawData = getRawData(town, strng);
        if (rawData.length < 12) return -1;
        double sum = 0;
        for(double number: rawData) sum += number;
        return sum / rawData.length;
    }

    @Override
    public double variance(String town, String strng) {
        double[] rawData = getRawData(town, strng);
        if (rawData.length < 12) return -1;
        double avg = mean(town, strng);
        double sum = 0;
        for(double number: rawData) sum += (number - avg) * (number - avg);
        return sum / rawData.length;
    }

    private static double[] getRawData(String town, String data){
        System.out.println(town);
        System.out.println(data);
        int numberOfMonths = 12;
        int beginIndex = data.indexOf(town + ":");
        if (beginIndex == -1) return new double[0];
        int endIndex = data.indexOf("\n", beginIndex);
        if (endIndex == -1) endIndex = data.length();
        String townData = data.substring(beginIndex, endIndex);
        String[] numbers = townData.split("[^\\d.]+");
        double[] rawData = new double[numberOfMonths];
        for (int i = 1; i <= numberOfMonths; i++){
            rawData[i - 1] = Double.parseDouble(numbers[i]);
        }
        return rawData;
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
