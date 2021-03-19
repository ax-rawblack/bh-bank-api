package org.bh.bank.controller;

import io.swagger.model.CustomerAccountDetails;
import io.swagger.model.NewAccountRequest;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.bh.bank.service.AccountService;
import org.bh.bank.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
@RequestMapping("bank/v1")
@RequiredArgsConstructor
public class BHBankController {

    private final AccountService accountService;
    private final CustomerService customerService;

    @PostMapping(value = "/account/create", produces = {"application/json"})
    public ResponseEntity<Void> createNewAccount(@Parameter(in = ParameterIn.DEFAULT, description = "New account creation for existing customer", schema = @Schema()) @Valid @RequestBody NewAccountRequest newAccountRequest) {
        accountService.createNewAccount(newAccountRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/customer/details", produces = {"application/json"})
    public ResponseEntity<CustomerAccountDetails> getCustomerAccountsDetails(@NotNull @Parameter(in = ParameterIn.QUERY, description = "Customer id", required = true, schema = @Schema()) @Valid @RequestParam(value = "customerId", required = true) Integer customerId) {
        return new ResponseEntity<>(customerService.getAccountsDetails(customerId), HttpStatus.CREATED);
    }
}
