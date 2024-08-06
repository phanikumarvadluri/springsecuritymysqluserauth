package com.example.springsecurity.config;

import com.example.springsecurity.Repository.UserRepo;
import com.example.springsecurity.model.CustomeUserDetails;
import com.example.springsecurity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomeUserService implements UserDetailsService {


    @Autowired
    UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byName = userRepo.findByName(username);
        Optional<CustomeUserDetails> customeUserDetails = byName.map(CustomeUserDetails::new);
        return customeUserDetails.get();
    }
}
