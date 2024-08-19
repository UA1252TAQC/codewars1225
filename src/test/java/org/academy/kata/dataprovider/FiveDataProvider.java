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
}
