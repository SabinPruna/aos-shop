package com.sabinshop.billing.api.mapper;


import com.sabinshop.billing.api.models.db.TransactionEntity;
import com.sabinshop.billing.lib.Transaction;

public class TransactionMapper {

    public static Transaction toTransaction(TransactionEntity entity) {

        if (entity == null) return null;

        Transaction transaction = new Transaction();
        transaction.setId(entity.getId());
        transaction.setUpdatedAt(entity.getUpdatedAt());
        transaction.setCreatedAt(entity.getCreatedAt());
        transaction.setCurrency(entity.getCurrency());
        transaction.setAmount(entity.getAmount());
        transaction.setStatus(entity.getStatus());
        transaction.setGatewayDeclineCode(entity.getGatewayDeclineCode());
        transaction.setProcessorResponseCode(entity.getProcessorResponseCode());
        transaction.setProcessorResponseText(entity.getProcessorResponseText());
        transaction.setPaymentMethodType(entity.getPaymentMethodType());
        transaction.setCustomerId(entity.getCustomerId());
        transaction.setOrderId(entity.getOrderId());
        transaction.setGatewayTransactionId(entity.getGatewayTransactionId());

        return transaction;
    }

    public static TransactionEntity toTransactionEntity(Transaction transaction) {

        if (transaction == null) return null;

        TransactionEntity entity = new TransactionEntity();
        entity.setId(transaction.getId());
        entity.setCurrency(transaction.getCurrency());
        entity.setAmount(transaction.getAmount());
        entity.setCustomerId(transaction.getCustomerId());
        entity.setOrderId(transaction.getOrderId());

        return entity;
    }
}
