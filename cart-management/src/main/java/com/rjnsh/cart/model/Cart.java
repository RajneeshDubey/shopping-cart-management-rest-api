package com.rjnsh.cart.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable {

    private Integer cartId;

    //map of prodId and qty
    private List<Map<Product, Integer>> productList = new ArrayList<>();

    private String status;

    private BigDecimal total;


    public List<Map<Product, Integer>> getProductList() {
        return productList;
    }

    public void setProductList(Map<Product, Integer> newProduct) {
        this.productList.add(newProduct);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }


    @Override
    public String toString() {
        String cartDetails = "";
        BigDecimal cartTotal = BigDecimal.ZERO;
        for (Map<Product, Integer> prods : productList) {
            for (Map.Entry<Product, Integer> prodQty : prods.entrySet()) {
                cartDetails += "Item Id :" + prodQty.getKey().getProductId()+ "  Prod Name :" + prodQty.getKey().getProductName() + " Qty :" + prodQty.getValue() +"\n";
            }
        }
        return cartDetails;
    }

}
