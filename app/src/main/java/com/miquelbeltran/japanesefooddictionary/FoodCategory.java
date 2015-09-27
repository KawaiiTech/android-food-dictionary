package com.miquelbeltran.japanesefooddictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miquel on 9/27/2015.
 */
public class FoodCategory {
    public final String name;
    private List<FoodDescription> foodDescriptionList = new ArrayList<FoodDescription>();

    public FoodCategory(String name) {
        this.name = name;
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
