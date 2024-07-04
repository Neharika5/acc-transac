package com.dtcc.intern.dtcc.model;

public class Account {
    private int accountId;
    private int userId;
    private String accountNumber;
    private String accountType;
    private String currency;

    public Account(int accountId, int userId, String accountNumber, String accountType, String currency) {
        this.accountId = accountId;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.currency = currency;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
