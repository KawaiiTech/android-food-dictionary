package com.miquelbeltran.japanesefooddictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miquel on 9/27/2015.
 */
public class FoodDictionaryForTesting implements FoodDictionary {
    @Override
    public List<FoodCategory> getCategories() {
        List<FoodCategory> foodCategories = new ArrayList<FoodCategory>();
        FoodCategory categoryRice = new FoodCategory("Rice");
        FoodDescription whiteRice = new FoodDescription();
        categoryRice.addFoodDescription(whiteRice);
        foodCategories.add(categoryRice);

        FoodCategory categorySweets = new FoodCategory("Sweets");
        FoodDescription mochi = new FoodDescription();
        categorySweets.addFoodDescription(mochi);
        foodCategories.add(categorySweets);
        return foodCategories;
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
