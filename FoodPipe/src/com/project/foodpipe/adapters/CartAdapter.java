package com.project.foodpipe.adapters;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.foodpipe.R;
import com.project.foodpipe.activity.DashboardActivity;
import com.project.foodpipe.helper.ShoppingCartHelper;
import com.project.foodpipe.model.Product;
import com.project.foodpipe.util.SharedPreferenceManager;

public class CartAdapter extends BaseAdapter{

	private List<Product> mProductList;
	private LayoutInflater mInflater;
	private Context mContext;
	boolean b1;

	public CartAdapter(Context c,List<Product> list, LayoutInflater inflater, boolean b) {
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
		public TextView productTitle;
		public TextView productRate;
		public ImageView cancelProduct;
		public EditText editProductNum;
		
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final ViewItem item;
		final int pos = position;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.cart_items, null);
			item = new ViewItem();

			item.productTitle = (TextView) convertView
					.findViewById(R.id.productName);

			item.productRate = (TextView) convertView.findViewById(R.id.productRate);
			
			item.cancelProduct = (ImageView) convertView.findViewById(R.id.productCancel);
			
			item.editProductNum = (EditText) convertView.findViewById(R.id.editProductQuantity);

			convertView.setTag(item);
		} else {
			item = (ViewItem) convertView.getTag();
		}

		Product curProduct = mProductList.get(position);
		
		
		item.productTitle.setText(curProduct.title);
		item.productRate.setText(curProduct.price +"");
		
		

		Log.e("ProductAdapter","title--------" + curProduct.title + "---" + "subtitle------" + curProduct.description);
	
//		item.cancelProduct.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//
//			}
//		});


		return convertView;
	}

}
