package org.bh.bank.service;

import io.swagger.model.CustomerAccountDetails;

/**
 * The Customer service
 */
public interface CustomerService {

    /**
     * Gets accounts details.
     *
     * @param customerId the customer id
     * @return the accounts details
     */
    CustomerAccountDetails getAccountsDetails(int customerId);
}
