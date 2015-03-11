package com.project.foodpipe.model;

import java.util.ArrayList;

public class ModelCart {
	private  ArrayList<CartProducts> cartProducts = new ArrayList<CartProducts>();
    
	 
	   public CartProducts getProducts(int pPosition) {
	         
	        return cartProducts.get(pPosition);
	    }
	     
	    public void setProducts(CartProducts Products) {
	        
	        cartProducts.add(Products);
	         
	    }
	     
	    public int getCartSize() {
	            
	        return cartProducts.size();
	         
	    }
	  
	    public boolean checkProductInCart(CartProducts aProduct) {
	            
	        return cartProducts.contains(aProduct);
	         
	    }
	 
}
