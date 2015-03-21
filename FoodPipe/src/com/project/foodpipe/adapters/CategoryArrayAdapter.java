package com.project.foodpipe.adapters;

import com.project.foodpipe.R;
import com.project.foodpipe.activity.CategoryActivity;
import com.project.foodpipe.activity.DetailsActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CategoryArrayAdapter extends BaseAdapter {
	private Context mContext;
	private final String[] categoryTitle;
	private final String[] categoryDesc;

	public CategoryArrayAdapter(Context c, String[] title,
			String[] desc) {
		mContext = c;
		this.categoryTitle = title;
		this.categoryDesc = desc;
		}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return categoryTitle.length;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static class ViewHolder {

		public TextView title;
		public TextView subTitle;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		ViewHolder holder = new ViewHolder();

		// First let's verify the convertView is not null
		if (convertView == null) {
			// This a new view we inflate the new layout
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.category_list_item, null);
			// Now we can fill the layout with the right values
			TextView tv = (TextView) v.findViewById(R.id.txtCategoryTitle);
			TextView distView = (TextView) v.findViewById(R.id.txtCategoryDesc);

			holder.title = tv;
			holder.subTitle = distView;

			v.setTag(holder);
		} else
			holder = (ViewHolder) v.getTag();

		System.out.println("Position [" + position + "]");

		holder.title.setText(categoryTitle[position]);
		holder.subTitle.setText(categoryDesc[position]);

		return v;
	}
}
