package com.tocean.service;

import com.tocean.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
public interface UserService {

    public List<User> findAll();

    User findById(Integer id);

    User save(User user);

    void deleteUser(Integer id);

    void updateUser(User user);


}
