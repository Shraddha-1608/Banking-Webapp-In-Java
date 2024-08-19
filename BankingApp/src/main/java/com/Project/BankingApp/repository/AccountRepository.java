package com.Project.BankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.BankingApp.Data.Account;
import com.Project.BankingApp.dto.AccountDTO;


public interface AccountRepository extends JpaRepository<Account, Long> {	 

}
