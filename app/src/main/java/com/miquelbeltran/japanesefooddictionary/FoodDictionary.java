package com.miquelbeltran.japanesefooddictionary;

import java.util.List;

/**
 * Created by miquel on 9/27/2015.
 */
public interface FoodDictionary {
    List<FoodCategory> getCategories();

    List<FoodDescription> search(String searchTerm);

    List<FoodDescription> getAll();
}
