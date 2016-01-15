package com.beltranfebrer.japanesefooddictionary.categories.test;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.beltranfebrer.japanesefooddictionary.BuildConfig;
import com.beltranfebrer.japanesefooddictionary.R;
import com.beltranfebrer.japanesefooddictionary.categories.CategoriesExpandableListAdapter;
import com.beltranfebrer.japanesefooddictionary.data.FoodCategory;
import com.beltranfebrer.japanesefooddictionary.dummy.FoodDictionaryForTesting;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by miquel on 15.01.16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class,
        packageName = "com.beltranfebrer.japanesefooddictionary")
public class CategoriesExpandableTest {
    CategoriesExpandableListAdapter adapter;
    List<FoodCategory> list = new FoodDictionaryForTesting().getCategories();
    @Before
    public void setUp() throws Exception {
        adapter = new CategoriesExpandableListAdapter(RuntimeEnvironment.application, list);
    }

    @Test
    public void testGroupCount() throws Exception {
        assertEquals(11, adapter.getGroupCount());
    }

    @Test
    public void testChildrenCount() throws Exception {
        assertEquals(1, adapter.getChildrenCount(0));
        assertEquals(1, adapter.getChildrenCount(1));
        assertEquals(0, adapter.getChildrenCount(2));
    }

    @Test
    public void testGetGroup() throws Exception {
        assertEquals(list.get(0), adapter.getGroup(0));
        assertEquals(list.get(1), adapter.getGroup(1));
    }

    @Test
    public void testGetChild() throws Exception {
        assertEquals(list.get(0).getFoodDescriptionList().get(0), adapter.getChild(0, 0));
    }

    @Test
    public void testGroupId() throws Exception {
        assertEquals(list.get(0).hashCode(), adapter.getGroupId(0));
        assertEquals(list.get(1).hashCode(), adapter.getGroupId(1));
    }

    @Test
    public void testChildId() throws Exception {
        assertEquals(list.get(0).getFoodDescriptionList().get(0).hashCode(), adapter.getChildId(0, 0));
    }

    @Test
    public void testStableId() throws Exception {
        assertFalse(adapter.hasStableIds());
    }

    @Test
    public void testChildSelectable() throws Exception {
        assertFalse(adapter.isChildSelectable(0, 0));
    }

    @Test
    public void testAreAllItemsEnabled() throws Exception {
        assertFalse(adapter.areAllItemsEnabled());
    }

    @Test
    public void testEmpty() throws Exception {
        assertFalse(adapter.isEmpty());
    }

    @Test
    public void testCombinedChildId() throws Exception {
        assertEquals(0, adapter.getCombinedChildId(0, 0));
    }

    @Test
    public void testCombinedGroupId() throws Exception {
        assertEquals(0, adapter.getCombinedGroupId(1));
    }

    @Test
    public void testGroup() throws Exception {
        View view = adapter.getGroupView(0, false, null, null);
        assertNotNull(view);
        TextView textView = (TextView) view.findViewById(R.id.catTextView);
        assertEquals("Sweets (1)", textView.getText());
    }

    @Test
    public void testChildView() throws Exception {
        View view = adapter.getChildView(0, 0, false, null, null);
        assertNotNull(view);
        TextView textView = (TextView) view.findViewById(R.id.japaneseTextView);
        assertEquals("餅", textView.getText());
        textView = (TextView) view.findViewById(R.id.englishTextView);
        assertEquals("Mochi rice cake", textView.getText());
        textView = (TextView) view.findViewById(R.id.pronunciationTextView);
        assertEquals("moochi", textView.getText());
    }
}
