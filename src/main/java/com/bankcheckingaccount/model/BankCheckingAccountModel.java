package com.bankcheckingaccount.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bank_checking_account")
public class BankCheckingAccountModel {
	
	@Id
	private String id;
	
	private String accountNumber;
	
	private Double amount;
	
	private String type;
	
	private String status;
	
	private String bankName;
	
	private List<BcaClient> bcaClient;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<BcaClient> getBcaClient() {
		return bcaClient;
	}

	public void setBcaClient(List<BcaClient> bcaClient) {
		this.bcaClient = bcaClient;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
		
}
