package com.beltranfebrer.japanesefooddictionary.categories;

import android.app.Application;
import android.content.Context;

import com.beltranfebrer.japanesefooddictionary.data.CategoryIcons;
import com.beltranfebrer.japanesefooddictionary.data.FoodDictionaryFromJson;

import java.io.IOException;

/**
 * Created by miquel on 15.01.16.
 */
public class CategoriesListPresenter {
    private CategoriesListView view;
    private static final String ICON_DICTIONARY_ASSET = "iconIDdict.json";

    public CategoriesListPresenter(CategoriesListView view) {
        this.view = view;
    }

    public void createModel(Context context) {
        try {
            CategoryIcons categoryIcons = new CategoryIcons();
            categoryIcons.loadDictionary(context, ICON_DICTIONARY_ASSET);
            FoodDictionaryFromJson foodDictionary = new FoodDictionaryFromJson(categoryIcons);
            foodDictionary.loadDictionary(context, "foodDict.json");
            view.updateAdapter(new CategoriesExpandableListAdapter(context, foodDictionary.getCategories()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
