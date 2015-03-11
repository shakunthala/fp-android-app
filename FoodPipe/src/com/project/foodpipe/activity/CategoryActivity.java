package com.project.foodpipe.activity;

import com.project.foodpipe.R;
import com.project.foodpipe.adapters.CategoryArrayAdapter;
import com.project.foodpipe.adapters.MenuListAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CategoryActivity extends Activity {
	
	ListView categoryList;
	String[] categoryTitle = { "Menu Title I", "Menu Title II", "Menu Title III", "Menu Title IV" };
	String[] categoryDesc = {
			"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ",
			"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ",
			"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ",
			"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		
		categoryList = (ListView) findViewById(R.id.category_list);
		
		CategoryArrayAdapter adapter = new CategoryArrayAdapter(CategoryActivity.this,
				categoryTitle, categoryDesc);
		categoryList.setAdapter((ListAdapter) adapter);

		categoryList.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Object item = categoryList.getItemAtPosition(position);
				//Need to pass the id of the category in Intent.putExtra() to display menu details under that particular category in menu page.
				//For now, only sending the intent.
				Intent menuDetailsIntent = new Intent(CategoryActivity.this, MenuDetailsActivity.class);
				startActivity(menuDetailsIntent);
			}
		});
	}
}
