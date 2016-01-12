package com.beltranfebrer.japanesefooddictionary.test;

import com.beltranfebrer.japanesefooddictionary.R;
import com.beltranfebrer.japanesefooddictionary.data.CategoryIcons;

import org.apache.tools.ant.filters.StringInputStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.io.IOException;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created by miquel on 12.01.16.
 */
@RunWith(RobolectricTestRunner.class)
public class CategoryIconsTest {

    private CategoryIcons categoryIcons;
    private final String JSON = "[\n" +
            "    {\n" +
            "        \"category\": \"Sweets\",\n" +
            "        \"iconId\": \"icon_cat_sweet\"\n" +
            "    },\n" +
            "\n" +
            "]";

    @Before
    public void setUp() throws Exception {
        categoryIcons = new CategoryIcons();
        InputStream in = new StringInputStream(JSON);
        categoryIcons.readJsonStream(in);
    }

    @Test
    public void testName() throws Exception {
        assertEquals("icon_cat_sweet", categoryIcons.getIconForCategory("Sweets"));
    }
}
