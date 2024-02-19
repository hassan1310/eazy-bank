package com.eazybank.repository;

import com.eazybank.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {

    List<Account> findByCustomerId(int customerId);

}
