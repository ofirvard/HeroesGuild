package com.example.heroesguild.templates;

import com.example.heroesguild.enums.AttackType;
import com.example.heroesguild.enums.EnemyType;
import com.example.heroesguild.enums.Sex;

public class EnemyTemplate {//todo delete this, enemys will be loaded with quests
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
    //    List<Trait> traits;
// TODO: 9/28/2019 add resistances and damage types
}
