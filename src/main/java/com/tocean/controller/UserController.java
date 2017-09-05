package com.tocean.controller;

import com.tocean.entity.User;
import com.tocean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello world";
    }


    @GetMapping(value = "/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping(value="/user/{id}")
    public User findById(@PathVariable("id")  Integer id){
        return userService.findById(id);
    }

    @PostMapping(value = "/user")
    public User saveUser(User user) {
        return  userService.save(user);
    }

    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

    @PutMapping(value = "/user")
    public void updateUser(User user){
        userService.updateUser(user);
    }
}
