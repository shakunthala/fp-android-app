package com.project.foodpipe.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.project.foodpipe.R;
import com.project.foodpipe.adapters.MenuListAdapter;

public class MenuDetailsActivity extends Activity {

	String[] menuTitle = { "Menu - I", "Menu - II", "Menu - III", "Menu - IV" };
	String[] menuSubTitle = {
			"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ",
			"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ",
			"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ",
			"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " };

	int[] menuImageId = { R.drawable.food_img, R.drawable.food_img,
			R.drawable.food_img, R.drawable.food_img };
	ListView menuListView;
	Button btnMenuDetails;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_page);
		menuListView = (ListView) findViewById(R.id.menuList);
	
//		btnMenuDetails = (Button) findViewById(R.id.btnDetails);
	
		
		MenuListAdapter adapter = new MenuListAdapter(MenuDetailsActivity.this,
				menuTitle, menuSubTitle, menuImageId);
		menuListView.setAdapter((ListAdapter) adapter);
//
//		btnMenuDetails.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				//What has to be done here???
//				//From onClick of Details...
//			}
//		});
//		
		
	}

}
