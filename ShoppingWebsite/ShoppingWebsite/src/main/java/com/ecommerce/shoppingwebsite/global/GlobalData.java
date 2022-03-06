package com.ecommerce.shoppingwebsite.global;

import java.util.ArrayList;
import java.util.List;



import com.ecommerce.shoppingwebsite.entity.Product;

public class GlobalData {
public static List<Product> cart;
  static {
	  cart=new ArrayList<Product>();
	  
  }
}
