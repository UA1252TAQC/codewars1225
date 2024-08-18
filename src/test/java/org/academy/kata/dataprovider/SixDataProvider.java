package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SixDataProvider extends AbstractDataProvider {
    @DataProvider(name = "data-findNb")
    public static Iterator<Object[]> dpFindNb(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{1071225L, 45});
        inputs.add(new Object[]{91716553919377L, -1});
        inputs.add(new Object[]{135440716410000L, 4824});

        return combineData(inputs, SIX);
    }
}
