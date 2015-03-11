package com.project.foodpipe.model;

public class CartProducts {

	private String productName;
	private String productDesc;
	private int productPrice;

	public CartProducts(String productName, String productDesc, int productPrice) {
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
	}

	public String getProductName() {

		return productName;
	}

	public String getProductDesc() {

		return productDesc;
	}

	public int getProductPrice() {

		return productPrice;
	}

}
