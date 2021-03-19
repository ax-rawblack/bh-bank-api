package org.bh.bank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.CustomerAccountDetails;
import io.swagger.model.NewAccountRequest;
import org.bh.bank.exception.handler.BHBankControllerAdvice;
import org.bh.bank.service.AccountService;
import org.bh.bank.service.CustomerService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BHBankController.class)
@ContextConfiguration(classes = {BHBankControllerAdvice.class, BHBankController.class})
class BHBankControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectmapper;

    @MockBean
    private AccountService accountService;

    @MockBean
    private CustomerService customerService;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void createNewAccount() throws Exception {

        NewAccountRequest request = new NewAccountRequest();
        request.setCustomerId(1);
        request.setAccountType("CURRENT");
        request.setInitialCredit(10.0);

        Mockito.doNothing().when(accountService).createNewAccount(request);

        MvcResult result = mockMvc
                .perform(post("/bank/v1/account/create/").contentType(MediaType.APPLICATION_JSON)
                        .content(getObjectAsJson(request)))
                .andExpect(status().isCreated()).andReturn();

        verify(accountService, times(1)).createNewAccount(request);
        verifyNoMoreInteractions(accountService);
    }

    @Test
    void getCustomerAccountsDetails() throws Exception {

        CustomerAccountDetails details = new CustomerAccountDetails();
        details.setCustomerId(1);
        details.setFirstName("Anshul");
        details.setLastName("Luthra");
        details.setAccounts(null);

        when(customerService.getAccountsDetails(1)).thenReturn(details);

        MvcResult result = mockMvc
                .perform(get("/bank/v1/customer/details?customerId=1"))
                .andExpect(status().isOk()).andReturn();

        verify(customerService, times(1)).getAccountsDetails(1);
        verifyNoMoreInteractions(customerService);

    }

    private String getObjectAsJson(Object object) throws JsonProcessingException {
        return objectmapper.writeValueAsString(object);
    }
}
