package com.Project.BankingApp.service;

import com.Project.BankingApp.Data.Account;
import com.Project.BankingApp.dto.AccountDTO;
import java.util.List;

public interface AccountService {
	
	AccountDTO createAccount(AccountDTO accountDTO);//create
	
	AccountDTO getAccountById(Long id);//Retrive
	
	AccountDTO deposit(Long id,double amount);//Update:->add money to account
	
	AccountDTO withdraw(Long id,double amount);///update :remove money from account
	
	List<AccountDTO> getAllAccounts();//get all the accounts with information
	
	void deleteAccount(Long id);
	
	Account createAccount(Account account);

	Account saveAccount(Account account);

	
	
	
}
