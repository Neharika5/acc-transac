package com.example.demo.controller;

import com.example.demo.model.Transaction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    public TransactionController() {
        // Initialize transaction list with hardcoded values
        Transaction.initializeTransactionList();
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return Transaction.getAllTransactions();
    }

    @GetMapping("/getTransaction")
    public ResponseEntity<Transaction> getTransactionById(@RequestParam int id) {
        Transaction transaction = Transaction.getTransactionById(id);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    @GetMapping("/getByAccount")
    public List<Transaction> getTransactionsByAccountId(@RequestParam int accountId) {
        return Transaction.getTransactionsByAccountId(accountId);
    }

    @PostMapping("/createTransaction")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction.addTransaction(transaction);
        return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
    }

    @DeleteMapping("/deleteTransaction")
    public ResponseEntity<Void> deleteTransaction(@RequestParam int id) {
        boolean removed = Transaction.deleteTransaction(id);
        return removed ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
