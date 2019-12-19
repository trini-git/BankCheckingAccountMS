package com.bankcheckingaccount.service;

import com.bankcheckingaccount.model.BankCheckingAccountModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankCheckingAccountServiceInterface {
	
	Mono<BankCheckingAccountModel> insertBankCheckingAccount 
	(BankCheckingAccountModel bankCheckingAccountModel);
	
	Flux<BankCheckingAccountModel> findAll();
	
	Mono<BankCheckingAccountModel> findByDocument(String document);
}
