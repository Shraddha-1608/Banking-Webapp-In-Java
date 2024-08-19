package com.Project.BankingApp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AccountDTO {
	
	private Long id;
	private String AccountHolderName;
	private double balance;
	
	public AccountDTO() {
		super();
	}
	public AccountDTO(Long id, String accountHolderName, double balance) {
		super();
		this.id = id;
		this.AccountHolderName = accountHolderName;
		this.balance = balance;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAccountHolderName() {
		return AccountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.AccountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	

	
	
}
