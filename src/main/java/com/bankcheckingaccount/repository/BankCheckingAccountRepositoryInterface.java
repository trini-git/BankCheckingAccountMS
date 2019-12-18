package com.bankcheckingaccount.repository;


import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bankcheckingaccount.model.BankCheckingAccountModel;

import reactor.core.publisher.Mono;

@Repository
public interface BankCheckingAccountRepositoryInterface extends ReactiveMongoRepository<BankCheckingAccountModel, String>{
	
	@Query("{'bcaClient.document' : ?0}")
	Mono<BankCheckingAccountModel> findByDocument(String document);
}
