package com.dtcc.intern.transac.repository;



import com.dtcc.intern.dtcc.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
 List<Transaction> findByUserId(Long userId);
}
