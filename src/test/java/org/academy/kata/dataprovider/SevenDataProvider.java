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
