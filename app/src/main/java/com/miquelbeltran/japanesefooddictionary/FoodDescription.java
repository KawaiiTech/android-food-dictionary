package com.miquelbeltran.japanesefooddictionary;

/**
 * Created by miquel on 9/27/2015.
 */

public class FoodDescription {

    public final String english;
    public final String japanese;

    public FoodDescription(String english, String japanese) {
        this.english = english;
        this.japanese = japanese;
    }

    @Override
    public String toString() {
        return japanese + " (" + english + ")";
    }
}

