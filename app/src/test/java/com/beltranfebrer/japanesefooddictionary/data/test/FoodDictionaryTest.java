package com.beltranfebrer.japanesefooddictionary.data.test;

import android.app.SearchableInfo;

import com.beltranfebrer.japanesefooddictionary.BuildConfig;
import com.beltranfebrer.japanesefooddictionary.data.CategoryIcons;
import com.beltranfebrer.japanesefooddictionary.data.FoodCategory;
import com.beltranfebrer.japanesefooddictionary.data.FoodDescription;
import com.beltranfebrer.japanesefooddictionary.data.FoodDictionary;
import com.beltranfebrer.japanesefooddictionary.data.FoodDictionaryFromJson;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by miquel on 13.01.16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        packageName = "com.beltranfebrer.japanesefooddictionary")
public class FoodDictionaryTest {
    private static final String SEARCH = "Rice";
    CategoryIcons categoryIconsMock = mock(CategoryIcons.class);
    FoodDictionaryFromJson dictionary;

    @Before
    public void setUp() throws Exception {
        dictionary = new FoodDictionaryFromJson(categoryIconsMock);
        dictionary.loadDictionary(RuntimeEnvironment.application, "foodDict.json");
    }

    @Test
    public void testGetCategories() throws Exception {
        List<FoodCategory> list = dictionary.getCategories();
        assertEquals(16, list.size());
        assertEquals("Alcoholic Drinks (2)", list.get(0).toString());
    }

    @Test
    public void testSearch() throws Exception {
        List<FoodDescription> list = dictionary.search("");
        assertEquals(55, list.size());
        list = dictionary.search(SEARCH);
        assertEquals(19, list.size());
        for (FoodDescription food :
                list) {
            assertTrue(food.english.toLowerCase().contains(SEARCH.toLowerCase()));
        }
    }
}
