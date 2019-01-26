package com.sabinshop.orders.api.services.exceptions;

import com.sabinshop.orders.lib.v1.common.OrderServiceErrorCode;

public class OrderServiceException extends RuntimeException {

    private OrderServiceErrorCode code;

    public OrderServiceException(OrderServiceErrorCode code) {
        this.code = code;
    }

    public OrderServiceErrorCode getCode() {
        return code;
    }
}
