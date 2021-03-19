package org.bh.bank.mapper;

import org.bh.bank.data.TransactionData;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * This is mapper class for Transaction
 */
@Component
public class TransactionMapper {

    /**
     * Map transaction transaction data.
     *
     * @param accountId       the account id
     * @param transactionType the transaction type
     * @param amount          the amount
     * @return the transaction data
     */
    public TransactionData mapTransaction(int accountId, String transactionType, double amount) {
        return TransactionData.builder()
                .accountId(accountId)
                .transactionType(transactionType)
                .amount(amount)
                .createdDttm(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }
}
