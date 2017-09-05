package com.tocean.service.impl;

import com.tocean.Respository.UserRespository;
import com.tocean.entity.User;
import com.tocean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRespository userRespository;

    @Override
    public List<User> findAll() {

        return userRespository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRespository.findOne(id);
    }

    @Override
    public User save(User user) {
        return userRespository.save(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userRespository.delete(id);
    }

    @Override
    public void updateUser(User user) {
        userRespository.save(user);
    }

    @Override
    public Page<User> serachUsers(Pageable pageable, String name) {
       Page<User> users =  userRespository.findByName(name,pageable);
        return users;
    }
}
