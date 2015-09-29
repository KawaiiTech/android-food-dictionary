package com.beltranfebrer.japanesefooddictionary;

import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.beltranfebrer.japanesefooddictionary.data.CategoryIcons;
import com.beltranfebrer.japanesefooddictionary.data.FoodDescription;
import com.beltranfebrer.japanesefooddictionary.data.FoodDictionaryFromJson;

import java.io.IOException;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FoodListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FoodListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FoodListFragment extends Fragment implements AdapterView.OnItemClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ICON_DICTIONARY_ASSET = "iconIDdict.json";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ListAdapter mAdapter;
    private AbsListView mListView;
    private EditText mSearchField;
    private FoodDictionaryFromJson foodDictionary;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FoodListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FoodListFragment newInstance(String param1, String param2) {
        FoodListFragment fragment = new FoodListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FoodListFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        try {
            CategoryIcons categoryIcons = new CategoryIcons();
            categoryIcons.loadDictionary(getContext(), ICON_DICTIONARY_ASSET);
            foodDictionary = new FoodDictionaryFromJson(categoryIcons);
            foodDictionary.loadDictionary(getContext(), "foodDict.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        mAdapter = new CustomArrayAdapter(getActivity(), foodDictionary.search(""));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_food_list, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(R.id.listView);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);

        mSearchField = (EditText) view.findViewById(R.id.editText);
        mSearchField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateListWithSearch(s.toString());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void updateListWithSearch(String search) {
        mAdapter = new CustomArrayAdapter(getActivity(), foodDictionary.search(search));
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // TODO
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    private class CustomArrayAdapter implements ListAdapter {
        private final List<FoodDescription> itemList;
        private final FragmentActivity activity;

        public CustomArrayAdapter(FragmentActivity activity, List<FoodDescription> itemList) {
            this.itemList = itemList;
            this.activity = activity;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return false;
        }

        @Override
        public boolean isEnabled(int position) {
            return false;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int position) {
            return itemList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return itemList.get(position).hashCode();
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = activity.getLayoutInflater().inflate(R.layout.food_item, null);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.japaneseTextView);
            textView.setText(itemList.get(position).japanese);
            textView = (TextView) convertView.findViewById(R.id.englishTextView);
            textView.setText(itemList.get(position).english);
            textView = (TextView) convertView.findViewById(R.id.pronunciationTextView);
            textView.setText(itemList.get(position).pronunciation);
            return convertView;
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }
    }
}
