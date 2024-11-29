package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.BankAccountDTO;
import com.bank.service.impl.BankAccountServiceImpl;

@RestController
@RequestMapping("/account")
public class BankAccountController {

	@Autowired
	BankAccountServiceImpl accountService;
	
	@PostMapping("/create")
	public void createAccount(@RequestBody BankAccountDTO accountDTO) {
		accountService.createAccount(accountDTO);
		System.out.println();
	}
	
	@GetMapping("balance/{id}")
	public BankAccountDTO getAccount(@PathVariable("id") Long id) {
		BankAccountDTO accountDTO = accountService.getAccount(id);
		return accountDTO;
	}
	
	@PutMapping("/update")
	public void updateaccount(@RequestBody BankAccountDTO accountDTO) {
		accountService.updateAccount(accountDTO);
		System.out.println();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAccount(@PathVariable("id") Long id) {
		accountService.deleteAccount(id);
		System.out.println();
	}
}
