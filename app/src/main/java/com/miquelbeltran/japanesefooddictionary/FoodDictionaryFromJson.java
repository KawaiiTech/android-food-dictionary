package com.miquelbeltran.japanesefooddictionary;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by miquel on 9/27/2015.
 */
public class FoodDictionaryFromJson implements FoodDictionary {
    public FoodDictionaryFromJson() {
    }

    public void loadDictionary(Context context, String dictionaryFileName) throws IOException {
        AssetManager am = context.getAssets();
        InputStream is = am.open(dictionaryFileName);
    }

    @Override
    public List<FoodCategory> getCategories() {
        List<FoodCategory> FoodCategories = new ArrayList<FoodCategory>();
        return FoodCategories;
    }

    @Override
    public List<FoodDescription> search(String searchTerm) {
        List<FoodDescription> foodDescriptionList = new ArrayList<FoodDescription>();
        return foodDescriptionList;
    }

    @Override
    public List<FoodDescription> getAll() {
        List<FoodDescription> foodDescriptionList = new ArrayList<FoodDescription>();
        return foodDescriptionList;
    }
}
