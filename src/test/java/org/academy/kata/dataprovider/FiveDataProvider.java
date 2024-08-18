package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiveDataProvider extends AbstractDataProvider {

    @DataProvider(name = "data-Zeros")
    public static Iterator<Object[]> dpZeros(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 0});
        inputs.add(new Object[]{6, 1});
        inputs.add(new Object[]{14, 2});
        inputs.add(new Object[]{100, 24});

        return combineData(inputs, FIVE);
    }
}
