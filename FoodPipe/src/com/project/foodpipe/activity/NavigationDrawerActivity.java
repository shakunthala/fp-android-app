package com.project.foodpipe.activity;

import java.util.ArrayList;

import com.project.foodpipe.R;
import com.project.foodpipe.adapters.NavDrawerListAdapter;
import com.project.foodpipe.model.NavDrawerItem;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

abstract public class NavigationDrawerActivity extends Activity {

	private CharSequence actionBarTitle;
	// slide menu items
	private String[] navMenuTitles;
	private TypedArray navMenuIcons;
	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;
	private DrawerLayout drawerLayout;
	private ListView drawerList;
	private TextView testLogo;
	private ActionBarDrawerToggle drawerToggle;
	private RelativeLayout mDrawerRelativeLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	protected void setActionBarTitle(CharSequence charSequence) {
		actionBarTitle = charSequence;
	}

	protected CharSequence getActionBarTitle() {
		return actionBarTitle;
	}

	protected DrawerLayout getDrawerLayout() {
		return drawerLayout;
	}

	protected ActionBarDrawerToggle getDrawerToggle() {
		return drawerToggle;
	}

	protected ListView getDrawerList() {
		return drawerList;
	}

	protected void setNavDrawerMenu(int from) {
		// testLogo = (TextView) findViewById(R.id.loggedUser);
		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
		// nav drawer icons from resources
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerList = (ListView) findViewById(R.id.list_slidermenu);
		// mDrawerRelativeLayout = (RelativeLayout)
		// findViewById(R.id.drawer_layout);
		drawerList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		// drawerLayout.closeDrawer(mDrawerRelativeLayout);
		navDrawerItems = new ArrayList<NavDrawerItem>();
		for (int i = 0; i < 4; i++) {
			navDrawerItems.add(new NavDrawerItem(navMenuTitles[i], navMenuIcons
					.getResourceId(i, -1)));
		}
		navMenuIcons.recycle();

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems, from);
		drawerList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		drawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.app_name, R.string.app_name) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(getActionBarTitle());
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(getActionBarTitle());
				invalidateOptionsMenu();
				drawerView.bringToFront();

			}
		};
		drawerLayout.setDrawerListener(drawerToggle);
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

	@Override
	public void setTitle(CharSequence title) {
		setActionBarTitle(title);
		getActionBar().setTitle(getActionBarTitle());
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		getDrawerToggle().syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		getDrawerToggle().onConfigurationChanged(newConfig);
	}

	/**
	 * Slide menu item click listener
	 * */
	public class SlideMenuClickListener implements ListView.OnItemClickListener {
		DrawerLayout slideMenuDrawerLayout;
		int fromId;

		SlideMenuClickListener(DrawerLayout mDrawerLayout, int fromId) {
			this.slideMenuDrawerLayout = mDrawerLayout;
			this.fromId = fromId;
		}

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			displayView(position, fromId);
			slideMenuDrawerLayout.closeDrawers();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Pass the event to ActionBarDrawerToggle, if it returns
		// true, then it has handled the app icon touch event
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle your other action bar items...

		return super.onOptionsItemSelected(item);
	}

	public void displayView(int position, int fromId) {
		// update the main content by replacing fragments

		switch (position) {
		case 0:
			if (fromId != 0) {
				Intent i = new Intent(NavigationDrawerActivity.this, DetailsActivity.class);
				startActivity(i);
			}
			break;
		case 1:
			if (fromId != 1) {

			}
			break;
		case 2:
			if (fromId != 2) {

			}
			break;
		case 3:
			if (fromId != 3) {

			}
			break;

		default:
			break;
		}

	}
}