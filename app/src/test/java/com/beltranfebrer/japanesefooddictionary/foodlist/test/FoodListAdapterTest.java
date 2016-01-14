package com.beltranfebrer.japanesefooddictionary.foodlist.test;

import android.view.View;
import android.widget.TextView;

import com.beltranfebrer.japanesefooddictionary.BuildConfig;
import com.beltranfebrer.japanesefooddictionary.R;
import com.beltranfebrer.japanesefooddictionary.data.FoodDescription;
import com.beltranfebrer.japanesefooddictionary.foodlist.FoodListArrayAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by miquel on 14.01.16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        packageName = "com.beltranfebrer.japanesefooddictionary")
public class FoodListAdapterTest {
    FoodListArrayAdapter adapter;
    FoodDescription mochi = new FoodDescription("Sweets", "Mochi rice cake", "餅", "");
    FoodDescription whiteRice = new FoodDescription("", "White rice", "白米", "");
    List<FoodDescription> list = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        list.add(mochi);
        list.add(whiteRice);
        adapter = new FoodListArrayAdapter(RuntimeEnvironment.application, list);
    }

    @Test
    public void testMethods() throws Exception {
        assertFalse(adapter.areAllItemsEnabled());
        assertFalse(adapter.isEnabled(0));
        assertEquals(2, adapter.getCount());
        assertEquals(mochi, adapter.getItem(0));
        assertEquals(mochi.hashCode(), adapter.getItemId(0));
        assertFalse(adapter.hasStableIds());
        assertEquals(0, adapter.getItemViewType(0));
        assertEquals(1, adapter.getViewTypeCount());
        assertFalse(adapter.isEmpty());
    }

    @Test
    public void testView() throws Exception {
        View view = adapter.getView(1, null, null);
        assertNotNull(view);
        TextView textView = (TextView) view.findViewById(R.id.japaneseTextView);
        assertEquals(whiteRice.japanese, textView.getText());
        textView = (TextView) view.findViewById(R.id.englishTextView);
        assertEquals(whiteRice.english, textView.getText());
        textView = (TextView) view.findViewById(R.id.pronunciationTextView);
        assertEquals(whiteRice.pronunciation, textView.getText());
    }
}
