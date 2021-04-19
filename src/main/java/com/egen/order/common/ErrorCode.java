package com.egen.order.common;

public enum ErrorCode {

    INVALID_ORDER("ORD-001", "Invalid request"),
    SHIPPING_ADDRESS_MANDATORY("ORD-002", "Shipping address mandatory"),
    CUSTOMER_ID_MANDATORY("ORD-003", "Customer Id mandatory mandatory"),
    ITEM_DETAIL_MANDATORY("ORD-004", "Item list mandatory"),
    TECHNICAL_ERROR("ORD-000", "Technical error")
    ;

    private String errorCode;
    private String message;

    ErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

}
