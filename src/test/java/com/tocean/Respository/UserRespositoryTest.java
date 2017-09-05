package com.tocean.Respository;

import com.tocean.entity.User;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/9/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRespositoryTest {


    private static final Logger logger = LoggerFactory.getLogger(UserRespositoryTest.class);
    @Autowired
    private UserRespository userRespository;

    @Test
    public void findByUsername() throws Exception {
       User user =  userRespository.findByUsername("admin");
        logger.info("user{}",user);
    }

    @Test
    public void countByUserable() throws Exception {
        Integer count = userRespository.countByUserable(0);
        logger.info("count{}",count);
    }

    @Test
    public void findByUsernameLike() throws Exception {
        List<User> users = userRespository.findByUsernameLike("%user%");
        for(User user: users){
        }
    }

    @Test
    public void findByUsernameOrEmail() throws Exception {
       List<User> users =  userRespository.findByUsernameOrEmail("admin","fasw@163.com");
       logger.info("users{}",users);
    }

    @Test
    public void findByOrderByIdDesc() throws Exception {
       List<User> users =  userRespository.findByOrderByIdDesc();
       logger.info("users{}",users);
    }

    @Test
    public void findBy() throws Exception {
        //分页从第0页开始
        int page=0;
        int size=3;
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<User> pageObj = userRespository.findBy(pageable);
        List<User> users = pageObj.getContent();
        for(User user : users){
            logger.info("user.id:{}",user.getId());
        }
    }

    @Test
    public void findFirst10ByUsernameLike() throws Exception {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        List<User> users = userRespository.findFirst10ByUsernameLike("%user%",sort);
        for(User user : users){

        }
    }
}