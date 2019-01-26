package com.sabinshop.orders.api.integrations;

import com.sabinshop.orders.api.models.db.OrderEntity;
import com.sabinshop.payments.lib.Transaction;

public interface PaymentsClient {

    Transaction createTransaction(OrderEntity orderEntity);
}
