package org.bh.bank.repository;

import org.bh.bank.data.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Customer repository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerData, Integer> {

    /**
     * Find by customer id optional.
     *
     * @param customerId the customer id
     * @return the optional
     */
    Optional<CustomerData> findByCustomerId(Integer customerId);
}
