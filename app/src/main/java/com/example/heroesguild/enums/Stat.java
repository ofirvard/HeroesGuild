package com.example.heroesguild.enums;

import java.util.Random;

public enum Stat {
    HEALTH, THREAT, STRENGTH, INTELLECT, DEXTERITY;

    public static Stat getRandomStat() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
