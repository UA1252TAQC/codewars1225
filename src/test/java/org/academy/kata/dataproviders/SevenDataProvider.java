package org.academy.kata.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SevenDataProvider extends AbstractDataProvider {

    @DataProvider(name = "data-NewAvg")
    public static Iterator<Object[]> dpNewAvg() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{null, new double[]{14, 30, 5, 7, 9, 11, 15}, 30, 149L});
        inputs.add(new Object[]{null, new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645L});
        inputs.add(new Object[]{null, new double[]{14, 30, 5, 7, 9, 11, 15}, 30, 149L});
        inputs.add(new Object[]{null, new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645L});
        inputs.add(new Object[]{null, new double[]{10, 20, 30, 40}, 25.0, 25L});
        inputs.add(new Object[]{null, new double[]{5, 15, 25}, 20.0, 35L});
        inputs.add(new Object[]{IllegalArgumentException.class, new double[]{10, 20, 30}, 10.0, 35L});
        inputs.add(new Object[]{null, new double[]{10, 10, 10, 10}, 10.0, 10L});
        inputs.add(new Object[]{null, new double[]{}, 10, 10L});
        inputs.add(new Object[]{null, new double[]{10, 20, 30}, 25.0, 40L});

        return combineData(inputs, SEVEN);
    }

    @DataProvider(name = "data-SeriesSum")
    public static Iterator<Object[]> dpSeriesSum() {
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, "0.00"});
        inputs.add(new Object[]{1, "1.00"});
        inputs.add(new Object[]{2, "1.25"});
        inputs.add(new Object[]{5, "1.57"});

        return combineData(inputs, SEVEN);
    }

}
