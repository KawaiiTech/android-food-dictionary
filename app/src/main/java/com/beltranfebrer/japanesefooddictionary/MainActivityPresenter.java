package com.beltranfebrer.japanesefooddictionary;

/**
 * Created by miquel on 11.01.16.
 */
public class MainActivityPresenter {
    private MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
        view.addTab("Categories");
        view.addTab("Search");
        //TODO: view.addTab("Favourites");
    }

    public boolean onOptionsItemSelected(int id) {
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about_us) {
            view.showAboutUs();
            return true;
        }
        return false;
    }
}
