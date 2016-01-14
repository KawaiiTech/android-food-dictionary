package com.beltranfebrer.japanesefooddictionary.foodlist;

import android.support.v4.app.FragmentActivity;

/**
 * Created by miquel on 14.01.16.
 */
public interface FoodListView {
    FragmentActivity getActivity();
    void updateAdapter(FoodListArrayAdapter adapter);
}
