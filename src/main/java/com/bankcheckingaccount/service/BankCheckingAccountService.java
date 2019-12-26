package com.bankcheckingaccount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.bankcheckingaccount.model.BankAccount;
import com.bankcheckingaccount.model.BankCheckingAccountModel;
import com.bankcheckingaccount.repository.BankCheckingAccountRepositoryInterface;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BankCheckingAccountService implements BankCheckingAccountServiceInterface {
	
	@Autowired
	WebClient client;
	
	@Autowired
	BankCheckingAccountRepositoryInterface bankCheckingAccountRepositoryInterface;
	
	BankAccount bankAccount = new BankAccount();

	@Override
	public Mono<BankCheckingAccountModel> insertBankCheckingAccount(BankCheckingAccountModel bankCheckingAccountModel) {
		
		bankAccount.setAccountNumber(bankCheckingAccountModel.getAccountNumber());
		bankAccount.setAmount(bankCheckingAccountModel.getAmount());
		bankAccount.setType(bankCheckingAccountModel.getType());
		bankAccount.setStatus(bankCheckingAccountModel.getStatus());
		
		insertBankAccount(bankAccount).subscribe();
		return bankCheckingAccountRepositoryInterface.save(bankCheckingAccountModel);
		
	}

	@Override
	public Mono<BankCheckingAccountModel> findByDocument(String document) {
		
		return bankCheckingAccountRepositoryInterface.findByDocument(document);
	}

	@Override
	public Flux<BankCheckingAccountModel> findAll() {
		
		return bankCheckingAccountRepositoryInterface.findAll();
	}
	
	/*to give data to my method*/
	public Mono<BankAccount> insertBankAccount (BankAccount bankgAccount) {
		
		return client.post()
					.uri("/insert")
					.accept(MediaType.APPLICATION_JSON_UTF8)
					.contentType(MediaType.APPLICATION_JSON_UTF8)
					.body(BodyInserters.fromObject(bankgAccount))
					.retrieve()
					.bodyToMono(BankAccount.class);
	}
}
