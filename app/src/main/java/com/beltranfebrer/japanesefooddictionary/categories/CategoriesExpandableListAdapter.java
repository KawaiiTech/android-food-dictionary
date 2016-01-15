package com.beltranfebrer.japanesefooddictionary.categories;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.beltranfebrer.japanesefooddictionary.R;
import com.beltranfebrer.japanesefooddictionary.data.FoodCategory;

import java.util.List;

/**
 * Created by miquel on 9/27/2015.
 */
public class CategoriesExpandableListAdapter implements ExpandableListAdapter {
    private final Context context;
    private final List<FoodCategory> categories;

    public CategoriesExpandableListAdapter(Context context, List<FoodCategory> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return categories.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return categories.get(groupPosition).getFoodDescriptionList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categories.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return categories.get(groupPosition).getFoodDescriptionList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return categories.get(groupPosition).hashCode();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return categories.get(groupPosition).getFoodDescriptionList().get(childPosition).hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.cat_item, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.catTextView);
        textView.setText(categories.get(groupPosition).toString());
        ImageView imageView = (ImageView) convertView.findViewById(R.id.catImageView);
        Integer iconIdValue = context.getResources().getIdentifier(categories.get(groupPosition).iconRes, "drawable", "com.miquelbeltran.japanesefooddictionary");
        imageView.setImageResource(iconIdValue);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.food_item, null);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.japaneseTextView);
        textView.setText(categories.get(groupPosition).getFoodDescriptionList().get(childPosition).japanese);
        textView = (TextView) convertView.findViewById(R.id.englishTextView);
        textView.setText(categories.get(groupPosition).getFoodDescriptionList().get(childPosition).english);
        textView = (TextView) convertView.findViewById(R.id.pronunciationTextView);
        textView.setText(categories.get(groupPosition).getFoodDescriptionList().get(childPosition).pronunciation);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return categories.isEmpty();
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
}
