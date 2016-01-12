package com.beltranfebrer.japanesefooddictionary.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.JsonReader;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lara on 28/09/2015.
 */
public class CategoryIcons {
    private Map<String, String> mapCategoryIcons;

    public CategoryIcons() {
        mapCategoryIcons = new HashMap();
    }

    public String getIconForCategory(String name) {
        return mapCategoryIcons.get(name);
    }

    public void loadDictionary(Context context, String dictionaryFileName) throws IOException {
        AssetManager am = context.getAssets();
        InputStream is = am.open(dictionaryFileName);
        readJsonStream(is);
    }

    public void readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            readCategoryIcons(reader);
        } catch (IOException e) {
            Log.e(CategoryIcons.class.getCanonicalName(), e.getMessage(), e);
        }
        finally{
            reader.close();
        }
    }

    private void readCategoryIcons(JsonReader reader) throws IOException {
        reader.beginArray();
        while (reader.hasNext()) {
            Map.Entry<String, String> categoryIcon = readCategoryIcon(reader);
            mapCategoryIcons.put(categoryIcon.getKey(), categoryIcon.getValue());
        }
        reader.endArray();
    }

    private Map.Entry<String, String> readCategoryIcon(JsonReader reader) throws IOException {
        String category = "";
        String iconId = "";
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("category")) {
                category = reader.nextString();
            } else if (name.equals("iconId")) {
                iconId = reader.nextString();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new AbstractMap.SimpleImmutableEntry<String, String>(category, iconId);
    }
}
