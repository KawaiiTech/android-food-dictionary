package com.beltranfebrer.japanesefooddictionary.foodlist.test;

import com.beltranfebrer.japanesefooddictionary.BuildConfig;
import com.beltranfebrer.japanesefooddictionary.foodlist.FoodListArrayAdapter;
import com.beltranfebrer.japanesefooddictionary.foodlist.FoodListPresenter;
import com.beltranfebrer.japanesefooddictionary.foodlist.FoodListView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by miquel on 14.01.16.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public class FoodListTest {
    FoodListPresenter presenter;
    FoodListView mockView;

    @Before
    public void setUp() throws Exception {
        mockView = mock(FoodListView.class);
        presenter = new FoodListPresenter(mockView);
        presenter.createModel(RuntimeEnvironment.application);
    }

    @Test
    public void testSearch() throws Exception {
        presenter.search("");
        verify(mockView).updateAdapter((FoodListArrayAdapter) any());
    }
}
