package com.project.foodpipe.helper;

import java.util.List;
import java.util.Vector;

import com.project.foodpipe.R;
import com.project.foodpipe.model.Product;

import android.content.res.Resources;

public class ShoppingCartHelper {
	
	public static final String PRODUCT_INDEX = "PRODUCT_INDEX";

	private static List<Product> catalog;
	private static List<Product> cart;

	public static List<Product> getCatalog(Resources res) {
		if (catalog == null) {
			catalog = new Vector<Product>();
			catalog.add(new Product("Menu - I", res
					.getDrawable(R.drawable.food_img),
					"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ", 29.99));
			catalog.add(new Product("Menu - II", res
					.getDrawable(R.drawable.food_img),
					"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ", 24.99));
			catalog.add(new Product("Menu - III", res
					.getDrawable(R.drawable.food_img),
					"Lorem ipsum dolor sit amet or incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud ", 14.99));
		}

		return catalog;
	}

	public static List<Product> getCart() {
		if (cart == null) {
			cart = new Vector<Product>();
		}

		return cart;
	}
}
