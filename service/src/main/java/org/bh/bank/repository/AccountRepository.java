package org.bh.bank.repository;

import org.bh.bank.data.AccountData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Account repository.
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountData, Integer> {

    /**
     * Find by account id optional.
     *
     * @param accountId the account id
     * @return the optional
     */
    Optional<AccountData> findByAccountId(Integer accountId);
}
