package org.bh.bank.service;

import io.swagger.model.CustomerAccountDetails;
import lombok.RequiredArgsConstructor;
import org.bh.bank.data.CustomerData;
import org.bh.bank.mapper.CustomerMapper;
import org.bh.bank.repository.CustomerRepository;
import org.bh.bank.validator.ValidCustomer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Transactional
    @ValidCustomer
    @Override
    public CustomerAccountDetails getAccountsDetails(int customerId) {
        CustomerData customerData = customerRepository.findByCustomerId(customerId).get();
        return customerMapper.mapCustomerData(customerData);
    }
}
