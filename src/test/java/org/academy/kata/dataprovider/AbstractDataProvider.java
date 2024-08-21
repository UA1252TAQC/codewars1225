package org.academy.kata.dataprovider;

import org.academy.kata.Eight;
import org.academy.kata.Five;
import org.academy.kata.Seven;
import org.academy.kata.Six;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class AbstractDataProvider {
    protected static final List<Five> FIVE = List.of(
            new org.academy.kata.implementation.AndriyVel05.FiveImpl(),
            new org.academy.kata.implementation.marchenko2005.FiveImpl(),
            //new org.academy.kata.implementation.Mihailll333.FiveImpl(),
            new org.academy.kata.implementation.ol271176.FiveImpl(),
            new org.academy.kata.implementation.oleksandrtkv.FiveImpl(),
            //new org.academy.kata.implementation.Oyne.FiveImpl(),
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
            //new org.academy.kata.implementation.Mihailll333.SixImpl(),
            new org.academy.kata.implementation.ol271176.SixImpl(),
            new org.academy.kata.implementation.oleksandrtkv.SixImpl(),
            //new org.academy.kata.implementation.Oyne.SixImpl(),
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
            new org.academy.kata.implementation.AndriyVel05.EightImpl(),
            new org.academy.kata.implementation.marchenko2005.EightImpl(),
            //new org.academy.kata.implementation.Mihailll333.EightImpl(),
            new org.academy.kata.implementation.ol271176.EightImpl(),
            new org.academy.kata.implementation.oleksandrtkv.EightImpl(),
            //new org.academy.kata.implementation.Oyne.EightImpl(),
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
            for (Object[] o : objects) {
                data.add(Stream.concat(Stream.of(impl), Arrays.stream(o).map(obj -> {
                            if (obj == null) return null;
                            if (obj.getClass().isArray()) {
                                var componentType = obj.getClass().getComponentType();
                                if (componentType.isPrimitive()) {
                                    if (componentType == int.class) {
                                        return Arrays.copyOf((int[]) obj, Array.getLength(obj));
                                    } else if (componentType == double.class) {
                                        return Arrays.copyOf((double[]) obj, Array.getLength(obj));
                                    } else if (componentType == float.class) {
                                        return Arrays.copyOf((float[]) obj, Array.getLength(obj));
                                    } else if (componentType == long.class) {
                                        return Arrays.copyOf((long[]) obj, Array.getLength(obj));
                                    } else if (componentType == short.class) {
                                        return Arrays.copyOf((short[]) obj, Array.getLength(obj));
                                    } else if (componentType == byte.class) {
                                        return Arrays.copyOf((byte[]) obj, Array.getLength(obj));
                                    } else if (componentType == char.class) {
                                        return Arrays.copyOf((char[]) obj, Array.getLength(obj));
                                    } else if (componentType == boolean.class) {
                                        return Arrays.copyOf((boolean[]) obj, Array.getLength(obj));
                                    }
                                } else {
                                    return Arrays.copyOf((Object[]) obj, Array.getLength(obj));
                                }
                            }
                            return obj;
                        })
                ).toArray(Object[]::new));
            }
        }
        return data.iterator();
    }
}