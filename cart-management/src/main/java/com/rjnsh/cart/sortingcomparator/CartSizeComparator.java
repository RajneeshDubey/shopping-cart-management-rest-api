package com.rjnsh.cart.sortingcomparator;

import com.rjnsh.cart.model.Cart;
import com.rjnsh.cart.model.Product;

import java.util.Comparator;
import java.util.Map;

public class CartSizeComparator implements Comparator<Cart> {

    @Override
    public int compare(Cart a, Cart b)
    {   return cartSize(a)-cartSize(b);

    }

    public int cartSize(Cart cart)
    {  Integer cartSize=0;
        for(Map<Product, Integer> prods:  cart.getProductList())
        {
            cartSize+=prods.values().size();
        }
        return cartSize;
    }

}
