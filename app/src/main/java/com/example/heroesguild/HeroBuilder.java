package com.example.heroesguild;

import java.util.List;
import java.util.Random;

public class HeroBuilder {
    static enum Sex {
        MALE,
        FEMALE
    }

    static enum HeroClass {
        WARRIOR, FIREMAGE, ROGUE
    }

    static List<HeroTemplate> heroTemplates;

    static Hero buildHero(HeroClass heroClass, int level) {
        Hero hero = null;
        Random random = new Random();
        HeroTemplate heroTemplate = getHeroTemplate(heroClass);

        Sex sex = heroTemplate.sexes.get(random.nextInt(heroTemplate.sexes.size()));

        int healthGrowth = heroTemplate.healthGrowth;
        int threatGrowth = heroTemplate.threatGrowth;
        int strengthGrowth = heroTemplate.strengthGrowth;
        int intellectGrowth = heroTemplate.intellectGrowth;
        int dexterityGrowth = heroTemplate.dexterityGrowth;

        switch (random.nextInt(5)) {
            case 0:
                healthGrowth++;
            case 1:
                threatGrowth++;
            case 2:
                strengthGrowth++;
            case 3:
                intellectGrowth++;
            case 4:
                dexterityGrowth++;
        }

        switch (random.nextInt(5)) {
            case 0:
                healthGrowth++;
            case 1:
                threatGrowth++;
            case 2:
                strengthGrowth++;
            case 3:
                intellectGrowth++;
            case 4:
                dexterityGrowth++;
        }


        hero = new Hero(random.nextInt(), returnRandomName(sex), heroClass, sex, null, level,
                getExperienceToNextLevel(level, heroTemplate.experienceMultiplier), getSecretPointBonus(random),
                heroTemplate.ticksTillAttack, );
//Math.round()
        return hero;
    }

    static void levelUp() {
    }

    static HeroTemplate getHeroTemplate(HeroClass heroClass) {
        for (HeroTemplate heroTemplate : heroTemplates) {
            if (heroTemplate.heroClass == heroClass) return heroTemplate;
        }

        return null;
    }

    static String returnRandomName(Sex sex) {
        return "Bobo the monkey";
    }

    static int getExperienceToNextLevel(int currentLevel, double experienceMultiplier) {
        return (int) (100 * (currentLevel + 1) * experienceMultiplier);
    }

    static int getSecretPointBonus(Random random) {
        int pointBonus = random.nextInt(6);
        if (random.nextBoolean())
            return pointBonus * -1;
        return pointBonus;
    }

    static
}
