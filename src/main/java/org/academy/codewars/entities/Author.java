package org.academy.codewars.entities;

import org.academy.kata.Eight;
import org.academy.kata.Five;
import org.academy.kata.Six;
import org.academy.kata.Seven;

import java.util.Arrays;
import java.util.List;

public enum Author {

    MARCHENKO2005("Marchenko Maria",
            new org.academy.kata.implementation.marchenko2005.FiveImpl(),
            new org.academy.kata.implementation.marchenko2005.SixImpl(),
            new org.academy.kata.implementation.marchenko2005.SevenImpl(),
            new org.academy.kata.implementation.marchenko2005.EightImpl()),

    ANDRIYVEL05("Velychko Andriy",
            new org.academy.kata.implementation.AndriyVel05.FiveImpl(),
            new org.academy.kata.implementation.AndriyVel05.SixImpl(),
            new org.academy.kata.implementation.AndriyVel05.SevenImpl(),
            new org.academy.kata.implementation.AndriyVel05.EightImpl()),

    MIHAILLL333("Turubarov Mykhailo",
            new org.academy.kata.implementation.Mihailll333.FiveImpl(),
            new org.academy.kata.implementation.Mihailll333.SixImpl(),
            new org.academy.kata.implementation.Mihailll333.SevenImpl(),
            new org.academy.kata.implementation.Mihailll333.EightImpl()),

    OL271176("Ponomarov Oleh",
            new org.academy.kata.implementation.ol271176.FiveImpl(),
            new org.academy.kata.implementation.ol271176.SixImpl(),
            new org.academy.kata.implementation.ol271176.SevenImpl(),
            new org.academy.kata.implementation.ol271176.EightImpl()),

    OLEKSANDRTKV("Tiekoiev Oleksandr",
            new org.academy.kata.implementation.oleksandrtkv.FiveImpl(),
            new org.academy.kata.implementation.oleksandrtkv.SixImpl(),
            new org.academy.kata.implementation.oleksandrtkv.SevenImpl(),
            new org.academy.kata.implementation.oleksandrtkv.EightImpl()),

    OYNE("Litvinov Andrii",
            new org.academy.kata.implementation.Oyne.FiveImpl(),
            new org.academy.kata.implementation.Oyne.SixImpl(),
            new org.academy.kata.implementation.Oyne.SevenImpl(),
            new org.academy.kata.implementation.Oyne.EightImpl()),
    ROCKETMAN2K21("Duda Roman",
            new org.academy.kata.implementation.RocketMan2k21.FiveImpl(),
            new org.academy.kata.implementation.RocketMan2k21.SixImpl(),
            new org.academy.kata.implementation.RocketMan2k21.SevenImpl(),
            new org.academy.kata.implementation.RocketMan2k21.EightImpl()
    ),
    SBEKBEROV("Bekberov Selim",
            new org.academy.kata.implementation.sbekberov.FiveImpl(),
            new org.academy.kata.implementation.sbekberov.SixImpl(),
            new org.academy.kata.implementation.sbekberov.SevenImpl(),
            new org.academy.kata.implementation.sbekberov.EightImpl()
    ),
    SHR1MPA("Syniuk Amina",
            new org.academy.kata.implementation.Shr1mpa.FiveImpl(),
            new org.academy.kata.implementation.Shr1mpa.SixImpl(),
            new org.academy.kata.implementation.Shr1mpa.SevenImpl(),
            new org.academy.kata.implementation.Shr1mpa.EightImpl()
    ),
    SMELOVD("Smelov Denys",
            new org.academy.kata.implementation.smelovd.FiveImpl(),
            new org.academy.kata.implementation.smelovd.SixImpl(),
            new org.academy.kata.implementation.smelovd.SevenImpl(),
            new org.academy.kata.implementation.smelovd.EightImpl()
    ),
    VLADYSLAVANEZHNOVA("Nezhnova Vladyslava",
            new org.academy.kata.implementation.VladyslavaNezhnova.FiveImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.SixImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.SevenImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.EightImpl()
    ),
    YANOLEKS("Yanytskyi Oleksandr",
            new org.academy.kata.implementation.YanOleks.FiveImpl(),
            new org.academy.kata.implementation.YanOleks.SixImpl(),
            new org.academy.kata.implementation.YanOleks.SevenImpl(),
            new org.academy.kata.implementation.YanOleks.EightImpl()
    );

    private final String name;
    private final Five five;
    private final Six six;
    private final Seven seven;
    private final Eight eight;

    Author(String name, Five five, Six six, Seven seven, Eight eight) {
        this.name = name;
        this.five = five;
        this.six = six;
        this.seven = seven;
        this.eight = eight;
    }

    public int getId() {
        return this.ordinal();
    }

    public String getName() {
        return name;
    }

    public Five getFive() {
        return five;
    }

    public Six getSix() {
        return six;
    }

    public Seven getSeven() {
        return seven;
    }

    public Eight getEight() {
        return eight;
    }

    public static List<Author> findAll() {
        return Arrays.asList(values());
    }

    public static Author findById(int id) {
        for (Author author: values()) {
            if(author.getId() == id) {
                return author;
            }
        }
        return null;
    }

}
