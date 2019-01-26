package com.sabinshop.orders.api.rest.v1.mappers;

import com.sabinshop.orders.api.services.exceptions.OrderServiceException;
import com.sabinshop.orders.lib.v1.common.ApiError;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

@Provider
public class OrderServiceMapper implements ExceptionMapper<OrderServiceException> {

    @Override
    public Response toResponse(OrderServiceException exception) {

        ApiError apiError = new ApiError();
        apiError.setRef(UUID.randomUUID());
        apiError.setStatus(400);
        apiError.setCode(exception.getCode().getCode());

        return Response.status(Response.Status.BAD_REQUEST).entity(apiError).build();
    }
}
