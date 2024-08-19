package com.Project.BankingApp.WebController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.BankingApp.service.AccountService;
import com.Project.BankingApp.service.ServiceImpl;
import com.Project.BankingApp.Data.Account;
import com.Project.BankingApp.dto.AccountDTO;
import com.Project.BankingApp.repository.AccountRepository;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/create-account")
    public String createAccount() {
        return "createAccount";
    }
    
    @GetMapping("/deposit")
    public String showDepositPage() {
        return "deposit"; // This should match the name of your template file (without .html)
    }
    
    @GetMapping("/withdraw")
    public String showWithdrawPage() {
        return "withdraw"; // This should match the name of your template file (without .html)
    }
    
    @GetMapping("/delete-account")
    public String showDeletePage() {
        return "delete"; // This should match the name of your template file (delete.html)
    }
      
    @Autowired
    private AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<String> createAccount(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        String accountId = createdAccount.getId().toString();  // Convert accountId to string
        return ResponseEntity.ok(accountId);  // Return the account ID as a response
    }




}
