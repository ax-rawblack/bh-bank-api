package org.bh.bank.service;

import io.swagger.model.NewAccountRequest;

public interface AccountService {

    void createNewAccount(NewAccountRequest newAccountRequest);
}
