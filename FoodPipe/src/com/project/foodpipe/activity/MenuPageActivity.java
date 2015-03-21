package com.project.foodpipe.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.project.foodpipe.R;
import com.project.foodpipe.adapters.ProductAdapter;
import com.project.foodpipe.model.Product;
import com.project.foodpipe.util.SharedPreferenceManager;
import com.project.foodpipe.helper.ShoppingCartHelper;

public class MenuPageActivity extends Activity {

	ListView menuListView;
	private List<Product> mProductList;
	List<Product> cart;
	Product selectedProduct;
	List<Product> catalog;
	int productIndex;
	ProductAdapter productAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_page);

		menuListView = (ListView) findViewById(R.id.menuList);

		// Obtain a reference to the product catalog
		mProductList = ShoppingCartHelper.getCatalog(getResources());

		menuListView.setAdapter(new ProductAdapter(this, mProductList,
				getLayoutInflater(), false));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.findItem(R.id.search).setVisible(false);
		return true;
	}

	public void onResume() {
		super.onResume();

	}

	public void onPause() {
		super.onPause();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		super.onOptionsItemSelected(item);

		switch (item.getItemId()) {
		case R.id.action_add_to_cart:
			catalog = ShoppingCartHelper.getCatalog(getResources());
			cart = ShoppingCartHelper.getCart();

			productIndex = SharedPreferenceManager
					.getIntPreference(ShoppingCartHelper.PRODUCT_INDEX);
			selectedProduct = catalog.get(productIndex);
			cart.add(selectedProduct);

			Intent cartIntent = new Intent(MenuPageActivity.this,
					ShoppingCartActivity.class);
			startActivity(cartIntent);
			break;
		}
		return true;

	}

}
