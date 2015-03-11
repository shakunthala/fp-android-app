package com.project.foodpipe.model;

import java.util.ArrayList;

import android.app.Application;

public class Product extends Application{
    
   private  ArrayList<CartProducts> myProducts = new ArrayList<CartProducts>();
   private  ModelCart myCart = new ModelCart();
    

   public CartProducts getProducts(int pPosition) {
        
       return myProducts.get(pPosition);
   }
    
   public void setProducts(CartProducts Products) {
       
       myProducts.add(Products);
        
   }   
    
   public ModelCart getCart() {
           
       return myCart;
        
   }
 
  public int getProductsArraylistSize() {
        
       return myProducts.size();
   }
   
}