package com.sabinshop.billing.api.services;

import com.sabinshop.billing.lib.Transaction;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionService {

    Transaction findTransactionById(String id);

    List<Transaction> findTransactions(Pageable pageable);

    Long findTransactionsCount();

    Transaction createTransaction(Transaction transaction);
}
