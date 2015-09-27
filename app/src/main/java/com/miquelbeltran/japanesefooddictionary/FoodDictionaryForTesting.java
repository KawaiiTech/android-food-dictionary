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
        FoodDescription whiteRice = new FoodDescription("White rice", "白米");
        categoryRice.addFoodDescription(whiteRice);
        foodCategories.add(categoryRice);

        FoodCategory categorySweets = new FoodCategory("Sweets");
        foodCategories.add(categorySweets);
        FoodDescription mochi = new FoodDescription("Mochi rice cake", "餅");
        categorySweets.addFoodDescription(mochi);

        FoodCategory categoryNoodles = new FoodCategory("Noodles");
        foodCategories.add(categoryNoodles);

        FoodCategory categoryBread = new FoodCategory("Bread");
        FoodDescription melonpan = new FoodDescription("Melonpan sweet bun", "メロンパン");
        categoryBread.addFoodDescription(melonpan);
        foodCategories.add(categoryBread);

        FoodCategory categorySoftDrinks = new FoodCategory("Soft Drinks");
        foodCategories.add(categorySoftDrinks);

        FoodCategory categoryTea = new FoodCategory("Tea");
        foodCategories.add(categoryTea);

        FoodCategory categorySake = new FoodCategory("Sake");
        foodCategories.add(categorySake);

        FoodCategory categoryDeepFried = new FoodCategory("Deep Fried");
        foodCategories.add(categoryDeepFried);

        FoodCategory categoryGrilledPan = new FoodCategory("Grilled or Pan fried");
        foodCategories.add(categoryGrilledPan);

        return foodCategories;
    }

    @Override
    public List<FoodDescription> search(String searchTerm) {
        List<FoodDescription> foodDescriptionList = new ArrayList<FoodDescription>();
        foodDescriptionList.add(new FoodDescription("mochi", "餅"));
        if (searchTerm.equals("mo"))
            return foodDescriptionList;
        foodDescriptionList.add(new FoodDescription("white rice", "白米"));
        foodDescriptionList.add(new FoodDescription("melonpan", "メロンパン"));
        foodDescriptionList.add(new FoodDescription("tolo", "pom"));
        return foodDescriptionList;
    }

    @Override
    public List<FoodDescription> getAll() {
        List<FoodDescription> foodDescriptionList = new ArrayList<FoodDescription>();
        return foodDescriptionList;
    }
}
