package com.spring.movieApp.service;

import com.spring.movieApp.model.User;
import com.spring.movieApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(NullPointerException::new);
        return user;
    }
    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }
    public User saveUser(User user){
        return userRepository.save(user);
    }
}
