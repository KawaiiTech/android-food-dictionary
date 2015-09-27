package com.miquelbeltran.japanesefooddictionary;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by miquel on 9/27/2015.
 */
public class FoodDictionary {
    public FoodDictionary() {
    }

    public void loadDictionary(Context context, String dictionaryFileName) throws IOException {
        AssetManager am = context.getAssets();
        InputStream is = am.open(dictionaryFileName);
    }
}
