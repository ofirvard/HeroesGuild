package com.example.heroesguild;

import java.util.List;
import java.util.UUID;

public class Hero
{
    String id;
    String name;
    HeroBuilder.HeroClass heroClass;
    HeroBuilder.Sex sex;
//    List<Trait> traits;
    //// TODO: 9/25/19 add resistances

    private int level;
    private int experienceToNextLevel;

    private int ticksTillAttack;

    private int currentHealth;

    private Stats stats;

    public Hero(String name, HeroBuilder.HeroClass heroClass, HeroBuilder.Sex sex, int level, int experienceToNextLevel, int ticksTillAttack, Stats stats)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.heroClass = heroClass;
        this.sex = sex;
        this.level = level;
        this.experienceToNextLevel = experienceToNextLevel;
        this.ticksTillAttack = ticksTillAttack;
        this.stats = stats;
        this.currentHealth = getMaxHealth();
    }

    public int getMaxHealth()
    {
        return this.stats.getHealth() * 10;
    }

    @Override
    public String toString()
    {
        return "Hero{" +
//                "id='" + id + '\'' +
//                ", name='" + name + '\'' +
//                ", heroClass=" + heroClass +
//                ", sex=" + sex +
//                ", level=" + level +
//                ", experienceToNextLevel=" + experienceToNextLevel +
//                ", ticksTillAttack=" + ticksTillAttack +
                ", stats=" + stats +
                '}';
    }
}
