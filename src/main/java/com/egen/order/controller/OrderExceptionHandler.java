package com.egen.order.controller;

import com.egen.order.exception.OrderExceptionResponse;
import com.egen.order.exception.OrderServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class OrderExceptionHandler {

    public ResponseEntity<OrderExceptionResponse> orderServiceException(OrderServiceException ex) {
        OrderExceptionResponse response = new OrderExceptionResponse();
        response.setErrorCode(ex.getErrorCode());
        response.setErrorMessage(ex.getMessage());
        response.setTimestamp(LocalDateTime.now());
        return new ResponseEntity<OrderExceptionResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
