package com.dtcc.intern.transac.model;



import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class UserDetailModel {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long userId;
 private String username;
 private String email;
 private String password;

 @Temporal(TemporalType.TIMESTAMP)
 private Date createdAt;

 @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
 private List<Transaction> transactions;

 @PrePersist
 protected void onCreate() {
     createdAt = new Date();
 }

 // Getters and Setters
 public Long getUserId() {
     return userId;
 }

 public void setUserId(Long userId) {
     this.userId = userId;
 }

 public String getUsername() {
     return username;
 }

 public void setUsername(String username) {
     this.username = username;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getPassword() {
     return password;
 }

 public void setPassword(String password) {
     this.password = password;
 }

 public Date getCreatedAt() {
     return createdAt;
 }

 public void setCreatedAt(Date createdAt) {
     this.createdAt = createdAt;
 }

 public List<Transaction> getTransactions() {
     return transactions;
 }

 public void setTransactions(List<Transaction> transactions) {
     this.transactions = transactions;
 }
}
