package com.miquelbeltran.japanesefooddictionary;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by miquel on 9/27/2015.
 */
public class FoodDictionaryFromJson implements FoodDictionary {
    private List<FoodDescription> foodDescriptionList = new ArrayList<FoodDescription>();
    private List<FoodCategory> foodCategories = new ArrayList<FoodCategory>();

    public FoodDictionaryFromJson() {
    }

    public void loadDictionary(Context context, String dictionaryFileName) throws IOException {
        AssetManager am = context.getAssets();
        InputStream is = am.open(dictionaryFileName);
        readJsonStream(is);
        orderFoodList();
    }

    private void orderFoodList() {
        Collections.sort(foodDescriptionList, new Comparator<FoodDescription>() {
            @Override
            public int compare(FoodDescription lhs, FoodDescription rhs) {
                return lhs.english.compareToIgnoreCase(rhs.english);
            }
        });
        Collections.sort(foodCategories, new Comparator<FoodCategory>() {
            @Override
            public int compare(FoodCategory lhs, FoodCategory rhs) {
                return lhs.name.compareToIgnoreCase(rhs.name);
            }
        });
    }

    @Override
    public List<FoodCategory> getCategories() {
        return foodCategories;
    }

    @Override
    public List<FoodDescription> search(String searchTerm) {
        if (searchTerm.isEmpty())
            return foodDescriptionList;
        List<FoodDescription> result = new ArrayList<FoodDescription>();
        for (FoodDescription food:
             foodDescriptionList) {
            if (food.english.contains(searchTerm)) {
                result.add(food);
            }
        }
        return result;
    }

    private void readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            readFoodDescriptions(reader);
        } catch (IOException e) {
            Log.e(FoodDictionary.class.getCanonicalName(), e.getMessage(), e);
        }
        finally{
            reader.close();
        }
    }

    private void readFoodDescriptions(JsonReader reader) throws IOException {
        reader.beginArray();
        while (reader.hasNext()) {
            FoodDescription food = readFood(reader);
            foodDescriptionList.add(food);
            FoodCategory foodCategory = getCategory(food.category);
            if (foodCategory == null) {
                foodCategory = new FoodCategory(food.category);
                foodCategory.addFoodDescription(food);
                foodCategories.add(foodCategory);
            } else {
                foodCategory.addFoodDescription(food);
            }
        }
        reader.endArray();
        return;
    }

    private FoodCategory getCategory(String categoryName) {
        for (FoodCategory category:
             foodCategories) {
            if (category.name.equals(categoryName)) {
                return category;
            }
        }
        return null;
    }

    private FoodDescription readFood(JsonReader reader) throws IOException {
        String category = "";
        String english = "";
        String japanese = "";
        String pronunciation = "";
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("category")) {
                category = reader.nextString();
            } else if (name.equals("english")) {
                english = reader.nextString();
            } else if (name.equals("japanese")) {
                japanese = reader.nextString();
            } else if (name.equals("pronunciation")) {
                pronunciation = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new FoodDescription(category, english, japanese, pronunciation);
    }
}
