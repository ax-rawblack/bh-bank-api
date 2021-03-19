package org.bh.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.bh.bank.repository"})
public class BHBankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BHBankApplication.class, args);
    }
}
