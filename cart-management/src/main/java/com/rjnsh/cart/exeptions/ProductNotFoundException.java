package com.rjnsh.cart.exeptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(){}
    public ProductNotFoundException(String msg){
        super(msg);
    }

}
