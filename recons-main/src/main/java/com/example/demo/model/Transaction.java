package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {
    private static List<Transaction> transactions = new ArrayList<>();

    private int transactionId;
    private int accountId;
    private String transactionType;
    private double amount;
    private String currency;
    private Date transactionDate;
    private double fxRate;

    public Transaction(int transactionId, int accountId, String transactionType, double amount, String currency, Date transactionDate, double fxRate) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.fxRate = fxRate;
    }

    // Getters and setters

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

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getFxRate() {
        return fxRate;
    }

    public void setFxRate(double fxRate) {
        this.fxRate = fxRate;
    }

    public static void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public static List<Transaction> getAllTransactions() {
        return transactions;
    }

    public static Transaction getTransactionById(int id) {
        return transactions.stream().filter(t -> t.getTransactionId() == id).findFirst().orElse(null);
    }

    public static boolean deleteTransaction(int id) {
        return transactions.removeIf(t -> t.getTransactionId() == id);
    }

    public static List<Transaction> getTransactionsByAccountId(int accountId) {
        List<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAccountId() == accountId) {
                accountTransactions.add(t);
            }
        }
        return accountTransactions;
    }

    public static void initializeTransactionList() {
        // Hardcode some transactions
        addTransaction(new Transaction(1, 101, "Buy", 1000.00, "USD", new Date(), 1.2345));
        addTransaction(new Transaction(2, 102, "Sell", 500.00, "EUR", new Date(), 0.9876));
        addTransaction(new Transaction(3, 101, "Buy", 750.00, "GBP", new Date(), 1.4567));
    }
}
