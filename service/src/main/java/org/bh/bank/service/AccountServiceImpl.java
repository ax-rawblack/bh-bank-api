package org.bh.bank.service;

import io.swagger.model.NewAccountRequest;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.math.NumberUtils;
import org.bh.bank.data.AccountData;
import org.bh.bank.mapper.AccountMapper;
import org.bh.bank.repository.AccountRepository;
import org.bh.bank.util.TransactionType;
import org.bh.bank.validator.ValidCustomer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Transactional
    @ValidCustomer
    @Override
    public void createNewAccount(NewAccountRequest newAccountRequest) {
        AccountData accountDataResult = accountRepository.save(accountMapper.mapNewAccountRequest(newAccountRequest));
        Double initialCredit = newAccountRequest.getInitialCredit();

        if (initialCredit != null && initialCredit > NumberUtils.DOUBLE_ZERO) {
            transactionService.performNewTransaction(accountDataResult.getAccountId(), TransactionType.CREDIT.toString(), initialCredit);
            accountDataResult.setBalance(accountDataResult.getBalance() + initialCredit);
            accountRepository.save(accountDataResult);
        }
    }
}
