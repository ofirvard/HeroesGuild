package com.example.heroesguild;

import android.content.Context;

import java.util.List;
import java.util.Random;

public class HeroBuilder
{
    static enum Sex
    {
        MALE,
        FEMALE
    }

    static enum HeroClass
    {
        WARRIOR, FIREMAGE, ROGUE
    }

    private static final int experienceToNextLevelBase = 100;

    static List<HeroTemplate> heroTemplates;
    static List<String> maleNames;
    static List<String> femaleNames;

    static Hero buildLevelOneHero(HeroClass heroClass, Context context)
    {
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

        stats.increaseStatGrowthByOne(Stats.Stat.getRandomStat());
        stats.increaseStatGrowthByOne(Stats.Stat.getRandomStat());

        stats.levelUpStats();

        Hero hero = new Hero(returnRandomName(sex, context), heroClass, sex, 1, (int) Math.round(experienceToNextLevelBase * 1 * heroTemplate.experienceMultiplier),
                heroTemplate.ticksTillAttack, stats);

        return hero;
    }

    static void levelUp()
    {
    }

    static HeroTemplate getHeroTemplate(HeroClass heroClass)
    {
        for (HeroTemplate heroTemplate : heroTemplates)
        {
            if (heroTemplate.heroClass == heroClass) return heroTemplate;
        }

        return null;
    }

    static String returnRandomName(Sex sex, Context context)
    {
        if (maleNames == null)
            maleNames = JsonReadWrite.loadMaleNames(context);

        if (femaleNames == null)
            femaleNames = JsonReadWrite.loadFemaleNames(context);

        if (sex == Sex.MALE)
            return "Bobo the monkey";
        return "Mila the baboon";
    }

    static int getExperienceToNextLevel(int currentLevel, double experienceMultiplier)
    {
        return (int) (100 * (currentLevel + 1) * experienceMultiplier);
    }

    static int getSecretPointBonus(Random random)
    {
        int pointBonus = random.nextInt(11);
        if (random.nextBoolean())
            return pointBonus * -1;
        return pointBonus;
    }
}
