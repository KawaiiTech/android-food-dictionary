package com.beltranfebrer.japanesefooddictionary.categories;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.beltranfebrer.japanesefooddictionary.R;

public class CategoriesListFragment extends Fragment implements CategoriesListView {
    private CategoriesListPresenter presenter = new CategoriesListPresenter(this);

    /**
     * The fragment's ListView/GridView.
     */
    private ExpandableListView mListView;


    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public CategoriesListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categoryitem, container, false);
        mListView = (ExpandableListView) view.findViewById(android.R.id.list);
        presenter.createModel(getContext());
        return view;
    }

    @Override
    public void updateAdapter(CategoriesExpandableListAdapter adapter) {
        mListView.setAdapter(adapter);
    }
}
