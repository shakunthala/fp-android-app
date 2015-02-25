package com.project.foodpipe.model;

import android.graphics.drawable.Drawable;

public class LocationDetails {
	//private Drawable image;

	private String title = "";
	private String subTitle = "";

	
	public LocationDetails() {
		// TODO Auto-generated constructor stub
		 super();
	}
	public LocationDetails(String name, String price) {
	    super();
	    this.title = name;
	    this.subTitle = price;
	}

	/*********** Set Methods ******************/
//	public void setImage(Drawable image) {
//		this.image = image;
//	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/*********** Get Methods ****************/
//	public Drawable getImage() {
//		return image;
//	}

	public String getTitle() {
		return title;
	}

	public String getSubTitle() {
		return subTitle;
	}
}
