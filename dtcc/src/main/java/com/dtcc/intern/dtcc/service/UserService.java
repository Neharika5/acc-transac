package com.dtcc.intern.dtcc.service;

import com.dtcc.intern.dtcc.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final List<User> users = new ArrayList<>();
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private long userIdCounter = 1;

    @PostConstruct
    public void init() {
        users.add(new User(userIdCounter++, "amritha", "amritha@example.com", passwordEncoder.encode("pass1"), LocalDateTime.now()));
        users.add(new User(userIdCounter++, "neharika", "neharika@example.com", passwordEncoder.encode("pass2"), LocalDateTime.now()));
        users.add(new User(userIdCounter++, "mahitosh", "mahitosh@example.com", passwordEncoder.encode("pass3"), LocalDateTime.now()));
        users.add(new User(userIdCounter++, "sahithi", "sahithi@example.com", passwordEncoder.encode("pass4"), LocalDateTime.now()));
        users.add(new User(userIdCounter++, "nishanth", "nishanth@example.com", passwordEncoder.encode("pass5"), LocalDateTime.now()));
        users.add(new User(userIdCounter++, "harini", "harini@example.com", passwordEncoder.encode("pass6"), LocalDateTime.now()));
        users.add(new User(userIdCounter++, "user", "user@example.com", passwordEncoder.encode("pass"), LocalDateTime.now()));
    }

    public User registerUser(String username, String email, String rawPassword) {
        String encodedPassword = passwordEncoder.encode(rawPassword);
        User user = new User(userIdCounter++, username, email, encodedPassword, LocalDateTime.now());
        users.add(user);
        return user;
    }

    public Optional<User> loginUser(String username, String rawPassword) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .filter(user -> passwordEncoder.matches(rawPassword, user.getPassword()))
                .findFirst();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}
