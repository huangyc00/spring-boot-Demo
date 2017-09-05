package com.tocean.service;

import com.tocean.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
public interface UserService {

    Page<User> serachUsers(Pageable pageable, String name);

    public List<User> findAll();

    User findById(Integer id);

    User save(User user);

    void deleteUser(Integer id);

    void updateUser(User user);


}
