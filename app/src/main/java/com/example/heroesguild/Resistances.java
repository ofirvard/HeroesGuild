package com.example.heroesguild;

import android.util.Pair;

import com.example.heroesguild.enums.AttackType;

import java.util.List;

public class Resistances {
    List<Pair<AttackType, Double>> resistances;

    public double getResistance(AttackType attackType) {
//        if (resistances)
        for (Pair pair : resistances)
            if (pair.first == attackType)
                return (double) pair.second;

        return 1.0;
    }
}
