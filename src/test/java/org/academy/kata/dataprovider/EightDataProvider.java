package org.academy.kata.dataprovider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EightDataProvider extends AbstractDataProvider {

    @DataProvider(name = "data-Liters")
    public static Iterator<Object[]> dpLiters(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{80, 40});
        inputs.add(new Object[]{1600.20, 800});
        inputs.add(new Object[]{14.64, 7});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-SquareOrSquareRoot")
    public static Iterator<Object[]> dpSquareOrSquareRoot(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{new int[] { 4, 3, 9, 7, 2, 1 }, new int[] { 2, 9, 3, 49, 4, 1 }});
        inputs.add(new Object[]{new int[] { 100, 101, 5, 5, 1, 1 }, new int[] { 10, 10201, 25, 25, 1, 1 }});
        inputs.add(new Object[]{new int[] { 1, 2, 3, 4, 5, 6 }, new int[] { 1, 4, 9, 2, 25, 36 }});

        return combineData(inputs, EIGHT);
    }

    @DataProvider(name = "data-stringToNumber")
    public static Iterator<Object[]> dpStringToNumber(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{"1234", 1234});
        inputs.add(new Object[]{"605", 605});
        inputs.add(new Object[]{"1405", 1405});
        inputs.add(new Object[]{"-7", -7});

        return combineData(inputs, EIGHT);
    }
}
