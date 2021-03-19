package org.bh.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableJpaRepositories(basePackages = {"net.apmoller.crb.rcon.transformer.repository"})
public class BHBankApplication {
    public static void main(String[] args) {
        SpringApplication.run(BHBankApplication.class, args);
    }
}
