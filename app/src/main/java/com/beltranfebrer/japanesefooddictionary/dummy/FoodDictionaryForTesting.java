package com.beltranfebrer.japanesefooddictionary.dummy;

import com.beltranfebrer.japanesefooddictionary.R;
import com.beltranfebrer.japanesefooddictionary.data.FoodCategory;
import com.beltranfebrer.japanesefooddictionary.data.FoodDescription;
import com.beltranfebrer.japanesefooddictionary.data.FoodDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miquel on 9/27/2015.
 */
public class FoodDictionaryForTesting implements FoodDictionary {
    @Override
    public List<FoodCategory> getCategories() {
        List<FoodCategory> foodCategories = new ArrayList<FoodCategory>();

        FoodCategory categorySweets = new FoodCategory("Sweets", R.drawable.icon_cat_beef);
        foodCategories.add(categorySweets);
        FoodDescription mochi = new FoodDescription("Sweets", "Mochi rice cake", "餅", "");
        categorySweets.addFoodDescription(mochi);

        FoodCategory categoryRice = new FoodCategory("Rice", R.drawable.icon_cat_beef);
        FoodDescription whiteRice = new FoodDescription("", "White rice", "白米", "");
        categoryRice.addFoodDescription(whiteRice);
        foodCategories.add(categoryRice);

        FoodCategory categoryNoodles = new FoodCategory("Noodles", R.drawable.icon_cat_beef);
        foodCategories.add(categoryNoodles);

        FoodCategory categoryBread = new FoodCategory("Bread", R.drawable.icon_cat_beef);
        FoodDescription melonpan = new FoodDescription("Bread", "Melonpan sweet bun", "メロンパン", "");
        categoryBread.addFoodDescription(melonpan);
        foodCategories.add(categoryBread);

        FoodCategory categoryDeepFried = new FoodCategory("Deep-fried", R.drawable.icon_cat_beef);
        foodCategories.add(categoryDeepFried);

        FoodCategory categoryGrilledPan = new FoodCategory("Grilled or Pan fried", R.drawable.icon_cat_beef);
        foodCategories.add(categoryGrilledPan);

        FoodCategory categoryToppings = new FoodCategory("Toppings", R.drawable.icon_cat_beef);
        foodCategories.add(categoryToppings);

        FoodCategory categorySoftDrinks = new FoodCategory("Soft Drinks", R.drawable.icon_cat_beef);
        foodCategories.add(categorySoftDrinks);

        FoodCategory categoryTea = new FoodCategory("Tea", R.drawable.icon_cat_beef);
        foodCategories.add(categoryTea);

        FoodCategory categorySake = new FoodCategory("Sake", R.drawable.icon_cat_beef);
        foodCategories.add(categorySake);

        FoodCategory categorySushi = new FoodCategory("Sushi", R.drawable.icon_cat_beef);
        foodCategories.add(categorySushi);

        return foodCategories;
    }

    @Override
    public List<FoodDescription> search(String searchTerm) {
        List<FoodDescription> foodDescriptionList = new ArrayList<FoodDescription>();
        foodDescriptionList.add(new FoodDescription("Sweet", "mochi", "餅", ""));
        if (searchTerm.equals("mo"))
            return foodDescriptionList;
        foodDescriptionList.add(new FoodDescription("Rice", "white rice", "白米", ""));
        foodDescriptionList.add(new FoodDescription("Bread", "melonpan", "メロンパン", ""));
        foodDescriptionList.add(new FoodDescription("Bar", "tolo", "pom", ""));
        return foodDescriptionList;
    }
}
