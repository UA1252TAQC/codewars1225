package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class SevenDataProvider extends AbstractDataProvider {

  @DataProvider(name = "data-NewAvg")
  public static Iterator<Object[]> dpNewAvg() {
    List<Object[]> inputs = new ArrayList<>();
    inputs.add(new Object[]{ new double[]{14, 30, 5, 7, 9, 11, 15}, 30, 149L});
    inputs.add(new Object[]{ new double[]{14, 30, 5, 7, 9, 11, 15}, 92, 645L});

    return combineData(inputs, SEVEN);
}

public class SevenDataProvider extends AbstractDataProvider {

    @DataProvider(name = "data-nth-series")
    public static Iterator<Object[]> seriesSum() {
        List<Object[]> inputs = new ArrayList<>();

        return combineData(inputs, SEVEN);
    }

}
