package com.project.foodpipe.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.project.foodpipe.R;

public class DetailsActivity extends Activity {

	TextView webSiteLink;
	ImageView fbIcon, twitterIcon, gPlusIcon;
	Button orderNow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);

		webSiteLink = (TextView) findViewById(R.id.websiteAddress);

		fbIcon = (ImageView) findViewById(R.id.fb_icon);
		twitterIcon = (ImageView) findViewById(R.id.twitter_icon);
		gPlusIcon = (ImageView) findViewById(R.id.gplus_icon);
		
		orderNow = (Button) findViewById(R.id.orderNowButton);
		
		webSiteLink.setMovementMethod(LinkMovementMethod.getInstance());
		
		
		//onClick of ORDER NOW button, app should direct to Category page.
		orderNow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent sendToCategory = new Intent(DetailsActivity.this,CategoryActivity.class);
				startActivity(sendToCategory);
			}
		});

		fbIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				List<Intent> targetShareIntents = new ArrayList<Intent>();
				Intent shareIntent = new Intent();
				shareIntent.setAction(Intent.ACTION_SEND);
				shareIntent.setType("text/plain");
				List<ResolveInfo> resInfos = getPackageManager()
						.queryIntentActivities(shareIntent, 0);
				if (!resInfos.isEmpty()) {
					for (ResolveInfo resInfo : resInfos) {
						String packageName = resInfo.activityInfo.packageName;
						if (packageName.contains("com.facebook.lite")
								|| packageName.contains("com.facebook.katana")) {
							Intent intent = new Intent();
							intent.setComponent(new ComponentName(packageName,
									resInfo.activityInfo.name));
							intent.setAction(Intent.ACTION_SEND);
							intent.setType("text/plain");
							intent.putExtra(Intent.EXTRA_TEXT, "Title");
							intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
							intent.setPackage(packageName);
							targetShareIntents.add(intent);
						}
					}
					if (!targetShareIntents.isEmpty()) {
						Intent chooserIntent = Intent.createChooser(
								targetShareIntents.remove(0),
								"Choose app to share");
						chooserIntent
								.putExtra(Intent.EXTRA_INITIAL_INTENTS,
										targetShareIntents
												.toArray(new Parcelable[] {}));
						startActivity(chooserIntent);
					} else {
					}
				}
			}
		});
		gPlusIcon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				List<Intent> targetShareIntents = new ArrayList<Intent>();
				Intent shareIntent = new Intent();
				shareIntent.setAction(Intent.ACTION_SEND);
				shareIntent.setType("text/plain");
				List<ResolveInfo> resInfos = getPackageManager()
						.queryIntentActivities(shareIntent, 0);
				if (!resInfos.isEmpty()) {
					for (ResolveInfo resInfo : resInfos) {
						String packageName = resInfo.activityInfo.packageName;
						if (packageName
								.contains("com.google.android.apps.plus")) {
							Intent intent = new Intent();
							intent.setComponent(new ComponentName(packageName,
									resInfo.activityInfo.name));
							intent.setAction(Intent.ACTION_SEND);
							intent.setType("text/plain");
							intent.putExtra(Intent.EXTRA_TEXT, "Title");
							intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
							intent.setPackage(packageName);
							targetShareIntents.add(intent);
						}
					}
					if (!targetShareIntents.isEmpty()) {
						Intent chooserIntent = Intent.createChooser(
								targetShareIntents.remove(0),
								"Choose app to share");
						chooserIntent
								.putExtra(Intent.EXTRA_INITIAL_INTENTS,
										targetShareIntents
												.toArray(new Parcelable[] {}));
						startActivity(chooserIntent);
					} else {
					}
				}
			}
		});

		twitterIcon.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				List<Intent> targetShareIntents = new ArrayList<Intent>();
				Intent shareIntent = new Intent();
				shareIntent.setAction(Intent.ACTION_SEND);
				shareIntent.setType("text/plain");
				List<ResolveInfo> resInfos = getPackageManager()
						.queryIntentActivities(shareIntent, 0);
				if (!resInfos.isEmpty()) {
					for (ResolveInfo resInfo : resInfos) {
						String packageName = resInfo.activityInfo.packageName;
						if (packageName.contains("com.twitter.android")) {
							Intent intent = new Intent();
							intent.setComponent(new ComponentName(packageName,
									resInfo.activityInfo.name));
							intent.setAction(Intent.ACTION_SEND);
							intent.setType("text/plain");
							intent.putExtra(Intent.EXTRA_TEXT, "Title");
							intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
							intent.setPackage(packageName);
							targetShareIntents.add(intent);
						}
					}
					if (!targetShareIntents.isEmpty()) {
						Intent chooserIntent = Intent.createChooser(
								targetShareIntents.remove(0),
								"Choose app to share");
						chooserIntent
								.putExtra(Intent.EXTRA_INITIAL_INTENTS,
										targetShareIntents
												.toArray(new Parcelable[] {}));
						startActivity(chooserIntent);
					} else {
					}
				}
			}
		});

	}

	// protected void makeCall() {
	//
	// Intent intent = new Intent(Intent.ACTION_DIAL);
	// intent.setData(Uri.parse("tel:0123456789"));
	// startActivity(intent);
	//
	// }
}
