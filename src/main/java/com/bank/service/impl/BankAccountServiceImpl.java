package com.bank.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bank.dto.BankAccountDTO;
import com.bank.entity.BankAccount;
import com.bank.repository.AccountRepository;
import com.bank.service.BankAccountService;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	private final AccountRepository accountRepo;
	
    private ModelMapper mapper;
	
	public BankAccountServiceImpl(AccountRepository accountRepo, ModelMapper mapper) {
		this.accountRepo = accountRepo;
		this.mapper = mapper;
	}
	
	@Override
	public void createAccount(BankAccountDTO accountDTO) {
		BankAccount entity = new BankAccount();
		entity.setName(accountDTO.getName());
		entity.setAmount(accountDTO.getAmount());
		accountRepo.save(entity);
	}

	@Override
	public BankAccountDTO getAccount(Long Id) {
		Optional<BankAccount> account = accountRepo.findById(Id);
		BankAccountDTO bankAccountDTO = mapper.map(account, BankAccountDTO.class);
        return bankAccountDTO;
	}

	@Override
	public void updateAccount(BankAccountDTO accountDTO) {
		Optional<BankAccount> account = accountRepo.findById(accountDTO.getAccountNum());
		if (account.isPresent()) {
			BankAccount entity = new BankAccount();
			entity.setAccountNum(account.get().getAccountNum());
			entity.setAmount(accountDTO.getAmount());
			entity.setName(account.get().getName());
			accountRepo.save(entity);
        }
        else
            System.out.println("account is null");
	}

	@Override
	public void deleteAccount(Long Id) {
		Optional<BankAccount> account = accountRepo.findById(Id);
		if (account.isPresent()) {
			accountRepo.delete(account.get());
        }
        else
            System.out.println("account is null");
	}

}
