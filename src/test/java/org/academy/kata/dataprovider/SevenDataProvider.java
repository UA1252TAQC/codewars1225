package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SevenDataProvider extends AbstractDataProvider {

    @DataProvider(name = "data-nth-series")
    public static Iterator<Object[]> seriesSum() {
        List<Object[]> inputs = new ArrayList<>();

        return combineData(inputs, SEVEN);
    }

}
