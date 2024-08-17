package org.academy.kata.dataprovider;

import org.academy.kata.Eight;
import org.academy.kata.Five;
import org.academy.kata.Seven;
import org.academy.kata.Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class AbstractDataProvider {
    protected static final List<Five> FIVE = List.of(
            new org.academy.kata.implementation.AndriyVel05.FiveImpl(),
            new org.academy.kata.implementation.marchenko2005.FiveImpl(),
            new org.academy.kata.implementation.Mihailll333.FiveImpl(),
            new org.academy.kata.implementation.ol271176.FiveImpl(),
            new org.academy.kata.implementation.oleksandrtkv.FiveImpl(),
            new org.academy.kata.implementation.Oyne.FiveImpl(),
            //new org.academy.kata.implementation.RocketMan2k21.FiveImpl(),
            new org.academy.kata.implementation.sbekberov.FiveImpl(),
            new org.academy.kata.implementation.Shr1mpa.FiveImpl(),
            new org.academy.kata.implementation.smelovd.FiveImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.FiveImpl(),
            new org.academy.kata.implementation.YanOleks.FiveImpl()
    );
    protected static final List<Six> SIX = List.of(
            new org.academy.kata.implementation.AndriyVel05.SixImpl(),
            new org.academy.kata.implementation.marchenko2005.SixImpl(),
            new org.academy.kata.implementation.Mihailll333.SixImpl(),
            new org.academy.kata.implementation.ol271176.SixImpl(),
            new org.academy.kata.implementation.oleksandrtkv.SixImpl(),
            new org.academy.kata.implementation.Oyne.SixImpl(),
            //new org.academy.kata.implementation.RocketMan2k21.SixImplSixImpl(),
            new org.academy.kata.implementation.sbekberov.SixImpl(),
            new org.academy.kata.implementation.Shr1mpa.SixImpl(),
            new org.academy.kata.implementation.smelovd.SixImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.SixImpl(),
            new org.academy.kata.implementation.YanOleks.SixImpl()
    );
    protected static final List<Seven> SEVEN = List.of(
            new org.academy.kata.implementation.AndriyVel05.SevenImpl(),
            new org.academy.kata.implementation.marchenko2005.SevenImpl(),
            new org.academy.kata.implementation.Mihailll333.SevenImpl(),
            new org.academy.kata.implementation.ol271176.SevenImpl(),
            new org.academy.kata.implementation.oleksandrtkv.SevenImpl(),
            new org.academy.kata.implementation.Oyne.SevenImpl(),
            //new org.academy.kata.implementation.RocketMan2k21.SevenImpl(),
            new org.academy.kata.implementation.sbekberov.SevenImpl(),
            new org.academy.kata.implementation.Shr1mpa.SevenImpl(),
            new org.academy.kata.implementation.smelovd.SevenImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.SevenImpl(),
            new org.academy.kata.implementation.YanOleks.SevenImpl()
    );
    protected static final List<Eight> EIGHT = List.of(
            //new org.academy.kata.implementation.AndriyVel05.EightImpl(),
            new org.academy.kata.implementation.marchenko2005.EightImpl(),
            //new org.academy.kata.implementation.Mihailll333.EightImpl(),
            new org.academy.kata.implementation.ol271176.EightImpl(),
            new org.academy.kata.implementation.oleksandrtkv.EightImpl(),
            new org.academy.kata.implementation.Oyne.EightImpl(),
            //new org.academy.kata.implementation.RocketMan2k21.EightImpl(),
            new org.academy.kata.implementation.sbekberov.EightImpl(),
            new org.academy.kata.implementation.Shr1mpa.EightImpl(),
            new org.academy.kata.implementation.smelovd.EightImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.EightImpl(),
            new org.academy.kata.implementation.YanOleks.EightImpl()
    );


    protected static Iterator<Object[]> combineData(List<Object[]> objects, List<?> impls) {
        List<Object[]> data = new ArrayList<>();
        for (Object impl : impls) {
            objects.forEach(o -> data.add(Stream.concat(Stream.of(impl), Arrays.stream(o)).toArray()));
        }
        return data.iterator();
    }
}
