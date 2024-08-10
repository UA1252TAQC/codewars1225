package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Six;
import java.util.HashMap;

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
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";
        HashMap<Character, Integer> map = getCharacterIntegerHashMap(lstOfArt, lstOf1stLetter);
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Character, Integer> set: map.entrySet()){
            sb.append(String.format("(%c : %d) - ", set.getKey(), set.getValue()));
        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.toString();
    }
    private static HashMap<Character, Integer> getCharacterIntegerHashMap(String[] lstOfArt, String[] lstOf1stLetter) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(String category: lstOf1stLetter){
            map.put(category.charAt(0), 0);
        }
        for (String book: lstOfArt){
            char category = book.charAt(0);
            if (map.containsKey(category)){
                int lastSpace = book.lastIndexOf(' ');
                int numberOfBooks = Integer.parseInt(book.substring(lastSpace + 1));
                map.put(category, map.get(category) + numberOfBooks);
            }
        }
        return map;
    }
}
