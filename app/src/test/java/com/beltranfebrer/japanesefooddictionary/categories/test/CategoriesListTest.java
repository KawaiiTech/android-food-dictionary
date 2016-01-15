package com.beltranfebrer.japanesefooddictionary.categories.test;

import com.beltranfebrer.japanesefooddictionary.BuildConfig;
import com.beltranfebrer.japanesefooddictionary.categories.CategoriesExpandableListAdapter;
import com.beltranfebrer.japanesefooddictionary.categories.CategoriesListFragment;
import com.beltranfebrer.japanesefooddictionary.categories.CategoriesListPresenter;
import com.beltranfebrer.japanesefooddictionary.categories.CategoriesListView;
import com.beltranfebrer.japanesefooddictionary.foodlist.FoodListArrayAdapter;
import com.beltranfebrer.japanesefooddictionary.foodlist.FoodListPresenter;
import com.beltranfebrer.japanesefooddictionary.foodlist.FoodListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.notNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by miquel on 14.01.16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class CategoriesListTest {
    CategoriesListPresenter presenter;
    CategoriesListView mockView;

    @Before
    public void setUp() throws Exception {
        mockView = mock(CategoriesListFragment.class);
        presenter = new CategoriesListPresenter(mockView);
        presenter.createModel(RuntimeEnvironment.application);
    }

    @Test
    public void testSetAdapter() throws Exception {
        verify(mockView).updateAdapter((CategoriesExpandableListAdapter) notNull());
    }
}
