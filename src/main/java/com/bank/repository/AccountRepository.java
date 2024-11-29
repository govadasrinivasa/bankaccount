package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.entity.BankAccount;

public interface AccountRepository extends JpaRepository<BankAccount, Long> {

	//List<Account> findAccount(Long Id);
}
