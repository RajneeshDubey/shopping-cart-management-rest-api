package com.rjnsh.cart.service;

import com.rjnsh.cart.exeptions.CartNotFoundException;
import com.rjnsh.cart.exeptions.ProductNotFoundException;
import com.rjnsh.cart.model.Cart;
import com.rjnsh.cart.model.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cartManagementService")
public interface CartManagementService {

    //making this cart static to store some dummy cart value
    public static Map<Integer, Cart> carts = new HashMap<Integer,Cart>();

    Boolean addProduct(Integer cartId, Product p, Integer qty);

    Boolean removeProduct(String pid) throws CartNotFoundException;

    List<Cart> fetchCartsByStatus(String status) throws CartNotFoundException;

    Map<String, Integer> fetchCartsByProdCategory(String prodCategory) throws CartNotFoundException;

    Map<String, Integer> fetchProdHistory(String prodId) throws ProductNotFoundException;
}
