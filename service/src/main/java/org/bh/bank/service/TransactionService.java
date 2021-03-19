package org.bh.bank.service;

public interface TransactionService {

    void performNewTransaction(int accountId, String transactionType, double amount);
}
