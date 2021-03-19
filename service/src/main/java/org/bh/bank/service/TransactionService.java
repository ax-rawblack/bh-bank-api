package org.bh.bank.service;

/**
 * The Transaction service
 */
public interface TransactionService {

    /**
     * Perform new transaction.
     *
     * @param accountId       the account id
     * @param transactionType the transaction type
     * @param amount          the amount
     */
    void performNewTransaction(int accountId, String transactionType, double amount);
}
