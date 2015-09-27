package com.miquelbeltran.japanesefooddictionary;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String FOOD_DICTIONARY_ASSET = "foodDict.json";

    public ApplicationTest() {
        super(Application.class);
    }

    public void testFoodDictionary() throws Exception {
        FoodDictionary foodDictionary = new FoodDictionary();
        foodDictionary.loadDictionary(getContext(), FOOD_DICTIONARY_ASSET);

    }
}