package com.project.foodpipe.activity;

import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import com.project.foodpipe.R;
import com.project.foodpipe.adapters.GridViewAdapter;

public class DashboardActivity extends NavigationDrawerActivity {
	ImageView imageView;
	GridView gridView;
	
	//These values needs to be moved to string file.
	String[] imageTitle = { "Table Ordering", "Take Away", "Home Delivery",
			"Book a Table  " };
	int[] imageId = { R.drawable.dining, R.drawable.take_away,
			R.drawable.delivery, R.drawable.table };

	// Check whether Location is ON or NOT.
	boolean isGPSEnabled = false;
	AlertDialog.Builder toTurnOnGPSAlert;

	protected AlertDialog alertDialog;

	Context context;
	LocationManager locationManager;
	Criteria criteria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);

		locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);

		setActionBarTitle(getTitle());
		setNavDrawerMenu(0);
		getDrawerList().setOnItemClickListener(
				new SlideMenuClickListener(getDrawerLayout(), 0));

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		imageView = (ImageView) findViewById(R.id.dashboardImage);

		gridView = (GridView) findViewById(R.id.dashboardGrid);

		//IS THIS REQUIRED HERE???
	//	checkGPSStatus();
		
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

	public void checkGPSStatus() {
		if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			// If not GPS enabled, ask user to turn on GPS/Location.
			enableGPS();
		} else {
			// If GPS is ON, then get the current location of the user.
			// getLocation();
		}
	}

	/**
	 * Alert message to ask user to turn on GPS.
	 */
	private void enableGPS() {
		// TODO: write a generic dialog opener which can used for all test-unit.
		toTurnOnGPSAlert = new AlertDialog.Builder(DashboardActivity.this);
		// set title
		toTurnOnGPSAlert.setTitle("Turn ON GPS");
		// set dialog message
		toTurnOnGPSAlert
				.setMessage("Please turn on Location Services in your device")
				.setCancelable(false)
				.setPositiveButton("Continue",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {

								dialog.dismiss();
								if (!locationManager
										.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
									Intent intent = new Intent(
											Settings.ACTION_LOCATION_SOURCE_SETTINGS);
									// startActivity(intent);
									startActivityForResult(intent, 12);
								} else {
									checkGPSStatus();
								}
							}
						})
				.setNegativeButton("Cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dialog.dismiss();

							}
						})
				.setOnKeyListener(new DialogInterface.OnKeyListener() {

					@Override
					public boolean onKey(DialogInterface dialog, int keyCode,
							KeyEvent event) {
						if (keyCode == KeyEvent.KEYCODE_BACK) {

						}
						return false;
					}
				});
		// creates the alert dialog
		alertDialog = toTurnOnGPSAlert.create();
		if (!alertDialog.isShowing()) {
			alertDialog.show();
		}
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
