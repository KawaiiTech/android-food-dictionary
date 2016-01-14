package com.beltranfebrer.japanesefooddictionary.foodlist;

import android.content.Context;

import com.beltranfebrer.japanesefooddictionary.data.CategoryIcons;
import com.beltranfebrer.japanesefooddictionary.data.FoodDictionaryFromJson;

import java.io.IOException;

/**
 * Created by miquel on 14.01.16.
 */
public class FoodListPresenter {
    private FoodDictionaryFromJson foodDictionary;
    private FoodListView view;
    private static final String ICON_DICTIONARY_ASSET = "iconIDdict.json";
    private static final String FOOD_DICTIONARY_ASSET = "foodDict.json";

    public FoodListPresenter(FoodListView view) {
        this.view = view;
    }

    public void createModel(Context context) {
        CategoryIcons categoryIcons = new CategoryIcons();
        try {
            categoryIcons.loadDictionary(context, ICON_DICTIONARY_ASSET);
            foodDictionary = new FoodDictionaryFromJson(categoryIcons);
            foodDictionary.loadDictionary(context, FOOD_DICTIONARY_ASSET);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void search(String search) {
        FoodListArrayAdapter adapter = new FoodListArrayAdapter(view.getActivity(), foodDictionary.search(search));
        view.updateAdapter(adapter);
    }
}
