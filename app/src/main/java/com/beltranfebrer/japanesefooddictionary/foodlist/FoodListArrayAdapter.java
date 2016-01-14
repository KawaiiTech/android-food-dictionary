package com.beltranfebrer.japanesefooddictionary.foodlist;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.beltranfebrer.japanesefooddictionary.R;
import com.beltranfebrer.japanesefooddictionary.data.FoodDescription;

import java.util.List;

/**
 * Created by miquel on 14.01.16.
 */
public class FoodListArrayAdapter implements ListAdapter {
    private final List<FoodDescription> itemList;
    private Context context;

    public FoodListArrayAdapter(Context context, List<FoodDescription> itemList) {
        this.itemList = itemList;
        this.context = context;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.food_item, null);
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
