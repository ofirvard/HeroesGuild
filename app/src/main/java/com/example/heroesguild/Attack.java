package com.example.heroesguild;

import com.example.heroesguild.enums.AttackType;

public class Attack {

    private double strengthPercent;
    private double intellectPercent;
    private double dexterityPercent;

    private AttackType attackType;

    public Attack(double strengthPercent, double intellectPercent, double dexterityPercent, AttackType attackType) {
        this.strengthPercent = strengthPercent;
        this.intellectPercent = intellectPercent;
        this.dexterityPercent = dexterityPercent;
        this.attackType = attackType;
    }

    public AttackType getAttackType() {
        return attackType;
    }

    public int getAttack(Stats stats) {
        return (int) Math.round(getStrengthAttack(stats.getStrength()) +
                getIntellectAttack(stats.getIntellect()) +
                getDexterityAttack(stats.getDexterity()));
    }

    private double getStrengthAttack(int strength) {
        return strengthPercent * (double) strength;
    }

    private double getIntellectAttack(int intellect) {
        return intellectPercent * (double) intellect;
    }

    private double getDexterityAttack(int dexterity) {
        return dexterityPercent * (double) dexterity;
    }
}
