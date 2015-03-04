package com.project.foodpipe.activity;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.EditText;

import com.project.foodpipe.R;

public class SignUpActivity extends Activity { 
	
	EditText fullName, mobileNo, emailID, password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		
		fullName= (EditText) findViewById(R.id.fullName);
		mobileNo= (EditText) findViewById(R.id.mobileNumber);
		emailID= (EditText) findViewById(R.id.emailId);
		password= (EditText) findViewById(R.id.password);
		
		
		fullName.setHint(Html.fromHtml("<large>"
				+ getResources().getString(R.string.full_name) + "</large>"));
		password.setHint(Html.fromHtml("<medium>"
				+ getResources().getString(R.string.password) + "</medium>"));
		emailID.setHint(Html.fromHtml("<large>"
				+ getResources().getString(R.string.email_id) + "</large>"));
		mobileNo.setHint(Html.fromHtml("<medium>"
				+ getResources().getString(R.string.mobile_no) + "</medium>"));
		
	}
}
