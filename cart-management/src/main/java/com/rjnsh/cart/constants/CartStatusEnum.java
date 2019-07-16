package com.rjnsh.cart.constants;

public enum CartStatusEnum {
    ACTIVE("ACTIVE"),
    ORDERED("ORDERED"),
    DISCARDED("DISCARDED");

    private String status;

    CartStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
