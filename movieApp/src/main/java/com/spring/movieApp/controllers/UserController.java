package com.spring.movieApp.controllers;

import com.spring.movieApp.model.Role;
import com.spring.movieApp.model.User;
import com.spring.movieApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @GetMapping(path="/users")
    public @ResponseBody ResponseEntity<List<User>> getUsers(){
        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    @GetMapping(path="/users/{id}")
    public @ResponseBody ResponseEntity<User>getUser(Long id){
        User user = userService.getUser(id);
        if(user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
    @PostMapping(path="/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = new User(user.getUserName(), bCryptPasswordEncoder.encode(user.getPassword()), Role.user);
        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }
}
