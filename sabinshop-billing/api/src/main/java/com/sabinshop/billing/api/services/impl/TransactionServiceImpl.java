package com.sabinshop.billing.api.services.impl;


import com.sabinshop.billing.api.mapper.TransactionMapper;
import com.sabinshop.billing.api.models.TransactionRepository;
import com.sabinshop.billing.api.models.db.TransactionEntity;
import com.sabinshop.billing.api.services.TransactionService;
import com.sabinshop.billing.api.services.exceptions.EmptyPayloadException;
import com.sabinshop.billing.api.services.exceptions.ResourceNotFoundException;
import com.sabinshop.billing.lib.PaymentMethodType;
import com.sabinshop.billing.lib.Transaction;
import com.sabinshop.billing.lib.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction findTransactionById(String id) {

        TransactionEntity transactionEntity = transactionRepository .findById(id).orElse(null);

        if (transactionEntity == null) {
            throw new ResourceNotFoundException(Transaction.class.getSimpleName(), id);
        }

        return TransactionMapper.toTransaction(transactionEntity);
    }

    @Override
    public List<Transaction> findTransactions(Pageable pageable) {

        List<TransactionEntity> transactionEntities = transactionRepository
                .findAll(pageable).getContent();

        return transactionEntities.stream().map(TransactionMapper::toTransaction).collect(Collectors.toList());
    }

    @Override
    public Long findTransactionsCount() {

        return transactionRepository.count();
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {

        if (transaction == null) {
            throw new EmptyPayloadException(Transaction.class.getSimpleName());
        }

        TransactionEntity transactionEntity = TransactionMapper.toTransactionEntity(transaction);
        transactionEntity.setId(null);
        transactionEntity.setStatus(TransactionStatus.SETTLED);
        transactionEntity.setProcessorResponseCode("1000");
        transactionEntity.setProcessorResponseText("Transaction approved");
        transactionEntity.setPaymentMethodType(PaymentMethodType.CREDIT_CARD);
        transactionEntity.setGatewayTransactionId(UUID.randomUUID().toString());

        transactionRepository.save(transactionEntity);

        return TransactionMapper.toTransaction(transactionEntity);
    }
}
