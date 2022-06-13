package com.example.productcrud.exception;

public class ProductNotFoundException extends Exception {
    private ErrorCode errorCode;


    public ProductNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
