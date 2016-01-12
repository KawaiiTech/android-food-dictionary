package com.beltranfebrer.japanesefooddictionary;

/**
 * Created by miquel on 11.01.16.
 */
public class MainActivityPresenter {
    private MainActivityView view;

    public MainActivityPresenter(MainActivityView view) {
        this.view = view;
    }

    /**
     * Tell the view what to show depending on the option selected
     * @param id of the option
     * @return true if a valid option is selected
     */
    public boolean onOptionsItemSelected(int id) {
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about_us) {
            view.showAboutUs();
            return true;
        }
        return false;
    }

    /**
     * @return How many tabs are we showing.
     */
    public int getFragmentCount() {
        return 2;
    }

    /**
     * @param position
     * @return Which fragment to show depending on the tab position
     */
    public MainActivityView.FragmentId getFragmentId(int position) {
        switch (position) {
            case 0:
                return MainActivityView.FragmentId.Categories;
            case 1:
                return MainActivityView.FragmentId.Search;
            default:
                return MainActivityView.FragmentId.Categories;
        }
    }

    public void showTabs() {
        view.addTab(MainActivityView.FragmentId.Categories.toString());
        view.addTab(MainActivityView.FragmentId.Search.toString());
        //TODO: view.addTab("Favourites");
    }
}
