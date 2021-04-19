package com.egen.order.exception;

import com.egen.order.common.ErrorCode;

public class OrderServiceException extends RuntimeException {
    private String message;
    private String errorCode;

    public OrderServiceException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.message = errorCode.getMessage();
        this.errorCode = errorCode.getErrorCode();
    }

    public OrderServiceException(String message) {
        super(message);
    }

    public OrderServiceException(ErrorCode errorCode, Throwable cause) {
        super(errorCode.getMessage(), cause);
        this.message = errorCode.getMessage();
        this.errorCode = errorCode.getErrorCode();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
