package com.rjnsh.cart.constants;

public enum ProductCategoryEnum {

    CLOTHING("CLOTHING"),
    ELECTRONICS("ELECTRONICS"),
    EATABLE("EATABLE");

    private String category;

    ProductCategoryEnum(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
