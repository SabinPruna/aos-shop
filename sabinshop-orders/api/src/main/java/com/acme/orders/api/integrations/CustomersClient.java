package com.sabinshop.orders.api.integrations;

import com.sabinshop.orders.api.integrations.lib.catalogue.Customer;
import com.sabinshop.orders.api.rest.v1.auth.User;

public interface CustomersClient {

    Customer findCustomerById(String id, User user);
}
