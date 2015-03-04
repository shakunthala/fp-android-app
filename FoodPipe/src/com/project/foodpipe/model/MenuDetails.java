package com.project.foodpipe.model;

public class MenuDetails {
	//private Drawable image;

		private String title = "";
		private String subTitle = "";

		
		public MenuDetails() {
			// TODO Auto-generated constructor stub
			 super();
		}
		public MenuDetails(String name, String desc){
		    super();
		    this.title = name;
		    this.subTitle = desc;
		}

		/*********** Set Methods ******************/
//		public void setImage(Drawable image) {
//			this.image = image;
//		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setSubTitle(String subTitle) {
			this.subTitle = subTitle;
		}

		/*********** Get Methods ****************/
//		public Drawable getImage() {
//			return image;
//		}

		public String getTitle() {
			return title;
		}

		public String getSubTitle() {
			return subTitle;
		}
}
