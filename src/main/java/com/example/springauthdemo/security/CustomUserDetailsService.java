package com.example.springauthdemo.security;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.springauthdemo.model.User;
import com.example.springauthdemo.repository.UserRepository;

//This class is an implementation of UserDetailsService, 
//as a result it should provide an implementation of the loadUserByUsername 
//method that return an UserDetails implementation object
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        // First we find the user by username or return an error
        User user = userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not found for this username"));

        // then we convert it to an UserDetails implementation class called
        // UserPrincipal
        return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(long id) {
        // First we find the user by id or return an error
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found for this id"));

        // then we convert it to an UserDetails implementation class called
        // UserPrincipal
        return UserPrincipal.create(user);
    }

}
