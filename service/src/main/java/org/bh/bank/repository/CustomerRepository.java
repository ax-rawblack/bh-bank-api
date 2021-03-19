package org.bh.bank.repository;

import org.bh.bank.data.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerData, Integer> {

    Optional<CustomerData> findByCustomerId(Integer customerId);
}
