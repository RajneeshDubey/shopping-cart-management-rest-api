package com.rjnsh.cart.exeptions;

public class CartNotFoundException extends RuntimeException {
    public CartNotFoundException(){}
    public CartNotFoundException(String msg){
        super(msg);
    }

}

