package com.example.springsecurity.controller;


import com.example.springsecurity.Repository.UserRepo;
import com.example.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class MessageController {


    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('USER')")
    public String hello() {
        return "Hello";
    }


    @GetMapping("/hi")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String hi() {
        return "hi";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/user")
    public User user(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

}
