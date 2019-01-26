package com.sabinshop.billing.api.models;

import com.sabinshop.billing.api.models.db.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, String> {
}
