package com.project.foodpipe.activity;

import android.app.SearchManager;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;

import com.project.foodpipe.R;


@SuppressWarnings("deprecation")
public class LocationActivity extends TabActivity {
	 TabHost mTabHost;
	 FrameLayout mFrameLayout;
	 ListView listView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location);
		
		//This is to change the tab bottom line color.
		
//		TabHost host = (TabHost)findViewById(R.id.);
//		TabWidget widget = host.getTabWidget();
//		for(int i = 0; i < widget.getChildCount(); i++) {
//		    View v = widget.getChildAt(i);
//
//		    // Look for the title view to ensure this is an indicator and not a divider.
//		    TextView tv = (TextView)v.findViewById(android.R.id.title);
//		    if(tv == null) {
//		        continue;
//		    }
//		    v.setBackgroundResource(R.drawable.your_tab_selector_drawable);
//		}
		
		 mTabHost = getTabHost();
		    TabSpec tabSpec = mTabHost.newTabSpec("tab_test1");
		    tabSpec.setIndicator("Map");
		    Context ctx = this.getApplicationContext();
		    Intent mapIntent = new Intent(ctx, MapTabView.class);
		    tabSpec.setContent(mapIntent);
		    mTabHost.addTab(tabSpec);
		    TabSpec tabSpec2 = mTabHost.newTabSpec("tab_test2");
		    tabSpec2.setIndicator("List");
		    Intent listIntent = new Intent(this, ListTabView.class);
		    tabSpec2.setContent(listIntent);
		    mTabHost.addTab(tabSpec2);
		    mTabHost.setCurrentTab(0);
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
		
		menu.findItem(R.id.action_add_to_cart).setVisible(false);

		return true;

	}

}