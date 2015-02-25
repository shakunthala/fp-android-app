package com.project.foodpipe.adapters;

import java.util.ArrayList;

import com.project.foodpipe.R;
import com.project.foodpipe.model.NavDrawerItem;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NavDrawerListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;
    private int from;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems, int from) {
        this.context = context;
        this.navDrawerItems = navDrawerItems;
        this.from = from;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }
        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
        txtTitle.setText(navDrawerItems.get(position).getTitle());

        if (position == 0) {
            imgIcon.setPadding(6, 90, 0, 5);
            txtTitle.setPadding(5, 104, 0, 5);

        }
        if (position == from) {
         //   convertView.setBackgroundResource(R.drawable.slider_item_bg_pressed);
            imgIcon.setSelected(true);
            txtTitle.setSelected(true);

        }
        return convertView;
    }
}
