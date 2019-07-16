package com.rjnsh.cart.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    BigDecimal price;

    String productId;

    String productName;

    String category;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //overriding hashcode based on productId for it to be used in Cart Class as key in Map
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + productId.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (productId != other.productId)
            return false;
        return true;
    }
}
