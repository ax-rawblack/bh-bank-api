package org.bh.bank.mapper;

import org.bh.bank.data.TransactionData;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class TransactionMapper {

    public TransactionData mapTransaction(int accountId, String transactionType, double amount) {
        return TransactionData.builder()
                .accountId(accountId)
                .transactionType(transactionType)
                .amount(amount)
                .createdDttm(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }
}
