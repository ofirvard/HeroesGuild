package com.example.heroesguild;

import com.example.heroesguild.enums.AttackType;
import com.example.heroesguild.enums.EnemyType;
import com.example.heroesguild.enums.Sex;

public class Enemy {
    public EnemyType enemyType;

    public int ticksTillAttack;

    public int level;

    public int health;
    public int threat;

    public int strength;
    public int intellect;
    public int dexterity;

    public AttackType attackType;

    public Sex sex;

    public Enemy(EnemyType enemyType, int ticksTillAttack, int level, int health, int threat, int strength, int intellect, int dexterity, AttackType attackType, Sex sex) {
        this.enemyType = enemyType;
        this.ticksTillAttack = ticksTillAttack;
        this.level = level;
        this.health = health;
        this.threat = threat;
        this.strength = strength;
        this.intellect = intellect;
        this.dexterity = dexterity;
        this.attackType = attackType;
        this.sex = sex;
    }
}
