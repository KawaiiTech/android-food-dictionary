package com.miquelbeltran.japanesefooddictionary;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String FOOD_DICTIONARY_ASSET = "foodDict.json";
    private static final String SEARCH_TERM_EMPTY = "";
    private static final String SEARCH_TERM_1 = "rice";
    private static final String SEARCH_TERM_2 = "hashed beef rice or hayashi rice";
    private static final String SEARCH_TERM_3 = "NO RESULTS LOL";

    public ApplicationTest() {
        super(Application.class);
    }

    public void testFoodDictionary() throws Exception {
        FoodDictionaryFromJson foodDictionary = new FoodDictionaryFromJson();
        foodDictionary.loadDictionary(getContext(), FOOD_DICTIONARY_ASSET);
        List<FoodCategory> foodCategories = foodDictionary.getCategories();
        assertTrue("There are some categories", foodCategories.size() > 0);
        List<FoodDescription> foodDescriptionList = foodDictionary.search(SEARCH_TERM_EMPTY);
        assertTrue("There are some items when I search empty", foodDescriptionList.size() > 0);
        foodDescriptionList = foodDictionary.search(SEARCH_TERM_1);
        assertTrue("There are some items when I search: " + SEARCH_TERM_1, foodDescriptionList.size() > 0);
        foodDescriptionList = foodDictionary.search(SEARCH_TERM_2);
        assertTrue("There is only one item when I search: " + SEARCH_TERM_2, foodDescriptionList.size() == 1);
        foodDescriptionList = foodDictionary.search(SEARCH_TERM_3);
        assertTrue("There are no items when I search: " + SEARCH_TERM_3, foodDescriptionList.size() == 0);

    }
}