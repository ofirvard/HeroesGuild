package com.example.heroesguild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.heroesguild.builders.HeroBuilder;
import com.example.heroesguild.enums.HeroClass;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Hero hero1 = HeroBuilder.buildLevelOneHero(HeroClass.WARRIOR, getApplicationContext());
        Hero hero2 = HeroBuilder.buildLevelOneHero(HeroClass.WARRIOR, getApplicationContext());
//        Hero hero3 = HeroBuilder.buildLevelOneHero(HeroClass.WARRIOR, getApplicationContext());
        Resistances res1;//= new Resistances();
//        String s = new Gson().toJson(resistances);
        int x = 3;
    }
}
