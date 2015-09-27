package com.miquelbeltran.japanesefooddictionary;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String FOOD_DICTIONARY_ASSET = "foodDict.json";
    private static final String SEARCH_TERM_1 = "rice";

    public ApplicationTest() {
        super(Application.class);
    }

    public void testFoodDictionary() throws Exception {
        FoodDictionaryFromJson foodDictionary = new FoodDictionaryFromJson();
        foodDictionary.loadDictionary(getContext(), FOOD_DICTIONARY_ASSET);
        List<FoodCategory> foodCategories = foodDictionary.getCategories();
        assertTrue(foodCategories.size() > 0);
        List<FoodDescription> foodDescriptionList = foodDictionary.getAll();
        assertTrue(foodDescriptionList.size() > 0);
        foodDescriptionList =foodDictionary.search(SEARCH_TERM_1);
        assertTrue(foodDescriptionList.size() > 0);

    }
}