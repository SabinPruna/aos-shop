package com.sabinshop.orders.api.integrations;

import com.sabinshop.orders.api.integrations.lib.catalogue.Product;

public interface CatalogueClient {

    Product findProductById(String id);
}