package com.dtcc.intern.dtcc.controller;

import com.dtcc.intern.dtcc.model.Account;
import com.dtcc.intern.dtcc.model.User;
import com.dtcc.intern.dtcc.service.AccountService;
import com.dtcc.intern.dtcc.service.UserService;
import com.dtcc.intern.dtcc.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public User registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        return userService.registerUser(username, email, password);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        Optional<User> userOptional = userService.loginUser(username, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String token = jwtUtil.generateToken(user.getUsername(), user.getUserId());
            return "Login successful. Token: " + token;
        } else {
            return "Login failed: Invalid username or password"; }
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestParam int userId, @RequestParam String accountNumber, @RequestParam String accountType, @RequestParam String currency) {
        return accountService.createAccount(userId, accountNumber, accountType, currency);
    }

    @GetMapping("/accounts/user")
    public List<Account> getUserAccounts(@RequestParam int userId) {
        return accountService.getAccountsByUserId(userId);
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }
}
