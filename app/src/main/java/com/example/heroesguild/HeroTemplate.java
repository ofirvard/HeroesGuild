package com.example.heroesguild;

import java.util.ArrayList;
import java.util.List;

public class HeroTemplate {
    HeroBuilder.HeroClass heroClass;
    String className;
    double experienceMultiplier;

    int ticksTillAttack;

    int healthGrowth;
    int threatGrowth;

    int strengthGrowth;
    int intellectGrowth;
    int dexterityGrowth;

    List<HeroBuilder.Sex> sexes;
    List<Trait> traits;

}
