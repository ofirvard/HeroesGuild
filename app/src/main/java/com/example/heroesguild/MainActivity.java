package com.example.heroesguild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HeroBuilder.heroTemplates = JsonReadWrite.loadHeroTemplates(getApplicationContext());

        Hero hero1 = HeroBuilder.buildLevelOneHero(HeroBuilder.HeroClass.WARRIOR, getApplicationContext());
        Hero hero2 = HeroBuilder.buildLevelOneHero(HeroBuilder.HeroClass.WARRIOR, getApplicationContext());
        Hero hero3 = HeroBuilder.buildLevelOneHero(HeroBuilder.HeroClass.WARRIOR, getApplicationContext());
        int x = 3;
    }
}
