package com.tocean.Respository;

import com.tocean.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
public interface UserRespository extends JpaRepository<User,Integer>{

    //select * from .. where username = ?
    User findByUsername(String username);

    //select count(*) from .. where  userable = ?
    Integer countByUserable(Integer userable);

    //select * from .. where username like ?
    List<User> findByUsernameLike(String username);

    //where user0_.username=? or user0_.email=?
    List<User> findByUsernameOrEmail(String username, String email);

    //排序，一定要加by
    List<User> findByOrderByIdDesc();

    //分页查询
    //select * from t_user  order by id desc limit ?,?
    Page<User> findBy(Pageable pageable);

    //通过id查询前面
    //select * where username like ? order by id desc limit 10
    List<User> findFirst10ByUsernameLike(String username, Sort sort);

}
