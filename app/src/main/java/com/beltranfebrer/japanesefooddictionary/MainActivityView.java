package com.beltranfebrer.japanesefooddictionary;

/**
 * Created by miquel on 11.01.16.
 */
public interface MainActivityView {
    public enum FragmentId {
        Categories("Categories"),
        Search("Search");
        FragmentId(String title) {
            this.title = title;
        }
        @Override
        public String toString() {
            return title;
        }
        private String title;
    }
    void showAboutUs();
    void addTab(String categories);
}
