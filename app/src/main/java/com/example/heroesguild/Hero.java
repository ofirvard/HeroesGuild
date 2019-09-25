package com.example.heroesguild;

import java.util.List;

public class Hero {
    int id;
    String name;
    HeroBuilder.HeroClass heroClass;
    HeroBuilder.Sex sex;
    List<Trait> traits;
    //// TODO: 9/25/19 add resistances

    private int level;
    private int experienceToNextLevel;

    private int secretPointBonus;

    private int health;
    private int threat;
    private int ticksTillAttack;

    private int strength;
    private int intellect;
    private int dexterity;

    int healthGrowth;
    int threatGrowth;
    int strengthGrowth;
    int intellectGrowth;
    int dexterityGrowth;

    public Hero(int id, String name, HeroBuilder.HeroClass heroClass, HeroBuilder.Sex sex, List<Trait> traits, int level,
                int experienceToNextLevel, int secretPointBonus, int ticksTillAttack, int healthGrowth, int threatGrowth, int strengthGrowth,
                int intellectGrowth, int dexterityGrowth) {
        this.id = id;
        this.name = name;
        this.heroClass = heroClass;
        this.sex = sex;
        this.traits = traits;
        this.level = level;
        this.experienceToNextLevel = experienceToNextLevel;
        this.secretPointBonus = secretPointBonus;
        this.health = health;
        this.threat = threat;
        this.ticksTillAttack = ticksTillAttack;
        this.strength = strength;
        this.intellect = intellect;
        this.dexterity = dexterity;
        this.healthGrowth = healthGrowth;
        this.threatGrowth = threatGrowth;
        this.strengthGrowth = strengthGrowth;
        this.intellectGrowth = intellectGrowth;
        this.dexterityGrowth = dexterityGrowth;
    }
}
