package org.bh.bank.repository;

import org.bh.bank.data.AccountData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountData, Integer> {

    Optional<AccountData> findByAccountId(Integer accountId);
}
