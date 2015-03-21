package com.project.foodpipe.activity;

import com.project.foodpipe.R;
import com.project.foodpipe.adapters.LocationListDetailsAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class ListTabView extends Activity {
	
	String[] locTitle = { "Bars", "Coffee Shops", "Concerts", "Restaurants" };
	String[] locSubTitle = { "Bars", "Coffee Shops", "Concerts", "Restaurants" };
	int[] locImageId = { R.drawable.dining, R.drawable.take_away,
			R.drawable.delivery, R.drawable.table };
	ListView listTabView;
	 @Override
	  protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.list_tab_view_layout);
	    listTabView = (ListView) findViewById(R.id.listTabView);
	    
		LocationListDetailsAdapter adapter = new LocationListDetailsAdapter(ListTabView.this,
				locTitle, locSubTitle, locImageId);
		listTabView.setAdapter((ListAdapter) adapter);
		
		//Directing the screen to details page on click of list item.
		listTabView
		.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Object item = listTabView.getItemAtPosition(position);
				Intent detailsIntent = new Intent(
						ListTabView.this, DetailsActivity.class);
				startActivity(detailsIntent);
			}
		});
	 }
	 
}
