package com.example.heroesguild;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HeroBuilder.heroTemplates = JsonReadWrite.loadHeroTemplates(getApplicationContext());
        int x=3;
        double a = ((int) ((x / 11) * 10));
        int b = 0;
    }
}
