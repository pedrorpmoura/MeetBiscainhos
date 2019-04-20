package com.example.pedrorpmoura.teste;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.Object;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private List<ExpandedMenuModel> mListDataHeader;

    // child data
    private HashMap<ExpandedMenuModel, List<String>> mListDataChild;
    ExpandableListView expandList;

    public ExpandableListAdapter(Context context, List<ExpandedMenuModel> listDataHeader,
                                 HashMap<ExpandedMenuModel, List<String>> listDataChild,
                                 ExpandableListView view) {
        this.mContext = context;
        this.mListDataHeader = listDataHeader;
        this.mListDataChild = listDataChild;
        this.expandList = view;
    }

    @Override
    public int getGroupCount() {
        return this.mListDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.mListDataChild.get(this.mListDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.mListDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.mListDataChild.get(this.mListDataHeader.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        ExpandedMenuModel headerTitle = (ExpandedMenuModel) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.expanded_list_group);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle.getIconName());

        View ind = convertView.findViewById(R.id.explist_indicator);

        if (ind != null)
        {
            ImageView indicator = (ImageView) ind;
            if (groupPosition != 1)
            {
                indicator.setVisibility(View.INVISIBLE);
            }
            else
            {
                indicator.setVisibility(View.VISIBLE);
                indicator.setImageResource(
                        isExpanded ?
                                R.drawable.baseline_expand_more_black_18dp :
                                R.drawable.baseline_expand_less_black_18dp);
                indicator.setColorFilter(ContextCompat.getColor(
                        mContext, R.color.colorDefault));
            }
        }

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.expanded_list_item);

        txtListChild.setText(childText);


        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
