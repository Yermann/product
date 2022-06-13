package com.example.productcrud.exception;

public enum ErrorCode {

    PRODUCT_ID_NOT_FOUND("ErrorCode.PRODUCT_ID_NOT_FOUND");

    private String resourceKey;

    ErrorCode(String resourceKey) {
        this.resourceKey = resourceKey;
    }

    public String getResourceKey() {
        return resourceKey;
    }
}
