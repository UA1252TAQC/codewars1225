package org.academy.kata.implementation.ol271176;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
