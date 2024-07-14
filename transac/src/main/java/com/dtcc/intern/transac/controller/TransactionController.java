package com.dtcc.intern.transac.controller;



import com.dtcc.intern.dtcc.model.Transaction;
import com.dtcc.intern.dtcc.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

 @Autowired
 private TransactionService transactionService;

 @PostMapping("/save")
 public Transaction saveTransaction(@RequestBody Transaction transaction) {
     return transactionService.saveTransaction(transaction);
 }

 @PostMapping("/get")
 public List<Transaction> getTransactionsByUserId(@RequestBody Long userId) {
     return transactionService.getTransactionsByUserId(userId);
 }
}
