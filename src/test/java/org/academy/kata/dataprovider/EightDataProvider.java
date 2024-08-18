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

    @DataProvider(name = "data-decimal-places")
    public static Iterator<Object[]> dpDecimalPlaces(){
        List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{5.5589, 5.56});
        inputs.add(new Object[]{3.3424, 3.34});
        inputs.add(new Object[]{7.1234, 7.12});
        inputs.add(new Object[]{1.9999, 2.00});
        inputs.add(new Object[]{0.005, 0.01});
        inputs.add(new Object[]{-2.678, -2.68});
        inputs.add(new Object[]{-256789.567890, -256789.57});
        inputs.add(new Object[]{100.0049, 100.00});
        inputs.add(new Object[]{0.0, 0.00});

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
