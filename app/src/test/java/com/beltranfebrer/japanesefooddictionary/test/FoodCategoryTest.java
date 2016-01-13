package com.beltranfebrer.japanesefooddictionary.test;

import com.beltranfebrer.japanesefooddictionary.data.FoodCategory;
import com.beltranfebrer.japanesefooddictionary.data.FoodDescription;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by miquel on 13.01.16.
 */
public class FoodCategoryTest {
    private static final String NAME = "Name";
    private static final String ICON = "Icon";
    private static final String TO_STRING = NAME + " (1)";
    private static final String CATEGORY = "Cat";
    private static final String ENGLISH = "English";
    private static final String JAPANESE = "Japanese";
    private static final String PRONUNCIATION = "Pro";
    FoodCategory category;

    @Before
    public void setUp() throws Exception {
        category = new FoodCategory(NAME, ICON);
        category.addFoodDescription(new FoodDescription(CATEGORY, ENGLISH, JAPANESE, PRONUNCIATION));
    }

    @Test
    public void testToString() throws Exception {
        assertEquals(TO_STRING, category.toString());
    }

    @Test
    public void testGetList() throws Exception {
        assertEquals(1,category.getFoodDescriptionList().size());
        assertEquals(ENGLISH, category.getFoodDescriptionList().get(0).english);
        assertEquals(JAPANESE + " (" + ENGLISH + ")", category.getFoodDescriptionList().get(0).toString());
    }
}
