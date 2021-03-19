package org.bh.bank.validator;

import io.swagger.model.NewAccountRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.bh.bank.exception.InvalidCustomerException;
import org.bh.bank.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Aspect
@Component
public final class ValidCustomerAspect {

    private final CustomerRepository customerRepository;

    @Before("@annotation(org.bh.bank.validator.ValidCustomer) && args(newAccountRequest)")
    public void validate(NewAccountRequest newAccountRequest) {
        customerRepository.findByCustomerId(newAccountRequest.getCustomerId())
                .orElseThrow(() -> new InvalidCustomerException("Customer in the request does not exists"));
    }

    @Before("@annotation(org.bh.bank.validator.ValidCustomer) && args(customerId)")
    public void validate(int customerId) {
        customerRepository.findByCustomerId(customerId)
                .orElseThrow(() -> new InvalidCustomerException("Customer in the request does not exists"));
    }
}
