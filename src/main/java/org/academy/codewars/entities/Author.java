package org.academy.codewars.entities;

import org.academy.kata.Eight;
import org.academy.kata.Five;
import org.academy.kata.Six;
import org.academy.kata.Seven;

public enum Author {

    MARCHENKO2005(1, "Marchenko Maria",
            new org.academy.kata.implementation.marchenko2005.FiveImpl(),
            new org.academy.kata.implementation.marchenko2005.SixImpl(),
            new org.academy.kata.implementation.marchenko2005.SevenImpl(),
            new org.academy.kata.implementation.marchenko2005.EightImpl()),

    ANDRIYVEL05(2, "Velychko Andriy",
            new org.academy.kata.implementation.AndriyVel05.FiveImpl(),
            new org.academy.kata.implementation.AndriyVel05.SixImpl(),
            new org.academy.kata.implementation.AndriyVel05.SevenImpl(),
            new org.academy.kata.implementation.AndriyVel05.EightImpl()),

    MIHAILLL333(3, "Turubarov Mykhailo",
            new org.academy.kata.implementation.Mihailll333.FiveImpl(),
            new org.academy.kata.implementation.Mihailll333.SixImpl(),
            new org.academy.kata.implementation.Mihailll333.SevenImpl(),
            new org.academy.kata.implementation.Mihailll333.EightImpl()),

    OL271176(4, "Ponomarov Oleh",
            new org.academy.kata.implementation.ol271176.FiveImpl(),
            new org.academy.kata.implementation.ol271176.SixImpl(),
            new org.academy.kata.implementation.ol271176.SevenImpl(),
            new org.academy.kata.implementation.ol271176.EightImpl()),

    OLEKSANDRTKV(5, "Tiekoiev Oleksandr",
            new org.academy.kata.implementation.oleksandrtkv.FiveImpl(),
            new org.academy.kata.implementation.oleksandrtkv.SixImpl(),
            new org.academy.kata.implementation.oleksandrtkv.SevenImpl(),
            new org.academy.kata.implementation.oleksandrtkv.EightImpl()),

    OYNE(6, "Litvinov Andrii",
            new org.academy.kata.implementation.Oyne.FiveImpl(),
            new org.academy.kata.implementation.Oyne.SixImpl(),
            new org.academy.kata.implementation.Oyne.SevenImpl(),
            new org.academy.kata.implementation.Oyne.EightImpl()),
    ROCKETMAN2K21(7, "Duda Roman",
            new org.academy.kata.implementation.RocketMan2k21.FiveImpl(),
            new org.academy.kata.implementation.RocketMan2k21.SixImpl(),
            new org.academy.kata.implementation.RocketMan2k21.SevenImpl(),
            new org.academy.kata.implementation.RocketMan2k21.EightImpl()
    ),
    SBEKBEROV(8, "Bekberov Selim",
            new org.academy.kata.implementation.sbekberov.FiveImpl(),
            new org.academy.kata.implementation.sbekberov.SixImpl(),
            new org.academy.kata.implementation.sbekberov.SevenImpl(),
            new org.academy.kata.implementation.sbekberov.EightImpl()
    ),
    SHR1MPA(9, "Syniuk Amina",
            new org.academy.kata.implementation.Shr1mpa.FiveImpl(),
            new org.academy.kata.implementation.Shr1mpa.SixImpl(),
            new org.academy.kata.implementation.Shr1mpa.SevenImpl(),
            new org.academy.kata.implementation.Shr1mpa.EightImpl()
    ),
    SMELOVD(10, "Smelov Denys",
            new org.academy.kata.implementation.smelovd.FiveImpl(),
            new org.academy.kata.implementation.smelovd.SixImpl(),
            new org.academy.kata.implementation.smelovd.SevenImpl(),
            new org.academy.kata.implementation.smelovd.EightImpl()
    ),
    VLADYSLAVANEZHNOVA(11, "Nezhnova Vladyslava",
            new org.academy.kata.implementation.VladyslavaNezhnova.FiveImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.SixImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.SevenImpl(),
            new org.academy.kata.implementation.VladyslavaNezhnova.EightImpl()
    ),
    YANOLEKS(12, "Yanytskyi Oleksandr",
            new org.academy.kata.implementation.YanOleks.FiveImpl(),
            new org.academy.kata.implementation.YanOleks.SixImpl(),
            new org.academy.kata.implementation.YanOleks.SevenImpl(),
            new org.academy.kata.implementation.YanOleks.EightImpl()
    );

    private final int id;
    private final String name;
    private final Five five;
    private final Six six;
    private final Seven seven;
    private final Eight eight;

    Author(int id, String name, Five five, Six six, Seven seven, Eight eight) {
        this.id = id;
        this.name = name;
        this.five = five;
        this.six = six;
        this.seven = seven;
        this.eight = eight;
    }

    // Гетери для полів
    public int getId() {
        return id;
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

}
