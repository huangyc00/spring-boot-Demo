package com.tocean.controller;

import com.tocean.entity.User;
import com.tocean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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


    //根据条件进行查询
    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    public Page<User>  serachUsers(Integer page ,Integer pageSize ,String name){
        Pageable pageable = new PageRequest(page,pageSize);
        Page<User> users = userService.serachUsers(pageable,name);
        return users;
    }

    //直接查询全部内容
    @GetMapping(value = "/users")
    public List<User> findAll(){
        return userService.findAll();
    }

    //根据id查询
    @GetMapping(value="/user/{id}")
    public User findById(@PathVariable("id")  Integer id){
        return userService.findById(id);
    }

    //添加user
    @PostMapping(value = "/user")
    public User saveUser(User user) {
        return  userService.save(user);
    }


    //删除user
    @DeleteMapping(value = "/user/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userService.deleteUser(id);
    }

    //更新user
    @PutMapping(value = "/user")
    public void updateUser(User user){
        userService.updateUser(user);
    }
}
