package com.example.demo.controller;

import com.example.demo.handler.ResponseHandler;
import com.example.demo.model.UserCredentials;
import com.example.demo.util.JWTUtil;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/userlogin")
    public ResponseEntity<Object> userLogin(@RequestBody UserCredentials userCredentials) {
        String username = userCredentials.getUsername();
        String password = userCredentials.getPassword();

        if (username == null || password == null) {
            return ResponseHandler.generateResponse("Username or password cannot be empty", HttpStatus.BAD_REQUEST, null);
        }

        UserCredentials user = UserCredentials.getUserByName(username);

        if (user == null || !user.getPassword().equals(password)) {
            System.out.println("Invalid user credentials");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user credentials");
        } else {
            String token = jwtUtil.generateToken(user);
            List<Map<String, Object>> response = new ArrayList<>();
            Map<String, Object> entry = new HashMap<>();
            entry.put("token", token);
            entry.put("username", user.getUsername());
            response.add(entry);
            System.out.println("User logged in successfully");
            return ResponseHandler.generateResponse("User logged in successfully", HttpStatus.OK, response);
        }
    }
    
}
//package com.example.demo.controller;
//
//import com.example.demo.handler.ResponseHandler;
//import com.example.demo.model.UserCredentials;
//import com.example.demo.util.JWTUtil;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api")
//public class UserController {
//
//    @Autowired
//    private JWTUtil jwtUtil;
//
//    private List<UserCredentials> userList = UserCredentials.initializeUserList();
//
//    @PostMapping("/userlogin")
//    public ResponseEntity<Object> userLogin(@RequestBody UserCredentials userCredentials) {
//        String username = userCredentials.getUsername();
//        String password = userCredentials.getPassword();
//
//        if (username == null || password == null) {
//            return ResponseHandler.generateResponse("Username or password cannot be empty", HttpStatus.BAD_REQUEST, null);
//        }
//
//        UserCredentials user = UserCredentials.getUserByName(username);
//
//        if (user == null || !UserCredentials.validatePassword(password, user.getPassword())) {
//            System.out.println("Invalid user credentials");
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid user credentials");
//        } else {
//            String token = jwtUtil.generateToken(user);
//            List<Map<String, Object>> response = new ArrayList<>();
//            Map<String, Object> entry = new HashMap<>();
//            entry.put("token", token);
//            entry.put("username", user.getUsername());
//            response.add(entry);
//            System.out.println("User logged in successfully");
//            return ResponseHandler.generateResponse("User logged in successfully", HttpStatus.OK, response);
//        }
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<Object> registerUser(@RequestBody UserCredentials userCredentials) {
//        String username = userCredentials.getUsername();
//        String password = userCredentials.getPassword();
//
//        if (username == null || password == null) {
//            return ResponseHandler.generateResponse("Username or password cannot be empty", HttpStatus.BAD_REQUEST, null);
//        }
//
//        UserCredentials existingUser = UserCredentials.getUserByName(username);
//        if (existingUser != null) {
//            return ResponseHandler.generateResponse("Username already exists", HttpStatus.BAD_REQUEST, null);
//        }
//
//        userList.add(new UserCredentials(username, password, userCredentials.getAccountNumber(), userCredentials.getAccessNumber()));
//        return ResponseHandler.generateResponse("User registered successfully", HttpStatus.CREATED, null);
//    }
//}
