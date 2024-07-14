package com.dtcc.intern.transac.service;


import com.dtcc.intern.dtcc.model.Transaction;
import com.dtcc.intern.dtcc.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

 @Autowired
 private TransactionRepository transactionRepository;

 public Transaction saveTransaction(Transaction transaction) {
     return transactionRepository.save(transaction);
 }

 public List<Transaction> getTransactionsByUserId(Long userId) {
     return transactionRepository.findByUserId(userId);
 }
}
