package com.rjnsh.cart.sortingcomparator;

import com.rjnsh.cart.model.Cart;
import com.rjnsh.cart.model.Product;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;

public class CartValueComparator implements Comparator<Cart> {

    @Override
    public int compare(Cart a, Cart b)
    {   return cartValue(a)-cartValue(b);

    }

    public Integer cartValue(Cart cart)
    {  BigDecimal cartValue=BigDecimal.ZERO;

        for(Map<Product, Integer> prods:  cart.getProductList())
        {
            for(Map.Entry<Product,Integer> prodDetail : prods.entrySet())
            {
                cartValue = cartValue.add(prodDetail.getKey().getPrice().multiply(BigDecimal.valueOf(prodDetail.getValue())));
            }
        }
        return cartValue.intValue();
    }

}