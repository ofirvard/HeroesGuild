package com.example.heroesguild;

import com.example.heroesguild.enums.AttackType;
import com.example.heroesguild.enums.HeroClass;
import com.example.heroesguild.enums.Sex;

import java.util.UUID;


public class Hero {
    String id;
    String name;
    HeroClass heroClass;
    Sex sex;
    //    List<Trait> traits;
    public Resistances resistances;

    private int level;
    private int experienceToNextLevel;

    private int ticksTillAttack;

    private int currentHealth;

    private Stats stats;
    private Attack attack;

    public Hero(String name, HeroClass heroClass, Sex sex, int level, int experienceToNextLevel,
                int ticksTillAttack, Stats stats, Attack attack, Resistances resistances) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.heroClass = heroClass;
        this.sex = sex;
        this.level = level;
        this.experienceToNextLevel = experienceToNextLevel;
        this.ticksTillAttack = ticksTillAttack;
        this.stats = stats;
        this.currentHealth = getMaxHealth();
        this.attack = attack;
        this.resistances = resistances;
    }

    public int getMaxHealth() {
        return this.stats.getHealth() * 10;
    }

    public void levelUpStats() {
        stats.levelUpStats();
        this.currentHealth = getMaxHealth();
    }

    public int getAttack() {
        return this.attack.getAttack(this.stats);
    }

    public AttackType geAttackType() {
        return this.attack.getAttackType();
    }

    public double getResistance(AttackType attackType) {
        return resistances.getResistance(attackType);
    }

    public void levelUpOne() {
        this.level++;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getLevel() {
        return level;
    }

    public int getTicksTillAttack() {
        return ticksTillAttack;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Stats getStats() {
        return stats;
    }

    public HeroClass getHeroClass() {
        return heroClass;
    }

    public void setExperienceToNextLevel(int experienceToNextLevel) {
        this.experienceToNextLevel = experienceToNextLevel;
    }

    @Override
    public String toString() {
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
