package com.miquelbeltran.japanesefooddictionary.data;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.JsonReader;
import android.util.Log;

import com.miquelbeltran.japanesefooddictionary.R;

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
    private Map<String, Integer> mapCategoryIcons;
    private Context context;

    public CategoryIcons() {
        mapCategoryIcons = new HashMap();
    }

    public int getIconForCategory(String name) {
        return mapCategoryIcons.get(name);
    }

    public void loadDictionary(Context context, String dictionaryFileName) throws IOException {
        this.context = context;
        AssetManager am = context.getAssets();
        InputStream is = am.open(dictionaryFileName);
        readJsonStream(is);
    }

    private void readJsonStream(InputStream in) throws IOException {
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
            Map.Entry<String, Integer> categoryIcon = readCategoryIcon(reader);
            mapCategoryIcons.put(categoryIcon.getKey(), categoryIcon.getValue());
        }
        reader.endArray();
        return;
    }

    private Map.Entry<String, Integer> readCategoryIcon(JsonReader reader) throws IOException {
        String category = "";
        String iconId = "";;
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
        Integer iconIdValue = context.getResources().getIdentifier(iconId, "drawable", "com.miquelbeltran.japanesefooddictionary");;
        return new AbstractMap.SimpleImmutableEntry<String, Integer>(category, iconIdValue);
    }
}
