package com.example.heroesguild;

import com.example.heroesguild.enums.Stat;

public class Stats {
    private final int BASE_POINTS_PER_LEVEL = 50;

    private int secretPointBonus;


    private int health;
    private int threat;

    private int strength;
    private int intellect;
    private int dexterity;

    private int healthGrowth;
    private int threatGrowth;

    private int strengthGrowth;
    private int intellectGrowth;
    private int dexterityGrowth;

    public void increaseStatGrowthByOne(Stat stat) {
        switch (stat) {
            case HEALTH:
                healthGrowth += 3;
            case THREAT:
                threatGrowth += 3;
            case STRENGTH:
                strengthGrowth += 3;
            case DEXTERITY:
                dexterityGrowth += 3;
            case INTELLECT:
                intellectGrowth += 3;
        }
    }

    public Stats(int secretPointBonus, int healthGrowth, int threatGrowth, int strengthGrowth, int intellectGrowth, int dexterityGrowth) {
        this.secretPointBonus = secretPointBonus;
        this.healthGrowth = healthGrowth;
        this.threatGrowth = threatGrowth;
        this.strengthGrowth = strengthGrowth;
        this.intellectGrowth = intellectGrowth;
        this.dexterityGrowth = dexterityGrowth;

        this.health = 0;
        this.threat = 0;
        this.strength = 0;
        this.intellect = 0;
        this.dexterity = 0;
    }

    public void levelUpStats() {
        int pointsToSpend = BASE_POINTS_PER_LEVEL + secretPointBonus;
        int totalGrowth = this.healthGrowth +
                this.threatGrowth +
                this.strengthGrowth +
                this.intellectGrowth +
                this.dexterityGrowth;

        this.health += Math.round((double) this.healthGrowth / (double) totalGrowth * pointsToSpend);
        this.threat += Math.round((double) this.threatGrowth / (double) totalGrowth * pointsToSpend);
        this.strength += Math.round((double) this.strengthGrowth / (double) totalGrowth * pointsToSpend);
        this.intellect += Math.round((double) this.intellectGrowth / (double) totalGrowth * pointsToSpend);
        this.dexterity += Math.round((double) this.dexterityGrowth / (double) totalGrowth * pointsToSpend);
    }

    public int getHealth() {
        return health;
    }

    public int getThreat() {
        return threat;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getDexterity() {
        return dexterity;
    }

    @Override
    public String toString() {
        return "Stats{" +
                ", secretPointBonus=" + secretPointBonus +
                ", health=" + health +
                ", threat=" + threat +
                ", strength=" + strength +
                ", intellect=" + intellect +
                ", dexterity=" + dexterity +
                ", total points=" + (health + threat + strength + intellect + dexterity) +
//                ", healthGrowth=" + healthGrowth +
//                ", threatGrowth=" + threatGrowth +
//                ", strengthGrowth=" + strengthGrowth +
//                ", intellectGrowth=" + intellectGrowth +
//                ", dexterityGrowth=" + dexterityGrowth +
//                ", total growth=" + (healthGrowth + threatGrowth + strengthGrowth + intellectGrowth + dexterityGrowth) +
                '}';
    }
}
