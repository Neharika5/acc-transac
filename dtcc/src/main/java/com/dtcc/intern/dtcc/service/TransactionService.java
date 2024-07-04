package com.dtcc.intern.dtcc.service;

import com.dtcc.intern.dtcc.model.Transaction;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(1, 101, "Buy", 1000.00, "USD", new Timestamp(System.currentTimeMillis()), 1.0));
        transactions.add(new Transaction(2, 102, "Sell", 500.00, "EUR", new Timestamp(System.currentTimeMillis()), 0.85));
        // Add more transactions as needed
        return transactions;
    }
}
