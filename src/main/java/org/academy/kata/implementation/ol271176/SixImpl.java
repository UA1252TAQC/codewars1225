package org.academy.kata.implementation.ol271176;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        int n = 1;
        long totalVolume = 0;

        while(m > totalVolume){
            totalVolume += Math.pow(n++, 3);
        }
        n--;

        return totalVolume == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        // Delete empty lines
        String[] lines = book.split("\n");
        StringBuilder result = new StringBuilder();

        // Find balance
        double balance = Double.parseDouble(lines[0].replaceAll("[^0-9.]", ""));
        result.append(String.format("Original Balance: %.2f\\r\\n", balance));
        double totalExpense = 0, avgExpense = 0, count = 0;

        // Process each line
        for (int i = 1; i < lines.length; i++) {
            String proccessedLine = lines[i].replaceAll("[^a-zA-Z0-9. ]", "");

            if (proccessedLine.isEmpty()) continue;

            String[] info = proccessedLine.split(" ");
            int checkNumber = Integer.parseInt(info[0]);
            String category = info[1];
            double checkAmount = Double.parseDouble(info[2]);
            double totalAmount = balance - checkAmount;
            balance -= checkAmount;

            totalExpense += checkAmount;
            count++;

            result.append(String.format("%d %s %.2f Balance %.2f\\r\\n", checkNumber, category, checkAmount, balance));
        }
        result.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        result.append(String.format("Average expense  %.2f", totalExpense / count));

        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
    }

    @Override
    public double mean(String town, String strng) {
        return 0;
    }

    @Override
    public double variance(String town, String strng) {
        return 0;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        Map<Character, Integer> mapOfBooks = new LinkedHashMap<>();
        for(String letter : lstOf1stLetter) mapOfBooks.put(letter.charAt(0), 0);

        Pattern pattern = Pattern.compile("(\\D+)\\s(\\d+)");
        for(String bookInfo : lstOfArt){
            Matcher matcher = pattern.matcher(bookInfo);
            if(matcher.find()){
                char key = matcher.group(1).charAt(0);
                int value = Integer.parseInt(matcher.group(2));
                if(mapOfBooks.containsKey(key)){
                    mapOfBooks.put(key, mapOfBooks.get(key) + value);
                } else {
                    continue;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character, Integer> entry : mapOfBooks.entrySet()){
            if (sb.length() > 0) sb.append(" - ");
            sb.append(String.format("(%c : %d)", entry.getKey(), entry.getValue()));

        }

        return sb.toString();
    }
}
