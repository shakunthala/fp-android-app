package com.project.foodpipe.adapters;

import java.util.List;

import com.project.foodpipe.helper.ShoppingCartHelper;
import com.project.foodpipe.R;
import com.project.foodpipe.activity.DashboardActivity;
import com.project.foodpipe.activity.DetailsActivity;
import com.project.foodpipe.activity.ShoppingCartActivity;
import com.project.foodpipe.model.Product;
import com.project.foodpipe.util.SharedPreferenceManager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductAdapter extends BaseAdapter {

	private List<Product> mProductList;
	private LayoutInflater mInflater;
	private Context mContext;
	boolean b1;

	public ProductAdapter(Context c,List<Product> list, LayoutInflater inflater, boolean b) {
		mProductList = list;
		mInflater = inflater;
		b1 = b;
		mContext = c;
	}

	@Override
	public int getCount() {
		return mProductList.size();
	}

	@Override
	public Object getItem(int position) {
		return mProductList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	
	private class ViewItem {
		public TextView title;
		public TextView subTitle;
		public ImageView image;
		public Button details, addMenu;
		
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewItem item;
		final int pos = position;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.menu_details_page, null);
			item = new ViewItem();

			item.image = (ImageView) convertView
					.findViewById(R.id.menu_img);

			item.title = (TextView) convertView
					.findViewById(R.id.menuTitle);

			item.subTitle = (TextView) convertView
					.findViewById(R.id.menuDesc);
			
			item.details = (Button) convertView.findViewById(R.id.btnDetails);
			
			item.addMenu = (Button) convertView.findViewById(R.id.btnAddMenu);

			convertView.setTag(item);
		} else {
			item = (ViewItem) convertView.getTag();
		}

		Product curProduct = mProductList.get(position);
		
		item.image.setImageDrawable(curProduct.productImage);
		item.title.setText(curProduct.title);
		item.subTitle.setText(curProduct.description);

		Log.e("ProductAdapter","title--------" + curProduct.title + "---" + "subtitle------" + curProduct.description);
	
		item.details.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent dashBoardIntent = new Intent(mContext,
						DashboardActivity.class);
				mContext.startActivity(dashBoardIntent);
			//	dashBoardIntent = null;

			}
		});

		
		// Add to cart functionality needs to be implemented here..
		item.addMenu.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(mContext, "You have added an item to cart", Toast.LENGTH_LONG).show();
				SharedPreferenceManager.setPreference(ShoppingCartHelper.PRODUCT_INDEX, pos);
				
//				Intent productDetailsIntent = new Intent(mContext ,ShoppingCartActivity.class);
//			    productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX,pos);
//			    Log.e("ADD MENU ON CLICK","curPosition------" +pos);
//			    mContext.startActivity(productDetailsIntent);
			}
		});


		return convertView;
	}

	
}