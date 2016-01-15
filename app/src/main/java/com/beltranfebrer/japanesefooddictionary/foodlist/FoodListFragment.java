package com.beltranfebrer.japanesefooddictionary.foodlist;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;

import com.beltranfebrer.japanesefooddictionary.R;

public class FoodListFragment extends Fragment implements FoodListView {
    private AbsListView listView;
    private EditText searchField;
    private FoodListPresenter presenter = new FoodListPresenter(this);

    public FoodListFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_list, container, false);
        // Set the adapter
        listView = (AbsListView) view.findViewById(R.id.listView);
        searchField = (EditText) view.findViewById(R.id.editText);
        searchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.search(s.toString());
            }
        });

        presenter.createModel(getContext());
        presenter.search("");
        return view;
    }

    @Override
    public void updateAdapter(FoodListArrayAdapter adapter) {
        listView.setAdapter(adapter);
    }
}
