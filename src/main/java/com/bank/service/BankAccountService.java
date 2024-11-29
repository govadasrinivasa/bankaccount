package com.bank.service;

import com.bank.dto.BankAccountDTO;

public interface BankAccountService {

	void createAccount(BankAccountDTO accountDTO);
	BankAccountDTO getAccount(Long Id);
	void updateAccount(BankAccountDTO accountDTO);
	void deleteAccount(Long Id);
}
