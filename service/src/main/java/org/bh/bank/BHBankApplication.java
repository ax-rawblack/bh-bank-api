package org.bh.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type BH Bank application.
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.bh.bank.repository"})
public class BHBankApplication {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(BHBankApplication.class, args);
    }
}
