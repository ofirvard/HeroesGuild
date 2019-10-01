package com.example.heroesguild;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonReadWrite
{


    static List<HeroTemplate> loadHeroTemplates(Context context)
    {
        List<HeroTemplate> heroTemplates = new ArrayList<>();
        String data;

        try
        {
//            InputStream in = context.getAssets().open("hero_templates.json");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            data = read(reader);
//            JSONArray list = new JSONArray(data);
            JSONArray list = loadListData(context, "hero_templates.json");
            Gson gson = new Gson();
            for (int i = 0; i < list.length(); i++)
                heroTemplates.add(gson.fromJson(list.getJSONObject(i).toString(), HeroTemplate.class));
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return heroTemplates;
    }

    static List<String> loadMaleNames(Context context)
    {
        List<String> maleNames = new ArrayList<>();

        try
        {
            JSONArray list = loadListData(context, "male_names.json");
            Gson gson = new Gson();
            for (int i = 0; i < list.length(); i++)
                maleNames.add(gson.fromJson(list.getJSONObject(i).toString(), String.class));
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return maleNames;
    }

    static List<String> loadFemaleNames(Context context)
    {
        List<String> femaleNames = new ArrayList<>();

        try
        {
            JSONArray list = loadListData(context, "female_names.json");
            Gson gson = new Gson();
            for (int i = 0; i < list.length(); i++)
                femaleNames.add(gson.fromJson(list.getJSONObject(i).toString(), String.class));
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return femaleNames;
    }

    static JSONArray loadListData(Context context, String fileName)
    {
        String data;
        try
        {
            InputStream in = context.getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            data = read(reader);
            return new JSONArray(data);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    //this reads from saved files
    static List<HeroTemplate> read(Context context)
    {
        List<HeroTemplate> heroTemplates = new ArrayList<>();
        String data;

        try
        {
            FileInputStream in = context.openFileInput("hero_templates.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            data = read(reader);
            JSONArray list = new JSONArray(data);
            Gson gson = new Gson();
            for (int i = 0; i < list.length(); i++)
                heroTemplates.add(gson.fromJson(list.getJSONObject(i).toString(), HeroTemplate.class));
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return heroTemplates;
    }

    static void write(Context context, List<Hero> soundItems)
    {
        try
        {
            Gson gson = new Gson();
            String data = gson.toJson(soundItems);
            FileOutputStream out = context.openFileOutput("hero_templates.json", Context.MODE_PRIVATE);
            out.write(data.getBytes());
            out.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static String read(BufferedReader reader)
    {
        try
        {
            StringBuilder builder = new StringBuilder();
            String aux;
            while ((aux = reader.readLine()) != null)
            {
                builder.append(aux);
            }
            return builder.toString();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
