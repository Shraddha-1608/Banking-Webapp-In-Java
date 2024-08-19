package com.Project.BankingApp.controller;

import org.apache.catalina.connector.Response;
import org.hibernate.mapping.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.BankingApp.Data.Account;
import com.Project.BankingApp.dto.AccountDTO;
import com.Project.BankingApp.service.AccountService;

import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	
	
	private AccountService accountService;
	private Long id;

	public AccountController(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	
 
	
	//Add Account REST API
	@PostMapping()
	public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO){
		return new ResponseEntity<AccountDTO>(accountService.createAccount(accountDTO),HttpStatus.CREATED);
	}
	
	
	//Get Account REST API
	@GetMapping("/{id}")
	public ResponseEntity<AccountDTO> getAccount(@PathVariable  Long id){
		AccountDTO accountdto=accountService.getAccountById(id);
		return ResponseEntity.ok(accountdto);	
		
	}
	
	
	//Deposite REST API
	@PutMapping("/{id}/deposit")
	public ResponseEntity<AccountDTO> deposit(@PathVariable Long id,@RequestBody java.util.Map<String,Double> request){
		Double amount=request.get("amount");
		AccountDTO accountDTO=accountService.deposit(id,amount);
		return ResponseEntity.ok( accountDTO);
		
	}
	
	//REST API for withdraw
	@PutMapping("/{id}/withdraw")
	public ResponseEntity<AccountDTO> withdraw(@PathVariable  Long id,@RequestBody java.util.Map<String, Double> request){
		Double amount=request.get("amount");
		AccountDTO accountDTO=accountService.withdraw(id, amount);
		return ResponseEntity.ok(accountDTO);
	}
	
	//REST API for getAllAccounts
	@GetMapping
	public ResponseEntity<List<AccountDTO>> getAllAccounts(){
		List<AccountDTO> acconts=accountService.getAllAccounts();
		return ResponseEntity.ok(acconts);
	}
	
	////REST API for deleting account
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long id){
		accountService.deleteAccount(id);
		return ResponseEntity.ok("Account is deleted successfully!");
	}

}

