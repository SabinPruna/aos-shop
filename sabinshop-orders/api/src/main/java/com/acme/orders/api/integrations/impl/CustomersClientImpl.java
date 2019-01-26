package com.sabinshop.orders.api.integrations.impl;

import com.sabinshop.orders.api.integrations.CustomersClient;
import com.sabinshop.orders.api.integrations.lib.catalogue.Customer;
import com.sabinshop.orders.api.rest.v1.auth.User;
import com.sabinshop.orders.api.rest.v1.providers.JacksonProvider;
import com.sabinshop.orders.api.services.exceptions.ResourceNotFoundException;
import com.sabinshop.orders.lib.v1.common.ApiError;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class CustomersClientImpl implements CustomersClient {

    private WebTarget webTarget;

    public CustomersClientImpl(Client client, String customersUrl) {
        this.webTarget = client.target(customersUrl).register(JacksonProvider.class);
    }

    @Override
    public Customer findCustomerById(String id, User user) {

        try {
            return webTarget.path("customers").path(id).request(MediaType.APPLICATION_JSON_TYPE)
                    .header("Authorization", "Bearer ")
                    .get(Customer.class);
        } catch (WebApplicationException e) {

            ApiError error = e.getResponse().readEntity(ApiError.class);

            switch (error.getStatus()) {

                case 404:
                    throw new ResourceNotFoundException(Customer.class.getSimpleName(), id);
            }

            throw e;
        }
    }
}
