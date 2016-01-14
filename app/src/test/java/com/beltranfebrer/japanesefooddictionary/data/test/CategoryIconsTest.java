package com.beltranfebrer.japanesefooddictionary.data.test;

import com.beltranfebrer.japanesefooddictionary.BuildConfig;
import com.beltranfebrer.japanesefooddictionary.R;
import com.beltranfebrer.japanesefooddictionary.data.CategoryIcons;

import org.apache.tools.ant.filters.StringInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;

import java.io.IOException;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;

/**
 * Created by miquel on 12.01.16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        packageName = "com.beltranfebrer.japanesefooddictionary")
public class CategoryIconsTest {

    private CategoryIcons categoryIcons;
    private final String JSON = "[\n" +
            "    {\n" +
            "        \"category\": \"Sweets\",\n" +
            "        \"iconId\": \"icon_cat_sweet\"\n" +
            "    }\n" +
            "\n" +
            "]";
    private final String JSON_WRONG = "[\n" +
            "    {\n" +
            "        \"nope\": \"Foo\",\n" +
            "        \"nein\": \"Bar\"\n" +
            "    }\n" +
            "\n" +
            "error" +
            "]";

    @Before
    public void setUp() throws Exception {
        categoryIcons = new CategoryIcons();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testJson() throws Exception {
        InputStream in = new StringInputStream(JSON);
        categoryIcons.readJsonStream(in);
        assertEquals("icon_cat_sweet", categoryIcons.getIconForCategory("Sweets"));
    }

    @Test
    public void testWrongJson() throws Exception {
        InputStream in = new StringInputStream(JSON_WRONG);
        categoryIcons.readJsonStream(in);
    }

    @Test
    public void testLoadDiccionary() throws Exception {
        categoryIcons.loadDictionary(RuntimeEnvironment.application, "iconIDdict.json");
        assertEquals("icon_cat_sweet", categoryIcons.getIconForCategory("Sweets"));
    }
}
