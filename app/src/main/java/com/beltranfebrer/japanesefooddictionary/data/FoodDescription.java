package com.beltranfebrer.japanesefooddictionary.data;

/**
 * Created by miquel on 9/27/2015.
 */

public class FoodDescription {

    public final String category;
    public final String english;
    public final String japanese;
    public final String pronunciation;

    public FoodDescription(String category, String english, String japanese, String pronunciation) {
        this.category = category;
        this.english = english;
        this.japanese = japanese;
        this.pronunciation = pronunciation;
    }

    @Override
    public String toString() {
        return japanese + " (" + english + ")";
    }
}

