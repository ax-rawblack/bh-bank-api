package org.bh.bank.service;

import io.swagger.model.CustomerAccountDetails;

public interface CustomerService {

    CustomerAccountDetails getAccountsDetails(int customerId);
}
