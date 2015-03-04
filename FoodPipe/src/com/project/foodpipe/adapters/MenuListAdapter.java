package com.project.foodpipe.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.foodpipe.R;
import com.project.foodpipe.activity.DetailsActivity;
import com.project.foodpipe.activity.MenuDetailsActivity;
import com.project.foodpipe.adapters.LocationListDetailsAdapter.ViewHolder;

public class MenuListAdapter extends BaseAdapter {
	private Context mContext;
	private final String[] menuTitle;
	private final String[] menuDesc;
	private final int[] Imageid;

	public MenuListAdapter(Context c, String[] menuTitle,
			String[] menuSubTitle, int[] menuImageId) {
		mContext = c;
		this.Imageid = menuImageId;
		this.menuTitle = menuTitle;
		this.menuDesc = menuSubTitle;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return menuTitle.length;
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
		public Button btn;

	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;

		ViewHolder holder = new ViewHolder();

		// First let's verify the convertView is not null
		if (convertView == null) {
			// This a new view we inflate the new layout
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.menu_details_page, null);
			// Now we can fill the layout with the right values
			TextView tv = (TextView) v.findViewById(R.id.menuTitle);
			TextView distView = (TextView) v.findViewById(R.id.menuDesc);
			ImageView img = (ImageView) v.findViewById(R.id.menu_img);
			Button btnMenuDetails = (Button) v.findViewById(R.id.btnDetails);
			holder.title = tv;
			holder.subTitle = distView;
			holder.image = img;
			holder.btn = btnMenuDetails;
			v.setTag(holder);
		} else
			holder = (ViewHolder) v.getTag();

		System.out.println("Position [" + position + "]");

		holder.title.setText(menuTitle[position]);
		holder.subTitle.setText(menuDesc[position]);

		holder.image.setImageResource(Imageid[position]);

		holder.btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent dashBoardIntent = new Intent(mContext,
						DetailsActivity.class);
				mContext.startActivity(dashBoardIntent);
				dashBoardIntent = null;

			}
		});

		return v;
	}

}
