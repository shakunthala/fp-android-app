package com.project.foodpipe.adapters;

import java.util.ArrayList;

import com.project.foodpipe.R;
import com.project.foodpipe.model.LocationDetails;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LocationListDetailsAdapter extends BaseAdapter {
	private Context mContext;
	private final String[] loc_title;
	private final String[] loc_subtitle;
	private final int[] Imageid;

	/**
	 * This method is used for constructor
	 * 
	 * @param locSubTitle
	 */
	public LocationListDetailsAdapter(Context c, String[] locTitle,
			String[] locSubTitle, int[] Imageid) {
		mContext = c;
		this.Imageid = Imageid;
		this.loc_title = locTitle;
		this.loc_subtitle = locSubTitle;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return loc_title.length;
	}

	@Override
	public Object getItem(int position) {
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
		public ImageView image;

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		ViewHolder holder = new ViewHolder();

		// First let's verify the convertView is not null
		if (convertView == null) {
			// This a new view we inflate the new layout
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.loc_list_item, null);
			// Now we can fill the layout with the right values
			TextView tv = (TextView) v.findViewById(R.id.loc_title);
			TextView distView = (TextView) v.findViewById(R.id.loc_sub_title);
			ImageView img = (ImageView) v.findViewById(R.id.loc_image);

			holder.title = tv;
			holder.subTitle = distView;
			holder.image = img;

			v.setTag(holder);
		} else
			holder = (ViewHolder) v.getTag();

		System.out.println("Position [" + position + "]");

		holder.title.setText(loc_title[position]);
		holder.subTitle.setText(loc_subtitle[position]);

		holder.image.setImageResource(Imageid[position]);

		return v;
	}

}
