package org.bh.bank.validator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.bh.bank.exception.InvalidAccountException;
import org.bh.bank.repository.AccountRepository;
import org.springframework.stereotype.Component;

/**
 * The type Valid account aspect to validate existence of account
 */
@Slf4j
@RequiredArgsConstructor
@Aspect
@Component
public final class ValidAccountAspect {

    private final AccountRepository accountRepository;

    /**
     * Validate.
     *
     * @param accountId       the account id
     * @param transactionType the transaction type
     * @param amount          the amount
     */
    @Before("@annotation(org.bh.bank.validator.ValidAccount) && args(accountId, transactionType, amount)")
    public void validate(int accountId, String transactionType, double amount) {
        accountRepository.findByAccountId(accountId)
                .orElseThrow(() -> new InvalidAccountException("Account does not exist for the customer to perform transaction"));
    }
}
