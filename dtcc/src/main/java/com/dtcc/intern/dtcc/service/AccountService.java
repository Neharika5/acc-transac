package com.dtcc.intern.dtcc.service;

import com.dtcc.intern.dtcc.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    private final List<Account> accounts = new ArrayList<>();
    private int accountIdCounter = 1;

    public Account createAccount(int userId, String accountNumber, String accountType, String currency) {
        Account account = new Account(accountIdCounter++, userId, accountNumber, accountType, currency);
        accounts.add(account);
        return account;
    }

    public List<Account> getAccountsByUserId(int userId) {
        List<Account> userAccounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getUserId() == userId) {
                userAccounts.add(account);
            }
        }
        return userAccounts;
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}
