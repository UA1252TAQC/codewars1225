package org.academy.kata.dataprovider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiveDataProvider extends AbstractDataProvider {

    @DataProvider(name = "data-Smallest")
    public static Iterator<Object[]> dpFindSmallest(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{261235L, new long[]{126235L, 2L, 0L}});
        inputs.add(new Object[]{209917L, new long[]{29917L, 0L, 1L}});
        inputs.add(new Object[]{1000000L, new long[]{1L, 0L, 6L}});
        return combineData(inputs, FIVE);
    }

    @DataProvider(name = "data-Zeros")
    public static Iterator<Object[]> dpZeros(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 0});
        inputs.add(new Object[]{6, 1});
        inputs.add(new Object[]{14, 2});
        inputs.add(new Object[]{100, 24});

        return combineData(inputs, FIVE);
    }

    @DataProvider(name = "data-gap")
    public static Iterator<Object[]> dpGap(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{2,100,110, new long[]{101,103}});
        inputs.add(new Object[]{4,100,110, new long[]{103,107}});
        inputs.add(new Object[]{6,100,110, null});
        inputs.add(new Object[]{8,300,400, new long[]{359,367}});
        inputs.add(new Object[]{10,300,400, new long[]{337,347}});

        return combineData(inputs, FIVE);
    }
}
