package com.miquelbeltran.japanesefooddictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miquel on 9/27/2015.
 */
public class FoodCategory {
    public final String name;
    public final int icon_res;
    private List<FoodDescription> foodDescriptionList = new ArrayList<FoodDescription>();

    public FoodCategory(String name) {
        this.name = name;
        icon_res = getIconForCategory(name);
    }

    private int getIconForCategory(String name) {
        if (name.equals("Rice")) {
            return R.drawable.icon_cat_rice;
        }
        if (name.equals("Toppings")) {
            return R.mipmap.ic_launcher;
        }
        if (name.equals("Deep-fried")) {
            return R.mipmap.ic_launcher;
        }
        if (name.equals("Beef")) {
            return R.drawable.icon_cat_beef;
        }
        return R.mipmap.ic_launcher;
    }

    public final List<FoodDescription> getFoodDescriptionList() {
        return foodDescriptionList;
    }

    public void addFoodDescription(FoodDescription foodDescription) {
        foodDescriptionList.add(foodDescription);
    }

    @Override
    public String toString() {
        return name + " (" + foodDescriptionList.size() + ")";
    }
}
