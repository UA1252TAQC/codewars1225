package org.academy.kata.dataprovider;

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

    @DataProvider(name = "data-Wilson")
    public static Iterator<Object[]> dpWilson(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{-1, false});
        inputs.add(new Object[]{1, false});
        inputs.add(new Object[]{1.1, false});
        inputs.add(new Object[]{2, false});
        inputs.add(new Object[]{5, true});
        inputs.add(new Object[]{13, true});
        inputs.add(new Object[]{12, false});
        inputs.add(new Object[]{563, true});
        inputs.add(new Object[]{562, false});

        return combineData(inputs, EIGHT);
    }
}
