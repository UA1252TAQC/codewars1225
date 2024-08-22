package org.academy.kata.dataproviders;

import org.testng.annotations.DataProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiveDataProvider extends AbstractDataProvider {

    @DataProvider(name = "data-Smallest")
    public static Iterator<Object[]> dpFindSmallest(){
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{261235L, new long[]{126235L, 2L, 0L}});
        inputs.add(new Object[]{209917L, new long[]{29917L, 0L, 1L}});
        inputs.add(new Object[]{1000000L, new long[]{1L, 0L, 6L}});
        inputs.add(new Object[]{112233L, new long[]{112233L, -1, -1}});
        inputs.add(new Object[]{0L, new long[]{0L, -1, -1}});
        inputs.add(new Object[]{2341, new long[]{1234, 3, 0}});
        inputs.add(new Object[]{1442331L, new long[]{1144233L, 6L, 0L}});
        return combineData(inputs, FIVE);
    }

    @DataProvider(name = "data-Zeros")
    public static Iterator<Object[]> dpZeros(){
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{0, 0});
        inputs.add(new Object[]{6, 1});
        inputs.add(new Object[]{14, 2});
        inputs.add(new Object[]{100, 24});

        return combineData(inputs, FIVE);
    }

    @DataProvider(name = "data-gap")
    public static Iterator<Object[]> dpGap(){
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{2,100,110, new long[]{101,103}});
        inputs.add(new Object[]{4,100,110, new long[]{103,107}});
        inputs.add(new Object[]{6,100,110, null});
        inputs.add(new Object[]{8,300,400, new long[]{359,367}});
        inputs.add(new Object[]{10,300,400, new long[]{337,347}});
        inputs.add(new Object[]{2, 1, 1, null});
        inputs.add(new Object[]{2, 2, 2, null});
        inputs.add(new Object[]{2, 2, 2, null});
        inputs.add(new Object[]{2, 3, 3, null});
        inputs.add(new Object[]{2, 4, 5, null});

        return combineData(inputs, FIVE);
    }

    @DataProvider(name = "data-perimeter")
    public static Iterator<Object[]> dpPerimeter(){
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{BigInteger.valueOf(5), BigInteger.valueOf(80)});
        inputs.add(new Object[]{BigInteger.valueOf(7), BigInteger.valueOf(216)});
        inputs.add(new Object[]{BigInteger.valueOf(1), BigInteger.valueOf(8)});
        inputs.add(new Object[]{BigInteger.valueOf(10), BigInteger.valueOf(928)});
        inputs.add(new Object[]{BigInteger.valueOf(15), BigInteger.valueOf(10332)});

        return combineData(inputs, FIVE);
    }

    @DataProvider(name = "data-solve")
    public static Iterator<Object[]> whichXForThatSum(){
        final List<Object[]> inputs = new ArrayList<>();
        inputs.add(new Object[]{2.0, 0.5});
        inputs.add(new Object[]{4.0, 0.6096117967978});
        inputs.add(new Object[]{5.0, 0.6417424305044});
        inputs.add(new Object[]{6.0, 0.6666666666667});
        inputs.add(new Object[]{8.0, 0.7034648345914});
        inputs.add(new Object[]{10.0, 0.7298437881284});
        inputs.add(new Object[]{12.0, 0.75});
        inputs.add(new Object[]{13.0, 0.7584573119507});
        inputs.add(new Object[]{14.0, 0.7660773415975});
        inputs.add(new Object[]{17.0, 0.7850992981495});
        inputs.add(new Object[]{20.0, 0.8});
        inputs.add(new Object[]{50.0, 0.868225531212422});
        inputs.add(new Object[]{500000.0, 0.9985867860840736});

        return combineData(inputs, FIVE);
    }
}
