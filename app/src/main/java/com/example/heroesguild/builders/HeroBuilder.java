package com.example.heroesguild.builders;

import android.content.Context;

import com.example.heroesguild.Attack;
import com.example.heroesguild.Hero;
import com.example.heroesguild.Resistances;
import com.example.heroesguild.templates.HeroTemplate;
import com.example.heroesguild.JsonReadWrite;
import com.example.heroesguild.Stats;
import com.example.heroesguild.enums.HeroClass;
import com.example.heroesguild.enums.Sex;
import com.example.heroesguild.enums.Stat;

import java.util.List;
import java.util.Random;

public class HeroBuilder {

    private static final int EXPERIENCE_TO_NEXT_LEVEL_BASE = 100;

    static List<HeroTemplate> heroTemplates;
    static List<String> maleNames;
    static List<String> femaleNames;

    public static Hero buildLevelOneHero(HeroClass heroClass, Context context) {
        if (heroTemplates == null)
            HeroBuilder.heroTemplates = JsonReadWrite.loadHeroTemplates(context);

        Random random = new Random();
        HeroTemplate heroTemplate = getHeroTemplate(heroClass);

        Sex sex = heroTemplate.sexes.get(random.nextInt(heroTemplate.sexes.size()));

        Stats stats = new Stats(getSecretPointBonus(random),
                heroTemplate.healthGrowth,
                heroTemplate.threatGrowth,
                heroTemplate.strengthGrowth,
                heroTemplate.intellectGrowth,
                heroTemplate.dexterityGrowth);

        stats.increaseStatGrowthByOne(Stat.getRandomStat());
        stats.increaseStatGrowthByOne(Stat.getRandomStat());

        Attack attack = new Attack(heroTemplate.strengthPercent, heroTemplate.intellectPercent, heroTemplate.dexterityPercent,
                heroTemplate.attackType);


//        stats.levelUpStats();

        Hero hero = new Hero(returnRandomName(sex, context), heroClass, sex, 1, 0,
//                (int) Math.round(EXPERIENCE_TO_NEXT_LEVEL_BASE * 1 * heroTemplate.experienceMultiplier),
                heroTemplate.ticksTillAttack, stats, attack, heroTemplate.resistances);
        levelUpOne(hero);

        return hero;
    }

    static void levelUpOne(Hero hero) {
        HeroTemplate heroTemplate = getHeroTemplate(hero.getHeroClass());

        hero.levelUpStats();
        hero.levelUpOne();
        hero.setExperienceToNextLevel((int) Math.round(EXPERIENCE_TO_NEXT_LEVEL_BASE * hero.getLevel() * heroTemplate.experienceMultiplier));
    }

    static HeroTemplate getHeroTemplate(HeroClass heroClass) {
        for (HeroTemplate heroTemplate : heroTemplates) {
            if (heroTemplate.heroClass == heroClass) return heroTemplate;
        }

        return null;
    }

    static String returnRandomName(Sex sex, Context context) {
        if (maleNames == null)
            maleNames = JsonReadWrite.loadMaleNames(context);

        if (femaleNames == null)
            femaleNames = JsonReadWrite.loadFemaleNames(context);

        if (sex == Sex.MALE)
            return "Bobo the monkey";
        return "Mila the baboon";
    }

    static int getExperienceToNextLevel(int currentLevel, double experienceMultiplier) {
        return (int) (100 * (currentLevel + 1) * experienceMultiplier);
    }

    static int getSecretPointBonus(Random random) {
        int pointBonus = random.nextInt(11);
        if (random.nextBoolean())
            return pointBonus * -1;
        return pointBonus;
    }
}
