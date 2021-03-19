package org.bh.bank.mapper;

import io.swagger.model.NewAccountRequest;
import org.bh.bank.data.AccountData;
import org.bh.bank.util.ApplicationConstants;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * This is mapper class for Account
 */
@Component
public class AccountMapper {

    /**
     * Map new account request account data.
     *
     * @param newAccountRequest the new account request
     * @return the account data
     */
    public AccountData mapNewAccountRequest(NewAccountRequest newAccountRequest) {
        return AccountData.builder()
                .customerId(newAccountRequest.getCustomerId())
                .accountType(newAccountRequest.getAccountType())
                .balance(ApplicationConstants.INITIAL_NEW_ACCOUNT_BALANCE)
                .createdDttm(Timestamp.valueOf(LocalDateTime.now()))
                .build();
    }
}
