package com.tocean.service.impl;

import com.tocean.Respository.UserRespository;
import com.tocean.entity.User;
import com.tocean.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private static  final Logger logger = LoggerFactory.getLogger(UserServiceImplTest.class);
    @Autowired
    private UserService userService;

    @Test
    public void findAll() throws Exception {
        List<User> users = userService.findAll();
        Assert.assertEquals(20,users.size());
    }

    @Test
    public void findById() throws Exception {
        Integer id = 35;
        User user = userService.findById(id);
        Assert.assertEquals(id,user.getId());
}

    @Test
    public void save() throws Exception {
        User user  = new User();
        user.setUsername("huangyc");
        user.setLoginTime(new Date());
        user.setPassword("123456");
        user.setAddtime(new Date());
        user.setUserable(0);
        user.setEmail("112511511@qq.com");
        user.setName("yourname");
        User result = userService.save(user);
        Assert.assertNotNull(result);
    }

    @Test
    public void deleteUser() throws Exception {
        Integer id = 39;
        userService.deleteUser( id);
        User user = userService.findById(id);
        Assert.assertNull(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user  = new User();
        Integer id = 35;
        user.setId(id);
        user.setUsername("huangyyyykkkkyyy");
        user.setLoginTime(new Date());
        user.setPassword("123456");
        user.setAddtime(new Date());
        user.setUserable(0);
        user.setEmail("112511511@qq.com");
        user.setName("yourname");
        User result = userService.save(user);
        Assert.assertEquals(id,user.getId());
    }

}