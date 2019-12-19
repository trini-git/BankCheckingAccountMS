package com.bankcheckingaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankcheckingaccount.model.BankCheckingAccountModel;
import com.bankcheckingaccount.service.BankCheckingAccountService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/bank-checking-account")
public class BankCheckingAccountController {
	
	@Autowired
	BankCheckingAccountService bankCheckingAccountService;
	
	@PostMapping("/insert")
	public Mono<BankCheckingAccountModel> insertBankCheckingAccount (@RequestBody BankCheckingAccountModel bankCheckingAccountModel){
		
		return bankCheckingAccountService.insertBankCheckingAccount(bankCheckingAccountModel);
	}
	
	@GetMapping("/find-by/{document}")
	public Mono<BankCheckingAccountModel> findBankCheckingAccount (@PathVariable String document){
		
		return bankCheckingAccountService.findByDocument(document);
	}
	
	@GetMapping("/find-all")
	public Flux<BankCheckingAccountModel> findAll (){
		
		return bankCheckingAccountService.findAll();
	}
}
