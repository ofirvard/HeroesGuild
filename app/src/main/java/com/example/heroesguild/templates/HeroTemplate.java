package com.example.heroesguild.templates;

import com.example.heroesguild.Resistances;
import com.example.heroesguild.enums.AttackType;
import com.example.heroesguild.enums.HeroClass;
import com.example.heroesguild.enums.Sex;

import java.util.List;

public class HeroTemplate {
    public HeroClass heroClass;
    public String className;
    public double experienceMultiplier;

    public int ticksTillAttack;

    public int healthGrowth;
    public int threatGrowth;

    public int strengthGrowth;
    public int intellectGrowth;
    public int dexterityGrowth;

    public double strengthPercent;
    public double intellectPercent;
    public double dexterityPercent;

    public AttackType attackType;

    public List<Sex> sexes;
    //    List<Trait> traits;
    public Resistances resistances;
}
