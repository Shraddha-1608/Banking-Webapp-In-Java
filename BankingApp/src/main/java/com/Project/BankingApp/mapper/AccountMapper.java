package com.Project.BankingApp.mapper;

import com.Project.BankingApp.Data.Account;
import com.Project.BankingApp.dto.AccountDTO;

public class AccountMapper {
	public static Account mapToAccount(AccountDTO accountDTO) {
		Account account=new Account(
			accountDTO.getId(),
			accountDTO.getAccountHolderName(),
			accountDTO.getBalance()
				);
		return account;
	}
	
	public static AccountDTO mapToAccountDTO(Account account)  {
		AccountDTO accountdto=new AccountDTO(
				account.getId(),
				account.getAccountHolderName(),
				account.getBalance()
				);
		return accountdto;
	}


}
