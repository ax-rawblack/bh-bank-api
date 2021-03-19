package org.bh.bank.service;

import lombok.RequiredArgsConstructor;
import org.bh.bank.mapper.TransactionMapper;
import org.bh.bank.repository.TransactionRepository;
import org.bh.bank.validator.ValidAccount;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionMapper transactionMapper;
    private final TransactionRepository transactionRepository;

    @ValidAccount
    @Override
    public void performNewTransaction(int accountId, String transactionType, double amount) {
        transactionRepository.save(transactionMapper.mapTransaction(accountId, transactionType, amount));
    }
}
