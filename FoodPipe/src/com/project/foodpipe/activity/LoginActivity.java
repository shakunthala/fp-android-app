package com.project.foodpipe.activity;

import com.facebook.UiLifecycleHelper;
import com.project.foodpipe.R;
import com.project.foodpipe.fragment.MainFragment;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Plus;

public class LoginActivity extends FragmentActivity
		implements
		ConnectionCallbacks,
		OnConnectionFailedListener,
		com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks,
		com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener {

	EditText userName, passWord;
	Button login;
	private MainFragment mainFragment;
	private static final String TAG = "LoginActivity";

	/* Request code used to invoke sign in user interactions. */
	private static final int RC_SIGN_IN = 0;

	/* Client used to interact with Google APIs. */
	private GoogleApiClient mGoogleApiClient;

	/*
	 * A flag indicating that a PendingIntent is in progress and prevents us
	 * from starting further intents.
	 */
	private boolean mIntentInProgress;
	/*
	 * Track whether the sign-in button has been clicked so that we know to
	 * resolve all issues preventing sign-in without waiting.
	 */
	private boolean mSignInClicked;

	/*
	 * Store the connection result from onConnectionFailed callbacks so that we
	 * can resolve them when the user clicks sign-in.
	 */
	private ConnectionResult mConnectionResult;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		mGoogleApiClient = new GoogleApiClient.Builder(this)
				.addConnectionCallbacks(this)
				.addOnConnectionFailedListener(this).addApi(Plus.API)
				.addScope(Plus.SCOPE_PLUS_LOGIN).build();

		userName = (EditText) findViewById(R.id.txtUsername);
		passWord = (EditText) findViewById(R.id.txtPassword);
		login = (Button) findViewById(R.id.btnLogin);

		// For setting hint inside the EditText.
		userName.setHint(Html.fromHtml("<large>"
				+ getResources().getString(R.string.email_id) + "</large>"));
		passWord.setHint(Html.fromHtml("<medium>"
				+ getResources().getString(R.string.password) + "</medium>"));

		login.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// For now, if the user clicks on the login button app will
				// direct to DashboardActivity.
				// Later - login credentials to be added, if it is valid the
				// app
				// will direct to DashboardActivity.

				Intent dashBoardIntent = new Intent(getApplicationContext(),
						DashboardActivity.class);
				startActivity(dashBoardIntent);
				dashBoardIntent = null;
				finish();

			}
		});
		
		//The commented code will give the scope to facebook login and normal login becomes dummy. 
		//Inorder to avoid that and give equal scope to all, commented the check == null code.

		// if (savedInstanceState == null) {
		// // Add the fragment on initial activity setup
		// mainFragment = new MainFragment();
		// getSupportFragmentManager().beginTransaction()
		// .add(android.R.id.content, mainFragment).commit();
		// } else {
		// Or set the fragment from restored state info
		mainFragment = (MainFragment) getSupportFragmentManager()
				.findFragmentById(android.R.id.content);
		// }

	}

	public void signIn(View view) {
		if (view.getId() == R.id.sign_in_button
				&& !mGoogleApiClient.isConnecting()) {
			mSignInClicked = true;

			resolveSignInError();
		}
	}

//	public void onClick(View view) {
//
//		 //SIGN-OUT PROCESS
//		//Need to change the icon.
//		 if (view.getId() == R.id.sign_in_button) {
//		 if (mGoogleApiClient.isConnected()) {
//		 Plus.AccountApi.clearDefaultAccount(mGoogleApiClient);
//		 mGoogleApiClient.disconnect();
//		 mGoogleApiClient.connect();
//			Toast.makeText(this, "User is disconnected!", Toast.LENGTH_LONG).show();
//		 }
//		 }
//	}

	@Override
	public void onConnectionFailed(ConnectionResult result) {
		if (!mIntentInProgress && result.hasResolution()) {
			try {
				mIntentInProgress = true;
				startIntentSenderForResult(result.getResolution()
						.getIntentSender(), RC_SIGN_IN, null, 0, 0, 0);
			} catch (SendIntentException e) {
				// The intent was canceled before it was sent. Return to the
				// default
				// state and attempt to connect to get an updated
				// ConnectionResult.
				mIntentInProgress = false;
				mGoogleApiClient.connect();
			}
		}
	}

	public void onConnected(Bundle connectionHint) {
		// We've resolved any connection errors. mGoogleApiClient can be used to
		// access Google APIs on behalf of the user.

		mSignInClicked = false;
		Toast.makeText(this, "User is connected!", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onDisconnected() {
		// TODO Auto-generated method stub

	}

	protected void onStart() {
		super.onStart();
		mGoogleApiClient.connect();
	}

	protected void onStop() {
		super.onStop();

		if (mGoogleApiClient.isConnected()) {
			mGoogleApiClient.disconnect();
		}
	}

	protected void onActivityResult(int requestCode, int responseCode,
			Intent intent) {
		if (requestCode == RC_SIGN_IN) {
			mIntentInProgress = false;

			if (!mGoogleApiClient.isConnecting()) {
				mGoogleApiClient.connect();
			}
		}
	}

	public void onConnectionSuspended(int cause) {
		mGoogleApiClient.connect();
	}

	/* A helper method to resolve the current ConnectionResult error. */
	private void resolveSignInError() {
		if (mConnectionResult.hasResolution()) {
			try {
				mIntentInProgress = true;
				startIntentSenderForResult(mConnectionResult.getResolution()
						.getIntentSender(), RC_SIGN_IN, null, 0, 0, 0);
			} catch (SendIntentException e) {
				// The intent was canceled before it was sent. Return to the
				// default
				// state and attempt to connect to get an updated
				// ConnectionResult.
				mIntentInProgress = false;
				mGoogleApiClient.connect();
			}
		}
	}

}
