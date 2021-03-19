package org.bh.bank.repository;

import org.bh.bank.data.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionData, Integer> {

}
