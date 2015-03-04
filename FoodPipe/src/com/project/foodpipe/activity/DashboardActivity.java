package com.project.foodpipe.activity;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.project.foodpipe.R;
import com.project.foodpipe.adapters.GridViewAdapter;

public class DashboardActivity extends NavigationDrawerActivity {
	ImageView imageView;
	GridView gridView;
	String[] imageTitle = { "Table Ordering", "Take Away", "Home Delivery", "Book a Table  " };
	int[] imageId = { R.drawable.beer_img, R.drawable.coffee_img,
			R.drawable.concert_img, R.drawable.hotel_img };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		setActionBarTitle(getTitle());
		setNavDrawerMenu(0);
		getDrawerList().setOnItemClickListener(
				new SlideMenuClickListener(getDrawerLayout(), 0));

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		imageView = (ImageView) findViewById(R.id.dashboardImage);

		gridView = (GridView) findViewById(R.id.dashboardGrid);

		GridViewAdapter adapter = new GridViewAdapter(DashboardActivity.this,
				imageTitle, imageId);
		gridView.setAdapter((ListAdapter) adapter);
		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(DashboardActivity.this,
						"You Clicked at " + imageTitle[+position],
						Toast.LENGTH_SHORT).show();

				Intent sendToLocation = new Intent(DashboardActivity.this,
						LocationActivity.class);
				startActivity(sendToLocation);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		// Associate searchable configuration with the SearchView
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.search)
				.getActionView();
		searchView.setSearchableInfo(searchManager
				.getSearchableInfo(getComponentName()));

		return true;

	}
}
