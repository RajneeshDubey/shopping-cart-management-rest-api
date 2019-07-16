package com.rjnsh.cart.service;

import com.rjnsh.cart.constants.ProductCategoryEnum;
import com.rjnsh.cart.sortingcomparator.CartSizeComparator;
import com.rjnsh.cart.exeptions.CartNotFoundException;
import com.rjnsh.cart.exeptions.ProductNotFoundException;
import com.rjnsh.cart.model.Cart;
import com.rjnsh.cart.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import java.util.*;

@Component("cartManagementServiceImpl")
public class CartManagementServiceImpl implements CartManagementService {

    @Override
    public Boolean addProduct(Integer cartId, Product p, Integer qty) throws CartNotFoundException {

        Map<Product, Integer> items = new HashMap<>();
        items.put(p, qty);
        try {
            if (carts.get(cartId) == null) {
                carts.get(cartId).getProductList().add(items);
            }
        } catch (Exception e) {
            throw new CartNotFoundException("Cart not available");
        }
        return true;
    }

    @Override
    public Boolean removeProduct(String pid) throws ProductNotFoundException {
        return false;
    }


    @Override
    public List<Cart> fetchCartsByStatus(String status) throws CartNotFoundException {
        List<Cart> cartListWithStatus = new ArrayList<>();
        for (Cart cart : carts.values()) {
            if (status.equalsIgnoreCase(cart.getStatus())) {
                cartListWithStatus.add(cart);
            }
        }

        if (CollectionUtils.isEmpty(cartListWithStatus)) {
            throw new CartNotFoundException("Not Cart with this status Found");
        }
        //default sorting with size
        Collections.sort(cartListWithStatus, new CartSizeComparator());
        return cartListWithStatus;
    }

    @Override
    public Map<String, Integer> fetchCartsByProdCategory(String prodCategory) throws CartNotFoundException {
        Map<String, Integer> cartListWithStatus = new HashMap<>();

        for (Cart cart : carts.values()) {
            for (Map<Product, Integer> prodDetails : cart.getProductList()) {
                {
                    cartListWithStatus = this.processCartsToFetchProductCategory(prodDetails, cart);
                }
            }
        }
        return cartListWithStatus;
    }

    private Map<String, Integer> processCartsToFetchProductCategory(Map<Product, Integer> prodDetails, Cart cart) {
        Map<String, Integer> cartListWithStatus = new HashMap<>();
        for (Map.Entry<Product, Integer> prods : prodDetails.entrySet()) {
            if (ProductCategoryEnum.CLOTHING.getCategory().equalsIgnoreCase(prods.getKey().getCategory())) {
                if (cartListWithStatus.containsKey(cart.getStatus()))
                    cartListWithStatus.put(cart.getStatus(), cartListWithStatus.get(cart.getStatus()) + 1);
                else
                    cartListWithStatus.put(cart.getStatus(), 1);
            }
        }
        return cartListWithStatus;
    }


    @Override
    public Map<String, Integer> fetchProdHistory(String prodId) throws ProductNotFoundException {
        Map<String, Integer> prodHistory = new HashMap<>();
        for (Cart cart : carts.values()) {
            {
                for (Map<Product, Integer> prodDetails : cart.getProductList()) {
                    prodHistory =  this.processCartsToFetchProductHistory(prodDetails, cart, prodId);
                }
            }
        }
        return prodHistory;
    }

    private Map<String, Integer> processCartsToFetchProductHistory(Map<Product, Integer> prodDetails, Cart cart, String prodId) {
        Map<String, Integer> prodHistory = new HashMap<>();
        for (Map.Entry<Product, Integer> prods : prodDetails.entrySet()) {
            if (prodId.equalsIgnoreCase(prods.getKey().getProductId())) {
                if (prodHistory.containsKey(cart.getStatus()))
                    prodHistory.put(cart.getStatus(), prodHistory.get(cart.getStatus()) + 1);
                else
                    prodHistory.put(cart.getStatus(), 1);
            }
        }
        return prodHistory;
    }

}
