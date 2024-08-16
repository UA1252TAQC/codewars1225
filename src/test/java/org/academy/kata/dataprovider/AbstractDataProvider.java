package org.academy.kata.dataprovider;

import org.academy.kata.Eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class AbstractDataProvider {
    protected static final List<Eight> EIGHT = List.of(
            new org.academy.kata.implementation.Oyne.EightImpl(),
            new org.academy.kata.implementation.marchenko2005.EightImpl(),
            new org.academy.kata.implementation.smelovd.EightImpl()
    );


    protected static Iterator<Object[]> combineData(List<Object[]> objects, List impls){
        List<Object[]> data = new ArrayList<>();
        for(Object impl: impls){
            objects.forEach(o ->data.add(Stream.concat(Stream.of(impl), Arrays.stream(o)).toArray()));
        }
        return  data.iterator();
    }
}
