package org.bh.bank.mapper;

import io.swagger.model.AccountDetails;
import io.swagger.model.CustomerAccountDetails;
import io.swagger.model.Transaction;
import org.bh.bank.data.CustomerData;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * This is mapper class for Customer
 */
@Component
public class CustomerMapper {

    /**
     * Map customer data customer account details.
     *
     * @param customerData the customer data
     * @return the customer account details
     */
    public CustomerAccountDetails mapCustomerData(CustomerData customerData) {

        CustomerAccountDetails customerAccountDetails = new CustomerAccountDetails();
        customerAccountDetails.setCustomerId(customerData.getCustomerId());
        customerAccountDetails.setFirstName(customerData.getFirstName());
        customerAccountDetails.setLastName(customerData.getLastName());
        customerAccountDetails.setAccounts(
                customerData.getAccounts().stream().map(accountData -> {
                    AccountDetails accountDetails = new AccountDetails();
                    accountDetails.setAccountId(accountData.getAccountId());
                    accountDetails.setAccountType(accountData.getAccountType());
                    accountDetails.setBalance(accountData.getBalance());
                    accountDetails.setTransactions(
                            accountData.getTransactions().stream().map(transaction -> new Transaction()
                                    .txnId(transaction.getTransactionId())
                                    .txnType(transaction.getTransactionType())
                                    .amount(transaction.getAmount())).collect(Collectors.toList()));
                    return accountDetails;
                }).collect(Collectors.toList()));
        return customerAccountDetails;
    }
}
