package org.bh.bank.service;

import io.swagger.model.NewAccountRequest;

/**
 * The Account service
 */
public interface AccountService {

    /**
     * Create new account
     *
     * @param newAccountRequest the new account request
     */
    void createNewAccount(NewAccountRequest newAccountRequest);
}
