package com.dtcc.intern.dtcc.model;

import java.sql.Timestamp;

public class Transaction {
    private int transactionId;
    private int accountId;
    private String transactionType;
    private double amount;
    private String currency;
    private Timestamp transactionDate;
    private double fxRate;

    // Constructors
    public Transaction(int transactionId, int accountId, String transactionType, double amount, String currency, Timestamp transactionDate, double fxRate) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.fxRate = fxRate;
    }

    // Getters and Setters
    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getFxRate() {
        return fxRate;
    }

    public void setFxRate(double fxRate) {
        this.fxRate = fxRate;
    }
}
