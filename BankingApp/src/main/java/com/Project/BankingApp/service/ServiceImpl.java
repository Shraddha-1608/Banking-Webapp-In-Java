package com.Project.BankingApp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.Project.BankingApp.Data.Account;
import com.Project.BankingApp.dto.AccountDTO;
import com.Project.BankingApp.mapper.AccountMapper;
import com.Project.BankingApp.repository.AccountRepository;

@Service
public class ServiceImpl implements AccountService {
	
	private AccountRepository accountrepository;
	

	public ServiceImpl(AccountRepository accountrepository) {
		super();
		this.accountrepository =accountrepository;
	}


	@Override
	public AccountDTO createAccount(AccountDTO accountDTO) {
		Account account=AccountMapper.mapToAccount(accountDTO);
		Account savedAccount= accountrepository.save(account);
		
		return AccountMapper.mapToAccountDTO(savedAccount);
	}


	@Override
	public AccountDTO getAccountById(Long id) {
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exists"));
		return AccountMapper.mapToAccountDTO(account);
	}


	@Override
	public AccountDTO deposit(Long id, double amount) {
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exists"));
		Double total=account.getBalance()+amount;
		account.setBalance(total);
		Account savedAccount=accountrepository.save(account);
		return AccountMapper.mapToAccountDTO(savedAccount);
		
	}


	@Override
	public AccountDTO withdraw(Long id, double amount) {
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exists"));
		if(account.getBalance()<amount) {
			throw new RuntimeException("You have Insufficient balance for withdrawal!!");
		}
		Double total=account.getBalance()-amount;
		account.setBalance(total);
		Account savedAccount=accountrepository.save(account);	
		return AccountMapper.mapToAccountDTO(savedAccount);
	}


	@Override
	public List<AccountDTO> getAllAccounts() {
		List<Account> accounts=accountrepository.findAll();
		return accounts.stream().map((account)->AccountMapper.mapToAccountDTO(account)).collect(Collectors.toList());
		
	}


	@Override
	public void deleteAccount(Long id) {
		Account account=accountrepository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Account does not exists"));
		accountrepository.deleteById(id);
		
	}


	@Override
	public Account createAccount(Account account) {
		return accountrepository.save(account); 
	}
	
	public Account saveAccount(Account account) {
        return accountrepository.save(account); // Saves the account to the database
    }
	



	


	


	

	
	
}
