package org.academy.kata;

public interface Six {
    long findNb(long m);

    String balance(String book);

    double f(double x);

    public static double mean(String town, String strng) {
        String[] records = strng.split("/n");
        for (String record : records) {
            if (record.startsWith(town + ":")) {
                double[] rainfall = Arrays.stream(record.replace(town + ":", "").split(","))
                        .mapToDouble(r -> Double.parseDouble(r.split(" ")[1]))
                        .toArray();
                return Arrays.stream(rainfall).average().orElse(-1);
            }
        }

        return -1;
    }

    public static double variance(String town, String strng) {
        double avg = mean(town, strng);
        if (avg == -1) return -1;

        String[] records = strng.split("\n");
        for (String.record : records) {
            if (record.startsWith(town + ":")) {
                double[] rainfall = Arrays.stream(record.replace(town + ":", "").split(","))
                        .mapToDouble(r -> Double.parseDouble(r.split(" ")[1]))
                        .toArray();
                double variance = Arrays.stream(rainfall)
                        .map(r -> Math.pow(r - avg, 2))
f                       .average()
                        .orElse(-1);
                return variance;
            }
        }

        return -1;
    }

    String nbaCup(String resultSheet, String toFind);

    String stockSummary(String[] lstOfArt, String[] lstOf1stLetter);
}
